package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * MakeComparatorAsc sorts the list in ascending order
 * 
 * @author simongorial
 * 
 */
public class MakeComparatorAsc {

	/** COMPARE_BY_MODEL is called when a table of records gets sorted by model */
	public static Comparator<ServiceRecord> COMPARE_BY_MAKE_ASC = new Comparator<ServiceRecord>() {
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
			return one.getMake().compareTo(other.getMake());
		}
	};
}
