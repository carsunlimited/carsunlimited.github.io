package springmvc.service.cmp;

import java.util.Comparator;

import springmvc.model.ServiceRecord;

/**
 * ModelComparatorAsc sorts the list in ascending order
 * 
 * @author simongorial
 *
 */
public class ModelComparatorAsc {

	/** COMPARE_BY_MODEL is called when a table of records gets sorted by model */
	public static Comparator<ServiceRecord> COMPARE_BY_MODEL_ASC = new Comparator<ServiceRecord>() {

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
			return one.getModel().compareTo(other.getModel());
		}
	};
}
