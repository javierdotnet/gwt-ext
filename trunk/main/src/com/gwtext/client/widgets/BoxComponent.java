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
import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.Box;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.Size;
import com.gwtext.client.widgets.event.BoxComponentListener;

/**
 * Base class for any visual {@link Component} that uses a box container. BoxComponent provides automatic box model adjustments
 * for sizing and positioning and will work correctly withnin the Component rendering model. All container classes should subclass
 * BoxComponent so that they will work consistently when nested within other Ext layout containers.
 */
public class BoxComponent extends Component {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
        var c = new $wnd.Ext.BoxComponent();
        @com.gwtext.client.widgets.BoxComponent::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "box";
	}

	public BoxComponent() {
	}

	public BoxComponent(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public BoxComponent(Element element) {
		super(element);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.BoxComponent(config);
    }-*/;

	/**
	 * Gets the current box measurements of the component's.
	 *
	 * @return the box measurements
	 */
	public native Box getBox()/*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var boxJS = component.getBox();
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

	/**
	 * Gets the current box measurements of the component's.
	 *
	 * @param local if true the element's left and top are returned instead of page XY (defaults to false)
	 * @return the box measurements
	 */
	public native Box getBox(boolean local)/*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var boxJS = component.getBox(local);
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Gets the current XY position of the component's underlying element.
     *
     * @return the XY position
     */
    public native int[] getPosition() /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var arrJS = component.getPosition();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the current XY position of the component's underlying element.
     *
     * @return the XY position
     * @param local if true the element's left and top are returned instead of page XY (defaults to false)
     */
    public native int[] getPosition(boolean local) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var arrJS = component.getPosition();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
	 * Gets the current size of the component's underlying element.
	 *
	 * @return the components Size
	 */
	public native Size getSize()/*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var sizeJS = component.getSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

	/**
	 * Sets the page XY position of the component. To set the left and top instead, use setPosition.
	 * This method fires the move event.
	 *
	 * @param x the new X position
	 * @param y the new Y opsition
	 */
	public native void setPagePosition(int x, int y) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.setPagePosition(x, y);            
    }-*/;

	/**
	 * Sets the left and top of the component. To set the page XY position instead, use setPagePosition.
	 * This method fires the move event.
	 *
	 * @param left the new left
	 * @param top  the new right
	 */
	public native void setPosition(int left, int top) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.setPosition(left, top);
    }-*/;

	/**
	 * Sets the width and height of the component. This method fires the resize event.
	 *
	 * @param width  the new width
	 * @param height the new height
	 */
	private void setSize(int width, int height) {
		if (!isRendered()) {
			setWidth(width);
			setHeight(height);
		} else {
			setSizeRendered(width, height);
		}
	}

	private native void setSizeRendered(int width, int height) /*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.setSize(width, height);
    }-*/;

	/**
	 * Force the component's size to recalculate based on the underlying element's current height and width.
	 */
	public native void syncSize()/*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        component.syncSize();
    }-*/;

	/**
	 * Sets the current box measurements of the component's underlying element.
	 *
	 * @param box the new box measurements
	 */
	public native void updateBox(Box box)/*-{
        var component = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var boxJS = box.@com.gwtext.client.core.JsObject::jsObj;
        component.updateBox(boxJS);                    
    }-*/;

	/**
	 * Add a Component listener.
	 *
	 * @param listener the listener
	 */
	protected native void addListener(BoxComponentListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);
        var componentJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('move',
                function(source, x, y) {
                    listener.@com.gwtext.client.widgets.event.BoxComponentListener::onMove(Lcom/gwtext/client/widgets/BoxComponent;II)(componentJ, x, y)
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('resize',
                function(source, adjWidth, adjHeight, rawWidth, rawHeight) {

                    if(adjWidth == null || adjWidth === undefined) adjWidth = 0;
                    if(adjHeight == null || adjHeight === undefined) adjHeight = 0;
                    if(rawWidth == null || rawWidth === undefined) rawWidth = 0;
                    if(rawHeight == null || rawHeight === undefined) rawHeight = 0;
                    if(typeof adjWidth == 'string') adjWidth = -1;
                    if(typeof adjHeight == 'string') adjHeight = -1;
                    if(typeof rawWidth  == 'string') rawWidth = -1;
                    if(typeof rawHeight  == 'string') rawHeight = -1;
                    listener.@com.gwtext.client.widgets.event.BoxComponentListener::onResize(Lcom/gwtext/client/widgets/BoxComponent;IIII)(componentJ, adjWidth, adjHeight, rawWidth, rawHeight);
                }
        );
    }-*/;

    /**
     * Runs the specified function when the Component is rendered.
     *
     * @param function the function to execute on render
     */
    public void doOnRender(Function function) {
        if(!isRendered()) {
            addListener("render", function);
        } else {
            throw new IllegalStateException("The component is already rendered");
        }
    }

    /**
     * Runs the specified function when the Component is rendered.
     *
     * @param function the function to execute on render
     * @param delayMillis a delay in milliseconds
     */
    public void doOnRender(final Function function, final int delayMillis) {
        if(!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
                    new Timer() {
                        public void run() {
                             function.execute();
                        }
                    }.schedule(delayMillis);
                }
            });
        } else {
            throw new IllegalStateException("The component is already rendered");
        }
    }

    // --- config properties ---

	/**
	 * True to use height:'auto', false to use fixed height (defaults to false).
	 *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered.
     *
	 * @param autoHeight true to use auto height
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAutoHeight(boolean autoHeight) throws IllegalStateException {
        setAttribute("autoHeight", autoHeight, true);
	}

    /**
     *
     * @return true if using auto height, else false
     */
    public boolean getAutoHeight() {
		return getAttributeAsBoolean("autoHeight");
	}

	/**
	 * True to use width:'auto', false to use fixed width (defaults to false).
	 *
	 * @param autoWidth true for auto width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setAutoWidth(boolean autoWidth) throws IllegalStateException {
        setAttribute("autoWidth", autoWidth, true);
	}

    /**
     * @return true if using auto width, else false
     */
    public boolean getAutoWidth() {
		return getAttributeAsBoolean("autoWidth");
	}

	/**
	 * The height of this component in pixels (defaults to auto).
	 *
	 * @param height the component height
	 */
	public void setHeight(int height) {
        if(!isRendered()) {
            if(height == -1) {
                setAttribute("height", "auto", true);
            } else {
                setAttribute("height", height, true);
            }
        } else {
            super.setHeight(height + "px");
        }
    }

    /**
     * Set the height in pixels or auto. Note that setting percentage based heights will lead to unpredictable
     * display behavior. You should use the various layouts like {@link com.gwtext.client.widgets.layout.AnchorLayout}
     * to control percentage based rendering of components.
     *
     * @param height the component height
     */
    public void setHeight(String height) {
        if(!isRendered()) {
            if(height.indexOf("px") != -1) {
                height = height.replaceAll("px","").trim();
                setHeight(Integer.parseInt(height));
            } else if (height.trim().equalsIgnoreCase("auto")) {
                setAutoHeight(true);
            } else {
                setAttribute("height", height, true);
            }
        } else {
            super.setHeight(height);
        }
    }

    /**
     * The height of this component in pixels.
     *
     * @return the hieght of the component in pixels
     */
    public int getHeight() {
        if(!isRendered()) {
            String height = getAttribute("height");
            if(height.equals("auto")) {
                return -1;
            } else {
                return Integer.parseInt(height);
            }
        } else {
            return getEl().getHeight();
        }
    }

	/**
	 * The component width. (defaults to auto)
	 *
	 * @param width the width, -1 for auto
	 */
	public void setWidth(int width) {
        if(!isRendered()) {
            if(width == -1) {
                setAttribute( "width", "auto", true);
            } else {
                setAttribute( "width", width, true);
            }
        } else {
            super.setWidth(width +"px");
        }
    }

    /**
     * Set the width in pixels or auto. Note that setting percentage based widths will lead to unpredictable
     * display behavior. You should use the various layouts like {@link com.gwtext.client.widgets.layout.AnchorLayout}
     * to control percentage based rendering of components.
     *
     * @param width the component height
     */
    public void setWidth(String width) {
        if(!isRendered()) {
            if(width.indexOf("px") != -1) {
                width = width.replaceAll("px","").trim();
                setWidth(Integer.parseInt(width));
            } else if (width.trim().equalsIgnoreCase("auto")) {
                setAutoWidth(true);
            } else {
                setAttribute("width", width, true);
            }
        } else {
            super.setWidth(width);
        }
    }

    /**
     * The component width.
     *
     * @return the component width, -1 for auto
     */
    public int getWidth() {
        if(isRendered()) {
            return getEl().getWidth();
        } else {
            String width = getAttribute("width");
            if(width.equals("auto")) {
                return -1;
            } else {
                return Integer.parseInt(width);
            }
        }
    }
}
