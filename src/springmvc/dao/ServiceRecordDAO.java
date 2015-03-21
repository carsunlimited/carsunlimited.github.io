package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import springmvc.model.ServiceRecord;
import springmvc.model.User;
import springmvc.util.DateUtils;

/**
 * This class is responsible for handling all the add/delete/update/get records
 * to and from a mysql database.
 * 
 * @author simongorial
 * 
 */
public class ServiceRecordDAO {

	/**
	 * Injected from application context. JdbcTemplate obtains a database
	 * connection
	 */
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = Logger
			.getLogger(ServiceRecordDAO.class);

	// Constant string variables for DB column id's
	private final static String ID = "ID";
	private final static String MAKE = "MAKE";
	private final static String MODEL = "MODEL";
	private final static String COST = "COST";
	private final static String DATE = "DATE";
	private final static String DESCRIPTION = "DESCRIPTION";
	private final static String SATISFIED = "SATISFIED";
	private final static String USERID = "userid";

	/**
	 * default constructor
	 */
	public ServiceRecordDAO() {
	}

	/**
	 * Injecting JdbcTemplate reference into bean ServiceRecordDAO via
	 * constructor injection. Setting jdbcTemplate.
	 * 
	 * @param jdbcTemplate
	 */
	public ServiceRecordDAO(JdbcTemplate jdbcTemplate) {
		PropertyConfigurator.configure("log4j.properties");

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * addRecord adds a record of data (row) to table 'ServiceRecord' in mysql
	 * database
	 * 
	 * @param record
	 * @return
	 */
	public int addRecord(ServiceRecord record) {
		LOGGER.info("Adding record with values " + record);

		// SQL to insert record data (e.g. id, make, date)
		final String SQL = "Insert Into sql371355.servicerecord("
				+ ID + ", " + MAKE + ", " + MODEL + ", " + COST + ", " + DATE
				+ ", " + DESCRIPTION + ", " + SATISFIED + " ," + USERID
				+ ") values (?,?,?,?,?,?,?,?)";

		// Set parameters and JDBC types
		Object[] params = new Object[] { record.getId(), record.getMake(),
				record.getModel(), record.getCost(),
				DateUtils.parseDate(record.getDate()), record.getDescription(),
				record.getSatisfied(), record.getUserId() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.DOUBLE, Types.DATE, Types.VARCHAR, Types.BOOLEAN,
				Types.INTEGER };

		return jdbcTemplate.update(SQL, params, types);
	}

	/**
	 * deleteRecord removes a record of data (row) from table 'ServiceRecord' in
	 * mysql database
	 * 
	 * @param id
	 * @return
	 */
	public int deleteRecord(int id) {

		LOGGER.info("Deleting record with " + ID + " = " + id);

		// SQL to delete record
		final String SQL = "delete from sql371355.servicerecord where "
				+ ID + "=?";

		// Set parameters and JDBC types
		Object[] params = new Object[] { id };
		int[] types = new int[] { Types.INTEGER };

		return jdbcTemplate.update(SQL, params, types);
	}

	/**
	 * editRecord edit a record of data (row) from table 'ServiceRecord' in
	 * mysql database
	 * 
	 * @param record
	 * @return
	 */
	public int editRecord(ServiceRecord record) {

		LOGGER.info("Editing record and replacing with new values: " + record);

		// SQL to update and replace record data
		final String SQL = "update sql371355.servicerecord set "
				+ MAKE + "=?, " + MODEL + "=?, " + COST + "=?, " + DATE
				+ "=?, " + DESCRIPTION + "=?, " + SATISFIED + "=? where " + ID
				+ "=?" + USERID + "=?";

		// Set parameters and JDBC types
		Object[] params = new Object[] { record.getMake(), record.getModel(),
				record.getCost(), DateUtils.parseDate(record.getDate()),
				record.getDescription(), record.getSatisfied(), record.getId(),
				record.getUserId() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE,
				Types.DATE, Types.VARCHAR, Types.BOOLEAN, Types.INTEGER,
				Types.INTEGER };

		return jdbcTemplate.update(SQL, params, types);
	}

	/**
	 * getServiceRecordList() instansiates an ArrayList, queries the database
	 * using query statement in String variable object by first: processing the
	 * result by instansiating a new service record, setting the fields and
	 * adding the new record to the list.
	 * 
	 * @return service record ArrayList
	 */
	public ArrayList<ServiceRecord> getServiceRecordList(final User user) {

		LOGGER.info("Getting all records from list...");

		// SQL query to get all the records from the database
		final String SQL = "select * from servicerecord where userid = "
				+ user.getId();
		final ArrayList<ServiceRecord> serviceRecordList = new ArrayList<ServiceRecord>();

		jdbcTemplate.query(SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {

				ServiceRecord record = new ServiceRecord();

				// setting all the fields using a ResultSet reference
				record.setId(new Integer(rs.getInt(ID)));
				record.setMake(rs.getString(MAKE));
				record.setModel(rs.getString(MODEL));
				record.setCost(rs.getDouble(COST));
				record.setDate(DateUtils.formatDate(rs.getDate(DATE)));
				record.setDescription(rs.getString(DESCRIPTION));
				record.setSatisfied(rs.getBoolean(SATISFIED));
				record.setUserId(new Integer(rs.getInt(USERID)));
				record.setFirstName(user.getFirstName());
				record.setLastName(user.getLastName());

				// Finally adding new record to ArrayList
				serviceRecordList.add(record);
			}
		});

		LOGGER.info("Returning service record list with record data: "
				+ serviceRecordList);

		return serviceRecordList;
	}

	/**
	 * getRecord() is used to return a single record object which matches the
	 * record id passed by value. This method is mainly used to pre-populate the
	 * edit form.
	 * 
	 * @param id
	 *            service record id
	 * @return single queried object
	 */
	public ServiceRecord getRecord(int id) {

		LOGGER.info("Fetching service record with " + ID + " = " + id);

		final String SQL = "select * from servicerecord where " + ID + "=?";

		final Object[] params = new Object[] { id };

		// instansiate a new record to store queried record
		final ServiceRecord record = new ServiceRecord();

		jdbcTemplate.query(SQL, params, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {

				// setting all the fields using a ResultSet reference
				record.setId(new Integer(rs.getInt(ID)));
				record.setMake(rs.getString(MAKE));
				record.setModel(rs.getString(MODEL));
				record.setCost(rs.getDouble(COST));
				record.setDate(DateUtils.formatDate(rs.getDate(DATE)));
				record.setDescription(rs.getString(DESCRIPTION));
				record.setSatisfied(rs.getBoolean(SATISFIED));
				record.setUserId(new Integer(rs.getInt(USERID)));
			}
		});

		LOGGER.info("Returning single service record instance with record data: "
				+ record);

		return record;
	}
}
