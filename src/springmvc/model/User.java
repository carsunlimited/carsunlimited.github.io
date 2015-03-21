package springmvc.model;

/**
 * This class defines the data to be stored in a user with provided
 * setter/getter methods that provide controlled access to the state of this
 * object
 * 
 * @author simongorial
 * 
 */
public class User {

	// Field that holds users id
	private int id;

	// Field that holds username of user
	private String userName;

	// Field that holds password of user
	private String password;

	// Field that holds first name of user
	private String firstName;

	// Field that holds last name of user
	private String lastName;

	/**
	 * Gets the users ID
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the users id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * gets the users username
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * sets the users username
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * gets the users password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets the users password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * gets the users firstname
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the users first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets the users last name
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the users last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * outputs the variable data each as a string
	 */
	public String toString() {
		return " Username: " + userName + " Password: " + password
				+ "First name: " + firstName + " Last name: " + lastName
				+ " ID: " + id;
	}
}
