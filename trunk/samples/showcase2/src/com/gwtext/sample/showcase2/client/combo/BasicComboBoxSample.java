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
 
package com.gwtext.sample.showcase2.client.combo;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.ComboBoxCallback;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Basic ComboBox.
 */
public class BasicComboBoxSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/BasicComboBoxSample.java.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {

			panel = new Panel();

            FormPanel form = new FormPanel();
			form.setLabelWidth(35);
			form.setBorder(false);
            //create a Store using local array data
			final Store store = new SimpleStore(new String[]{"abbr", "state", "nick"}, SampleData.getStates());
            store.load();

            final ComboBox cb = new ComboBox();
			cb.setForceSelection(true);
			cb.setMinChars(1);
			cb.setFieldLabel("State");
			cb.setStore(store);
			cb.setDisplayField("state");
			cb.setMode(ComboBox.LOCAL);
			cb.setTriggerAction(ComboBox.ALL);
			cb.setEmptyText("Enter state");
			cb.setLoadingText("Searching...");
			cb.setTypeAhead(true);
			cb.setSelectOnFocus(true);
			cb.setWidth(200);
            cb.setValueField("abbr");
            //cb.setTpl("<tpl for=\".\"><div ext:qtip=\"{state}. {nick}\" class=\"x-combo-list-item\">{state}</div></tpl>");

            //this hides the dropdown besides the ComboBox field
            cb.setHideTrigger(false);

			cb.addListener(new ComboBoxListenerAdapter() {
				public boolean doBeforeQuery(ComboBox comboBox, ComboBoxCallback cb) {
					log(EVENT, "ComboBox::doBeforeQuery()");
					return true;
				}

				public boolean doBeforeSelect(ComboBox comboBox, Record record, int index) {
					log(EVENT, "ComboBox::doBeforeSelect('" + record.getAsString("states") + "')");
					return super.doBeforeSelect(comboBox, record, index);
				}

				public void onCollapse(ComboBox comboBox) {
					log(EVENT, "ComboBox::onCollapse()");
				}

				public void onExpand(ComboBox comboBox) {
					log(EVENT, "ComboBox::onExpand()");
				}

				public void onSelect(ComboBox comboBox, Record record, int index) {
					log(EVENT, "ComboBox::onSelect('" + record.getAsString("states") + "')");
				}

				public void onBlur(Field field) {
					log(EVENT, "ComboBox::onBlur()");
				}

				public void onChange(Field field, Object newVal, Object oldVal) {
					log(EVENT, "ComboBox::onChange(" + oldVal + "-->" + newVal + ")");
				}

				public void onFocus(Field field) {
					log(EVENT, "ComboBox::onFocus()");
				}

				public void onInvalid(Field field, String msg) {
					super.onInvalid(field, msg);
				}

				public void onSpecialKey(Field field, EventObject e) {
					log(EVENT, "ComboBox::onSpecialKey(key code " + e.getKey() + ")");
				}
			});

            form.add(cb);
            panel.add(form);
		}
		return panel;
	}

	protected boolean showEvents() {
		return true;
	}

	public String getIntro() {
		return "<p>This example shows a basic ComboBox populated with data from a Store. It also associates a custom tooltip based on a template for each ComboBox item.</p> " +
                "<p>A Store can be populated from a wide varierty of data sources like XML or Json data from your webserver, Json data from another server using cross " +
                "domain script loading or local array data. GWT-Plus supports populating a Store with Javabeans returned using GWT-RPC.</p>" +
				"<p>This particular example loads data into the Store using local array data.</p>";
	}
}