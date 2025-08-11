package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_02_TC_40_Verify_Auto_Population_Of_Secondary_Barcode extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	
	@Test
	public void TC_40_Generate_primary_secondary_barcodes() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboard();
		activate_test_kit_Actions.createDoubleBarcodeFromTimsToUseInDashboard();
	}
	
	@Test (dependsOnMethods = "TC_40_Generate_primary_secondary_barcodes")
	public void TC_02_Verify_auto_population_of_secondary_barcode_for_test_kits_with_two_barcodes() throws Exception
	{				
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.autoPopulationOfSecondaryBarcodeForTestKitsWithTwoBarcodes();
		
    }

}
