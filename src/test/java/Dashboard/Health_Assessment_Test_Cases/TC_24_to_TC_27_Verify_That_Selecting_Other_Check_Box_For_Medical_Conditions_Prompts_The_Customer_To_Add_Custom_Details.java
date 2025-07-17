package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_24_to_TC_27_Verify_That_Selecting_Other_Check_Box_For_Medical_Conditions_Prompts_The_Customer_To_Add_Custom_Details extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_24_Verify_that_selecting_other_check_box_for_medical_conditions_prompts_the_customer_to_add_custom_details() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.submitAssessmentForm2();
		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.verifyMedicalConditionOthersDescTextBox();
	}
	
	@Test(dependsOnMethods = "TC_24_Verify_that_selecting_other_check_box_for_medical_conditions_prompts_the_customer_to_add_custom_details")
	public void TC_25_Validate_text_input_box_allows_to_enter_details_in_the_medical_condition_section() {
		health_assessment_actions.verifyFunctionalityOfMedicalConditionTxtBox();
	}
	
	@Test(dependsOnMethods = "TC_25_Validate_text_input_box_allows_to_enter_details_in_the_medical_condition_section")
	public void TC_26_Verify_that_selecting_other_check_box_for_medication_prompts_the_customer_to_add_custom_details() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyMedicationOthersDescTextBox();
	}
	
	@Test(dependsOnMethods = "TC_26_Verify_that_selecting_other_check_box_for_medication_prompts_the_customer_to_add_custom_details")
	public void TC_27_Validate_text_input_box_allows_to_enter_details_in_the_medications_section() {
		health_assessment_actions.verifyFunctionalityOfMedicationTxtBox();
	}
	
}
