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
package com.gwtext.sample.showcase.client;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.UpdateManager;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.event.ContentPanelListenerAdapter;

public abstract class ShowcaseExample {

    private boolean init = false;
    protected ContentPanel[] panels;

    public ContentPanel[] getPanels() {
        if (!init) {
            init = true;
            setup();
        }
        return panels;
    }

    public abstract void setup();

    protected VerticalPanel createPanel() {
        VerticalPanel vp = new VerticalPanel();
        vp.setSpacing(15);
        return vp;
    }

    protected ContentPanel getUrlContentPanel(String label, String sourceUrl) {
        ContentPanel panel = new ContentPanel(Ext.generateId(), label);

        final UpdateManager updateManager = panel.getUpdateManager();
        updateManager.setDefaultUrl(sourceUrl);
        updateManager.setLoadScripts(true);
        updateManager.setDisableCaching(false);

        panel.addContentPanelListener(new ContentPanelListenerAdapter() {
            public void onActivate(final ContentPanel cp) {
                Timer t = new Timer() {
                    public void run() {
                        //need to add this check because onActivate is triggered even when content panel is being added
                        //programatically to the region and not only when clicked by user.
                        if (cp.getEl().isVisible()) {
                            updateManager.refresh();
                            cp.purgeListeners();
                        }
                    }
                };
                t.schedule(1000);
            }
        });
        return panel;
    }
}
