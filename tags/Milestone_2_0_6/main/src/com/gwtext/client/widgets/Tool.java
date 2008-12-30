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
 
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * These are the tool buttons that can be added to a Panel by calling {@link com.gwtext.client.widgets.Panel#addTool(Tool)}
 *
 * @author Sanjiv Jivan
 */
public class Tool {

    /**
     * Created by default when collapsible property of Panel is is true
     */
    public static ToolType TOGGLE = new ToolType("toggle");
    public static ToolType CLOSE = new ToolType("close");
    public static ToolType MINIMIZE = new ToolType("minimize");
    public static ToolType MAXIMIZE = new ToolType("maximize");
    public static ToolType RESTORE = new ToolType("restore");
    public static ToolType GEAR = new ToolType("gear");
    public static ToolType PIN = new ToolType("pin");
    public static ToolType UNPIN = new ToolType("unpin");
    public static ToolType RIGHT = new ToolType("right");
    public static ToolType LEFT = new ToolType("left");
    public static ToolType UP = new ToolType("up");
    public static ToolType DOWN = new ToolType("down");
    public static ToolType REFRESH = new ToolType("refresh");
    public static ToolType MINUS = new ToolType("minus");
    public static ToolType PLUS = new ToolType("plus");
    public static ToolType HELP = new ToolType("help");
    public static ToolType SEARCH = new ToolType("search");
    public static ToolType SAVE = new ToolType("save");
    public static ToolType PRINT = new ToolType("print");

    private JavaScriptObject jsObj = JavaScriptObjectHelper.createObject();

    /**
     * Create a new Tool.
     *
     * @param type    the tool type
     * @param handler the handler
     */
    public Tool(ToolType type, Function handler) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", type.getType());
        JavaScriptObjectHelper.setAttribute(jsObj, "handler", handler);
    }

    /**
     * Create a new Tool.
     *
     * @param type    the tool type
     * @param handler the handler
     */
    public Tool(ToolType type, ToolHandler handler) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", type.getType());
        setAttribute(jsObj, "handler", handler);
    }
    
    /**
     * Create a new Tool.
     *
     * @param type    the tool type
     * @param handler the tool handler
     * @param qtip    the quick tip
     */
    public Tool(ToolType type, Function handler, String qtip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", type.getType());
        JavaScriptObjectHelper.setAttribute(jsObj, "handler", handler);
        JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
    }

    /**
     * Create a new Tool.
     *
     * @param type    the tool type
     * @param handler the tool handler
     * @param qtip    the quick tip
     */
    public Tool(ToolType type, ToolHandler handler, String qtip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", type.getType());
        setAttribute(jsObj, "handler", handler);
        JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
    }
    
    /**
     * Sets internal Attribute for a ToolHandler
     * @param elem
     * @param attr
     * @param handler
     */
    private native void setAttribute(JavaScriptObject elem, String attr, ToolHandler handler) /*-{
	    elem[attr] = function(event, toolEl, panel) {
	    	var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
			var extEl = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(toolEl);
			var panelJ = @com.gwtext.client.widgets.Panel::panelInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(panel);
	        handler.@com.gwtext.client.widgets.ToolHandler::onClick(Lcom/gwtext/client/core/EventObject;Lcom/gwtext/client/core/ExtElement;Lcom/gwtext/client/widgets/Panel;)(e, extEl, panelJ);
	    };
	}-*/;
    
    /**
     * Type of tool to be displayed in the upper right corner of panels.
     * For using stock tools, use the static variables defined in Tool class. <br/>
     * You need to create ToolType instances only to display your own icons (which should be 15x15 pixels). <br/>
     * <p/>
     * Sample usage (for custom tool icons):
     * <pre>
     * <code>
     * Java
     * ----
     * // string passed to constructor should be part of the CSS class names
     * Tool.ToolType flagType = new Tool.ToolType("<b>flag</b>");
     * panel.addTool(new Tool(flagType, new Function() {
     * 	public void execute() {
     * 		Window.alert("Flag tool clicked");
     * 	}
     * }));
     * 
     * 
     * CSS
     * ---
     * .x-tool-<b>flag</b>{background-image:url(images/flag.gif)}
     * .x-tool-<b>flag</b>-over{background-image:url(images/flag-over.gif)}
     * </code>
     * </pre> 
     */
    public static class ToolType {

        private String type;


        public ToolType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
