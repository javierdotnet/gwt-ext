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
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
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

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			panel.setLayout(new HorizontalLayout(15));

			panel.addButton(new com.gwtext.client.widgets.Button("Pubhish Company Record", new ButtonListenerAdapter() {
				public void onClick(com.gwtext.client.widgets.Button button, EventObject e) {
					Object[] data = new Object[]{"E.I. du Pont de Nemours and Company - " + (count++), new Double(40.48), new Double(0.51), new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"};
					Record record = recordDef.createRecord(data);
					PageBus.publish(PUBLISH_TOPIC, record);
				}
			}));

			SubscriberGrid sGrid1 = new SubscriberGrid();
			Panel sub1 = new Panel();
			sub1.setTitle("Subscriber1");
			sub1.setDraggable(true);
			sub1.setHeight(200);
			sub1.setWidth(200);
			sub1.add(sGrid1);
			sub1.setIconCls("subscriber-icon");
			panel.add(sub1);

			SubscriberGrid sGrid2 = new SubscriberGrid();
			Panel sub2 = new Panel();
			sub2.setTitle("Subscriber2");
			sub2.setDraggable(true);
			sub2.setHeight(200);
			sub2.setWidth(200);
			sub2.add(sGrid2);
			sub2.setIconCls("subscriber-icon");
			sub2.setPosition(150, 150);
			panel.add(sub2);

			SubscriberPanel sPanel = new SubscriberPanel();

			Panel sub3 = new Panel("Subscriber Panel");
			sub3.setLayout(new FitLayout());
			sub3.setHeight(200);
			sub3.setWidth(200);
			sub3.setAutoScroll(true);
			sub3.setDraggable(true);
			sub3.add(sPanel);
			sub3.setIconCls("subscriber-icon");
			panel.add(sub3);

		}
		return panel;
	}

	public String getIntro() {
		return "A demonstration of Publish-Subscribe messaging.";
	}
}

class SubscriberPanel extends Panel {

	public SubscriberPanel() {
		PageBus.subscribe(PubSubSample.PUBLISH_TOPIC, new SubscriptionCallback() {
			public void execute(String subject, Object message) {
				Record record = (Record) message;
				getBody().update("Received Company update " + record.getAsString("company"));
			}
		});
	}
}

class SubscriberGrid extends SampleGrid {

	public SubscriberGrid() {
		PageBus.subscribe(PubSubSample.PUBLISH_TOPIC, new SubscriptionCallback() {
			public void execute(String subject, Object message) {
				Record record = (Record) message;
				store.insert(0, record);
			}
		});
	}
}