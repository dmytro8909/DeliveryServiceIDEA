package commands;
import exception.AppException;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Interface for implementing which contains a method for
 * realizing specified business-logic for each command.
 */
public interface ActionCommand {
	String execute(HttpServletRequest request) throws AppException, ParseException;
}
