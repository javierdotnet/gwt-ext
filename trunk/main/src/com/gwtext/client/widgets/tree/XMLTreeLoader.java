package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.*;
import com.google.gwt.xml.client.*;

public class XMLTreeLoader extends TreeLoader {

	static {
		init();
	}

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

			processResponse : function(response, node, callback){
				try {
				  for(var i = 0; i < response.length; i++){
						var n = this.createNode(response[i]);
						if(n){
							node.appendChild(n);
						}
					}
					if(typeof callback == "function"){
						callback(this, node);
					}
				}catch(e){
					this.handleFailure(response);
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
				final String icon = evaluateNodeValue(child, config.getFolderIconMapping());
				final String iconCls = evaluateNodeValue(child, config.getFolderIconClsMapping());
				final String qtip = evaluateNodeValue(child, config.getFolderQtipMapping());

				TreeNode treeNode = new TreeNode(title, new TreeNodeConfig() {
					{
						setId(id);
						setIcon(icon);
						setIconCls(iconCls);
						setQtip(qtip);
					}
				});
				currentNode.appendChild(treeNode);
				load(config, treeNode, child.getChildNodes());
			} else if (name.equals(leafTag)) {
				final String id = evaluateNodeValue(child, config.getLeafIdMapping());
				final String title = evaluateNodeValue(child, config.getLeafTitleMapping());
				final String icon = evaluateNodeValue(child, config.getLeafIconMapping());
				final String iconCls = evaluateNodeValue(child, config.getLeafIconClsMapping());
				final String qtip = evaluateNodeValue(child, config.getLeafQtipMapping());

				TreeNode treeNode = new TreeNode(title, new TreeNodeConfig() {
					{
						setId(id);
						setIcon(icon);
						setIconCls(iconCls);
						setQtip(qtip);
					}
				});
				currentNode.appendChild(treeNode);
			}
		}
	}

	public static String evaluateNodeValue(Node node, String mapping) {
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
