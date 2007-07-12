package com.gwtext.sample.feedviewer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.gwtext.client.core.Ext;
import com.gwtext.client.widgets.QuickTips;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;
import com.gwtext.client.widgets.layout.NestedLayoutPanel;

/**
 * Main entry point for the feed viewer app.
 */
public class FeedViewer implements EntryPoint {

    private NestedLayoutPanel feedDetailsPanel;

    public void onModuleLoad() {

        Ext.setBlankImageUrl("images/s.gif");
        QuickTips.init();

        //setup main layout
        BorderLayout layout = createLayout();

        //create feed panel that has a tree view of feeds added
        FeedPanel feedPanel = new FeedPanel();

        //create the main panel that shows feeds grid / details
        final MainPanel mainPanel = new MainPanel(layout);

        //setup header image
        ContentPanel northContentPanel = new ContentPanel(Ext.generateId(), "Header");
        VerticalPanel headerPanel = new VerticalPanel();
        headerPanel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
        headerPanel.setHeight("100%");
        headerPanel.setSpacing(4);
        headerPanel.add(new Image("images/gwtext.png"));
        northContentPanel.add(headerPanel);
        layout.add(LayoutRegionConfig.NORTH, northContentPanel);

        //add feed panel to west region
        ContentPanel westContentPanel = new ContentPanel(Ext.generateId(), "Feeds");
        westContentPanel.add(feedPanel);
        layout.add(LayoutRegionConfig.WEST, westContentPanel);

        //add fedd details panel to center region
        feedDetailsPanel = mainPanel.getNestedLayoutPanel();
        layout.add(LayoutRegionConfig.CENTER, feedDetailsPanel);

        //add listener to feed panel so that when a feed is selected, the
        //feed listings are displayed
        feedPanel.addFeedListener(new FeedListener() {
            public void onSelect(String feedName, String feedUrl) {
                mainPanel.loadFeed(feedName, feedUrl);
                setTitle(feedName);
            }
        });

        //add a few feeds
        feedPanel.addFeed("http://www.jroller.com/rss/sjivan", "Sanjiv Jivan's Blog", true, true);
        feedPanel.addFeed("http://googlewebtoolkit.blogspot.com/atom.xml", "Google Web Toolkit Blog", true, true);
        feedPanel.addFeed("http://extjs.com/forum/external.php?type=RSS2", "ExtJS.com Forums", true, true);
        feedPanel.addFeed("http://news.google.com/?ned=us&topic=w&output=rss", "Google News - World", true, true);

        //add main layout to root panel
        RootPanel.get().add(layout);

    }

    //sets the title of the feed listing panel
    private void setTitle(String feedName) {
        feedDetailsPanel.setTitle(feedName);
    }

    //create main application layout
    private BorderLayout createLayout() {
        return new BorderLayout("100%", "100%",
                //north region
                new LayoutRegionConfig() {
                    {
                        setInitialSize(50);
                        setCollapsible(false);
                    }
                },
                //south region
                new LayoutRegionConfig(),
                //west region
                new LayoutRegionConfig() {
                    {
                        setTitle("Feeds");
                        setTitlebar(true);
                        setSplit(true);
                        setInitialSize(225);
                        setMinSize(175);
                        setMaxSize(400);
                        setCollapsible(true);
                        setAutoScroll(true);
                        setAnimate(true);
                    }
                },
                //east region
                new LayoutRegionConfig(),
                //south region
                new LayoutRegionConfig() {
                    {
                        setResizeTabs(true);
                        setPreferredTabWidth(150);
                        setTabPosition("top");
                        setAlwaysShowTabs(true);
                        setCloseOnTab(true);
                    }
                }
        );
    }
}
