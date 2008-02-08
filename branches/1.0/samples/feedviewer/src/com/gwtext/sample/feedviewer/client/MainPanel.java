package com.gwtext.sample.feedviewer.client;

import com.google.gwt.user.client.Window;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.RowSelectionListenerAdapter;
import com.gwtext.client.widgets.layout.*;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.ItemConfig;
import com.gwtext.client.widgets.menu.Menu;


/**
 * This panel is the panel that displays the feed listing along with the preview pane.
 */
public class MainPanel {
    private NestedLayoutPanel nestedLayoutPanel;

    private FeedGrid feedGrid;
    private Grid grid;
    private ContentPanel previewPanel;
    private Template template;
    private BorderLayout mainLayout;


    public MainPanel(BorderLayout mainLayout) {
        this.mainLayout = mainLayout;
        template = new Template(
                "<div class='post-data'>" +
                        "<span class='post-date'>{0}</span>" +
                        "<h3 class='post-title'>{1}</h3>" +
                        "</div>" +
                        "<div class=\"post-body\">{2}</div>"
        );

        BorderLayout innerLayout = new BorderLayout("100%", "100%", new LayoutRegionConfig(),
                //south
                new LayoutRegionConfig() {
                    {
                        setAutoScroll(true);
                        setInitialSize(250);
                        setSplit(true);
                    }
                }, new LayoutRegionConfig(), new LayoutRegionConfig(), new LayoutRegionConfig());

        //setup toolbar
        final Toolbar mainTB = new Toolbar(Ext.generateId());
        mainTB.addButton(new ToolbarButton("Open All", new ButtonConfig() {
            {
                setTooltip(new QuickTipsConfig() {
                    {
                        setTitle("Open All");
                        setText("Opens all item in tabs");
                    }
                });

                setIconCls("tabs");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        openAll();
                    }
                });
            }
        }));

        mainTB.addSeparator();

        Menu readingMenu = new Menu("reading-menu");
        readingMenu.addItem(new Item("Bottom", new ItemConfig() {
            {
                setIconCls("preview-bottom");
            }
        }));
        readingMenu.addItem(new Item("Right", new ItemConfig() {
            {
                setIconCls("preview-right");
            }
        }));
        readingMenu.addItem(new Item("Hide", new ItemConfig() {
            {
                setIconCls("preview-hide");
            }
        }));

        mainTB.addButton(new ToolbarMenuButton(readingMenu,
                new SplitButtonConfig() {
                    {
                        setText("Reading Pane");
                        setTooltip(new QuickTipsConfig() {
                            {
                                setTitle("Reading Pane");
                                setText("Show, move or hide the Reading Pane");
                                setAnimate(true);
                            }
                        });
                    }
                }));

        mainTB.addButton(new ToolbarButton("Summary", new ButtonConfig() {
            {
                setPressed(true);
                setEnableToggle(true);
                setIconCls("summary");
                setTooltip(new QuickTipsConfig() {
                    {
                        setTitle("Post Summary");
                        setText("View a short summary of each item in the list");
                        setButtonListener(new ButtonListenerAdapter() {
                            public void onToggle(Button button, boolean pressed) {
                                togglePreview(pressed);
                            }
                        });
                    }
                });
            }
        }));

        nestedLayoutPanel = new NestedLayoutPanel(innerLayout, new ContentPanelConfig() {
            {
                setFitToFrame(true);
            }
        });

        final Toolbar previewTB = new Toolbar("preview-tb");
        previewTB.addButton(new ToolbarButton("View in New Tab", new ButtonConfig() {
            {
                setIconCls("new-tab");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        openTab();
                    }
                });
            }
        }));
        previewTB.addSeparator();
        previewTB.addButton(new ToolbarButton("Go to Post", new ButtonConfig() {
            {
                setIconCls("new-win");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        String url = grid.getSelectionModel().getSelected().getAsString("link");
                        openExternalUrl(url);
                    }
                });
            }
        }));

        previewPanel = new ContentPanel("preview", new ContentPanelConfig() {
            {
                setTitle("Preview Pane");
                setToolbar(previewTB);
                setFitToFrame(true);
                setCls("preview");
            }
        });

        innerLayout.add(LayoutRegionConfig.SOUTH, previewPanel);

        feedGrid = new FeedGrid(this);
        grid = feedGrid.getGrid();

        grid.getSelectionModel().addRowSelectionListener(new RowSelectionListenerAdapter() {
            public void onRowSelect(RowSelectionModel sm, int rowIndex) {
                Record record = grid.getStore().getAt(rowIndex);
                String content = getHtmlContent(record);
                previewPanel.setContent(content);
            }
        });

        GridPanel gridPanel = new GridPanel(grid, new ContentPanelConfig() {
            {
                setToolbar(mainTB);
            }
        });
        innerLayout.add(LayoutRegionConfig.CENTER, gridPanel);
    }

    private String getHtmlContent(Record record) {
        return template.applyTemplate(new String[]{Format.date(record.getAsString("publishedDate"), "M j, Y, g:i a"),
                record.getAsString("title"),
                record.getAsString("content")
        });
    }

    public NestedLayoutPanel getNestedLayoutPanel() {
        return nestedLayoutPanel;
    }

    public void loadFeed(String feedName, String feedUrl) {
        previewPanel.clear();
        previewPanel.setContent("");
        feedGrid.loadFeed(feedUrl);
    }

    private void openAll() {
        Record[] records = grid.getStore().getRecords();
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            openTab(record);
        }
    }

    private void togglePreview(boolean pressed) {
        feedGrid.togglePreview(pressed);
    }

    public void openTab() {
        openTab(null);
    }

    public void openTab(Record record) {
        if (record == null) {
            record = grid.getSelectionModel().getSelected();
        }
        final String url = record.getAsString("link");
        final String id = convertToId(url);

        final String title = record.getAsString("title");

        ContentPanel panel = mainLayout.findPanel(id);
        if (panel != null) {
            mainLayout.showPanel(id);
        } else {
            final Toolbar tb = new Toolbar(id + "-tb");
            tb.addButton(new ToolbarButton("Go to Post", new ButtonConfig() {
                {
                    setIconCls("new-win");
                    setButtonListener(new ButtonListenerAdapter() {
                        public void onClick(Button button, EventObject e) {
                            openExternalUrl(url);
                        }
                    });
                }
            }));
            panel = new ContentPanel(id, new ContentPanelConfig() {
                {
                    setTitle(title);
                    setCls("preview");
                    setClosable(true);
                    setAutoScroll(true);
                    setFitToFrame(true);
                    setToolbar(tb);

                }
            });
            panel.setContent(getHtmlContent(record));

            mainLayout.add(LayoutRegionConfig.CENTER, panel);
            mainLayout.showPanel(id);
        }
    }

    public void openExternalUrl(String url) {
        Window.open(url, "_blank", "");
    }

    private native String convertToId(String url) /*-{
        return url.replace(/[^A-Z0-9-_]/gi, '');
    }-*/;

}
