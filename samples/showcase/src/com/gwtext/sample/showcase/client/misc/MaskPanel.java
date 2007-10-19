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

package com.gwtext.sample.showcase.client.misc;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.form.event.CheckboxListener;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class MaskPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "misc/MaskPanel.java.html";
    }

    public Panel getViewPanel() {

        Form form = new Form(new FormConfig() {
            {
                setWidth(400);
                setLabelWidth(100);
                setSurroundWithBox(true);
            }
        });

        final TextField maskField = new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Mask message");
                setName("maskMessage");
                setWidth(175);
                setAllowBlank(true);
                setSelectOnFocus(true);

            }
        });
        form.add(maskField);

        form.fieldset(new FieldSetConfig() {
            {
                setHideLabels(true);
                setLegend("Select region");
            }
        });
        form.add(new Checkbox(new CheckboxConfig() {
            {
                setBoxLabel("Mask Side Nav using message");
                setCheckboxListener(new CheckboxListener() {
                    public void onCheck(Checkbox field, boolean checked) {
                        String message = maskField.getText();
                        final ExtElement element = Ext.get("eg-explorer");
                        if (checked) {
                            if (message.trim().equals("")) {
                                element.mask();
                            } else {
                                element.mask(message);
                            }
                        } else {
                            element.unmask();
                        }
                    }
                });
            }
        }));

        form.add(new Checkbox(new CheckboxConfig() {
            {
                setBoxLabel("Mask Header");
                setCheckboxListener(new CheckboxListener() {
                    public void onCheck(Checkbox field, boolean checked) {
                        ExtElement element = Ext.get("north");
                        if (checked) {
                            element.mask();
                        } else {
                            element.unmask();
                        }
                    }
                });
            }
        }));

        form.end();
        form.render();

        VerticalPanel vp = createPanel();
        vp.add(new HTML(intro));
        vp.add(form);

        return vp;
    }

    private static String intro = "<h3>Demo of masking elements</h3>\n" +
            "<p>\n" +
            "    This example demonstrates masking elements. Masking containers is an effective way of disabling the control and its children." +
            "</p>";
}