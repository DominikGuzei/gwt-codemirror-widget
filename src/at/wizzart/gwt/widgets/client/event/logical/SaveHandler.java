

package at.wizzart.gwt.widgets.client.event.logical;

import com.google.gwt.event.shared.EventHandler;

/**
 * A simple interface to indicate that implementers handle
 * save events.
 * 
 * @author dominikguzei
 * @version 1.0
 */

public interface SaveHandler extends EventHandler {

	void onSave(SaveEvent event);
}
