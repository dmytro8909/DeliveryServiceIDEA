package commands;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class ToLoginFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page =  null;
		
		if (request != null) {
			page = ConfigurationManager.getProperty("path.page.login");
		}
		
		return page;
	}

}
