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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class ComboBoxStyledPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CountryData.java.html";
    }

    public String getSourceUrl() {
        return "combo/ComboBoxStyledPanel.java.html";
    }

    public Panel getViewPanel() {

        final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());

        final Template template = new Template("<div class=\"x-combo-list-item\"><img src=\"images/flags/{abbr}.gif\"> " +
                "{country}<div class=\"x-clear\"></div></div>");

        Form form = new Form();

        ComboBox cb = new ComboBox(new ComboBoxConfig() {
            {
                setMinChars(1);
                setFieldLabel("Countries");
                setStore(store);
                setDisplayField("country");
                setMode("local");
                setTriggerAction("all");
                setEmptyText("Select Country");
                setTypeAhead(true);
                setSelectOnFocus(true);
                setWidth(200);
                setResizable(true);
                setTpl(template);
                setTitle("Countries");
            }
        });

        form.add(cb);
        form.render();

        Panel panel = createPanel();
        panel.add(form);
        return panel;
    }
}