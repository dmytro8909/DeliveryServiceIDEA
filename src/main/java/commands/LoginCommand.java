package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import exception.AppException;
import exception.DBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.Controller;
import dao.UserDAO;
import db.DBManager;
import entities.User;
import logic.LoginLogic;
import resource.ConfigurationManager;
import resource.MessageManager;

import static exception.Messages.ERR_CANNOT_GET_USER;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class LoginCommand implements ActionCommand {

	private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private UserDAO userDAO = new UserDAO();

	/**
	 * Method for realizing specified business-logic
	 * of command for logging in.
	 * @param request - an instance of HttpServletRequest with
	 *                  request parameters;
	 * @return path to the necessary page;
	 * @throws AppException
	 */
	@Override
	public String execute(HttpServletRequest request) throws AppException {
		HttpSession session = request.getSession();
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		Integer userId = null;
		String userRole = null;

		User user = userDAO.findUserByLogin(login);
		OrderDAO orderDAO = new OrderDAO();

		if (user != null) {
			userId = user.getId();
			userRole = user.getRole();

			if (LoginLogic.checkLogin(login, pass) && "manager".equals(user.getRole())) {
				session.setAttribute("user", user);
				session.setAttribute("userRole", userRole);
				session.setAttribute("userId", userId);
				session.setAttribute("ordersList", orderDAO.getAll());
				page = ConfigurationManager.getProperty("path.page.index");
			} else if (LoginLogic.checkLogin(login, pass) && "user".equals(user.getRole())) {
				session.setAttribute("user", user);
				session.setAttribute("userRole", userRole);
				session.setAttribute("userId", userId);
				session.setAttribute("userOrders", orderDAO.getUserOrders(userId));
				page = ConfigurationManager.getProperty("path.page.index");
			}
		} else {
//			page = ConfigurationManager.getProperty("path.page.error");
//			request.setAttribute("loginError",
//					MessageManager.getProperty("message.loginerror"));
			LOGGER.error(ERR_CANNOT_GET_USER);
			throw new AppException(ERR_CANNOT_GET_USER);
		}

//		if (user == null || !pass.equals(user.getPassword())) {
//			page = ConfigurationManager.getProperty("path.page.error");
//			session.setAttribute("loginerror",
//				MessageManager.getProperty("message.loginerror"));
//			LOGGER.error(ERR_CANNOT_GET_USER);
//		} else
//		if (LoginLogic.checkLogin(login, pass) && "manager".equals(user.getRole())) {
//			session.setAttribute("user", user);
//			session.setAttribute("userRole", userRole);
//			session.setAttribute("userId", userId);
//			session.setAttribute("ordersList", orderDAO.getAll());
//			page = ConfigurationManager.getProperty("path.page.index");
//		} else if (LoginLogic.checkLogin(login, pass) && "user".equals(user.getRole())) {
//			session.setAttribute("user", user);
//			session.setAttribute("userRole", userRole);
//			session.setAttribute("userId", userId);
//			session.setAttribute("userOrders", orderDAO.getUserOrders(userId));
//			page = ConfigurationManager.getProperty("path.page.index");
//		}
		
		return page;
	}
}
