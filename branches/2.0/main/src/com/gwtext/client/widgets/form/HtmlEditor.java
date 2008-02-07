/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.form.event.HtmlEditorListener;

/**
 * Provides a lightweight HTML Editor component.
 * <p/>
 * Note: The focus/blur and validation marking functionality inherited from {@link Field} is NOT supported by this editor.
 * <br/><br/>
 * An Editor is a sensitive component that can't be used in all spots standard fields can be used. Putting an Editor within any element that has display set to 'none' can cause problems in Safari and Firefox.
 * <br/> <br/>
 * <p/>
 * There can only be one HtmlEditor on a page at a time.
 */
public class HtmlEditor extends Field {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
		var c = new $wnd.Ext.form.HtmlEditor();
		@com.gwtext.client.widgets.form.HtmlEditor::configPrototype = c.initialConfig;
	}-*/;

	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "htmleditor";
	}

	public HtmlEditor(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public HtmlEditor() {
	}

    public HtmlEditor(String fieldLabel) {
        super(fieldLabel);
    }

	public HtmlEditor(String fieldLabel, String name) {
		super(fieldLabel, name);
	}

	public HtmlEditor(String fieldLabel, String name, int width) {
		super(fieldLabel, name, width);
	}

	protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.HtmlEditor(jsObj);
    }-*/;

	/**
	 * Executes a Midas editor command directly on the editor document. For visual commands, you should use relayCmd instead. This should only be called after the editor is initialized.
	 *
	 * @param cmd   the Midas command
	 * @param value the value to pass to the command
	 */
	public native void execCmd(String cmd, String value) /*-{
        var he = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        he.execCmd(cmd, value);
    }-*/;

	/**
	 * Returns the editor's toolbar. This is only available after the editor has been rendered.
	 *
	 * @return toolbar
	 */
	public Toolbar getToolbar() {
		return new Toolbar(getToolbar(getOrCreateJsObj()));
	}

	private native JavaScriptObject getToolbar(JavaScriptObject he) /*-{
        return he.getToolbar();    
    }-*/;

	/**
	 * Inserts the passed text at the current cursor position. Note: the editor must be initialized and activated to insert text.
	 *
	 * @param text the text to insert
	 */
	public native void insertAtCursor(String text) /*-{
        var he = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        he.insertAtCursor(text);
    }-*/;

	/**
	 * Executes a Midas editor command on the editor document and performs necessary focus and toolbar updates. This should only be called after the editor is initialized.
	 *
	 * @param cmd   the Midas command
	 * @param value the value to pass to the command
	 */
	public native void relayCmd(String cmd, String value) /*-{
        var he = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        he.relayCmd(cmd, value);
    }-*/;

	/**
	 * Toggles the editor between standard and source edit mode.
	 *
	 * @param sourceEdit true for source edit, false for standard
	 */
	public native void toggleSourceEdit(boolean sourceEdit) /*-{
        var he = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        he.toggleSourceEdit(sourceEdit);
    }-*/;

	/**
	 * Adds a HtmlEditor listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(HtmlEditorListener listener) /*-{
        this.@com.gwtext.client.widgets.form.Field::addListener(Lcom/gwtext/client/widgets/form/event/FieldListener;)(listener);
        var fieldJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('activate',
                function(fld) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onActivate(Lcom/gwtext/client/widgets/form/HtmlEditor;)(fieldJ);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforepush',
                function(fld, html) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::doBeforePush(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('beforesync',
                function(fld, html) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::doBeforeSync(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('editmodechange',
                function(fld, sourceEdit) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onEditModeChange(Lcom/gwtext/client/widgets/form/HtmlEditor;Z)(fieldJ, sourceEdit);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('initialize',
               function(fld) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onInitialize(Lcom/gwtext/client/widgets/form/HtmlEditor;)(fieldJ);
                }
        );
    
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('push',
              function(fld, html) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onPush(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('sync',
                function(fld, html) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onSync(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );
    
    }-*/;

	// --- config properties ---


	/**
	 * The default text for the create link prompt.
	 *
	 * @param createLinkText link text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setCreateLinkText(String createLinkText) throws IllegalStateException {
		setAttribute("createLinkText", createLinkText, true);
	}

	/**
	 * The default value for the create link prompt (defaults to http:/ /).
	 *
	 * @param defaultLinkValue link value
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDefaultLinkValue(String defaultLinkValue) throws IllegalStateException {
		setAttribute("defaultLinkValue", defaultLinkValue, true);
	}

	/**
	 * Enable the left, center, right alignment buttons (defaults to true).
	 *
	 * @param enableAlignments true to enable alignments
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableAlignments(boolean enableAlignments) throws IllegalStateException {
		setAttribute("enableAlignments", enableAlignments, true);
	}

	/**
	 * Enable the fore/highlight color buttons (defaults to true).
	 *
	 * @param enableColors true to enable colors
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableColors(boolean enableColors) throws IllegalStateException {
		setAttribute("enableColors", enableColors, true);
	}

	/**
	 * Enable font selection. Not available in Safari. (defaults to true).
	 *
	 * @param enableFont true to enable fonr selection
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableFont(boolean enableFont) throws IllegalStateException {
		setAttribute("enableFont", enableFont, true);
	}

	/**
	 * Enable the increase/decrease font size buttons (defaults to true).
	 *
	 * @param enableFontSize true to enable font size buttons
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableFontSize(boolean enableFontSize) throws IllegalStateException {
		setAttribute("enableFontSize", enableFontSize, true);
	}

	/**
	 * Enable the create link button. Not available in Safari. (defaults to true).
	 *
	 * @param enableLinks true to enable links
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableLinks(boolean enableLinks) throws IllegalStateException {
		setAttribute("enableLinks", enableLinks, true);
	}

	/**
	 * Enable the bullet and numbered list buttons. Not available in Safari. (defaults to true).
	 *
	 * @param enableLists true to enable lists
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableLists(boolean enableLists) throws IllegalStateException {
		setAttribute("enableLists", enableLists, true);
	}

	/**
	 * Enable the switch to source edit button. Not available in Safari. (defaults to true)
	 *
	 * @param enableSourceEdit true to enable source edit
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setEnableSourceEdit(boolean enableSourceEdit) throws IllegalStateException {
		setAttribute("enableSourceEdit", enableSourceEdit, true);
	}

	/**
	 * An array of available font families.
	 *
	 * @param fontFamilies the font families
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setFontFamilies(String[] fontFamilies) throws IllegalStateException {
		setAttribute("fontFamilies", JavaScriptObjectHelper.convertToJavaScriptArray(fontFamilies), true);
	}

	/**
	 * Set the height of the HtmlEditor.
	 *
	 * @param height the feild height
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHeight(int height) throws IllegalStateException {
		setAttribute("height", height, true);
	}
}
