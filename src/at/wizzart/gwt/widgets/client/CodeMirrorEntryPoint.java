/**
 * 	@author Dominik Guzei
 *	Project: StyleKit - Qualifikationsprojekt 1
 *	Fachhochschule Salzburg
 *
 */

package at.wizzart.gwt.widgets.client;

import at.wizzart.gwt.widgets.client.event.logical.SaveEvent;
import at.wizzart.gwt.widgets.client.event.logical.SaveHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.InitializeEvent;
import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * This is the Test class for development of CodeMirror
 * @author dominikguzei
 *
 */

public class CodeMirrorEntryPoint implements EntryPoint {
	
	private CodeMirror editor;
	private CodeMirrorConfiguration config = new CodeMirrorConfiguration();
	
	// set up logging to catch exceptions in browser
	public void onModuleLoad() {

		config.setLineNumbers(true);
		config.setContinuousScanning(0);
		config.setTextWrapping(false);
		config.setAutoMatchParens(false);
		//config.setStyleSheetURL(GWT.getModuleBaseURL() + "/css/test.css");
		
		editor = new CodeMirror(config);
		editor.setHeight("100%");
		editor.setWidth("400px");
		
		editor.addInitializeHandler(new InitializeHandler() {
			public void onInitialize(InitializeEvent event) {
				editor.setParser(CodeMirror.PARSER_PHP_HTML_MIXED);
				editor.setLineNumbers(true);
				//editor.setTextWrapping(true);
				editor.setIndentUnit(2);
				//editor.setStylesheetURL(GWT.getModuleBaseURL() + "/css/test.css");
				editor.setFocus();
				//editor.setSelection("body { \nmargin: 0px; \n}");
				editor.reindent();
			}
		});
		
		editor.addSaveHandler(new SaveHandler() {

			public void onSave(SaveEvent event) {
				Window.alert("saved!");
			}
		});
		
		RootPanel.get().add(editor);
	
	}
}
