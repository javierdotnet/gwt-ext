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

    public void setCreateLinkText(String createLinkText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "createLinkText", createLinkText);
    }

    public void setDefaultLinkValue(String defaultLinkValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultLinkValue", defaultLinkValue);
    }

    public void setEnableAlignments(boolean enableAlignments) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableAlignments", enableAlignments);
    }

    public void setEnableColors(boolean enableColors) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColors", enableColors);
    }

    public void setEnableFont(boolean enableFont) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableFont", enableFont);
    }

    public void setEnableFontSize(boolean enableFontSize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableFontSize", enableFontSize);
    }

    public void setenableLinks(boolean enableLinks) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableLinks", enableLinks);
    }

    public void setEnableLists(boolean enableLists) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableLists", enableLists);
    }

    public void setEnableSourceEdit(boolean enableSourceEdit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableSourceEdit", enableSourceEdit);
    }

    public void setFontFamilies(String[] fontFamilies) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fontFamilies", JavaScriptObjectHelper.convertToJavaScriptArray(fontFamilies));
    }

    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    public HtmlEditorListener getHtmlEditorListener() {
        return htmlEditorListener;
    }

    public void setHtmlEditorListener(HtmlEditorListener htmlEditorListener) {
        this.htmlEditorListener = htmlEditorListener;
    }
}
