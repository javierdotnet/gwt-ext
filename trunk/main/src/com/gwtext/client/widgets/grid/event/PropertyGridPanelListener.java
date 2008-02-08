package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.PropertyGridPanel;

/**
 * {@link com.gwtext.client.widgets.grid.PropertyGridPanel} listener.
 */
public interface PropertyGridPanelListener {

    /**
     * Fires before a property value changes. Handlers can return false to cancel the property change (this will internally call
     * {@link com.gwtext.client.data.Record#reject()}  on the property's record).
     *
     * @param source this
     * @param recordID the recordID
     * @param value the current edited property value
     * @param oldValue the original property value prior to editing
     * @return false to cancel
     */
    boolean doBeforePropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue);

    /**
     * Fires after a property value has changed.
     *
     * @param source this
     * @param recordID the recordID
     * @param value the current edited property value
     * @param oldValue the original property value prior to editing
     */
    void onPropertyChange(PropertyGridPanel source, String recordID, Object value, Object oldValue);

    
}
