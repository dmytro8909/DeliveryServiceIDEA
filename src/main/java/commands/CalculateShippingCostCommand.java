package commands;

import javax.servlet.http.HttpServletRequest;

public class CalculateShippingCostCommand implements ActionCommand {
	private static final String PARAM_NAME_WEIGHT = "weight";
	private static final String PARAM_NAME_LENGTH = "length";
	private static final String PARAM_NAME_WIDTH = "width";
	private static final String PARAM_NAME_HEIGHT = "height";

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		String page = null;
		String weight = request.getParameter(PARAM_NAME_WEIGHT);
		String length = request.getParameter(PARAM_NAME_LENGTH);
		String width = request.getParameter(PARAM_NAME_WIDTH);
		String height = request.getParameter(PARAM_NAME_HEIGHT);
		
		
		
		return null;
	}

}
