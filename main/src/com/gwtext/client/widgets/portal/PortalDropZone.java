/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.portal;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.dd.*;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Container;

//credits : this class has been adapted from the Ext portal sample
public class PortalDropZone extends DropTarget {

	private Portal portal;
	private int lastCW = -1;
	private int lastPos = -1;
	private XPosWidth[] grid;

	private Container lastPosC;
	private int col;
	private int pos = -1;
	private int[] scrollPos;

	public PortalDropZone(Portal portal, String sGroup, DragDropConfig config) {
		super(portal.getBodyWrap().getDOM(), sGroup, config);
		ScrollManager.register(portal.getBody().getDOM());
		this.portal = portal;
	}

	public String notifyOver(DragSource source, EventObject e, DragData data) {
		int[] xy = e.getXY();
		PanelProxy proxy = new PanelProxy(source.getProxy().getJsObj());

		if (grid == null) {
			grid = getGrid();
		}

		int cw = portal.getBody().getClientWidth();
		if (lastCW == -1) {
			lastCW = cw;
		} else if (lastCW != cw) {
			lastCW = cw;
			portal.doLayout();
			grid = getGrid();
		}

		//determine column
		col = 0;
		boolean cmatch = false;
		for (int len = grid.length; col < len; col++) {
			XPosWidth xPosWidth = grid[col];
			if (xy[0] < (xPosWidth.getX() + xPosWidth.getWidth())) {
				cmatch = true;
				break;
			}
		}

		//no match, fix last index
		if (!cmatch) {
			col--;
		}

		//find insert position
		boolean match = false;
		pos = 0;
		lastPosC = (Container) portal.getItems()[col];
		Component[] items = lastPosC.getItems();
		Component p = null;

		for (pos = 0; pos < items.length; pos++) {
			p = items[pos];
			int height = p.getEl().getHeight();
			if (height != 0 && (p.getEl().getY() + (height / 2)) > xy[1]) {
				match = true;
				break;
			}
		}

		if (!match) pos = -1;
		//over event

		proxy.getProxy().setWidth("auto", false);

		if (p != null) {
			proxy.moveProxy(p.getEl().getParentNode(), (match ? p.getEl().getDOM() : null));
		} else {
			proxy.moveProxy(lastPosC.getEl().getDOM(), null);
		}


		scrollPos = portal.getBody().getScroll();

		return "x-dd-drop-ok";
	}

	public void notifyOut(DragSource source, EventObject e, DragData data) {
		this.grid = null;
	}

	public boolean notifyDrop(DragSource source, EventObject e, DragData data) {
		grid = null;
		if (lastPosC == null) {
			return false;
		}

		PanelProxy proxy = new PanelProxy(source.getProxy().getJsObj());
		proxy.getProxy().remove();
		Element parentNode = proxy.getPanel().getEl().getParentNode();
		new ExtElement(parentNode).removeChild(proxy.getPanel().getElement());
		if (pos != -1) {
			lastPosC.insert(pos, proxy.getPanel());
		} else {
			lastPosC.add(proxy.getPanel());
		}
		lastPosC.doLayout();

		if (scrollPos != null) {
			final int scrollTop = scrollPos[0];
			new Timer() {
				public void run() {
					portal.getBody().setScrollTop(scrollTop);
				}
			}.schedule(10);

		}
		lastPosC = null;
		return true;
	}

	private XPosWidth[] getGrid() {
		Component[] items = portal.getItems();

		XPosWidth[] xPosWidths = new XPosWidth[items.length];

		for (int i = 0; i < items.length; i++) {
			Component item = items[i];
			int x = item.getEl().getX();
			int w = item.getEl().getWidth();
			xPosWidths[i] = new XPosWidth(x, w);
		}
		return xPosWidths;
	}

	private class XPosWidth {
		private int xPos;
		private int width;

		private XPosWidth(int xPos, int width) {
			this.xPos = xPos;
			this.width = width;
		}

		public int getX() {
			return xPos;
		}

		public int getWidth() {
			return width;
		}
	}
}

