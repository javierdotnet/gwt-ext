package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.ProgressBar;

/**
 * {@link com.gwtext.client.widgets.ProgressBar} listener.
 */
public interface ProgressBarListener extends BoxComponentListener {

    /**
     * Fires after each update interval.
     *
     * @param self this
     * @param value the current progress value
     * @param text the current progress text
     */
    void onUpdate(ProgressBar self, float value, String text);
}
