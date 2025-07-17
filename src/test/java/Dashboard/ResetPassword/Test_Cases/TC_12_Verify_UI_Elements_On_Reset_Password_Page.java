package Dashboard.ResetPassword.Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Reset_Password_Actions;
import Test.Dashboard.Locators_Class.Reset_Password_Locators;
import initializer.BaseClass;

public class TC_12_Verify_UI_Elements_On_Reset_Password_Page extends BaseClass {
	
	
	Reset_Password_Locators reset_password_locators;
	Reset_Password_Actions reset_password_actions;
	
	@Test
	public void TC_12_Verify_ui_elements_on_reset_password_page_present_or_not() throws Exception{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.dashboardUrl();
		reset_password_actions.resetPasswordUIElementsOnResetPasswordPagePresentOrNot();
		
	}

}
