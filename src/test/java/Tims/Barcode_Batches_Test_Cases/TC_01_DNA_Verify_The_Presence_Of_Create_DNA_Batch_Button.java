package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_01_DNA_Verify_The_Presence_Of_Create_DNA_Batch_Button extends BaseClass {
	
	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_01_DNA_Verify_the_presence_of_create_DNA_batch_button() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyPresenceOfCreateDNABatchBtn();
	}

	@Test(dependsOnMethods = "TC_01_DNA_Verify_the_presence_of_create_DNA_batch_button")
	public void TC_02_DNA_Verify_that_the_create_DNA_batch_button_opens_the_form() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyOpeningOfCreateDNABatchForm();
	}
	
	@Test(dependsOnMethods = "TC_02_DNA_Verify_that_the_create_DNA_batch_button_opens_the_form")
	public void TC_03_Verify_that_the_type_dropdown_has_the_wellness_option() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCreateDNABatchTypeDrpValues();
	}
	
	@Test(dependsOnMethods = "TC_03_Verify_that_the_type_dropdown_has_the_wellness_option")
	public void TC_04_Verify_that_the_sub_type_dropdown_has_the_correct_options() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCreateDNABatchSubTypeNonEditable();
	}
	
	@Test(dependsOnMethods = "TC_04_Verify_that_the_sub_type_dropdown_has_the_correct_options")
	public void TC_05_Verify_that_the_count_field_has_a_help_text() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyHelpTextForCountFieldDna();
	}
	
	@Test(dependsOnMethods = "TC_05_Verify_that_the_count_field_has_a_help_text")
	public void TC_06_Verify_that_the_count_field_only_accepts_numbers_and_greater_than_2() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyFunctionalityOfCountFieldDNA();
	}
	
	@Test(dependsOnMethods = "TC_06_Verify_that_the_count_field_only_accepts_numbers_and_greater_than_2")
	public void TC_07_Verify_dynamic_population_of_customer_dropdown() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCustomerDrpValuesDna();
	}
	
	@Test(dependsOnMethods = "TC_07_Verify_dynamic_population_of_customer_dropdown")
	public void TC_08_Verify_the_title_of_the_form_is_Create_DNA_batch() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceOfCreateDNABatchTitle();
	}
	
}
