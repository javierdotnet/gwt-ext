/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Template;
import com.gwtext.client.util.ClickRepeaterConfig;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.menu.Menu;

/**
 * Simple Button class.
 */
public class Button extends Component {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Button();
        @com.gwtext.client.widgets.Button::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	/**
	 * Create a new Button.
	 */
	public Button() {
    }

	/**
	 * Create a new Button
	 *
	 * @param text the button label
	 */
	public Button(String text) {
        if (text != null) setText(text);
    }

    /**
     * Create a new Button.
     *
     * @param text the Button label
     * @param menu the Button menu
     */
    public Button(String text, Menu menu) {
        if (text != null) setText(text);
        setMenu(menu);
    }

    /**
	 * Create a new Button.
	 *
	 * @param text the button label
	 * @param listener the Button listener.
	 * @see  com.gwtext.client.widgets.event.ButtonListenerAdapter
	 */
	public Button(String text, ButtonListener listener) {
        if (text != null) setText(text);
		addListener(listener);
	}

    /**
	 * Create a new Button.
	 *
	 * @param text the button label
	 * @param listener the Button listener
     * @param icon the button icon
	 * @see  com.gwtext.client.widgets.event.ButtonListenerAdapter
     * @see #setIcon(String)
	 */
    public Button(String text, ButtonListener listener, String icon) {
        if (text != null) setText(text);
        if(icon != null) setIcon(icon);
        if(listener != null) addListener(listener);

        if(text == null && icon != null) {
            setCls("x-btn-icon");
        } else {
            setCls("x-btn-text-icon");
        }
    }

    public Button(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Button instance(JavaScriptObject jsObj) {
        return new Button(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Button(config);
    }-*/;

    /**
     * Returns true if button is disabled.
     *
     * @return true if disabled
     */
    public boolean isDisabled() {
        return super.isDisabled();
    }

    /**
     * Focus the button.
     */
    public void focus(){
        super.focus();
    }

    /**
     * Gets the text of this button.
     *
     * @return the button text, null if not set
     */
    private native String getRenderedText() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var text = button.getText();
        return text === undefined ? null : text;
    }-*/;

    /**
     * An Ext Button consists of a table that wraps a button element. This method returns the underlying
     * Button element.
     * <br>
     * <b>Note:</b> This method should be called only after the Button has been Rendered.
	 *
     * @return the Button Element
     */
    public native Element getButtonElement() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var but = button.el.child('button:first').dom;
        return but;
    }-*/;

    /**
     * The Button's owner Panel, null before rendered.
     *
     * @return the Button's owner Panel, null before rendered.
     */
    public Panel getOwnerCt() {
        if(!isRendered()) {
            return null;
        } else {
            return getOwnerCtRendered();
        }
    }

   private native Panel getOwnerCtRendered() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var panel = button.ownerCt;
        return panel == null || panel === undefined ? null : @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
    }-*/;

    /**
     * Returns true if the button has a menu and it is visible.
     *
     * @return true if menu visible
     */
    public native boolean hasVisibleMenu() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getJsObj()();
		if(button == null) return false;
		return button.hasVisibleMenu();
    }-*/;

    /**
     * Hide this button's menu (if it has one).
     */
    public native void hideMenu() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(button != null) button.hideMenu();
    }-*/;

    /**
     * Sets this button's text.
     *
     * @param text the text
     */
    private native void setRenderedText(String text) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        button.setText(text);
    }-*/;

    /**
     * Show this button's menu (if it has one).
     */
    public native void showMenu() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(button != null) button.showMenu();
    }-*/;

    /**
     * Toggle the current state.
     */
    public void toggle() {
        if(!isRendered()) {
            setPressed(!isPressed());
        } else {
            toggleRendered();
        }
    }

    private native void toggleRendered() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(button != null) button.toggle();
    }-*/;

    /**
     * Toggle the button to the passed state.
     *
     * @param state true to toggle pressed
     */
    public void toggle(boolean state) {
        if(!isRendered()) {
            setPressed(state);
        } else {
            toggleRendered(state);
        }
    }

    private native void toggleRendered(boolean state) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getJsObj()();
        if(button != null) button.toggle(state);
    }-*/;

    /**
     * Sets the Button's tooltip.
     * 
     * @param tooltip Button's toolip
     */
    private native void setRenderedTooltip(String tooltip) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var but = button.el.child('button:first').dom;
        but.qtip = tooltip;
    }-*/;

    /**
     * Add a Button listener.
     *
     * @param listener the listener
     */
    public native void addListener(ButtonListener listener) /*-{
        this.@com.gwtext.client.widgets.Component::addListener(Lcom/gwtext/client/widgets/event/ComponentListener;)(listener);
        var buttonJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
                function(source, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onClick(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('menuhide',
                function(source, menu) {
                    var menuJ = @com.gwtext.client.widgets.menu.Menu::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMenuHide(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/widgets/menu/Menu;)(buttonJ, menuJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('menushow',
                function(source, menu) {
                    var menuJ = @com.gwtext.client.widgets.menu.Menu::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMenuShow(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/widgets/menu/Menu;)(buttonJ, menuJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('menutriggerout',
                function(source, menu, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    var menuJ = @com.gwtext.client.widgets.menu.Menu::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMenuTriggerOut(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/widgets/menu/Menu;Lcom/gwtext/client/core/EventObject;)(buttonJ, menuJ, e);
                }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('menutriggerover',
                function(source, menu, event) {
                    var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    var menuJ = @com.gwtext.client.widgets.menu.Menu::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(menu);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMenuTriggerOver(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/widgets/menu/Menu;Lcom/gwtext/client/core/EventObject;)(buttonJ, menuJ, e);
                }
        );    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseout',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMouseOut(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseover',
                function(source, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onMouseOver(Lcom/gwtext/client/widgets/Button;Lcom/gwtext/client/core/EventObject;)(buttonJ, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('toggle',
                function(source,pressed) {
                    listener.@com.gwtext.client.widgets.event.ButtonListener::onToggle(Lcom/gwtext/client/widgets/Button;Z)(buttonJ, pressed);
                }
        );
    }-*/;


    // --- config properties ---
    public String getXType() {
        return "button";
    }

    /**
     * The type of event to map to the button's event handler (defaults to 'click')
     *
     * @param clickEvent the click event
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setClickEvent(String clickEvent) throws IllegalStateException {
        setAttribute("clickEvent", clickEvent, true);
    }

    /**
     * @return the type of event to map to the button's event handler (defaults to 'click')
     */
    public String getClickEvent() {
        return getAttribute("clickEvent");
    }

    /**
     * True to enable pressed/not pressed toggling (defaults to false).
     *
     * @param enableToggle true to enable toggle
     */
    public void setEnableToggle(boolean enableToggle) {		
		if(isRendered()) {
            toggle(enableToggle);
        } else {
			setAttribute("enableToggle", enableToggle, true);
		}
    }

    /**
     * @return true if toggle enabled
     */
    public boolean isEnableToggle() {
        return getAttributeAsBoolean("enableToggle");
    }

    /**
     * You can bind your form buttons to the valid state of the form. Note: the Form's monitorValid config must be set to true.
     * To bind a button(s) enabled state to the valid state set this property to true.
     *
     * @param bindToForm to to bind to form's valid state
     */
    public void setFormBind(boolean bindToForm) {
       setAttribute("formBind", bindToForm, true);
    }

    /**
     * @return true if bind to form is enabled
     */
    public boolean getBindToForm() {
        return getAttributeAsBoolean("formBind");
    }

	/**
     * False to disable visual cues on mouseover, mouseout and mousedown (defaults to true).
     *
     * @param handleMouseEvents false to diable visual cues
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHandleMouseEvents(boolean handleMouseEvents) throws IllegalStateException {
        setAttribute("handleMouseEvents", handleMouseEvents, true);
    }

    /**
     * False to disable visual cues on mouseover, mouseout and mousedown (defaults to true).
     *
     * @return true if visual cues on mouseover, mouseout and mousedown are enabled
     */
    public boolean getHandleMouseEvents()  {
        return getAttributeAsBoolean("handleMouseEvents");
    }

    /**
     * True to start hidden or hide rendered button (defaults to false).
     *
     * @param hidden true for hidden
     */
    public void setHidden(boolean hidden) {
		if(!isRendered()) {
			setAttribute("hidden", hidden, true);
		} else {
			hide();
		}
    }

    //TODO doesnt seem to be working for toolbar menu button
    /**
     * The path to an image to display in the button (the image will be set as the background-image CSS property of the
     * button by default, so if you want a mixed icon/text button, set cls:"x-btn-text-icon")
     *
     * @param icon the icon
     */
    public void setIcon(String icon) {
		if(!isRendered()) {
			setAttribute("icon", icon, true);
		} else {
            Element buttonEl = getButtonElement();
            DOM.setStyleAttribute(buttonEl, "backgroundImage", "url(" + icon + ")");
        }
		if(getText() == null) {
			addClass("x-btn-icon");
		} else {
			addClass("x-btn-text-icon");
		}
	}

    /**
     * @return the path of the Button icon image
     */
    public String getIcon() {
        return getAttribute("icon");
    }

    /**
     * A css class which sets a background image to be used as the icon for this button (defaults to undefined).
     *
     * @param iconCls the icon CSS class
     */
    public void setIconCls(String iconCls) {
        if(isCreated()) {
            if(getCls() == null){
                addClass(getText() != null ? "x-btn-text-icon" : "x-btn-icon");
            }
            setIconClsCreated(iconCls);
        } else {
            setAttribute("iconCls", iconCls, false);
        }
    }

    private native void setIconClsCreated(String iconCls) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return button.setIconClass(iconCls);
    }-*/;

    /**
     * @return the icon CSS class for this Button
     */
    public String getIconCls() {
        return getAttribute("iconCls");
    }

    /**
     * Assign a button menu.
     *
     * @param menu the button menu
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMenu(Menu menu) throws IllegalStateException {
        setAttribute("menu", menu.getOrCreateJsObj(), false);
    }

    /**
     * The position to align the menu to. Defaults to tl-bl?
     *
     * @param anchorPosition the element's anchor position
     */
    public void setMenuAlign(String anchorPosition) {
        setAttribute("menuAlign", anchorPosition, true, true);
    }

    /**
     * The position to align the menu to. Defaults to tl-bl?
     *
     * @return the position to align the menu to
     */
    public String getMenuAlign() {
        return getAttribute("menuAlign");
    }

    /**
     * The minimum width for this button.
     *
     * @param minWidth the min width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinWidth(int minWidth) throws IllegalStateException {
        setAttribute("minWidth", minWidth, true);
    }

    /**
     * The minimum width for this button.
     *
     * @return the Button min width
     */
    public int getMinWidth() {
        return getAttributeAsInt("minWidth");
    }

    /**
     * True to start pressed (only if enableToggle = true).
     *
     * @param pressed true for pressed
     */
    public void setPressed(boolean pressed) {
        if(!isRendered()) {
            setAttribute("pressed", pressed, true);
        } else {
            toggle(pressed);
        }
    }

    /**
     * True if the Button is pressed.
     *
     * @return true if start Button pressed (only if enableToggle = true)
     * @see #toggle(boolean)
     */
    public boolean isPressed() {
        return getAttributeAsBoolean("pressed");
    }

    /**
     * True to repeat fire the click event while the mouse is down. (defaults to false).
     *
     * @param repeat true to repeat
     */
    public void setRepeat(boolean repeat) {
        setAttribute("repeat", repeat, true);
    }

    /**
     * @return true to repeat fire the click event while the mouse is down
     */
    public native boolean isRepeat() /*-{
        var config = this.@com.gwtext.client.widgets.Component::config;
        return config['repeat'] != null && config['repeat'] !== undefined; 
    }-*/;

    /**
     * Fire click event when mouse is down.
     *
     * @param qconfig the click repeat configuration
     */
    public void setRepeat(ClickRepeaterConfig qconfig) {
        setAttribute("repeat", qconfig.getJsObj(), true);
    }

    /**
     * Set a DOM tabIndex for this button.
     *
     * @param tabIndex the tab index
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTabIndex(int tabIndex) throws IllegalStateException {
        setAttribute("tabIndex", tabIndex, true);
    }

    /**
     * @return the tab index, 0 if undefined
     */
    public int getTabIndex() {
        return getAttributeAsInt("tabIndex");
    }

    //TODO inconsistent since others use autoCreate with template overridden?
    /**
     * A {@link Template} with which to create the Button's main element. This Template must
     * contain numeric substitution parameter 0 if it is to display the text property. Changing the template could
     * require code modifications if required elements (e.g. a button) aren't present.
     *
     * The defaut tempalte is
     *
     * <pre>
     * <code>
     *
     * &lt;table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"&gt;&lt;tbody&gt;&lt;tr&gt;
     *   &lt;td class="x-btn-left"&gt;&lt;i&gt;&#160;&lt;/i&gt;&lt;/td&gt;&lt;td class="x-btn-center"&gt;&lt;em unselectable="on"&gt;&lt;button class="x-btn-text" type="{1}"&gt;{0}&lt;/button&gt;&lt;/em&gt;&lt;/td&gt;&lt;td class="x-btn-right"&gt;&lt;i&gt;&#160;&lt;/i&gt;&lt;/td&gt;
     * &lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;
     * </code>
     * </pre>
     * @param template the button template
     */
    public void setTemplate(Template template) {
        setAttribute("template", template.getJsObj(), true);
    }

    /**
     * The button text.
     *
     * @param text the buttons text
     */
    public void setText(String text) {
        if(isRendered()) {
            setRenderedText(text);
        } else {
        	setAttribute("text", text, true);
		}
	}

    /**
     * @return the Button's text
     */
    public String getText() {
        if(isRendered()) {
            return getRenderedText();
        } else {
            return getAttribute("text");
        }
    }

    /**
     * The group this toggle button is a member of (only 1 per group can be pressed, only applies if enableToggle = true).
     *
     * @param toggleGroup the button's toggle group
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setToggleGroup(String toggleGroup) throws IllegalStateException {
        setAttribute("toggleGroup", toggleGroup, true);
		setEnableToggle(true);
	}

    /**
     * @return the Button's toggle group
     */
    public String getToggleGroup() {
        return getAttribute("toggleGroup");
    }

    /**
     *  The tooltip for the button.
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        if(isRendered()) {
            setRenderedTooltip(tooltip);
        } else {
            setAttribute("tooltip", tooltip, true);
        }
    }

    /**
     * @return the Button tooltip
     */
    public String getTooltip() {
        return getAttribute("tooltip");
    }


    /**
     *  The tooltip for the button.
     *
     * @param title the tootlip title
     * @param text the tootlip text
     */
    public void setTooltip(final String title, final String text) {
        setAttribute("tooltip", new QuickTipsConfig() {
            {
                setTitle(title);
                setText(text);
            }
        }.getJsObj(), true);
    }

    /**
     * The tooltip for the button.
     *
     * @param qtipConfig the tooltip config
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTooltip(QuickTipsConfig qtipConfig) throws IllegalStateException {
        setAttribute("tooltip", qtipConfig.getJsObj(), true);
    }

    /**
     * The type of tooltip to use.
     *
     * @param quickTip true for quicktips, false for the "title" attribute.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTooltipType(boolean quickTip) throws IllegalStateException {
        if(quickTip){
            setAttribute("tooltipType", "qtip", true);
        } else {
            setAttribute("tooltipType", "title", true);
        }
    }

    /**
     * The type of tooltip to use.
     *
     * @return the tooltip type
     */
    public String getTooltipType() {
        return getAttribute("tooltipType");
    }


    /**
     * The button's type, corresponding to the DOM input element type attribute. Either "submit," "reset" or "button" (default).
     *
     * @param type the button type
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setType(String type) throws IllegalStateException {
        setAttribute("type", type, true);
    }

    /**
     * The button's type, corresponding to the DOM input element type attribute. Either "submit," "reset" or "button" (default).
     *
     * @return the Button type
     */
    public String getType() {
        return getAttribute("type");
    }
}
