package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_30_TC_31_Verify_That_Fill_Health_Assessment_Change_After_Assessment_Completion extends BaseClass {
	
	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_30_Verify_that_fill_health_assessment_change_after_assessment_completion() throws InterruptedException, IOException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyFillAssessmentBtnChangeToEdit();
	}
	
	@Test(dependsOnMethods = "TC_30_Verify_that_fill_health_assessment_change_after_assessment_completion")
	public void TC_31_Verify_ability_to_fill_or_edit_and_save_the_health_assessment_before_sample_reach_to_lab_for_blood_test() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.editAssessmentBeforeSampleReachLab();
	}

}
