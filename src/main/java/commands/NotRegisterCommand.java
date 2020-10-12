package commands;

import javax.servlet.http.HttpServletRequest;

import resource.ConfigurationManager;

public class NotRegisterCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		String page =  null;
		
		if (request != null) {
			page = ConfigurationManager.getProperty("path.page.not_register");
		}
		
		return page;
	}
	
}
