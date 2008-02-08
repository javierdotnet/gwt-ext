/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

/**
 * Convenience Panel subclass for HTML-only Components.
 */
public class HTMLPanel extends Panel {

    /**
     * Create a new HTMLPanel.
     */
    public HTMLPanel() {
        setBorder(false);
    }

    /**
     * Create a new HTMLPanel.
     *
     * @param html the html
     */
    public HTMLPanel(String html) {
        setBorder(false);
        setHtml(html);
    }

    /**
     * Create a new HTMLPanel.
     *
     * @param html the html
     * @param paddings the paddings on all sides
     */
    public HTMLPanel(String html, int paddings) {
        setBorder(false);
        setHtml(html);
        setPaddings(paddings);
    }

    /**
     * Create a new HTMLPanel.
     *
     * @param html the html
     * @param topPadding the top padding
     * @param leftPadding the left padding
     * @param rightPadding the right padding
     * @param bottomPadding the bottom padding
     */
    public HTMLPanel(String html, int topPadding, int leftPadding, int rightPadding, int bottomPadding) {
        setBorder(false);
        setHtml(html);
        setPaddings(topPadding, leftPadding, rightPadding, bottomPadding);
    }
}
