package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * ModelComparatorDec sorts the list in descending order
 * 
 * @author simongorial
 * 
 */
public class ModelComparatorDec {

	/**
	 * COMPARE_BY_MODEL is called when a table of records gets sorted by model
	 */
	public static Comparator<ServiceRecord> COMPARE_BY_MODEL_DEC = new Comparator<ServiceRecord>() {

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
			return other.getModel().compareTo(one.getModel());
		}
	};
}
