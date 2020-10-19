package commands;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.UserDAO;
import entities.User;
import resource.ConfigurationManager;
import resource.MessageManager;
import static exception.Messages.ERR_CANNOT_INSERT_USER;

public class RegisterCommand implements ActionCommand {
	
	private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
	
	private static final String PARAM_NAME_NAME = "name";
	private static final String PARAM_NAME_LAST_NAME = "lastName";
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private UserDAO userDAO = new UserDAO();
	
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String name = request.getParameter(PARAM_NAME_NAME);
		String lastName = request.getParameter(PARAM_NAME_LAST_NAME);
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
	
		User user = userDAO.findUserByLogin(login);
		
		if (user == null) {
			try {
				userDAO.insertUser(name, lastName, login, password);
				page = ConfigurationManager.getProperty("path.page.index");
			} catch (SQLException e) {
				LOGGER.error(ERR_CANNOT_INSERT_USER);
			}
		} else {
			request.setAttribute("errorLoginPassMessage",
			MessageManager.getProperty("message.loginexists"));
			page = ConfigurationManager.getProperty("path.page.index");
		}
		return page;
	}
	
}
