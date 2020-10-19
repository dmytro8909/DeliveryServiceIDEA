package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;
import dao.UserDAO;
import db.DBManager;
import entities.User;
import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

public class LoginCommand implements ActionCommand {
	
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private UserDAO userDAO = new UserDAO();
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);

		User user = userDAO.findUserByLogin(login);
		int userId = user.getId();
		String userRole = user.getRole();
		OrderDAO orderDAO = new OrderDAO();

		if (user == null || !pass.equals(user.getPassword())) {
			session.setAttribute("loginerror",
			MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		
		if (LoginLogic.checkLogin(login, pass) && "manager".equals(user.getRole())) {
			session.setAttribute("user", user);
			session.setAttribute("userRole", userRole);
			session.setAttribute("userId", userId);
			session.setAttribute("ordersList", orderDAO.getAll());
			page = ConfigurationManager.getProperty("path.page.index");
		}

		if (LoginLogic.checkLogin(login, pass) && "user".equals(user.getRole())) {
			session.setAttribute("user", user);
			session.setAttribute("userRole", userRole);
			session.setAttribute("userId", userId);
			session.setAttribute("userOrders", orderDAO.getUserOrders(userId));
			page = ConfigurationManager.getProperty("path.page.index");
		}
		
		return page;
	}
}
