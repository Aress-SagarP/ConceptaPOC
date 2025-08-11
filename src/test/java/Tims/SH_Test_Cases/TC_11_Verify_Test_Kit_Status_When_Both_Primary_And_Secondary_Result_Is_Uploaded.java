package Tims.SH_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.SH_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import initializer.BaseClass;

public class TC_11_Verify_Test_Kit_Status_When_Both_Primary_And_Secondary_Result_Is_Uploaded extends BaseClass{

	SH_Locators sh_locators;
	SH_Actions sh_actions;
	
	@Test
	public void TC_11_Verify_test_kit_status_when_both_primary_and_secondary_result_is_uploaded() throws IOException, InterruptedException {
		
		sh_actions = new SH_Actions(getDriver());		
		sh_actions.TimsUrl();	
		sh_actions.createBarcodes();
		sh_actions.dashboardLogin();
		sh_actions.activateKitJourney();
		sh_actions.healthAssessmentJourney();
		sh_actions.TimsUrl();	
		sh_actions.markAsReceivedBothResultsUploaded("Gold case 2.csv", "Lavender case 10.csv", "MGT-MBM-4422", "Barcode1");
		sh_actions.getStatus("results-ready", "results-ready", "results-ready");
		sh_actions.getTestReportBothResultsUploaded();
		
	}
}
