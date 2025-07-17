package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_06_Verify_Login_With_Invalid_Email_Format extends BaseClass{
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_06_Verify_login_with_invalid_Email_format() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.invalidEmail();
	}
}
