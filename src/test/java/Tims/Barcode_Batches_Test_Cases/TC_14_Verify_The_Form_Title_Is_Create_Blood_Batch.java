package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_14_Verify_The_Form_Title_Is_Create_Blood_Batch extends BaseClass{

	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_14_Verify_the_form_title_is_create_blood_batch() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.presenceOfCreateBloodBatchTitle();
	}
	
	@Test(dependsOnMethods = "TC_14_Verify_the_form_title_is_create_blood_batch")
	public void TC_11_Verify_successful_submission_of_blood_batch() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.sucessfulSubmissionBloodBatchForm();
	}
	
	@Test(dependsOnMethods = "TC_11_Verify_successful_submission_of_blood_batch")
	public void TC_12_Verify_the_toaster_after_successful_submission() {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.bloodBatchSuccessMsg();
	}
	
	
}
