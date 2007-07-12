/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.form.event.HtmlEditorListener;

public class HtmlEditor extends Field {
    public HtmlEditor() {
        setJsObj(create(null));
    }

    public HtmlEditor(HtmlEditorConfig config) {
        super(config);
        if (config.getHtmlEditorListener() != null) {
            addHtmlEditorListener(config.getHtmlEditorListener());
        }
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.HtmlEditor(jsObj);
    }-*/;

    public native void cleanHtml(String html) /*-{
        var he = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        he.cleanHtml(html);
    }-*/;

    public native void execCmd(String cmd, String value) /*-{
        var he = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        he.execCmd(cmd, value);
    }-*/;

    public Toolbar getToolbar() {
        return new Toolbar(getToolbar(jsObj));
    }

    private native JavaScriptObject getToolbar(JavaScriptObject he) /*-{
        return he.getToolbar();    
    }-*/;

    public native void insertAtCursor(String text) /*-{
        var he = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        he.insertAtCursor(text);
    }-*/;

    public native void relayCmd(String cmd, String value) /*-{
        var he = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        he.relayCmd(cmd, value);
    }-*/;

    public native void toggleSourceEdit(boolean sourceEdit) /*-{
        var he = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        he.toggleSourceEdit(sourceEdit);
    }-*/;

    public native void addHtmlEditorListener(HtmlEditorListener listener) /*-{
        var fieldJ = this;
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        field.addListener('activate',
                function(fld) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onActivate(Lcom/gwtext/client/widgets/form/HtmlEditor;)(fieldJ);
                }
        );

        field.addListener('beforepush',
                function(fld, html) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::doBeforePush(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );
        field.addListener('beforesync',
                function(fld, html) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::doBeforeSync(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );

        field.addListener('editmodechange',
                function(fld, sourceEdit) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onEditModeChange(Lcom/gwtext/client/widgets/form/HtmlEditor;Z)(fieldJ, sourceEdit);
                }
        );

         field.addListener('initialize',
                function(fld) {
                    return listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onInitialize(Lcom/gwtext/client/widgets/form/HtmlEditor;)(fieldJ);
                }
        );
    
        field.addListener('push',
                function(fld, html) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onPush(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );

        field.addListener('sync',
                function(fld, html) {
                    listener.@com.gwtext.client.widgets.form.event.HtmlEditorListener::onSync(Lcom/gwtext/client/widgets/form/HtmlEditor;Ljava/lang/String;)(fieldJ, html);
                }
        );
    
    }-*/;
}
