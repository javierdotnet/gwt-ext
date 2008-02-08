/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.combo;

import com.google.gwt.user.client.Window;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Styled ComboBox that gets data from a remote Json web service.
 */
public class LiveSearchSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/LiveSearchSample.java.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setId("livesearch");

            //Use a ScriptTagProxy because you are getting data from a different domain using
            //a Json web service. If getting data from your own domain, then should use HttpProxy
            DataProxy dataProxy = new ScriptTagProxy("http://extjs.com/forum/topics-remote.php");

			RecordDef recordDef = new RecordDef(new FieldDef[]{
					new StringFieldDef("title", "topic_title"),
					new StringFieldDef("topicId", "topic_id"),
					new StringFieldDef("author", "author"),
					new DateFieldDef("lastPost", "post_time", "timestamp"),
					new StringFieldDef("excerpt", "post_text")
			});

			JsonReader reader = new JsonReader(recordDef);
			reader.setRoot("topics");
			reader.setTotalProperty("totalCount");
			reader.setId("post_id");

			final Store store = new Store(dataProxy, reader);
			store.load();

			final String resultTpl = "<div class=\"search-item\"><h3><span>{lastPost:date(\"M j, Y\")}<br />" +
					"by {author}</span>{title}</h3>{excerpt}</div>";

			ComboBox cb = new ComboBox();
			cb.setStore(store);
			cb.setDisplayField("title");
			cb.setTypeAhead(false);
			cb.setLoadingText("Searching...");
			cb.setWidth(440);
			cb.setPageSize(10);
			cb.setHideTrigger(true);
			cb.setTpl(resultTpl);
			cb.setMode(ComboBox.REMOTE);
			cb.setTitle("ExtJS Forums");
			cb.setHideLabel(true);
			cb.setItemSelector("div.search-item");

			cb.addListener(new ComboBoxListenerAdapter() {
				public void onSelect(ComboBox comboBox, Record record, int index) {
					String[] args = new String[]{record.getAsString("topicId"), record.getId()};
					String url = Format.format("http://extjs.com/forum/showthread.php?t={0}&p={1}", args);
					Window.open(url, "forum", "");
				}
			});

			Panel searchPanel = new Panel();
			searchPanel.setWidth(490);
            searchPanel.setHeight(150);
            searchPanel.setPaddings(20);
			searchPanel.setTitle("Search ExtJS Forums");
			searchPanel.setFrame(true);

            FormPanel form = new FormPanel();
            form.setBorder(false);
            form.add(cb);                        
            searchPanel.add(form);

			Panel instructionPanel = new Panel();
			instructionPanel.setBorder(false);
			instructionPanel.setPaddings(4,0,0,0);
			instructionPanel.setHtml("Live search requires a minimum of 4 characters.");
			searchPanel.add(instructionPanel);

			panel.add(searchPanel);
		}
		return panel;
	}

	public String getIntro() {
		return "<p>\n" +
				"    <b>Combo with Templates & Ajax</b>\n" +
				"    <p>This is a more advanced example that shows how you can combine paging, Template and a remote data store\n" +
				"    to create a \"live search\" feature.</p><p>Live search requires a minimum of 4 characters.</p>\n" +
                "   <p>This examples calls a Json Webservice to retreive data from the ExtJS forums and populate the Store backing the ComboBox.</p>"+
                "</p>";
	}

}