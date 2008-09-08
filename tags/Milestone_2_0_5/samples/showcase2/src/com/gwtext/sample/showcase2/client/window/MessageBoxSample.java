/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.sample.showcase2.client.window;

import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.TableLayout;
import com.gwtext.sample.showcase2.client.Showcase2;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class MessageBoxSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/window/MessageBoxSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new TableLayout(2));

            Panel panel1 = new Panel();
            panel1.setTitle("Confirm");
            panel1.setFrame(true);
            panel1.setWidth(250);
            panel1.setHeight(150);
            panel1.setPaddings(20);

            Button button1 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MessageBox.confirm("Confirm", "Are you sure you want to do that?",
                            new MessageBox.ConfirmCallback() {
                                public void execute(String btnID) {
                                    Showcase2.showMessage("Button Click",
                                            Format.format("You clicked the {0} button", btnID));
                                }
                            });
                }
            });

            panel1.add(new HTMLPanel("A Standard Yes/No Confirm Dialog.", 0, 0, 0, 10));

            panel1.addButton(button1);
            panel.add(new PaddedPanel(panel1, 0, 0, 10, 10));

            Panel panel2 = new Panel();
            panel2.setTitle("Prompt");
            panel2.setFrame(true);
            panel2.setWidth(250);
            panel2.setHeight(150);
            panel2.setPaddings(20);

            Button button2 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MessageBox.prompt("Name", "Please enter your name:",
                            new MessageBox.PromptCallback() {
                                public void execute(String btnID, String text) {
                                    Showcase2.showMessage("Button Click",
                                            Format.format("You clicked the {0} button and entered the text \"{1}\"", btnID, text));
                                }
                            });
                }
            });
            panel2.add(new HTMLPanel("A Standard prompt dialog.", 0, 0, 0, 10));
            panel2.addButton(button2);
            panel.add(new PaddedPanel(panel2, 0, 0, 10, 10));


            Panel panel3 = new Panel();
            panel3.setTitle("Multi-line Prompt");
            panel3.setFrame(true);
            panel3.setWidth(250);
            panel3.setHeight(150);
            panel3.setPaddings(20);


            Button button3 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    MessageBox.show(new MessageBoxConfig() {
                        {
                            setTitle("Address");
                            setMsg("Please enter your address:");
                            setWidth(300);
                            setButtons(MessageBox.OKCANCEL);
                            setMultiline(true);
                            setCallback(new MessageBox.PromptCallback() {
                                public void execute(String btnID, String text) {
                                    Showcase2.showMessage("Button Click",
                                            Format.format("You clicked the {0} button and entered the text \"{1}\"", btnID, text));
                                }
                            });
                            setAnimEl(button.getId());
                        }
                    });
                }
            });
            panel3.add(new HTMLPanel("A multi-line prompt dialog.", 0, 0, 0, 10));
            panel3.addButton(button3);
            panel.add(new PaddedPanel(panel3, 0, 0, 10, 10));


            Panel panel4 = new Panel();
            panel4.setTitle("Yes/No/Cancel");
            panel4.setFrame(true);
            panel4.setWidth(250);
            panel4.setHeight(150);
            panel4.setPaddings(20);

            Button button4 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    MessageBox.show(new MessageBoxConfig() {
                        {
                            setTitle("Save Changes?");
                            setMsg("Your are closing a tab that has unsaved changes. Would you like to save your changes?");
                            setButtons(MessageBox.YESNOCANCEL);
                            setCallback(new MessageBox.PromptCallback() {
                                public void execute(String btnID, String text) {
                                    Showcase2.showMessage("Button Click",
                                            Format.format("You clicked the {0} button", btnID));
                                }
                            });
                            setAnimEl(button.getId());
                        }
                    });
                }
            });
            panel4.add(new HTMLPanel("Standard Yes/No/Cancel dialog.", 0, 0, 0, 10));

            panel4.addButton(button4);
            panel.add(new PaddedPanel(panel4, 0, 0, 10, 10));


            Panel panel5 = new Panel();
            panel5.setTitle("Progress Dialog");
            panel5.setFrame(true);
            panel5.setWidth(250);
            panel5.setHeight(150);
            panel5.setPaddings(20);

            Button button5 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    MessageBox.show(new MessageBoxConfig() {
                        {
                            setTitle("Please wait...");
                            setMsg("Initializing...");
                            setWidth(240);
                            setProgress(true);
                            setClosable(false);
                            setCallback(new MessageBox.PromptCallback() {
                                public void execute(String btnID, String text) {
                                    Showcase2.showMessage("Button Click",
                                            Format.format("You clicked the {0} button and entered the text {1}", btnID, text));
                                }
                            });
                            setAnimEl(button.getId());
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
            panel5.add(new HTMLPanel("You can set a progress on a progress MessageBox..", 0, 0, 0, 10));

            panel5.addButton(button5);
            panel.add(new PaddedPanel(panel5, 0, 0, 10, 10));


            Panel panel6 = new Panel();
            panel6.setTitle("Wait Dialog");
            panel6.setFrame(true);
            panel6.setWidth(250);
            panel6.setHeight(150);
            panel6.setPaddings(20);

            Button button6 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(final Button button, EventObject e) {
                    MessageBox.show(new MessageBoxConfig() {
                        {
                            setMsg("Saving your data, please wait...");
                            setProgressText("Saving...");
                            setWidth(300);
                            setWait(true);
                            setWaitConfig(new WaitConfig() {
                                {
                                    setInterval(200);
                                }
                            });
                            setAnimEl(button.getId());
                        }
                    });

                    Timer timer = new Timer() {
                        public void run() {
                            MessageBox.hide();
                            Showcase2.showMessage("Done", "Your fake data was saved!");
                        }
                    };
                    timer.schedule(8000);
                }
            });
            panel6.add(new HTMLPanel("Dialog with indefinite progress bar (will close after 8 sec).", 0, 0, 0, 10));

            panel6.addButton(button6);
            panel.add(new PaddedPanel(panel6, 0, 0, 10, 10));


            Panel panel7 = new Panel();
            panel7.setTitle("Alert");
            panel7.setFrame(true);
            panel7.setWidth(250);
            panel7.setHeight(150);
            panel7.setPaddings(20);

            Button button7 = new Button("Show Me", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MessageBox.alert("Changes saved successfully");
                }
            });
            panel7.add(new HTMLPanel("Standard Alert dialog.", 0, 0, 0, 10));

            panel7.addButton(button7);
            panel.add(new PaddedPanel(panel7, 0, 0, 10, 10));

        }
        return panel;
    }

    public String getIntro() {
        return "<p><h1>MessageBox Dialogs</h1><p>The example shows how to use the MessageBox class. Some of the buttons have animations, some are normal.</p></p>";
    }
}