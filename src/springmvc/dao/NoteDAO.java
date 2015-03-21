package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import springmvc.model.Note;

/**
 * This class is responsible for handling all the add/delete/get notes to and
 * from a mysql database.
 * 
 * @author simongorial
 * 
 */
public class NoteDAO {
	
	/**
	 * Injected from application context. JdbcTemplate obtains a database
	 * connection
	 */
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = Logger.getLogger(NoteDAO.class);

	/** Constant string variables for DB column id's */
	private final static String TEXT = "text";
	private final static String ID = "id";
	private final static String SERVICERECORDID = "servicerecord_id";

	/**
	 * default constructor
	 */
	public NoteDAO() {
	}

	/**
	 * Injecting JdbcTemplate reference into bean ServiceRecordDAO via
	 * constructor injection. Setting jdbcTemplate.
	 * 
	 * @param jdbcTemplate
	 */
	public NoteDAO(JdbcTemplate jdbcTemplate) {
		PropertyConfigurator.configure("log4j.properties");

		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * addNote adds a note (row) to table 'notes' in mysql database
	 * 
	 * @param note
	 *            holds added note data
	 * @return Query to the database, inserting added note data
	 */
	public int addNote(Note note) {
		LOGGER.info("Adding note " + note.getId());

		// SQL to insert note text
		final String SQL = "Insert Into sql371355.notes(" + ID
				+ ", " + SERVICERECORDID + ", " + TEXT + ") values (?,?,?)";

		// Set parameters and JDBC types
		Object[] params = new Object[] { note.getId(), note.getServiceId(),
				note.getText() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR };

		return jdbcTemplate.update(SQL, params, types);
	}

	/**
	 * deleteNote removes a note (row) from table 'notes' in mysql database
	 * 
	 * @param id
	 *            holds integer id for requested note to be removed
	 * @return Query to the database, removing note
	 */
	public int deleteNote(int id) {

		LOGGER.info("Deleting note with " + ID + " = " + id);

		// SQL to delete record
		final String SQL = "delete from sql371355.notes where "
				+ ID + "=?";

		// Set parameters and JDBC types
		Object[] params = new Object[] { id };
		int[] types = new int[] { Types.INTEGER };

		return jdbcTemplate.update(SQL, params, types);
	}

	/**
	 * getNoteList() instansiates an ArrayList, queries the database using query
	 * statement in String variable object by first: processing the result by
	 * instansiating a new notes record, setting the fields and adding the new
	 * note record to the list.
	 * 
	 * @return notes ArrayList
	 */
	public ArrayList<Note> getNoteList(int id) {

		LOGGER.info("Getting all notes from list...");

		final String SQL = "select * from notes where " + SERVICERECORDID + " = " + id;
		final ArrayList<Note> noteList = new ArrayList<Note>();

		jdbcTemplate.query(SQL, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {

				Note note = new Note();

				// setting all the fields using a ResultSet reference
				note.setId(new Integer(rs.getInt(ID)));
				note.setServiceId(new Integer(rs.getInt(SERVICERECORDID)));
				note.setText(rs.getString(TEXT));

				// Finally adding new record to ArrayList
				noteList.add(note);
			}
		});

		LOGGER.info("Returning note list with note data: " + noteList);

		return noteList;
	}

}
