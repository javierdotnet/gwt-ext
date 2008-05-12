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
import com.google.gwt.user.client.Element;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ProgressBarListener;

/**
 * An updateable progress bar component. The progress bar supports two different modes: manual and automatic.
 * <br><br>
 * In manual mode, you are responsible for showing, updating (via updateProgress) and clearing the progress bar as needed
 * from your own code. This method is most appropriate when you want to show progress throughout an operation that has
 * predictable points of interest at which you can update the control.
 * <br><br>
 * In automatic mode, you simply call wait and let the progress bar run indefinitely, only clearing it once the operation is
 * complete. You can optionally have the progress bar wait for a specific amount of time and then clear itself. Automatic mode
 * is most appropriate for timed operations or asymchronous operations in which you have no need for indicating intermediate
 * progress.
 *
 * @author Sanjiv Jivan
 */
public class ProgressBar extends BoxComponent {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Toolbar();
        @com.gwtext.client.widgets.ProgressBar::configPrototype = c.initialConfig;
    }-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "progress";
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.ProgressBar(config);
    }-*/;

    public ProgressBar() {
    }

    public ProgressBar(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Returns true if the progress bar is currently in a {@link #wait} operation.
     *
     * @return true if in wait
     */
    public native boolean isWaiting() /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       return pb.isWaiting();
    }-*/;

    /**
     * Resets the progress bar value to 0 and text to empty string.
     */
	public void reset() {
		reset(false);
	}

	private native void resetRendered(boolean hide) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       pb.reset(hide);
    }-*/;

    /**
     * Resets the progress bar value to 0 and text to empty string. If hide = true, the progress bar will also be hidden
     * (using the hideMode property internally).
     *
     * @param hide true to hide the progress bar (defaults to false)
     */
    public  void reset(boolean hide) {
		if(!isRendered()) {
	        setValue(0);
		} else {
			resetRendered(false);
		}
	}
    /**
     * Sets the size of the progress bar.
     *
     * @param width  the width
     * @param height the height
     */
    public native void setSize(int width, int height) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       pb.setSize(width, height);
    }-*/;

    /**
     * Updates the progress bar value. Any existing text value will be unchanged. Note that even if the progress bar
     * value exceeds 1, it will never automatically reset -- you are responsible for determining when the progress is
     * complete and calling reset to clear and/or hide the control.
     *
     * @param value the new value
     */
    public native void updateProgress(float value) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       pb.updateProgress(value);
    }-*/;

    /**
     * Updates the progress bar value, and its text. Note that even if the progress bar value exceeds 1, it will never
     * automatically reset -- you are responsible for determining when the progress is complete and calling reset to
     * clear and/or hide the control.
     *
     * @param value the new value
     * @param text  the new text
     */
    public native void updateProgress(float value, String text) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       pb.updateProgress(value, text);
    }-*/;

    /**
     * Updates the progress bar text. If specified, textEl will be updated, otherwise the progress bar
     * itself will display the updated text.
     *
     * @param text the text to display
     */
    public native void updateText(String text) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       pb.updateText(text);
    }-*/;

    /**
     * Initiates an auto-updating progress bar. A duration can be specified, in which case the progress bar will automatically
     * reset after a fixed amount of time and optionally call a callback function if specified. If no duration is passed in,
     * then the progress bar will run indefinitely and must be manually cleared by calling reset.
     *
     * @param waitConfig the wait configuration
     */
    public native void wait(WaitConfig waitConfig) /*-{
       var pb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
       var wcJS = waitConfig == null ? null : waitConfig.@com.gwtext.client.core.JsObject::getJsObj()();
       pb.wait(wcJS);
    }-*/;

    /**
     * Add a ProgressBar listener.
     *
     * @param listener the listener
     */
    public native void addListener(ProgressBarListener listener)/*-{
        this.@com.gwtext.client.widgets.BoxComponent::addListener(Lcom/gwtext/client/widgets/event/BoxComponentListener;)(listener);
        var pbJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('update',
                function(source, value, text) {
                    listener.@com.gwtext.client.widgets.event.ProgressBarListener::onUpdate(Lcom/gwtext/client/widgets/ProgressBar;FLjava/lang/String;)(pbJ, value, text);
                }
        );
    }-*/;

    // --- config properties

    /**
     * The progress bar text (defaults to '').
     *
     * @param text the progress bar text
     */
    public void setText(String text) {
        if(!isCreated()) {
            JavaScriptObjectHelper.setAttribute(config, "text", text);
        } else {
            updateText(text);
        }
    }

    /**
     * The progress bar text.
     *
     * @return the progress bar text (defaults to '')
     */
    public String getText() {
        return getAttribute("text");
    }

    /**
     * The element to render the progress text to (defaults to the progress bar's internal text element).
     * <br><br>
     * <b>Note that the text element must already be rendered to the DOM before creation of the progress bar.</b>
     * You can call textElComponent.render(RootPanel.getBodyElement()) to force addition of the textEl  to the broswer DOM.
     *
     * @param textElID the text element ID
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTextEl(String textElID) throws IllegalStateException {
        setAttribute("textEl", textElID, true);
    }

    /**
     * The element to render the progress text to (defaults to the progress bar's internal text element).
     * <br><br>
     * <b>Note that the text element must already be rendered to the DOM before creation of the progress bar.</b>
     * You can call textElComponent.render(RootPanel.getBodyElement()) to force addition of the textEl  to the broswer DOM.
     *
     *
     * @param textEl the text element
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTextEl(Element textEl) throws IllegalStateException {
        setAttribute("textEl", textEl, true);
    }

    /**
     * The  value of the progress bar. A floating point value between 0 and 1 (e.g., .5, defaults to 0)
     *
     * @param value the value of the progress bar
     */
    public void setValue(float value) {
        if(!isCreated()) {
            JavaScriptObjectHelper.setAttribute(config, "value", value);
        } else {
            updateProgress(value);
        }
    }

    /**
     * @return the  value of the progress bar
     */
    public float getValue() {
        return getAttributeAsFloat("value");
    }
}
