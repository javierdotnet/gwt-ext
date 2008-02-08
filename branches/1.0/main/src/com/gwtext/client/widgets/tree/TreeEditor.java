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

/**
 * A support class that allows you to make the nodes of a TreePanel editable. To do this, create an instance of
 * TreeEditor passing the TreePanel and the {@link Field} that you'd like to use when the user double clicks on a node to
 * edit it. For example you can assing a {@link com.gwtext.client.widgets.form.TextField} or {@link com.gwtext.client.widgets.form.ComboBox}.
 *
 */
public class TreeEditor extends Editor {

	/**
	 * Create an editable tree using a default TextField as the editor.
	 *
	 * @param treePanel the TreePanel
	 */
	public TreeEditor(TreePanel treePanel) {
        this(treePanel, (FieldConfig)null);
    }

	/**
	 * Create an editable tree using the specified confguration.
	 *
	 * @param treePanel the TreePanel
	 * @param  config the tree editor configuraiton
	 */
    public TreeEditor(TreePanel treePanel, TreeEditorConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    //http://extjs.com/forum/showthread.php?t=10701&highlight=TreeEditor+selectOnFocus
	/**
	 * Create an editable tree using the specified FieldConfig to create the editor.
	 *
	 * @param treePanel the TreePanel
	 * @param config the field config
	 */
	public TreeEditor(TreePanel treePanel, FieldConfig config) {
        jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

	/**
	 * Create an editable tree using the specified Field as the editor.
	 *
	 * @param treePanel the TreePanel
	 * @param field the field
	 */
    public TreeEditor(TreePanel treePanel, Field field) {
        jsObj = create(treePanel.getJsObj(), field.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.TreeEditor(treePanel, config);
    }-*/;
}
