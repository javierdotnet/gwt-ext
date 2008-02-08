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

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.HtmlEditorListener;

public class HtmlEditorConfig extends FieldConfig {

    private HtmlEditorListener htmlEditorListener;

    /**
     * The default text for the create link prompt.
     *
     * @param createLinkText link text
     */
    public void setCreateLinkText(String createLinkText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "createLinkText", createLinkText);
    }

    /**
     * The default value for the create link prompt (defaults to http:/ /).
     *
     * @param defaultLinkValue link value
     */
    public void setDefaultLinkValue(String defaultLinkValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultLinkValue", defaultLinkValue);
    }

    /**
     * Enable the left, center, right alignment buttons (defaults to true).
     *
     * @param enableAlignments true to enable alignments
     */
    public void setEnableAlignments(boolean enableAlignments) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableAlignments", enableAlignments);
    }

    /**
     * Enable the fore/highlight color buttons (defaults to true).
     *
     * @param enableColors true to enable colors
     */
    public void setEnableColors(boolean enableColors) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColors", enableColors);
    }

    /**
     * Enable font selection. Not available in Safari. (defaults to true).
     *
     * @param enableFont true to enable fonr selection
     */
    public void setEnableFont(boolean enableFont) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableFont", enableFont);
    }

    /**
     * Enable the increase/decrease font size buttons (defaults to true).
     *
     * @param enableFontSize true to enable font size buttons
     */
    public void setEnableFontSize(boolean enableFontSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableFontSize", enableFontSize);
    }

    /**
     * Enable the create link button. Not available in Safari. (defaults to true).
     *
     * @param enableLinks true to enable links
     */
    public void setEnableLinks(boolean enableLinks) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableLinks", enableLinks);
    }

    /**
     * Enable the bullet and numbered list buttons. Not available in Safari. (defaults to true).
     *
     * @param enableLists true to enable lists
     */
    public void setEnableLists(boolean enableLists) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableLists", enableLists);
    }

    /**
     * Enable the switch to source edit button. Not available in Safari. (defaults to true)
     *
     * @param enableSourceEdit true to enable source edit
     */
    public void setEnableSourceEdit(boolean enableSourceEdit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableSourceEdit", enableSourceEdit);
    }

    /**
     * An array of available font families.
     *
     * @param fontFamilies the font families
     */
    public void setFontFamilies(String[] fontFamilies) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fontFamilies", JavaScriptObjectHelper.convertToJavaScriptArray(fontFamilies));
    }

    /**
     *  Set the height of the HtmlEditor.
     *
     * @param height the feild height
     */
    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    /**
     * Get the HtmlEditor listener.
     *
     * @return the listener
     */
    public HtmlEditorListener getHtmlEditorListener() {
        return htmlEditorListener;
    }

    /**
     * Set the HtmlEditor listener.
     *
     * @param htmlEditorListener the listener
     */
    public void setHtmlEditorListener(HtmlEditorListener htmlEditorListener) {
        this.htmlEditorListener = htmlEditorListener;
    }
}
