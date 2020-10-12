package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import commands.ActionCommand;
import commands.factory.ActionFactory;
import dao.DirectionDAO;
import db.ConnectionPool;
import resource.ConfigurationManager;
import resource.MessageManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
								HttpServletResponse response)
										throws ServletException, IOException{
		
		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		try {
			page = command.execute(request);
		} catch (Exception e) {
			LOGGER.error("Page exception");
		}
		
		if (page != null) {
			RequestDispatcher dispatcher = 
					getServletContext().getRequestDispatcher(page);
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.error");
			request.getSession().setAttribute("nullPage",
			MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}

//	private void postProcessRequest(HttpServletRequest request,
//			HttpServletResponse response)
//					throws ServletException, IOException{
//		
//		String page = null;
//		ActionFactory client = new ActionFactory();
//		ActionCommand command = client.defineCommand(request);
//		try {
//			page = command.execute(request);
//		} catch (Exception e) {
//			LOGGER.error("Page exception");
//		}
//		
//		if (command != null) {
//			response.sendRedirect(request.getContextPath() + page);
//		} else {
//			page = ConfigurationManager.getProperty("path.page.error");
//			request.getSession().setAttribute("nullPage",
//					MessageManager.getProperty("message.nullpage"));
//			response.sendRedirect(request.getContextPath() + page);
//		}
//	}
	
	
	
}
