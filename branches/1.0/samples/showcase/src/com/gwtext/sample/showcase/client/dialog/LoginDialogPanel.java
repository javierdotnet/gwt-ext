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

package com.gwtext.sample.showcase.client.dialog;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.TabPanelItemListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.ContentPanelConfig;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class LoginDialogPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "dialog/LoginDialogPanel.java.html";
    }

    public Panel getViewPanel() {

        LayoutRegionConfig center = new LayoutRegionConfig() {
            {
                setAutoScroll(true);
                setTabPosition("top");
                setCloseOnTab(true);
                setAlwaysShowTabs(true);
            }
        };

        final LayoutDialog dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setModal(true);
                setWidth(500);
                setHeight(350);
                setShadow(true);
                setResizable(false);
                setClosable(false);
                setProxyDrag(true);
                setTitle("Sign in");
            }
        }, center);


        final BorderLayout layout = dialog.getLayout();
        layout.beginUpdate();

        ContentPanel signInPanel = new ContentPanel(Ext.generateId(), "Sign In");
        final Form signInForm = getSignInForm();

        VerticalPanel signInWrapper = new VerticalPanel() {
            {
                setSpacing(30);
                setWidth("100%");
                setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
            }
        };
        signInWrapper.add(signInForm);

        signInPanel.add(signInWrapper);
        layout.add(LayoutRegionConfig.CENTER, signInPanel);

        ContentPanel registerPanel = new ContentPanel(Ext.generateId(), new ContentPanelConfig() {
            {
                setTitle("Register");
                setBackground(true);
            }
        });

        final Form registerForm = getRegistrationForm();
        VerticalPanel registerWrapper = new VerticalPanel() {
            {
                setSpacing(30);
                setWidth("100%");
                setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
            }
        };
        registerWrapper.add(registerForm);

        registerPanel.add(registerWrapper);
        layout.add(LayoutRegionConfig.CENTER, registerPanel);

        final Toolbar tb = new Toolbar("my-tb");
        tb.addButton(new ToolbarButton("About", new ButtonConfig()));
        tb.addSeparator();
        tb.addItem(new ToolbarTextItem("Copyright &copy; 2007"));

        ContentPanel infoPanel = new ContentPanel(Ext.generateId(), new ContentPanelConfig() {
            {
                setTitle("Info");
                setClosable(true);
                setBackground(true);
                setToolbar(tb);
            }
        });
        infoPanel.setContent("<p>Some content goes here</p>");

        layout.add(LayoutRegionConfig.CENTER, infoPanel);
        layout.endUpdate();

        final Button signInBtn = dialog.addButton("Sign in");
        signInBtn.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                signInForm.submit();
            }
        });

        final Button registerBtn = dialog.addButton("Register");
        registerBtn.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                registerForm.submit();
            }
        });
        registerBtn.hide();

        dialog.addButton(new Button(new ButtonConfig() {
            {
                setText("Cancel");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        signInForm.reset();
                        registerForm.reset();
                        dialog.hide();
                    }
                });
            }
        }));

        TabPanel tabPanel = layout.getRegion(LayoutRegionConfig.CENTER).getTabs();

        tabPanel.getTab(0).addTabPanelItemListener(new TabPanelItemListenerAdapter() {
            public void onActivate(TabPanelItem tab) {
                dialog.setTitle("Sign In");
                registerBtn.hide();
                signInBtn.show();
            }
        });

        tabPanel.getTab(1).addTabPanelItemListener(new TabPanelItemListenerAdapter() {
            public void onActivate(TabPanelItem tab) {
                dialog.setTitle("Register");
                signInBtn.hide();
                registerBtn.show();
                tab.getTextEl().highlight();
            }
        });

        tabPanel.getTab(2).addTabPanelItemListener(new TabPanelItemListenerAdapter() {
            public void onActivate(TabPanelItem tab) {
                dialog.setTitle("Info");
                registerBtn.hide();
                signInBtn.hide();
            }
        });

        Button button = new Button(new ButtonConfig() {
            {
                setText("Login / Register");
            }
        });
        button.addButtonListener(new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                dialog.show(button.getEl());
            }
        });

        VerticalPanel vp = new VerticalPanel();
        vp.setSpacing(15);
        vp.add(new HTML("<h1>Login / Register Dialog</h1>"));
        vp.add(new HTML("<p>This example shows how to create a more advanced dialog.</p>"));
        vp.add(button);

        return vp;
    }


    private Form getSignInForm() {
        Form form = new Form(new FormConfig() {
            {
                setWidth(300);
                setLabelWidth(75);

            }
        });
        form.fieldset("Sign In");
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Username");
                setName("username");
                setWidth(175);
                setAllowBlank(false);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Password");
                setName("password");
                setWidth(175);
                setPassword(true);
                setAllowBlank(false);
            }
        }));
        form.end();
        form.render();
        return form;
    }

    public Form getRegistrationForm() {
        Form form = new Form("form-ct3", new FormConfig() {
            {
                setWidth(400);
                setLabelWidth(75);
                setLabelAlign(Position.RIGHT);
            }
        });

        form.fieldset(new FieldSetConfig() {
            {
                setLegend("Register");
            }
        });
        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("User Name");
                setName("uname");
                setWidth(200);
                setAllowBlank(false);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("First Name");
                setName("name");
                setWidth(200);
                setAllowBlank(false);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Password");
                setName("password");
                setPassword(true);
                setAllowBlank(false);
                setWidth(200);
            }
        }));

        form.add(new TextField(new TextFieldConfig() {
            {
                setFieldLabel("Email");
                setName("email");
                setVtype(VType.EMAIL);
                setWidth(200);
            }
        }));
        form.end();
        form.render();
        return form;
    }
}