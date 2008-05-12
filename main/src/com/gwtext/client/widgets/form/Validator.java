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
 

package com.gwtext.client.widgets.form;

/**
 * Interface that must be implemented for custom Field validation logic.
 *
 * @author Sanjiv Jivan
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
