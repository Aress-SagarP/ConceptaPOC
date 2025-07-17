package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_01_to_07_Verify_The_Successful_Health_Assessment_Filling_For_Normal_Blood_Test extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_01_Verify_the_successful_health_assessment_filling_for_normal_blood_test() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.submitAssessmentForm2();
		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.submitAssessmentForm5();
	}
	
	@Test(dependsOnMethods = "TC_01_Verify_the_successful_health_assessment_filling_for_normal_blood_test")
	public void TC_02_Verify_users_can_select_multiple_checkboxes_for_disease_types() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifySelectionOfMultipleChkboxesdiseases();
	}
	
	@Test(dependsOnMethods = "TC_01_Verify_the_successful_health_assessment_filling_for_normal_blood_test")
	public void TC_03_Verify_upon_submission_of_the_health_assessment_the_user_is_presented_with_a_summary_or_confirmation_page() {
		health_assessment_actions.verifyAssessmentSubmissionPageIsDisplayed();
	}
	
	@Test(dependsOnMethods = "TC_03_Verify_upon_submission_of_the_health_assessment_the_user_is_presented_with_a_summary_or_confirmation_page")
	public void TC_04_Verify_the_presence_and_functionality_of_the_fill_edit_assessment_button() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyEditBtnFunctionalityHealthAssessment();
	}
	
	@Test(dependsOnMethods = "TC_04_Verify_the_presence_and_functionality_of_the_fill_edit_assessment_button")
	public void TC_05_Validate_the_data_displayed_on_the_assessment_summary_page_matches_the_data_entered() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyCorrectDetailsOnAssessmentSummary();
	}
	
	@Test(dependsOnMethods = "TC_04_Verify_the_presence_and_functionality_of_the_fill_edit_assessment_button")
	public void TC_06_Verify_if_the_user_navigates_to_an_existing_health_assessment_the_previously_saved_data_is_displayed_correctly() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyPreviouslySavedDataIsDisplayedCorrectly();
	}
	
	@Test(dependsOnMethods = "TC_06_Verify_if_the_user_navigates_to_an_existing_health_assessment_the_previously_saved_data_is_displayed_correctly")
	public void TC_07_Verify_the_ability_to_edit_and_save_each_field_in_the_health_assessment() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.editAssessmentDetails();
	}
	
}
