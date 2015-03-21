package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.model.User;
import springmvc.service.ServiceRecordManager;

/**
 * The login controller gets a user object and puts it in session. The
 * controller redirects the view to the service record list which accesses a
 * database in a table named 'users', and searches for a 'id' that matches a
 * login username.
 * 
 * @author simongorial
 * 
 */
public class LoginController extends SimpleFormController {

	// A reference object of type ServiceRecordManager
	private ServiceRecordManager serviceRecordManager;

	// Logging console statements
	private static final Logger LOGGER = Logger
			.getLogger(LoginController.class);

	/**
	 * Sets the session request id parameter and adds a note by passing a type
	 * Note object. ModelAndView then redirects the view to the success page
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		// Requests a session and sets User command object into session
		HttpSession session = request.getSession();
		User user = ((User) command);

		// Gets the user
		this.serviceRecordManager.getUserRecord(user);

		// Puts the User object and user id in session
		session.setAttribute("userid", user.getId());
		session.setAttribute("user", user);

		LOGGER.info("User ID: " + user.getId());

		// Redirects the view to the service record list
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
