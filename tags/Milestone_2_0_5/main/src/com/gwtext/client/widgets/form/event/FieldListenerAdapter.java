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
 

package com.gwtext.client.widgets.form.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.event.BoxComponentListenerAdapter;

public class FieldListenerAdapter extends BoxComponentListenerAdapter implements FieldListener {

    public void onBlur(Field field) {
    }

    //make old API final so that it results in compile errors when users' previous code overrides this instead of
    //silently failing. Uses should now use onChange(Field field, Object newVal, Object oldVal)
    public final void onChange(Field field, String newVal, String oldVal) {
    }

    public void onChange(Field field, Object newVal, Object oldVal) {
    }

    public void onFocus(Field field) {
    }

    public void onInvalid(Field field, String msg) {
    }

    public void onSpecialKey(Field field, EventObject e) {
    }

    public void onValid(Field field) {
    }
}
