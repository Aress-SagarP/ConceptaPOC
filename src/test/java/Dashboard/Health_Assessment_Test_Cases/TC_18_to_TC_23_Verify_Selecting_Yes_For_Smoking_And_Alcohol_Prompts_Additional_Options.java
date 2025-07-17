package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_18_to_TC_23_Verify_Selecting_Yes_For_Smoking_And_Alcohol_Prompts_Additional_Options extends BaseClass{
	
	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_18_Verify_selecting_Yes_for_smoking_habits_prompts_additional_options() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.verifyAdditionalOptionsSmoking_TC_05();
	}
	
	@Test(dependsOnMethods = "TC_18_Verify_selecting_Yes_for_smoking_habits_prompts_additional_options")
	public void TC_19_Verify_selecting_Yes_for_alcohol_prompts_additional_options() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptionsAlcohol_TC_06();
	}
	
	@Test(dependsOnMethods = "TC_18_Verify_selecting_Yes_for_smoking_habits_prompts_additional_options")
	public void TC_20_Verify_validation_on_conditional_fields() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyValidationConditionalFields();
	}
	
	@Test(dependsOnMethods = "TC_20_Verify_validation_on_conditional_fields")
	public void TC_21_Verify_selecting_Yes_for_exercise_details_prompts_additional_options () {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptionsPhysicalActivity();
	}
	
	@Test(dependsOnMethods = "TC_21_Verify_selecting_Yes_for_exercise_details_prompts_additional_options")
	public void TC_22_Verify_that_selecting_Yes_for_medical_conditions_prompts_additional_options() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptionsMedicalConditions();
	}
	
	@Test(dependsOnMethods="TC_22_Verify_that_selecting_Yes_for_medical_conditions_prompts_additional_options")
	public void TC_23_Verify_that_selecting_Yes_for_medications_prompts_the_customer_to_select_additional_options() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptionsMedications();
	}
	
}
