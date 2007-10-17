/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
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
 * 
 * And when setCssClass is called, it sets the CSS on the TD element. As an example, when cellMetadata.setCssClass("mystyle") is called the rendered html for the cell is
 * <br/><br/>
 * <code>
 *
 * &lt;td tabindex="0" class="x-grid-col x-grid-td-2 x-grid-cell-6-2 x-grid-dirty-cell x-grid-cell-selected <b>mystyle</b>" id="ext-gen353">&lt;div class="x-grid-col-2 x-grid-cell-inner">
 * &lt;div style="-moz-background-clip: -moz-initial; -moz-background-origin:-moz-initial; -moz-background-inline-policy: -moz-initial;"unselectable="on" class="x-grid-cell-text">$4.41&lt;/div>&lt;/div>
 * &lt;/td>
 * </code>
 *
 *
 * @see ColumnConfig#setRenderer(Renderer)
 * @see com.gwtext.client.widgets.grid.Renderer
 */
public interface CellMetadata {

    /**
     *  Sets the CSS style to the table cell. 
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
