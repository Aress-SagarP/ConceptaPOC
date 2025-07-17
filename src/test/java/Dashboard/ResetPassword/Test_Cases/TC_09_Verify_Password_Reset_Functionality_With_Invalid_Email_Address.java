package Dashboard.ResetPassword.Test_Cases;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Test.Hcp.Actions_Class.Login_Health_Professional_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Reset_Password_Actions;
import Test.Dashboard.Locators_Class.Reset_Password_Locators;

import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_09_Verify_Password_Reset_Functionality_With_Invalid_Email_Address extends BaseClass {
	
	
	Reset_Password_Locators reset_password_locators;
	Reset_Password_Actions reset_password_actions;
	
	@Test
	public void TC_09_Verify_password_reset_functionality_with_invalid_Email_address() throws Exception{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.dashboardUrl();
		reset_password_actions.resetPasswordFunctionalityWithInvalidEmailAddress();
		
	}

}
