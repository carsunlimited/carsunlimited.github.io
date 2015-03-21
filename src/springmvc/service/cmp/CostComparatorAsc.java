package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * CostComparatorAsc sorts the list in ascending order
 * 
 * @author simongorial
 * 
 */
public class CostComparatorAsc {

	/**
	 * COMPARE_BY_COST is called when a table of records gets sorted by cost
	 */
	public static Comparator<ServiceRecord> COMPARE_BY_COST_ASC = new Comparator<ServiceRecord>() {

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
			return one.getCost().compareTo(other.getCost());
		}
	};
}
