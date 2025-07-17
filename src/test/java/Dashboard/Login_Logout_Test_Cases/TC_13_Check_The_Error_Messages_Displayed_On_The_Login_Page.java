package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_13_Check_The_Error_Messages_Displayed_On_The_Login_Page extends BaseClass {

	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_13_Check_the_error_messages_displayed_on_the_login_page() throws IOException, InterruptedException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.incorrectEmailPassword();
		login_boot_actions.passwordCaseSensitivity();
	}
}
