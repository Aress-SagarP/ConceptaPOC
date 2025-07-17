package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;


public class TC_04_Verify_Login_With_Empty_Email_Field extends BaseClass {
	Login_Action login_action;
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_04_Verify_login_with_empty_email_field() throws IOException, InterruptedException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.emptyEmailLogin();
	}
}
