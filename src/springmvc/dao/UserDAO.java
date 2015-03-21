package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import springmvc.model.User;

public class UserDAO {

	/**
	 * Injected from application context. JdbcTemplate obtains a database
	 * connection
	 */
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

	/** Constant string variables for DB column id's */
	private final static String ID = "id";
	private final static String USERNAME = "username";
	private final static String PASSWORD = "password";
	private final static String FIRSTNAME = "firstname";
	private final static String LASTNAME = "lastname";

	/**
	 * Injecting JdbcTemplate reference into bean ServiceRecordDAO via
	 * constructor injection. Setting jdbcTemplate.
	 * 
	 * @param jdbcTemplate
	 */
	public UserDAO(JdbcTemplate jdbcTemplate) {
		PropertyConfigurator.configure("log4j.properties");

		this.jdbcTemplate = jdbcTemplate;
	}

	public User getFirstLastName(int id) {

		// SQL to update and replace record data
		final String SQL = "select firstname, lastname from sql371355.user where id=" + id;


		// instansiate a new record to store queried record
		final User user = new User();

		//final ArrayList<User> userName = new ArrayList<User>();
		
		jdbcTemplate.query(SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {

				// setting all the fields using a ResultSet reference
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				
				//userName.add(user);
			}
		});

		return user;
	}
	
	/**
	 * getUser() is used to return a single user object which matches the id
	 * passed by value.
	 * 
	 * @param id
	 *            service record id
	 * @return single queried object
	 */
	public User getUser(User user) {

		// Console out user record data
		LOGGER.info("Fetching user record: " + user);
		
		// Query to select the user with matching login id
		final String SQL = "select * from user where id=" + user.getId();

		// instansiate a new record to store queried record
		final User newUser = new User();

		jdbcTemplate.query(SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {

				// setting all the fields using a ResultSet reference
				newUser.setId(new Integer(rs.getInt(ID)));
				newUser.setFirstName(rs.getString(FIRSTNAME));
				newUser.setLastName(rs.getString(LASTNAME));
				newUser.setUserName(rs.getString(USERNAME));
				newUser.setPassword(rs.getString(PASSWORD));

			}
		});

		LOGGER.info("Returning user instance with record data: " + user);

		return newUser;
	}
}