package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springmvc.service.ServiceRecordManager;

/**
 * ListNoteController() is called when a user adds a note to a service record
 * and all notes unique to a service record id are listed
 * 
 * @author simongorial
 * 
 */
public class ListNoteController implements Controller {

	private static final Logger LOGGER = Logger
			.getLogger(ListNoteController.class);

	private static final String ID = "id";
	
	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	// JSP view page to redirect to
	private static final String VIEW_PAGE = "noteList";

	// Handles the request using HttpServletRequest/Response
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		/**
		 * Creating a session object, getting the id parameter and setting the
		 * id attribute into session
		 */
		HttpSession session = request.getSession();
		if (request.getParameter(ID) != null) {
			session.setAttribute(ID, request.getParameter(ID));
		}

		LOGGER.info("Session ID: " + session.getAttribute(ID));

		/**
		 * Instansiates a new object and passes the .jsp page to display through
		 * it's constructor
		 */
		ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);

		// Getting the list with notes unique to service record id
		modelAndView.addObject(VIEW_PAGE, this.serviceRecordManager
				.getNoteListFromDAO(Integer.parseInt((String) session
						.getAttribute(ID))));

		return modelAndView;
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
