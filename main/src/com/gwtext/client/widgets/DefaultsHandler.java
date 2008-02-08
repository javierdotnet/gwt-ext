/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

/**
 * Interface that is used by {@link com.gwtext.client.widgets.Container#setDefaults(DefaultsHandler)} . Users
 * can pass in thier own implmentation of this interface where thier settings will apply to each component that is
 * adde to the container.
 */
public interface DefaultsHandler {

    /**
     * Apply default settings to components added to the container.
     *
     * @param component the component being added
     */
    void apply(Component component);
}
