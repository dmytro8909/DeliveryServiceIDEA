package logic;

public class LoginLogic {
//	private static DBManager dbManager = new DBManager();
//	private static final String LOGIN = dbManager.getUserLogin();
//	private static final String PASS = dbManager.getUserPassword();
	
	public static boolean checkLogin(String enterLogin, String enterPass) {
		return !"".equals(enterLogin) && !"".equals(enterPass);
	}
}
