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

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * Inteface for custom Grid column rendering.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.widgets.grid.ColumnConfig#setRenderer(Renderer)
 */
public interface Renderer {

    /**
     * Renderer function.
     *
     * @param value        the cells value. When working with numberic data, cast the value to {@link java.lang.Number}
     *                     and not to a specific data type line Integer or Float as the class type is inferred from the data
     * @param cellMetadata the grid cell metadata. Can be use to customize the apperanace of the grid cell
     * @param record       the record corresponding to the row
     * @param rowIndex     the row index
     * @param colNum       the column number
     * @param store        the Grid's data store
     * @return the rendered cell content (can include html)
     */
    String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store);
}
