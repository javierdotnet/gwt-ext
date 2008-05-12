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
 * Helper class that wraps a Panel with shell panel adding the specified padding.
 * Useful when laying out panels using ColumnLayouts or the other layouts which
 * place the panels right beside each otehr without spacing.
 *
 * @author Sanjiv Jivan
 */
public class PaddedPanel extends Panel {

    /**
     * Create a Padded Panel.
     *
     * @param panel the panel to wrap
     * @param paddings the paddings
     */
    public PaddedPanel(Panel panel, int paddings) {
        setBaseCls("x-plain");
        setPaddings(paddings);
        add(panel);
    }

    /**
     * Wraps the passed Panel with a shell Panel having the specified padding values.
     *
     * @param panel the panel the wrap
     * @param top the top padding
     * @param left the left padding
     * @param right the right padding
     * @param bottom the bottom padding
     */
    public PaddedPanel(Panel panel, int top, int left, int right, int bottom) {
        setBaseCls("x-plain");
        setPaddings(top, left, right, bottom);
        add(panel);
    }
}
