package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;
import springmvc.util.DateUtils;

/**
 * DateComparatorDec sorts the list in descending order
 * 
 * @author simongorial
 *
 */
public class DateComparatorDec {

	/** COMPARE_BY_DATE is called when a table of records gets sorted by date */
	public static Comparator<ServiceRecord> COMPARE_BY_DATE_DEC = new Comparator<ServiceRecord>() {

		/**
		 * 
		 * @param one
		 *            Compares object 'one' with the specified object 'other'
		 * @param other
		 *            Compares object 'other' with the specified object 'one'
		 * @return cost comparison
		 */
		@Override
		public int compare(ServiceRecord one, ServiceRecord other) {
			return DateUtils.parseDate(other.getDate()).compareTo(DateUtils.parseDate(one.getDate()));
		}
	};
}
