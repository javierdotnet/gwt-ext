package com.gwtext.client.widgets.form.event;

import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.event.PanelListener;

public interface FormPanelListener extends PanelListener {

	/**
	 * If the monitorValid config option is true, this event fires repetitively to notify of valid state
	 *
	 * @param formPanel the form panel
	 * @param valid true if valid
	 *
	 * @see com.gwtext.client.widgets.form.FormPanel#setMonitorValid(boolean)
	 */
	void onClientValidation(FormPanel formPanel, boolean valid);
}
