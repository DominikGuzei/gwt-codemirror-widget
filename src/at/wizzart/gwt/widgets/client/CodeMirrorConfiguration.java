/**
 * 	@author Dominik Guzei
 *	Project: StyleKit - Qualifikationsprojekt 1
 *	Fachhochschule Salzburg
 *
 */

package at.wizzart.gwt.widgets.client;

/**
 * 	CodeMirrorConfiguration
 * 	@author dominikguzei
 *	@version 1.0
 *
 *	This is a simple configuration class for the CodeMirror editor
 *	It enables you to define default parameters that should be used
 *	by multiple instances and to provide this information on init
 *	For a complete reference of the settings please go to:
 *	http://marijn.haverbeke.nl/codemirror/manual.html
 */

public class CodeMirrorConfiguration {
	
	/**
	 *  set the amount of milliseconds between colouring passes
	 */
	private int passDelay = 200;
	
	/** 
	 * Specifies the maximum amount of time that the highlighter will
	 * spend in one shot. Setting this too high will cause the editor 
	 * to 'freeze' the browser for noticeable intervals. 
	 * Defaults to 50. 
	 */
	private int passTime = 50;
	
	/**
	 * Configure continuous scanning of the document. When false, 
	 * scanning is disabled.
	 * 
	 * <p>When set to a number, say N, a 'background' process will 
	 * scan the document for passTime (see above) milliseconds every N 
	 * milliseconds, regardless of whether anything changed. 
	 * This makes sure non-local changes propagate through the document, 
	 * and will help keep everything consistent. It does add extra processing
	 * cost, even for an idle editor. Default value is false.</p>
	 */
	private int continuousScanning = 0;
	
	/**
	 *  switch line numbers on or off
	 */
	private boolean lineNumbers = false;
	
	/**
	 *  the delay for refreshing line numbers
	 */
	private int lineNumberDelay = 500;
	
	/**
	 *  the max time taken for each line number calculation
	 */
	private int lineNumberTime = 30;
	
	/**
	 * define the content of the editor
	 */
	private String content = "";
	
	private int undoDepth = 50;
	
	private int undoDelay = 800;
	
	private boolean disableSpellcheck = true;
	
	private boolean textWrapping = true;
	
	private boolean readOnly = false;
	
	private boolean autoMatchParens = false;
	
	private String tabMode = "indent";
	
	private boolean reindentOnLoad = false;
	
	private int indentUnit = 2;
	
	private String styleSheetURL = "";
		

	public void setPassDelay(int passDelay) {
		this.passDelay = passDelay;
	}
	
	public int getPassDelay() {
		return passDelay;
	}

	public void setPassTime(int passTime) {
		this.passTime = passTime;
	}

	public int getPassTime() {
		return passTime;
	}
	
	/** 
	 * Configure continuous scanning of the document. When false, scanning is disabled. 
	 * When set to a number, say N, a 'background' process will scan the document for 
	 * passTime (see above) milliseconds every N milliseconds, regardless of whether anything changed. 
	 * This makes sure non-local changes propagate through the document, and will help keep everything consistent. 
	 * It does add extra processing cost, even for an idle editor. Default value is false.
	 */
	public void setContinuousScanning(int continuousScanning) {
		this.continuousScanning = continuousScanning;
	}

	public int getContinuousScanning() {
		return continuousScanning;
	}

	public void setLineNumbers(boolean lineNumbers) {
		this.lineNumbers = lineNumbers;
	}

	public boolean isLineNumbers() {
		return lineNumbers;
	}

	public void setLineNumberDelay(int lineNumberDelay) {
		this.lineNumberDelay = lineNumberDelay;
	}

	public int getLineNumberDelay() {
		return lineNumberDelay;
	}

	public void setLineNumberTime(int lineNumberTime) {
		this.lineNumberTime = lineNumberTime;
	}

	public int getLineNumberTime() {
		return lineNumberTime;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setUndoDepth(int undoDepth) {
		this.undoDepth = undoDepth;
	}

	public int getUndoDepth() {
		return undoDepth;
	}

	public void setUndoDelay(int undoDelay) {
		this.undoDelay = undoDelay;
	}

	public int getUndoDelay() {
		return undoDelay;
	}

	public void setDisableSpellcheck(boolean disableSpellcheck) {
		this.disableSpellcheck = disableSpellcheck;
	}

	public boolean isDisableSpellcheck() {
		return disableSpellcheck;
	}

	public void setTextWrapping(boolean textWrapping) {
		this.textWrapping = textWrapping;
	}

	public boolean isTextWrapping() {
		return textWrapping;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setAutoMatchParens(boolean autoMatchParens) {
		this.autoMatchParens = autoMatchParens;
	}

	public boolean isAutoMatchParens() {
		return autoMatchParens;
	}

	public void setTabMode(String tabMode) {
		this.tabMode = tabMode;
	}

	public String getTabMode() {
		return tabMode;
	}

	public void setReindentOnLoad(boolean reindentOnLoad) {
		this.reindentOnLoad = reindentOnLoad;
	}

	public boolean isReindentOnLoad() {
		return reindentOnLoad;
	}

	public void setIndentUnit(int indentUnit) {
		this.indentUnit = indentUnit;
	}

	public int getIndentUnit() {
		return indentUnit;
	}

	public void setStyleSheetURL(String styleSheetURL) {
		this.styleSheetURL = styleSheetURL;
	}

	public String getStyleSheetURL() {
		return styleSheetURL;
	}
}
