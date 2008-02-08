/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Ext;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ContainerListener;
import com.gwtext.client.widgets.layout.CardLayout;
import com.gwtext.client.widgets.layout.ContainerLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.LayoutData;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Base class for any {@link BoxComponent} that can contain other components. Containers handle the basic behavior of
 * containing items, namely adding, inserting and removing them. The specific layout logic required to visually render
 * contained items is delegated to any one of the different layout classes available. This class is intended to be extended
 * and should generally not need to be created directly via the new keyword.
 */
public class Container extends BoxComponent implements HasWidgets {

	private static JavaScriptObject configPrototype;
    private String activeItemID;
    private ContainerLayout layout;
    private DefaultsHandler defaultsHandler;

    static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.Container();
        @com.gwtext.client.widgets.Container::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "container";
	}

	public Container() {
	}

	public Container(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public Container(Element element) {
		super(element);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Container(config);
    }-*/;

	private static Container instance(JavaScriptObject jsObj) {
		return new Container(jsObj);
	}

    public void setDefaults(DefaultsHandler defaultsHandler) {
        this.defaultsHandler = defaultsHandler;
    }

    /**
     * Add a Component to the Container.
     *
     * @param component the component to add
     * @param layoutData the layout to use when adding the component
     */
	public void add(Component component, LayoutData layoutData) {
        if(defaultsHandler != null) {
            defaultsHandler.apply(component);
        }
        JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
		//JavaScriptObject componentJS = component.getJsObj();
		JavaScriptObjectHelper.apply(layoutData.getJsObj(), componentJS);
        if(layout != null && layout.getSpacing() != null) {
            Panel panel = new Panel();
            panel.setBaseCls("x-plain");
            panel.setBorder(false);
            panel.setBodyStyle(layout.getSpacing());
            panel.add(component);
            add(panel.getConfig());
        } else {
            add(componentJS);
        }        
	}

    /**
     * Add a widget to the Container.
     *
     * @param widget the widget to add
     */
    public void add(final Widget widget) {
		if (widget instanceof Component) {
			add((Component) widget);
		} else {
			String id = DOMUtil.getID(widget);
			if(id == null) {
				id = Ext.generateId();
				DOMUtil.setID(widget, id);
			}
			JavaScriptObject compJS = getComponentJS(id);
			WidgetComponent component = null;
			if (compJS != null) {
				component = new WidgetComponent(compJS);
				component.setVisible(true);
			} else {
                component = new WidgetComponent(widget);
            }
			add(component);
		}
	}

    /**
     * Add a widget to the Container.
     *
     * @param widget the widget to add
	 * @param layoutData the layout to use when adding the component
     */
	public void add(final Widget widget, LayoutData layoutData) {
		if (widget instanceof Component) {
			add((Component) widget, layoutData);
		} else {
			String id = DOMUtil.getID(widget);
			if(id == null) {
				id = Ext.generateId();
				DOMUtil.setID(widget, id);
			}
			JavaScriptObject compJS = getComponentJS(id);
			WidgetComponent component = null;
			if (compJS != null) {
				component = new WidgetComponent(compJS);
				component.setVisible(true);
			} else {
				component = new WidgetComponent(widget);
            }
			add(component, layoutData);
		}
	}
	
	/**
     * Add a Component to the Container.
     *
     * @param component the component to add
     */
    public void add(Component component) {

        if(defaultsHandler != null) {
            defaultsHandler.apply(component);
        }
		JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
		if(layout != null && layout.getSpacing() != null) {
            Panel panel = new Panel();
            panel.setBaseCls("x-plain");
            panel.setBorder(false);
            panel.setBodyStyle(layout.getSpacing());
            panel.add(component);
            componentJS = panel.getConfig();
            if(layout instanceof HorizontalLayout) {
                HorizontalLayout l = (HorizontalLayout) layout;
                l.setColumns(l.getColumns() + 1);
            }
        }
        if (isCreated()) {
			addPostCreate(componentJS);

		} else {
			addPreCreate(componentJS);
		}
	}

	private void add(JavaScriptObject componentJS) {
		if (isCreated()) {
			addPostCreate(componentJS);
		} else {
			addPreCreate(componentJS);
		}
	}

	private native void addPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.gwtext.client.widgets.Component::config;

        if(!config.items) {
            config.items = new $wnd.Array();
        }
        config.items.push(componentJS);
    }-*/;

	private native void addPostCreate(JavaScriptObject componentJS) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.add(componentJS);
    }-*/;

    /**
     * Find a component under this container at any level by id.
     *
     * @param id the component ID
     * @return the component
     */
    public native Component findByID(String id) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var comp = container.findById(id);
		return comp == null | comp === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
	}-*/;

    /**
     * Find a component under this container at any level by xtype.
     *
     * @param xtype the components xtype
     * @return an array of components
     */
    public native Component[] findByType(String xtype) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var comps = container.findByType(xtype);
		return comps == null || comps === undefined ? null : @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(comps);
	}-*/;

    /**
     * Find a component under this container at any level by a custom function. If the passed function returns true,
     * the component will be included in the results.
     *
     * @param cb the find function
     * @return an array of Components
     */
    public native Component[] findBy(ComponentTraversalCallback cb)/*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var containerJ = this;
        var comps = container.findBy(function(comp) {
            var compJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
            return cb.@com.gwtext.client.widgets.ComponentTraversalCallback::execute(Lcom/gwtext/client/widgets/Component;)(compJ);
        });
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(comps);
    }-*/;

    /**
     * Gets a direct child Component by id.
     *
     * @param id the component ID
     * @return the component
     */
    public native Component getComponent(String id) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var comp = container.getComponent(id);
		return comp == null | comp === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
	}-*/;

    /**
     * Gets a direct child Component by by index.
     *
     * @param index the component index
     * @return the component
     */
    public native Component getComponent(int index) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var comp = container.getComponent(index);
		return comp == null | comp === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
	}-*/;

    /**
     * Bubbles up the component/container heirarchy, calling the specified function with each component.
     * If the function returns false at any point, the bubble is stopped.
     *
     * @param cb the traversal callback
     */
    public native void bubble(ComponentTraversalCallback cb)/*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var containerJ = this;
        container.bubble(function(comp) {
            var compJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
            return cb.@com.gwtext.client.widgets.ComponentTraversalCallback::execute(Lcom/gwtext/client/widgets/Component;)(compJ);
        });
    }-*/;

    /**
     * Cascades down the component/container heirarchy from this component (called first), calling the specified function with each component.
     * If the function returns false at any point, the cascade is stopped on that branch.
     *
     * @param cb the traversal callback
     */
    public native void cascade(ComponentTraversalCallback cb)/*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var containerJ = this;
        container.cascade(function(comp) {
            var compJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(comp);
            return cb.@com.gwtext.client.widgets.ComponentTraversalCallback::execute(Lcom/gwtext/client/widgets/Component;)(compJ);
        });
    }-*/;

    /**
     * Inserts a Component into this Container at a specified index. Fires the beforeadd event before inserting, then fires
     * the add event after the Component has been inserted.
     * 
     * @param index the index to insert the component at
     * @param component the component to insert
     */
    public void insert(int index, Component component) {
		JavaScriptObject componentJS = component.isCreated() ? component.getOrCreateJsObj() : component.getConfig();
		doInsert(index, componentJS);
    }

    private native void doInsert(int index, JavaScriptObject component) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.insert(index, component);
	}-*/;

    /**
     * Removes a component from this container. Fires the beforeremove event before removing, then fires the remove event after the component has been removed.
     *
     * @param id the id of the Component to remove
     */
    public native void remove(String id) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.remove(id);
	}-*/;

    public boolean remove(Widget w) {
        String id = DOMUtil.getID(w);
        if(getComponent(id) != null) {
            remove(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove all child elements destroying them. 
     */
    public void clear() {
        removeAll(true);
    }

    /**
     * The collection of components in this container. Alias for {@link #getComponents()}
     *
     * @return child components
     */
    public Component[] getItems() {
        return getComponents();
    }

    /**
     * The collection of components in this container.
     *
     * @return child components
     */
    public native Component[] getComponents()/*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var items = container.items;
        if(items === undefined || items == null) {
            items = null;
        } else {
            items = container.items.items;
        }
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaComponentArray(Lcom/google/gwt/core/client/JavaScriptObject;)(items);
    }-*/;

    public Iterator iterator() {
        ArrayList list = new ArrayList();
        Component[] items = getComponents();
        for (int i = 0; i < items.length; i++) {
            Component item = items[i];
            list.add(item);
        }
        return list.iterator();
    }

    /**
     * Removes a component from this container. Fires the beforeremove event before removing, then fires the remove event after the component has been removed.
     *
     * @param component the id of the Component to remove
     * @param autoDestroy true to automatically invoke the Component's destroy method
     */
    public native void remove(Component component, boolean autoDestroy) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var componentJS = component.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.remove(componentJS, autoDestroy);
	}-*/;

    /**
     * Removes a component from this container. Fires the beforeremove event before removing, then fires the remove event after the component has been removed.
     *
     * @param id the id of the Component to remove
     * @param autoDestroy true to automatically invoke the Component's destroy method
     */
    public native void remove(String id, boolean autoDestroy) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.remove(id, autoDestroy);
	}-*/;

    /**
     * Removes all child components without destroying them.
     */
    public native void removeAll() /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        if(container.items){
            var cs = container.items.items;

            for(var i = 0, len = cs.length; i < len; i++) {
                cs[i].hide();
                container.remove(cs[i], false);
            }
        }
    }-*/;

	/**
	 * Removes all components from this container. Fires the beforeremove event before removing, then fires the remove event
	 * after the component has been removed.
	 *
	 * @param autoDestroy true to automatically invoke the component's destroy
	 */
	public native void removeAll(boolean autoDestroy) /*-{
        var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        if(container.items){
            var cs = container.items.items;
            for(var i = 0, len = cs.length; i < len; i++) {
                container.remove(cs[i], autoDestroy);
            }
        }
    }-*/;

	/**
	 * Force this container's layout to be recalculated. A call to this function is required after adding a new component
	 * to an already rendered container. If you are not dynamically adding and removing components after render, this function will generally not need to be called.
	 */
	public native void doLayout() /*-{
		var container = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        container.doLayout();
    }-*/;

	/**
	 * Add a Container listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(ContainerListener listener) /*-{
        this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
        var containerJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('add',
                function(source, component, index) {
                    var componentJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
                    listener.@com.gwtext.client.widgets.event.ContainerListener::onAdd(Lcom/gwtext/client/widgets/Container;Lcom/gwtext/client/widgets/Component;I)(containerJ, componentJ, index);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeadd',
                function(source, component, index) {
                    var componentJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
                    return listener.@com.gwtext.client.widgets.event.ContainerListener::doBeforeAdd(Lcom/gwtext/client/widgets/Container;Lcom/gwtext/client/widgets/Component;I)(containerJ, componentJ, index);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('afterlayout',
                function(source, layout) {
                    listener.@com.gwtext.client.widgets.event.ContainerListener::onAfterLayout(Lcom/gwtext/client/widgets/Container;)(containerJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('remove',
                function(source, component) {
                    var componentJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
                    listener.@com.gwtext.client.widgets.event.ContainerListener::onRemove(Lcom/gwtext/client/widgets/Container;Lcom/gwtext/client/widgets/Component;)(containerJ, componentJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeremove',
                function(source, component) {
                    var componentJ = @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(component);
                    return listener.@com.gwtext.client.widgets.event.ContainerListener::doBeforeRemove(Lcom/gwtext/client/widgets/Container;Lcom/gwtext/client/widgets/Component;)(containerJ, componentJ);
                }
        );
    }-*/;

	// --- config properties ---

	/**
	 * A string component id or the numeric index of the component that should be initially activated within the
	 * container's layout on render. For example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item in
	 * the container's collection). activeItem only applies to layout styles that can display items one at a time
	 * (like {@link com.gwtext.client.widgets.layout.AccordionLayout} , {@link com.gwtext.client.widgets.layout.CardLayout}
	 * and {@link com.gwtext.client.widgets.layout.FitLayout} ).
	 *
	 * @param activeItem the active Item ID
	 */
	public void setActiveItemID(String activeItem) {
        //need local variable as bean introspectors will error out when underlting activeItem attribute can
        //either be string or  int
        activeItemID = activeItem;
        if(isRendered() && layout instanceof CardLayout) {
            ((CardLayout)layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem, true);
        }
    }

    /**
     * @return the active Item ID
     */
    public String getActiveItemID() {
        return activeItemID;
    }

    /**
	 * A string component id or the numeric index of the component that should be initially activated within the
	 * container's layout on render. For example, activeItem: 'item-1' or activeItem: 0 (index 0 = the first item in
	 * the container's collection). activeItem only applies to layout styles that can display items one at a time
	 * (like {@link com.gwtext.client.widgets.layout.AccordionLayout} , {@link com.gwtext.client.widgets.layout.CardLayout}
	 * and {@link com.gwtext.client.widgets.layout.FitLayout} ).
     *
	 *
	 * @param activeItem the active Item ID
	 */
	public void setActiveItem(int activeItem) {
        if(isRendered() && layout instanceof CardLayout) {
            ((CardLayout)layout).setActiveItem(activeItem);
        } else {
            setAttribute("activeItem", activeItem, true);
        }
	}

    /**
     * Return the Active Item index.
     *
     * @return the active item index
     */
    public int getActiveItem() {        
        return JavaScriptObjectHelper.getAttributeAsInt(config, "activeItem");
    }

    /**
	 * If true the container will automatically destroy any contained component that is removed from it, else destruction
	 * must be handled manually (defaults to true).
	 *
	 * @param autoDestroy true to autodestroy
	 */
	public void setAutoDestroy(boolean autoDestroy) {
		setAttribute("autoDestroy", autoDestroy, true);
	}

    /**
     * @return true if Component is configured to auto destroy contained components on destruction
     */
    public boolean getAutoDestroy() {
        return getAttributeAsBoolean("autoDestroy");
    }

    /**
	 * When set to true (100 milliseconds), the layout assigned for this container will buffer
	 * the frequency it calculates and does a re-layout of components. This is useful for heavy containers or containers
	 * with a large amount of sub components that frequent calls to layout are expensive.
	 *
	 * @param bufferResize true to buffer resize
	 */
	public void setBufferResize(boolean bufferResize) {
		setAttribute("bufferResize", bufferResize, true);
	}

    /**
     * @return true if buffer resize is enabled
     */
    public boolean getBufferResize() {
        return getAttributeAsBoolean("bufferResize");
    }

    /**
	 * True to hide the borders of each contained component, false to defer to the component's existing border settings (defaults to false).
	 *
	 * @param hideBorders true to hide borders
	 */
	public void setHideBorders(boolean hideBorders) {
		setAttribute("hideBorders", hideBorders, true);
	}

    /**
     * True to hide the borders of each contained component, false to defer to the component's existing border settings (defaults to false).
     *
     * @return true if hide borders
     */
    public boolean getHideBorders() {
		return getAttributeAsBoolean("hideBorders");
	}

	/**
	 * The layout type to be used in this container. If not specified, a default ContainerLayout will be created and used.
	 *
	 * @param layout the layout to use
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLayout(ContainerLayout layout) throws IllegalStateException {
        this.layout = layout;
        if(layout.getSpacing() != null && this instanceof Panel) {
            ((Panel)this).setBorder(false);
        }
        setAttribute("layout", layout.getJsObj(), true);
		if (layout.getContainerAttributes() != null) {
			JavaScriptObjectHelper.apply(layout.getContainerAttributes(), isCreated()  ? config : getJsObj());
		}
	}

    public ContainerLayout getLayout() {
        return layout;
    }

    /**
	 * True to automatically monitor window resize events to handle anything that is sensitive to the current size of the
	 * viewport. This value is typically managed by the chosen layout and should not need to be set manually.
	 *
	 * @param monitorResize true to monitor resize
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setMonitorResize(boolean monitorResize) throws IllegalStateException {
		setAttribute("monitorResize", monitorResize, true);
	}

    /**
     * @return true if monitor resize
     */
    public boolean getMonitorResize() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(config, "monitorResize");
	}
}
