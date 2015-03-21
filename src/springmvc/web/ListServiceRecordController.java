package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import springmvc.model.User;
import springmvc.service.ServiceRecordManager;

/**
 * Similar to the add controller, ListServiceRecord() acts as a controller to
 * show all the service records stored in an ArrayList. This class uses a
 * reference of the ServiceRecordManager class, handles the request by creating
 * a ModelAndView object and passing the appropriate .jsp page to be displayed.
 * 
 * @author simongorial
 * 
 */
public class ListServiceRecordController implements Controller {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	// Constant variable for JSP view page
	private static final String VIEW_PAGE = "serviceRecordList";
	private static final String LOGIN_PAGE = "login";

	// Constant variable for list sort type
	private static final String SORT_TYPE = "sortType";

	private static final Logger LOGGER = Logger
			.getLogger(ListServiceRecordController.class);

	// Handles the request using HttpServletRequest/Response
	@SuppressWarnings("unused")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		LOGGER.info("Calling request object for parameter 'sortType' with value: "
				+ request.getParameter(SORT_TYPE));

		String sortType = request.getParameter(SORT_TYPE);

		// Instansiates a new object and sends the .jsp success page
		ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		LOGGER.info("User ID in session: " + user.getId());
		
		User name = this.serviceRecordManager.getFirstLastNameRecord(user.getId());

		user.setFirstName(name.getFirstName());
		user.setLastName(name.getLastName());
		
		/**
		 * When this class is first instansiated, SORT_TYPE is null since no one
		 * can sort a record before the view is shown. Therefore, SORT_TYPE must
		 * be set to zero first to prevent a NULL pointer exception
		 */
		if (!(sortType != null)) {
			sortType = "0";
		}

		if (session != null) {
			
			modelAndView.addObject(VIEW_PAGE, this.serviceRecordManager
					.getServiceRecordList(sortType, user));

			LOGGER.info("Successfull getting service record list with user ID: "
					+ user.getId());
			return modelAndView;
		}

		/**
		 * If user trys to type in the url extension:
		 * "/show_service_records.html" without logging in first, it redirects
		 * to login page. This is done by checking to see if there is a user in
		 * session
		 */
		return new ModelAndView("redirect:/login.html");
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