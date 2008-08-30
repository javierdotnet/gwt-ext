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
 
package com.gwtext.sample.showcase2.client.panel;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.dd.DD;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class PanelsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/panel/PanelsSample.java.html";
    }

    public String getCssUrl() {
        return "source/panel/PanelsSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            HorizontalPanel horizontalPanel = new HorizontalPanel();
            horizontalPanel.setSpacing(15);

            Panel collapsiblePanel = new Panel();
            collapsiblePanel.setTitle("Collapsible Panel");
            collapsiblePanel.setWidth(200);
            collapsiblePanel.setCollapsible(true);
            collapsiblePanel.setHtml(SampleData.getShortBogusMarkup());

            Panel iconPanel = new Panel();
            iconPanel.setTitle("Icon Panel");
            iconPanel.setIconCls("paste-icon");
            iconPanel.setWidth(200);
            iconPanel.setHtml(SampleData.getShortBogusMarkup());
            iconPanel.setShadow(true);

            HorizontalPanel horizontalPanel2 = new HorizontalPanel();
            horizontalPanel2.setSpacing(15);

            Panel draggablePanel = new Panel();
            draggablePanel.setTitle("Draggable Panel");
            draggablePanel.setDraggable(true);
            draggablePanel.setWidth(200);
            draggablePanel.setHtml(SampleData.getShortBogusMarkup());
            draggablePanel.setShadow(true);
            DD dd = new DD(draggablePanel);

            Panel toolsPanel = new Panel();
            toolsPanel.setTitle("Tools Panel");
            toolsPanel.setIconCls("paste-icon");
            toolsPanel.setWidth(200);
            toolsPanel.setHtml(SampleData.getShortBogusMarkup());
            toolsPanel.setShadow(true);
            toolsPanel.addTool(new Tool(Tool.GEAR, new Function() {
                public void execute() {
                    MessageBox.alert("Settings", "The Settings tool was clicked");
                }
            }, "Settings"));
            toolsPanel.addTool(new Tool(Tool.SEARCH, new Function() {
                public void execute() {
                    MessageBox.alert("Search", "The Search tool was clicked");
                }
            }, "Search"));

            Panel windowPanel = new Panel();
            windowPanel.setHtml(SampleData.getShortBogusMarkup());
            windowPanel.setShadow(true);

            final Window window = new Window();
            window.setTitle("Window Panel");
            window.setIconCls("paste-icon");
            window.setMaximizable(true);
            window.setResizable(true);
            window.setLayout(new FitLayout());
            window.setWidth(200);
            window.setModal(false);

            window.addTool(new Tool(Tool.REFRESH, new Function() {
                public void execute() {
                    MessageBox.alert("Refresh", "The Refresh tool was clicked");
                }
            }, "Refresh"));
            window.addTool(new Tool(Tool.PIN, new Function() {
                public void execute() {
                    MessageBox.alert("Pin", "The Pin tool was clicked");
                }
            }, "Pin"));
            window.add(windowPanel);

            Button button = new Button("Show Window Panel", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    window.show();
                }
            });

            window.setAnimateTarget(button.getId());

            HorizontalPanel horizontalPanel3 = new HorizontalPanel();
            horizontalPanel3.setSpacing(15);
            HorizontalPanel horizontalPanel4 = new HorizontalPanel();
            horizontalPanel4.setSpacing(15);
            
            SyntaxHighlightPanel shPanelXml = new SyntaxHighlightPanel(getXmlData(), SyntaxHighlightPanel.SYNTAX_XML);
            shPanelXml.setWidth(400);
            shPanelXml.setTitle("SyntaxHighlightPanel XML");
            shPanelXml.setShadow(true);
            SyntaxHighlightPanel shPanelJava = new SyntaxHighlightPanel(getJavaData(), SyntaxHighlightPanel.SYNTAX_JAVA);
            shPanelJava.setWidth(400);
            shPanelJava.setTitle("SyntaxHighlightPanel Java");
            shPanelJava.setShadow(true);
            shPanelJava.setShowGutter(false);
            shPanelJava.setShowControls(false);
            shPanelJava.setShowColumns(false);
            shPanelJava.setBorder(true);

            horizontalPanel.add(collapsiblePanel);
            horizontalPanel.add(toolsPanel);
            horizontalPanel2.add(draggablePanel);
            horizontalPanel2.add(button);
            horizontalPanel3.add(shPanelXml);
            horizontalPanel4.add(shPanelJava);

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));
            verticalPanel.add(horizontalPanel);
            verticalPanel.add(horizontalPanel2);
            verticalPanel.add(horizontalPanel3);
            verticalPanel.add(horizontalPanel4);

            panel.add(verticalPanel);
        }
        return panel;
    }
    
    public String getXmlData(){
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("<countries>\n");
    	sb.append("  <team title=\"Iceland\">\n");
    	sb.append("    <country title=\"Australia\">\n");
    	sb.append("    <country title=\"Brazil\">\n");
    	sb.append("    <country title=\"Canada\">\n");
    	sb.append("    <country title=\"China\">\n");
    	sb.append("  </team>\n");
    	sb.append("  <team title=\"Finland\">\n");
    	sb.append("    <country title=\"Germany\">\n");
    	sb.append("    <country title=\"France\">\n");
    	sb.append("    <country title=\"Canada\">\n");
    	sb.append("    <country title=\"India\">\n");
    	sb.append("    <country title=\"Seychelles\">\n");
    	sb.append("  </team>\n\n");

    	sb.append("  <team title=\"Switzerland\">\n");
    	sb.append("    <country title=\"United States\">\n");
    	sb.append("    <country title=\"Japan\">\n");
    	sb.append("    <country title=\"Italy\">\n");
    	sb.append("    <country title=\"Finland\">\n");
    	sb.append("  </team>\n");
    	sb.append("</countries>\n");
    	
    	return sb.toString();
    }
    
    public String getJavaData(){
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("public class foo{\n");
    	sb.append("	 private int i = 0;\n");
    	sb.append("	 public foo(){\n");
    	sb.append("	   i = 1;\n");
    	sb.append("	 }\n\n");
    	sb.append("	 public void print(){\n");
    	sb.append("	   System.out.println(\"counter = \" + i++);\n");
    	sb.append("	 }\n");
    	sb.append("}\n");
    	
    	return sb.toString();
    }

    public String getIntro() {
        return "A demonstration of basic Panel styles and configurations.";
    }
}