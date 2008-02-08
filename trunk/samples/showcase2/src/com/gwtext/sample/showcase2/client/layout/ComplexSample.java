/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.layout;

import com.google.gwt.user.client.ui.HTML;
import com.gwtext.client.core.Margins;
import com.gwtext.client.core.RegionPosition;
import com.gwtext.client.widgets.BoxComponent;
import com.gwtext.client.widgets.HTMLPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.grid.PropertyGridPanel;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ComplexSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/layout/ComplexSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new FitLayout());

            Panel borderPanel = new Panel();
            borderPanel.setLayout(new BorderLayout());

            //add north panel
            //raw html
            BoxComponent northPanel = new BoxComponent();
            northPanel.setEl(new HTML("<p>north - generally for menus, toolbars and/or advertisements</p>").getElement());
            northPanel.setHeight(32);
            borderPanel.add(northPanel, new BorderLayoutData(RegionPosition.NORTH));

            //add south panel
            Panel southPanel = new HTMLPanel("<p>south - generally for informational stuff, also could be for status bar</p>");
            southPanel.setHeight(100);
            southPanel.setCollapsible(true);
            southPanel.setTitle("South");

            BorderLayoutData southData = new BorderLayoutData(RegionPosition.SOUTH);
            southData.setMinSize(100);
            southData.setMaxSize(200);
            southData.setMargins(new Margins(0, 0, 0, 0));
            southData.setSplit(true);
            borderPanel.add(southPanel, southData);

            //add east panel
            Panel eastPanel = new Panel();
            eastPanel.setTitle("East Side");
            eastPanel.setCollapsible(true);
            eastPanel.setWidth(225);
            eastPanel.setLayout(new FitLayout());

            BorderLayoutData eastData = new BorderLayoutData(RegionPosition.EAST);
            eastData.setSplit(true);
            eastData.setMinSize(175);
            eastData.setMaxSize(400);
            eastData.setMargins(new Margins(0, 0, 5, 0));

            borderPanel.add(eastPanel, eastData);

            TabPanel tabPanel = new TabPanel();
            tabPanel.setBorder(false);
            tabPanel.setActiveTab(1);

            Panel tabOne = new Panel();
            tabOne.setHtml("<p>A TabPanel component can be a region.</p>");
            tabOne.setTitle("A Tab");
            tabOne.setAutoScroll(true);
            tabPanel.add(tabOne);

            PropertyGridPanel propertyGrid = new PropertyGridPanel();
            propertyGrid.setTitle("Property Grid");

            Map source = new HashMap();
            source.put("(name)", "Properties Grid");
            source.put("grouping", Boolean.FALSE);
            source.put("autoFitColumns", Boolean.TRUE);
            source.put("productionQuality", Boolean.FALSE);
            source.put("created", new Date());
            source.put("tested", Boolean.FALSE);
            source.put("version", new Float(0.1f));
            source.put("borderWidth", new Integer(1));

            propertyGrid.setSource(source);

            tabPanel.add(propertyGrid);
            eastPanel.add(tabPanel);

            final AccordionLayout accordion = new AccordionLayout(true);

            Panel westPanel = new Panel();
			westPanel.setTitle("West");
			westPanel.setCollapsible(true);
            westPanel.setWidth(200);
            westPanel.setLayout(accordion);

            Panel navPanel = new Panel();
            navPanel.setHtml("<p>Hi. I'm the west panel.</p>");
            navPanel.setTitle("Navigation");
            navPanel.setBorder(false);
            navPanel.setIconCls("forlder-icon");
            westPanel.add(navPanel);

            Panel settingsPanel = new Panel();
            settingsPanel.setHtml("<p>Some settings in here.</p>");
            settingsPanel.setTitle("Settings");
            settingsPanel.setBorder(false);
            settingsPanel.setIconCls("settings-icon");
            westPanel.add(settingsPanel);

            BorderLayoutData westData = new BorderLayoutData(RegionPosition.WEST);
            westData.setSplit(true);
            westData.setMinSize(175);
            westData.setMaxSize(400);
            westData.setMargins(new Margins(0, 5, 0, 0));

            borderPanel.add(westPanel, westData);

            TabPanel centerPanel = new TabPanel();
            centerPanel.setDeferredRender(false);
            centerPanel.setActiveTab(0);

            Panel centerPanelOne = new HTMLPanel();
            centerPanelOne.setHtml("<p><b>Done reading me? Close me by clicking the X in the top right corner.</b></p>\n" +
                    "        <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>\n" +
                    "        <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>\n" +
                    "        <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>\n" +
                    "        <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>");
            centerPanelOne.setTitle("Close Me");
            centerPanelOne.setAutoScroll(true);
            centerPanelOne.setClosable(true);

            centerPanel.add(centerPanelOne);

            Panel centerPanelTwo = new HTMLPanel();
            centerPanelTwo.setHtml(
                    "            <p>\n" +
                            "            My closable attribute is set to false so you can't close me. The other center panels can be closed.</p>\n" +
                            "        <p>The center panel automatically grows to fit the remaining space in the container that isn't taken up by the border regions.</p>\n" +
                            "        <hr>\n" +
                            "        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed metus nibh, sodales a, porta at, vulputate eget, dui. Pellentesque ut nisl. Maecenas tortor turpis, interdum non, sodales non, iaculis ac, lacus. Vestibulum auctor, tortor quis iaculis malesuada, libero lectus bibendum purus, sit amet tincidunt quam turpis vel lacus. In pellentesque nisl non sem. Suspendisse nunc sem, pretium eget, cursus a, fringilla vel, urna. Aliquam commodo ullamcorper erat. Nullam vel justo in neque porttitor laoreet. Aenean lacus dui, consequat eu, adipiscing eget, nonummy non, nisi. Morbi nunc est, dignissim non, ornare sed, luctus eu, massa. Vivamus eget quam. Vivamus tincidunt diam nec urna. Curabitur velit. Quisque dolor magna, ornare sed, elementum porta, luctus in, leo.</p>\n" +
                            "        <p>Donec quis dui. Sed imperdiet. Nunc consequat, est eu sollicitudin gravida, mauris ligula lacinia mauris, eu porta dui nisl in velit. Nam congue, odio id auctor nonummy, augue lectus euismod nunc, in tristique turpis dolor sed urna. Donec sit amet quam eget diam fermentum pharetra. Integer tincidunt arcu ut purus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla blandit malesuada odio. Nam augue. Aenean molestie sapien in mi. Suspendisse tincidunt. Pellentesque tempus dui vitae sapien. Donec aliquam ipsum sit amet pede. Sed scelerisque mi a erat. Curabitur rutrum ullamcorper risus. Maecenas et lorem ut felis dictum viverra. Fusce sem. Donec pharetra nibh sit amet sapien.</p>\n" +
                            "        <p>Aenean ut orci sed ligula consectetuer pretium. Aliquam odio. Nam pellentesque enim. Nam tincidunt condimentum nisi. Maecenas convallis luctus ligula. Donec accumsan ornare risus. Vestibulum id magna a nunc posuere laoreet. Integer iaculis leo vitae nibh. Nam vulputate, mauris vitae luctus pharetra, pede neque bibendum tellus, facilisis commodo diam nisi eget lacus. Duis consectetuer pulvinar nisi. Cras interdum ultricies sem. Nullam tristique. Suspendisse elementum purus eu nisl. Nulla facilisi. Phasellus ultricies ullamcorper lorem. Sed euismod ante vitae lacus. Nam nunc leo, congue vehicula, luctus ac, tempus non, ante. Morbi suscipit purus a nulla. Sed eu diam.</p>\n" +
                            "        <p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras imperdiet felis id velit. Ut non quam at sem dictum ullamcorper. Vestibulum pharetra purus sed pede. Aliquam ultrices, nunc in varius mattis, felis justo pretium magna, eget laoreet justo eros id eros. Aliquam elementum diam fringilla nulla. Praesent laoreet sapien vel metus. Cras tempus, sapien condimentum dictum dapibus, lorem augue fringilla orci, ut tincidunt eros nisi eget turpis. Nullam nunc nunc, eleifend et, dictum et, pharetra a, neque. Ut feugiat. Aliquam erat volutpat. Donec pretium odio nec felis. Phasellus sagittis lacus eget sapien. Donec est. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;</p>\n" +
                            "        <p>Vestibulum semper. Nullam non odio. Aliquam quam. Mauris eu lectus non nunc auctor ullamcorper. Sed tincidunt molestie enim. Phasellus lobortis justo sit amet quam. Duis nulla erat, varius a, cursus in, tempor sollicitudin, mauris. Aliquam mi velit, consectetuer mattis, consequat tristique, pulvinar ac, nisl. Aliquam mattis vehicula elit. Proin quis leo sed tellus scelerisque molestie. Quisque luctus. Integer mattis. Donec id augue sed leo aliquam egestas. Quisque in sem. Donec dictum enim in dolor. Praesent non erat. Nulla ultrices vestibulum quam.</p>\n" +
                            "        <p>Duis hendrerit, est vel lobortis sagittis, tortor erat scelerisque tortor, sed pellentesque sem enim id metus. Maecenas at pede. Nulla velit libero, dictum at, mattis quis, sagittis vel, ante. Phasellus faucibus rutrum dui. Cras mauris elit, bibendum at, feugiat non, porta id, neque. Nulla et felis nec odio mollis vehicula. Donec elementum tincidunt mauris. Duis vel dui. Fusce iaculis enim ac nulla. In risus.</p>\n" +
                            "        <p>Donec gravida. Donec et enim. Morbi sollicitudin, lacus a facilisis pulvinar, odio turpis dapibus elit, in tincidunt turpis felis nec libero. Nam vestibulum tempus ipsum. In hac habitasse platea dictumst. Nulla facilisi. Donec semper ligula. Donec commodo tortor in quam. Etiam massa. Ut tempus ligula eget tellus. Curabitur id velit ut velit varius commodo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla facilisi. Fusce ornare pellentesque libero. Nunc rhoncus. Suspendisse potenti. Ut consequat, leo eu accumsan vehicula, justo sem lobortis elit, ac sollicitudin ipsum neque nec ante.</p>\n" +
                            "        <p>Aliquam elementum mauris id sem. Vivamus varius, est ut nonummy consectetuer, nulla quam bibendum velit, ac gravida nisi felis sit amet urna. Aliquam nec risus. Maecenas lacinia purus ut velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Suspendisse sit amet dui vitae lacus fermentum sodales. Donec varius dapibus nisl. Praesent at velit id risus convallis bibendum. Aliquam felis nibh, rutrum nec, blandit non, mattis sit amet, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Etiam varius dignissim nibh. Quisque id orci ac ante hendrerit molestie. Aliquam malesuada enim non neque.</p>");
            centerPanelTwo.setTitle("Center Panel");
            centerPanelTwo.setAutoScroll(true);

            centerPanel.add(centerPanelTwo);
            borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));

            panel.add(borderPanel);
        }
        return panel;
    }
}