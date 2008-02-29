package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.WindowListener;

/**
 * A specialized panel intended for use as an application window. Windows are floated and draggable by default, and also provide specific
 * behavior like the ability to maximize and restore (with an event for  * minimizing, since the minimize behavior is application-specific).
 * Windows can also be linked to a WindowGroup or managed by the WindowManager to provide grouping, activation,
 * to front/back and other application-specific behavior.
 */
public class Window extends Panel {

    private static JavaScriptObject configPrototype;

    public static CloseAction CLOSE = new CloseAction("close");
    public static CloseAction HIDE = new CloseAction("hide");


    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Window();
        @com.gwtext.client.widgets.Window::configPrototype = c.initialConfig;
    }-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "window";
    }

    /**
     * Create a new Window.
     */
    public Window() {
    }

    /**
     * Create a new Window.
     *
     * @param title the title
     */
    public Window(String title) {
        setTitle(title);
    }

    /**
     * Create a new Window.
     *
     * @param title  the title
     * @param width  the width
     * @param height the height
     */
    public Window(String title, int width, int height) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Create a new Window.
     *
     * @param title     the title
     * @param modal     true for modal
     * @param resizable true for resizable
     */
    public Window(String title, boolean modal, boolean resizable) {
        setTitle(title);
        setModal(modal);
        setResizable(resizable);
    }

    /**
     * Create a new Window.
     *
     * @param title     the title
     * @param width  the width
     * @param height the height
     * @param modal     true for modal
     * @param resizable true for resizable
     */
    public Window(String title, int width, int height, boolean modal, boolean resizable) {
        setTitle(title);
        setWidth(width);
        setHeight(height);
        setModal(modal);
        setResizable(resizable);
    }

    public Window(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Window instance(JavaScriptObject jsObj) {
        return new Window(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Window(config);
    }-*/;

    /**
     * Aligns the window to the specified element.
     *
     * @param element  the element to align to
     * @param position the position to align to
     * @param offsetXY offset the positioning by [x, y]
     */
    public native void alignTo(Element element, String position, int[] offsetXY) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        w.alignTo(element, position, offsetXY);
    }-*/;

    /**
     * Anchors this window to another element and realigns it when the window is resized or scrolled.
     *
     * @param element  the element to anchor to
     * @param position the position to anchor to
     * @param offsetXY offset the positioning by [x, y]
     */
    public native void anchorTo(Element element, String position, int[] offsetXY) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        w.anchorTo(element, position, offsetXY);
    }-*/;

    /**
     * Centers this window in the viewport
     */
    public native void center() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.center();
    }-*/;

    /**
     * Closes the window, removes it from the DOM and destroys the window object.
     * The beforeclose event is fired before the close happens and will cancel the close action if it returns false.
     */
    public native void close() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.close();
    }-*/;

    /**
     * Focuses the window. If a defaultButton is set {@link Window#setDefaultButton(Element)}, it will receive focus,
     * otherwise the window itself will receive focus.
     */
    public native void focus() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.focus();
    }-*/;

    /**
     * Hides the window, setting it to invisible and applying negative offsets.
     */
    public native void hide() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.hide();
    }-*/;

    /**
     * Fits the window within its current container and automatically replaces the 'maximize' tool button with the 'restore' tool button.
     */
    public native void maximize() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.maximize();
    }-*/;

    /**
     * Placeholder method for minimizing the window. By default, this method simply fires the minimize event since the behavior of
     * minimizing a window is application-specific. To implement custom minimize behavior, either the minimize event can be handled
     * or this method can be overridden.
     */
    public native void minimize() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.minimize();
    }-*/;

    /**
     * Restores a maximized window back to its original size and position prior to being maximized and also replaces the 'restore'
     * tool button with the 'maximize' tool button.
     */
    public native void restore() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.restore();
    }-*/;

    /**
     * Makes this the active window by showing its shadow. This method also fires
     * the activate or deactivate event depending on which action occurred.
     */
    public native void setActive() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.setActive(true);
    }-*/;

    /**
     * Makes this the active window by showing its shadow, or deactivates it by hiding its shadow. This method also fires
     * the activate or deactivate event depending on which action occurred.
     *
     * @param active true to activate the window, false to deactivate it (defaults to false)
     */
    public native void setActive(boolean active) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.setActive(active);
    }-*/;

    /**
     * Shows the window, rendering it first if necessary, or activates it and brings it to front if hidden
     */
    public native void show() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.show();
    }-*/;

    /**
     * Shows the window, rendering it first if necessary, or activates it and brings it to front if hidden
     *
     * @param animationTargetID The target element id from which the window should animate while opening
     */
    public native void show(String animationTargetID) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.show(animationTargetID);
    }-*/;

    /**
     * Shows the window, rendering it first if necessary, or activates it and brings it to front if hidden
     *
     * @param animationTarget The target element from which the window should animate while opening
     */
    public native void show(Element animationTarget) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.show(animationTarget);
    }-*/;

    /**
     * Sends this window to the back of (lower z-index than) any other visible windows
     */
    public native void toBack() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.toBack();
    }-*/;

    /**
     * Brings this window to the front of any other visible windows
     */
    public native void toFront() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.toFront();
    }-*/;

    /**
     * A shortcut method for toggling between maximize and restore based on the current maximized state of the window.
     */
    public native void toggleMaximize() /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.toggleMaximize();
    }-*/;


    public native void addListener(WindowListener listener) /*-{
        this.@com.gwtext.client.widgets.Panel::addListener(Lcom/gwtext/client/widgets/event/PanelListener;)(listener);
        var windowJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('activate',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.WindowListener::onActivate(Lcom/gwtext/client/widgets/Window;)(windowJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('deactivate',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.WindowListener::onDeactivate(Lcom/gwtext/client/widgets/Window;)(windowJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('maximize',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.WindowListener::onMaximize(Lcom/gwtext/client/widgets/Window;)(windowJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('minimize',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.WindowListener::onMinimize(Lcom/gwtext/client/widgets/Window;)(windowJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('resize',
                function(source, width, height) {
                    if(width == null | width === undefined) width = 0;
                    if(height == null | height === undefined) height = 0;
                    listener.@com.gwtext.client.widgets.event.WindowListener::onResize(Lcom/gwtext/client/widgets/Window;II)(windowJ, width, height);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('restore',
                function(source) {
                    listener.@com.gwtext.client.widgets.event.WindowListener::onRestore(Lcom/gwtext/client/widgets/Window;)(windowJ);
                }
        );
    }-*/;
    // --- config properties ---

    /**
     * Id from which the window should animate while opening.
     *
     * @param animateTarget By default the id is set to null and there is no animation
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAnimateTarget(String animateTarget) throws IllegalStateException {
        setAttribute("animateTarget", animateTarget, true);
    }

    /**
     * Element from which the window should animate while opening.
     *
     * @param animateTarget By default the element is set to null and there is no animation.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAnimateTarget(Element animateTarget)  throws IllegalStateException {
        if (isRendered()) {
            setAnimateTargetRendered(animateTarget);
        } else {
            setAttribute("animateTarget", animateTarget, true);
        }
    }

    private native void setAnimateTargetRendered(Element animateTarget) /*-{
        var w = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        w.setAnimateTarget(animateTarget);
    }-*/;

    /**
     * The base CSS class to apply to this panel's element.
     *
     * @param baseCls Defaults to 'x-window'
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBaseCls(String baseCls) throws IllegalStateException {
        super.setBaseCls(baseCls);
    }

    /**
     * True to display the 'close' tool button and allow the user to close the window, false to hide the button
     * and disallow closing the window. The default value is true.
     *
     * @param closable true for closable
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setClosable(boolean closable) throws IllegalStateException {
        setAttribute("closable", closable, true);
    }

    /**
     * The action to take when the close button is clicked. The default action is {@link Window#CLOSE} which will actually
     * remove the window from the DOM and destroy it. The other valid option is {@link Window#HIDE} which will simply hide
     * the window by setting visibility to hidden and applying negative offsets, keeping the window available
     * to be redisplayed via the show method.
     * <p/>
     * <br><br>
     * <b>Note:</b> This property cannot be changed after the Component has been rendered.
     *
     * @param closeAction Defaults to CLOSE
     */
    public void setCloseAction(Window.CloseAction closeAction) {
        setAttribute("closeAction", closeAction.getCloseAction(), true);
    }

    /**
     * True to constrain the window to the viewport, false to allow it to fall outside of the viewport. Default value is false.
     * Optionally the header only can be constrained using  {@link Window#setConstrainHeader(boolean)}.
     *
     *
     * @param constrain Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setConstrain(boolean constrain) throws IllegalStateException {
        setAttribute("constrain", constrain, true);
    }

    /**
     * True to constrain the window to the viewport, false to allow it to fall outside of the viewport. Default value is false.
     * Optionally the header only can be constrained using  {@link Window#setConstrainHeader(boolean)}.
     *
     * @return  constrain Defaults to false
     */
    public boolean isConstrain() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "constrain");
    }


    /**
     * True to constrain the window header to the viewport, allowing the window body to fall outside of the viewport,
     * false to allow the header to fall outside the viewport. Optionally the entire window can be constrained
     * using constrain.
     *
     * @param constrainHeader Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setConstrainHeader(boolean constrainHeader) throws IllegalStateException {
        setAttribute("constrainHeader", constrainHeader, true);
    }

    /**
     * True to constrain the window header to the viewport, allowing the window body to fall outside of the viewport,
     * false to allow the header to fall outside the viewport. Optionally the entire window can be constrained
     * using constrain.
     *
     * @return  constrainHeader Defaults to false
     */
    public boolean isConstrainHeader() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "constrainHeader");
    }

    /**
     * The button that should focus when the window receives focus.
     *
     * @param buttonIndex the button index
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDefaultButton(int buttonIndex) throws IllegalStateException {
        setAttribute("defaultButton", buttonIndex, true);
    }

    /**
     * The button that should focus when the window receives focus.
     *
     * @param defaultButton the default button
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDefaultButton(String defaultButton) throws IllegalStateException {
        setAttribute("defaultButton", defaultButton, true);
    }

    /**
     * The button that should focus when the window receives focus.
     *
     * @param defaultButton the default button
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDefaultButton(Element defaultButton) throws IllegalStateException {
        setAttribute("defaultButton", defaultButton, true);
    }

    /**
     * True to allow the window to be dragged by the header bar, false to disable dragging.
     * Note that by default the window will be centered in the viewport, so if dragging is disabled the window
     * may need to be positioned programmatically after render (e.g., myWindow.setPosition(100, 100);).
     *
     * @param draggable Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDraggable(boolean draggable) throws IllegalStateException {
        setAttribute("draggable", draggable, true);
    }

    /**
     * True to allow the window to be dragged by the header bar, false to disable dragging.
     * Note that by default the window will be centered in the viewport, so if dragging is disabled the window
     * may need to be positioned programmatically after render (e.g., myWindow.setPosition(100, 100);).
     *
     * @return  draggable Defaults to true
     */
    public boolean isDraggable() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "draggable");
    }

    /**
     * True to always expand the window when it is displayed, false to keep it in its current state (which may be collapsed) when displayed
     *
     * @param expandOnShow Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setExpandOnShow(boolean expandOnShow) throws IllegalStateException {
        setAttribute("expandOnShow", expandOnShow, true);
    }

    /**
     * True to always expand the window when it is displayed, false to keep it in its current state (which may be collapsed) when displayed.
     *
     * @return expandOnShow Defaults to true
     */
    public int getExpandOnShow() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "expandOnShow");
    }

    /**
     * A reference to the WindowGroup that should manage this window (defaults to {@link WindowMgr}).
     * @param manager the window manager
     */
    public void setManager(WindowGroup manager) {
        setAttribute("manager", manager.getJsObj(), true);
    }

    public WindowGroup getManager() {
        JavaScriptObject manager = getAttributeAsJavaScriptObject("manager");
        return new WindowGroup(manager);
    }

    public boolean isMaximized() {
        if(!isCreated()) {
            return false;
        } else {
            return getAttributeAsBoolean("maximized");
        }
    }

    /**
     * True to display the 'maximize' tool button and allow the user to maximize the window, false to hide the button
     * and disallow maximizing the window. Note that when a window is maximized, the tool button
     * will automatically change to a 'restore' button with the appropriate behavior already built-in that will restore
     * the window to its previous size.
     *
     * @param maximizable Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaximizable(boolean maximizable) throws IllegalStateException {
        setAttribute("maximizable", maximizable, true);
    }

    /**
     * True to display the 'maximize' tool button and allow the user to maximize the window, false to hide the button
     * and disallow maximizing the window. Note that when a window is maximized, the tool button
     * will automatically change to a 'restore' button with the appropriate behavior already built-in that will restore
     * the window to its previous size.
     *
     * @return  maximizable Defaults to false
     */
    public boolean isMaximizable() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "maximizable");
    }

    /**
     * The minimum height in pixels allowed for this window. Only applies when resizable = true.
     *
     * @param minHeight Defaults to 100 pixels
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinHeight(int minHeight) throws IllegalStateException {
        setAttribute("minHeight", minHeight, true);
    }

    /**
     * The minimum height in pixels allowed for this window. Only applies when resizable = true.
     *
     * @return  the minHeight Defaults to 100 pixels
     */
    public int getMinHeight() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "minHeight");
    }


    /**
     * The minimum width in pixels allowed for this window. Only applies when resizable = true.
     *
     * @param minWidth Defaults to 200 pixels
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinWidth(int minWidth) throws IllegalStateException {
        setAttribute("minWidth", minWidth, true);
    }

    /**
     * The minimum width in pixels allowed for this window. Only applies when resizable = true.
     *
     * @return the min width (Defaults to 200 pixels)
     */
    public int getMinWidth() {
        return JavaScriptObjectHelper.getAttributeAsInt(config, "minWidth");
    }

    /**
     * True to display the 'minimize' tool button and allow the user to minimize the window, false to hide the button
     * and disallow minimizing the window. Note that this button provides no implementation --
     * the behavior of minimizing a window is implementation-specific, so the minimize event must be handled and a custom
     * minimize behavior implemented for this option to be useful.
     *
     * @param minimizable Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinimizable(boolean minimizable) throws IllegalStateException {
        setAttribute("minimizable", minimizable, true);
    }

    /**
     * True to make the window modal and mask everything behind it when displayed, false to display it without
     * restricting access to other UI elements.
     *
     * @param modal Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setModal(boolean modal) throws IllegalStateException {
        setAttribute("modal", modal, true);
    }

    /**
     * True to make the window modal and mask everything behind it when displayed, false to display it without
     * restricting access to other UI elements.
     *
     * @return true if modal
     */
    public boolean isModal() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "modal");
    }

    /**
     * True to render the window body with a transparent background so that it will blend into the framing elements,
     * false to add a lighter background color to visually highlight the body element and separate it more distinctly
     * from the surrounding frame.
     *
     * @param plain Defaults to false
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPlain(boolean plain) throws IllegalStateException {
        setAttribute("plain", plain, true);
    }

    /**
     * True to render the window body with a transparent background so that it will blend into the framing elements,
     * false to add a lighter background color to visually highlight the body element and separate it more distinctly
     * from the surrounding frame.
     *
     * @return true if plain
     */
    public boolean isPlain() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "plain");
    }

    /**
     * True to allow user resizing at each edge and corner of the window, false to disable resizing.
     *
     * @param resizable Defaults to true
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setResizable(boolean resizable) throws IllegalStateException {
        setAttribute("resizable", resizable, true);
    }

    /**
     * True to allow user resizing at each edge and corner of the window, false to disable resizing.
     *
     * @return true to allow user resizing at each edge and corner of the window, false to disable resizing.
     */
    public boolean isResizable() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(config, "resizable");
    }

    /**
     * A valid  {@link Resizable} handles config string. Only applies when resizable = true.
     *
     * @param resizeHandles Defaults to {@link Resizable#ALL}
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setResizeHandles(String resizeHandles) throws IllegalStateException {
        setAttribute("resizeHandles", resizeHandles, true);
    }

    /**
     * The {@link Resizable} handles config string. Only applies when resizable = true.
     *
     * @return the resizable config string
     */
    public String getResizeHandles() {
        return JavaScriptObjectHelper.getAttribute(config, "resizeHandles");
    }


    public static class CloseAction {
        private String closeAction;

        private CloseAction(String closeAction) {
            this.closeAction = closeAction;
        }

        public String getCloseAction() {
            return closeAction;
        }
    }
}


