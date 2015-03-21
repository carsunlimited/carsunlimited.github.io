package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.model.Note;
import springmvc.service.ServiceRecordManager;

/**
 * AddNoteController() serves as a controller class to add note records to a
 * list. ModelAndView's onSubmit method is overridden which calls the request
 * object to set the default values and then calls the command object to pass to
 * the manager class to implement its business logic to add the note to its
 * list. It then redirects a ModelAndView to a success page.
 * 
 * @author simongorial
 * 
 */
public class AddNoteController extends SimpleFormController {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	private static final Logger LOGGER = Logger
			.getLogger(AddNoteController.class);

	/**
	 * Sets the session request id parameter and adds a note by passing a type
	 * Note object. ModelAndView then redirects the view to the success page
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		// Requests a session and sets an id attribute to a string variable
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// Sets the current id in session to the command objects setServiceId()
		// method
		((Note) command).setServiceId(Integer.parseInt(id));

		// Logs the service id and command object to console
		LOGGER.info("Service record id:  " + ((Note) command).getServiceId());
		LOGGER.info("Command object holds value " + command.toString());

		// Calls the service reocrd manager and adds a note by passing the note
		// object to the method addNoteRecord
		this.serviceRecordManager.addNoteRecord((Note) command);
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
