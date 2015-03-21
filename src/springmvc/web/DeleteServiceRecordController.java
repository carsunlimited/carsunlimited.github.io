package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springmvc.service.ServiceRecordManager;

/**
 * DeleteServiceRecord() is the controller that deletes a requested service
 * record from an ArrayList. This class uses a reference of the
 * ServiceRecordManager class, handles the request by calling the delete method
 * of its manager class, creates a ModelAndView object and redirects the view to
 * a .jsp page to be displayed.
 * 
 * @author simongorial
 * 
 */
public class DeleteServiceRecordController implements Controller {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	// JSP view page to redirect to
	private static final String VIEW_PAGE = "serviceRecordDeleted";

	private static final Logger LOGGER = Logger
			.getLogger(DeleteServiceRecordController.class);

	/**
	 * Handles the request to delete a service record by passing its record id
	 * to its delete method
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// get the id
		int id = Integer.parseInt(request.getParameter("id"));

		LOGGER.info("Calling request object for parameter 'id' with value: "
				+ id);

		// get the object
		this.serviceRecordManager.deleteServiceRecord(id);

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