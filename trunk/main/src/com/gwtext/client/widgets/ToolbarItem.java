/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

/**
 * The base class that other classes should extend in order to get some basic common toolbar item functionality.
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
