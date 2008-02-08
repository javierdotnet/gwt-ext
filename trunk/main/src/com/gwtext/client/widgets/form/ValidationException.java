/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

/**
 * Exception to raise when field validaiton fails.
 *
 * @see Validator#validate(String)
 */
public class ValidationException extends Exception {

    /**
     * Create new ValidationException.
     *
     * @param message the field validation error message
     */
    public ValidationException(String message) {
        super(message);
    }
}
