package com.gwtext.client.widgets;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.ExtElement;

/**
 * Interface to handle onClick events on a Tool
 * @author Mario Lim
 *
 */
public interface ToolHandler {
	/**
	 * Method to implement to get onClick events
	 * @param e the EventObject
	 * @param toolEl the ExtElement of the tool icon
	 * @param panel the Panel where this tool resides
	 */
	public void onClick(EventObject e, ExtElement toolEl, Panel panel);
}
