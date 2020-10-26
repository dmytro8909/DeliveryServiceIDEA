package controller;

import commands.ActionCommand;
import commands.LoginCommand;
import commands.factory.ActionFactory;
import db.SQLConstants;
import exception.AppException;
import exception.DBException;
import exception.Messages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Servlet implementation class HttpServlet.
 * Class which realizes the controller in the
 * MVC-pattern.
 */
@WebServlet(urlPatterns = "/controller", name = "Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = -3777927504771334162L;
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (AppException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Method which realizes Post-Redirect-Get-pattern
	 * and transmits commands handing with redirection
	 * to the necessary page.
	 * @param request - an instance of HttpServletRequest with
	 *                  request parameters;
	 * @param response - an instance of HttpServletResponse with
	 *                   response parameters;
	 * @throws ServletException
	 * @throws IOException
	 * @throws AppException
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException, AppException {
		request.setCharacterEncoding("UTF-8");
		String page;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		try {
		        page = command.execute(request);
            } catch (AppException | ParseException e) {
				page = ConfigurationManager.getProperty("path.page.error");
				LOGGER.error(Messages.ERR_CANNOT_OPEN_PAGE);
//				request.setAttribute("errorMessage", e.getMessage());
//                response.sendRedirect(request.getContextPath() + page);

				request.setAttribute("nullPage",
						MessageManager.getProperty("message.nullpage"));
				response.sendRedirect(request.getContextPath() + page);

		}
		if ((page != null) && (request.getMethod().equals("GET"))) {
			RequestDispatcher dispatcher =
					getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else if ((page != null) && (request.getMethod().equals("POST"))) {
			response.sendRedirect(request.getContextPath() + page);
		}
		else {
			LOGGER.error(Messages.ERR_CANNOT_OPEN_PAGE);
			page = ConfigurationManager.getProperty("path.page.error");
			request.setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
//			response.sendRedirect(request.getContextPath() + page);
			RequestDispatcher dispatcher =
					getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}

}
