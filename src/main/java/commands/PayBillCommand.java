package commands;

import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class PayBillCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String page = null;

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.bill");
        }

        return null;
    }
}
