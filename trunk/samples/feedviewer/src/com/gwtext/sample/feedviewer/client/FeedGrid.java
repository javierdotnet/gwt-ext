package com.gwtext.sample.feedviewer.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.data.event.StoreListenerAdapter;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridRowListenerAdapter;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.ItemConfig;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;

import java.util.Date;

/**
 * This class handles the display of the feed listing in a grid along with the events associated with
 * actions carried out on the grid like the context menu
 */
public class FeedGrid {
    private Grid grid;
    private Store store;
    private boolean showPreview = true;
    private Menu gridMenu;
    private Record ctxRecord;
    private MainPanel viewer;

    public FeedGrid(MainPanel mainPanel) {
        //keep handle to main panel as we want to be able to add new
        //feed details panel when user selects 'View in Tab'
        this.viewer = mainPanel;

        //data store for grid using Google API that returns data as Json
        store = new Store(
                new JsonReader(new JsonReaderConfig() {
                    {
                        setRoot("entries");
                    }
                }, new RecordDef(new Field[]{
                        new StringField("title"),
                        new StringField("publishedDate"),
                        new StringField("link"),
                        new StringField("content")
                }
                )));

        //when the store is loaded, select the first row
        store.addStoreListener(new StoreListenerAdapter() {
            public void onLoad(Store store, Record[] records) {
                if (records != null && records.length > 0) {
                    grid.getSelectionModel().selectFirstRow();
                }
            }
        });

        //initial sort order
        store.setDefaultSort("publishedDate", "DESC");

        //setup column model for the grid along with formatting options
        ColumnModel cm = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setId("title");
                        setHeader("Title");
                        setDataIndex("title");
                        setSortable(true);
                        setWidth(420);
                        setRenderer(getRowRenderer());
                    }
                },
                new ColumnConfig() {
                    {
                        setId("last");
                        setHeader("Date");
                        setDataIndex("publishedDate");
                        setWidth(150);
                        setSortable(true);
                        setRenderer(new Renderer() {
                            public String render(String value, Record record, int rowIndex, int colNum) {
                                if (value == null || value.equals("")) {
                                    return "";
                                }
                                Date date = new Date(value);
                                Date now = new Date();
                                if (date.getDay() == now.getDay() && date.getMonth() == now.getMonth() && date.getYear() == now.getYear()) {
                                    return "Today " + Format.date(value, "g:i a");
                                } else {
                                    return Format.date(value, "n/j g:i a");
                                }
                            }
                        });
                    }
                }
        });

        //create and render grid
        grid = new Grid("topic-grid", "100%", "100%", store, cm, new GridConfig() {
            {
                setAutoExpandColumn("title");
            }
        });
        grid.render();

        //add listener for context menu when user right clicks on a row
        grid.addGridRowListener(new GridRowListenerAdapter() {
            public void onRowContextMenu(Grid grid, int rowIndex, EventObject e) {
                if (gridMenu == null) {
                    createGridMenu();
                }
                e.stopEvent();
                ctxRecord = grid.getStore().getAt(rowIndex);
                gridMenu.showAt(e.getXY());
            }
        });
    }

    //create context menu along with associated event handlers for each menu item
    private void createGridMenu() {
        gridMenu = new Menu("grid-ctx");
        gridMenu.addItem(new Item("View in new Tab", new ItemConfig() {
            {
                setIconCls("new-tab");
                setBaseItemListener(new BaseItemListenerAdapter() {
                    public void onClick(BaseItem item, EventObject e) {
                        viewer.openTab(ctxRecord);
                    }
                });
            }
        }));

        gridMenu.addSeparator();

        gridMenu.addItem(new Item("Go to Post", new ItemConfig() {
            {
                setIconCls("new-win");
                setBaseItemListener(new BaseItemListenerAdapter() {
                    public void onClick(BaseItem item, EventObject e) {
                        viewer.openExternalUrl(ctxRecord.getAsString("link"));
                    }
                });
            }
        }));

        gridMenu.addSeparator();

        gridMenu.addItem(new Item("Refresh", new ItemConfig() {
            {
                setIconCls("refresh-icon");
                setBaseItemListener(new BaseItemListenerAdapter() {
                    public void onClick(BaseItem item, EventObject e) {
                        ctxRecord = null;
                        grid.getStore().reload();
                    }
                });
            }
        }));
    }

    public Grid getGrid() {
        return grid;
    }

    /**
     * load a feed by issuing a http request of the URL associated with the store and pass a 'feed' request
     * parameter
     *
     * @param feedUrl feed url
     */
    public void loadFeed(final String feedUrl) {
        loadUsingGoogleAPI(store.getJsObj(), feedUrl);
    }

    private native void loadUsingGoogleAPI(JavaScriptObject store, String url) /*-{
        var feed = new $wnd.google.feeds.Feed(url);
        feed.setNumEntries(20);
        feed.load(function(result) {            
            store.loadData(result.feed);
        });
    }-*/;


    //render for grid row
    public Renderer getRowRenderer() {
        return new Renderer() {
            public String render(String value, Record record, int rowIndex, int colNum) {
                if (showPreview) {
                    return Format.format("<div class=\"topic\"><b>{0}</b><p>{1}</p></div>",
                            new String[]{
                                    value,
                                    Format.ellipsis(Format.stripTags(record.getAsString("content")), 200)
                            });
                } else {
                    return Format.format("<div class=\"topic\"><b>{0}</b></div>",
                            new String[]{
                                    value
                            });
                }
            }
        };
    }

    //toggle between preview and title-only views
    public void togglePreview(boolean pressed) {
        showPreview = pressed;
        grid.getView().refresh();
    }
}
