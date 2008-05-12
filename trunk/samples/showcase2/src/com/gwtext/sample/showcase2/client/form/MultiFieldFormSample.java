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
 
package com.gwtext.sample.showcase2.client.form;

import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class MultiFieldFormSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/form/MultiFieldFormSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final FormPanel formPanel = new FormPanel();
            formPanel.setFrame(true);
            formPanel.setBorder(true);
            formPanel.setTitle("Multiple Fields on Row");
            formPanel.setWidth(550);
            formPanel.setLabelWidth(100);
            formPanel.setUrl("save-form.php");

            TextField firstName = new TextField("First / Last", "first", 110, "Sanjiv");

            TextField lastName = new TextField("Last Name", "last", 110, "Jivan");
            lastName.setHideLabel(true);

            MultiFieldPanel namePanel = new MultiFieldPanel();
            namePanel.addToRow(firstName, 220);
            namePanel.addToRow(lastName, new ColumnLayoutData(1));
            formPanel.add(namePanel);

            TextField company = new TextField("Company", "company", 222);
            formPanel.add(company);

            MultiFieldPanel dateTimePanel = new MultiFieldPanel();
            dateTimePanel.addToRow(new DateField("Appointment", "appointment", 140), 250);
            TimeField timeField = new TimeField();
            timeField.setHideLabel(true);
            timeField.setWidth(80);
            dateTimePanel.addToRow(timeField, new ColumnLayoutData(1));
            formPanel.add(dateTimePanel);

            TextField email = new TextField("Email", "email", 222);
            email.setVtype(VType.EMAIL);
            formPanel.add(email);

            Image image = new Image("images/captcha.jpg");
            Panel imagePanel = new Panel();
            imagePanel.setBorder(false);
            imagePanel.add(image);

            ToolTip imageToolTip = new ToolTip("Tooltip on an Image");
            imageToolTip.applyTo(image.getElement());

            formPanel.add(new PaddedPanel(imagePanel, 0, 110, 0, 5));

            MultiFieldPanel captchaPanel = new MultiFieldPanel();
            TextField captchaField = new TextField("Captcha", "captcha", 110);
            captchaPanel.addToRow(captchaField, 220);

            ToolTip fieldToolTip = new ToolTip("Tooltip on a Field.");
            fieldToolTip.applyTo(captchaField);

            Image info = new Image("images/silk/information.gif");

            ToolTip tooltip = new ToolTip();
            tooltip.setHtml("A <b>CAPTCHA</b> is a challenge-response test to determine whether the user is human.");
            tooltip.setWidth(150);
            tooltip.applyTo(info.getElement());

            captchaPanel.addToRow(info, new ColumnLayoutData(1));
            formPanel.add(captchaPanel);

            panel.add(formPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates how multiple Fields can be added to a single row.</p><p>It also demonstrates an image being added to the form and the use of " +
                "tooltips on any element, including Images and TextFields.</p>";
    }
}