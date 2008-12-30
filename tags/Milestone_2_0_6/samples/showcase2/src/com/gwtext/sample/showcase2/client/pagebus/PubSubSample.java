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

package com.gwtext.sample.showcase2.client.pagebus;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.pagebus.PageBus;
import com.gwtext.client.pagebus.SubscriptionCallback;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.dd.DD;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class PubSubSample extends ShowcasePanel {

	private static int count = 1;
	public static String PUBLISH_TOPIC = "recordAdded";

	private RecordDef recordDef = new RecordDef(
			new FieldDef[]{
					new StringFieldDef("company"),
					new FloatFieldDef("price"),
					new FloatFieldDef("change"),
					new FloatFieldDef("pctChange"),
					new DateFieldDef("lastChanged", "n/j h:ia"),
					new StringFieldDef("symbol"),
					new StringFieldDef("industry")
			}
	);

	public String getSourceUrl() {
		return "source/pagebus/PubSubSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			panel.setLayout(new VerticalLayout(15));

			Panel first = new Panel();
			first.setLayout(new HorizontalLayout(15));

			SubscriberGrid sGrid1 = new SubscriberGrid();
			sGrid1.setTitle("Subscriber1");
			sGrid1.setHeight(200);
			sGrid1.setWidth(200);
			sGrid1.setIconCls("subscribe-icon");
			first.add(sGrid1);

			Button button = new Button("Pubhish Company Record", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					Object[] data = new Object[]{"Company - " + (count++), new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"};
					Record record = recordDef.createRecord(data);
					PageBus.publish(PUBLISH_TOPIC, record);
				}
			});
			button.setIconCls("publish-icon");
			first.add(button);
			
			panel.add(first);

			Panel second = new Panel();
			second.setLayout(new HorizontalLayout(15));
			
			SubscriberGrid sGrid2 = new SubscriberGrid();
			sGrid2.setTitle("Subscriber2");
			sGrid2.setHeight(200);
			sGrid2.setWidth(200);
			sGrid2.setIconCls("subscribe-icon");
			second.add(sGrid2);

			SubscriberPanel sPanel = new SubscriberPanel();
			sPanel.setTitle("Subscriber Panel");
			sPanel.setHeight(200);
			sPanel.setWidth(300);
			sPanel.setAutoScroll(true);
			sPanel.setIconCls("subscribe-icon");
			second.add(sPanel);

			panel.add(second);

		}
		return panel;
	}

	public String getIntro() {
		return "<p>A demonstration of Publish-Subscribe messaging. Clicking the button publishes a Record object to a topic that the other subscribers receive</p>" +
				"<p>In this sample, the subscribers are 2 separate Grids and 1 Panel. It is worth noting that any object can be published and you are not limited to publishing String types.</p>";
	}
}



