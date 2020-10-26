package commands;

import exception.AppException;
import resource.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class BidsCommand implements ActionCommand {

    /**
     * Method for realizing specified business-logic
     * command for
     * @param request
     * @return
     * @throws AppException
     */
    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;
        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.bids");
        }
        return page;
    }
}
