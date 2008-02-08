/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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