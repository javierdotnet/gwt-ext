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

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.Grid;

//deails here http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit
public interface EditorGridListener {
    void onAfterEdit(Grid grid, Record record, String field, String newValue, String oldValue, int rowIndex, int colIndex);

    boolean doBeforeEdit(Grid grid, Record record, String field, String value, int rowIndex, int colIndex);

    boolean doValidateEdit(Grid grid, Record record, String field, String value, String originalValue, int rowIndex, int colIndex);

    
}