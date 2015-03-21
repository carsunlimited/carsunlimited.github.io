package springmvc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Date utility functions
 * 
 * @author simongorial
 */
public final class DateUtils {

	// Class logger
	private static final Logger LOGGER = Logger.getLogger(DateUtils.class);

	// The date format string
	private static final String DATE_FMT_STR = "MM/dd/yyyy";

	// The date formatter/parser
	private static final DateFormat SDF = new SimpleDateFormat(DATE_FMT_STR);

	/**
	 * Formats the given date into a string representation
	 * 
	 * @param date
	 *            The date to format
	 * @return Returns a date string
	 */
	public static final String formatDate(final Date date) {
		return SDF.format(date);
	}

	/**
	 * Parse the given string into a date object
	 * 
	 * @param string
	 *            The string to parse
	 * @return Returns the parsed date object
	 */
	public static final Date parseDate(final String string) {
		try {
			return SDF.parse(string);
		} catch (ParseException e) {
			LOGGER.error("Error while parsing date " + string);
			return null;
		}
	}

	/**
	 * Private constructor - do not instantiate
	 */
	private DateUtils() {

	}

}
