package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_11_to_TC_17_Verify_The_Successful_Health_Assessment_Filling_For_Blood_SH_Test extends BaseClass{

	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_11_Verify_that_sexual_health_test_contains_additional_step_in_health_assessment() throws InterruptedException, IOException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalStepForSexualHealth();
	}
	
	@Test(dependsOnMethods = "TC_11_Verify_that_sexual_health_test_contains_additional_step_in_health_assessment")
	public void TC_12_Verify_that_selecting_Yes_for_sexual_activeness_prompts_additional_options_for_SH_Test() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptsForSexualActiveness();
	}
	
	@Test(dependsOnMethods = "TC_12_Verify_that_selecting_Yes_for_sexual_activeness_prompts_additional_options_for_SH_Test")
	public void TC_13_Verify_that_selecting_Yes_for_unprotected_sex_prompts_additional_options_for_SH_Test() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptsForUnprotectedSex();
	}
	
	@Test(dependsOnMethods = "TC_13_Verify_that_selecting_Yes_for_unprotected_sex_prompts_additional_options_for_SH_Test")
	public void TC_14_Verify_that_selecting_Yes_for_symptoms_prompts_additional_options_for_SH_Test() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptsForSymptoms();
	}
	
	@Test(dependsOnMethods = "TC_14_Verify_that_selecting_Yes_for_symptoms_prompts_additional_options_for_SH_Test")
	public void TC_15_Verify_that_selecting_Yes_for_STI_prompts_additional_options_for_SH_Test() throws InterruptedException{
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyAdditionalOptsForSTI();
	}
	
	@Test(dependsOnMethods = "TC_15_Verify_that_selecting_Yes_for_STI_prompts_additional_options_for_SH_Test")
	public void TC_16_Verify_the_successful_health_assessment_filling_for_blood_SH_test() throws InterruptedException, IOException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.successfullHealthAssessmentForSexualHealthTest();
	}
	
	@Test(dependsOnMethods = "TC_16_Verify_the_successful_health_assessment_filling_for_blood_SH_test")
	public void TC_17_Verify_the_successful_health_assessment_filling_for_blood_SH_test_with_the_option_as_Yes_for_applicable_fields() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.successfullHAForSHTestYesOption();
	}
	
}
