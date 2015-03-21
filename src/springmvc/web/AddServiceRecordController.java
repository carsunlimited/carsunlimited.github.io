package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.model.ServiceRecord;
import springmvc.service.ServiceRecordManager;

/**
 * AddServiceRecordController() serves as a controller class to add service
 * records to a list. Two overridden methods are implemented which call the
 * request object to set the default values and then use the command object to
 * pass to the manager class to implement its business logic to add the record
 * to its list.It then redirects a ModelAndView to a success page.
 * 
 * @author simongorial
 * 
 */
public class AddServiceRecordController extends SimpleFormController {

	// A reference object of type ServiceRecordManager 
	private ServiceRecordManager serviceRecordManager;

	private static final Logger LOGGER = Logger
			.getLogger(AddServiceRecordController.class);

	/**
	 * Adds a service record by passing a type ServiceRecord object. ModelAndView then redirects
	 * the view to the success page
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		HttpSession session = request.getSession();
		int user_id = (Integer) session.getAttribute("userid");
		
		LOGGER.info("User ID " + user_id  + " in session getting set to service records userid ");
		LOGGER.info("Command object holds value " + command.toString());

		// Setting user_id
		((ServiceRecord) command).setUserId(user_id);
		
		// Passes command object from form and adds service record
		this.serviceRecordManager.addServiceRecord((ServiceRecord) command);
		
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	/**
	 * Gets the service record manager reference
	 * 
	 * @return serviceRecordManager reference
	 */
	public ServiceRecordManager getServiceRecordManager() {
		return serviceRecordManager;
	}

	/**
	 * Sets the service record manager
	 * 
	 * @param serviceRecordManager
	 *            Service record manager object
	 */
	public void setServiceRecordManager(
			ServiceRecordManager serviceRecordManager) {
		this.serviceRecordManager = serviceRecordManager;
	}

}