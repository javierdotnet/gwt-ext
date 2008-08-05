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

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * Custom cell editor.  This class will create a custom editor called
 * by ColumnModel.getCellEditor.  By default, the cell editor can be 
 * set in ColumnModel on a per column basis.  In cases where values
 * or different editors are needed depending on column and rows, 
 * this class is used to in ColumnModel.setUserCustomEditor
 *
 * @author Mario Lim
 */
public class UserCustomCellEditor extends JsObject {
	/**
	 * New functionality added to the extjs.  This is a new "class" for
	 * custom cell editors.
	 */
	protected native void createFunctionality()/*-{
		var myinstance = this;
		
		var pluginGetEditor = function(colIndex, rowIndex) {
        	return myinstance.@com.gwtext.client.widgets.grid.UserCustomCellEditor::getPluginCustomEditorJ(II)(colIndex, rowIndex);
		}
		
		var pluginIsEditable = function(colIndex, rowIndex) {
        	return myinstance.@com.gwtext.client.widgets.grid.UserCustomCellEditor::isCellEditable(II)(colIndex, rowIndex);
		}

		$wnd.Ext.grid.UserCustomCellEditor = function(){
		};
		
		$wnd.Ext.grid.UserCustomCellEditor.prototype = {
			getUserCustomCellEditor : function(colIndex, rowIndex){
				return pluginGetEditor(colIndex, rowIndex);
			},	
			isUserCustomCellEditable : function(colIndex, rowIndex){
				return pluginIsEditable(colIndex, rowIndex);
			}
		}
	}-*/;
	
	/**
	 * Constructor based on the JavaScriptObject passed
	 * @param jsObject the instance of UserCustomCellEditor in javascript
	 */
	public UserCustomCellEditor(JavaScriptObject jsObject) {
		jsObj = jsObject;
    }
	
	/**
	 * Empty constructor
	 */
	public UserCustomCellEditor(){
        createFunctionality();
        jsObj = create();
    }

	/**
	 * creates the javascript object
	 * @return the instance of the javascript object
	 */
    private native JavaScriptObject create() /*-{
    	return new $wnd.Ext.grid.UserCustomCellEditor();
	}-*/;
    
    /**
     * Method called in Javascript to get the javascript instance
     * of a GridEditor based on the column and row index
     * @param colIndex the column index
     * @param rowIndex the row index
     * @return the javascript object instance of GridEditor
     */
	protected JavaScriptObject getPluginCustomEditorJ(int colIndex, int rowIndex){
		GridEditor ge = getCellEditor(colIndex, rowIndex);
		if(ge == null) return null;
		return ge.getJsObj();
	}
	
	/**
	 * This method return null by default.  This means that whatever
	 * is currently set as the GridEditor for the column in extjs is
	 * what is return.  Overwrite this method to change the GridEditor
	 * whenever a cell is clicked.
	 * @param colIndex the column index 
	 * @param rowIndex the row index
	 * @return the GridEditor to use for that column and row index
	 */
	public GridEditor getCellEditor(int colIndex, int rowIndex){
		return null;
	}
	
	/**
	 * This method is called to find out if the cell is editable
	 * This method should be overwritten; by default, it returns false.
	 * This method is called only if the isCellEditable from ColumnModel
	 * returns false.  Otherwise, there is no need to call isCellEditable
	 * from the UserCustomCellEditor.
	 * @param colIndex the column index
	 * @param rowIndex the row index
	 * @return true if the cell is editable; otherwise, false.
	 */
	public boolean isCellEditable(int colIndex, int rowIndex){
		return false;
	}
}
