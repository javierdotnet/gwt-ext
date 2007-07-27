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

package com.gwtext.client.widgets.form;


//http://extjs.com/forum/showthread.php?t=4271&highlight=vtype
public class VType {

    private String vType;

    public VType(String vType) {
        this.vType = vType;
    }

    public String getVType() {
        return vType;
    }

    public static VType ALPHA = new VType("alpha");
    public static VType ALPHA_MASK = new VType("alphaMask");
    public static VType ALPHA_TEXT = new VType("alphaText");
    public static VType ALPHANUM_MASK = new VType("alphanumMask");
    public static VType ALPHANUM = new VType("alphanum");
    public static VType ALPHANUM_TEXT = new VType("alphanumText");
    public static VType EMAIL = new VType("email");
    public static VType EMAIL_MASK = new VType("emailMask");
    public static VType EMAIL_TEXT = new VType("emailText");
    public static VType URL = new VType("url");
    public static VType URL_TEXT = new VType("urlText");
}
