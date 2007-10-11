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

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.HtmlEditor;

public interface HtmlEditorListener {

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
     * @param html the html
     * @return false to cancel
     */
    boolean doBeforePush(HtmlEditor field, String html);

    /**
     * Fires before the textarea is updated with content from the editor iframe. Return false to cancel the sync.
     *
     * @param field this
     * @param html the html
     * @return false to cancel sync
     */
    boolean doBeforeSync(HtmlEditor field, String html);

    /**
     * Fires when the editor switches edit modes.
     *
     * @param field this
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
     * @param html the html
     */
    void onPush(HtmlEditor field, String html);

    /**
     * Fires when the textarea is updated with content from the editor iframe.
     *
     * @param field this
     * @param html the html
     */
    void onSync(HtmlEditor field, String html);
}
