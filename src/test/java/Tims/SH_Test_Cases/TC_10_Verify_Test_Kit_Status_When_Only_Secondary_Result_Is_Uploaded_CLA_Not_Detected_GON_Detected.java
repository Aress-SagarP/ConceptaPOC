package Tims.SH_Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import initializer.BaseClass;

public class TC_10_Verify_Test_Kit_Status_When_Only_Secondary_Result_Is_Uploaded_CLA_Not_Detected_GON_Detected extends BaseClass{
	
	SH_Locators sh_locators;
	SH_Actions sh_actions;
	
	@Test
	public void TC_10_Verify_test_kit_status_when_only_secondary_result_is_uploaded_CLA_not_detected_GON_detected() throws Exception  {
					
		sh_actions = new SH_Actions(getDriver());		
		sh_actions.TimsUrl();	
		sh_actions.createBarcodes();
		sh_actions.dashboardLogin();
		sh_actions.activateKitJourney();
		sh_actions.healthAssessmentJourney();
		sh_actions.TimsUrl();	
		sh_actions.markAsReceivedJourney("Lavender case 10.csv", "MBT-SAA-3423", "Barcode2");
		sh_actions.getStatus("processing", "processing", "results-ready");
		sh_actions.getTestReport();
		
	}

}
