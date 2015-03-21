package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springmvc.service.ServiceRecordManager;

/**
 * DeleteNoteRecord() is the controller that deletes a requested note from an
 * ArrayList. This class uses a reference of the ServiceRecordManager class,
 * handles the request by calling the deleteNoteRecord() method of its manager
 * class, creates a ModelAndView object and redirects the view to a .jsp page to
 * be displayed.
 * 
 * @author simongorial
 * 
 */
public class DeleteNoteController implements Controller {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	// JSP view page to redirect to
	private static final String VIEW_PAGE = "noteDeleted";

	private static final Logger LOGGER = Logger
			.getLogger(DeleteNoteController.class);

	/**
	 * Handles the request to delete note by passing its note id to the delete
	 * method
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// get the id
		int id = Integer.parseInt(request.getParameter("id"));

		LOGGER.info("Calling request object for parameter 'id' with value: "
				+ id);

		// get the object
		this.serviceRecordManager.deleteNoteRecord(id);

		return new ModelAndView(VIEW_PAGE);
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
