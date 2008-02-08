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
package com.gwtext.sample.showcase.client.grid;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class RowRenderingGridPanel extends ShowcaseExampleVSD {

     public String getDataUrl() {
         return "data/CompanyData.java.html";
     }

     public String getSourceUrl() {
         return "grid/RowRenderingGridPanel.java.html";
     }

     public Panel getViewPanel() {

         Grid grid = SampleData.getSampleGrid("grid-row-rendering-example", "460px", "300px");

         grid.setView(new GridView() {
             public String getRowClass(Record record, int index) {
                 float price = record.getAsFloat("price");
                 if(price <20) {
                     return "yellowClass";
                 } else if (price < 40) {
                     return "orangeClass";
                 } else if (price < 80) {
                     return "blueClass";
                 } else {
                     return "greenClass";
                 }
             }
         });
         grid.render();

         Panel panel = createPanel();
         panel.add(new HTML("<h1>Array Grid Example with custom row colors</h1>"));
         panel.add(new HTML("<p>This example shows how to customize the row background colors.</p>"));
         panel.add(grid);

         return panel;
     }
 }