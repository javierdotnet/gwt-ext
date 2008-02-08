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
package com.gwtext.client.widgets;

import com.gwtext.client.core.AnchorPosition;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * Configuration for the {@link Editor} class.
 */
public class EditorConfig extends ComponentConfig {

	/**
	 * The position to align to.
	 *
	 * @param elementAnchor defaults to {@link com.gwtext.client.core.AnchorPosition#CENTER
	 * @param targetAnchor  defaults to {@link com.gwtext.client.core.AnchorPosition#CENTER
	 */
	public void setAlignment(AnchorPosition elementAnchor, final AnchorPosition targetAnchor) {
		JavaScriptObjectHelper.setAttribute(jsObj, "alignment", elementAnchor.getPosition() + "-" + targetAnchor.getPosition());
	}

	/**
	 * True for the editor to automatically adopt the size of the underlying field.
	 *
	 * @param autosize true to autosize
	 */
	public void setAutosize(boolean autosize) {
		JavaScriptObjectHelper.setAttribute(jsObj, "autosize", autosize);
	}

	/**
	 * Set to "width" to adopt the width only, or "height" to adopt the height only.
	 *
	 * @param autosize the autosize value
	 */
	public void setAutosize(String autosize) {
		JavaScriptObjectHelper.setAttribute(jsObj, "autosize", autosize);
	}

	/**
	 * True to cancel the edit when the escape key is pressed (defaults to false).
	 *
	 * @param cancelOnEsc cancel on escape
	 */
	public void setCancelOnEsc(boolean cancelOnEsc) {
		JavaScriptObjectHelper.setAttribute(jsObj, "cancelOnEsc", cancelOnEsc);
	}

	/**
	 * True to complete the edit when the enter key is pressed (defaults to false).
	 *
	 * @param completeOnEnter true to complete on enter
	 */
	public void setCompleteOnEnter(boolean completeOnEnter) {
		JavaScriptObjectHelper.setAttribute(jsObj, "completeOnEnter", completeOnEnter);
	}

	/**
	 * True to constrain the editor to the viewport.
	 *
	 * @param constrain true to constrain the editor to the viewport
	 */
	public void setConstrain(boolean constrain) {
		JavaScriptObjectHelper.setAttribute(jsObj, "constrain", constrain);
	}

	/**
	 * False to keep the bound element visible while the editor is displayed (defaults to true).
	 *
	 * @param hideEl true to hide element
	 */
	public void setHideEl(boolean hideEl) {
		JavaScriptObjectHelper.setAttribute(jsObj, "hideEl", hideEl);
	}

	/**
	 * True to skip the the edit completion process (no save, no events fired) if the user completes an edit and the
	 * value has not changed (defaults to false). Applies only to string values - edits for other data types will never be ignored.
	 *
	 * @param ignoreNoChange true to ingnore no change
	 */
	public void setIgnoreNoChange(boolean ignoreNoChange) {
		JavaScriptObjectHelper.setAttribute(jsObj, "ignoreNoChange", ignoreNoChange);
	}

	/**
	 * True to automatically revert the field value and cancel the edit when the user completes an edit and the field validation fails (defaults to true).
	 *
	 * @param revertInvalid true to rever invalid field value
	 */
	public void setRevertInvalid(boolean revertInvalid) {
		JavaScriptObjectHelper.setAttribute(jsObj, "revertInvalid", revertInvalid);
	}

	/**
	 * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "frame")
	 *
	 * @param shadow the shadow setting
	 */
	public void setShadow(boolean shadow) {
		JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
	}

	/**
	 * "sides" for sides/bottom only, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "frame")
	 *
	 * @param shadow the shadow setting
	 */
	public void setShadow(String shadow) {
		JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
	}

	/**
	 * True to update the innerHTML of the bound element when the update completes (defaults to false).
	 *
	 * @param updateEl true to update the element
	 */
	public void setUpdateEl(boolean updateEl) {
		JavaScriptObjectHelper.setAttribute(jsObj, "updateEl", updateEl);
	}

	/**
	 * The data value of the underlying field (defaults to "").
	 *
	 * @param value the field value
	 */
	public void setValue(String value) {
		JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
	}

	/**
	 * The data value of the underlying field (defaults to "").
	 *
	 * @param value the field value
	 */
	public void setValue(Date value) {
		JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
	}

	/**
	 * The data value of the underlying field (defaults to "").
	 *
	 * @param value the field value
	 */
	public void setValue(long value) {
		JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
	}

	/**
	 * The data value of the underlying field (defaults to "").
	 *
	 * @param value the field value
	 */
	public void setValue(double value) {
		JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
	}

	/**
	 * The data value of the underlying field (defaults to "").
	 *
	 * @param value the field value
	 */
	public void setValue(boolean value) {
		JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
	}
}
