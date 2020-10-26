package commands;

import exception.AppException;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class NewOrderCommand implements ActionCommand {

    /**
     * Method for realizing specified business-logic
     * of command for displaying new order page.
     * @param request - an instance of HttpServletRequest with
     * 	                request parameters;
     * @return path to the necessary page;
     * @throws AppException
     */
    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;
        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.new_order");
        }
        return page;
    }
}
