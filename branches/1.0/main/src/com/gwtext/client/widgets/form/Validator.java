/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.form;

/**
 * Interface that must be implemented for custom Field validation logic.
 *
 * @see com.gwtext.client.widgets.form.TextFieldConfig#setValidator(Validator)
 */
public interface Validator {

    /**
     *
     * Return true if Field value is valid and false if invalid. The value set in {@link FieldConfig#setInvalidText(String)}
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
