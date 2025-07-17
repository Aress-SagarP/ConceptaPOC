package Test.Tims.Actions_Class;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import java.io.IOException;
import java.time.Duration;

import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Tims.Locators_Class.SH_Locators;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;

public class SH_Actions extends BaseClass {

	public WebDriver driver;
	SH_Locators sh_locators; 
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_actions;
	Health_Assessment_Locators health_assessment_locators;
	public static String Barcode1;
	public static String Barcode2;
	//public static String barcodeChoice;
	
	
	public SH_Actions(WebDriver driver) {
		this.driver = driver;
		sh_locators = new SH_Locators(driver);
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		activate_test_kit_actions = new Activate_Test_Kit_Actions(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
	}
	
	public void TimsUrl() throws IOException, InterruptedException {
		String urlKey = determineUrlKey("tims_URL_For_SH");
		driver.get(urlKey);
		WebTextBox.sendInput(sh_locators.get_emailTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafileTims, "tims_Login"));
		WebTextBox.sendInput(sh_locators.get_passwordTxt(), PropertiesReader
				.getPropertyValue(WebCommonPath.testDatafile, "tims_Password_For_Dashboard_Activate_Kit"));
		WebButton.clickButton(sh_locators.get_submitBtn());
		Thread.sleep(3000);
		WebButton.clickButton(sh_locators.get_enableLaterBtn());
		
	}
	public void createBarcodes() throws InterruptedException
	{
	Activate_Test_Kit_Actions activate_test_kit_actions = new Activate_Test_Kit_Actions(getDriver());
	createSingleBarcodeFromTimsToUseInDashboard();
	createDoubleBarcodeFromTimsToUseInDashboard();
	}
	
	public void createSingleBarcodeFromTimsToUseInDashboard() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(3000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.print("Generated Barcode is" + Barcode1);
		
	}

	public void createDoubleBarcodeFromTimsToUseInDashboard() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Blue");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Barcode2 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.print("Generated Barcode is" + Barcode2);
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), Barcode2);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		Thread.sleep(2000);
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Male Sexual Health Test");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		Thread.sleep(2000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);

	}

	public void dashboardLogin() throws IOException, InterruptedException {
		Thread.sleep(3000);
		String urlKey = determineUrlKey("dashboard_automation_resetpassword_staging");
		driver.get(urlKey);
		WebTextBox.sendInput(activate_test_kit_locators.get_emailDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Email"));
		WebTextBox.sendInput(activate_test_kit_locators.get_passwordDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Password"));
		WebButton.clickButton(activate_test_kit_locators.get_loginTimsBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_dbEnableLaterBtn());

	}
	
	public void activateKitJourney() throws InterruptedException
	{
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebWait.elementToBeClickable(driver, sh_locators.get_activateShKitBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_activateShKitBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_phoneNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_genderBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_genderConfirmBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_ethnicityRadioBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_dateTxt(), activate_test_kit_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.elementToBeClickable(driver, sh_locators.get_closeBtnOfWarningMsg(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_closeBtnOfWarningMsg());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
			
	}
	
	public void healthAssessmentJourney() throws InterruptedException
	{
		Thread.sleep(5000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		WebTextBox.sendInput(health_assessment_locators.get_heightTxt(), "165");
		WebTextBox.sendInput(health_assessment_locators.get_weightTxt(), "68");
		WebDropDown.selectByText(health_assessment_locators.get_smokeCigarettesDrp(), "No");
		WebDropDown.selectByText(health_assessment_locators.get_drinkAlcoholDrp(), "No");
		WebScrollView.scrollToElement(driver, health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(health_assessment_locators.get_physicalActivityDrp(), "No");
		WebButton.clickButton(health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(health_assessment_locators.get_medicalConditionDrp(), "No");
		WebButton.clickButton(health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(health_assessment_locators.get_medicationDrp(), "No");
		WebButton.clickButton(health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(health_assessment_locators.get_sexuallyActiveDrp(), "No");
		WebDropDown.selectByText(health_assessment_locators.get_stiDiagnosedDrp(), "No");
		WebDropDown.selectByText(health_assessment_locators.get_stiSymptomsDrp(), "No");
		WebDropDown.selectByText(health_assessment_locators.get_potentialSTIExposureDrp(), "No");
		WebScrollView.scrollToElement(driver, health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(health_assessment_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(health_assessment_locators.get_assessmentSubmitBtn());
		Thread.sleep(2000);	
		
	}
	
	public void markAsReceivedJourney(String fileName, String csvBarcode, String barcodeOption) throws InterruptedException, IOException
	{
		String barcodeChoice = barcodeOption; 
		String selectedBarcode = selectBarcode(barcodeChoice);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebWait.elementToBeClickable(driver, sh_locators.get_markAsReceivedHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_markAsReceivedHeaderMenuBtn());
		WebWait.visibilityOfElement(driver, sh_locators.get_barcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_barcodeTxt(), Barcode1);
		WebWait.elementToBeClickable(driver, sh_locators.get_nextBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_nextBtn());
		WebWait.elementToBeClickable(driver, sh_locators.get_markAsReceivedPopupWindowBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_markAsReceivedPopupWindowBtn());
		Thread.sleep(5000);	
		WebWait.elementToBeClickable(driver, sh_locators.get_markAsReceivedHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_markAsReceivedHeaderMenuBtn());
		WebWait.visibilityOfElement(driver, sh_locators.get_barcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_barcodeTxt(), Barcode2);
		WebWait.elementToBeClickable(driver, sh_locators.get_nextBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_nextBtn());	
		WebWait.elementToBeClickable(driver, sh_locators.get_markAsReceivedPopupWindowBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_markAsReceivedPopupWindowBtn());
		Thread.sleep(5000);
		WebWait.elementToBeClickable(driver, sh_locators.get_uploadBloodCsvHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_uploadBloodCsvHeaderMenuBtn());
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver,System.getProperty("user.dir") +"\\TestData\\SH_CSV\\" + fileName,sh_locators.get_uploadCsvChooseFileOptionTxt(), csvBarcode, selectedBarcode);
		Thread.sleep(1000);
		WebButton.clickButton(sh_locators.get_uploadBtn());
		Thread.sleep(3000);	
		driver.navigate().refresh();
		Thread.sleep(5000);	
		
	}
	
	public static String selectBarcode(String barcodeChoice) {
	    if ("Barcode1".equalsIgnoreCase(barcodeChoice)) {
	        return Barcode1;
	    } else if ("Barcode2".equalsIgnoreCase(barcodeChoice)) {
	        return Barcode2;
	    }
	    throw new IllegalArgumentException("Invalid barcode choice: " + barcodeChoice);
	}
	
	
   public void getStatus(String expectedKitStatus, String expectedPrimaryBarcodeStatus, String expectedSecondaryBarcodeStatus) throws InterruptedException
    {
		
		WebWait.elementToBeClickable(driver, sh_locators.get_uploadBloodCsvHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		Thread.sleep(5000);
		String ActualKitStatus = sh_locators.get_kitStatus().getText().trim();
		String ActualPrimaryBarcodeStatus = sh_locators.get_primaryBarcodeStatus().getText().trim();
		String ActualSecondaryBarcodeStatus = sh_locators.get_secondaryBarcodeStatus().getText().trim();
		System.out.print(ActualKitStatus);
		Assert.assertEquals(ActualPrimaryBarcodeStatus, expectedPrimaryBarcodeStatus,
				"PrimaryBarcodeStatus Status is wrong");
		Assert.assertEquals(ActualSecondaryBarcodeStatus, expectedSecondaryBarcodeStatus,
				"SecondaryBarcodeStatus Status is wrong");
		Assert.assertEquals(ActualKitStatus, expectedKitStatus, 
				"Kit Status is wrong");
	   
	}
   
   public void getTestReport() throws InterruptedException
   {
	    
	    WebWait.elementToBeClickable(driver, sh_locators.get_testReportSideMenu(), Duration.ofSeconds(20));
	    WebButton.clickButton(sh_locators.get_testReportSideMenu());
	    WebWait.elementToBeClickable(driver, sh_locators.get_inLabBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_inLabBtn());
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, sh_locators.get_inLabPrimaryBarcode(), Duration.ofSeconds(20));
		Assert.assertTrue(sh_locators.get_inLabPrimaryBarcode().isDisplayed(), "Primary Barcode Visible In 'In Lab' ");
		WebButton.clickButton(sh_locators.get_inLabBackBtn());
		
		WebWait.elementToBeClickable(driver, sh_locators.get_ReadyForReviewBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(sh_locators.get_ReadyForReviewBtn());	
		
		WebWait.visibilityOfElement(driver, sh_locators.get_primaryBarcodeSearchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(sh_locators.get_primaryBarcodeSearchTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, sh_locators.get_ReadyForReviewEmptyData(), Duration.ofSeconds(20));
		Assert.assertTrue(sh_locators.get_ReadyForReviewEmptyData().isDisplayed(), "Primary Barcode Not Visible In 'Ready For Review' ");
   }	   

}
