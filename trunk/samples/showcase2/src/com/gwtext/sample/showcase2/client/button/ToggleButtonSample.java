/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.button;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ToggleButtonSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/button/ToggleButtonSample.java.html";
    }

    public String getCssUrl() {
        return "source/button/ToggleButtonSample.css.html";
    }

    public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			Toolbar toolbar = new Toolbar();
			toolbar.setWidth(400);

			ToolbarButton bold = new ToolbarButton();
			bold.setEnableToggle(true);
			bold.setIconCls("text-bold");
			bold.setTooltip("<b>Bold</b>");
			toolbar.addButton(bold);

			ToolbarButton italic = new ToolbarButton();
			italic.setEnableToggle(true);
			italic.setIconCls("text-italic");
			italic.setTooltip("<i>Italic</i>");
			toolbar.addButton(italic);

			ToolbarButton underline = new ToolbarButton();
			underline.setEnableToggle(true);
			underline.setIconCls("text-underline");
			underline.setTooltip("<u>Underline</u>");
			toolbar.addButton(underline);

			toolbar.addSeparator();

			ToolbarButton left = new ToolbarButton();
			left.setToggleGroup("alignment");
			left.setTooltip("Left Align");
			left.setIconCls("text-align-left");
			toolbar.addButton(left);

			ToolbarButton right = new ToolbarButton();
			right.setToggleGroup("alignment");
			right.setIconCls("text-align-right");
			right.setTooltip("Right Align");
			toolbar.addButton(right);

			ToolbarButton center = new ToolbarButton();
			center.setToggleGroup("alignment");
			center.setIconCls("text-align-center");
			center.setTooltip("Center");
			toolbar.addButton(center);

			ToolbarButton justify = new ToolbarButton();
			justify.setToggleGroup("alignment");
			justify.setIconCls("text-align-justify");
			justify.setTooltip("Justify");
			toolbar.addButton(justify);

			panel.add(toolbar);
		}
		return panel;
	}

	public String getIntro() {
		return "<p>This example illustrates Toggle Buttons. When clicked, such Buttons toggle thier 'pressed' state.</p>" +
				"<p>The Bold, Italic and Underline toggle Buttons operate independently with respect to thier toggle state while " +
				"the text alignment icon Buttons belong to the same toggle group and so when one of them is click, the previously pressed " +
				"Button returns to its normal state.<p>";
	}
}