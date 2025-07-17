package Dashboard.Login_Logout_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_11_TC_12_Check_The_Element_Visibility_On_Login_Page extends BaseClass{

	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_11_Check_the_element_visibility_on_login_page() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.visibilityOfLoginPageElements();
	}
	
	@Test(dependsOnMethods = "TC_11_Check_the_element_visibility_on_login_page")
	public void TC_12_Check_the_display_of_labels_and_titles_on_login_page() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		login_boot_actions.visibilityOfLoginPageElements();
	}
}
