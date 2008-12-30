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
import com.google.gwt.user.client.ui.impl.FocusImpl;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.event.PanelListener;
import com.gwtext.client.widgets.event.PanelListenerAdapter;

/**
 * This class replicates the FocusPanel provided by GWT but 
 * subclassing from the GWTExt Panel instead.  Mainly, this
 * class provides events listeners for the Panel not available
 * on the normal Panel.
 * @author malim
 *
 */
public class FocusPanel extends Panel {

	static final FocusImpl impl = FocusImpl.getFocusImplForPanel();

	public FocusPanel() {
		super();
		setStyle("visibility: visible");
	}

	/**
	 * Construct a new Panel with the given title.
	 *
	 * @param title the title
	 */
	public FocusPanel(String title) {
		super(title);
		setStyle("visibility: visible");
	}

	/**
	 * Constructor to use title and the html used internally
	 * @param title title for the panel
	 * @param html the inner html in the panel
	 */
	public FocusPanel(String title, String html) {
		super(title, html);
		setStyle("visibility: visible");
	}

	/**
	 * Constructor that accepts the title and the width and height of
	 * the panel
	 * @param title title for the panel
	 * @param width the width for the panel
	 * @param height the height of the panel
	 */
	public FocusPanel(String title, int width, int height) {
		super(title, width, height);
		setStyle("visibility: visible");
	}

	/**
	 * FocusPanel can be reconstructed from the javascript object itself
	 * @param jsObj
	 */
	protected FocusPanel(JavaScriptObject jsObj) {
		super(jsObj);
	}

	/**
	 * Add listeners for the different events
	 * @param listener
	 */
	public void addListener(final FocusPanelListener listener){
		addListener((PanelListener)listener);
		final FocusPanel fpanel = this;

		this.addListener(new PanelListenerAdapter() {
			public void onRender(Component component) {
				component.getEl().addListener("blur", new EventCallback() {
					public void execute(EventObject e) {
						listener.onBlur(fpanel, e);
					}
				});

				component.getEl().addListener("focus", new EventCallback() {
					public void execute(EventObject e) {
						listener.onFocus(fpanel, e);
					}
				});

				component.getEl().addListener("click", new EventCallback() {
					public void execute(EventObject e) {
						listener.onClick(fpanel, e);
					}
				});

				component.getEl().addListener("dblclick", new EventCallback() {
					public void execute(EventObject e) {
						listener.onDblClick(fpanel, e);
					}
				});

				component.getEl().addListener("mousedown", new EventCallback() {
					public void execute(EventObject e) {
						listener.onMouseDown(fpanel, e);
					}
				});

				component.getEl().addListener("mouseup", new EventCallback() {
					public void execute(EventObject e) {
						listener.onMouseUp(fpanel, e);
					}
				});

				component.getEl().addListener("keypress", new EventCallback() {
					public void execute(EventObject e) {
						listener.onKeyPress(fpanel, e);
					}
				});

				component.getEl().addListener("keydown", new EventCallback() {
					public void execute(EventObject e) {
						listener.onKeyDown(fpanel, e);
					}
				});

				component.getEl().addListener("keyup", new EventCallback() {
					public void execute(EventObject e) {
						listener.onKeyUp(fpanel, e);
					}
				});

				// Chaining the renderer from the caller...
				listener.onRender(component);
				
				// Setting a tab index of 0 so that firefox can set focus on it.
				setTabIndex(0);
			}
		});
		//wheel... http://adomas.org/javascript-mouse-wheel/
	}

	public void setAccessKey(char key) {
		impl.setAccessKey(getElement(), key);
	}

	public void setFocus(boolean focused) {
		if (focused) {
			impl.focus(getElement());
		} else {
			impl.blur(getElement());
		}
	}

	public void setTabIndex(int index) {
		impl.setTabIndex(getElement(), index);
	}

	public native int getZIndex() /*-{
	  	  var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		  return panel.style.zIndex;
	  }-*/;

	public native void  setZIndex(int index) /*-{
	  	  var panel = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		  panel.style.zIndex = index;
	  }-*/;
}
