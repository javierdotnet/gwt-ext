/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

/**
 * Interface that must be implemented for custom Field validation logic.
 *
 * @see com.gwtext.client.widgets.form.TextField#setValidator(Validator)
 */
public interface Validator {
    /**
     * Return true if Field value is valid and false if invalid. The value set in {@link Field#setInvalidText(String)}
     * will be used as the error message. For a custom error message throw a ValidationException with the
     * error message. The error message of the ValidationException will be dispalyed.
     *
     *
     * @param value the field value to test
     * @return true if valid, false if invalid.
     * @throws ValidationException when validate fails
     */
    boolean validate(String value) throws ValidationException;
}
