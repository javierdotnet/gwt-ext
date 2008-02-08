/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 *
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * These are the tool buttons that can be added to a Panel by calling {@link com.gwtext.client.widgets.Panel#addTool(Tool)}
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
     * @param handler the tool handler
     * @param qtip    the quick tip
     */
    public Tool(ToolType type, Function handler, String qtip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", type.getType());
        JavaScriptObjectHelper.setAttribute(jsObj, "handler", handler);
        JavaScriptObjectHelper.setAttribute(jsObj, "qtip", qtip);
    }

    public static class ToolType {

        private String type;


        private ToolType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
