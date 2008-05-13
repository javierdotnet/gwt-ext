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
 * @author Sanjiv  Jivan
 */
public class PageBus {

	public static native void publish(String subject, Object message)/*-{
        $wnd.PageBus.publish(subject, message);
    }-*/;

	public static native Subscription subscribe(String subject, SubscriptionCallback callback)/*-{
          var sub = $wnd.PageBus.subscribe(subject, this, function(subject, message, subscriberData){
			  callback.@com.gwtext.client.pagebus.SubscriptionCallback::execute(Ljava/lang/String;Ljava/lang/Object;)(subject, message);
		  }, null);
		  return  @com.gwtext.client.pagebus.PageBus::createSubscription(Lcom/google/gwt/core/client/JavaScriptObject;)(sub);
	}-*/;

	private static Subscription createSubscription(JavaScriptObject sub) {
		return new Subscription(sub);
	}
	
	public static native void unsubscribe(Subscription subscription)/*-{
        var sub = subscription.@com.gwtext.client.core.JsObject::jsObj;
		$wnd.PageBus.unsubscribe(sub);
	}-*/;
}
