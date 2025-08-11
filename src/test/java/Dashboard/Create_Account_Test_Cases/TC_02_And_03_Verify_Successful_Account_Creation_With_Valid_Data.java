package Dashboard.Create_Account_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Create_Account_Actions;
import Test.Dashboard.Locators_Class.Create_Account_Locators;
import initializer.BaseClass;

public class TC_02_And_03_Verify_Successful_Account_Creation_With_Valid_Data extends BaseClass
{

	Create_Account_Locators create_account_locators;
	Create_Account_Actions create_account_actions;
	
	@Test
	public void TC_02_Verify_successful_account_creation_with_valid_data() throws Exception
	{				
		create_account_actions = new Create_Account_Actions(getDriver());		
		create_account_actions.dashboardUrl();
		create_account_actions.createAccount();
    }
	
	@Test(dependsOnMethods = "TC_02_Verify_successful_account_creation_with_valid_data")
	public void TC_03_Verify_account_created_via_email_link() throws Exception
	{   Create_Account_Actions create_account_actions;
		create_account_actions = new Create_Account_Actions(getDriver());
		create_account_actions.validateEmailLink();
	}

}
