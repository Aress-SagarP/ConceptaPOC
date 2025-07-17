package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_05_Verify_Login_With_Empty_Password_Field extends BaseClass{
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_05_Verify_login_with_empty_password_field() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.emptyPasswordLogin();
	}
}
