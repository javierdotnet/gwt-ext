/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.dd;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.dd.DD;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class BasicOnTopSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/dd/BasicOnTopSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Panel panel1 = new Panel();
            panel1.setTitle("Panel1");
            panel1.setBorder(true);
            panel1.setBodyStyle("background-color:#6D739A");
            panel1.setWidth(200);
            panel1.setHtml(SampleData.getShortBogusMarkup());

            Panel panel2 = new Panel();
            panel2.setTitle("Panel2");
            panel2.setBodyStyle("background-color:#566F4E");
            panel2.setBorder(true);
            panel2.setWidth(200);
            panel2.setHtml(SampleData.getShortBogusMarkup());

            Panel panel3 = new Panel();
            panel3.setTitle("Panel3");
            panel3.setBodyStyle("background-color:#7E5B60");
            panel3.setBorder(true);
            panel3.setWidth(200);
            panel3.setHtml(SampleData.getShortBogusMarkup());

            DD dd1 = new DDOnTop(panel1);
            DD dd2 = new DDOnTop(panel2);
            DD dd3 = new DDOnTop(panel3);

            horizontalPanel.add(panel1);
            horizontalPanel.add(panel2);
            horizontalPanel.add(panel3);

            panel.add(horizontalPanel);
        }

        return panel;
    }

    class DDOnTop extends DD {
        private int origZ = 0;


        DDOnTop(Component component) {
            super(component);
        }

        public void startDrag(int x, int y) {
            String zIndex = DOM.getStyleAttribute(this.getEl(), "zIndex");
            if(zIndex != null && !"".equals(zIndex)) {
                origZ = Integer.parseInt(zIndex);
            }
            DOM.setIntStyleAttribute(this.getEl(), "zIndex", 999);
        }

        public void endDrag(EventObject e) {
            DOM.setIntStyleAttribute(DDOnTop.this.getEl(), "zIndex", origZ);
        }
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This example builds on the basic drag and drop, keeping the dragged element on top of the others by changing its z-index property during the drag.</p>";
    }
}