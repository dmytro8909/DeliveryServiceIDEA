package commands;

import javax.servlet.http.HttpServletRequest;

import exception.AppException;
import resource.ConfigurationManager;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class ToIndexCommand implements ActionCommand {

	/**
	 * Method for realizing specified business-logic
	 * of command for displaying index page.
	 * @param request - an instance of HttpServletRequest with
	 *                  request parameters;
	 * @return path to the necessary page;
	 * @throws AppException
	 */
	@Override
	public String execute(HttpServletRequest request) throws AppException {
		String page =  null;
		
		if (request != null) {
			page = ConfigurationManager.getProperty("path.page.index");
		}
		
		return page;
	}
	
}
