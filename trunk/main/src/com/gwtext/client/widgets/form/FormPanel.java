package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Reader;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.QuickTips;
import com.gwtext.client.widgets.form.event.FormListener;
import com.gwtext.client.widgets.form.event.FormPanelListener;

/**
 * FormPanel uses a {@link com.gwtext.client.widgets.layout.FormLayout} internally, and that is required for fields and labels
 * to work correctly within the FormPanel's layout. To nest additional layout styles within a FormPanel, you should nest
 * additional Panels or other containers that can provide additional layout functionality. <b>You should not override FormPanel's layout.</b> 
 */
public class FormPanel extends Panel {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

    private static void init() {
        QuickTips.init();
        Field.setMsgTarget("side");
        doInit();
    }

    private static native void doInit()/*-{
			var c = new $wnd.Ext.form.FormPanel();
			@com.gwtext.client.widgets.form.FormPanel::configPrototype = c.initialConfig;
		}-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

	public String getXType() {
		return "form";
	}

	/**
	 * Create a new FormPanel.
	 */
	public FormPanel() {
	}

	protected void initComponent() {
		super.initComponent();
		if (!GWT.isScript()) {
			Component[] items = getItems();
			if(items.length == 0) {
				error("FormPanel must contain atleast one field.");
			}
		}
	}

	/**
	 * Create a new FormPanel.
	 *
	 * @param labelAlign the label alignment
	 */
	public FormPanel(Position labelAlign) {
        setLabelAlign(labelAlign);
    }

    public FormPanel(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.form.FormPanel(config);
    }-*/;

	/**
	 * Starts monitoring of the valid state of this form. Usually this is done by passing the config option
	 * "monitorValid"
	 */
	public native void startMonitoring() /*-{
        var formPanel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        formPanel.startMonitoring();
    }-*/;

	/**
	 * Stops monitoring of the valid state of this form.
	 */
	public native void stopMonitoring() /*-{
        var formPanel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        formPanel.stopMonitoring();
    }-*/;

	/**
	 * Provides access to the Form which this Panel contains. Note that this method must be called only after the FormPanel has been
	 * rendered. <b>Returns null if called before the FormPanel has been rendered.</b>. If you need to add a listener to he form prior to
     * the FormPanel being rendered, call {@link #addFormListener(com.gwtext.client.widgets.form.event.FormListener)} instead.
	 *
	 * @return the underlying Form, or null if FormPanel not rendered
	 */
	public native Form getForm() /*-{
        var formPanel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var formJS = formPanel.getForm();
		return @com.gwtext.client.widgets.form.Form::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(formJS);
	}-*/;


    /**
     * Add a Form listener. Although you can add this listener on the {@link com.gwtext.client.widgets.form.Form}
     * directly, this method is useful to call when you would like to add a FormListener prior to the FormPaanel being rendered.
     *
     * @param listener the form listener
     */
    public void addFormListener(final FormListener listener) {
        if(!isRendered()) {
            addListener("render", new Function() {
                public void execute() {
                    addFormListener(listener);
                }
            });
        } else {
            getForm().addListener(listener);
        }
    }

	/**
	 * Add a Form Panel Listener.
	 *
	 * @param listener the listener
	 */
	public native void addListener(FormPanelListener listener) /*-{
        this.@com.gwtext.client.widgets.Panel::addListener(Lcom/gwtext/client/widgets/event/PanelListener;)(listener);
        var formPanelJ = this;

       this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('clientvalidation',
                function(form, valid) {
					var v = valid == null | valid === undefined ? false : valid;
					listener.@com.gwtext.client.widgets.form.event.FormPanelListener::onClientValidation(Lcom/gwtext/client/widgets/form/FormPanel;Z)(formPanelJ, v);
                }
        );
    }-*/;

	// -- config properties ---

	//http://extjs.com/forum/showthread.php?t=4814&highlight=doAction
	//acts like hidden form fields
	/**
	 * Parameters to pass with all requests. This effectively acts like Form hidden fields.
	 *
	 * @param params the base params
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setBaseParams(UrlParam[] params) throws IllegalStateException {
		JavaScriptObject paramObj = UrlParam.getJsObj(params);
		setAttribute("baseParams", paramObj, true);
	}

	/**
	 * Valid values are "left," "center" and "right" (defaults to "center").
	 *
	 * @param buttonAlign form button position
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setButtonAlign(Position buttonAlign) throws IllegalStateException {
		setAttribute("buttonAlign", buttonAlign.getPosition(), true);
	}

	/**
	 * A {@link com.gwtext.client.data.Reader} (e.g. {@link com.gwtext.client.data.XmlReader}) to be used to read data when reading validation errors on "submit" actions.
	 * This is completely optional as there is built-in support for processing JSON. The default JSON error reader expects the return value to be in the format
     *
     * <pre>
     * <code>
     * {"success":false,"errors":[{"id":"email","msg":"Already exists"}, {"id":"username","msg":"Already taken"}]}
     * </code></pre>
     *
     * If the response is in XML format, one can set an XMLReader.
     * <pre><code>
     * //setup error reader to process from submit response from server
     * RecordDef errorRecordDef = new RecordDef(new FieldDef[]{
     *     new StringFieldDef("id"),
     *     new StringFieldDef("msg")
     * });
     *
     * XmlReader errorReader = new XmlReader("field", errorRecordDef);
     * errorReader.setSuccess("@success");
     * </code></pre>
     * and the corresponding XML return value must be in the format :
     * <pre></code>
     * &lt;response success="false"&gt;
     *     &lt;errors&gt;
     *         &lt;field&gt;
     *             &lt;id&gt;email&lt;/id&gt;
     *             &lt;msg&gt;&lt;![CDATA[
     *             Invalid email. &lt;br /&gt;&lt;i&gt;Already exists &lt;/i&gt;
     *          ]]&gt;&lt;/msg&gt;
     *         &lt;/field&gt;
     *         &lt;field&gt;
     *             &lt;id&gt;username&lt;/id&gt;
     *             &lt;msg&gt;&lt;![CDATA[
     *             Invalid Username. &lt;br /&gt;&lt;i&gt;Already taken &lt;/i&gt;
     *          ]]&gt;&lt;/msg&gt;
     *         &lt;/field&gt;
     *     &lt;/errors&gt;
     * &lt;/response&gt;
     * </code></pre>

     * @param errorReader the error reader
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setErrorReader(Reader errorReader) throws IllegalStateException {
		setAttribute("errorReader", errorReader.getJsObj(), true);
	}

	/**
	 * Set true if this form is a file upload.
	 *
	 *
	 * @param fileUpload true if file upload
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setFileUpload(boolean fileUpload) throws IllegalStateException {
		setAttribute("fileUpload", fileUpload, true);
	}

	//http://extjs.com/forum/archive/index.php/t-7316.html
	/**
	 * Set to true to hide all field labels.
	 *
	 * @param hideLabels true to hide field labels
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setHideLabels(boolean hideLabels) throws IllegalStateException {
		setAttribute("hideLabels", hideLabels, true);
	}

	/**
	 * A CSS class to apply to the x-form-item of fields. This property cascades to child containers.
	 *
	 * @param itemCls CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setItemCls(String itemCls) throws IllegalStateException {
		setAttribute("itemCls", itemCls, true);
	}

	/**
	 * Valid values are "left," "top" and "right" (defaults to "left"). This property cascades to child containers if not set.
	 *
	 * @param labelAlign label alignment
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLabelAlign(Position labelAlign) throws IllegalStateException {
		setAttribute("labelAlign", labelAlign.getPosition(), true);
	}

	/**
	 * The width of labels. This property cascades to child containers.
	 *
	 * @param labelWidth the label width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setLabelWidth(int labelWidth) throws IllegalStateException {
		setAttribute("labelWidth", labelWidth, true);
	}

	/**
	 * The request method to use (GET or POST) for form actions if one isn't supplied in the action options.
	 *
	 * @param method the request method
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setMethod(Connection.Method method) throws IllegalStateException {
		setAttribute("method", method.getMethod(), true);
	}

	/**
	 * Minimum width of all buttons in pixels (defaults to 75).
	 *
	 * @param minButtonWidth min button width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setMinButtonWidth(int minButtonWidth) throws IllegalStateException {
		setAttribute("minButtonWidth", minButtonWidth, true);
	}

	/**
	 * The milliseconds to poll valid state, ignored if monitorValid is not true (defaults to 200).
	 *
	 * @param monitorPoll the monitor poll in milliseconds
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setMonitorPoll(int monitorPoll) throws IllegalStateException {
		setAttribute("monitorPoll", monitorPoll, true);
	}

	//http://extjs.com/forum/showthread.php?t=5108&highlight=formBind
	/**
	 * If true the form monitors its valid state client-side and fires a looping event with that state. This is required
	 * to bind buttons to the valid state using the config value formBind:true on the button.
	 *
	 * @param monitorValid true to enable monitoring
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setMonitorValid(boolean monitorValid) throws IllegalStateException {
		setAttribute("monitorValid", monitorValid, true);
	}

	/**
	 * A {@link Reader} (e.g. {@link com.gwtext.client.data.XmlReader}) to be used to read data when executing "load" actions.
	 * This is optional as there is built-in support for processing JSON.
	 *
	 * @param reader the load Reader
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setReader(Reader reader) throws IllegalStateException {
		setAttribute("reader", reader.getJsObj(), true);
	}

	/**
	 * Timeout for form actions in seconds (default is 30 seconds).
     *
	 * @param timeout timeout in seconds
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setTimeout(int timeout) throws IllegalStateException {
		setAttribute("timeout", timeout, true);
	}

	/**
	 * If set to true, form.reset() resets to the last loaded or setValues() data instead of when the form was first created.
	 *
	 * @param trackResetOnLoad true to track reset on load
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setTrackResetOnLoad(boolean trackResetOnLoad) throws IllegalStateException {
		setAttribute("trackResetOnLoad", trackResetOnLoad, true);
	}

	/**
	 * The URL to use for form actions if one isn't supplied in the action options.
	 *
	 * @param url the url
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setUrl(String url) throws IllegalStateException {
		setAttribute("url", url, true);
	}

	/**
	 * By default wait messages are displayed with {@link com.gwtext.client.widgets.MessageBox#wait(long)}.
	 * You can target a specific element by passing its id.
	 *
	 * @param waitMsgTarget ID of the Element to mask
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setWaitMsgTarget(String waitMsgTarget) throws IllegalStateException {
		setAttribute("waitMsgTarget", waitMsgTarget, true);
	}

	/**
	 * By default wait messages are displayed with {@link com.gwtext.client.widgets.MessageBox#wait(long)}.
	 * You can mask the form itself by passing in true.
	 *
	 * @param waitMsgTarget true to mask the form
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setWaitMsgTarget(boolean waitMsgTarget) throws IllegalStateException {
		setAttribute("waitMsgTarget", waitMsgTarget, true);
	}
}
