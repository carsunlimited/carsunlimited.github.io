package springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * This is a simple controller which does 3 basic things. Requests for a current
 * session, removes the object user in session (also invalidates so tomcat
 * server can remove the session), and lastly, rediects the view back to the
 * login page.
 * 
 * @author simongorial
 * 
 */
public class LogoutController implements Controller {

	/**
	 * Method handles the request to logout a user and remove user from session
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception {

		// Gets the session
		HttpSession session = request.getSession();

		// Removes the user from session
		session.removeAttribute("userid");
		session.removeAttribute("user");
		session.invalidate();

		// Redirects back to the login page
		return new ModelAndView("redirect:/login.html");
	}
}
