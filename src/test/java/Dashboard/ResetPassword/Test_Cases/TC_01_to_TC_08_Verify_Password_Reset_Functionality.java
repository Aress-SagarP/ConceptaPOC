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
public class TC_01_to_TC_08_Verify_Password_Reset_Functionality extends BaseClass {
	
	
	Reset_Password_Locators reset_password_locators;
	Reset_Password_Actions reset_password_actions;
	
	@Test
	public void TC_01_Verify_forgot_password_link_enabled_or_not() throws Exception{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.dashboardUrl();
		reset_password_actions.resetPasswordForgotPasswordLinkEnabledOrNot();
		
	}

	@Test(dependsOnMethods = {"TC_01_Verify_forgot_password_link_enabled_or_not"})
	public void TC_02_Verify_behavior_when_user_keep_email_address_field_empty_during_password_reset_process() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordBehaviorWhenUserKeepEmailAddressFieldEmptyDuringThisProcess();
		
	}
	
	@Test(dependsOnMethods = {"TC_02_Verify_behavior_when_user_keep_email_address_field_empty_during_password_reset_process"})
	public void TC_03_Verify_navigation_of_password_reset_link_available_in_email() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordNavigationOfPasswordResetLinkAvailableInEmail();
		
	}
	
	@Test(dependsOnMethods = {"TC_03_Verify_navigation_of_password_reset_link_available_in_email"})
	public void TC_04_Verify_reset_password_without_password() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordWithoutPassword();
		
	}
	
	@Test(dependsOnMethods = {"TC_04_Verify_reset_password_without_password"})
	public void TC_05_Verify_password_complexity() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordComplexity();
		
	}
	
	@Test(dependsOnMethods = {"TC_05_Verify_password_complexity"})
	public void TC_06_Verify_system_prevents_users_from_reusing_old_passwords_when_resetting() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordSystemPreventsUsersFromReusingOldPasswordsWhenResetting();
		
	}
	
	@Test(dependsOnMethods = {"TC_06_Verify_system_prevents_users_from_reusing_old_passwords_when_resetting"})
	public void TC_07_Verify_password_reset_functionality_with_valid_email_address() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordFunctionalityWithValidEmailAddress();
		
	}
	@Test(dependsOnMethods = {"TC_07_Verify_password_reset_functionality_with_valid_email_address"})
	public void TC_08_Verify_successful_login_after_resetting_new_password() throws Exception
	{
		
		Reset_Password_Actions reset_password_actions;			
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.resetPasswordSuccessfulLoginAfterResettingNewPassword();
		
	}
	
}
