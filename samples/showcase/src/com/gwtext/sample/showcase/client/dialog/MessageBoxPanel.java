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

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.sample.showcase.client.Showcase;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class MessageBoxPanel extends ShowcaseExampleVSD {


    public String getSourceUrl() {
        return "dialog/MessageBoxPanel.java.html";
    }

    public Panel getViewPanel() {

        VerticalPanel vp = createPanel();

        HTML intro = new HTML("<h1>MessageBox Dialogs</h1><p>The example shows how to use the MessageBox class. Some of the buttons have animations, some are normal.</p>");
        vp.add(intro);

        Grid grid = new Grid(6, 2);
        grid.setCellSpacing(20);

        grid.setWidget(0, 0, new HTML("<b>Confirm</b><br />Standard Yes/No dialog."));
        grid.setWidget(0, 1, new Button(new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.confirm("Confirm", "Are you sure you want to do that?",
                                new MessageBox.ConfirmCallback() {
                                    public void execute(String btnID) {
                                        Showcase.showMessage("Button Click",
                                                Format.format("You clicked the {0} button", btnID));
                                    }
                                });
                    }
                });
            }
        }));

        grid.setWidget(1, 0, new HTML("<b>Prompt</b><br />Standard prompt dialog."));
        grid.setWidget(1, 1, new Button(new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.prompt("Name", "Please enter your name:",
                                new MessageBox.PromptCallback() {
                                    public void execute(String btnID, String text) {
                                        Showcase.showMessage("Button Click",
                                                Format.format("You clicked the {0} button and entered the text \"{1}\"", btnID, text));
                                    }
                                });
                    }
                });

            }
        }));

        grid.setWidget(2, 0, new HTML("<b>Multi-line Prompt</b><br />A multi-line prompt dialog."));
        grid.setWidget(2, 1, new Button("mb3", new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.show(new MessageBoxConfig() {
                            {
                                setTitle("Address");
                                setMsg("Please enter yuor address:");
                                setWidth(300);
                                setButtons(MessageBox.OKCANCEL);
                                setMultiline(true);
                                setCallback(new MessageBox.PromptCallback() {
                                    public void execute(String btnID, String text) {
                                        Showcase.showMessage("Button Click",
                                                Format.format("You clicked the {0} button and entered the text \"{1}\"", btnID, text));
                                    }
                                });
                                setAnimEl("mb3");
                            }
                        });
                    }
                });
            }
        }));

        grid.setWidget(3, 0, new HTML("<b>Yes/No/Cancel</b><br />Standard Yes/No/Cancel dialog."));
        grid.setWidget(3, 1, new Button("mb4", new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.show(new MessageBoxConfig() {
                            {
                                setTitle("Save Changes?");
                                setMsg("Your are closing a tab that has unsaved changes. Would you like to save your changes?");
                                setButtons(MessageBox.YESNOCANCEL);
                                setCallback(new MessageBox.PromptCallback() {
                                    public void execute(String btnID, String text) {
                                        Showcase.showMessage("Button Click",
                                                Format.format("You clicked the {0} button", btnID));
                                    }
                                });
                                setAnimEl("mb4");
                            }
                        });
                    }
                });
            }
        }));


        grid.setWidget(4, 0, new HTML("<b>Progress Dialog</b><br />You can set a progress on a progress MessageBox."));
        grid.setWidget(4, 1, new Button("mb5", new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.show(new MessageBoxConfig() {
                            {
                                setTitle("Please wait...");
                                setMsg("Initializing...");
                                setWidth(240);
                                setProgress(true);
                                setClosable(false);
                                setCallback(new MessageBox.PromptCallback() {
                                    public void execute(String btnID, String text) {
                                        Showcase.showMessage("Button Click",
                                                Format.format("You clicked the {0} button and entered the text {1}", btnID, text));
                                    }
                                });
                                setAnimEl("mb5");
                            }
                        });

                        //create bogus progress
                        for (int i = 1; i < 12; i++) {
                            final int j = i;
                            Timer timer = new Timer() {
                                public void run() {
                                    if (j == 11) {
                                        MessageBox.hide();
                                    } else {
                                        MessageBox.updateProgress(j * 10, "Loading item " + j + " of 10... ");
                                    }
                                }
                            };
                            timer.schedule(i * 1000);
                        }
                    }
                });
            }
        }));


        grid.setWidget(5, 0, new HTML("<b>Alert</b><br />Standard Alert dialog."));
        grid.setWidget(5, 1, new Button("mb6", new ButtonConfig() {
            {
                setText("Show Me");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.alert("Status", "Changes saved successfully", new MessageBox.AlertCallback() {
                            public void execute() {
                                Showcase.showMessage("Button Click", "You closed alert");
                            }
                        });
                    }
                });
            }
        }));

        vp.add(grid);
        return vp;
    }
}
