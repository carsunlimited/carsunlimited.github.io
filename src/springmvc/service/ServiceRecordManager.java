package springmvc.service;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;

import springmvc.dao.NoteDAO;
import springmvc.dao.ServiceRecordDAO;
import springmvc.dao.UserDAO;
import springmvc.model.Note;
import springmvc.model.ServiceRecord;
import springmvc.model.User;
import springmvc.service.cmp.CostComparatorAsc;
import springmvc.service.cmp.CostComparatorDec;
import springmvc.service.cmp.DateComparatorAsc;
import springmvc.service.cmp.DateComparatorDec;
import springmvc.service.cmp.DescriptionComparatorAsc;
import springmvc.service.cmp.DescriptionComparatorDec;
import springmvc.service.cmp.MakeComparatorAsc;
import springmvc.service.cmp.MakeComparatorDec;
import springmvc.service.cmp.ModelComparatorAsc;
import springmvc.service.cmp.ModelComparatorDec;
import springmvc.service.cmp.SatisfiedComparatorAsc;
import springmvc.service.cmp.SatisfiedComparatorDec;

/**
 * ServiceRecordManager() handles the main business logic of adding, deleteing,
 * editing and sorting a service record and stores data to a database using
 * injected DAO
 * 
 * @author simongorial
 * 
 */
public class ServiceRecordManager {

	// DAO injection
	ServiceRecordDAO serviceRecordDAO;
	NoteDAO noteDAO;
	UserDAO userDAO;

	// Logger for testing entry for each method
	private static final Logger LOGGER = Logger
			.getLogger(ServiceRecordManager.class);

	// Class fields to distinguish the type of record sort
	public final static int SORT_BY_MAKE_ASC = 1;
	public final static int SORT_BY_MAKE_DEC = 2;
	public final static int SORT_BY_DATE_ASC = 3;
	public final static int SORT_BY_DATE_DEC = 4;
	public final static int SORT_BY_DESCRIPTION_ASC = 5;
	public final static int SORT_BY_DESCRIPTION_DEC = 6;
	public final static int SORT_BY_SATISFIED_ASC = 7;
	public final static int SORT_BY_SATISFIED_DEC = 8;
	public final static int SORT_BY_MODEL_ASC = 9;
	public final static int SORT_BY_MODEL_DEC = 10;
	public final static int SORT_BY_COST_ASC = 11;
	public final static int SORT_BY_COST_DEC = 12;

	/**
	 * addServiceRecord takes a type service record object and adds it to the
	 * array list
	 * 
	 * @param serviceRecord
	 *            Service record object
	 */
	public void addServiceRecord(ServiceRecord serviceRecord) {

		LOGGER.info("Adding service record: " + serviceRecord);

		// Sets a unique ID to each service record using millis time
		serviceRecord.setId((int) System.currentTimeMillis());
		// serviceRecord.setUserId(123);

		// Adds the service record to the database
		serviceRecordDAO.addRecord(serviceRecord);
	}

	/**
	 * addNoteRecord takes a type note object and adds it to the array list
	 * 
	 * @param noteRecord
	 *            note object
	 */
	public void addNoteRecord(Note noteRecord) {

		LOGGER.info("Adding note record: " + noteRecord);

		// Sets a unique ID to each note record using millis time
		noteRecord.setId((int) System.currentTimeMillis());

		// Adds the note record to the database
		noteDAO.addNote(noteRecord);
	}

	/**
	 * getUserRecord takes a type User object and calls the DAO getUser method
	 * to return a single instance of a user object
	 * 
	 * @param user
	 *            user object
	 */
	public void getUserRecord(User user) {

		LOGGER.info("Checking user object data: " + user);

		// Checks which user is logging in. Currently only two
		if ("simon.gorial".equals(user.getUserName())) {
			user.setId(123);
		} else if ("sam.gorial".equals(user.getUserName())) {
			user.setId(124);
		}

		// Adds the user record to the database
		userDAO.getUser(user);
	}

	public User getFirstLastNameRecord(int id) {

		return userDAO.getFirstLastName(id);

	}

	/**
	 * deleteServiceRecord() takes an id and iterates through the list of
	 * service records looking for a matching id. If the id is found, the object
	 * is removed (deleted) from the list
	 * 
	 * @param id
	 *            Unique ID to service record object
	 */
	public void deleteServiceRecord(int id) {
		LOGGER.info("Deleting service record with ID = " + id);

		serviceRecordDAO.deleteRecord(id);
	}

	/**
	 * deleteNoteRecord() takes an id and iterates through the list of notes
	 * looking for a matching id. If the id is found, the object is removed from
	 * the list
	 * 
	 * @param id
	 *            Unique ID from note object
	 */
	public void deleteNoteRecord(int id) {
		LOGGER.info("Deleting note with ID = " + id);

		noteDAO.deleteNote(id);
	}

	/**
	 * Similar to deleteing a record, editServiceRecord simply replaces each
	 * field with new values entered. Instead of just an 'id' being passed, a
	 * ServiceRecord object is passed which holds the new field values to be
	 * replaced. However, the 'id' of the parameter serviceRecord, must first
	 * match an 'id' from the list.
	 * 
	 * @param serviceRecord
	 *            Service record object
	 */
	public void editServiceRecord(ServiceRecord serviceRecord) {
		LOGGER.info("Editing service record with values " + serviceRecord);

		serviceRecordDAO.editRecord(serviceRecord);
	}

	/**
	 * Gets and optionally sorts the list of service records. Also passes User
	 * object to get the user_id
	 * 
	 * @return Service record list
	 */
	public ArrayList<ServiceRecord> getServiceRecordList(String sortType,
			User user) {

		LOGGER.info("Fetching service record list with sort type value "
				+ sortType);

		// Gets the service record ArrayList
		ArrayList<ServiceRecord> sortedList = serviceRecordDAO
				.getServiceRecordList(user);

		// Switch statements to get sort type
		switch (Integer.parseInt(sortType)) {
		case 0:
			break;
		case SORT_BY_MAKE_ASC:

			// Collections class to sort list by calling service record
			// comparator class (and by type)
			Collections.sort(sortedList, MakeComparatorAsc.COMPARE_BY_MAKE_ASC);
			break;
		case SORT_BY_MAKE_DEC:

			Collections.sort(sortedList, MakeComparatorDec.COMPARE_BY_MAKE_DEC);
			break;
		case SORT_BY_MODEL_ASC:

			Collections.sort(sortedList,
					ModelComparatorAsc.COMPARE_BY_MODEL_ASC);
			break;
		case SORT_BY_MODEL_DEC:

			Collections.sort(sortedList,
					ModelComparatorDec.COMPARE_BY_MODEL_DEC);
			break;
		case SORT_BY_COST_ASC:

			Collections.sort(sortedList, CostComparatorAsc.COMPARE_BY_COST_ASC);
			break;
		case SORT_BY_COST_DEC:

			Collections.sort(sortedList, CostComparatorDec.COMPARE_BY_COST_DEC);
			break;
		case SORT_BY_DATE_ASC:

			Collections.sort(sortedList, DateComparatorAsc.COMPARE_BY_DATE_ASC);
			break;
		case SORT_BY_DATE_DEC:

			Collections.sort(sortedList, DateComparatorDec.COMPARE_BY_DATE_DEC);
			break;
		case SORT_BY_DESCRIPTION_ASC:

			Collections.sort(sortedList,
					DescriptionComparatorAsc.COMPARE_BY_DESCRIPTION_ASC);
			break;
		case SORT_BY_DESCRIPTION_DEC:

			Collections.sort(sortedList,
					DescriptionComparatorDec.COMPARE_BY_DESCRIPTION_DEC);
			break;
		case SORT_BY_SATISFIED_ASC:

			Collections.sort(sortedList,
					SatisfiedComparatorAsc.COMPARE_BY_SATISFIED_ASC);
			break;
		case SORT_BY_SATISFIED_DEC:

			Collections.sort(sortedList,
					SatisfiedComparatorDec.COMPARE_BY_SATISFIED_DEC);
			break;

		}

		LOGGER.info("Returning sorted list with record data --> " + sortedList);

		return sortedList;
	}

	/**
	 * Gets and optionally sorts the list of service records
	 * 
	 * @return Service record list
	 */
	public ArrayList<Note> getNoteListFromDAO(int id) {

		LOGGER.info("Getting the note list with ID: " + id);

		return getNoteDAO().getNoteList(id);

	}

	/**
	 * Gets the list of service records from DAO
	 * 
	 * @return Service record list
	 */
	public ServiceRecordDAO getServiceRecordDAO() {
		return serviceRecordDAO;
	}

	/**
	 * Sets the list of service records from DAO
	 * 
	 * @param Service
	 *            record list
	 */
	public void setServiceRecordDAO(ServiceRecordDAO serviceRecordDAO) {
		this.serviceRecordDAO = serviceRecordDAO;
	}

	/**
	 * Gets the note DAO reference
	 * 
	 * @return noteDAO
	 */
	public NoteDAO getNoteDAO() {
		return noteDAO;
	}

	/**
	 * Sets the note DAO
	 * 
	 * @param noteDAO
	 *            note DAO reference
	 */
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	/**
	 * Gets the user DAO
	 * 
	 * @return userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Sets the user DAO
	 * 
	 * @param userDAO
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
