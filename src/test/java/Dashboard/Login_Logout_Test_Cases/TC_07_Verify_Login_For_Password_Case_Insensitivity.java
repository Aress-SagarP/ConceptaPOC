package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_07_Verify_Login_For_Password_Case_Insensitivity extends BaseClass {

	Login_Action Login_action;
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_07_Verify_login_for_password_case_insensitivity() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.passwordCaseSensitivity();
	}
}
