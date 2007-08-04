package com.gwtext.sample.feedviewer.client;

//import com.google.gwt.http.client.*;

import com.google.gwt.http.client.*;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.LayoutDialog;
import com.gwtext.client.widgets.LayoutDialogConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.layout.ContentPanel;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;

/**
 * Dialog that shows up when a user needs to add a feed.
 */
public class FeedWindow {
    private ComboBox feedUrl;
    private LayoutDialog dialog;

    private static String[][] defaultFeeds = new String[][]{
            new String[]{"http://feeds.feedburner.com/ajaxian", "Ajaxian"},
            new String[]{"http://sports.yahoo.com/nba/rss.xml", "NBA News"},
            new String[]{"http://feeds.dzone.com/dzone/frontpage", "DZone.com"},
    };

    private ValidFeedListener validFeedListener;

    public FeedWindow() {

        feedUrl = new ComboBox("feed-url", new ComboBoxConfig() {
            {
                setFieldLabel("Enter the URL of the feed to add");
                setEmptyText("http://example.com/blog/feed");
                setWidth(450);
                setValidationEvent(false);
                setValidateOnBlur(false);
                setMsgTarget("under");
                setTriggerAction("all");
                setDisplayField("url");
                setMode("local");

                setTpl(new Template("<div class=\"x-combo-list-item\">" +
                        "<em>{url}</em><strong>{text}</strong>" +
                        "<div class=\"x-clear\"></div></div>"));

                setStore(new SimpleStore(new String[]{"url", "text"}, defaultFeeds));
            }
        });

        //setup and render form
        Form form = new Form(Ext.generateId(), new FormConfig() {
            {
                setLabelAlign("top");
            }
        });
        form.container(new ContainerConfig() {
            {
                setStyle("padding:10px");
            }
        });
        form.add(feedUrl);
        form.end();
        form.render();

        //setup dialog
        dialog = new LayoutDialog(new LayoutDialogConfig() {
            {
                setTitle("Add Feed!");
                setWidth(500);
                setHeight(200);
                setResizable(false);
                setModal(true);
                setY(100);
                setAutoScroll(true);
                setShim(true);
            }
        }, null, null, null, null, new LayoutRegionConfig());

        ContentPanel contentPanel = new ContentPanel(Ext.generateId());
        contentPanel.add(form);
        dialog.getLayout().add(LayoutRegionConfig.CENTER, contentPanel);

        dialog.addButton(new Button("add-feed-btn", new ButtonConfig() {
            {
                setText("Add Feed!");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        onAdd();
                    }
                });
            }
        }));
        dialog.addButton(new Button("cancel-btn", new ButtonConfig() {
            {
                setText("Cancel");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        dialog.hide();
                    }
                });
            }
        }));
    }

    public void addValidFeedListener(ValidFeedListener listener) {
        this.validFeedListener = listener;
    }

    public void show(Button btn) {
        feedUrl.setValue("");
        if (btn != null) {
            dialog.show(btn.getEl());
        } else {
            dialog.show();
        }
    }

    private void markInvalid() {
        feedUrl.markInvalid("The URL specified is not a valid feed.");
        unmask();
    }

    private void unmask() {
        dialog.getEl().unmask();
    }

    private void hide() {
        dialog.hide();
    }

    private void onAdd() {
        //onAddUsingHttp();
        onAddUsingGoogleAPI();
    }

    private void onAddUsingGoogleAPI() {
        dialog.getEl().mask("Validating Feed...", "x-mask-loading");
        String url = feedUrl.getValue();
        validate(url);
    }

    private void notifyListener(String url, String title) {
        if (validFeedListener != null) {
            validFeedListener.onValid(url, title);
        }
    }

    private native void validate(String url)/*-{
        var feed = new $wnd.google.feeds.Feed(url);
        //just get one feed since we only want to validate here
        feed.setNumEntries(1);
        var fw = this;
        feed.load(function(result) {
            if (!(result.status.code == 200 && result.feed)) {
                fw.@com.gwtext.sample.feedviewer.client.FeedWindow::markInvalid()();
                fw.@com.gwtext.sample.feedviewer.client.FeedWindow::unmask()();
            } else {
                fw.@com.gwtext.sample.feedviewer.client.FeedWindow::unmask()();
                fw.@com.gwtext.sample.feedviewer.client.FeedWindow::notifyListener(Ljava/lang/String;Ljava/lang/String;)(url, result.feed.title);
                fw.@com.gwtext.sample.feedviewer.client.FeedWindow::hide()();
            }
        });
    }-*/;

    private void onAddUsingHttp() {
        dialog.getEl().mask("Validating Feed...", "x-mask-loading");
        final String url = feedUrl.getValue();
        String requestUrl = "feedproxy?feed=" + URL.encodeComponent(url);
        //AIR
        //String requestUrl = url;
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, requestUrl);
        try {
            builder.sendRequest(null, new RequestCallback() {

                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        Document xml = null;
                        try {
                            xml = XMLParser.parse(response.getText());
                        } catch (Exception e) {
                            markInvalid();
                            return;
                        }
                        validateFeed(xml, url);
                    } else {
                        markInvalid();
                    }
                }

                public void onError(Request request, Throwable throwable) {
                    feedUrl.markInvalid("The URL specified is not a valid RSS2 feed : " + throwable.getMessage());
                }
            });
        } catch (RequestException e) {
            feedUrl.markInvalid("The URL specified is not a valid RSS2 feed : " + e.getMessage());
        }
    }


    private void validateFeed(Document xml, String url) {
        NodeList channels = xml.getElementsByTagName("channel");
        if (channels.getLength() > 0) {
            String title = "Feed";
            Node channel = channels.item(0);
            NodeList chidren = channel.getChildNodes();
            for (int i = 0; i < chidren.getLength(); i++) {
                Node child = chidren.item(i);
                if (child.getNodeName().equals("title")) {
                    title = child.getFirstChild().getNodeValue();
                    break;
                }
            }
            dialog.getEl().unmask();
            if (validFeedListener != null) {
                validFeedListener.onValid(url, title);
            }
            dialog.hide();
        } else {
            dialog.getEl().unmask();
            markInvalid();
        }
    }
}
