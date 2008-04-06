/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

/**
 * This class provides the default UI implementation for TreeNodes. The TreeNode UI implementation is separate from the
 * tree implementation, and allows customizing of the appearance of tree nodes.
 *
 * <p>
 * This class provides access to the user interface components of an TreeNode, through {@link TreeNode#getUI()}.
 *
 */
public class TreeNodeUI extends JsObject {

    public TreeNodeUI(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static TreeNodeUI instance(JavaScriptObject jsObj) {
        return new TreeNodeUI(jsObj);
    }

	/**
	 * Adds one or more CSS classes to the node's UI element. Duplicate classes are automatically filtered out.
	 *
	 * @param cls the CSS class
	 */
	public native void addClass(String cls) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.addClass(cls);
    }-*/;

	/**
	 * Removes one or more CSS classes from the node's UI element.
	 *
	 * @param cls the CSS class to remove
	 */
	public native void removeClass(String cls) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.removeClass(cls);
    }-*/;

	/**
	 * Hides this node.
	 */
	public native void hide() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.hide();
    }-*/;

	/**
	 * Shows this node.
	 */
	public native void show() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.show();
    }-*/;

	/**
	 * Sets the checked status of the tree node to the passed value, or, if no value was passed, toggles the checked status.
	 * If the node was rendered with no checkbox, this has no effect.
	 */
	public native void toggleCheck() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.toggleCheck();
    }-*/;

	/**
	 * Sets the checked status of the tree node to the passed value, or, if no value was passed, toggles the checked status.
	 * If the node was rendered with no checkbox, this has no effect.
	 *
	 * @param value the new checkbox status
	 */
    public native void toggleCheck(boolean value) /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.toggleCheck(value);
    }-*/;

	/**
	 * Highlight this node.
	 */
	public native void highlight() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ui.highlight();
    }-*/;

    /**
     * This returns an element that represents the whole subtree starting with itselt as the
     * current node. The returned element has wtoe children. The first child represents its
     * node, and is what is returned when getElNode() is called. The second child containts
     * an array of its child elements.
     *
     * @return the subtree element
     */
    public native Element getEl() /*-{
         var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
         var el =  ui.getEl();
		 return el === undefined ? null : el;
	}-*/;

    /**
     * Element for 'this' node.
     *
     * @return the underlying element for this node
     */
    public native Element getElNode()/*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ui.elNode;
     }-*/;

    /**
     * Returns the &lt;a> element that provides focus for the node's UI.
     *
     * @return the DOM anchor element
     */
    public native Element getAnchor()/*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ui.getAnchor();
     }-*/;

    /**
     * Returns the text node.
     *
     * @return the text node.
     */
    public native Element getTextEl()/*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ui.getTextEl();
     }-*/;

    /**
     * Returns the icon &lt;img> element.
     *
     * @return the DOM image element
     */
    public native Element getIconEl()/*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ui.getIconEl();
     }-*/;

    /**
	 * Returns the checked status of the node. If the node was rendered with no checkbox, it returns false.
	 *
	 * @return true if checked
	 */
	public native boolean isChecked() /*-{
        var ui = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ui.isChecked();
     }-*/;
}
