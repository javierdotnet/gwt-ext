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

package com.gwtext.client.pagebus;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The PageBus class can be use to publish objects to any topic and have other (decoupled) components subscribe to these topics.
 * It is a powerful mechanism for inter component communication and state management.
 *
 * @author Sanjiv  Jivan
 */
public class PageBus {

	/**
	 * Publish an object / message to the specified topic.
	 *
	 * @param subject the subject to publish the message to
	 * @param message the message to publish
	 */
	public static native void publish(String subject, Object message)/*-{
        $wnd.PageBus.publish(subject, message);
    }-*/;

	/**
	 * Subscribe to the specified topic.
	 *
	 * @param subject the topic to subscribe to
	 * @param callback the callback to invoke when a message is received on the subscribed topic
	 *
	 * @return handle to the subscription. useful to unsubscribe to topic. {@link #unsubscribe(Subscription)}
	 */
	public static native Subscription subscribe(String subject, SubscriptionCallback callback)/*-{
          var sub = $wnd.PageBus.subscribe(subject, this, function(subject, message, subscriberData){
			  callback.@com.gwtext.client.pagebus.SubscriptionCallback::execute(Ljava/lang/String;Ljava/lang/Object;)(subject, message);
		  }, null);
		  return  @com.gwtext.client.pagebus.PageBus::createSubscription(Lcom/google/gwt/core/client/JavaScriptObject;)(sub);
	}-*/;

	private static Subscription createSubscription(JavaScriptObject sub) {
		return new Subscription(sub);
	}

	/**
	 * Unsubscribe previous subscription.
	 *
	 * @param subscription the subscription to unsubscribe
	 */
	public static native void unsubscribe(Subscription subscription)/*-{
        var sub = subscription.@com.gwtext.client.core.JsObject::jsObj;
		$wnd.PageBus.unsubscribe(sub);
	}-*/;
}
