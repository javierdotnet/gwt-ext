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

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

public class MessageBoxPanel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;

    public MessageBoxPanel() {
        vp = new VerticalPanel();
        vp.setSpacing(15);
        initWidget(vp);
    }

    protected void onLoad() {
        if (!init) {
            init = true;
            setup();
        }
    }

    private void setup() {
        JsonStore store = new JsonStore("json", "list.visits", new RecordDef(new Field[]{
                new StringField("summary"),
                new DateField("start"),
                new DateField("end")}
        ));

        HTML content = new HTML(html);
        Button b = new Button("test", new ButtonConfig() {
            {
                setText("Click Me!");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MessageBox.show(new MessageBoxConfig() {
                            {
                                setButtons(new NameValuePair[]{
                                        new NameValuePair("h", "Hello"),
                                        new NameValuePair("w", "World")
                                });

                                //setButtons(MessageBox.OKCANCEL);
                                setTitle("Hello World");
                                setClosable(true);
                                setMsg("Sample Message Box");
                                setCallback(new MessageBox.PromptCallback() {
                                    public void execute(String btnID, String text) {
                                        System.out.println("here");
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        vp.add(b);

    }


    private static String html = "<h1>MessageBox Dialogs</h1>\n" +
            "<p>The example shows how to use the MessageBox class. Some of the buttons have animations, some are normal.</p>\n" +
            "<p>The js is not minified so it is readable. See <a href=\"msg-box.js\">msg-box.js</a>.</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Confirm</b><br />\n" +
            "    Standard Yes/No dialog.\n" +
            "    <button id=\"mb1\">Show Me</button>\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Prompt</b><br />\n" +
            "    Standard prompt dialog.\n" +
            "    <button id=\"mb2\">Show Me</button>\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Multi-line Prompt</b><br />\n" +
            "    A multi-line prompt dialog.\n" +
            "    <button id=\"mb3\">Show Me</button>\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Yes/No/Cancel</b><br />\n" +
            "    Standard Yes/No/Cancel dialog.\n" +
            "    <button id=\"mb4\">Show Me</button>\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Progress Dialog</b><br />\n" +
            "    You can set a progress on a progress MessageBox.\n" +
            "    <button id=\"mb6\">Show Me</button>\n" +
            "</p>\n" +
            "\n" +
            "<p>\n" +
            "    <b>Alert</b><br />\n" +
            "    Standard alert message dialog.\n" +
            "    <button id=\"mb7\">Show Me</button>\n" +
            "</p>";

}
