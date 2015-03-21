package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * CostComparatorDec sorts the list in decending order
 * 
 * @author simongorial
 * 
 */
public class CostComparatorDec {

	/**
	 * COMPARE_BY_COST is called when a table of records gets sorted by cost
	 */
	public static Comparator<ServiceRecord> COMPARE_BY_COST_DEC = new Comparator<ServiceRecord>() {

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
			return other.getCost().compareTo(one.getCost());
		}
	};
}
