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
package com.gwtext.client.widgets.tree;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.EditorConfig;

public class TreeEditorConfig extends EditorConfig {

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    public void setEditDelay(int editDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editDelay", editDelay);
    }
        
    public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }
}
