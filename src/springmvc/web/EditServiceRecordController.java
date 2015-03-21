package springmvc.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.model.ServiceRecord;
import springmvc.service.ServiceRecordManager;

/**
 * EditServiceRecord() is the controller that edits and replaces a requested
 * service record from an ArrayList. This class uses a form backing object to
 * store the field data in an object for storing into a command object. Also a
 * reference of the ServiceRecordManager class, handles the request by creating
 * a ModelAndView object and passing the appropriate .jsp page to be displayed.
 * 
 * @author simongorial
 * 
 */
public class EditServiceRecordController extends SimpleFormController {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	private static final Logger LOGGER = Logger
			.getLogger(EditServiceRecordController.class);

	/**
	 * New form fields are set here and stored in a form backing object
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		// get request param from form
		final int id = Integer.parseInt(request.getParameter("id"));

		// get the queried object and set to reference of service record
		ServiceRecord getRecord = serviceRecordManager.getServiceRecordDAO()
				.getRecord(id);

		// populate form
		ServiceRecord defaultServiceRecord = new ServiceRecord();

		defaultServiceRecord.setId(getRecord.getId());
		defaultServiceRecord.setMake(getRecord.getMake());
		defaultServiceRecord.setModel(getRecord.getModel());
		defaultServiceRecord.setCost(getRecord.getCost());
		defaultServiceRecord.setDate(getRecord.getDate());
		defaultServiceRecord.setDescription(getRecord.getDescription());
		defaultServiceRecord.setSatisfied(getRecord.getSatisfied());

		LOGGER.info("formBackingObject of edit controller holds "
				+ defaultServiceRecord);

		// Returns the object with data that is pre-populated in the form
		return defaultServiceRecord;
	}

	@Override
	/**
	 * onSubmit is called when a request to edit a service record is recieved
	 */
	public ModelAndView onSubmit(Object command) throws ServletException {

		LOGGER.info("Command object holds value: " + command.toString());

		// Passes command object to its edit method and redirects to success
		this.serviceRecordManager.editServiceRecord((ServiceRecord) command);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	/**
	 * Gets the service record manager ArrayList
	 * 
	 * @return serviceRecordManager list
	 */
	public ServiceRecordManager getServiceRecordManager() {
		return serviceRecordManager;
	}

	/**
	 * Sets the service record manager ArrayList
	 * 
	 * @param serviceRecordManager
	 */
	public void setServiceRecordManager(
			ServiceRecordManager serviceRecordManager) {
		this.serviceRecordManager = serviceRecordManager;
	}

}