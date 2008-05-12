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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * @author Sanjiv Jivan
 * @author <a href="mailto:m.bogaert@memenco.com">Mathias Bogaert</a>
 */
public class FormLayout extends AnchorLayout {

    /**
     * True to hide field labels by default (defaults to false).
     *
     * @param hideLabels true to hide field labels by default (defaults to false)
     */
    public void setHideLabels(boolean hideLabels) {
        JavaScriptObjectHelper.setAttribute(configJS, "hideLabels", hideLabels);
    }

    /**
     * A CSS class to add to the div wrapper that contains each field label and field element (the default class is 'x-form-item' and itemCls will be added to that).
     * 
     * @param itemCls a CSS class to add to the div wrapper that contains each field label and field element (the default class is 'x-form-item' and itemCls will be added to that)
     */
    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(configJS, "itemCls", itemCls);
    }

	/**
	 * Valid values are "left," "top" and "right" (defaults to "left"). This property cascades to child containers if not set.
	 *
	 * @param labelAlign label alignment
	 */
	public void setLabelAlign(Position labelAlign) {
		JavaScriptObjectHelper.setAttribute(configJS, "labelAlign", labelAlign.getPosition());
	}

    /**
     * The default padding in pixels for field labels (defaults to 5). labelPad only applies if labelWidth is also specified, otherwise it will be ignored.
     *
     * @param labelPad the default padding in pixels for field labels (defaults to 5). labelPad only applies if labelWidth is also specified, otherwise it will be ignored.
     */
    public void setLabelPad(int labelPad) {
        JavaScriptObjectHelper.setAttribute(configJS, "labelPad", labelPad);
    }

    public void setLabelWidth(int labelWidth) {
        JavaScriptObjectHelper.setAttribute(configJS, "labelWidth", labelWidth);
    }
        
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.FormLayout(config);
    }-*/;

       
}
