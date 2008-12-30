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
 
package com.gwtext.client.widgets.map;

/**
 * Fcatory class for map instantiaion.
 *
 * @author Sanjiv Jivan
 */
public class MapFactory {

	/**
	 * Returns an available map implementation by detecting the available map JS.
	 * 
	 * @return
	 */
	public static MapPanel getMap() {
        if (isGoogleAvailable()) {
            return new GoogleMap();
        } else if (isYahooAvailable()) {
            return new YahooMap();
        } else if (isMicrosoftAvailable()) {
            return new MicrosoftMap();
        } else if (isOpenLayersAvailable()) {
            return new OpenLayersMap();
        } else if (isMultiMapAvailable()) {
            return new MultiMap();
        } else if (isMap24Available()) {
            return new Map24Map();
        } else if (isMapQuestAvailable()) {
            return new MapQuestMap();
        } else if (isFreeEarthAvailable()) {
            return new FreeEarthMap();
        } else if (isOpenStreetMapAvailable()) {
            return new OpenStreetMap();
        } else {
            throw new IllegalStateException("No mapping libray available. Please make sure that you have included the appropriate mapping scripts.");
        }
    }

    public static native boolean isGoogleAvailable()/*-{
        return $wnd.GMap2 != null && $wnd.GMap2 !== undefined;
    }-*/;

    public static native boolean isYahooAvailable()/*-{
        return $wnd.YMap != null && $wnd.YMap !== undefined;
    }-*/;

    public static native boolean isMicrosoftAvailable()/*-{
        return $wnd.VEMap != null && $wnd.VEMap !== undefined;
    }-*/;


    public static native boolean isOpenLayersAvailable()/*-{
        return $wnd.OpenLayers.Map != null && $wnd.OpenLayers.Map !== undefined;
    }-*/;

    public static boolean isOpenStreetMapAvailable() {
        return isGoogleAvailable();
    }

    public static native boolean isMultiMapAvailable()/*-{
        return $wnd.MultimapViewer != null && $wnd.MultimapViewer !== undefined;
    }-*/;


    public static native boolean isMap24Available()/*-{
        return $wnd.Map24 != null && $wnd.Map24 !== undefined;
    }-*/;

    public static native boolean isMapQuestAvailable()/*-{
        return $wnd.MQInitOverlays != null && $wnd.MQInitOverlays !== undefined;
    }-*/;

    public static native boolean isFreeEarthAvailable()/*-{
        return $wnd.FE.Map != null && $wnd.FE.Map !== undefined;
    }-*/;
}
