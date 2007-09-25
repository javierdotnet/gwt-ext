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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Editor;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FieldConfig;

public class TreeEditor extends Editor {

    public TreeEditor(TreePanel treePanel) {
        this(treePanel, (FieldConfig)null);
    }

    public TreeEditor(TreePanel treePanel, TreeEditorConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    //http://extjs.com/forum/showthread.php?t=10701&highlight=TreeEditor+selectOnFocus
    public TreeEditor(TreePanel treePanel, FieldConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    public TreeEditor(TreePanel treePanel, Field field) {
        jsObj = create(treePanel.getJsObj(), field.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeEditor(treePanel, config);
    }-*/;
}
