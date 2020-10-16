package commands;

import dao.DirectionDAO;
import dao.OrderDAO;
import dao.RatesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateOrderCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(CreateOrderCommand.class);

    private static final String PARAM_NAME_USER_ID = "userId";
//    private static final String PARAM_NAME_PACKAGE_ID = "packageId";
//    private static final String PARAM_NAME_DIRECTION_ID = "directionId";
//    private static final String PARAM_NAME_RATE_ID = "rateId";
    private static final String PARAM_NAME_DESCRIPTION = "description";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_DIRECTION = "direction";
    private static final String PARAM_NAME_WEIGHT = "weight";
    private static final String PARAM_NAME_LENGTH = "length";
    private static final String PARAM_NAME_WIDTH = "width";
    private static final String PARAM_NAME_HEIGHT = "height";
    private static final String PARAM_NAME_SHIPPING_DATE = "shippingDate";

    private static OrderDAO orderDAO = new OrderDAO();
    private static RatesDAO ratesDAO = new RatesDAO();
    private static DirectionDAO directionDAO = new DirectionDAO();

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String page = null;

        String uId = request.getParameter(PARAM_NAME_USER_ID);
//        String pId = request.getParameter(PARAM_NAME_PACKAGE_ID);
        String dId = request.getParameter(PARAM_NAME_DIRECTION);
//        String rId = request.getParameter(PARAM_NAME_RATE_ID);
        String description = request.getParameter(PARAM_NAME_DESCRIPTION);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
//        String direction = request.getParameter(PARAM_NAME_DIRECTION);
        String weight = request.getParameter(PARAM_NAME_WEIGHT);
        String length = request.getParameter(PARAM_NAME_LENGTH);
        String width = request.getParameter(PARAM_NAME_WIDTH);
        String height = request.getParameter(PARAM_NAME_HEIGHT);
        String shipDate = request.getParameter(PARAM_NAME_SHIPPING_DATE);

        int userId = Integer.parseInt(uId);
        int directionId = Integer.parseInt(dId);
//        Long rateId = Long.parseLong(rId);

        int distance = directionDAO.getDistanceById(directionId);

//        Long packageId = Long.parseLong(pId);
        Double packageWeight = Double.parseDouble(weight);
        Double packageLength = Double.parseDouble(length);
        Double packageWidth = Double.parseDouble(width);
        Double packageHeight = Double.parseDouble(height);
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd");
        Date shippingDate = simpleDateFormat.parse(shipDate);
        BigDecimal rate = getRate(packageWeight, packageLength, packageWidth,
                                  packageHeight);
        BigDecimal cost = costForming(rate, distance);

        orderDAO.insertOrder(description, address, shippingDate,
                             cost, userId, directionId);

        if (request != null) {
            page = ConfigurationManager.getProperty("path.page.index");
        }
        return page;
    }

    private static BigDecimal getRate(Double weight, Double length,
                                      Double width, Double height) {
        BigDecimal rate = null;
        if (weight <= 2 && ((length * width * height) <= 3.375)) {
            rate = ratesDAO.getRateByName("up_to_2");
        } else if ((weight > 2) && ((length * width * height) > 3.375)) {
            rate = ratesDAO.getRateByName("over_2");
        } else {
            rate = ratesDAO.getRateByName("otherwise");
        }
        return rate;
    }

    private static BigDecimal costForming(BigDecimal rate, int distance) {
        BigDecimal cost = null;
        if (rate != null && distance != 0) {
            cost = rate.multiply(BigDecimal.valueOf(distance));
        }
        return cost;
    }

}
