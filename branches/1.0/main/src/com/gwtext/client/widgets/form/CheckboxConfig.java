/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.CheckboxListener;

/**
 * {@link Checkbox} configuration class.
 *
 */
public class CheckboxConfig extends FieldConfig {

    private CheckboxListener checkboxListener;

    /**
     * The text that appears beside the checkbox.
     *
     * @param boxLabel the box label
     */
    public void setBoxLabel(String boxLabel) {
        JavaScriptObjectHelper.setAttribute(jsObj, "boxLabel", boxLabel);
		setLabelSeparator("&nbsp;");
	}

    /**
     *  True if the the checkbox should render already checked (defaults to false).
     *
     * @param checked true to render checked
     */
	public void setChecked(boolean checked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "checked", checked);
    }

    /**
     * The value that should go into the generated input element's value attribute.
     * 
     * @param inputValue fields input value
     */
    public void setInputValue(String inputValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "inputValue", inputValue);
    }

    /**
     * Return the registered checkbox listener.
     *
     * @return the listener
     */
    public CheckboxListener getCheckboxListener() {
        return checkboxListener;
    }

    /**
     * Register a CheckboxListener.
     *
     * @param checkboxListener checkbox listener
     */
    public void setCheckboxListener(CheckboxListener checkboxListener) {
        this.checkboxListener = checkboxListener;
    }
}
