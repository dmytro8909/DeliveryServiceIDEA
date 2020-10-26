package logic;

/**
 * Class for checking login
 */
public class LoginLogic {
	public static boolean checkLogin(String enterLogin, String enterPass) {
		return !"".equals(enterLogin) && !"".equals(enterPass);
	}
}
