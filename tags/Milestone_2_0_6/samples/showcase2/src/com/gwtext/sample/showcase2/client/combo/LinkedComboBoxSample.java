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

import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * An example of a Linked ComboBox.
 */

//credit to Jozef Sakalos for original Ext tutorial
//http://extjs.com/learn/Tutorial:Linked_Combos_Tutorial_for_Ext_2    
public class LinkedComboBoxSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/combo/LinkedComboBoxSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();

            FormPanel form = new FormPanel();
            form.setTitle("Linked ComboBox");
            form.setFrame(true);
            form.setWidth(350);

            // countries store
            Object[][] countries = new Object[][]{
                    new Object[]{"USA", "United States of America"},
                    new Object[]{"D", "Germany"},
                    new Object[]{"F", "France"},
                    new Object[]{"GB", "Great Britain"},
            };

            final Store countriesStore = new SimpleStore(new String[]{"cid", "country"}, countries);
            countriesStore.load();

            //cities store
            Object[][] cities = new Object[][]{
                    new Object[]{new Integer(1), "USA", "New York"},
                    new Object[]{new Integer(2), "USA", "Cleveland"},
                    new Object[]{new Integer(3), "USA", "Austin"},
                    new Object[]{new Integer(4), "USA", "Los Angeles"},
                    new Object[]{new Integer(5), "D", "Munich"},
                    new Object[]{new Integer(6), "D", "Bonn"},
                    new Object[]{new Integer(7), "F", "Paris"},
                    new Object[]{new Integer(8), "F", "Nice"},
                    new Object[]{new Integer(9), "GB", "London"},
                    new Object[]{new Integer(10), "GB", "Glasgow"},
                    new Object[]{new Integer(11), "GB", "Liverpool"}
            };

            final Store citiesStore = new SimpleStore(new String[]{"id", "cid", "city"}, cities);
            citiesStore.load();

            final ComboBox countryCB = new ComboBox();
            countryCB.setFieldLabel("Select Country");
            countryCB.setStore(countriesStore);
            countryCB.setDisplayField("country");
            countryCB.setMode(ComboBox.LOCAL);
            countryCB.setTriggerAction(ComboBox.ALL);
            countryCB.setForceSelection(true);
            countryCB.setValueField("cid");
            countryCB.setReadOnly(true);

            final ComboBox cityCB = new ComboBox();
            cityCB.setFieldLabel("Select City");
            cityCB.setStore(citiesStore);
            cityCB.setDisplayField("city");
            cityCB.setValueField("id");
            cityCB.setMode(ComboBox.LOCAL);
            cityCB.setTriggerAction(ComboBox.ALL);
            cityCB.setLinked(true);
            cityCB.setForceSelection(true);
            cityCB.setReadOnly(true);

            countryCB.addListener(new ComboBoxListenerAdapter() {

                public void onSelect(ComboBox comboBox, Record record, int index) {
                    cityCB.setValue("");
                    citiesStore.filter("cid", comboBox.getValue());
                }
            });

            form.add(countryCB);
            form.add(cityCB);

            panel.add(form);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates a linked ComboBox where the available options in the second ComboBox depend on" +
                "the selection in the first ComboBox.</p>";
    }
}