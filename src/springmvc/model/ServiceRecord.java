package springmvc.model;

/**
 * This class defines the data to be stored in a service record with provided
 * setter/getter methods that provide controlled access to the state of this
 * object
 * 
 * @author simongorial
 * 
 */
public class ServiceRecord {

	// Field that holds the unique id of each record
	private int id;

	// Field that holds the vehicles make each record
	private String make;

	// Field that holds the vehicles model each record
	private String model;

	// Field that holds the vehicles cost each record
	private Double cost;

	// Field that holds the date for each record
	private String date;

	// Field that holds the vehicles description for each record
	private String description;

	// Field that holds boolean value true or false for satisfied
	private Boolean satisfied;

	// Field that holds for the user id
	private int userid;

	// Name of users who log in and displayed on page front
	private String firstName;
	private String lastName;

	/**
	 * Gets the service record id
	 * 
	 * @return service record id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the service record id
	 * 
	 * @param id
	 *            Sets the service record id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the service record make
	 * 
	 * @return service record make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the service record make
	 * 
	 * @param make
	 *            Sets the service record make
	 */
	public void setMake(String make) {
		this.make = make.toUpperCase();
	}

	/**
	 * Gets the service record model
	 * 
	 * @return service record model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the service record make
	 * 
	 * @param model
	 *            Sets the service record model
	 */
	public void setModel(String model) {
		this.model = model.toUpperCase();
	}

	/**
	 * Gets the service record cost
	 * 
	 * @return service record cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * Sets the service record cost
	 * 
	 * @param cost
	 *            Sets the service record cost
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the service record date
	 * 
	 * @return service record date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the service record date
	 * 
	 * @param simpleDateFormat
	 *            Sets the service record date
	 */
	public void setDate(String date) {

		this.date = date;
	}

	/**
	 * Gets the service record description
	 * 
	 * @return service record description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the service record description
	 * 
	 * @param description
	 *            Sets the service record description
	 */
	public void setDescription(String description) {
		this.description = description.toUpperCase();
	}

	/**
	 * Sets the service record satisfied
	 * 
	 * @param satisfied
	 *            Sets the service record satisfied
	 */
	public void setSatisfied(Boolean satisfied) {
		this.satisfied = satisfied;
	}

	/**
	 * Gets the service record satisfied
	 * 
	 * @return service record satisfied
	 */
	public Boolean getSatisfied() {
		return satisfied;
	}

	/**
	 * Gets the user id in session
	 * 
	 * @return user id
	 */
	public int getUserId() {
		return userid;
	}

	/**
	 * Sets the user id
	 * 
	 * @param userid
	 */
	public void setUserId(int userid) {
		this.userid = userid;
	}

	/**
	 * Gets the users first name
	 * 
	 * @return user id
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the users first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the users last name
	 * 
	 * @return user id
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the users last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returning all fields as strings using toString method
	 */
	public String toString() {
		return "ID: " + id + " Make: " + make + " Date: " + date
				+ " Description " + description + " Satisfied?: " + satisfied;
	}
}