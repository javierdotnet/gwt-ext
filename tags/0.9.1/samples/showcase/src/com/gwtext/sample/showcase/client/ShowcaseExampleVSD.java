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
package com.gwtext.sample.showcase.client;

import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.layout.ContentPanel;

public abstract class ShowcaseExampleVSD extends ShowcaseExample {

    public void setup() {
        ContentPanel view = new ContentPanel(Ext.generateId(), "View");
        view.add(getViewPanel());

        final String sourceUrl = getSourceUrl();
        if (sourceUrl != null) {
            String dataUrl = getDataUrl();
            if (dataUrl != null) {
                panels = new ContentPanel[3];
                panels[2] = getUrlContentPanel("Data", dataUrl);
            } else {
                panels = new ContentPanel[2];
            }
            ContentPanel source = getUrlContentPanel("Source", sourceUrl);
            panels[0] = view;
            panels[1] = source;
        } else {
            panels = new ContentPanel[1];
            panels[0] = view;
        }
    }

    public String getDataUrl() {
        return null;
    }

    public abstract String getSourceUrl();

    public abstract Panel getViewPanel();

}
