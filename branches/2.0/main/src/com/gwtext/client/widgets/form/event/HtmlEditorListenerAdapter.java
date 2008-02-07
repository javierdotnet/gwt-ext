/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.HtmlEditor;

public class HtmlEditorListenerAdapter extends FieldListenerAdapter implements HtmlEditorListener {

    public void onActivate(HtmlEditor field) {
    }

    public boolean doBeforePush(HtmlEditor field, String html) {
        return true;
    }

    public boolean doBeforeSync(HtmlEditor field, String html) {
        return true;
    }

    public void onEditModeChange(HtmlEditor field, boolean sourceEdit) {
    }

    public void onInitialize(HtmlEditor field) {
    }

    public void onPush(HtmlEditor field, String html) {
    }

    public void onSync(HtmlEditor field, String html) {
    }
}
