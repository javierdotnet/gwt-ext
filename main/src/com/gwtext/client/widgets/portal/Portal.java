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

import com.gwtext.client.dd.DropTargetConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ColumnLayout;

/**
 * Portal class. A portal is created by instantiating this class, and adding {@link PortalColumn}'s with a specified
 * {@link com.gwtext.client.widgets.layout.ColumnLayoutData}.
 *
 * <br>
 * To each PortalColumn, a Portlet is added.
 */
//credits : this class has been adapted from the Ext portal sample
public class Portal extends Panel {

    private DropTargetConfig ddConfig;

    public Portal() {
        setLayout(new ColumnLayout());
        setAutoScroll(true);
        setCls("x-portal");
    }

    public Portal(DropTargetConfig ddConfig) {
        this();
        this.ddConfig = ddConfig;
    }

    protected void afterRender() {    
        PortalDropZone dropZone = new PortalDropZone(this, ddConfig);
    }
}
