/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;

/**
 * Component Listener
 */
public interface ComponentListener {

    /**
     * Fires before the component is destroyed. Return false to stop the destroy.
     *
     * @param component this
     * @return false to stop destroy
     */
    boolean doBeforeDestroy(Component component);

    /**
     * Fires before the component is hidden. Return false to stop the hide.
     *
     * @param component this
     * @return false to stop hide
     */
    boolean doBeforeHide(Component component);

    /**
     * Fires before the component is rendered. Return false to stop the render.
     *
     * @param component this
     * @return false to stop render
     */
    boolean doBeforeRender(Component component);

    /**
     * Fires before the component is shown. Return false to stop the show.
     *
     * @param component this
     * @return false to stop show
     */
    boolean doBeforeShow(Component component);

    /**
     * Fires before the state of the component is restored. Return false to stop the restore.
     *
     * @param component this
     * @param state     the component state
     * @return false to stop the restore
     */
    boolean doBeforeStateRestore(Component component, JavaScriptObject state);

    /**
     * Fires before the state of the component is saved to the configured state provider. Return false to stop the save.
     *
     * @param component this
     * @param state     the component state
     * @return false to stop the save
     */
    boolean doBeforeStateSave(Component component, JavaScriptObject state);

    /**
     * Fires after the component is destroyed.
     *
     * @param component this
     */
    void onDestroy(Component component);

    /**
     * Fires after the component is disabled.
     *
     * @param component this
     */
    void onDisable(Component component);

    /**
     * Fires after the component is enabled.
     *
     * @param component this
     */
    void onEnable(Component component);

    /**
     * Fires after the component is hidden.
     *
     * @param component this
     */
    void onHide(Component component);

    /**
     * Fires after the component is rendered.
     *
     * @param component this
     */
    void onRender(Component component);

    /**
     * Fires after the component is shown.
     *
     * @param component this
     */
    void onShow(Component component);

    /**
     * Fires after the state of the component is restored.
     *
     * @param component this
     * @param state     the component state
     */
    void onStateRestore(Component component, JavaScriptObject state);

    /**
     * Fires after the state of the component is saved to the configured state provider.
     *
     * @param component this
     * @param state     the component state
     */
    void onStateSave(Component component, JavaScriptObject state);
}
