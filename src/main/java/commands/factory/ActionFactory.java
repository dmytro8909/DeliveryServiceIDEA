package commands.factory;

import javax.servlet.http.HttpServletRequest;

import commands.ActionCommand;
import commands.EmptyCommand;
import commands.client.CommandEnum;
import resource.MessageManager;

public class ActionFactory {
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
