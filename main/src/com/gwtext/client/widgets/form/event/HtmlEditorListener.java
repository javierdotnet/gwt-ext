/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.HtmlEditor;

public interface HtmlEditorListener extends FieldListener {

    /**
     * Fires when the editor is first receives the focus. Any insertion must wait until after this event.
     *
     * @param field this
     */
    void onActivate(HtmlEditor field);

    /**
     * Fires before the iframe editor is updated with content from the textarea. Return false to cancel the push.
     *
     * @param field this
     * @param html  the html
     * @return false to cancel
     */
    boolean doBeforePush(HtmlEditor field, String html);

    /**
     * Fires before the textarea is updated with content from the editor iframe. Return false to cancel the sync.
     *
     * @param field this
     * @param html  the html
     * @return false to cancel sync
     */
    boolean doBeforeSync(HtmlEditor field, String html);

    /**
     * Fires when the editor switches edit modes.
     *
     * @param field      this
     * @param sourceEdit true if source edit, false if standard editing
     */
    void onEditModeChange(HtmlEditor field, boolean sourceEdit);

    /**
     * Fires when the editor is fully initialized (including the iframe)
     *
     * @param field this
     */
    void onInitialize(HtmlEditor field);

    /**
     * Fires when the iframe editor is updated with content from the textarea.
     *
     * @param field this
     * @param html  the html
     */
    void onPush(HtmlEditor field, String html);

    /**
     * Fires when the textarea is updated with content from the editor iframe.
     *
     * @param field this
     * @param html  the html
     */
    void onSync(HtmlEditor field, String html);
}
