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
 
package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Editor;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A support class that allows you to make the nodes of a TreePanel editable. To do this, create an instance of
 * TreeEditor passing the TreePanel and the {@link Field} that you'd like to use when the user double clicks on a node to
 * edit it. For example you can assing a {@link com.gwtext.client.widgets.form.TextField} or {@link com.gwtext.client.widgets.form.ComboBox}.
 *
 * @author Sanjiv Jivan
 */
public class TreeEditor extends Editor {


    //http://extjs.com/forum/showthread.php?t=10701&highlight=TreeEditor+selectOnFocus
	/**
	 * Create an editable tree using the default Field editor.
	 *
	 * @param treePanel the TreePanel
	 */
    public TreeEditor(TreePanel treePanel) {
        create(treePanel.getOrCreateJsObj(), null);
    }
    
    /**
	 * Create an editable tree using the specified Field as the editor.
	 *
	 * @param treePanel the TreePanel
	 * @param field the field
	 */
    public TreeEditor(TreePanel treePanel, Field field) {
        create(treePanel.getOrCreateJsObj(), field.getOrCreateJsObj());
    }


    protected native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject field)/*-{
		var te =  new $wnd.Ext.tree.TreeEditor(treePanel, field);
		var id = te.getId();
		this.@com.gwtext.client.widgets.Component::id = id;
		return te;
	}-*/;


    /**
     * Starts the editing process and shows the editor.
     *
     * @param node the tree node to edit
     */
    public native void startEdit(TreeNode node) /*-{
		var editor = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		var nodeJS = node.@com.gwtext.client.core.JsObject::getJsObj()();
		editor.triggerEdit(nodeJS);
    }-*/;

	// --- config options ---

    /**
	 * CSS class to apply to the editor (defaults to "x-small-editor x-tree-editor")
	 *
	 * @param cls the CSS class
	 */
    public void setCls(String cls) {
        setAttribute("cls", cls, true, true);
    }

	/**
	 * The maximum width in pixels of the editor field (defaults to 250). Note that if the maxWidth would exceed the
	 * containing tree element's size, it will be automatically limited for you to the container width, taking scroll and client offsets into account prior to each edit.
	 *
	 * @param maxWidth the max width
	 */
	public void setMaxWidth(int maxWidth) {
        setAttribute("maxWidth", maxWidth, true, true);
    }

	/**
	 *  The edit delay in milliseconds. Default is 350ms.
	 *
	 * @param editDelay the edit delay
	 */
	public void setEditDelay(int editDelay) {
        setAttribute("editDelay", editDelay, true, true);
    }

	/**
	 * True to shim the editor if selects/iframes could be displayed beneath it (defaults to false).
	 *
	 * @param shim true to shim
	 */
	public void setShim(boolean shim) {
        setAttribute("shim", shim, true, true);
    }
}
