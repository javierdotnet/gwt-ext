/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Container;

/**
 * Container listener interface.
 */
public interface ContainerListener extends BoxComponentListener {

    /**
     * Fires after any Component is added or inserted into the container.
     *
     * @param self      self
     * @param component the component being added
     * @param index     the index at which the component was added to the container's items collection
     */
    void onAdd(Container self, Component component, int index);

    /**
     * Fires when the components in this container are arranged by the associated layout manager.
     *
     * @param self self
     */
    void onAfterLayout(Container self);

    /**
     * Fires before any Component is added or inserted into the container. A handler can return false to cancel the add.
     *
     * @param self      self
     * @param component the component being added
     * @param index     the index at which the component was added to the container's items collection
     * @return false to cancel
     */
    boolean doBeforeAdd(Container self, Component component, int index);

    /**
     * Fires before any Component is removed from the container. A handler can return false to cancel the remove.
     *
     * @param self      self
     * @param component the container being removed
     * @return false to cancel
     */
    boolean doBeforeRemove(Container self, Component component);

    /**
     * Fires after any Component is removed from the container.
     *
     * @param self      self
     * @param component the container being removed
     */
    void onRemove(Container self, Component component);

}
