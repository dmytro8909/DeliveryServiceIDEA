package commands;

import dao.BillDAO;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class PayBillCommand implements ActionCommand {

    private static final String PARAM_NAME_BILL_ID = "billId";

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String page = null;

        String bId = request.getParameter(PARAM_NAME_BILL_ID);
        int billId = Integer.parseInt(bId);

        BillDAO billDAO = new BillDAO();
        billDAO.updateStatusOnPaid(billId);

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.client");
        }

        return null;
    }
}
