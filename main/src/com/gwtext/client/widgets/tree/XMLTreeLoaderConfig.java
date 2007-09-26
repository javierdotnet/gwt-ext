package com.gwtext.client.widgets.tree;

public class XMLTreeLoaderConfig extends TreeLoaderConfig {
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

    public String getIconMapping() {
        return iconMapping;
    }

    public void setIconMapping(String iconMapping) {
        this.iconMapping = iconMapping;
    }

    public String getIconClsMapping() {
        return iconClsMapping;
    }

    public void setIconClsMapping(String iconClsMapping) {
        this.iconClsMapping = iconClsMapping;
    }

    public String getQtipMapping() {
        return qtipMapping;
    }

    public void setQtipMapping(String qtipMapping) {
        this.qtipMapping = qtipMapping;
    }

    public String getCheckedMapping() {
        return checkedMapping;
    }

    public void setCheckedMapping(String checkedMapping) {
        this.checkedMapping = checkedMapping;
    }

    public String getDisabledMapping() {
        return disabledMapping;
    }

    public void setDisabledMapping(String disabledMapping) {
        this.disabledMapping = disabledMapping;
    }

    public String getExpandedMapping() {
        return expandedMapping;
    }

    public void setExpandedMapping(String expandedMapping) {
        this.expandedMapping = expandedMapping;
    }

    public String getHrefMapping() {
        return hrefMapping;
    }

    public void setHrefMapping(String hrefMapping) {
        this.hrefMapping = hrefMapping;
    }

    public String getHrefTargetMapping() {
        return hrefTargetMapping;
    }

    public void setHrefTargetMapping(String hrefTargetMapping) {
        this.hrefTargetMapping = hrefTargetMapping;
    }

    public String getAllowDragMapping() {
        return allowDragMapping;
    }

    public void setAllowDragMapping(String allowDragMapping) {
        this.allowDragMapping = allowDragMapping;
    }

    public String getAllowDropMapping() {
        return allowDropMapping;
    }

    public void setAllowDropMapping(String allowDropMapping) {
        this.allowDropMapping = allowDropMapping;
    }

    public String[] getAttributeMappings() {
        return attributeMappings;
    }

    public void setAttributeMappings(String[] attributeMappings) {
        this.attributeMappings = attributeMappings;
    }
}
