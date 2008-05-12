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

import com.gwtext.client.core.Position;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextArea;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class AnchoringSample extends ShowcasePanel {


    public String getSourceUrl() {
        return "source/form/AnchoringSample.java.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {
            panel = new Panel();
            
            final Window window = new Window();
			window.setTitle("Resize Me");
			window.setWidth(500);
			window.setHeight(300);
			window.setMinWidth(300);
			window.setMinHeight(200);
			window.setLayout(new FitLayout());
			window.setPaddings(5);
			window.setButtonAlign(Position.CENTER);
			window.addButton(new Button("Send"));
			window.addButton(new Button("Cancel"));

			window.setCloseAction(Window.HIDE);
			window.setPlain(true);

			FormPanel formPanel = new FormPanel();
			//strips all Ext styling for the component
			formPanel.setBaseCls("x-plain");
            formPanel.setLabelWidth(55);
			formPanel.setUrl("save-form.php");

			formPanel.setWidth(500);
			formPanel.setHeight(300);

			// anchor width by percentage
			formPanel.add(new TextField("Send To", "to"), new AnchorLayoutData("100%"));

			// anchor width by percentage
			formPanel.add(new TextField("Subject", "subject"), new AnchorLayoutData("100%"));

			TextArea textArea = new TextArea("Subject", "subject");
			textArea.setHideLabel(true);
			// anchor width by percentage and height by raw adjustment
			// sets width to 100% and height to "remainder" height - 53px
			formPanel.add(textArea, new AnchorLayoutData("100% -53"));

			window.add(formPanel);

            Button button = new Button("Show Form", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    window.show(button.getId());
                }
            });
            panel.add(button);
        }
		return panel;
	}

	public String getIntro() {
		return "<p><br>Anchor Layout with Forms</b>" +
				"<p>This example illustrates positioning form fields by anchor. A FormLayout extends AnchorLayout and " +
				"so all anchoring layout properties apply.</p>" +
				"<p>The 'Send To' field has an anchor property '100%' and so it takes up the rest of the panel width.</p>"  +
				"<p>The 'Subject' field also has a width anchor property of '100%' and so it takes up the rest of the panel width.</p>" +
				"<p>The TextArea field has its label hidden and has an anchor property of '100% -53' and so it takes up the panel width and" +
				"the rest of the panel height less 53px.</p>" +
				"<p>The other thing worth noting is that the FormPanel is added to a Window</p>" +
				"</p>";
	}
}