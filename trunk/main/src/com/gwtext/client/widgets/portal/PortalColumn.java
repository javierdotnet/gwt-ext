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
package com.gwtext.client.widgets.portal;

import com.gwtext.client.widgets.Container;
import com.gwtext.client.widgets.layout.AnchorLayout;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.core.Paddings;

/**
 * A Portal column to which the Portlets are added.
 */
//credits : this class has been adapted from the Ext portal sample
public class PortalColumn extends Container {

    public PortalColumn() {
        setLayout(new AnchorLayout());
        setAutoEl("div");
        setCls("x-portal-column");
		setPaddings(10, 10, 0, 10);
	}

    public void add(Portlet portlet) {
        super.add(portlet, new AnchorLayoutData("100%"));
    }

	/**
	 * Set the paddings for the PortletColumn.
	 *
 	 * @param top the rop padding
	 * @param left the left padding
	 * @param right the right padding
	 * @param bottom the botton padding
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setPaddings(int top, int left, int right, int bottom) throws IllegalStateException {
        Paddings paddings = new Paddings(top, left, right, bottom);
        String style = paddings.getStyleString();
        String bodyStyle = "";
        if (bodyStyle == null) {
            setStyle(style);
        } else {
            setStyle(bodyStyle + style);
        }
    }
}
