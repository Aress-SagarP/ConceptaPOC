package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_09_To_TC_18_Verify_Activate_Kit_Process extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	@Test
	public void TC_09_Verify_that_consent_check_boxes_are_mandatory_feilds() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.dashboardUrl();		
		activate_test_kit_Actions.consentCheckboxesAreMandatoryFeilds();
		
	}
	
	@Test(dependsOnMethods = "TC_09_Verify_that_consent_check_boxes_are_mandatory_feilds")
	public void TC_10_Verify_user_redirected_to_detials_page_after_marking_consent_checkboxes() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.userRedirectedToDetialsPageAfterMarkingConsentCheckboxes();
		
	}

	@Test(dependsOnMethods = "TC_10_Verify_user_redirected_to_detials_page_after_marking_consent_checkboxes")
	public void TC_11_Verify_data_auto_populate_on_personal_details_page() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.dataAutoPopulateOnPersonalDetailsPage();
		
	}
	
	@Test(dependsOnMethods = "TC_11_Verify_data_auto_populate_on_personal_details_page")
	public void TC_12_Verify_ability_to_edit_personal_details() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.abilityToEditPersonalDetails();
		
	}
	
	@Test(dependsOnMethods = "TC_12_Verify_ability_to_edit_personal_details")
	public void TC_13_Verify_continue_button_redirects_to_how_to_page() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.howToPageRedirected();
		
	}
	
	@Test(dependsOnMethods = "TC_13_Verify_continue_button_redirects_to_how_to_page")
	public void TC_14_Verify_content_of_how_to_page() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());			
		activate_test_kit_Actions.contentOfHowToPage();
		
	}
	
	@Test(dependsOnMethods = "TC_14_Verify_content_of_how_to_page")
	public void TC_15_Verify_navigate_back_to_how_to_page_from_any_step_in_the_activation_process() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.navigateBackToHowToPageFromAnyStepInTheActivationProcess();
		
	}
	
	@Test(dependsOnMethods = "TC_15_Verify_navigate_back_to_how_to_page_from_any_step_in_the_activation_process")
	public void TC_16_Verify_check_date_functionality_of_more_than_16_days() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.checkDateFunctionalityOfMoreThan16Days();
		
	}
	
	@Test(dependsOnMethods = "TC_16_Verify_check_date_functionality_of_more_than_16_days")
	public void TC_17_Verify_date_functionality_of_current_date_and_proceed() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.selectCurrentDateAndProceed();
		
	}
	

	@Test(dependsOnMethods = "TC_17_Verify_date_functionality_of_current_date_and_proceed")
	public void TC_18_Verify_test_activation_kit_success_email() throws Exception
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());				
		activate_test_kit_Actions.testActivationKitSuccessEmail();
		
	}
	
	
	
	

}
