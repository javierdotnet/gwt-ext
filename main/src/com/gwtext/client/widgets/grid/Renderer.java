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

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * Inteface for custom Grid column rendering.
 *
 * @see com.gwtext.client.widgets.grid.ColumnConfig#setRenderer(Renderer)
 */
public interface Renderer {

    /**
     * Renderer function.
     *
     * @param value the cells value. When working with numberic data, cast the value to {@link java.lang.Number}
     * and not to a specific data type line Integer or Float as the class type is inferred from the data
     * @param cellMetadata the grid cell metadata. Can be use to customize the apperanace of the grid cell
     * @param record the record corresponding to the row
     * @param rowIndex the row index
     * @param colNum the column number
     * @param store the Grid's data store
     * @return the rendered cell content (can include html)
     */
    String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store);
}
