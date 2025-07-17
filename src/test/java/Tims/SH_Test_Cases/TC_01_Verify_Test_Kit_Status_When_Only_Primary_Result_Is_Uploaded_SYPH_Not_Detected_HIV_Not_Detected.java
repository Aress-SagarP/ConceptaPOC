package Tims.SH_Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import initializer.BaseClass;


public class TC_01_Verify_Test_Kit_Status_When_Only_Primary_Result_Is_Uploaded_SYPH_Not_Detected_HIV_Not_Detected extends BaseClass {
	
	SH_Locators sh_locators;
	SH_Actions sh_actions;
	
	@Test
	public void TC_01_Verify_test_kit_status_when_only_primary_result_is_uploaded_SYPH_not_detected_HIV_not_detected() throws Exception  {
			
		sh_actions = new SH_Actions(getDriver());		
		sh_actions.TimsUrl();	
		sh_actions.createBarcodes();
		sh_actions.dashboardLogin();
		sh_actions.activateKitJourney();
		sh_actions.healthAssessmentJourney();
		sh_actions.TimsUrl();	
		sh_actions.markAsReceivedJourney("Gold case 1.csv", "MGI-ROQ-3295", "Barcode1");
		sh_actions.getStatus("processing", "results-ready", "processing");
		sh_actions.getTestReport();
		
	}
	
}
