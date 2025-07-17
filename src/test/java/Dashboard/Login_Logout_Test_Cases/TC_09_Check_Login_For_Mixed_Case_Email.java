package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_09_Check_Login_For_Mixed_Case_Email extends BaseClass {

	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_09_Check_login_for_mixed_case_email() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.emailCaseSensitivity();
	}

}
