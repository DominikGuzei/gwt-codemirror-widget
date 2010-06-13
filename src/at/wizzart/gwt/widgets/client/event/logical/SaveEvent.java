/**
 * 	@author Dominik Guzei
 *	Project: StyleKit - Qualifikationsprojekt 1
 *	Fachhochschule Salzburg
 *
 */

package at.wizzart.gwt.widgets.client.event.logical;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A simple event class that holds a reference to the 
 * instance that fired the save event.
 * 
 * @author dominikguzei
 * @version 1.0
 */

public class SaveEvent extends GwtEvent<SaveHandler> {
	/**
	   * The event type.
	   */
	  private static Type<SaveHandler> TYPE;

	  /**
	   * Fires a save event on all registered handlers in the handler source.
	   * 
	   * @param <S> The handler source
	   * @param source the source of the handlers
	   */
	  public static <S extends HasSaveHandlers & HasHandlers> void fire(
	      S source) {
	    if (TYPE != null) {
	      SaveEvent event = new SaveEvent();
	      source.fireEvent(event);
	    }
	  }

	  /**
	   * Ensures the existence of the handler hook and then returns it.
	   * 
	   * @return returns a handler hook
	   */
	  public static Type<SaveHandler> getType() {
	    if (TYPE == null) {
	      TYPE = new Type<SaveHandler>();
	    }
	    return TYPE;
	  }

	  /**
	   * Construct a new {@link SaveEvent}.
	   * 
	   */
	  protected SaveEvent() {
	  }

	  public final Type<SaveHandler> getAssociatedType() {
	    return TYPE;
	  }

	  protected void dispatch(SaveHandler handler) {
	    handler.onSave(this);
	  }
}
