package commands;
import exception.AppException;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface ActionCommand {
	String execute(HttpServletRequest request) throws AppException, ParseException;
}
