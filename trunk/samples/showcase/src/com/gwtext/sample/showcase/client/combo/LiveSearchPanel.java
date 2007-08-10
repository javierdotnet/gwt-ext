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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormConfig;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class LiveSearchPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "combo/LiveSearchPanel.java.html";
    }

    public Panel getViewPanel() {

        DataProxy dataProxy = new ScriptTagProxy("http://extjs.com/forum/topics-remote.php");

        JsonReader reader = new JsonReader(new JsonReaderConfig() {
            {
                setRoot("topics");
                setTotalProperty("totalCount");
                setId("post_id");
            }
        }, new RecordDef(new FieldDef[]{
                new StringFieldDef("title", "topic_title"),
                new StringFieldDef("topicId", "topic_id"),
                new StringFieldDef("author", "author"),
                new DateFieldDef("lastPost", "post_time", "timestamp"),
                new StringFieldDef("excerpt", "post_text")
        }));

        final Store store = new Store(dataProxy, reader);
        store.load();

        Form form = new Form(new FormConfig() {
            {
                setWidth(610);
                setSurrondWithBox(true);
                setHideLabels(true);
                setHeader("Search the Ext Forums");
            }
        });

        final Template resultTpl = new Template("<div class=\"search-item\"><h3><span>{lastPost:date(\"M j, Y\")}<br />" +
                                                    "by {author}</span>{title}</h3>{excerpt}</div>");
        ComboBox cb = new ComboBox(new ComboBoxConfig() {
            {
                setStore(store);
                setDisplayField("title");
                setTypeAhead(false);
                setLoadingText("Searching...");
                setWidth(570);
                setPageSize(10);
                setHideTrigger(true);
                setTpl(resultTpl);
                setMode("remote");
                setTitle("ExtJS Forums");

                setComboBoxListener(new ComboBoxListenerAdapter() {
                    public void onSelect(ComboBox comboBox, Record record, int index) {
                        String[] args = new String[]{record.getAsString("topicId"), record.getId()};
                        String url = Format.format("http://extjs.com/forum/showthread.php?t={0}&p={1}", args);
                        Window.open(url, "forum", "");
                    }
                });
            }
        });

        form.add(cb);
        form.render();

        Panel panel = createPanel();
        panel.add(new HTML(intro));
        panel.add(form);
        return panel;
    }

    private static String intro = "<p>\n" +
            "    <b>Combo with Templates and Ajax</b><br />\n" +
            "    This is a more advanced example that shows how you can combine paging, Ext.Template and a remote data store\n" +
            "    to create a \"live search\" feature. Live search requires a minimum of 4 characters.\n" +
            "</p>"; 
}