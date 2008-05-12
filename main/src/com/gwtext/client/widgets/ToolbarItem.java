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
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

/**
 * The base class that other classes should extend in order to get some basic common toolbar item functionality.
 *
 * @author Sanjiv Jivan
 */
public class ToolbarItem extends BaseExtWidget {

	protected ToolbarItem() {
	}

	/**
	 * Creates a new Item.
	 *
	 * @param element the html element
	 */
	public ToolbarItem(Element element) {
		setJsObj(create(element));
	}

	private native JavaScriptObject create(Element element) /*-{
        return new $wnd.Ext.Toolbar.Item(element);
    }-*/;

	public ToolbarItem(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public native Element getElement() /*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var el = tbi.getEl();
		return el === undefined ? null : el;
	}-*/;

	protected native boolean isRendered() /*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var el = tbi.getEl();
		return tbi.td != null && tbi.td !== undefined;
	}-*/;

	/**
	 * Removes and destroys this item.
	 */
	public native void destroy()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.destroy();
    }-*/;

	/**
	 * Disables this item.
	 */
	public void disable() {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					disable();
				}
			});
		} else {
			disableRendered();
		}
	}

	private native void disableRendered()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.disable();
    }-*/;

	/**
	 * Enables this item.
	 */
	public void enable() {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					enable();
				}
			});
		} else {
			enableRendered();
		}
	}

	private native void enableRendered()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.enable();
    }-*/;

	/**
	 * Try to focus this item.
	 */
	public void focus() {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					focus();
				}
			});
		} else {
			focusRendered();
		}
	}

	private native void focusRendered()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.focus();
    }-*/;

	public void hide() {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					hide();
				}
			});
		} else {
			hideRendered();
		}
	}

	/**
	 * Hides this item.
	 */
	public native void hideRendered()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.hide();
    }-*/;

	/**
	 * Shows this item.
	 */
	public void show() {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					show();
				}
			});
		} else {
			showRendered();
		}
	}

	private native void showRendered()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.show();
    }-*/;

	/**
	 * Convenience function for boolean show/hide.
	 *
	 * @param visible true to show
	 */
	public void setVisible(final boolean visible) {
		if (!isRendered()) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					setVisible(visible);
				}
			});
		} else {
			setVisibleRendered(visible);
		}
	}

	private native void setVisibleRendered(boolean visible)/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.setVisible(visible);
    }-*/;
}
