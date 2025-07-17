package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_08_TC_09_TC_10_Verify_The_Successful_Health_Assessment_Filling_For_Blood_Hormone_Test extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_08_Verify_that_blood_hormone_test_contains_additional_step_in_health_assessment() throws InterruptedException, IOException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyMenstrualCyclePageIsDisplayed();
	}
	
	@Test(dependsOnMethods = "TC_08_Verify_that_blood_hormone_test_contains_additional_step_in_health_assessment")
	public void TC_09_Verify_the_successful_health_assessment_filling_for_blood_hormone_test() throws InterruptedException, IOException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.successfulHealthAssessmentBloodHormoneTest();
	}
	
	@Test(dependsOnMethods = "TC_09_Verify_the_successful_health_assessment_filling_for_blood_hormone_test")
	public void TC_10_Verify_successful_health_assessment_filling_for_blood_hormone_test_with_option_as_Yes_for_applicable_fields() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.successfulHealthAssessmentBloodHormoneTestOptionYes();
	}
	
	
}
