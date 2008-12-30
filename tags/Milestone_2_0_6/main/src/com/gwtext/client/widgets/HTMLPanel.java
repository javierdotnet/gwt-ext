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

/**
 * Convenience Panel subclass for HTML-only Components.
 *
 * @author Sanjiv Jivan
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
