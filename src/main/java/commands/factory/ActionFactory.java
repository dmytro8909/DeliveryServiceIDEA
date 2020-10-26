package commands.factory;

import javax.servlet.http.HttpServletRequest;

import commands.ActionCommand;
import commands.EmptyCommand;
import commands.client.CommandEnum;
import resource.MessageManager;

/**
 * Class for transforming a request parameter
 * to the specified command.
 */
public class ActionFactory {

	/**
	 * Method for finding command in a request parameters and returning
	 * current command from the enumeration with commands.
	 *
	 * @param request - an instance of HttpServletRequest with
	 *                	request parameters;
	 * @return - a current command which was found in the
	 * 			 enumeration with commands;
	 */
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		
		if (action == null || action.isEmpty()) {
			return current;
		}
		
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
			+ MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
