package com.gwtext.client.widgets.tree;

/**
 * Configuration class for {@lik com.gwtext.client.widgets.tree.XMLTreeLoader}.
 */
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
     * @param  allowDragMapping the allow drag mapping
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
     * @param  allowDropMapping the allow drop mapping
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
