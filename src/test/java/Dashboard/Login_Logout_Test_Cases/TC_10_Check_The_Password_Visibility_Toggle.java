package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_10_Check_The_Password_Visibility_Toggle extends BaseClass{

	Login_Action login_action;
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_10_Check_the_password_visibility_toggle() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.passwordVisibilityToggle();
	}
}
