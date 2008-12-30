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
 *     final TreePanel treePanel = new TreePanel() {
 *            {
 *                setAnimate(true);
 *                setEnableDD(true);
 *                setContainerScroll(true);
 *                setRootVisible(true);
 *            }
 *        };
 *
 *     final XMLTreeLoader loader = new XMLTreeLoader() {
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
 *        };
 *        AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
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
 * @author Sanjiv Jivan
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
     */
    public XMLTreeLoader() {
    }

    /**
     * Construct a new XMLTreeLoader.
     *
     * @param url the data url
     * @param rootTag the root tag
     * @param folderTag the folder tag
     *
     */
    public XMLTreeLoader(String url, String rootTag, String folderTag) {
        setDataUrl(url);
        setRootTag(rootTag);
        setFolderTag(folderTag);
    }

    protected native JavaScriptObject create(JavaScriptObject configJS)/*-{
        return new $wnd.Ext.tree.XMLTreeLoader(configJS, this);
    }-*/;

    private static native void init() /*-{
       $wnd.Ext.tree.XMLTreeLoader = function(configJS, selfJ) {
         $wnd.Ext.tree.XMLTreeLoader.superclass.constructor.call(this, configJS);
          this.selfJ = selfJ;
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
                       var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                       var params = this.getParams(node);
                       @com.gwtext.client.widgets.tree.XMLTreeLoader::requestData(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/XMLTreeLoader;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this, nodeJ, this.selfJ, this.requestMethod, this.dataUrl||this.url, this.handleResponse, this.handleFailure, callback, params);

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


    private static void requestData(final JavaScriptObject treeLoaderJS, final TreeNode root, final XMLTreeLoader treeLoader, String method, String url, final JavaScriptObject success, final JavaScriptObject failure, final JavaScriptObject callback, String params) {
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
                            call(failure, treeLoaderJS, root.getJsObj(), callback, e.getMessage());
                            return;
                        }
                        String rootTag = treeLoader.getRootTag();
                        Node rootNode = null;
                        if (rootTag == null) {
                            rootNode = xml.getDocumentElement().getParentNode().getChildNodes().item(0);
                        } else {
                            rootNode = xml.getElementsByTagName(rootTag).item(0);
                        }
                        load(treeLoader, root, rootNode.getChildNodes());
                        call(success, treeLoaderJS, root.getJsObj(), callback, response.getText());

                    } else {
                        call(failure, treeLoaderJS, root.getJsObj(), callback, response.getStatusCode() + ":" + response.getText());
                    }
                }

                public void onError(Request request, Throwable throwable) {
                    call(failure, treeLoaderJS, root.getJsObj(), callback, throwable.getMessage());
                }
            });
        } catch (RequestException e) {
            call(failure, treeLoaderJS, root.getJsObj(), callback, e.getMessage());
        }
    }

    private static native void call(JavaScriptObject func, JavaScriptObject treeLoader, JavaScriptObject node, JavaScriptObject callback, String responseData)/*-{
        var arguments =  {callback: callback, node: node, responseData : responseData};
        func.call(treeLoader, arguments);
    }-*/;

    private static void load(XMLTreeLoader treeLoader, TreeNode currentNode, NodeList chidren) {
        for (int i = 0; i < chidren.getLength(); i++) {
            Node child = chidren.item(i);
            if (!(child instanceof Element)) continue;
            String name = child.getNodeName();
            String folderTag = treeLoader.getFolderTag();
            String leafTag = treeLoader.getLeafTag();

            if (name.equals(folderTag)) {
                final String id = evaluateNodeValue(child, treeLoader.getFolderIdMapping());
                final String title = evaluateNodeValue(child, treeLoader.getFolderTitleMapping());
                TreeNode treeNode = createNode(child, treeLoader, id, title, false);
                currentNode.appendChild(treeNode);
                load(treeLoader, treeNode, child.getChildNodes());
            } else if (name.equals(leafTag)) {
                final String id = evaluateNodeValue(child, treeLoader.getLeafIdMapping());
                final String title = evaluateNodeValue(child, treeLoader.getLeafTitleMapping());
                TreeNode treeNode = createNode(child, treeLoader, id, title, true);
                currentNode.appendChild(treeNode);
            }
        }
    }

    private static TreeNode createNode(Node child, XMLTreeLoader treeLoader, final String id, String title, final boolean isLeaf) {
        final String icon = evaluateNodeValue(child, treeLoader.getIconMapping());
        final String iconCls = evaluateNodeValue(child, treeLoader.getIconClsMapping());
        final String qtip = evaluateNodeValue(child, treeLoader.getQtipMapping());
        final String checked = evaluateNodeValue(child, treeLoader.getCheckedMapping());
        final String disabled = evaluateNodeValue(child, treeLoader.getDisabledMapping());
        final String allowDrag = evaluateNodeValue(child, treeLoader.getAllowDragMapping());
        final String allowDrop = evaluateNodeValue(child, treeLoader.getAllowDropMapping());
        final String expanded = evaluateNodeValue(child, treeLoader.getExpandedMapping());
        final String href = evaluateNodeValue(child, treeLoader.getHrefMapping());
        final String hrefTarget = evaluateNodeValue(child, treeLoader.getHrefTargetMapping());
                            
        TreeNode treeNode = new TreeNode(title) {
            {
                setId(id);
                setIcon(icon);
                setIconCls(iconCls);
                setTooltip(qtip);
                setDisabled(booleanValue(disabled));
                setAllowDrag(allowDrag == null || booleanValue(allowDrag));
                setAllowDrop(allowDrop == null || booleanValue(allowDrop));
                setExpanded(expanded == null || booleanValue(expanded));
                setHref(href);
                setHrefTarget(hrefTarget);
                setLeaf(isLeaf);
            }
        };
        if (checked != null) {
            treeNode.setChecked(booleanValue(checked));
        }

        String[] attributeMappings = treeLoader.getAttributeMappings();
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


    private String rootTag;
    private String folderTag = "node";
    private String leafTag = "leaf";
    private String folderTitleMapping = "@title";
    private String leafTitleMapping = "@title";
    private String folderIdMapping;
    private String leafIdMapping;

    private String iconMapping = "@icon";
    private String iconClsMapping = "@iconCls";
    private String qtipMapping = "@qtip";
    private String checkedMapping = "@checked";
    private String disabledMapping = "@disabled";
    private String expandedMapping = "@expanded";
    private String hrefMapping = "@href";
    private String hrefTargetMapping = "@hrefTarget";
    private String allowDragMapping = "@allowDrag";
    private String allowDropMapping = "@allowDrop";

    private String[] attributeMappings;

    /**
     * The root tag name in the XML data.
     *
     * @param rootTag the root tag name
     */
    public void setRootTag(String rootTag) {
        this.rootTag = rootTag;
    }

    /**
     * The folder tag name in the XML data.
     *
     * @param folderTag the folder tag name
     */
    public void setFolderTag(String folderTag) {
        this.folderTag = folderTag;
    }

    /**
     * The leaf tag name in the XML data.
     *
     * @param leafTag the leaf tag name
     */
    public void setLeafTag(String leafTag) {
        this.leafTag = leafTag;
    }

    /**
     * Mapping corresponding to the title of the folder relative to the folder tag.
     *
     * @param folderTitleMapping the folder title mapping
     */
    public void setFolderTitleMapping(String folderTitleMapping) {
        this.folderTitleMapping = folderTitleMapping;
    }

    /**
     * Mapping corresponding to the title of the leaf relative to the leaf tag.
     *
     * @param leafTitleMapping the leaf title mapping
     */
    public void setLeafTitleMapping(String leafTitleMapping) {
        this.leafTitleMapping = leafTitleMapping;
    }

    /**
     * Return the root tag name.
     *
     * @return the root tag
     */
    public String getRootTag() {
        return rootTag;
    }

    /**
     * Return the folder tag name.
     *
     * @return the folder tag
     */
    public String getFolderTag() {
        return folderTag;
    }

    /**
     * Return the leaf tag name.
     *
     * @return the leaf tag
     */
    public String getLeafTag() {
        return leafTag;
    }

    /**
     * Return the folder title mapping.
     *
     * @return folder title mapping
     */
    public String getFolderTitleMapping() {
        return folderTitleMapping;
    }

    /**
     * Return the leaf title mapping.
     *
     * @return the leaftitle mapping
     */
    public String getLeafTitleMapping() {
        return leafTitleMapping;
    }

    /**
     * Return the folder ID value mapping.
     *
     * @return the folder ID value mapping
     */
    public String getFolderIdMapping() {
        return folderIdMapping;
    }

    /**
     * Return the leaf ID value mapping.
     *
     * @return the leaf ID value mapping
     */
    public String getLeafIdMapping() {
        return leafIdMapping;
    }

    /**
     * Set the folder ID mapping relative to the folder tag.
     *
     * @param folderIdMapping the folder ID mapping
     */
    public void setFolderIdMapping(String folderIdMapping) {
        this.folderIdMapping = folderIdMapping;
    }

    /**
     * Set the leaf ID mapping relative to the leaf tag.
     *
     * @param leafIdMapping the leaf ID mapping
     */
    public void setLeafIdMapping(String leafIdMapping) {
        this.leafIdMapping = leafIdMapping;
    }

    /**
     * Return the icon mapping.
     *
     * @return the icon mapping
     */
    public String getIconMapping() {
        return iconMapping;
    }

    /**
     * Set the icon mapping.
     *
     * @param iconMapping the icon mapping
     */
    public void setIconMapping(String iconMapping) {
        this.iconMapping = iconMapping;
    }

    /**
     * Return the icon class mapping.
     *
     * @return the icon class mapping
     */
    public String getIconClsMapping() {
        return iconClsMapping;
    }

    /**
     * Set the icon class mapping.
     *
     * @param iconClsMapping the icon class mapping
     */
    public void setIconClsMapping(String iconClsMapping) {
        this.iconClsMapping = iconClsMapping;
    }

    /**
     * Return the quick tip value mapping.
     *
     * @return the quick tip mapping
     */
    public String getQtipMapping() {
        return qtipMapping;
    }

    /**
     * Set the quick tip value mapping.
     *
     * @param qtipMapping the quick tip mapping
     */
    public void setQtipMapping(String qtipMapping) {
        this.qtipMapping = qtipMapping;
    }

    /**
     * Return the checkbox state value mapping.
     *
     * @return the checked mapping
     */
    public String getCheckedMapping() {
        return checkedMapping;
    }

    /**
     * Set the checkbox state value mapping.
     *
     * @param checkedMapping the checked mapping
     */
    public void setCheckedMapping(String checkedMapping) {
        this.checkedMapping = checkedMapping;
    }

    /**
     * Return the mapping for the disabled state value.
     *
     * @return the disabled mapping
     */
    public String getDisabledMapping() {
        return disabledMapping;
    }

    /**
     * Set the mapping for the disabled state value.
     *
     * @param disabledMapping the disabled mapping
     */
    public void setDisabledMapping(String disabledMapping) {
        this.disabledMapping = disabledMapping;
    }

    /**
     * Return the mapping for the node's expanded state value.
     *
     * @return the expanded mapping
     */
    public String getExpandedMapping() {
        return expandedMapping;
    }

    /**
     * Set the mapping for the node's expanded state value.
     *
     * @param expandedMapping the expanded mapping
     */
    public void setExpandedMapping(String expandedMapping) {
        this.expandedMapping = expandedMapping;
    }

    /**
     * Return the node's href value mapping
     *
     * @return the href mapping
     */
    public String getHrefMapping() {
        return hrefMapping;
    }

    /**
     * Set the node's href value mapping.
     *
     * @param hrefMapping the href mapping
     */
    public void setHrefMapping(String hrefMapping) {
        this.hrefMapping = hrefMapping;
    }

    /**
     * Return the node's href target value mapping.
     *
     * @return the href target mapping
     */
    public String getHrefTargetMapping() {
        return hrefTargetMapping;
    }

    /**
     * Return the node's href target value mapping.
     *
     * @param hrefTargetMapping the href target mapping
     */
    public void setHrefTargetMapping(String hrefTargetMapping) {
        this.hrefTargetMapping = hrefTargetMapping;
    }

    /**
     * Return the node's "allow drag" mapping.
     *
     * @return the allow drag mapping
     */
    public String getAllowDragMapping() {
        return allowDragMapping;
    }

    /**
     * Set the node's "allow drag" mapping.
     *
     * @param allowDragMapping the allow drag mapping
     */
    public void setAllowDragMapping(String allowDragMapping) {
        this.allowDragMapping = allowDragMapping;
    }

    /**
     * Return the node's "allow drop" mapping.
     *
     * @return the allow drop mapping
     */
    public String getAllowDropMapping() {
        return allowDropMapping;
    }

    /**
     * Set the node's "allow drop" mapping.
     *
     * @param allowDropMapping the allow drop mapping
     */
    public void setAllowDropMapping(String allowDropMapping) {
        this.allowDropMapping = allowDropMapping;
    }

    /**
     * Return the node's attribute name(s) mapping.
     *
     * @return the attribute name mapping
     */
    public String[] getAttributeMappings() {
        return attributeMappings;
    }

    /**
     * Set the node's attribute name(s) mapping.
     *
     * @param attributeMappings attribute name mapping
     */
    public void setAttributeMappings(String[] attributeMappings) {
        this.attributeMappings = attributeMappings;
    }
}
