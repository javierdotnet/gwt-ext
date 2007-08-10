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
package com.gwtext.sample.showcase.client.combo;

import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class ComboBoxPagingPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CompanyData.java.html";
    }

    public String getSourceUrl() {
        return "combo/ComboBoxPagingPanel.java.html";
    }

    public Panel getViewPanel() {

        MemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyData());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia")
                }
        );

        ArrayReader reader = new ArrayReader(recordDef);
        final Store store = new Store(proxy, reader);
        store.load();

        Form form = new Form();
        ComboBox cb = new ComboBox(new ComboBoxConfig() {
            {
                setMinChars(1);
                setFieldLabel("Company");
                setStore(store);
                setDisplayField("company");
                setMode("remote");
                setTriggerAction("all");
                setEmptyText("Enter company");
                setLoadingText("Searching...");
                setTypeAhead(true);
                setSelectOnFocus(true);
                setWidth(250);
                setPageSize(10);
            }
        });

        form.add(cb);
        form.render();

        Panel panel = createPanel();
        panel.add(form);
        return panel;
    }
}