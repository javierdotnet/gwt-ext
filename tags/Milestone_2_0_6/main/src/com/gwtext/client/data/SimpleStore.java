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
 

package com.gwtext.client.data;

/**
 * Convenience class that creates a Store directly using field names and local array data. Usage :
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
 *                new Object[]{"xtheme-aero.css", "Aero Glass Theme"},
 *                new Object[]{"xtheme-gray.css", "Gray Theme"},
 *                new Object[]{"xtheme-vista.css", "Vista Dark Theme"}});
 * </code>
 * </pre>
 *
 * @author Sanjiv Jivan
 */
public class SimpleStore extends Store {

	/**
	 * Construct a single field SimpleStore.
	 *
	 * @param field a single field
	 * @param data  store data. all fields are treated as String's
	 */
	public SimpleStore(String field, Object[] data) {
		Object[][] dataArr = new Object[data.length][1];
		for (int i = 0; i < data.length; i++) {
			Object dataVal = data[i];
			dataArr[i][0] = dataVal;
		}
		MemoryProxy proxy = new MemoryProxy(dataArr);
		ArrayReader reader = new ArrayReader(new RecordDef(new FieldDef[]{
				new StringFieldDef(field)
		}));
		setDataProxy(proxy);
		setReader(reader);
	}


	public SimpleStore(String[] fields, Object[][] data) {
		this(-1, fields, data);
	}

	/**
	 * Construct a SimpleStore.
	 *
	 * @param id	 name of the ID field
	 * @param fields array of field names. All Fields are treated as Strings
	 * @param data   store data
	 */
	public SimpleStore(int id, String[] fields, Object[][] data) {

		MemoryProxy proxy = new MemoryProxy(data);

		FieldDef[] fieldDefs = new FieldDef[fields.length];
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			fieldDefs[i] = new StringFieldDef(field);
		}
		RecordDef recordDef = new RecordDef(fieldDefs);
		ArrayReader reader = null;
		if (id != -1) {
			reader = new ArrayReader(id, recordDef);
		} else {
			reader = new ArrayReader(recordDef);
		}

		setDataProxy(proxy);
		setReader(reader);
	}

	/**
	 * Construct a SimpleStore.
	 *
	 * @param id		name of the ID field
	 * @param fieldDefs the field definitions
	 * @param data	  store data
	 */
	public SimpleStore(int id, FieldDef[] fieldDefs, Object[][] data) {
		MemoryProxy proxy = new MemoryProxy(data);

		RecordDef recordDef = new RecordDef(fieldDefs);
		ArrayReader reader = null;
		if (id != -1) {
			reader = new ArrayReader(id, recordDef);
		} else {
			reader = new ArrayReader(recordDef);
		}
		setDataProxy(proxy);
		setReader(reader);
	}
}


