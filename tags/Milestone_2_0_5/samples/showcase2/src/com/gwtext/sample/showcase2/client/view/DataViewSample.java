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
 
package com.gwtext.sample.showcase2.client.view;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.DataView;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class DataViewSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/view/DataViewSample.java.html";
    }

    public String getCssUrl() {
        return "source/view/DataViewSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            MemoryProxy dataProxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("name"),
                    new IntegerFieldDef("size"),
                    new DateFieldDef("lastmod", "timestamp"),
                    new StringFieldDef("url")
            });

            ArrayReader reader = new ArrayReader(recordDef);

            //for loading from json data
            //JsonStore store = new JsonStore("data/images.json", "images", recordDef);
            //store.load();

            //or

            //HttpProxy dataProxy = new HttpProxy("data/images.json");
            //JsonReader reader = new JsonReader("images", recordDef);

            final Store store = new Store(dataProxy, reader, true);
            store.load();

            XTemplate template = new XTemplate(new String[]{
                    "<tpl for='.'>",
                    "<div class='thumb-wrap'>",
                    "<div class='thumb'><img src='{url}' ext:qtip='{name}'></div>",
                    "<span class='x-editable' ext:qtip='{name}'>{shortName}</span></div>",
                    "</tpl>",
                    "<div class='x-clear'></div>"
            });

            Panel inner = new Panel();
            inner.setWidth(535);
            inner.setId("images-view");
            inner.setFrame(true);
            inner.setAutoHeight(true);
            inner.setCollapsible(true);
            inner.setLayout(new FitLayout());
            inner.setTitle("Simple DataView");

            DataView dataView = new DataView("div.thumb-wrap") {
                public void prepareData(Data data) {
                    data.setProperty("shortName", Format.ellipsis(data.getProperty("name"), 15));
                }
            };
            dataView.setWidth(535);

            dataView.addListener(new DataViewListenerAdapter() {
                public boolean doBeforeClick(DataView source, int index, Element node, EventObject e) {

                    log(EVENT, "doBeforeClick::" + getSelectedMovies(source));
                    return true;
                }

                public boolean doBeforeSelect(DataView source, Element node, Element[] selections) {
                    log(EVENT, "doBeforeSelect::" + getSelectedMovies(source));
                    return super.doBeforeSelect(source, node, selections);
                }

                public void onClick(DataView source, int index, Element node, EventObject e) {
                    log(EVENT, "onClick::" + getSelectedMovies(source));
                    super.onClick(source, index, node, e);
                }

                public void onContainerClick(DataView source, EventObject e) {
                    log(EVENT, "onContainerClick");
                    super.onContainerClick(source, e);
                }

                public void onContextMenu(DataView source, int index, Element node, EventObject e) {
                    log(EVENT, "onContextMenu");
                    super.onContextMenu(source, index, node, e);
                }

                public void onDblClick(DataView source, int index, Element node, EventObject e) {
                    log(EVENT, "onDblClick");
                    super.onDblClick(source, index, node, e);
                }

                public void onSelectionChange(DataView view, Element[] selections) {
                    log(EVENT, "onSelectionChange");
                    super.onSelectionChange(view, selections);
                }
            });

            dataView.setStore(store);
            dataView.setTpl(template);
            dataView.setAutoHeight(true);
            dataView.setMultiSelect(true);
            dataView.setOverCls("x-view-over");
            dataView.setEmptyText("No Images to display");

            inner.add(dataView);

            panel.add(inner);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    private String getSelectedMovies(DataView view) {
        Record[] records = view.getSelectedRecords();
        String msg = "";
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            msg += record.getAsString("name") + " ";
        }
        return msg;
    }

    private Object[][] getData() {
        return new Object[][]{
                new Object[]{"Pirates of the Caribbean", new Integer(2120), new Long(1180231870000l), "images/view/carribean.jpg"},
                new Object[]{"Resident Evil", new Integer(2120), new Long(1180231870000l), "images/view/resident_evil.jpg"},
                new Object[]{"Blood Diamond", new Integer(2120), new Long(1180231870000l), "images/view/blood_diamond.jpg"},
                new Object[]{"No Reservations", new Integer(2120), new Long(1180231870000l), "images/view/no_reservations.jpg"},
                new Object[]{"Casino Royale", new Integer(2120), new Long(1180231870000l), "images/view/casino_royale.jpg"},
                new Object[]{"Good Shepherd", new Integer(2120), new Long(1180231870000l), "images/view/good_shepherd.jpg"},
                new Object[]{"Ghost Rider", new Integer(2120), new Long(1180231870000l), "images/view/ghost_rider.jpg"},
                new Object[]{"Batman Begins", new Integer(2120), new Long(1180231870000l), "images/view/batman_begins.jpg"},
                new Object[]{"Last Samurai", new Integer(2120), new Long(1180231870000l), "images/view/last_samurai.jpg"},
                new Object[]{"Italian Job", new Integer(2120), new Long(1180231870000l), "images/view/italian_job.jpg"},
                new Object[]{"Mission Impossible III", new Integer(2120), new Long(1180231870000l), "images/view/mi3.jpg"},
                new Object[]{"Mr & Mrs Smith", new Integer(2120), new Long(1180231870000l), "images/view/smith.jpg"},
                new Object[]{"Inside Man", new Integer(2120), new Long(1180231870000l), "images/view/inside_man.jpg"},
                new Object[]{"The Island", new Integer(2120), new Long(1180231870000l), "images/view/island.jpg"}
        };
    }

    public String getIntro() {
        return "<p>This example demonstrates the use of the DataView class. DataView is a very powerful class yet easy to use.</p>" +
                "<p>You essentially pass DataView a Store, and a template on how to render a given Store record and it does the rest. " +
                "It is important to note that the output of DataView is not just static html, but a control that is backed by a rich event model" +
                " giving you complete control over that actions you want to carry when, say, a given item is clicked.</p>";
    }
}