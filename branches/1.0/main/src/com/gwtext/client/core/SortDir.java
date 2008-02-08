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
package com.gwtext.client.core;

/**
 * Constants for Sort direction.
 */
public class SortDir {

    public static final SortDir ASC = new SortDir("ASC");
    public static final SortDir DESC = new SortDir("DESC");

    private String direction;

    private SortDir(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    /**
     * Return the sort dir value based on the passed String direction.
     *
     * @param direction the String direction
     * @return the corresponding SortDir
     */
    public static SortDir getValue(String direction) {
        if(ASC.getDirection().equalsIgnoreCase(direction)) {
            return ASC;
        } else if(DESC.getDirection().equalsIgnoreCase(direction)) {
            return DESC;
        } else {
            throw new IllegalArgumentException("Unrecognized direction value " + direction);
        }
    }
}
