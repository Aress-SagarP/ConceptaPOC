package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_43_to_TC_54_ATC_Verify_The_Postage_Tracking_Number_Auto_Population extends BaseClass{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	@Test
	public void TC_43_Verify_the_postage_tracking_number_auto_population() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.verifyTrackingNumIsAutoPopulated();
	}
	
	@Test(dependsOnMethods = "TC_43_Verify_the_postage_tracking_number_auto_population")
	public void TC_44_Verify_the_auto_populated_value_does_not_overwrite_manual_input_on_refresh_if_unsaved() throws InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyTrackingNumOnPageRefresh();
	}
	
	@Test(dependsOnMethods = "TC_44_Verify_the_auto_populated_value_does_not_overwrite_manual_input_on_refresh_if_unsaved")
	public void TC_45_Verify_the_ability_to_proceed_further_without_entering_the_tracking_number() {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyJourneyWithoutEnteringTrackingNum();
	}
	
	@Test(dependsOnMethods = "TC_45_Verify_the_ability_to_proceed_further_without_entering_the_tracking_number")
	public void TC_46_Verify_the_ability_to_proceed_further_by_removing_the_auto_populated_tracking_number() throws InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyJourneyAfterRemovingTrackingNum();
	}
	
	@Test(dependsOnMethods = "TC_46_Verify_the_ability_to_proceed_further_by_removing_the_auto_populated_tracking_number")
	public void TC_47_Verify_the_ability_to_edit_and_save_the_auto_populated_tracking_number() throws InterruptedException {
		//activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		Health_Assessment_Actions healthActions = new Health_Assessment_Actions(getDriver());
		activate_test_kit_Actions = healthActions.activate_test_kit_actions;
		activate_test_kit_Actions.verifyAbilityToEditSaveTrackingNum();
	}
	
	@Test(dependsOnMethods = "TC_47_Verify_the_ability_to_edit_and_save_the_auto_populated_tracking_number")
	public void TC_48_Verify_the_ability_to_enter_and_save_the_tracking_number() throws InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyAbilityToEnterSaveTrackingNum();
	}
	
	@Test(dependsOnMethods = "TC_48_Verify_the_ability_to_enter_and_save_the_tracking_number")
	public void TC_49_Verify_the_display_of_confirmed_tracking_number_in_my_result_page() throws InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyTackingNumDisplayedMyResultsPage();
	}
	
	@Test(dependsOnMethods = "TC_49_Verify_the_display_of_confirmed_tracking_number_in_my_result_page")
	public void TC_50_Verify_the_display_of_confirmed_tracking_number_in_test_kit_page() throws InterruptedException {
		Customer_Landing_Actions customerActions = new Customer_Landing_Actions(getDriver());
		activate_test_kit_Actions = customerActions.activate_test_kit_actions;
		activate_test_kit_Actions.verifyTrackingNumOnTestKitPage();
	}
	
	@Test(dependsOnMethods = "TC_50_Verify_the_display_of_confirmed_tracking_number_in_test_kit_page")
	public void TC_51_Verify_the_tracking_number_field_is_non_editable() {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyTrackingNumIsNonEditable();
	}
	
	@Test(dependsOnMethods = "TC_51_Verify_the_tracking_number_field_is_non_editable")
	public void TC_52_Verify_the_field_label_display_on_dashboard_and_TIMS() throws IOException, InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyTrackingNumPlaceholder();
	}
	
	@Test(dependsOnMethods = "TC_52_Verify_the_field_label_display_on_dashboard_and_TIMS")
	public void TC_53_Verify_the_updated_tracking_number_display_in_TIMS() throws IOException, InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyTrackingNumDisplayedInTims();
	}
	
	@Test(dependsOnMethods = "TC_53_Verify_the_updated_tracking_number_display_in_TIMS")
	public void TC_54_Verify_the_display_of_confirmed_tracking_number_in_test_kit_information_page_on_TIMS() {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.verifyConfirmedTrackingNumOnTims();
	}
	
	
}
