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

package com.gwtext.sample.showcase.client.form;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.sample.showcase.client.SampleData;

public class Forms2Panel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;

    public Forms2Panel() {
        vp = new VerticalPanel();
        vp.setSpacing(15);
        initWidget(vp);
    }

    protected void onLoad() {
        if (!init) {
            init = true;
            setup();
        }
    }

    private void setup() {

        final Template resultTpl = new Template(
                "<div class=search-item>" +
                        "<h3><span> {states}</span> - {abbr}</h3>" +
                        "</div>"
        );

        final Store store = new SimpleStore(new String[]{"abbr", "states"}, SampleData.getStates());

        Form form = new Form("live-form");

        ComboBox cb = new ComboBox(new ComboBoxConfig() {
            {
                setMinChars(3);
                setFieldLabel("State");
                setStore(store);
                setDisplayField("states");
                setMode("local");
                setTriggerAction("all");
                setEmptyText("type here");
                setLoadingText("Searching...");
                setTypeAhead(true);
                setSelectOnFocus(true);
                setWidth(500);
                setTpl(resultTpl);
            }
        });

        form.add(cb);
        form.render();
        vp.add(form);
    }
}