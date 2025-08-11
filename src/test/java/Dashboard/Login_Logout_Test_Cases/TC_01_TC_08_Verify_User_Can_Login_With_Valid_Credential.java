package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_01_TC_08_Verify_User_Can_Login_With_Valid_Credential extends BaseClass {	

	Login_Boot_Locators login_boot_locators;
	Login_Action Login_action;

	@Test
	public void TC_01_Verify_user_can_login_with_valid_credential() throws IOException, InterruptedException {

		Login_Boot_Actions login_boot_actions;
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.successfulLogin();
	}

	@Test(dependsOnMethods = "TC_01_Verify_user_can_login_with_valid_credential")
	public void TC_08_Verify_logout_functionality() throws IOException {

		Login_Boot_Actions login_boot_actions;
		Login_action = new Login_Action(getDriver());
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.successfulLogout();
	}
}
