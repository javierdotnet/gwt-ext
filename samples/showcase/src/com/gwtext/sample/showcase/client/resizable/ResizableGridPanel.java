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
package com.gwtext.sample.showcase.client.resizable;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.widgets.Resizable;
import com.gwtext.client.widgets.ResizableConfig;
import com.gwtext.client.widgets.event.ResizableListenerAdapter;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class ResizableGridPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CompanyData.java.html";
    }

    public String getSourceUrl() {
        return "resizable/ResizableGridPanel.java.html";
    }

    public Panel getViewPanel() {

        final Grid grid = SampleData.getSampleGrid("grid-resizable", "460px", "300px");

        Resizable resizable = new Resizable("grid-resizable", new ResizableConfig() {
            {
                setWrap(true);
                setMinHeight(100);
                setPinned(true);
                setHandles(Resizable.SOUTH);
            }
        });
        resizable.addResizableListener(new ResizableListenerAdapter() {
            public void onResize(Resizable self, int width, int height) {
                grid.autoSize();
            }
        });
        grid.render();

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Resizable grid</h1>"));
        panel.add(new HTML("<p>Example of a Resizable Grid.</p>"));
        panel.add(grid);

        return panel;
    }
}