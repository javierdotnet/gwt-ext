package com.gwtext.client.widgets.grid;

public class CheckboxColumnConfig extends BaseColumnConfig {

    public CheckboxColumnConfig(CheckboxSelectionModel checkboxSelectionModel) {
        jsObj = checkboxSelectionModel.getJsObj();
    }

}
