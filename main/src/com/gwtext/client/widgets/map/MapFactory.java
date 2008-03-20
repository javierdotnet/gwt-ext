/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.map;

/**
 * Fcatory class for map instantiaion.
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
