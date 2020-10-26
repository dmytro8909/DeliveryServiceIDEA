package commands;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class ToLoginFormCommand implements ActionCommand {

	/**
	 * Method for realizing specified business-logic
	 * of command for displaying login page.
	 * @param request - an instance of HttpServletRequest with
	 *                  request parameters;
	 * @return path to the necessary page;
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page =  null;
		
		if (request != null) {
			page = ConfigurationManager.getProperty("path.page.login");
		}
		
		return page;
	}

}
