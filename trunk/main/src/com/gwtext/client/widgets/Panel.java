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
import com.gwtext.client.core.*;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.PanelListener;

/**
 * Panel is a container that has specific functionality and structural components that make it the perfect building
 * block for application-oriented user interfaces. The Panel contains bottom and top toolbars, along with separate header,
 * footer and body sections. It also provides built-in expandable and collapsible behavior, along with a variety of prebuilt
 * tool buttons that can be wired up to provide other customized behavior. Panels can be easily dropped into any Container or
 * layout, and the layout and rendering pipeline is completely managed by the framework.
 */
public class Panel extends Container {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Panel();
        @com.gwtext.client.widgets.Panel::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "panel";
    }

    /**
     * Create a new Panel.
     */
    public Panel() {
    }

    /**
     * Construct a new Panel with the given title.
     *
     * @param title the title
     */
    public Panel(String title) {
        setTitle(title);
    }

    public Panel(String title, String html) {
        setTitle(title);
        setHtml(html);
    }

    public Panel(String title, int width, int height) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
    }

    protected Panel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Applys the Panel to an existing element.
     *
     * @param element the element
     */
    public Panel(Element element) {
        super(element);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.Panel(config);
    }-*/;

    public void setStyleName(String style) {
        setBodyStyle(style);
    }

    /**
     * Adds a button to this panel. Note that this method must be called prior to rendering. The preferred approach is to
     * add buttons via the buttons config.
     *
     * @param button the button to add
     */
    public void addButton(Button button) {
        if (isCreated()) {
            JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
            addButtonPostCreate(componentJS);

        } else {
            JavaScriptObject componentJS = button.isCreated() ? button.getOrCreateJsObj() : button.getConfig();
            addButtonPreCreate(componentJS);
        }
    }

    private native void addButtonPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.gwtext.client.widgets.Component::config;

        if (!config.buttons) {
            config.buttons = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        }
        config.buttons.push(componentJS);
    }-*/;

    private native void addButtonPostCreate(JavaScriptObject componentJS) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.addButton(componentJS);
    }-*/;

    /**
     * Collapses the panel body so that it becomes hidden. Fires the beforecollapse event which will cancel the collapse
     * action if it returns false.
     */
    public void collapse() {
        if(!isRendered()) {
            setCollapsed(true);
        } else {
            collapseRendered();
        }
    }

    private native void collapseRendered() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.collapse();
    }-*/;

    /**
     * Collapses the panel body so that it becomes hidden. Fires the beforecollapse event which will cancel the collapse
     * action if it returns false.
     *
     * @param animate True to animate the transition, else false (defaults to the value of the animCollapse panel config)
     */
    public void collapse(boolean animate) {
        if(!isRendered()) {
            setCollapsed(true);
        } else {
            collapseRendered(animate);
        }
    }

    private native void collapseRendered(boolean animate) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.collapse(animate);
    }-*/;

    /**
     * Expands the panel body so that it becomes visible.  Fires the beforeexpand event which will
     * cancel the expand action if it returns false.
     */
    public void expand(){
        if(!isRendered()) {
            setCollapsed(false);
        } else {
            expandRendered();
        }
    }

    private native void expandRendered() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.expand();
    }-*/;

    /**
     * Expands the panel body so that it becomes visible.  Fires the beforeexpand event which will
     * cancel the expand action if it returns false.
     *
     * @param animate True to animate the transition, else false (defaults to the value of the animCollapse panel config)
     */
    public void expand(boolean animate){
        if(!isRendered()) {
            setCollapsed(false);
        } else {
            expandRendered(animate);
        }
    }

    private native void expandRendered(boolean animate) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.expand(animate);
    }-*/;

    /**
     * The Panel's body Element which may be used to contain HTML content. The content may be specified in the html config,
     * or it may be loaded using the autoLoad config, or through the Panel's Updater.
     * <br>
     * If this is used to load visible HTML elements in either way, then the Panel may not be used as a Layout for hosting nested Panels.
     * <br>
     * If this Panel is intended to be used as the host of a Layout (See layout then the body Element must not be loaded or changed -
     * it is under the control of the Panel's Layout.
     *
     * @return the body element
     */
    public native ExtElement getBody() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var el = panel.body;
		return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The Panel's footer Element. This Element is used to house the Panel's
     * buttons.
     *
     * @return the footer element
     */
    public native ExtElement getFooter() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var el = panel.footer;
		return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The Panel's header Element. This Element is used to house the title and tools
     *
     * @return the header element
     */
    public native ExtElement getHeader() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var el = panel.header;
		return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * The wrapper element for the body of the Panel.
     *
     * @return the wrapper element for the body of the Panel
     */
    public native ExtElement getBodyWrap() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var el = panel.bwrap;
		return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the toolbar from the bottom section of the panel.
     *
     * @return the bottom toolbar
     */
    public native Toolbar getBottomToolbar() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var tb = panel.getBottomToolbar();
		return tb == null || tb === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
    }-*/;

    /**
     * Returns the height in pixels of the framing elements of this panel (including any top and bottom bars and header
     * and footer elements, but not including the body height). To retrieve the body height see {@link #getInnerHeight()}.
     *
     * @return the frame hieght
     */
    public native int getFrameHeight() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return panel.getFrameHeight();
    }-*/;

    /**
     * Returns the width in pixels of the framing elements of this panel (not including the body width). To retrieve
     * the body width see {@link #getInnerWidth()}.
     *
     * @return the frame width
     */
    public native int getFrameWidth() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return panel.getFrameWidth();
    }-*/;

    /**
     * Returns the height in pixels of the body element (not including the height of any framing elements).
     * For the frame height see {@link #getFrameHeight()} .
     *
     * @return the inner height
     */
    public native int getInnerHeight() /*-{
       var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       return panel.getInnerHeight();
   }-*/;

    /**
     * Returns the width in pixels of the body element (not including the width of any framing elements).
     * For the frame width see {@link #getFrameWidth()} .
     *
     * @return the inner width
     */
    public native int getInnerWidth() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return panel.getInnerWidth();
    }-*/;

    /**
     * Returns the toolbar from the top section of the panel.
     *
     * @return the top toolbar
     */
    public native Toolbar getTopToolbar() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var tb = panel.getTopToolbar();
		return tb == null || tb === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(tb);
    }-*/;

    /**
     * Get the UpdateManager for this panel. Enables you to perform Ajax updates of this panel's body.
     *
     * @return the UpdateManager
     */
    public native UpdateManager getUpdateManager()/*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var umJS = panel.getUpdater();
        return @com.gwtext.client.core.UpdateManager::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(umJS);
    }-*/;

    /**
     * Loads this content panel immediately with content returned from an XHR call.
     *
     * @param url the url to load the content from
     */
    public void load(String url) {
        load(url, (UrlLoadConfig) null, (UrlLoadCallback) null);
    }

    /**
     * Loads this content panel immediately with content returned from an XHR call.
     *
     * @param url         the url to load the content from
     * @param params      the request URL params
     * @param callback    callback function
     * @param loadScripts whether to execute scripts from the laoded content.
     */
    public void load(String url, UrlParam[] params, UrlLoadCallback callback, boolean loadScripts) {
        UrlLoadConfig config = new UrlLoadConfig();
        config.setParams(params);
        config.setCallback(callback);
        config.setScripts(loadScripts);
        load(url, config, callback);
    }

    /**
     * Loads this content panel immediately with content returned from an XHR call.
     *
     * @param url      the url to load the content from
     * @param params   the load configuration params
     * @param callback the callback
     */
    private void load(String url, UrlLoadConfig params, UrlLoadCallback callback) {
        if (params == null) params = new UrlLoadConfig();
        params.setUrl(url);
        params.setCallback(callback);
        load(params.getJsObj());
    }

    private native void load(JavaScriptObject params)/*-{       
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();        
        panel.load(params);
    }-*/;

    /**
     * Sets the CSS class that provides the icon image for this panel. This method will replace any existing icon class
     * if one has already been set.
     *
     * @param cls the icon class
     */
    private native void setIconClsRendered(String cls) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.setIconClass(cls);
    }-*/;

    /**
     * Sets the title text for the panel.
     *
     * @param title the title
     */
    private native void setTitleRendered(String title) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.setTitle(title);
    }-*/;

    /**
     * Sets the title text for the panel and optioanlly the icon class.
     *
     * @param title   the title
     * @param iconCls A CSS class that provides the icon image for this panel
     */
    public void setTitle(String title, String iconCls) {
        if (title == null || title.equals("")) {
            title = " ";
        }
        if (!isRendered()) {
            setTitle(title);
            setIconCls(iconCls);
        } else {
            setTitleRendered(title, iconCls);
        }
    }

    private native void setTitleRendered(String title, String iconCls) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.setTitle(title);
    }-*/;

    /**
     * Shortcut for performing an expand or collapse based on the current state of the panel.
     */
    public native void toggleCollapse() /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.toggleCollapse();
    }-*/;

    /**
     * Shortcut for performing an expand or collapse based on the current state of the panel.
     *
     * @param animate true to animate
     */
    public native void toggleCollapse(boolean animate) /*-{
        var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        panel.toggleCollapse(animate);
    }-*/;

    /**
     * Add a Panel listener.
     *
     * @param listener the listener
     */
    public native void addListener(PanelListener listener) /*-{
        this.@com.gwtext.client.widgets.Container::addListener(Lcom/gwtext/client/widgets/event/ContainerListener;)(listener);
        var panelJ = this;

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('activate',
                function(p) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onActivate(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeclose',
                function(p) {
                    return listener.@com.gwtext.client.widgets.event.PanelListener::doBeforeClose(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforecollapse',
                function(p, anim) {
                    var animate = anim === true;
                    return listener.@com.gwtext.client.widgets.event.PanelListener::doBeforeCollapse(Lcom/gwtext/client/widgets/Panel;Z)(panelJ, animate);
                }
        );                                                          

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforeexpand',
                function(p, anim) {
                    var animate = anim === true;
                    return listener.@com.gwtext.client.widgets.event.PanelListener::doBeforeExpand(Lcom/gwtext/client/widgets/Panel;Z)(panelJ, animate);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('bodyresize',
                function(p, w, h) {
                    if(w === undefined) w = 0;
                    if(h === undefined) h = 0;
                    listener.@com.gwtext.client.widgets.event.PanelListener::onBodyResize(Lcom/gwtext/client/widgets/Panel;Ljava/lang/String;Ljava/lang/String;)(panelJ, w.toString(), h.toString());
                }
        );
    
       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('close',
                function(p) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onClose(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('collapse',
                function(p) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onCollapse(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('deactivate',
                function(p) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onDeactivate(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('expand',
                function(p) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onExpand(Lcom/gwtext/client/widgets/Panel;)(panelJ);
                }
        );

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('titlechange',
                function(p, title) {
                    listener.@com.gwtext.client.widgets.event.PanelListener::onTitleChange(Lcom/gwtext/client/widgets/Panel;Ljava/lang/String;)(panelJ, title);
                }
        );    
    }-*/;

    // --- config properties

    /**
     * True to animate the transition when the panel is collapsed, false to skip the animation.
     *
     * @param animCollapse Defaults to true if the {@link Fx} class is available, otherwise false
     */
    public void setAnimCollapse(boolean animCollapse)  {
        setAttribute("animCollapse", animCollapse, true, true);
    }

    /**
     * True to animate the transition when the panel is collapsed, false to skip the animation.
     *
     * @return true to animate the transition when the panel is collapsed,  false to skip the animation
     */
    public boolean isAnimCollapse() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "animCollapse");
    }

    /**
     * If set, the panel will attempt to load its contents from the specified URL immediately upon
     * render.
     * <br><br>
     *
     * The URL will become the default URL for this panel's body element, so it may be refreshed at any time.
     *
     * @param url the URL to load the panel's content
     */
    public void setAutoLoad(String url) {
        setAutoLoad(url, new UrlLoadConfig());
    }

    /**
     * If set, the panel will attempt to load its contents from the specified URL immediately upon render.
     * <br><br>
     *
     * The URL will become the default URL for this panel's body element, so it may be refreshed at any time.
     *
     * @param url the URL to load the panel's content
     * @param loadConfig the URL load configuration
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoLoad(String url, UrlLoadConfig loadConfig) throws IllegalStateException {
        loadConfig.setUrl(url);
        setAttribute("autoLoad", loadConfig.getJsObj(), true);
    }

    /**
     * True to use overflow:'auto' on the panel's body element and show scroll bars automatically when necessary,
     * false to clip any overflowing content.
     *
     * @param autoScroll Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoScroll(boolean autoScroll) throws IllegalStateException {
        setAttribute("autoScroll", autoScroll, true);
    }

    /**
     * True to use overflow:'auto' on the panel's body element and show scroll bars automatically when necessary,
     * false to clip any overflowing content.
     *
     * @return true to autoscroll
     */
    public boolean isAutoScroll() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "autoScroll");
    }

    /**
     * The base CSS class to apply to this panel's element.
     *
     * @param baseCls Defaults to 'x-panel'
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBaseCls(String baseCls) throws IllegalStateException {
        setAttribute("baseCls", baseCls, true);
    }

    /**
     * The base CSS class to apply to this panel's element.
     *
     * @return the base CSS class to apply to this panel's element. Defaults to 'x-panel'
     */
    public String getBaseCls() {
        return JavaScriptObjectHelper.getAttribute(config, "baseCls");
    }

    /**
     * True to display an interior border on the body element of the panel, false to hide it.
     * This only applies when border == true. If border == true and bodyBorder == false, the border will display as a
     * 1px wide inset border, giving the entire body element an inset appearance.
     *
     * @param bodyBorder Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBodyBorder(boolean bodyBorder) throws IllegalStateException {
        setAttribute("bodyBorder", bodyBorder, true);
    }

    /**
     * @return true to display an interior border on the body element of the panel, false to hide it.
     */
    public boolean isBodyBorder() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "bodyBorder");
    }

    /**
     * True to display the borders of the panel's body element, false to hide them.
     * By default, the border is a 2px wide inset border, but this can be further altered by setting bodyBorder to false.
     *
     * @param border Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBorder(boolean border) throws IllegalStateException {
        setAttribute("border", border, true);
    }

    /**
     * True to display the borders of the panel's body element, false to hide them.
     * By default, the border is a 2px wide inset border, but this can be further altered by setting bodyBorder to false.
     *
     * @return true to display the borders of the panel's body element, false to hide them.
     */
    public boolean isBorder() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "border");
    }

    /**
     * Set padding on all sides.
     *
     * @param padding the  padding value in pixels
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPaddings(int padding) throws IllegalStateException {
        setPaddings(padding, padding, padding, padding);
    }

    /**
     * Set paddings to Panel.
     *
     * @param top    the top padding
     * @param left   left padding
     * @param right  right padding
     * @param bottom bottom padding
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPaddings(int top, int left, int right, int bottom) throws IllegalStateException {
        Paddings paddings = new Paddings(top, left, right, bottom);
        String style = paddings.getStyleString();
        String bodyStyle = getBodyStyle();
        if (bodyStyle == null) {
            setBodyStyle(style);
        } else {
            setBodyStyle(bodyStyle + style);
        }
    }

    /**
     * Set padding on all sides.
     *
     * @param margin the  padding value in pixels
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMargins(int margin) throws IllegalStateException {
        setMargins(margin, margin, margin, margin);
    }

    /**
     * Set paddings to Panel.
     *
     * @param top    the top padding
     * @param left   left padding
     * @param right  right padding
     * @param bottom bottom padding
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMargins(int top, int left, int right, int bottom) throws IllegalStateException {
        Margins margins = new Margins( top, left, right, bottom);
        String style = margins.getStyleString();
        String bodyStyle = getBodyStyle();
        if (bodyStyle == null) {
            setBodyStyle(style);
        } else {
            setBodyStyle(style + bodyStyle);
        }
    }

    /**
     * Custom CSS styles to be applied to the body element in the format expected by {@link ExtElement#applyStyles(String)}
     *
     * @param bodyStyle Defaults to null
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBodyStyle(String bodyStyle) throws IllegalStateException {
        setAttribute("bodyStyle", bodyStyle, true);
    }

    /**
     * Custom CSS styles to be applied to the body element in the format expected by {@link ExtElement#applyStyles(String)}
     *
     * @return the custom CSS styles to be applied to the body element
     */
    public String getBodyStyle() {
        return JavaScriptObjectHelper.getAttribute(config, "bodyStyle");
    }

    /**
     * The alignment of any buttons added to this panel. Valid values are {@link Position#RIGHT}, {@link Position#LEFT}, {@link Position#CENTER}.
     *
     * @param buttonAlign Defaults to {@link Position#RIGHT}
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setButtonAlign(Position buttonAlign) throws IllegalStateException {
        setAttribute("buttonAlign", buttonAlign.getPosition(), true);
    }

    /**
     * Used to add buttons to the footer of this panel.
     *
     * @param buttons Array of {@link Button}
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setButtons(Button[] buttons) throws IllegalStateException {
        JavaScriptObject buttonsJS = JavaScriptObjectHelper.convertToJavaScriptConfigArray(buttons);
        setAttribute("buttons", buttonsJS, true);
    }

    /**
     * Whether the Panel is closable. This is applicable when a Panel is added to a TabPanel.
     *
     * @param closable true if closable
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setClosable(boolean closable) throws IllegalStateException {
        setAttribute("closable", closable, true);
    }

    /**
     * Whether the Panel is closable. This is applicable when a Panel is added to a TabPanel.
     *
     * @return true if the Panel is closable
     */
    public boolean isClosable() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "closable");
    }

    /**
     * True to make sure the collapse/expand toggle button always renders first (to the left of) any other tools in the panel's title bar,
     * false to render it last.
     *
     * @param collapseFirst Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setCollapseFirst(boolean collapseFirst)  throws IllegalStateException {
        setAttribute("collapseFirst", collapseFirst, true);
    }

    /**
     * True to make sure the collapse/expand toggle button always renders first (to the left of) any other tools in the panel's title bar,
     * false to render it last.
     *
     * @return true to make sure the collapse/expand toggle button always renders first
     */
    public boolean getCollapseFirst() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "collapseFirst");
    }

    /**
     * True if panel collapsed, false if expanded
     *
     * @param collapsed Defaults to false
     */
    public void setCollapsed(boolean collapsed) {
        if(!isRendered()) {
            setAttribute("collapsed", collapsed, true);
        } else {
           if(collapsed) {
               collapse();
           } else {
               expand();
           }
        }
    }

    /**
     * True if panel collapsed, false if expanded.
     *
     * @return true to render the panel expanded, false to render it collapsed
     */
    public boolean isCollapsed() {
        return getAttributeAsBoolean("collapsed");
    }

    /**
     * A CSS class to add to the panel's element after it has been collapsed.
     *
     * @param collapsedCls Defaults to 'x-panel-collapsed'
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setCollapsedCls(String collapsedCls) throws IllegalStateException {
        setAttribute("collapsedCls", collapsedCls, true);
    }

    /**
     * A CSS class to add to the panel's element after it has been collapsed.
     *
     * @return the CSS class to add to the panel's element after it has been collapsed.
     */
    public String getCollapsedCls() {
        return JavaScriptObjectHelper.getAttribute(config, "collapsedCls");
    }

    /**
     * True to make the panel collapsible and have the expand/collapse toggle button automatically rendered into the header tool button area,
     * false to keep the panel statically sized with no button.
     *
     * @param collapsible Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setCollapsible(boolean collapsible) throws IllegalStateException {
        setAttribute("collapsible", collapsible, true);
    }

    /**
     * True to make the panel collapsible and have the expand/collapse toggle button automatically rendered into the header tool button area,
     * false to keep the panel statically sized with no button.
     *
     * @return true to make the panel collapsible and have the expand/collapse toggle button automatically rendered into
     *         the header tool button area, false to keep the panel statically sized with no button
     */
    public boolean isCollapsible() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "collapsible");
    }

    /**
     * The id of an existing HTML node to use as the panel's body content
     *
     * @param contentEl Defaults to null
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setContentEl(Element contentEl) throws IllegalStateException {
        setAttribute("contentEl", new ExtElement(contentEl).getJsObj(), true);
    }

    /**
     * True to enable dragging of this Panel (defaults to false).
     *
     * @param draggable true to enable dragging of this panel
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDraggable(boolean draggable) throws IllegalStateException {
        setAttribute("draggable", draggable, true);
    }

    /**
     * True to float the panel (absolute position it with automatic shimming and shadow), false to display it inline where it is rendered.
     * Note that by default, setting floating to true will cause the panel to display at negative offsets so that it is hidden -- because
     * the panel is absolute positioned, the position must be set explicitly after render (e.g., myPanel.setPosition(100,100);).
     * Also, when floating a panel you should always assign a fixed width, otherwise it will be auto width and will expand to fill to the
     * right edge of the viewport.
     *
     * @param floating Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFloating(boolean floating) throws IllegalStateException {
        setAttribute("floating", floating, true);
    }

    /**
     * True to float the panel (absolute position it with automatic shimming and shadow), false to display it inline where it is rendered.
     * Note that by default, setting floating to true will cause the panel to display at negative offsets so that it is hidden -- because
     * the panel is absolute positioned, the position must be set explicitly after render (e.g., myPanel.setPosition(100,100);).
     * Also, when floating a panel you should always assign a fixed width, otherwise it will be auto width and will expand to fill to the
     * right edge of the viewport.
     *
     * @return true to float panel, false to display it inline where it is rendered
     */
    public boolean getFloating() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "floating");
    }

    /**
     * True to create the footer element explicitly, false to skip creating it. By default, when footer is not specified, if one or more
     * buttons have been added to the panel the footer will be created automatically, otherwise it will not.
     *
     * @param footer true to create footer
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFooter(boolean footer) throws IllegalStateException {
        setAttribute("footer", footer, true);
    }

    /**
     * True to render the panel with custom rounded borders, false to render with plain 1px square borders.
     *
     * @param frame Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setFrame(boolean frame) throws IllegalStateException {
        setAttribute("frame", frame, true);
    }

    /**
     * @return true to render the panel with custom rounded borders
     */
    public boolean isFrame() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "frame");
    }

    /**
     * True to create the header element explicitly, false to skip creating it. By default, when header is not specified, if a title is
     * set the header will be created automatically, otherwise it will not. If a title is set but header is explicitly set to false, the
     * header will not be rendered.
     *
     * @param header true to create header
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHeader(boolean header) throws IllegalStateException {
        setAttribute("header", header, false);
    }

    /**
     * True to create the header element explicitly, false to skip creating it. By default, when header is not specified, if a title is
     * set the header will be created automatically, otherwise it will not. If a title is set but header is explicitly set to false, the
     * header will not be rendered.
     *
     * @return true to create header
     */
    public boolean isHeader() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "header");
    }


    /**
     * True to display the panel title in the header, false to hide it
     *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered.
     *
     * @param headerAsText Defaults to true
     */
    public void setHeaderAsText(boolean headerAsText)  {
        setAttribute("headerAsText", headerAsText, true, true);
    }

    /**
     * @return true to display the panel title in the header, false to hide it
     */
    public boolean isHeaderAsText() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "headerAsText");
    }

    /**
     * True to hide the expand/collapse toggle button when collapsible = true, false to display it.
     *
     * @param hideCollapseTool Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHideCollapseTool(boolean hideCollapseTool) throws IllegalStateException {
        setAttribute("hideCollapseTool", hideCollapseTool, true);
    }

    /**
     * True to hide the expand/collapse toggle button when collapsible = true, false to display it.
     *
     * @return true to hide the expand/collapse toggle button when collapsible = true, false to display it.
     */
    public boolean isHideCollapseTool() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "hideCollapseTool");
    }

    /**
     * An HTML fragment, or a DomHelper specification to use as the panel's body content.
     *
     * @param html Defaults to ""
     */
    public void setHtml(String html) {
        if(isRendered()) {
            getBody().update(html);
        } else {
            setAttribute("html", html, true);
        }
    }

    /**
     * An HTML fragment, or a DomHelper specification to use as the panel's body content.
     *
     * @return the HTML fragment, or a DomHelper specification to use as the panel's body content.
     */
    public String getHtml() {
        if(isRendered()) {
            return getBody().getDOM().toString();
        } else {
            return JavaScriptObjectHelper.getAttribute(config, "html");
        }
    }

    /**
     * A CSS class that will provide a background image to be used as the panel header icon
     *
     * @param iconCls Defaults to ""
     */
    public void setIconCls(String iconCls) {
        if (!isRendered()) {
            setAttribute("iconCls", iconCls, true);
        } else {
            setIconClsRendered(iconCls);
        }
    }

    /**
     * @return the  CSS class that will provide a background image to be used as the panel header icon
     */
    public String getIconCls() {
        return getAttribute("iconCls");
    }

    /**
     * True to mask the panel when it is disabled, false to not mask it. Either way, the panel will
     * always tell its contained elements to disable themselves when it is disabled, but masking the
     * panel can provide an additional visual cue that the panel is disabled.
     *
     * @param maskDisabled Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaskDisabled(boolean maskDisabled) throws IllegalStateException {
        setAttribute("maskDisabled", maskDisabled, true);
    }

    /**
     * @return true to mask the panel when it is disabled, false to not mask it.
     */
    public boolean isMaskDisabled() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "maskDisabled");
    }

    /**
     * Minimum width in pixels of all buttons in this panel.
     *
     * @param minButtonWidth Defaults to 75
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinButtonWidth(int minButtonWidth) throws IllegalStateException {
        setAttribute("minButtonWidth", minButtonWidth, true);
    }

    /**
     * Minimum width in pixels of all buttons in this panel.
     *
     * @return the minimum width in pixels of all buttons in this panel.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public int getMinButtonWidth() throws IllegalStateException {
        return getAttributeAsInt("minButtonWidth");
    }

    //todo add string option for custom shadows
    /**
     * True to display a shadow behind the panel, false to display no shadow (defaults to 'sides').
     * Note that this option only applies when floating = true.
     *
     * @param shadow true to display shadow
     */
    public void setShadow(boolean shadow) {
        setAttribute("shadow", shadow, true);
    }

    /**
     * Set the shadow behind the Panel.
     * Note that this option only applies when floating = true.
     *
     * @param shadow true to display shadow
     * @see com.gwtext.client.widgets.Shadow#SIDES
     * @see com.gwtext.client.widgets.Shadow#FRAME
     * @see com.gwtext.client.widgets.Shadow#DROP
     */
    public void setShadow(Shadow.Type shadow) {
        setAttribute("shadow", shadow.getType(), true);
    }

    /**
     * True to display a shadow behind the panel, false to display no shadow (defaults to 'sides').
     *
     * @return true to display a shadow behind the panel, false to display no shadow (defaults to 'sides').
     */
    public boolean isShadow() {
        return getAttributeAsBoolean("shadow");
    }

    /**
     * The number of pixels to offset the shadow if displayed. Note that this option only applies when floating = true.
     *
     * @param shadowOffset Defaults to 4
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShadowOffset(int shadowOffset) throws IllegalStateException {
        setAttribute("shadowOffset", shadowOffset, true);
    }

    /**
     * The number of pixels to offset the shadow if displayed. Note that this option only applies when floating = true.
     * @return the number of pixels to offset the shadow if displayed. Note that this option only applies when floating = true.
     */
    public int getShadowOffset() {
        return getAttributeAsInt("shadowOffset");
    }

    /**
     * False to disable the iframe shim in browsers which need one. Note that this option only applies when floating = true.
     *
     * @param shim Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setShim(boolean shim) throws IllegalStateException {
        setAttribute("shim", shim, true);
    }

    /**
     * False to disable the iframe shim in browsers which need one. Note that this option only applies when floating = true.
     *
     * @return false to disable the iframe shim in browsers which need one.
     */
    public boolean isShim() {
        return getAttributeAsBoolean("shim");
    }

    /**
     * The top toolbar of the panel. Note that this is not available as a property after render.
     * To access the top toolbar after render, use getTopToolbar.
     *
     * @param toolbar the toolbar
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTopToolbar(Toolbar toolbar) throws IllegalStateException {
        setAttribute("tbar", toolbar.getOrCreateJsObj(), false);
    }

    /**
     * The top toolbar of the panel. Note that this is not available as a property after render.
     * To access the top toolbar after render, use getTopToolbar.
     *
     * @param button the button
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTopToolbar(Button button) throws IllegalStateException {
        setTopToolbar(new Button[]{button});
    }

    /**
     * The top toolbar of the panel. Note that this is not available as a property after render.
     * To access the top toolbar after render, use getTopToolbar.
     *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered. To add buttons after the Panel has been
     * rendered, call {@link #getTopToolbar()} and then add Bottons directly to the toolbar.
     *
     * @param buttons the buttons
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTopToolbar(Button[] buttons) throws IllegalStateException {
        JavaScriptObject buttonsJS = JavaScriptObjectHelper.convertToJavaScriptConfigArray(buttons);
        setAttribute("tbar", buttonsJS, false);
    }

    /**
     * The bottom toolbar of the panel. Note that this is not available as a property after render.
     * To access the bottom toolbar after render, use @link #getBottomToolbar.
     *
     * @param toolbar the toolbar
     */
    public void setBottomToolbar(Toolbar toolbar) {
        setAttribute("bbar", toolbar.getOrCreateJsObj(), false);
    }

    /**
     * The bottom toolbar of the panel. Note that this is not available as a property after render.
     * To access the bottom toolbar after render, use @link #getBottomToolbar.
     *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered. To add buttons after the Panel has been
     * rendered, call {@link #getBottomToolbar()} and then add Bottons directly to the toolbar.
     *
     * @param button the button
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBottomToolbar(Button button) throws IllegalStateException {
        setBottomToolbar(new Button[]{button});
    }

    /**
     * The bottom toolbar of the panel. Note that this is not available as a property after render.
     * To access the bottom toolbar after render, use @link #getBottomToolbar.
     *
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered. To add buttons after the Panel has been
     * rendered, call {@link #getBottomToolbar()} and then add Bottons directly to the toolbar.
     *
     * @param buttons the buttons
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBottomToolbar(Button[] buttons) throws IllegalStateException {
        JavaScriptObject buttonsJS = JavaScriptObjectHelper.convertToJavaScriptConfigArray(buttons);
        setAttribute("bbar", buttonsJS, false);
    }

    /**
     * Set the tab CSS Class. This method is only applicable it the PAnel is being added to a TabPanel. This CSS class
     * is applied to the &lt;li&gt; elements of the tab in the tabpanel.
     *
     * @param tabCls the tabCls
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabCls(String tabCls) {
        setAttribute("tabCls", tabCls, true);
    }

    /**
     * Return the tab CSS Class.
     *
     * @return the tabCls
     */
    public String getTabCls() {
        return getAttribute("tabCls");
    }


    /**
     * The title text to display in the panel header. When a title is specified the header
     * element will automatically be created and displayed unless header is explicitly set to false. If you don't
     * want to specify a title at config time, but you may want one later, you must either specify a non-empty
     * title (a blank space " " will do) or call setHeader(true) so that the container element will get created.
     *
     * @param title Defaults to ""
     */
    public void setTitle(String title) {
        if (title == null || title.equals("")) {
            title = " ";
        }
        if (!isRendered()) {
            setAttribute("title", title, true);
        } else {
            setTitleRendered(title);
        }
    }

    /**
     * The title text to display in the panel header.
     *
     * @return the title text to display in the panel header.
     */
    public String getTitle() {
        return getAttribute("title");
    }

    /**
     * True to allow expanding and collapsing the panel (when collapsible = true) by clicking anywhere in the header bar,
     * false to allow it only by clicking to tool button
     *
     * @param titleCollapse Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTitleCollapse(boolean titleCollapse) throws IllegalStateException {
        setAttribute("titleCollapse", titleCollapse, true);
    }

    /**
     * @return true to allow expanding and collapsing the panel (when collapsible = true) by clicking anywhere in the header bar,
     *         false to allow it only by clicking to tool button
     */
    public boolean isTitleCollapse() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "titleCollapse");
    }

    /**
     * The tool to be added to the header tool area.
     *
     * @param tool the tool to add
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void addTool(Tool tool) throws IllegalStateException {
		check();
        addToolPreRender(tool);
    }

    /**
     * The tools to be added to the header tool area.
     *
     * @param tools the tools to add
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTools(Tool[] tools) throws IllegalStateException {
        for (int i = 0; i < tools.length; i++) {
            Tool tool = tools[i];
            addTool(tool);
        }
    }

    private native void addToolPreRender(Tool tool) /*-{
        var config = this.@com.gwtext.client.widgets.Component::config;
        if(!config.tools) config.tools = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
		config.tools.push(tool.@com.gwtext.client.widgets.Tool::jsObj);
    }-*/;    
}
