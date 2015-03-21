package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * SatisfiedComparatorAsc sorts the list in ascending order
 * 
 * @author simongorial
 *
 */
public class SatisfiedComparatorAsc {

	/** COMPARE_BY_SATISFIED is called when a table of records gets sorted by satisfied */
	public static Comparator<ServiceRecord> COMPARE_BY_SATISFIED_ASC = new Comparator<ServiceRecord>() {

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
			return one.getSatisfied().compareTo(other.getSatisfied());
		}
	};
}
