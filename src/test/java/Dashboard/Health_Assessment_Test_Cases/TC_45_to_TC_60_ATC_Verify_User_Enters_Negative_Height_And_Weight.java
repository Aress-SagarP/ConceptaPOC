package Dashboard.Health_Assessment_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import initializer.BaseClass;

public class TC_45_to_TC_60_ATC_Verify_User_Enters_Negative_Height_And_Weight extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	Health_Assessment_Actions health_assessment_actions;
	
	@Test
	public void TC_45_ATC_Verify_user_enters_negative_height_and_weight() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		customer_landing_actions.generateSingleBarcode("Thyroid Profile Test");
		customer_landing_actions.activateTestKit();
		health_assessment_actions.verifyNegativeHeightAndWeight();
	}
	
	@Test(dependsOnMethods = "TC_45_ATC_Verify_user_enters_negative_height_and_weight")
	public void TC_46_ATC_Verify_max_height_and_weight_allowed_for_the_user() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyUnrealisticHeightWeight();
	}
	
	@Test(dependsOnMethods = "TC_46_ATC_Verify_max_height_and_weight_allowed_for_the_user")
	public void TC_47_ATC_Verify_dropdown_options_for_Do_you_smoke_cigarettes() throws InterruptedException{
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForSmokeCigarettes();
	}
	
	@Test(dependsOnMethods = "TC_47_ATC_Verify_dropdown_options_for_Do_you_smoke_cigarettes")
	public void TC_48_ATC_Verify_dropdown_options_for_How_many_cigarettes_do_you_smoke_each_day() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForNumOfCigerettes();
	}
	
	@Test(dependsOnMethods = "TC_48_ATC_Verify_dropdown_options_for_How_many_cigarettes_do_you_smoke_each_day")
	public void TC_49_ATC_Verify_dropdown_options_for_Do_you_drink_alcohol() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForDrinkAlcohol();
	}
	
	@Test(dependsOnMethods = "TC_49_ATC_Verify_dropdown_options_for_Do_you_drink_alcohol")
	public void TC_50_ATC_Verify_dropdown_options_for_How_many_units_do_you_drink_each_week() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForAlcoholCount();
	}
	
	@Test(dependsOnMethods = "TC_50_ATC_Verify_dropdown_options_for_How_many_units_do_you_drink_each_week")
	public void TC_51_Verify_error_message_is_displayed_when_Smoking_and_Alcohol_status_left_empty() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyCigarettesAlcoholStatusIsMandatory();
	}
	
	@Test(dependsOnMethods = "TC_51_Verify_error_message_is_displayed_when_Smoking_and_Alcohol_status_left_empty")
	public void TC_52_Verify_error_message_is_displayed_when_Smoking_and_Alcohol_count_left_empty() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifySmokeAndAlcoholCountFieldIsMandatory();
	}
	
	@Test(dependsOnMethods = "TC_52_Verify_error_message_is_displayed_when_Smoking_and_Alcohol_count_left_empty")
	public void TC_53_Verify_dropdown_options_for_Do_you_do_any_physical_activity() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForPhysicalActivity();
	}
	
	@Test(dependsOnMethods = "TC_53_Verify_dropdown_options_for_Do_you_do_any_physical_activity")
	public void TC_54_Verify_error_messages_for_empty_fields_physical_activity_page() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyPhysicalActivityIsMandatory();
	}
	
	@Test(dependsOnMethods = "TC_54_Verify_error_messages_for_empty_fields_physical_activity_page")
	public void TC_55_Verify_dropdown_options_for_medical_condition(){
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyDrpOptionsForMedicalCondition();
	}
	
	@Test(dependsOnMethods = "TC_55_Verify_dropdown_options_for_medical_condition")
	public void TC_56_Verify_error_messages_on_medical_conditions_page() throws InterruptedException {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyErrorMsgForMedicalConditions();
	}
	
	@Test(dependsOnMethods = "TC_56_Verify_error_messages_on_medical_conditions_page")
	public void TC_57_Verify_list_of_medical_conditions_is_correct() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyListOfMedicalConditions();
	}
	
	@Test(dependsOnMethods = "TC_57_Verify_list_of_medical_conditions_is_correct")
	public void TC_58_Verify_dropdown_options_for_medications() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyMedicationDrpOptions();
	}
	
	@Test(dependsOnMethods = "TC_58_Verify_dropdown_options_for_medications")
	public void TC_59_Verify_error_messages_on_medications_page() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyErrorMessageMedication();
	}
	
	@Test(dependsOnMethods = "TC_59_Verify_error_messages_on_medications_page")
	public void TC_60_Verify_list_of_medications_is_correct() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyMedicationList();
	}
	
}
