/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ComponentListener;

import java.util.*;

/**
 * <p>Base class for all Ext components.  All subclasses of Component can automatically participate in the standard
 * Ext component lifecycle of creation, rendering and destruction.  They also have automatic support for basic hide/show
 * and enable/disable behavior.   All visual widgets that require rendering into a layout should subclass Component (or
 * BoxComponent if managed box model handling is required).</p>
 * <p>Every component has a specific xtype.  This is the list of all valid xtypes:</p>
 * <pre>
 * <p/>
 * xtype            Class
 * -------------    ------------------
 * box              BoxComponent
 * button           Button
 * colorpalette     ColorPalette
 * component        Component
 * container        Container
 * cycle            CycleButton
 * dataview         DataView
 * datepicker       DatePicker
 * editor           Editor
 * editorgrid       EditorGridPanel
 * grid             GridPanel
 * paging           PagingToolbar
 * panel            Panel
 * progress         ProgressBar
 * splitbutton      SplitButton
 * tabpanel         TabPanel
 * treepanel        TreePanel
 * viewport         ViewPort
 * window           Window
 * <p/>
 * Toolbar components
 * ---------------------------------------
 * toolbar          Toolbar
 * <p/>
 * Form components
 * ---------------------------------------
 * checkbox         Checkbox
 * combo            ComboBox
 * datefield        DateField
 * field            Field
 * fieldset         FieldSet
 * form             FormPanel
 * hidden           Hidden
 * htmleditor       HtmlEditor
 * numberfield      NumberField
 * radio            Radio
 * textarea         TextArea
 * textfield        TextField
 * timefield        TimeField</pre>
 */
public abstract class Component extends Widget implements Observable {

	private static JavaScriptObject configPrototype;
    private Map configListeners = new HashMap();

    protected String id;

	protected JavaScriptObject config;
    private boolean initHidden = false;
    private boolean initDisabled = false;

    static {
		init();
	}

	protected native JavaScriptObject cloneConfig(JavaScriptObject config)/*-{
        var clone = {};
        var id = $wnd.Ext.id();
        var cfg = $wnd.Ext.applyIf(clone, config);
        cfg.id = id; // prevent dup id
        return clone;
    }-*/;

	private static native void init()/*-{
        var c = new $wnd.Ext.Component();
        @com.gwtext.client.widgets.Component::configPrototype = c.initialConfig;
        
        $wnd.Ext.Component.prototype.initComponent=function() {
            var compJ = this.__compJ;
            if(compJ != null) {
                compJ.@com.gwtext.client.widgets.Component::doInitComponent()();
            }
        };
    }-*/;


    /**
     * Create a new Component.
     */
    public Component() {
		id = Ext.generateId();
		initConfig();
		if (config == null) {
			config = JavaScriptObjectHelper.createObject();
        }
        JavaScriptObjectHelper.setAttribute(config, "__compJ", this);
        JavaScriptObjectHelper.setAttribute(config, "id", id);
		JavaScriptObjectHelper.setAttribute(config, "xtype", getXType());
		makeObservable(config);
	}

    /**
     * Component Constructor. Applies the Component to an existing element.
     *
     * @param element the Element to apply the Component to
     */
    public Component(Element element) {
		id = DOMUtil.getID(element);
		if(id == null) {
			id = Ext.generateId();
			DOMUtil.setID(element, id);
		}
		config = JavaScriptObjectHelper.createObject();
		setId(id);
		setApplyTo(element);
		getOrCreateJsObj();
	}

    public Component(JavaScriptObject jsObj) {
		id = JavaScriptObjectHelper.getAttribute(jsObj, "id");
		config = jsObj;
		setElement(getElement(jsObj));
	}

    /**
     * Creates a Component object reference for an already rendered Component.
     *
     * @param id the Component ID
     */
    public Component(String id) {
		setElement(getElement(getComponentJS(id)));
	}

    private void doInitComponent() {
        doClear();
        for (Iterator iterator = configListeners.keySet().iterator(); iterator.hasNext();) {
            String event = (String) iterator.next();
            List listeners= (List) configListeners.get(event);
            for (int i = 0; i < listeners.size(); i++) {
                JavaScriptObject listener = (JavaScriptObject) listeners.get(i);
                addListener(event, listener);
            }
        }
        configListeners.clear();
        configListeners = null;
        initComponent();
        addListener("render", new Function() {
            public void execute() {
                Component.this.afterRender();
            }
        });

        addListener("beforedestroy", new Function() {
            public void execute() {

                if(isRendered()) {
                    doBeforeDestroy(Component.this.getJsObj());
                }
                beforeDestroy();
			}

			private native void doBeforeDestroy(JavaScriptObject jsObj) /*-{

            }-*/;
        });
		
		addListener("destroy", new Function() {
            public void execute() {
                onDestroy();
				JavaScriptObjectHelper.setAttribute(Component.this.getConfig(), "__compJ", (String)null);
				//add clearing of reference in DeferredCommand because in the case of TabPanel.remove, the remove event
				//is called after the component has been destroyed, and we want to make sure that the onremove event is passed
				//the real user object
				DeferredCommand.addCommand(new Command() {
					public void execute() {
						doOnDestroy(Component.this.getJsObj());
					}
				});
			}

			private native void doOnDestroy(JavaScriptObject jsObj) /*-{
                if(jsObj != null && jsObj.__compJ) {
                    jsObj.__compJ = null;
                }
            }-*/;
		});
    }

    /**
     * This template method is called after the Component has been instantiated but before it's rendered. Subclasses
     * can override it to provide any "constructor" type logic thats desired/
     */
    protected void initComponent() {
    }

    /**
     * Template method that is called after the Component has been renedered.
     */
    protected void afterRender() {
    }

    /**
     * This template method is called before the component is destroy. Subclasses can add any cleanup logic on destoy here.
     */
    protected void beforeDestroy() {
    }


    /**
     * This template method is called on component destroy. Subclasses can add any cleanup logic on destoy here.
     */
    protected void onDestroy() {
    }

    private native void doClear() /*-{
        var config = this.@com.gwtext.client.widgets.Component::config;
        config['__compJ'] = null;
    }-*/;

    private native void makeObservable(JavaScriptObject config) /*-{
        if(config.listeners == null || config.listeners === undefined) {
            //config.listeners = new $wnd.Array();
            config.listeners = new Object();
        }
    }-*/;

	public JavaScriptObject getJsObj() {
		JavaScriptObject jsObj = getComponentJS(id);
		return jsObj;
	}

	//create only, dont render
	public JavaScriptObject getOrCreateJsObj() {
		JavaScriptObject jsObj = getComponentJS(id);
		if(jsObj != null) {
			return jsObj;
		} else {
			//create object here
			return create(config);
		}
	}

	protected static native JavaScriptObject getComponentJS(String id)/*-{
        var cmp = $wnd.Ext.ComponentMgr.get(id);
		return (cmp === undefined || cmp == null) ? null : cmp;
	}-*/;

	protected void addListener(String event, JavaScriptObject fn) {
		if (!isCreated()) {
			addConfigListener(event, fn);
		} else {
			addWidgetListener(event, fn);
		}
	}
	private native void addWidgetListener(String event, JavaScriptObject fn) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.addListener(event, fn);
    }-*/;

	private void addConfigListener(String event, JavaScriptObject fn){
        List listeners = (List)configListeners.get(event);
        if(listeners == null) listeners = new ArrayList();
        listeners.add(fn);
        configListeners.put(event, listeners);
    }

	public JavaScriptObject getConfig() {
		return config;
	}

	protected abstract JavaScriptObject getConfigPrototype();

	private void initConfig() {
		config = cloneConfig(getConfigPrototype());
		JavaScriptObjectHelper.setAttribute(config, "xtype", getXType());
	}

	protected native Element getElement(JavaScriptObject jsObj) /*-{
        //var el = jsObj.el;
        var extEl = jsObj.getEl();
        if(extEl == null || extEl === undefined) {
            return null;
        }
        var el = extEl.dom;
        if(el == null || el === undefined) {
            return null;
            //forms buttons are detached when initially added
            //throw new Error('Widget ' + jsObj + ' has no element property set');
        } else {
            //There's an inconsistency in Ext where most elements have the property 'el' set to Ext's Element
            //with the exception of Menu->Item, Menu->Separator, Menu->TextItem,  Toolbar.Item and subclasses
            //(Toolbar.Separator, Toolbar.Spacer, Toolbar.TextItem) where the 'el' property is set to
            //the DOM element itself. Therefore retruning 'el' if 'el' is not Ext's Element. See details in issue 39.
             return el.dom || el ;
        }
    }-*/;

	protected abstract JavaScriptObject create(JavaScriptObject config);

	public Element getElement() {
		if (super.getElement() == null) {
			JavaScriptObject jsObj = getComponentJS(id);
			if (!isRendered()) {
				if (jsObj == null) {
					jsObj = create(config);
				}
				if (getParent() != null && getParent().getElement() != null) {
					render(getParent().getElement());
				} else {
					render(RootPanel.getBodyElement());
				}
			}
			setElement(getElement(jsObj));
		}
		return super.getElement();
	}

    public void addEvents(String[] events) {
        for (int i = 0; i < events.length; i++) {
            String event = events[i];
            addEvent(event);
        }
    }

    public native void addEvent(String events) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.addEvents(events);
    }-*/;

	/**
	 * Removes all listeners for this Component.
	 */
	public native void purgeListeners() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.purgeListeners();
    }-*/;	

	/**
	 * Resume firing events.
	 *
	 * @see #suspendEvents() 
	 */
	public native void resumeEvents() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.resumeEvents();
    }-*/;

	/**
	 * Suspend the firing of all events.
	 *
	 * @see #resumeEvents() 
	 */
	public native void suspendEvents() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.suspendEvents();
    }-*/;
	
	/**
	 * True if this component is disabled.
	 *
	 * @return true if disabled
	 */
	public boolean isDisabled() {
        if(!isRendered()) {
            return initDisabled;
        } else {
            return isDisabledRendered();
        }
    }

    private native boolean isDisabledRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component == null? false : component.disabled;
    }-*/;

	/**
	 * @return true if the component is hidden
	 */
	public boolean isHidden()  {
        if(!isRendered()) {
            return initHidden;
        } else {
            return isHiddenRendered();
        }
    }

    private native boolean isHiddenRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component == null? false : component.hidden;
    }-*/;

	/**
	 * The component's owner Ext.Container (defaults to undefined, and is set automatically when the
	 * component is added to a container).
	 * <br>
     * <b>Note:</b> This method should be called only after the component has been rendered.
     *
	 * @return the owner container
	 */
	public native Container getOwnerContainer() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		if (component == null) return null;
		var ct = component.ownerCt;
        return ct == null || ct === undefined ? null : @com.gwtext.client.widgets.Container::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ct);
    }-*/;

    /**
     * @return true if the underlying widget object has been created
     */
	public boolean isCreated() {
		//JavaScriptObject jsObj = getComponentJS(id);
		return doIsCreated(id);
	}

    private static native boolean doIsCreated(String id)/*-{
        var cmp = $wnd.Ext.ComponentMgr.get(id);
		return cmp == null || cmp === undefined? false : true;
	}-*/;

    /**
	 * @return true if component has been rendered
	 */
	public native boolean isRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
        return component != null && component.rendered;
    }-*/;

    /**
	 * Adds a CSS class to the component's underlying element.
	 *
	 * @param cls the CSS class
	 */
	public void addClass(String cls) {
        if(!isCreated()) {
            setCls(getCls() == null ? cls : getCls() + " " + cls);
        } else {
            addClassCreated(cls);
        }
    }

    public native void addClassCreated(String cls) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.addClass(cls);
    }-*/;

	/**
	 * Clone the current component using the original config values passed into this instance by default.
	 *
	 * @return the cloned copy of this component
	 */
	public Component cloneComponent() {
		JavaScriptObject clone = doClone(null);
		return ComponentFactory.getComponent(clone);
	}

    /**
     * Clone the current component using the original config values passed into this instance by default.
     *
     * @param overrides when cloning
     * @return the cloned copy of this component
     */
    public Component cloneComponent(Component overrides) {
        JavaScriptObject clone = doClone(overrides.getConfig());
        return ComponentFactory.getComponent(clone);
    }

    private native JavaScriptObject doClone(JavaScriptObject config) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component.cloneConfig(config);
    }-*/;

	/**
	 * Destroys this component by purging any event listeners, removing the component's element from the DOM, removing
	 * the component from its {@link Container} (if applicable) and unregistering it from {@link ComponentMgr}. Destruction
	 * is generally handled automatically by the framework and this method should usually not need to be called directly.
	 */
	public native void destroy() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
		if(component != null) component.destroy();
    }-*/;

	/**
	 * Disable this component.
	 */
	public void disable() {
        if(!isRendered()) {
            initDisabled = true;
            addListener("render", new Function() {
                public void execute() {
                    disableRendered();
                }
            });
        } else {
            disableRendered();
        }
    }

    private  native void disableRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.disable();
    }-*/;

	/**
	 * Enable this component.
	 */
	public void enable() {
        if(!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
                    enableRendered();
                }
            });
        } else {
            enableRendered();
        }
    }

    private native void enableRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.enable();
    }-*/;

	/**
	 * Try to focus this component.
	 */
    public void focus() {
        if(!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
					DeferredCommand.addCommand(new Command() {
						public void execute() {
							focusRendered();
						}
					});					
                }
            });
        } else {
			focusRendered();
		}
    }

    private native void focusRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(component != null) component.focus();
    }-*/;

	/**
	 * Try to focus this component.
	 *
	 * @param selectText True to also select the text in this component (if applicable)
	 */
	public native void focus(boolean selectText) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(component != null) component.focus(selectText);
    }-*/;

	/**
	 * Try to focus this component.
	 *
	 * @param selectText True to also select the text in this component (if applicable)
	 * @param delay	  delay the focus this number of milliseconds (true for 10 milliseconds)
	 */
	public native void focus(boolean selectText, int delay) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(component != null) component.focus(selectText);
	}-*/;

	public native ExtElement getEl() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var el = component.getEl();
        if(el == null || el === undefined) {
            return null;
        } else {
            return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
        }
    }-*/;


	/**
	 * Returns the item id of this component.
	 *
	 * @return the item ID
	 */
	public native String getItemId() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component.getItemId();
    }-*/;

	/**
	 * Gets the xtype for this component as registered with ComponentMgr. For a list of all available xtypes,
	 * see the Component javadocs.
	 * <p/>
	 * <pre>
	 * <code>
	 * <p/>
	 * TextField field = new TextField();
	 * field.getXType() returns "textfield"
	 * </code>
	 * </pre>
	 *
	 * @return the xtype
	 */
	public  String getXType() {
		return "";
	}

	/**
	 * Returns this component's xtype hierarchy as a slash-delimited string. For a list of all available xtypes, see the
	 * Component class javadocs.
	 * <p/>
	 * <pre>
	 * <code>
	 * <p/>
	 * TextField field = new TextField();
	 * field.getXTypes() returns "component/box/field/textfield"
	 * </code>
	 * </pre>
	 *
	 * @return the xtype hierarchy string
	 */
	public native String getXTypes() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component.getXTypes();
    }-*/;

	/**
	 * Hide this component.
	 */
	public void hide() {
        if(!isRendered()) {
            initHidden = true;
            addListener("render", new Function() {
                public void execute() {
                    hideRendered();
                }
            });
        } else {
            hideRendered();
        }
    }

    private native void hideRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.hide();
    }-*/;

	/**
	 * Returns true if this component is visible.
	 *
	 * @return true if visible
	 */
	public native boolean isVisible() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getJsObj()();
        return component == null ? false : component.isVisible();
    }-*/;


	/**
	 * Tests whether or not this component is of a specific xtype. This can test whether this component is descended from
	 * the xtype (default) or whether it is directly of the xtype specified (shallow = true). For a list of all available xtypes,
	 * see the {@link Component} header. Example usage:
	 * <p/>
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * TextField t = new TextField();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 *
	 * @param xtype the xtype to check for this component
	 * @return true if is style
	 */
	public native boolean isXType(String xtype) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component.isXType(xtype);
    }-*/;

	/**
	 * Tests whether or not this component is of a specific xtype. This can test whether this component is descended from
	 * the xtype (default) or whether it is directly of the xtype specified (shallow = true). For a list of all available xtypes,
	 * see the {@link Component} header. Example usage:
	 * <p/>
	 * <pre>
	 * <code>
	 * <p/>
	 * <p/>
	 * TextField t = new TextField();
	 * boolean isText = t.isXType('textfield');        // true
	 * boolean isBoxSubclass = t.isXType('box');       // true, descended from BoxComponent
	 * boolean  isBoxInstance = t.isXType('box', true); // false, not a direct BoxComponent instance
	 * <p/>
	 * </code>
	 * </pre>
	 *
	 * @param xtype   the xtype to check for this component
	 * @param shallow false to check whether this component is descended from the xtype (this is the default), or true to check whether this component is directly of the specified xtype.
	 * @return true if is style
	 */
	public native boolean isXType(String xtype, boolean shallow) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return component.isXType(xtype, shallow);
    }-*/;

	/**
	 * Removes a CSS class from the component's underlying element.
	 *
	 * @param cls the CSS class to remove
	 */
	public native void removeClass(String cls) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.removeClass(cls);
    }-*/;

	/**
	 * Convenience function for setting disabled/enabled by boolean.
	 *
	 * @param disabled true to disable
	 */
	public void setDisabled(boolean disabled)  {
        if(disabled) {
            disable();
        } else {
            enable();
        }
    }

	/**
	 * Convenience function to hide or show this component by boolean.
	 *
	 * @param visible True to show, false to hide
	 */
	public void setVisible(boolean visible) {
        if(visible) {
            show();
        } else {
            hide();
        }
    }

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param id the element id
	 */
	public native void render(String id) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(id);
    }-*/;

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param id	   the element id
	 * @param position the element ID within the container <b>before</b> which this
	 *                 component will be inserted (defaults to appending to the end of the container)
	 */
	public native void render(String id, String position) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(id, position);
    }-*/;

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param id	   the element id
	 * @param position the DOM node index within the container <b>before</b> which this
	 *                 component will be inserted (defaults to appending to the end of the container)
	 */
	public native void render(String id, int position) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(id, position);
    }-*/;

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param element the element
	 */
	public native void render(Element element) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(element);
    }-*/;

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param element  the element
	 * @param position the element ID within the container <b>before</b> which this
	 *                 component will be inserted (defaults to appending to the end of the container)
	 */
	public native void render(Element element, String position) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(element);
    }-*/;

	/**
	 * If this is a lazy rendering component, render it to its container element.
	 *
	 * @param element  the element
	 * @param position the DOM node index within the container <b>before</b> which this
	 *                 component will be inserted (defaults to appending to the end of the container)
	 */
	public native void render(Element element, int position) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.render(element);
    }-*/;

	/**
	 * Show this component.
	 */
	public void show() {
        if(!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
                    showRendered();
                }
            });
        } else {
            showRendered();
        }
    }
    
    private native void showRendered() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.show();
    }-*/;

    /**
     * Add a raw event listener.
     *
     * @param event the event name
     * @param funtion the fintion to execute
     */
    public native void addListener(String event, Function funtion)/*-{
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(event,
                function() {
                    return funtion.@com.gwtext.client.core.Function::execute()();
                }
        );
    }-*/;

    /**
	 * Add a component listner.
	 *
	 * @param listener the listener
	 */
	protected native void addListener(ComponentListener listener) /*-{
        var componentJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforedestroy',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeDestroy(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforehide',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeHide(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforerender',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeRender(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeshow',
                function(source) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeShow(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforestaterestore',
                function(source, state) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeStateRestore(Lcom/gwtext/client/widgets/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(componentJ, state);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforestatesave',
                function(source, state) {
                    return listener.@com.gwtext.client.widgets.event.ComponentListener::doBeforeStateSave(Lcom/gwtext/client/widgets/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(componentJ, state);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('destroy',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onDestroy(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('disable',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onDisable(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('enable',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onEnable(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('hide',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onHide(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('render',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onRender(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('show',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onShow(Lcom/gwtext/client/widgets/Component;)(componentJ);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('staterestore',
                function(source, state) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onStateRestore(Lcom/gwtext/client/widgets/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(componentJ, state);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('statesave',
                function(source, state) {
                    listener.@com.gwtext.client.widgets.event.ComponentListener::onStateSave(Lcom/gwtext/client/widgets/Component;Lcom/google/gwt/core/client/JavaScriptObject;)(componentJ, state);
                }
        );
    }-*/;

	protected void check() throws IllegalStateException {
		if (isRendered()) {
            if(GWT.isScript()) {
                MessageBox.alert("Error", "Cannot change configuration property after the component has been rendered");
                throw new IllegalStateException("Cannot change configuration property after the component has been rendered");
            }
		}
	}


	// --------------------- config properties --------------------------

	//public abstract String getXType();


	/**
	 * The id of the node, a DOM node or an existing Element corresponding to a DIV that is
	 * already present in the document that specifies some structural markup for this component.
	 * When applyTo is used, constituent parts of the component can also be specified by id or CSS class name within the
	 * main element, and the component being created may attempt to create its subcomponents from that markup if applicable.
	 * Using this config, a call to render() is not required. If applyTo is specified, any value passed for renderTo will be
	 * ignored and the target element's parent node will automatically be used as the component's container.
	 *
	 * @param element the ID of existing DIV
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setApplyTo(Element element) throws IllegalStateException {
		setAttribute("applyTo", element, false);
	}

    /**
     * @return the Element this component was applied to
     */
    public Element getApplyTo() {
		return JavaScriptObjectHelper.getAttributeAsElement(config, "applyTo");
	}

    public void setAutoEl(String autoEl) {
        setAttribute("autoEl", autoEl, true);
    }

    
    /**
	 * True if the component should check for hidden classes (e.g. 'x-hidden' or 'x-hide-display') and remove them on render (defaults to false).
	 *
	 * @param autoShow true to autoShow
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAutoShow(boolean autoShow) throws IllegalStateException {
		setAttribute("autoShow", autoShow, true);
	}

    /**
     * @return true if auto show
     */
    public boolean getAutoShow() {
		return getAttributeAsBoolean("autoShow");
	}

	/**
	 * An optional extra CSS class that will be added to this component's Element (defaults to ''). This can be useful
	 * for adding customized styles to the component or any of its children using standard CSS rules.
	 *
	 * @param cls the CSS class
	 */
	public void setCls(String cls) {
        if(isCreated()) {
           addClass(cls);
        } else {
			setAttribute("cls", cls, false);
		}
    }

    /**
     * @return the extra CSS applied to the components Element
     */
    public String getCls() {
		return getAttribute("cls");
	}

	/**
	 * An optional extra CSS class that will be added to this component's container (defaults to ''). This can be useful
	 * for adding customized styles to the container or any of its children using standard CSS rules.
	 *
	 * @param ctCls the container CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setCtCls(String ctCls) throws IllegalStateException {
		setAttribute("ctCls", ctCls, true);
	}

    /**
     * @return the extra CSS class applied to the components container.
     */
    public String getCtCls() {
		return getAttribute("ctCls");
	}

	/**
	 * CSS class added to the component when it is disabled (defaults to "x-item-disabled").
	 *
	 * @param disabledClass the disabled CSS class
	 */
	public void setDisabledClass(String disabledClass)  {
        setAttribute("disabledClass", disabledClass, true);
    }

    /**
     * @return the CSS class used when the component is disabled
     */
    public String getDisabledClass() {
        return getAttribute("disabledClass");
    }

	/**
	 * Sets the underlying Element for the component.
	 *
	 * @param el the element
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEl(Element el) throws IllegalStateException {
		setAttribute("el", new ExtElement(el).getJsObj(), false);
	}

	public void setEl(String elementID) throws IllegalStateException {
		setAttribute("el", elementID, false);
	}

    /**
	 * How this component should hidden. Supported values are "visibility" (css visibility), "offsets" (negative offset
	 * position) and "display" (css display) - defaults to "display".
	 *
	 * @param hideMode the hide mode
	 */
	public void setHideMode(String hideMode) {
		setAttribute("hideMode", hideMode, true);
	}

    /**
     * How this component should hidden. Supported values are "visibility" (css visibility), "offsets" (negative offset
	 * position) and "display" (css display) - defaults to "display".
     *
     * @return the hide mode
     */
    public String getHideMode() {
		return getAttribute("hideMode");
	}

	/**
	 * True to hide and show the component's container when hide/show is called on the component, false to hide and show
	 * the component itself (defaults to false). For example, this can be used as a shortcut for a hide button on a window
	 * by setting hide:true on the button when adding it to its parent container.
	 *
	 * @param hideParent true to hide and show the component's container when hide/show is called on the component
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHideParent(boolean hideParent) throws IllegalStateException {
		setAttribute("hideParent", hideParent, true);
	}

    /**
     * @return true if hideParent enabled
     */
    public boolean getHideParent() {
		return getAttributeAsBoolean("hideParent");
	}

	/**
	 * The unique id of this component (defaults to an auto-assigned id).
     *
     * <br>
     * <b>Note:</b> ID's cannot be changed after the component has been rendered.
	 *
	 * @param id the components ID
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public final void setId(String id) throws IllegalStateException {
        setAttribute( "id", id, false);
		this.id = id;
	}

    /**
     * @return the ID of the Component
     */
    public String getId() {
		return id;
	}

	//todo ext 2.0
	/*public void setPlugins(ComponentPlugin plugins) {
			JavaScriptObjectHelper.setAttribute(jsObj, "plugins", plugins);
		}*/


	/**
	 * The id of the node, a DOM node or an existing Element that will be the container to render this component into.
	 * Using this config, a call to render() is not required.
	 *
	 * @param elem the container element
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setRenderTo(Element elem) throws IllegalStateException {
		setAttribute("renderTo", elem, false);
	}


    /**
     * @return the element the Component is rendered to
     */
    public Element getRenderTo() {
		return JavaScriptObjectHelper.getAttributeAsElement(config, "renderTo");
	}

	/**
	 * An array of events that, when fired, should trigger this component to save its state (defaults to none). These can be
	 * any types of events supported by this component, including browser or custom events (e.g., ['click', 'customerchange']).
	 *
	 * @param stateEvents an array of state events
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setStateEvents(String[] stateEvents) throws IllegalStateException {
		setAttribute("stateEvents", stateEvents, true);
	}

    /**
     * An array of events that, when fired, should trigger this component to save its state (defaults to none). These can be
	 * any types of events supported by this component, including browser or custom events (e.g., ['click', 'customerchange']).
     *
     * @return an array of state events
     */
    public String[] getStateEvents() {
		return JavaScriptObjectHelper.getAttributeAsStringArray(config, "stateEvents");
	}

	/**
	 * The unique id for this component to use for state management purposes (defaults to the component id).
	 *
	 * @param stateId the state ID
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setStateId(String stateId) throws IllegalStateException {
		setAttribute("stateId", stateId, false);
	}

    /**
     * The unique id for this component to use for state management purposes (defaults to the component id).
     *
     * @return the state ID
     */
    public String getStateId() {
		return getAttribute("stateId");
	}

	/**
	 * A custom style specification to be applied to this component's Element.
	 *
	 * @param style the CSS style specification
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setStyle(String style) throws IllegalStateException {
		if(!isRendered()) {
			setAttribute("style", style, true);
		}else {
            Ext.get(getId()).applyStyles(style);
        }
    }

    /**
     * @return the custom style specification applied to the element
     */
    public String getStyle() {
		return getAttribute("style");
	}


    //fix GWT code for element access by using accessor and not member reference, this bug is fixed
    //in GWT 1.5
    public int getOffsetHeight() {
        return DOM.getElementPropertyInt(getElement(), "offsetHeight");
    }

    public int getOffsetWidth() {
        return DOM.getElementPropertyInt(getElement(), "offsetWidth");
    }

    protected Element getStyleElement() {
        return getElement();
    }

    public String getTitle() {
        return DOM.getElementProperty(getElement(), "title");
    }

    public void setHeight(String height) {
        // This exists to deal with an inconsistency in IE's implementation where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(height.trim().toLowerCase()) >= 0 :
                "CSS heights should not be negative";
        DOM.setStyleAttribute(getElement(), "height", height);
    }

    private native double extractLengthValue(String s) /*-{
    if (s == "auto" || s == "inherit" || s == "") {
      return 0;
    } else {
      return parseFloat(s);
    }
  }-*/;

    public void setTitle(final String title) {
        if(isRendered()) {
            if (title == null || title.length() == 0) {
                DOM.removeElementAttribute(getElement(), "title");
            } else {
                DOM.setElementAttribute(getElement(), "title", title);
            }
        } else {
            addListener("render", new Function() {
                public void execute() {
                    setTitle(title);
                }
            });
        }
    }

    protected String getAttribute(String attribute) {
        if(isCreated()) {
            return JavaScriptObjectHelper.getAttribute(getJsObj(), attribute);
        } else {
            return JavaScriptObjectHelper.getAttribute(config, attribute);
        }
    }

    protected JavaScriptObject getAttributeAsJavaScriptObject(String attribute) {
        if(isCreated()) {
            return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(getJsObj(), attribute);
        } else {
            return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(config, attribute);
        }
    }
    
    protected int getAttributeAsInt(String attribute) {
        if(isCreated()) {
            return JavaScriptObjectHelper.getAttributeAsInt(getJsObj(), attribute);
        } else {
            return JavaScriptObjectHelper.getAttributeAsInt(config, attribute);
        }
    }

    protected float getAttributeAsFloat(String attribute) {
        if(isCreated()) {
            return JavaScriptObjectHelper.getAttributeAsFloat(getJsObj(), attribute);
        } else {
            return JavaScriptObjectHelper.getAttributeAsFloat(config, attribute);
        }
    }

    protected boolean getAttributeAsBoolean(String attribute) {
        if(isRendered()) {
            return JavaScriptObjectHelper.getAttributeAsBoolean(getJsObj(), attribute);
        } else {
            return JavaScriptObjectHelper.getAttributeAsBoolean(config, attribute);
        }
    }

    private void error(String attribute, String value, boolean allowPostCreate) throws IllegalStateException {
        if (allowPostCreate) {
            error("Cannot change configuration property '" + attribute + "' after the component has been rendered.");
        } else {
            error("Cannot change configuration property '" + attribute + "' after the component has been created.");
        }
    }

    protected void error(String message) throws IllegalStateException {
        if (!GWT.isScript()) {
            MessageBox.alert("Error", message);
            throw new IllegalStateException(message);
        }
    }
	
	protected void setAttribute(String attribute, String value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, String value, boolean allowPostCreate, boolean allowPostRendered) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRendered) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, value, allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, int[] value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int[] value, boolean allowPostCreate, boolean allowPostRender) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRender) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, value.toString(), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, long value, boolean allowPostCreate) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, double value, boolean allowPostCreate) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, int value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, int value, boolean allowPostCreate, boolean allowPostRender) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRender) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, Date value, boolean allowPostCreate) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate) {
        setAttribute(attribute, value, allowPostCreate, false);
    }

    protected void setAttribute(String attribute, JavaScriptObject value, boolean allowPostCreate, boolean allowPostRender) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRender) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, String[] value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}
	
	protected void setAttribute(String attribute, String[] value, boolean allowPostCreate, boolean allowPostRender) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRender) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }


	protected void setAttribute(String attribute, boolean value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, boolean value, boolean allowPostCreate, boolean allowPostRendered) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRendered) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }

	protected void setAttribute(String attribute, Element value, boolean allowPostCreate) {
		setAttribute(attribute, value, allowPostCreate, false);
	}

	protected void setAttribute(String attribute, Element value, boolean allowPostCreate, boolean allowPostRendered) {
        if(!isCreated()) {
			JavaScriptObjectHelper.setAttribute(config, attribute, value);
        } else if(!isRendered() && allowPostCreate || allowPostRendered) {
            JavaScriptObjectHelper.setAttribute(getJsObj(),  attribute, value);
        } else {
			error(attribute, String.valueOf(value), allowPostCreate);
		}
    }


	public void setWidth(String width) {
        // This exists to deal with an inconsistency in IE's implementation where
        // it won't accept negative numbers in length measurements
        assert extractLengthValue(width.trim().toLowerCase()) >= 0 :
                "CSS widths should not be negative";
        DOM.setStyleAttribute(getElement(), "width", width);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Component) {
            if(obj == this) {
                return true;
            } else {
                Component other = (Component)obj;
                if(other.getId().equals(getId())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getId().hashCode();
    }
}
