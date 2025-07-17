package Tims.SH_Test_Cases;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import initializer.BaseClass;

public class TC_07_Verify_Test_Kit_Status_When_Only_Secondary_Result_Is_Uploaded_CLA_Detected_GON_Unconfirmed_Reactive extends BaseClass{
	
	SH_Locators sh_locators;
	SH_Actions sh_actions;
	
	@Test
	public void TC_07_Verify_test_kit_status_when_only_secondary_result_is_uploaded_CLA_detected_GON_unconfirmed_reactive() throws Exception  {
					
		sh_actions = new SH_Actions(getDriver());		
		sh_actions.TimsUrl();	
		sh_actions.createBarcodes();
		sh_actions.dashboardLogin();
		sh_actions.activateKitJourney();
		sh_actions.healthAssessmentJourney();
		sh_actions.TimsUrl();	
		sh_actions.markAsReceivedJourney("Lavender case 7.csv", "MBY-HJZ-7056", "Barcode2");
		sh_actions.getStatus("processing", "processing", "results-ready");
		sh_actions.getTestReport();
		
	}

}
