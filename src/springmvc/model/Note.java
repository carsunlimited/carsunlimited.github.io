package springmvc.model;

/**
 * This class defines the data to be stored in a note object with provided
 * setter/getter methods that provide controlled access to the state of this
 * object
 * 
 * @author simongorial
 * 
 */
public class Note {

	// Field that holds the unique id of each note
	private int id;

	// Field that holds the actual note text
	private String text;

	// Field that holds the id from the service record
	private int serviceId;

	/**
	 * Gets the id from ServiceRecord
	 * 
	 * @return service record id
	 */
	public int getServiceId() {
		return serviceId;
	}

	/**
	 * Sets the service record id
	 * 
	 * @param serviceId
	 *            integer id number
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * Gets the id from Note
	 * 
	 * @return note id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the note object id
	 * 
	 * @param id
	 *            integer id number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the text data for each note
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text data for note
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Returning all fields as strings using toString method
	 */
	public String toString() {
		return "Note: " + text;
	}
}
