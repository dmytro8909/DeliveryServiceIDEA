package resource;

import java.util.ResourceBundle;

/**
 * Class for working with config.properties file
 */
public class ConfigurationManager {
	private static final ResourceBundle resourceBundle = 
			ResourceBundle.getBundle("config");
	
	private ConfigurationManager() {}
	
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
