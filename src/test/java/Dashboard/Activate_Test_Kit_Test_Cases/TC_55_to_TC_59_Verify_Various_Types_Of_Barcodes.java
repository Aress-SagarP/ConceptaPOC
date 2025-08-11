package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_55_to_TC_59_Verify_Various_Types_Of_Barcodes extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	@Test
	public void TC_55_Verify_various_types_of_barcodes() throws Exception
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createMultipleBarcodes("Boots","blood","Gold","MG");
		activate_test_kit_Actions.createMultipleBarcodes("Boots","blood","Phlebotomy gold","PG");
		activate_test_kit_Actions.createMultipleBarcodes("Boots","blood","Lavender","ML");
		activate_test_kit_Actions.createMultipleBarcodes("Boots","blood","Blue","MB");
		activate_test_kit_Actions.createMultipleBarcodes("Boots","blood","Phlebotomy lavender","PL");
		activate_test_kit_Actions.createMultipleBarcodes("Boots private label","blood","Gold","BG");
		activate_test_kit_Actions.createMultipleBarcodes("Boots private label","blood","Lavender","BL");
		activate_test_kit_Actions.uploadCSVForMultipleBarcodes();
		activate_test_kit_Actions.activateKitMultipleBarcodeSingle();
		//activate_test_kit_Actions.dashboardUrl();
		//activate_test_kit_Actions.successfulActivationOfATestKitUsingValidInputs();
	}
	
	@Test(dependsOnMethods = "TC_55_Verify_various_types_of_barcodes")
	public void TC_56_Verify_Boots_Private_Single_Barcode() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.activateKitMultipleBarcodeSingleBootsPrivate();
	}
	
	@Test(dependsOnMethods = "TC_56_Verify_Boots_Private_Single_Barcode")
	public void TC_57_Verify_Double_Barcode() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.activateKitMultipleBarcodeDouble();
	}
	
	@Test(dependsOnMethods = "TC_57_Verify_Double_Barcode")
	public void TC_58_Verify_Boots_Private_Double_Barcode() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.activateKitMultipleBarcodeBootsPrivateDouble();
	}
	
	@Test(dependsOnMethods = "TC_58_Verify_Boots_Private_Double_Barcode")
	public void TC_59_Verify_Activate_Kit_Double_Barcode_Blue() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.activateKitMultipleBarcodeDoubleBlue();
	}

}
