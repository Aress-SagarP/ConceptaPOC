package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_01_Verify_The_Presence_Of_Create_Blood_Batch_Button_On_The_Barcode_Batches_Page extends BaseClass{

	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_01_Verify_the_presence_of_create_blood_batch_button_on_the_barcode_batches_page() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceofCreateBloodBatchBtn();
	}
	
	@Test(dependsOnMethods = "TC_01_Verify_the_presence_of_create_blood_batch_button_on_the_barcode_batches_page")
	public void TC_02_Verify_that_clicking_the_create_blood_batch_button_opens_the_form() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyOpeningOfCreateBloodBatchForm();
	}
	
	@Test(dependsOnMethods = "TC_02_Verify_that_clicking_the_create_blood_batch_button_opens_the_form")
	public void TC_03_Verify_the_type_dropdown_contains_only_blood() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyTypeDrpContainsOnlyBlood();
	}
	
	@Test(dependsOnMethods = "TC_03_Verify_the_type_dropdown_contains_only_blood")
	public void TC_05_Verify_that_no_invalid_options_are_available_in_the_type_dropdown() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyNoInvalidOptsInTypeDrp();
	}
	
	@Test(dependsOnMethods = "TC_05_Verify_that_no_invalid_options_are_available_in_the_type_dropdown")
	public void TC_04_Verify_the_subtype_dropdown_contains_all_valid_options() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifySubTypeDrpValues();
	}
	
	@Test(dependsOnMethods = "TC_04_Verify_the_subtype_dropdown_contains_all_valid_options")
	public void TC_06_Verify_the_count_field_displays_the_help_text() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyHelpTextForCountField();
	}
	
	@Test(dependsOnMethods = "TC_06_Verify_the_count_field_displays_the_help_text")
	public void TC_08_Verify_the_comment_field_is_present_and_allows_input() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceAndFunctionalityOfCommentField();
	}
	
	@Test(dependsOnMethods = "TC_08_Verify_the_comment_field_is_present_and_allows_input")
	public void TC_09_Verify_the_Customer_dropdown() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCustomerDrpValues();
	}
	
	@Test(dependsOnMethods = "TC_09_Verify_the_Customer_dropdown")
	public void TC_10_Verify_the_system_displays_an_error_when_mandatory_fields_Type_Sub_Type_Count_are_left_empty() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyErrorMessageCreateBloodBatch();
	}
	
	@Test(dependsOnMethods = "TC_10_Verify_the_system_displays_an_error_when_mandatory_fields_Type_Sub_Type_Count_are_left_empty")
	public void TC_13_Verify_the_Cancel_button_closes_the_form_without_saving_changes() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCancelBtnFunctionality();
	}
	
}
