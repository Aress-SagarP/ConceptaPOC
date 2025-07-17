package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_32_TC_33_Verify_Ability_To_Fill_The_Health_Assessment_After_Sample_Reach_To_Lab_For_Blood_Hormone_Tests extends BaseClass{
	
	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_32_Verify_ability_to_fill_the_health_assessment_after_sample_reach_to_lab_for_blood_hormone_tests() throws IOException, InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.fillAssessmentAfterSampleReachLab();
	}
	
	@Test(dependsOnMethods = "TC_32_Verify_ability_to_fill_the_health_assessment_after_sample_reach_to_lab_for_blood_hormone_tests")
	public void TC_33_Verify_ability_to_edit_and_save_the_health_assessment_after_sample_reach_to_lab_for_blood_hormone_tests() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.editAssessmentAfterSampleReachLab();
	}
}
