package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class XMLTreeLoaderConfig extends TreeLoaderConfig {
	private String rootTag;
	private String folderTag = "node";
	private String leafTag = "leaf";
	private String folderTitleMapping = "@title";
	private String leafTitleMapping = "@title";
	private String folderIdMapping;
	private String leafIdMapping;

	private String folderIconMapping = "@icon";
	private String leafIconMapping = "@icon";

	private String folderIconClsMapping = "@iconCls";
	private String leafIconClsMapping = "@iconCls";

	private String folderQtipMapping = "@qtip";
	private String leafQtipMapping = "@qtip";

	public void setRootTag(String rootTag) {
		this.rootTag = rootTag;
	}

	public void setFolderTag(String folderTag) {
		this.folderTag = folderTag;
	}

	public void setLeafTag(String leafTag) {
		this.leafTag = leafTag;
	}

	public void setFolderTitleMapping(String folderTitleMapping) {
		this.folderTitleMapping = folderTitleMapping;
	}

	public void setLeafTitleMapping(String leafTitleMapping) {
		this.leafTitleMapping = leafTitleMapping;
	}

	public String getRootTag() {
		return rootTag;
	}

	public String getFolderTag() {
		return folderTag;
	}

	public String getLeafTag() {
		return leafTag;
	}

	public String getFolderTitleMapping() {
		return folderTitleMapping;
	}

	public String getLeafTitleMapping() {
		return leafTitleMapping;
	}

	public String getFolderIdMapping() {
		return folderIdMapping;
	}

	public String getLeafIdMapping() {
		return leafIdMapping;
	}

	public void setFolderIdMapping(String folderIdMapping) {
		this.folderIdMapping = folderIdMapping;
	}

	public void setLeafIdMapping(String leafIdMapping) {
		this.leafIdMapping = leafIdMapping;
	}

	public String getFolderIconMapping() {
		return folderIconMapping;
	}

	public void setFolderIconMapping(String folderIconMapping) {
		this.folderIconMapping = folderIconMapping;
	}

	public String getLeafIconMapping() {
		return leafIconMapping;
	}

	public void setLeafIconMapping(String leafIconMapping) {
		this.leafIconMapping = leafIconMapping;
	}

	public String getFolderIconClsMapping() {
		return folderIconClsMapping;
	}

	public void setFolderIconClsMapping(String folderIconClsMapping) {
		this.folderIconClsMapping = folderIconClsMapping;
	}

	public String getLeafIconClsMapping() {
		return leafIconClsMapping;
	}

	public void setLeafIconClsMapping(String leafIconClsMapping) {
		this.leafIconClsMapping = leafIconClsMapping;
	}

	public String getFolderQtipMapping() {
		return folderQtipMapping;
	}

	public void setFolderQtipMapping(String folderQtipMapping) {
		this.folderQtipMapping = folderQtipMapping;
	}

	public String getLeafQtipMapping() {
		return leafQtipMapping;
	}

	public void setLeafQtipMapping(String leafQtipMapping) {
		this.leafQtipMapping = leafQtipMapping;
	}
}
