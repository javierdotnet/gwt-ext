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
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.HTMLPanel;

/**
 * This class creates a Syntax Highlight panel for different
 * languages, XML, and HTML for displaying.  This class
 * uses the syntaxhighlighter library found at:
 * http://code.google.com/p/syntaxhighlighter/
 * 
 * @author Mario Lim
 *
 */
public class SyntaxHighlightPanel extends HTMLPanel {
	public static final String SYNTAX_CPP = "cpp";
	public static final String SYNTAX_CSHARP = "csharp";
	public static final String SYNTAX_CSS = "css";
	public static final String SYNTAX_PASCAL = "pascal";
	public static final String SYNTAX_DELPHI = "pascal";
	public static final String SYNTAX_JAVA = "java";
	public static final String SYNTAX_JAVASCRIPT = "javascript";
	public static final String SYNTAX_PHP = "php";
	public static final String SYNTAX_PYTHON = "python";
	public static final String SYNTAX_RUBY = "ruby";
	public static final String SYNTAX_SQL = "sql";
	public static final String SYNTAX_VB = "vb";
	public static final String SYNTAX_XML = "xml";
	public static final String SYNTAX_HTML = "html";
	
	private String name = "sh_" + Ext.generateId(); 
	private String html = null;
	private String syntaxType = SYNTAX_XML;
	
	private boolean showGutter = true;
	private boolean showControls = true;
	private boolean collapseAll = false;
	private int firstLine = 1;
	private boolean showColumns = true;
	
	
    /**
     * Create a new SyntaxHighlightPanel.
     */
    public SyntaxHighlightPanel() {
        setBorder(true);
    }

    /**
     * Create a new SyntaxHighlightPanel.
     *
     * @param code the code to show in the panel
     * @param syntaxType is one of the available types:
     * <ul>
     *   <li>SyntaxHighlightPanel.SYNTAX_CPP</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_CSHARP</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_CSS</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_PASCAL</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_DELPHI</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_JAVA</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_JAVASCRIPT</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_PHP</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_PYTHON</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_RUBY</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_SQL</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_VB</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_XML</li>
     *   <li>SyntaxHighlightPanel.SYNTAX_HTML</li>
     * </ul>
     */
    public SyntaxHighlightPanel(String code, String syntaxType) {
        setBorder(true);
        setHtml(code);
        this.syntaxType = syntaxType;
    }

    /**
     * sets the code to the SyntaxHighlightPanel.  This is the code
     * that will be displayed in the panel
     * @param code is the code to display in the panel
     */
    public void setHtml(String code){
    	this.html = code;
    	
		addListener("render", new Function(){
			public void execute() {
				setSuperHtml(setSyntaxHighlight());
				DeferredCommand.addCommand(new Command(){
					public void execute() {
						executeSh(name, showGutter, showControls, collapseAll, firstLine, showColumns);
					}
				});
			}
		});
    }
    
    /**
     * used internally to call the super method for setHtml...
     * @param html the html to set for the panel
     */
    private void setSuperHtml(String html){
    	super.setHtml(html);
    }
    
    /**
     * This method is called internally to set the html to use
     * the textarea with a specific name and classname for
     * the library to use its specific css
     * @return the String that will be used for the setHtml.
     */
    protected String  setSyntaxHighlight(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<textarea name=\"");
		buffer.append(name);
		buffer.append("\" class=\"");
		buffer.append(syntaxType);
		buffer.append("\">");
		buffer.append(html);
		buffer.append("</textarea>");
	
		return buffer.toString();
    }
    
    /**
     * Private method that is called to apply the highlight for the textarea
     * @param name the name generated for this highlight
     * @param showGutter if it should show gutter
     * @param showControls if it should show the controls at the top
     * @param collapseAll if it should collapse the code
     * @param firstLine the first line to show
     * @param showColumns if it should show the column numbers
     */
	private native void executeSh(String name, boolean showGutter, boolean showControls,
			boolean collapseAll, int firstLine, boolean showColumns) /*-{
		$wnd.dp.SyntaxHighlighter.ClipboardSwf = 'js/sh/clipboard.swf';
		$wnd.dp.SyntaxHighlighter.HighlightAll(name, showGutter, 
							showControls, collapseAll, firstLine, showColumns);
	}-*/;
	
    protected JavaScriptObject create(JavaScriptObject config){
    	super.setHtml(setSyntaxHighlight());
    	return createJ(config);
    }
    
    protected JavaScriptObject createJ(JavaScriptObject config){
    	return super.create(config);
    }

    /**
     * Method to show gutter
     * @param showGutter true or false to show gutter
     */
    public void setShowGutter(boolean showGutter){
    	this.showGutter = showGutter;
    }
    
    /**
     * Method to show controls
     * @param showControls true or false to show controls
     */
    public void setShowControls(boolean showControls){
    	this.showControls = showControls;
    }
    
    /**
     * Method to collapse the code
     * @param collapseAll true or false to collapse or not the code
     */
    public void setCollapseAll(boolean collapseAll){
    	this.collapseAll = collapseAll;
    }
    
    /**
     * Method to set what line to start showing
     * @param firstLine integer of the line to show first
     */
    public void setFirstLine(int firstLine){
    	this.firstLine = firstLine;
    }
    
    /**
     * Method to show columns
     * @param showColumns true or false to show columns or not
     */
    public void setShowColumns(boolean showColumns){
    	this.showColumns = showColumns;
    }
}
