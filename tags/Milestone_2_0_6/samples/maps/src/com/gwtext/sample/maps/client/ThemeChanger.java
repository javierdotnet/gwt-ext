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

import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;


/**
 * A simple dynamic Theme Changer ComboBox. You must have the Ext theme stylesheet declared in your host html page
 * using the id "theme".
 * <p/>
 * For example
 * <p/>
 * &lt;link id="theme" rel="stylesheet" type="text/css" href="js/ext/resources/css/xtheme-gray.css"/&gt;
 * or
 * &lt;link id="theme" rel="stylesheet" type="text/css" href="xtheme-default.css"/&gt;
 */
public class ThemeChanger extends ComboBox {

	public ThemeChanger() {

		final Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
                new Object[]{"themes/silverCherry/css/xtheme-silverCherry.css", "Silver Cherry"},
                new Object[]{"js/ext/resources/css/xtheme-gray.css", "Gray"},
				new Object[]{"xtheme-default.css", "Aero Glass"},
				new Object[]{"themes/green/css/xtheme-green.css", "Green"},
				new Object[]{"themes/slate/css/xtheme-slate.css", "Slate"},
				new Object[]{"themes/indigo/css/xtheme-indigo.css", "Indigo"}
		});
		store.load();

		setFieldLabel("Select Theme");
		setEditable(false);
		setStore(store);
		setDisplayField("label");
		setForceSelection(true);
		setTriggerAction(ComboBox.ALL);
		setValue("Silver Cherry");
		setFieldLabel("Switch theme");
		addListener(new ComboBoxListenerAdapter() {
			public void onSelect(ComboBox comboBox, Record record, int index) {
				String theme = record.getAsString("theme");
				CSS.swapStyleSheet("theme", theme);
			}
		});
		setWidth(100);
	}
}