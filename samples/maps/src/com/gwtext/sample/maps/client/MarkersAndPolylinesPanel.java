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
 
package com.gwtext.sample.maps.client;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.widgets.map.*;

public class MarkersAndPolylinesPanel extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/MarkersAndPolylinesPanel.java.html";
    }

    public Panel getViewPanel() {

        if (panel == null) {
            panel = new Panel();
            panel.setPaddings(15);

            final MapPanel mapPanel = new GoogleMap();
            mapPanel.addLargeControls();
            mapPanel.addMapTypeControls();

            final Polyline myPoly = new Polyline(new LatLonPoint[]{
                    new LatLonPoint(37.7945928242851, -122.395033836365),
                    new LatLonPoint(37.7938467508748, -122.393960952759),
                    new LatLonPoint(37.7945928242851, -122.39275932312),
                    new LatLonPoint(37.789505810689, -122.387609481812),
                    new LatLonPoint(37.7782792282611, -122.387351989746)});
            myPoly.setColor("#FF7400");

            final Polyline myPoly2 = new Polyline(new LatLonPoint[]{new LatLonPoint(37.7768545853105, -122.390570640564),
                    new LatLonPoint(37.7690524823224, -122.397179603577),
                    new LatLonPoint(37.7668813159428, -122.394347190857),
                    new LatLonPoint(37.7658635597592, -122.407650947571)});
            myPoly2.setColor("blue");

            final Polyline myPoly3 = new Polyline(new LatLonPoint[]{new LatLonPoint(37.7689167862912, -122.408037185669),
                    new LatLonPoint(37.7765493011063, -122.417650222778),
                    new LatLonPoint(37.7945928242851, -122.395033836365)});
            myPoly3.setColor("#FF1A00");


            mapPanel.setCenterAndZoom(new LatLonPoint(37.78, -122.395033836365), 12);

            final TabPanel tabPanel = new TabPanel();
            tabPanel.setWidth(200);
            tabPanel.setHeight(100);

            Panel panel1 = new Panel("Panel 1");
            Panel panel2 = new Panel("Panel 1");
            panel1.setPaddings(5);
            panel1.add(new Button("Click Me!", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MessageBox.alert("Button Clicked");
                }
            }));

            tabPanel.add(panel1);
            tabPanel.add(panel2);

            LatLonPoint myPoint = new LatLonPoint(37.7945928242851, -122.395033836365);

            final Marker marker = new Marker(myPoint);
            marker.setInfoBubble(tabPanel);

            FormPanel form = new FormPanel();
            form.setTitle("Filter");
            form.setCollapsible(true);
            form.setLabelWidth(50);

            form.setWidth(160);
            form.setFrame(true);
            Checkbox cb1 = new Checkbox("Polyline 1");

            cb1.setChecked(true);
            cb1.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    if (checked) {
                        mapPanel.addPolyline(myPoly);
                    } else {
                        mapPanel.removePolyline(myPoly);
                    }
                }
            });

            Checkbox cb2 = new Checkbox("Polyline 2");
            cb2.setChecked(true);
            cb2.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    if (checked) {
                        mapPanel.addPolyline(myPoly2);
                    } else {
                        mapPanel.removePolyline(myPoly2);
                    }
                }
            });

            Checkbox cb3 = new Checkbox("Polyline 3");
            cb3.setChecked(true);
            cb3.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    if (checked) {
                        mapPanel.addPolyline(myPoly3);
                    } else {
                        mapPanel.removePolyline(myPoly3);
                    }
                }
            });

            Checkbox cb4 = new Checkbox("Marker");
            cb4.setChecked(true);
            cb4.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    if (checked) {
                        mapPanel.addMarker(marker);
                    } else {
                        mapPanel.removeMarker(marker);
                    }
                }
            });

            form.add(cb1);
            form.add(cb2);
            form.add(cb3);
            form.add(cb4);

            mapPanel.addMarker(marker);
            mapPanel.setWidth(500);
            mapPanel.setHeight(500);

            mapPanel.add(form, 50, 10);
            panel.add(mapPanel);

        }
        return panel;
    }

    public String getIntro() {
        return "An example of markers, polylines and filtering";
    }
}