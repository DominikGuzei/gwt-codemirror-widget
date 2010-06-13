/**
 * 	@author Dominik Guzei
 *	Project: StyleKit - Qualifikationsprojekt 1
 *	Fachhochschule Salzburg
 *
 */

package at.wizzart.gwt.widgets.client.event.logical;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A simple interface to indicate that implementers fire 
 * save events at specific moments of their lifecycle
 * 
 * @author dominikguzei
 * @version 1.0
 */

public interface HasSaveHandlers extends HasHandlers {

	HandlerRegistration addSaveHandler(SaveHandler handler);
}
