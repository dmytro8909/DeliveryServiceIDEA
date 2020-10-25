package commands;

import exception.AppException;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class NewOrderCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;
        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.new_order");
        }
        return page;
    }
}
