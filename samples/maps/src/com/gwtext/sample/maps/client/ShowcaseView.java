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

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.XTemplate;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.DataView;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.DataViewListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;

public class ShowcaseView extends Panel {

    private ScreenManager screenManager;

    public ShowcaseView(ScreenManager screenManager) {
        this.screenManager = screenManager;
        setBorder(false);
        setLayout(new FitLayout());
        setAutoScroll(true);
    }

    protected void afterRender() {
        final Store store = ScreenManager.getStore();

        XTemplate template = new XTemplate(new String[]{
                "<tpl for='.'>",
                "<tpl if='thumbnail'>",
                "<div id={id}-dv class='thumb-wrap'>",
                "<div class='thumb'><img src='{thumbnail}' ext:qtip='{title}'></div>",
                "<span class='x-editable' ext:qtip='{title}'>{shortTitle}</span></div>",
                "</tpl>",
                "</tpl>",
                "<div class='x-clear'></div>"
        });

        Panel panel = new Panel();
        panel.setId("showcase-view");
        panel.setAutoWidth(true);
        panel.setAutoScroll(true);
        panel.setCollapsible(true);
        panel.setLayout(new FitLayout());
        panel.setTitle("Welcome to GWT-Ext 2.0 Maps");

        final DataView dataView = new DataView("div.thumb-wrap") {
            public void prepareData(Data data) {
                data.setProperty("shortTitle", Format.ellipsis(data.getProperty("title"), 15));
            }
        };

        dataView.addListener(new DataViewListenerAdapter() {

            public void onClick(DataView source, int index, Element node, EventObject e) {
                String id = DOMUtil.getID(node);
                String screenName = id.substring(0, id.length() - 3);
                Record[] records = store.query("id", screenName);
                Record record = records[0];
                final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");
                if (panel != null) {
                    String title = record.getAsString("title");
                    String icon = record.getAsString("icon");
                    screenManager.showScreen(panel, title, icon, screenName);
                }
            }
        });


        dataView.setTpl(template);
        dataView.setAutoWidth(true);
        dataView.setAutoHeight(true);
        dataView.setMultiSelect(false);
        dataView.setOverCls("x-view-over");
        dataView.setEmptyText("No Images to display");
        panel.add(dataView);

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                dataView.setStore(store);
                dataView.refresh();
            }
        });
        add(panel);
    }
}