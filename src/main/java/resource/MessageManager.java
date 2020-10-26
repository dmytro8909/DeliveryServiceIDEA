package resource;

import java.util.ResourceBundle;

/**
 * Class for working with messages.properties file
 */
public class MessageManager {
	private static final ResourceBundle resourceBundle = 
			ResourceBundle.getBundle("messages");
		
	private MessageManager() {}
	
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
