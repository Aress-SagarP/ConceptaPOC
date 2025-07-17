package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_42_Verify_The_Successful_Health_Assessment_Filling_For_DNA_Test extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_42_Verify_the_successful_health_assessment_filling_for_DNA_test() throws IOException, InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifySuccessfulHealthAssessmentForDNATest();
	}
}
