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

import com.gwtext.client.widgets.Panel;

/**
 * The {@link Panel} listener.
 *
 * @author Sanjiv Jivan
 */
public interface PanelListener extends ContainerListener {

    /**
     * Fires after the Panel has been visually activated. Note that Panels do not directly support being activated, but
     * some Panel subclasses do (like Window). Panels which are child Components of a TabPanel fire the activate and
     * deactivate events under the control of the TabPanel.
     *
     * @param panel this
     */
    void onActivate(Panel panel);

    /**
     * Fires before the Panel is closed. Note that Panels do not directly support being closed, but some Panel subclasses
     * do (like Window). This event only applies to such subclasses. A handler can return false to cancel the close.
     *
     * <br><br>
     * <b>Note:</b> that if you want to capture the closing of a tab in a {@link com.gwtext.client.widgets.TabPanel},
     * you must listner for the {@link com.gwtext.client.widgets.event.ContainerListener#doBeforeRemove(com.gwtext.client.widgets.Container, com.gwtext.client.widgets.Component)}
     * event because closing a tab doesnt close the TabPanel, it just removes it from the parent TabPanel.
     *
     * @param panel this
     * @return false to cancel
     */
    boolean doBeforeClose(Panel panel);

    /**
     * Fires before the Panel is collapsed. A handler can return false to cancel the collapse.
     *
     * @param panel   this
     * @param animate true if collapse is animated
     * @return false to cancel
     */
    boolean doBeforeCollapse(Panel panel, boolean animate);

    /**
     * Fires before the Panel is expanded. A handler can return false to cancel the expand.
     *
     * @param panel   this
     * @param animate true if expand animated
     * @return false to cancel
     */
    boolean doBeforeExpand(Panel panel, boolean animate);

    /**
     * Fires after the Panel has been resized.
     *
     * @param panel  this
     * @param width  the new width
     * @param height the new height
     */
    void onBodyResize(Panel panel, String width, String height);

    /**
     * Fires after the Panel is closed. Note that Panels do not directly support being closed, but some Panel subclasses do
     * (like Window).
     *
     * <br><br>
     * <b>Note:</b> that if you want to capture the closing of a tab in a {@link com.gwtext.client.widgets.TabPanel},
     * you must listner for the {@link com.gwtext.client.widgets.event.ContainerListener#onRemove(com.gwtext.client.widgets.Container, com.gwtext.client.widgets.Component)}
     * event because closing a tab doesnt close the TabPanel, it just removes it from the parent TabPanel.
     *
     * @param panel this
     */
    void onClose(Panel panel);

    /**
     * Fires after the Panel has been collapsed.
     *
     * @param panel this
     */
    void onCollapse(Panel panel);

    /**
     * Fires after the Panel has been visually deactivated. Note that Panels do not directly support being deactivated,
     * but some Panel subclasses do (like  Window). Panels which are child Components of a TabPanel fire the activate and
     * deactivate events under the control of the TabPanel.
     *
     * @param panel this
     */
    void onDeactivate(Panel panel);

    /**
     * Fires after the Panel has been expanded.
     *
     * @param panel this
     */
    void onExpand(Panel panel);

    /**
     * Fires after the Panel title has been set or changed.
     *
     * @param panel this
     * @param title the new title
     */
    void onTitleChange(Panel panel, String title);
}
