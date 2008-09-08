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
 
package com.gwtext.client.widgets.grid;

/**
 * Handle to the Grid cell metadata passed to a Grid Column Renderer. This allows
 * fine grained coltrol to the column Renderer to custom render a grid cell. You can
 * customize a Grid cell appearance by either using {@link #setCssClass(String)} or
 * {@link #setHtmlAttribute(String)} . There is a subtle difference between the two methods that is best illustrated
 * by an example.
 * <br/>
 * So when cellMetadata.setHtmlAttribute("style=\"background:yellow;\"");  is called, the DIV within the cell TD has its attributes set.
 * <br/><br/>
 * <code>
 * &lt;td tabindex="0" class="x-grid-col x-grid-td-2 x-grid-cell-6-2 x-grid-dirty-cell x-grid-cell-selected" id="ext-gen353">
 * &lt;div class="x-grid-col-2 x-grid-cell-inner">&lt;div style="<b>background: yellow</b> none repeat scroll 0%; -moz-background-clip:-moz-initial; -moz-background-origin: -moz-initial;-moz-background-inline-policy: -moz-initial;" unselectable="on" class="x-grid-cell-text">$4.41&lt;/div>
 * &lt;/div>
 * &lt;/td>
 * </code>
 * <br/><br/>
 * <p/>
 * And when setCssClass is called, it sets the CSS on the TD element. As an example, when cellMetadata.setCssClass("mystyle") is called the rendered html for the cell is
 * <br/><br/>
 * <code>
 * <p/>
 * &lt;td tabindex="0" class="x-grid-col x-grid-td-2 x-grid-cell-6-2 x-grid-dirty-cell x-grid-cell-selected <b>mystyle</b>" id="ext-gen353">&lt;div class="x-grid-col-2 x-grid-cell-inner">
 * &lt;div style="-moz-background-clip: -moz-initial; -moz-background-origin:-moz-initial; -moz-background-inline-policy: -moz-initial;"unselectable="on" class="x-grid-cell-text">$4.41&lt;/div>&lt;/div>
 * &lt;/td>
 * </code>
 *
 * @author Sanjiv Jivan
 * @see ColumnConfig#setRenderer(Renderer)
 * @see com.gwtext.client.widgets.grid.Renderer
 */
public interface CellMetadata {

    /**
     * Sets the CSS style to the table cell.
     *
     * @param cssClass CSS class
     */
    void setCssClass(String cssClass);

    /**
     * Sets the HTML attribute definition to the data container element within the table cell.
     *
     * @param htmlAttribute the html attribute
     */
    void setHtmlAttribute(String htmlAttribute);
}
