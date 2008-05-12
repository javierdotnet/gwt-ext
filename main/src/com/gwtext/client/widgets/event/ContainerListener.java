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
 
package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Container;

/**
 * Container listener interface.
 *
 * @author Sanjiv Jivan
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
