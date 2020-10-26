package commands;

import dao.OrderDAO;
import exception.AppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class SortBidsCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(SortBidsCommand.class);

    private static final String PARAM_NAME_SORT_NAME = "sortName";
    private static OrderDAO orderDAO = new OrderDAO();

    /**
     * Method for realizing specified business-logic
     * of command for displaying page with sorted bids.
     * @param request - an instance of HttpServletRequest with
     *                  request parameters;
     * @return path to the necessary page;
     * @throws AppException
     * @throws ParseException
     */
    @Override
    public String execute(HttpServletRequest request) throws AppException, ParseException {
        String page = null;
        String sortName = request.getParameter(PARAM_NAME_SORT_NAME);
        if (sortName.equals("sortByShippingDate")) {
            request.getSession().setAttribute("ordersList", orderDAO.getOrdersSortedByShippingDate());
        } else if (sortName.equals("sortByCost")) {
            request.getSession().setAttribute("ordersList", orderDAO.getOrdersSortedByCost());
        } else {
            request.getSession().setAttribute("ordersList", orderDAO.getAll());
        }
        page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
