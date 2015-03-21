package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * DescriptionComparatorDec sorts the list in descending order
 * 
 * @author simongorial
 * 
 */
public class DescriptionComparatorDec {

	/** COMPARE_BY_DESCRIPTION is called when a table of records gets sorted by model */
	public static Comparator<ServiceRecord> COMPARE_BY_DESCRIPTION_DEC = new Comparator<ServiceRecord>() {
		/**
		 * 
		 * @param one
		 *            Compares object 'one' with the specified object 'other'
		 * @param other
		 *            Compares object 'other' with the specified object 'one'
		 * @return model comparison
		 */
		@Override
		public int compare(ServiceRecord one, ServiceRecord other) {
			// implements the Comparable interface, compareTo() method, and
			// compares service records model
			return other.getDescription().compareTo(one.getDescription());
		}
	};
}
