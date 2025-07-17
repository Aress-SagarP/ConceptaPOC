package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_02_TC_03_Verify_Login_With_Invalid_Email_And_Password extends BaseClass {
	Login_Action login_action;
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_02_Verify_login_with_invalid_email_and_password() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.incorrectEmailPassword();
	}
	
	@Test(dependsOnMethods = "TC_02_Verify_login_with_invalid_email_and_password")
	public void TC_03_Verify_error_message_with_incorrect_email() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.incorrectEmailPassword();
	}

}
