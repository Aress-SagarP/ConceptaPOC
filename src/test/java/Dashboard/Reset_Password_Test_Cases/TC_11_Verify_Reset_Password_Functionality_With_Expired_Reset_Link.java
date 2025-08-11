package Dashboard.Reset_Password_Test_Cases;
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

public class TC_11_Verify_Reset_Password_Functionality_With_Expired_Reset_Link extends BaseClass {
	
	
	Reset_Password_Locators reset_password_locators;
	Reset_Password_Actions reset_password_actions;
	
	@Test
	public void TC_11_Verify_reset_password_functionality_with_expired_reset_link() throws Exception{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());			
		reset_password_actions.resetPasswordFunctionalityWithExpiredResetLink();
		
	}

}
