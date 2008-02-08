package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.*;
import com.google.gwt.xml.client.*;

/**
 * Provides the abilty to a TreePanel using remote XML data.This TreeLoader can be configured to load tree data from XML
 * returned from a remote URL.
 *<p>
 * Sample code for loading a TreePanel using AsyncTreeNode and XmltreeLoader :
 *
 * <pre>
 * <code>
 *
 *     final TreePanel treePanel = new TreePanel("cb-tree", new TreePanelConfig() {
 *            {
 *                setAnimate(true);
 *                setEnableDD(true);
 *                setContainerScroll(true);
 *                setRootVisible(true);
 *            }
 *        });
 *
 *     final XMLTreeLoader loader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
 *            {
 *                setDataUrl("countries-cb.xml");
 *                setMethod("get");
 *                setRootTag("countries");
 *                setFolderIdMapping("@id");
 *                setLeafIdMapping("@id");
 *                setFolderTitleMapping("@title");
 *                setFolderTag("team");
 *                setLeafTitleMapping("@title");
 *                setLeafTag("country");
 *                setQtipMapping("@qtip");
 *                setDisabledMapping("@disabled");
 *                setCheckedMapping("@checked");
 *                setIconMapping("@icon");
 *                setAttributeMappings(new String[]{"@rank"});
 *            }
 *        });
 *        AsyncTreeNode root = new AsyncTreeNode("Countries", new AsyncTreeNodeConfig() {
 *            {
 *                setLoader(loader);
 *            }
 *        });
 *
 *        treePanel.setRootNode(root);
 *        treePanel.render();
 *
 *        root.expand();
 *        treePanel.expandAll();
 * </code>
 * </pre>
 *
 * The above code loads a Tree using the following XML data - countries-cb.xml
 *
 * <pre>
 * <code>
 *&lt;countries&gt;
 *    &lt;team id="team-a" title="Team A" icon="images/silk/flag_yellow.gif" checked="true"&gt;
 *        &lt;country title="Brazil" qtip="Rank 2" rank="2"  checked="false"/&gt;
 *        &lt;country title="Canada" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="China" qtip="Rank 4" rank="4" checked="false"/&gt;
 *    &lt;/team&gt;
 *    &lt;team title="Team B" icon="images/silk/flag_blue.gif"&gt;
 *        &lt;country title="Germany" qtip="Captain" checked="true" rank="1"/&gt;
 *        &lt;country title="France" qtip="Rank 2" rank="2" checked="false"/&gt;
 *        &lt;country title="Canada" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="India" qtip="Rank 4" rank="4" checked="false"/&gt;
 *        &lt;country title="Seychelles" qtip="Rank 5" rank="5" checked="false"/&gt;
 *    &lt;/team&gt;
 *
 *    &lt;team title="Team C" icon="images/silk/flag_green.gif"&gt;
 *        &lt;country title="United States" qtip="Captain - Rank 1" checked="true" rank="1"/&gt;
 *        &lt;country title="Japan" qtip="Rank 2" rank="2" checked="false"/&gt;
 *        &lt;country title="Italy" qtip="Rank 3" rank="3" checked="false"/&gt;
 *        &lt;country title="Finland" qtip="Rank 4" rank="4" checked="false"/&gt;
 *    &lt;/team&gt;
 *  &lt;/countries&gt;
 * </code>
 * </pre>
 *
 * @see com.gwtext.client.widgets.tree.TreePanel
 * @see com.gwtext.client.widgets.tree.TreeLoader
 * @see com.gwtext.client.widgets.tree.AsyncTreeNode
 */
public class XMLTreeLoader extends TreeLoader {

    static {
        init();
    }

    /**
     * Construct a new XMLTreeLoader.
     *
     * @param config the treeloader config
     */
    public XMLTreeLoader(XMLTreeLoaderConfig config) {
        jsObj = create(config);
    }

    protected native JavaScriptObject create(XMLTreeLoaderConfig config)/*-{
        return new $wnd.Ext.tree.XMLTreeLoader(config);
    }-*/;

    private static native void init() /*-{
       $wnd.Ext.tree.XMLTreeLoader = function(configJ) {
         $wnd.Ext.tree.XMLTreeLoader.superclass.constructor.call(this, configJ.@com.gwtext.client.core.JsObject::jsObj);
         this.configJ = configJ;
       };

       $wnd.Ext.extend($wnd.Ext.tree.XMLTreeLoader, $wnd.Ext.tree.TreeLoader, {

               load : function(node, callback){
                       if(this.clearOnLoad){
                           while(node.firstChild){
                               node.removeChild(node.firstChild);
                           }
                       }
                       this.requestData(node, callback);
                   },

              requestData : function(node, callback){
                   if(this.fireEvent("beforeload", this, node, callback) !== false){
                       var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                       var params = this.getParams(node);
                       @com.gwtext.client.widgets.tree.XMLTreeLoader::requestData(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/XMLTreeLoaderConfig;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this, nodeJ, this.configJ, this.requestMethod, this.dataUrl||this.url, this.handleResponse, this.handleFailure, callback, params);

                   }else{
                       // if the load is cancelled, make sure we notify
                       // the node that we are done
                       if(typeof callback == "function"){
                           callback();
                       }
                   }
               },

               handleResponse : function(response){
                   this.transId = false;
                   //var a = response.argument;
                   var callback  = response.callback;
                   var node = response.node;
                   var responseData = response.responseData;
                   if(typeof callback == "function"){
                       callback(this, node);
                   }
                   this.fireEvent("load", this, node, responseData);
               },

               handleFailure : function(response){
                   this.transId = false;
                   var callback  = response.callback;
                   var node = response.node;
                   var responseData = response.responseData;
                   this.fireEvent("loadexception", this, node, responseData);
                   if(typeof callback == "function"){
                       callback(this, node);
                   }
               }
       });
    }-*/;


    private static void requestData(final JavaScriptObject treeLoader, final TreeNode root, final XMLTreeLoaderConfig config, String method, String url, final JavaScriptObject success, final JavaScriptObject failure, final JavaScriptObject callback, String params) {
        //build side nav tree from xml data
        RequestBuilder.Method httpMethod = "post".equalsIgnoreCase(method) ? RequestBuilder.POST : RequestBuilder.GET;

        RequestBuilder builder = new RequestBuilder(httpMethod, url);
        builder.setHeader("Content-type","application/x-www-form-urlencoded");
        try {
            builder.sendRequest(params, new RequestCallback() {

                public void onResponseReceived(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        Document xml = null;
                        try {
                            xml = XMLParser.parse(response.getText());
                        } catch (Exception e) {
                            call(failure, treeLoader, root.getJsObj(), callback, e.getMessage());
                            return;
                        }
                        String rootTag = config.getRootTag();
                        Node rootNode = null;
                        if (rootTag == null) {
                            rootNode = xml.getDocumentElement().getParentNode().getChildNodes().item(0);
                        } else {
                            rootNode = xml.getElementsByTagName(rootTag).item(0);
                        }
                        load(config, root, rootNode.getChildNodes());
                        call(success, treeLoader, root.getJsObj(), callback, response.getText());

                    } else {
                        call(failure, treeLoader, root.getJsObj(), callback, response.getStatusCode() + ":" + response.getText());
                    }
                }

                public void onError(Request request, Throwable throwable) {
                    call(failure, treeLoader, root.getJsObj(), callback, throwable.getMessage());
                }
            });
        } catch (RequestException e) {
            call(failure, treeLoader, root.getJsObj(), callback, e.getMessage());
        }
    }

    private static native void call(JavaScriptObject func, JavaScriptObject treeLoader, JavaScriptObject node, JavaScriptObject callback, String responseData)/*-{
        var arguments =  {callback: callback, node: node, responseData : responseData};
        func.call(treeLoader, arguments);
    }-*/;

    private static void load(XMLTreeLoaderConfig config, TreeNode currentNode, NodeList chidren) {
        for (int i = 0; i < chidren.getLength(); i++) {
            Node child = chidren.item(i);
            if (!(child instanceof Element)) continue;
            String name = child.getNodeName();
            String folderTag = config.getFolderTag();
            String leafTag = config.getLeafTag();

            if (name.equals(folderTag)) {
                final String id = evaluateNodeValue(child, config.getFolderIdMapping());
                final String title = evaluateNodeValue(child, config.getFolderTitleMapping());
                TreeNode treeNode = createNode(child, config, id, title);
                currentNode.appendChild(treeNode);
                load(config, treeNode, child.getChildNodes());
            } else if (name.equals(leafTag)) {
                final String id = evaluateNodeValue(child, config.getLeafIdMapping());
                final String title = evaluateNodeValue(child, config.getLeafTitleMapping());
                TreeNode treeNode = createNode(child, config, id, title);
                currentNode.appendChild(treeNode);
            }
        }
    }

    private static TreeNode createNode(Node child, XMLTreeLoaderConfig config, final String id, String title) {
        final String icon = evaluateNodeValue(child, config.getIconMapping());
        final String iconCls = evaluateNodeValue(child, config.getIconClsMapping());
        final String qtip = evaluateNodeValue(child, config.getQtipMapping());
        final String checked = evaluateNodeValue(child, config.getCheckedMapping());
        final String disabled = evaluateNodeValue(child, config.getDisabledMapping());
        final String allowDrag = evaluateNodeValue(child, config.getAllowDragMapping());
        final String allowDrop = evaluateNodeValue(child, config.getAllowDropMapping());
        final String expanded = evaluateNodeValue(child, config.getExpandedMapping());
        final String href = evaluateNodeValue(child, config.getHrefMapping());
        final String hrefTarget = evaluateNodeValue(child, config.getHrefTargetMapping());

        TreeNodeConfig nodeConfig = new TreeNodeConfig() {
            {
                setId(id);
                setIcon(icon);
                setIconCls(iconCls);
                setQtip(qtip);
                setDisabled(booleanValue(disabled));
                setAllowDrag(allowDrag == null || booleanValue(allowDrag));
                setAllowDrop(allowDrop == null || booleanValue(allowDrop));
                setExpanded(expanded == null || booleanValue(expanded));
                setHref(href);
                setHrefTarget(hrefTarget);
            }
        };
        if (checked != null) {
            nodeConfig.setChecked(booleanValue(checked));
        }
        TreeNode treeNode = new TreeNode(title, nodeConfig);

        String[] attributeMappings = config.getAttributeMappings();
        if (attributeMappings != null) {
            for (int j = 0; j < attributeMappings.length; j++) {
                String attributeMapping = attributeMappings[j];
                String attributeName = attributeMapping.replaceAll("@", "");
                String attributeValue = evaluateNodeValue(child, attributeMapping);
                treeNode.setAttribute(attributeName, attributeValue);
            }
        }
        return treeNode;
    }

    private static boolean booleanValue(String value) {
        if (value == null) return false;
        return value.equalsIgnoreCase("true") || value.equals("1");
    }

    private static String evaluateNodeValue(Node node, String mapping) {
        if (mapping == null) return null;
        String value = null;
        if (mapping.startsWith("@")) {
            String attribute = mapping.substring(1, mapping.length());
            Node item = node.getAttributes().getNamedItem(attribute);
            value = item == null ? null : item.getNodeValue();
        } else {
            NodeList nodeList = node.getChildNodes();
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node child = nodeList.item(j);
                if (!(child instanceof Element)) continue;
                String nodeName = child.getNodeName();
                if (nodeName.equals(mapping)) {
                    value = child.getChildNodes().item(0).getNodeValue();
                }
            }
        }
        return value;
    }
}
