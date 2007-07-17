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
package com.gwtext.sample.showcase.client.grid;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.util.DateUtil;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.*;

import java.util.Date;

public class Grid3Panel extends Composite {

    private boolean init = false;
    private VerticalPanel vp;
    private Grid grid;
    private boolean showPreview = true;

    private Renderer renderTopic = new Renderer() {
        public String render(String value, Record record, int rowIndex, int colNum) {
            return Format.format("<b>{0}</b>{1}", new String[]{value, record.getAsString("excerpt")});
        }
    };

    private Renderer renderTopicPlain = new Renderer() {
        public String render(String value, Record record, int rowIndex, int colNum) {
            return Format.format("<b><i>{0}</i></b>", new String[]{value});
        }
    };

    private Renderer renderLast = new Renderer() {
        public String render(String value, Record record, int rowIndex, int colNum) {
            Date lastPost = record.getAsDate("lastPost");
            String lastPostStr = DateUtil.format(lastPost, "M j, Y, g:i a");
            return Format.format("{0}<br/>by {1}", new String[]{lastPostStr, record.getAsString("author")});
        }
    };

    private Renderer renderLastPlain = new Renderer() {
        public String render(String value, Record record, int rowIndex, int colNum) {
            Date lastPost = record.getAsDate("lastPost");
            return DateUtil.format(lastPost, "M j, Y, g:i a");
        }
    };


    public Grid3Panel() {
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
        DataProxy dataProxy = new ScriptTagProxy("http://www.yui-ext.com/forum2/topics-remote.php");

        JsonReader reader = new JsonReader(new JsonReaderConfig() {
            {
                setRoot("topics");
                setTotalProperty("totalCount");
                setId("topic_id");
            }
        }, new RecordDef(new Field[]{
                new StringField("title", "topic_title"),
                new StringField("author", "username"),
                new IntegerField("totalPosts", "topic_replies"),
                new DateField("lastPost", "post_time", "timestamp"),
                new StringField("lastPoster", "user2"),
                new StringField("excerpt", "post_text")
        }));

        final Store store = new Store(dataProxy, reader, true);
        store.setDefaultSort("lastPost", "DESC");
        store.load();

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setId("topic");
                        setHeader("Topic");
                        setDataIndex("title");
                        setWidth(420);
                        setRenderer(getTopicRenderer());
                        setCss("white-space:normal;");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Author");
                        setDataIndex("author");
                        setWidth(100);
                        setHidden(true);
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Total Posts");
                        setDataIndex("totalPosts");
                        setWidth(70);
                        setAlign("right");
                    }
                },
                new ColumnConfig() {
                    {
                        setId("last");
                        setHeader("Last Post");
                        setDataIndex("lastPost");
                        setWidth(150);
                        setRenderer(getLastRenderer());
                        setSortable(true);
                    }
                }
        });

        columnModel.setDefaultSortable(true);

        grid = new Grid("topic-grid", "300px", "655px", store, columnModel, new GridConfig() {
            {
                setEnableColLock(false);
                setLoadMask(true);
            }
        });

        grid.render();

        ExtElement gridFoot = grid.getView().getFooterPanel(true);

        PagingToolbar pagingToolbar = new PagingToolbar(gridFoot, store, new PagingToolbarConfig() {
            {
                setPageSize(25);
                setDisplayInfo(true);
                setDisplayMsg("Displaying topics {0} - {1} of {2}");
                setEmptyMsg("No topics to display");
            }
        });

        pagingToolbar.addSeparator();
        pagingToolbar.addButton(new ToolbarButton("Detailed View", new ButtonConfig() {
            {
                setPressed(showPreview);
                setEnableToggle(true);
                setCls("x-btn-text-icon details");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onToggle(Button button, boolean pressed) {
                        togglePreview(pressed);
                    }
                });
            }
        }));

        store.load(new StoreLoadConfig() {
            {
                setParams(new UrlParam[]{
                        new UrlParam("start", 0),
                        new UrlParam("limit", 25)
                });
            }
        });

        vp.setWidth("100%");
        vp.setHeight("100%");
        vp.add(grid);

    }

    private Renderer getTopicRenderer() {
        if (showPreview) {
            return renderTopic;
        } else {
            return renderTopicPlain;
        }
    }

    private Renderer getLastRenderer() {
        if (showPreview) {
            return renderLast;
        } else {
            return renderLastPlain;
        }
    }

    private void togglePreview(boolean pressed) {
        showPreview = pressed;
        grid.getColumnModel().setRenderer(0, getTopicRenderer());
        grid.getColumnModel().setRenderer(3, getLastRenderer());
        grid.getView().refresh();
    }
}
