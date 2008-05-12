/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.HtmlEditor;

/**
 *
 * @author Sanjiv Jivan
 */
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
