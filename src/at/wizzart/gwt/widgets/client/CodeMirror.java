/**
 * 	@author Dominik Guzei
 *	Project: StyleKit - Qualifikationsprojekt 1
 *	Fachhochschule Salzburg
 *
 */

package at.wizzart.gwt.widgets.client;

import at.wizzart.gwt.widgets.client.event.logical.HasSaveHandlers;
import at.wizzart.gwt.widgets.client.event.logical.SaveEvent;
import at.wizzart.gwt.widgets.client.event.logical.SaveHandler;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.HasInitializeHandlers;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

/**
 * 	@author Dominik Guzei
 *	@version 1.0
 *	
 *	CodeMirror
 *	This is a GWT wrapper class around the open source javascript 
 *	editor code mirror by Marijn Haverbeke 
 *	url: http://marijn.haverbeke.nl/codemirror/
 *
 *	This class can be used for source code editing in any browser
 *	and supports highlighting for various script and 
 *	markup languages like javascript, xml and html.
 *	It is implemented as GWT widget to simplify the use in your
 *	own GWT widget frameworks. Currently it does not provide
 *	complete functionality of code mirror, this will be added
 *	in future releases.
 *
 */

public class CodeMirror extends Widget 
implements HasChangeHandlers, HasValue<String>, HasInitializeHandlers, HasSaveHandlers {
	
	public final static String PARSER_CSS = "CSSParser";
	public final static String PARSER_JAVASCRPIPT = "JSParser";
	public final static String PARSER_PHP = "PHPParser";
	public final static String PARSER_XML = "XMLParser";
	public final static String PARSER_SQL = "SqlParser";
	public final static String PARSER_HTML_MIXED = "HTMLMixedParser";
	public final static String PARSER_PHP_HTML_MIXED = "PHPHTMLMixedParser";
	
	public final static String STYLESHEET_STANDARD_URL = GWT.getModuleBaseURL() + "css/" + "all-min.css";
	
	private Element hostElement; // the host element that holds our editor instance
	private static int nextId = 0; // a static counter for editor instances
	private String id; // the id of this instance
	private JavaScriptObject editor; // a native object reference to the editor
	private CodeMirrorConfiguration config; // the used configuration for this instance
	private String jsDir = GWT.getModuleBaseURL() + "js/"; // the path to js files in this module
	private String cssDir = GWT.getModuleBaseURL() + "css/"; // the path to css files in this module
	private boolean valueChangeHandlerInitialized; // 
	
	/**
	 * Sole constructor
	 * Calls the real constructor with a standard
	 * configuration object.
	 */
	public CodeMirror() {
		this(new CodeMirrorConfiguration());
	}
	
	/**
	 * Constructor with given configuration object
	 * sets up the host element and html markup used
	 * to integrate the editor in the widget framework.
	 * Does not initialize the code mirror editor, this
	 * is done in the widget's onLoad() function.
	 * 
	 * @param config - the initial configuration
	 */
	public CodeMirror(CodeMirrorConfiguration config) {
		super();
		id = "codemirror-editor-"+(++nextId);
		hostElement = DOM.createDiv();
		DOM.setElementProperty(hostElement, "id", id);
		setElement(hostElement);
		setStyleName("gwt-CodeMirror");
		this.config = config;
	}
	
	/**
	 * overrides widget's onLoad function and gets called
	 * when the widget is added to the DOM. This is the
	 * time the code mirror editor gets initialized and
	 * can be used. You can register an initialization handler
	 * which gets informed when the editor is scriptable.
	 */
	public void onLoad() {
		super.onLoad();
		editor = initEditor (id, config);
	}
	
	/**
	 * initializes the code mirror instance with given 
	 * configuration and plugs it into our host element. 
	 * @param id - the unique instance id
	 * @param conf - the code mirror configuration
	 * @return JavaScriptObject editor - the created code mirror instance
	 */
	private native JavaScriptObject initEditor (String id, CodeMirrorConfiguration conf) /*-{
		
		var passDelay = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getPassDelay()();
		var passTime = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getPassTime()();
		var continuousScanning = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getContinuousScanning()();
		if(continuousScanning == 0) { continuousScanning = false; }
		var lineNumbers = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isLineNumbers()();
		var lineNumberDelay = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getLineNumberDelay()();
		var lineNumberTime = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getLineNumberTime()();
		var undoDepth = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getUndoDepth()();
		var undoDelay = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getUndoDelay()();
		var disableSpellcheck = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isDisableSpellcheck()();
		var textWrapping = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isTextWrapping()();
		var readOnly = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isReadOnly()();
		var autoMatchParens = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isAutoMatchParens()();
		var tabMode = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getTabMode()();
		var reindentOnLoad = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::isReindentOnLoad()();
		var indentUnit = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getIndentUnit()();
		var styleSheetURL = conf.@at.wizzart.gwt.widgets.client.CodeMirrorConfiguration::getStyleSheetURL()();
		if(styleSheetURL == "") {
			styleSheetURL = @at.wizzart.gwt.widgets.client.CodeMirror::STYLESHEET_STANDARD_URL;
		}
		var self = this;
		
		//init a new editor with standard properties
		editor = new $wnd.CodeMirror($doc.getElementById(id), {
		 	basefiles: ["basefiles-min.js"],
		 	parserfile: ["parsers-min.js"],
		 	width: "100%",
		 	height: "100%",
		 	path: this.@at.wizzart.gwt.widgets.client.CodeMirror::jsDir,
		 	stylesheet: styleSheetURL,
		 	passDelay: passDelay,
		 	passTime: passTime,
		 	continuousScanning: continuousScanning,
		 	lineNumbers: lineNumbers,
		 	lineNumberDelay: lineNumberDelay,
		 	iframeClass: null,
		    saveFunction: function() { self.@at.wizzart.gwt.widgets.client.CodeMirror::onSave()(); },
		    onChange: function() { self.@at.wizzart.gwt.widgets.client.CodeMirror::onChange()(); },
		    undoDepth: undoDepth,
		    undoDelay: undoDelay,
		    disableSpellcheck: disableSpellcheck,
		    textWrapping: textWrapping,
		    readOnly: readOnly,
		    autoMatchParens: autoMatchParens,
		    tabMode: tabMode,
		    reindentOnLoad: reindentOnLoad,
		    indentUnit: indentUnit,
		    initCallback: function() { self.@at.wizzart.gwt.widgets.client.CodeMirror::editorLoaded()(); }
		 });

		return editor;
	 
	}-*/;
	
	/**
	 * Get the complete content of this code mirror instance
	 * @return content
	 */
	public native String getContent() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		return editor.getCode();
	}-*/;
	
	/**
	 * Replace the complete content of this editor instance
	 * @param content 
	 */
	public native void setContent(String content) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setCode(content);
	}-*/;
	
	/**
	 * Set the used parser - use one of the static class values here
	 * @param parser
	 */
	public native void setParser(String parser) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setParser(parser);
	}-*/;
	
	/**
	 * Enable (true) or disable (false) line numbers in the editor
	 * @param flag
	 */
	public native void setLineNumbers(boolean flag) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setLineNumbers(flag);
	}-*/;
	
	/**
	 * Enable or disable text-wrapping. If set to true the text in the
	 * editor will be wrapped if there are too many characters in one line.
	 * @param flag
	 */
	public native void setTextWrapping(boolean flag) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setTextWrapping(flag);
	}-*/;
	
	/**
	 * Specify the amount of [spaces] used as indention
	 * @param indention
	 */
	public native void setIndentUnit(int indention) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setIndentUnit(indention);
	}-*/;
	
	/**
	 * Provide a path to your own css file to specify the
	 * syntax highlighting features for the various languages.
	 * @param url
	 */
	public native void setStylesheetURL(String url) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.setStylesheet(url);
	}-*/;
	
	/**
	 * Give focus to the editor
	 */
	public native void setFocus() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.focus();
	}-*/;
	
	/**
	 * Get the text that the user currently selected
	 * @return selected text
	 */
	public native String getSelection() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		return editor.selection();
	}-*/;
	
	/**
	 * Replace the current selection with any text
	 * @param text
	 */
	public native void setSelection(String text) /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.replaceSelection(text);
	}-*/;
	
	/**
	 * Reindent the whole content in the editor
	 */
	public native void reindent() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.reindent();
	}-*/;
	
	/**
	 * Reindent only the selected text
	 */
	public native void reindentSelection() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.reindentSelection();
	}-*/;
	
	/**
	 * Undo the last action by the user
	 */
	public native void undo() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.undo();
	}-*/;
	
	/**
	 * Redo the last undone action by the user
	 */
	public native void redo() /*-{
		var editor = this.@at.wizzart.gwt.widgets.client.CodeMirror::editor;
		editor.redo();
	}-*/;
	
	// TODO: implement getSearchCursor - document searching
	// TODO: implement undo history manipulation
	// TODO: implement line handling
	
	/**
	 * Callback function for the code mirror instance
	 * that gets called when the editor is loaded and ready.
	 * Fires an Initialize Event which indicates that the editor
	 * can be used.
	 */
	private void editorLoaded() {
		InitializeEvent.fire(this);
	}
	
	/**
	 * Callback function for the code mirror instance
	 * that gets called when the user edits the content
	 * Fires an ValueChangeEvent with the new content
	 */
	private void onChange() {
		ValueChangeEvent.fire(this, getContent());
	}
	
	/**
	 * Callback function for the code mirror instance
	 * that gets called when the user presses CMD/STRG + s
	 * Fires an SaveEvent that can be handled by the app
	 */
	private void onSave() {
		SaveEvent.fire(this);
	}
	
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
	}
	
	public HandlerRegistration addValueChangeHandler(
		      ValueChangeHandler<String> handler) {
		    // Initialization code
		    if (!valueChangeHandlerInitialized) {
		      valueChangeHandlerInitialized = true;
		      addChangeHandler(new ChangeHandler() {
		        public void onChange(ChangeEvent event) {
		          ValueChangeEvent.fire(CodeMirror.this, getValue());
		        }
		      });
		    }
		    return addHandler(handler, ValueChangeEvent.getType());
		  }

	public String getValue() {
		return getContent();
	}

	public void setValue(String value) {
		setContent(value);
	}

	public void setValue(String value, boolean fireEvents) {
		String oldValue = getContent();
	    setContent(value);
	    if (fireEvents) {
	      ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
	    }
	}

	public HandlerRegistration addInitializeHandler(InitializeHandler handler) {
		return addHandler(handler, InitializeEvent.getType());
	}

	public HandlerRegistration addSaveHandler(SaveHandler handler) {
		return addHandler(handler, SaveEvent.getType());
	}
	
}
