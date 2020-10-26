package commands;

import dao.BillDAO;
import exception.AppException;
import resource.ConfigurationManager;
import resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Class for realizing specified business-logic
 * of command.
 */
public class PayBillCommand implements ActionCommand {

    private static final String PARAM_NAME_BILL_ID = "billId";

    /**
     * Method for realizing specified business-logic
     * of command for paying a bill.
     * @param request - an instance of HttpServletRequest with
     * 	                request parameters;
     * @return path to the necessary page;
     * @throws AppException
     */
    @Override
    public String execute(HttpServletRequest request) throws AppException {
        String page = null;

        String bId = request.getParameter(PARAM_NAME_BILL_ID);
        int billId = Integer.parseInt(bId);

        BillDAO billDAO = new BillDAO();
        billDAO.updateStatusOnPaid(billId);

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.client");
        } else {
            request.getSession().setAttribute("with_out_bill",
                    MessageManager.getProperty("message.with_out_bill"));
        }

        return page;
    }
}
