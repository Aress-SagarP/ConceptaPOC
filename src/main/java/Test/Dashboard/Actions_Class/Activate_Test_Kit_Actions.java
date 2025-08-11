package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import PreTestDataLocators.PreDataLocators;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Create_Account_Locators;
import Test.Dashboard.Locators_Class.Customer_Landing_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebMouseOperation;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebElementCommon;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;

public class Activate_Test_Kit_Actions extends BaseClass {

	public WebDriver driver;
	Activate_Test_Kit_Locators activate_test_kit_locators = null;
	Customer_Landing_Locators customer_landing_locators;
	Customer_Landing_Actions customer_landing_actions;
	Health_Assessment_Locators health_assessment_locators;
	Health_Assessment_Actions health_assessment_actions;
	Login_Action login_action;
	public static String Barcode1;
	public static String Barcode2;
	public static String formattedDate;
	public static String validationMsg;
	public static String editedValue;
	String newBarcode;
	public static String MGcode1;
	public static String MGcode2;
	public static String MGcode3;
	public static String PGcode1;
	public static String PGcode2;
	public static String BGcode1;
	public static String BGcode2;
	public static String COcode1;
	public static String BTcode1;
	public static String MLcode1;
	public static String MBcode1;
	public static String PLcode1;
	public static String BLcode1;
	ReadGmail read_gmail = new ReadGmail();

	public Activate_Test_Kit_Actions(WebDriver driver) {
		this.driver = driver;
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		customer_landing_locators = new Customer_Landing_Locators(driver);
		//customer_landing_actions = new Customer_Landing_Actions(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
		//health_assessment_actions = new Health_Assessment_Actions(driver);
		login_action = new Login_Action(driver);
	}
	
	public void setHealthAssessmentActions(Health_Assessment_Actions health_actions) {
        this.health_assessment_actions = health_actions;
    }
	
	public void setCustomerLandingActions(Customer_Landing_Actions customer_actions) {
		this.customer_landing_actions = customer_actions;
	}
	

	public void dashboardUrlOfTims() throws IOException, InterruptedException {
		String urlKey = determineUrlKey("tims_URL_For_Dashboard");
		driver.get(urlKey);
		WebTextBox.sendInput(activate_test_kit_locators.get_emailTimsLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "tims_Login_For_Dashboard_Activate_Kit"));
		WebTextBox.sendInput(activate_test_kit_locators.get_passwordTimsLoginTxt(), PropertiesReader
				.getPropertyValue(WebCommonPath.testDatafile, "tims_Password_For_Dashboard_Activate_Kit"));
		WebButton.clickButton(activate_test_kit_locators.get_loginTimsBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_timsEnableLaterBtn());
	}

	public void createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow() throws InterruptedException {
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(3000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.print("Generated Barcode is" + Barcode1);
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(3000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(6000);
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		Thread.sleep(2000);
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Cholesterol Profile Test ");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		Thread.sleep(3000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
		Thread.sleep(3000);

	}
	
	
	public void createSingleBarcodeFromTimsToUseInDashboard() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_customerDrp(), Duration.ofSeconds(20));
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
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Lavender");
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
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Energy Profile Test ");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		Thread.sleep(2000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);

	}

	public void dashboardUrl() throws IOException, InterruptedException {
		Thread.sleep(3000);
		String urlKey = determineUrlKey("dashboard_automation_staging");
		driver.get(urlKey);
		WebTextBox.sendInput(activate_test_kit_locators.get_emailDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Email"));
		WebTextBox.sendInput(activate_test_kit_locators.get_passwordDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Password"));
		WebButton.clickButton(activate_test_kit_locators.get_loginTimsBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_dbEnableLaterBtn());

	}

	public void autoPopulationOfSecondaryBarcodeForTestKitsWithTwoBarcodes() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(4000);
		String SecondaryBarcode = activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit().getAttribute("value");
		System.out.print(SecondaryBarcode);
		Assert.assertEquals(Barcode2, SecondaryBarcode, "Secondary Barcode Is Not Matching");

	}

	public void userCanClickTheActivateBloodTestButton() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_goldBarcodeTxt().isDisplayed(),
				"User Did Not Redirected To The Barcode & Tracking ID Page ");
	}
	
	public void handlingOfExtremelyLargeInputInBarcodeField() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGLMLYSSTOOEFJGUNDJKDJFU");
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"More Than 10 Digitis Barcode Is Accepted ");
	}

	public void errorIfUserAttemptToProceedWithEmptyFieldsForBarcodeAndTrackingNumber() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Without Barcode & Tracking Number User Gone To Next Page ");
	}
	public void systemAllowsUserToActivateKitForInCompleteActivationProcess() throws InterruptedException, IOException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebButton.clickButton(activate_test_kit_locators.get_logoutBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmLogoutBtn());
		Thread.sleep(3000);
		WebTextBox.sendInput(activate_test_kit_locators.get_emailDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Email"));
		WebTextBox.sendInput(activate_test_kit_locators.get_passwordDashboardLoginTxt(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "activate_Kit_Valid_Password"));
		WebButton.clickButton(activate_test_kit_locators.get_loginTimsBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_dbEnableLaterBtn());
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		Assert.assertTrue(activate_test_kit_locators.get_consentInfoFirstCheckBox().isDisplayed(),
				"User Not Allowed to Proceed with Kit Activation Process, Which Was Incompleted Last Time ");
	}
	
	public void doubleBarcodeFoHowToPageWith12Elements() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(2000);
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_phoneNumberTxt(), Duration.ofSeconds(10));
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
        List<WebElement> images = activate_test_kit_locators.get_all12Webelements();
        Assert.assertEquals(images.size(), 12, "Expected 12 checklist images but found: " + images.size());

        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed(), "One of the checklist images is not displayed.");
        }

        System.out.println("All 12 checklist images are present and displayed.");
	}
	
	public void placeholdersForBarcodeAndTrackingNumber() throws InterruptedException
	{ 
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
	    WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
	    Thread.sleep(2000);
	    Assert.assertTrue(activate_test_kit_locators.get_placeholderBarcodeTxt().isDisplayed(), "Placeholder For Barcode Is Not Present");
	    Assert.assertTrue(activate_test_kit_locators.get_placeholderTrackingNumberTxt().isDisplayed(), "Placeholder For Tracking Number Is Not Present");
	}
	
	public void emptyFeildsRequiredIcon() throws InterruptedException
	{
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
	    WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
	    Thread.sleep(2000);
	    WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_emptyFeildRequiredIcon().isDisplayed(),
				"System Proceed With Kit Activation Process with Empty Barcode ");
	}
	
	public void sameTrackingNumberAllowedForMultipleActivationProcess() throws InterruptedException
	{
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
	    WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
	    Thread.sleep(2000);
	    WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		Assert.assertTrue(activate_test_kit_locators.get_consentInfoFirstCheckBox().isDisplayed(), " System Does Not Allowed To Use Same Tracking Number");
		
		
	}
	public void errorForAlreadyUsedBarcode() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGI-ybe-8172");
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"System Proceed With Kit Activation Process For Already Used Barcode ");
	}
	
	public void invalidTrackingNumberForKitActivationProcess() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGI-YBE-8172");
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 ");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"System Proceed For An Kit Activation Process With Invalid Tracking ID Number ");
	}
	
	public void activateTestKitForExpiredBarcode() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGT-vxy-6888");
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB ");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"System Proceed For An Kit Activation Process With Expired Barcode ");
	}
	
	public void consentCheckboxesAreMandatoryFeilds() throws InterruptedException {
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB ");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isValid = (Boolean) js.executeScript("return arguments[0].form.reportValidity();", activate_test_kit_locators.get_consentInfoFirstCheckBox());
        if (!activate_test_kit_locators.get_consentInfoFirstCheckBox().isSelected()) {
            String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", activate_test_kit_locators.get_consentInfoFirstCheckBox());
            System.out.println("Validation message: " + validationMsg);
            String ErrorMsg = "Please check this box if you want to proceed.";
            Assert.assertEquals(ErrorMsg, validationMsg);
        }
		    

	}
	public void userRedirectedToDetialsPageAfterMarkingConsentCheckboxes() throws InterruptedException {
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_otherElementInConsentPage());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_phoneNumberTxt().isDisplayed(),
				"User Did Not Redirected To Deatils Page, After Marking The Consent Checkboxes ");
	}
	
	public void dataAutoPopulateOnPersonalDetailsPage() throws InterruptedException {
		String ActualFN = "Cust_FN_Test_Acc";
		String ActualLN = "Cust_LN_Test_Acc";
		String ExtractedFN = activate_test_kit_locators.get_firstNameOnDetailsPage().getAttribute("value");	
		String ExtractedLN = activate_test_kit_locators.get_lastNameOnDetailsPage().getAttribute("value");	
		Thread.sleep(2000);
		Assert.assertEquals(ActualFN, ExtractedFN);
	}
	
	public void abilityToEditPersonalDetails() throws InterruptedException {
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_firstNameOnDetailsPage(), "Test_FN");
		activate_test_kit_locators.get_firstNameOnDetailsPage().clear();
		WebTextBox.sendInput(activate_test_kit_locators.get_firstNameOnDetailsPage(), "Cust_FN_Test_Acc");
	}
	
	public void howToPageRedirected() throws InterruptedException {
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_howToPageText(), Duration.ofSeconds(10));
		Assert.assertTrue(activate_test_kit_locators.get_howToPageText().isDisplayed(), "User Did Not Redirected To 'How To' page ");
	}
	public void personalDetailsDoesNotEraseIfGoBackPage() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(3000);
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		Thread.sleep(2000);
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_phoneNumberTxt(), Duration.ofSeconds(20));
		Thread.sleep(3000);
		String MobNumber = activate_test_kit_locators.get_phoneNumberTxt().getAttribute("value");
		String ActualNumber = "7362342247";
		Assert.assertEquals(MobNumber, ActualNumber);
		
	}
	
	public void userFriendlyUI() throws InterruptedException
	{
		Assert.assertTrue(activate_test_kit_locators.get_activateTestSideMenuItem().isDisplayed(), "Menu Icons Are Not Proper");
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_confirmAndContinueBtn().isDisplayed(), "Continue & Back Buttons Are Not Proper");
		
	}
	
	public void tooltipOnHowToPage() throws InterruptedException
	{ 
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(3000);
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_tooltipTxt());
		WebMouseOperation.moveToElement(driver, activate_test_kit_locators.get_tooltipTxt());
		Assert.assertTrue(activate_test_kit_locators.get_tooltipOnHowToPage().isDisplayed(), "Tooltip Not Present");
	}
	public void contentOfHowToPage() {
		Assert.assertTrue(activate_test_kit_locators.get_contentOfHowToPage().isDisplayed(), "User Did Not Able To See The Content Of'How To' page ");
	}
	
	public void navigateBackToHowToPageFromAnyStepInTheActivationProcess() throws InterruptedException {
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_contentOfHowToPage().isDisplayed(), "User Did Not Able To Navigate Back To 'How To' page ");
	}
	
	public void checkDateFunctionalityOfMoreThan16Days() throws InterruptedException
	{
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		String DateCheck = getDateMinus16Days();
		WebTextBox.sendInput(activate_test_kit_locators.get_dateTxt(), DateCheck);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(), "User Proceed To Next Page With Having The Date Older Than 16 Days ");
	}
	
	public void selectCurrentDateAndProceed() throws InterruptedException
	{
		String CurrentDate = getSystemCurrentDate();
		
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dateTxt(), CurrentDate);
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(4000);
		Assert.assertTrue(activate_test_kit_locators.get_healtAssessmentText().isDisplayed(), "User Did Not Redirected To Next Page, Even After Selecting The Current Date");
		
	}
	
	public void testActivationKitSuccessEmail() throws Exception
	{   Thread.sleep(3000);
		String getSucessMsgOfActivationKit = read_gmail.getButtonURL("Completed Activation Kit");
		System.out.print(getSucessMsgOfActivationKit);
		
	}
	
	public void errorMsgForInvalidBarcode() throws InterruptedException
	{
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGF-RHT");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Using Invalid Barcode, User Proceed To Next Page ");
	}
	
	public void errorMsgDisplayedProperly() throws InterruptedException 
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		System.out.println("Error msg: " +activate_test_kit_locators.get_errorMsg().getText());
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Error Msg Dot Displayed");
		ExtentManager.getTest().log(Status.PASS, "Error msg: " +activate_test_kit_locators.get_errorMsg().getText());
	}
	
	public void errorMsgDisplayedWhenEnteredLongCharactersForPersonalDetails() throws InterruptedException
	{
		String longCharacters = "gdumxiqrvheuztbnzwkurxqvjoryczevjqmwqyxqtgznfnxtdjfmpdarkztdqfcyednljxebywzszxlibejkasecwqsnekagyrgkmgfqmkqioqgwnyeudqcgjmuymqzagydtmhcnoxcmcstzbhytocywtbzzroaqnyfubpvjjsrirlaasvyhezodfdrajknkrjhxoezluuuswvxksihikfiwrwflcbtkzudhezstzvpgtgwkyppcpnzjvfsrpsmu"; 
		WebTextBox.sendInput(activate_test_kit_locators.get_firstNameOnDetailsPage(), longCharacters);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		String actualValue = activate_test_kit_locators.get_firstNameOnDetailsPage().getDomAttribute("value");
		int lengthOfString = actualValue.length();
		if (lengthOfString == 63)
			System.out.print("System Only Accept The 63 Characters");
		System.out.println("Error msg: "+activate_test_kit_locators.get_errorMsg().getText());
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Error Msg Dot Displayed");
		ExtentManager.getTest().log(Status.PASS, "Error msg: " +activate_test_kit_locators.get_errorMsg().getText());
	}
	
	public void systemDoesNotAllowToActivateKitMoreThanOneTime() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGE-fnl-6494");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"System Proceed With Activation Kit Process For Already Activated Barcode");
	}
	
	public void systemCorrectlyHandlesBrowserBackButtonBehavior() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		driver.navigate().back();
		Assert.assertTrue(activate_test_kit_locators.get_activateKitOfBloofTestBtn().isDisplayed(),
				"Browser Back Button Not Working");
		Thread.sleep(2000);
		driver.navigate().forward();
		Assert.assertTrue(activate_test_kit_locators.get_goldBarcodeTxt().isDisplayed(),
				"Browser Forward Button Not Working");
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGV-TLN-2612");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		driver.navigate().back();
		Assert.assertTrue(activate_test_kit_locators.get_goldBarcodeTxt().isDisplayed(),
				"Browser Back Button Not Working");
	}
	
	public void screenResolutionSizesShowsAllWebelementsProperly(int width, int height) throws IOException, InterruptedException
	{
		 
		        /*    {1920, 1080}, // Desktop full HD
		            {1366, 768},  // Laptop
		            {768, 1024},  // Tablet Portrait
		            {375, 667},   // iPhone 8
		            {414, 896}    // iPhone XR */       
		        		            
		            driver.manage().window().setSize(new Dimension(width, height));	           
		            driver.get("https://dashboard-automation.myhealthchecked.com");	
		            
		            System.out.println("Testing resolution: " + width + "x" + height);		           
		            try {
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                e.printStackTrace();}      
		                                 
	}
	
	public void webelementsAreLabelledClearly()
	{
		List<WebElement> buttons =  activate_test_kit_locators.get_allWebelements();

        for (WebElement button : buttons) {
            //  Check if button is displayed
            if (button.isDisplayed()) {
                String label = button.getText().trim();

                //  Check for non-empty label
                if (!label.isEmpty()) {
                    System.out.println("Button is visible and labeled: " + label);
                } else {
                    System.out.println("Button is visible but has no label!");
                }

                //  Check if button is enabled (functional)
                if (button.isEnabled()) {
                    System.out.println("Button is enabled (clickable): " + label);

                } else {
                    System.out.println("Button is disabled: " + label);
                }

            } else {
                System.out.println("Button is not visible in viewport.");
            }
        }

	}
	
	public void toEditDateAfterActivationCompleted() throws InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(3000);
		WebTextBox.sendInput(activate_test_kit_locators.get_phoneNumberTxt(), "7362342247");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dobTxt(), "03212000");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_genderConfirmBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_ethnicityRadioBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		Assert.assertTrue(activate_test_kit_locators.get_errorMsgForUpdateDateAfterActivationProcess().isDisplayed(), "System Allows User To Update Date After Activation Process Is Completed");

		
	}
	
	public void userCantGotoActivationConfirmationPageWithoutCompletingAllPreviousSteps()
	{
		String Url = "https://dashboard-automation.myhealthchecked.com/time-administered/"+Barcode1;
		driver.get("https://dashboard-automation.myhealthchecked.com/time-administered/"+Barcode1);
		Assert.assertTrue(activate_test_kit_locators.get_emailDashboardLoginTxt().isDisplayed(),"Without Completing Process User Directly Went To Activation Conformation Page");
	}
	public void noDataRemiansOnScreenIfBrowserBackIsUsedAfterLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_logoutBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmLogoutBtn());
		Thread.sleep(2000);
		driver.navigate().back();
		Assert.assertTrue(activate_test_kit_locators.get_emailDashboardLoginTxt().isDisplayed(),"Data Remians On Screen If Browser Back Is Used After Logout");
		
	}
	public void successfulActivationOfATestKitUsingValidInputs() throws Exception {
		/*WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), "MGF-RHT-0931");
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		Thread.sleep(3000);
		

		/*Assert.assertTrue(activate_test_kit_locators.get_toastMsg().isDisplayed(),
				"Test Kit Activation Process Failed ");*/
		Thread.sleep(3000);
		String getSucessMsgOfActivationKit = read_gmail.getButtonURL("Completed Activation Kit");
		System.out.print(getSucessMsgOfActivationKit);

	}

	public String getSystemCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
		Date currentDate = new Date();
		formattedDate = formatter.format(currentDate);
		return formattedDate;
	}
	
	public static String getDateMinus16Days() {
        // Get current system date
        LocalDate currentDate = LocalDate.now();

        // Subtract 16 days
        LocalDate modifiedDate = currentDate.minusDays(16);

        // Format the date to dd-MM-yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return modifiedDate.format(formatter);
    }
	
	public void sensitiveInfoNotDisplayed() {
		System.out.println("Error Message: "+activate_test_kit_locators.get_errorMsg().getText());
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Sensitive information is displayed");
		ExtentManager.getTest().log(Status.PASS, "Error Message: "+activate_test_kit_locators.get_errorMsg().getText());
	}
	
	public void verifyTrackingNumIsAutoPopulated() throws InterruptedException, IOException {
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(3000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode is" + Barcode1);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadKitCSVHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadKitCSVHeaderMenuBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadFileInput(), Duration.ofSeconds(20));
		Map<String, String> replacements = new HashMap<>();
		replacements.put("MGH-DNQ-0779", Barcode1);
		//replacements.put("B28000", "B28000");
		//CSVUploaderWithTextReplacement.updateAndUploadCSVMultipleValues(driver, WebCommonPath.createKit_csv , health_assessment_locators.get_uploadFileInput(), "CONCS25164", Barcode1);
		CSVUploaderWithTextReplacement.updateAndUploadCSVMultipleValues(driver, WebCommonPath.createKit_csv , health_assessment_locators.get_uploadFileInput(), replacements);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_csvUploadedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_csvUploadedAlert().getText());
		Thread.sleep(3000);
		
		//login_action.login_Dashboard2();
		dashboardUrl();
//		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
//		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));		
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).perform();
		Thread.sleep(3000);
		String actualTrackingNum = activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value");
		String expectedTrackingNum = "AA 1245 7991 5AG";
		System.out.println("Tracking no.: " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		assertEquals(actualTrackingNum, expectedTrackingNum);
		ExtentManager.getTest().log(Status.PASS, "Tracking no.: " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		
		
	}
	
	public void verifyTrackingNumOnPageRefresh() throws InterruptedException {
		System.out.println("Tracking no.(Before refresh): " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		ExtentManager.getTest().log(Status.INFO, "Tracking no.(Before refresh): " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		driver.navigate().refresh();
		Thread.sleep(3000);
		String trackingNumAfterRefresh = activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value");
		System.out.println("Tracking no.(After refresh): " +trackingNumAfterRefresh);
		assertTrue(trackingNumAfterRefresh.isEmpty(), "Tracking number is not empty");
		System.out.println("Tracking number is empty");
		ExtentManager.getTest().log(Status.PASS, "Tracking no.(After refresh): " +trackingNumAfterRefresh+"<br>" +"Tracking number is empty");
	}
	
	public void verifyJourneyWithoutEnteringTrackingNum() {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));		
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_errorMsgTrackingNumRequired(), Duration.ofSeconds(20));
		String actualErrorMsg = activate_test_kit_locators.get_errorMsgTrackingNumRequired().getText();
		String expectedErrorMsg = "Tracking number is required";
		assertEquals(actualErrorMsg, expectedErrorMsg, "Error message mismatch");
		System.out.println("Error: "+actualErrorMsg);
		ExtentManager.getTest().log(Status.PASS, "Error: "+actualErrorMsg);
	}
	
	public void verifyJourneyAfterRemovingTrackingNum() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));		
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).perform();
		Thread.sleep(3000);
		act.click(activate_test_kit_locators.get_trackingNumberTxt())
		   .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
		   .sendKeys(Keys.BACK_SPACE)
		   .perform();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_errorMsgTrackingNumRequired(), Duration.ofSeconds(20));
		String actualErrorMsg = activate_test_kit_locators.get_errorMsgTrackingNumRequired().getText();
		String expectedErrorMsg = "Tracking number is required";
		assertEquals(actualErrorMsg, expectedErrorMsg, "Error message mismatch");
		System.out.println("Error: "+actualErrorMsg);
		ExtentManager.getTest().log(Status.PASS, "Error: "+actualErrorMsg);
	}
	
	
	
	public void verifyAbilityToEditSaveTrackingNum() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));		
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		act.keyDown(Keys.TAB).perform();
		Thread.sleep(3000);
		System.out.println("Tracking no.(Before edit): " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		ExtentManager.getTest().log(Status.INFO, "Tracking no.(Before edit): " +activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value"));
		act.sendKeys(Keys.BACK_SPACE)
		   .sendKeys(Keys.BACK_SPACE)
		   .sendKeys(Keys.BACK_SPACE)
		   .sendKeys(Keys.NUMPAD2)
		   .sendKeys("B")
		   .sendKeys("B")
		   .perform();
		editedValue = activate_test_kit_locators.get_trackingNumberTxt().getAttribute("value");
		System.out.println("Tracking no.(After edit): " +editedValue);
		ExtentManager.getTest().log(Status.PASS, "Tracking no.(After edit): " +editedValue);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(),
		health_assessment_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_msgTestKitActivatedAlert(),
				Duration.ofSeconds(20));
		System.out.println("Alert: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		health_assessment_actions.selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "170");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "65");
		health_assessment_actions.selectOptionSmokeCigarettes("No");
		health_assessment_actions.selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.submitAssessmentForm5();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(20000);
		WebElement trackingNum = getTrackingNumMyResultsPage(Barcode1);
		String actualTrackingNum = trackingNum.getText();
		String expectedTrackingNum = editedValue;
		assertEquals(actualTrackingNum, expectedTrackingNum, "Tracking number mismatch");
		System.out.println("Actual Tracking no.: "+actualTrackingNum+"\n"+ "Expected Tracking no.: "+expectedTrackingNum);
		ExtentManager.getTest().log(Status.PASS, "Actual Tracking no.: "+actualTrackingNum+"<br>"+ "Expected Tracking no.: "+expectedTrackingNum);
		
	}
	
	public void verifyAbilityToEnterSaveTrackingNum() throws InterruptedException {
		WebElement trackingNum = getTrackingNumMyResultsPage(Barcode1);
		String actualTrackingNum = trackingNum.getText();
		String expectedTrackingNum = editedValue;
		assertEquals(actualTrackingNum, expectedTrackingNum, "Tracking number mismatch");
		System.out.println("Actual Tracking no.: "+actualTrackingNum+"\n"+ "Expected Tracking no.: "+expectedTrackingNum);
		ExtentManager.getTest().log(Status.PASS, "Actual Tracking no.: "+actualTrackingNum+"<br>"+ "Expected Tracking no.: "+expectedTrackingNum);
	}
	
	public void verifyTackingNumDisplayedMyResultsPage() throws InterruptedException {
		WebElement trackingNum = getTrackingNumMyResultsPage(Barcode1);
		System.out.println("Tracking no.: "+trackingNum.getText());
		assertTrue(trackingNum.isDisplayed(), "Tracking number not displayed");
		ExtentManager.getTest().log(Status.PASS, "Tracking no.: "+trackingNum.getText());
		
	}
	
	public void verifyTrackingNumOnTestKitPage() throws InterruptedException {
		WebWait.visibilityOfElement(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(40));
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(40));
		WebScrollView.scrollToElement(driver, customer_landing_actions.getViewTestBtn(Barcode1));
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, customer_landing_actions.getViewTestBtn(Barcode1), Duration.ofSeconds(30));
		WebButton.JsclickButton(customer_landing_actions.getViewTestBtn(Barcode1), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumTestKitPageDb(), Duration.ofSeconds(20));
		String trackingNum = activate_test_kit_locators.get_trackingNumTestKitPageDb().getText();
		System.out.println("Tracking no.: "+trackingNum);
		assertTrue(activate_test_kit_locators.get_trackingNumTestKitPageDb().isDisplayed(), "Tracking number is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Tracking no.: "+trackingNum);
	}
	
	public void verifyTrackingNumIsNonEditable() {
		 WebElement trackingNumberElement = activate_test_kit_locators.get_trackingNumTestKitPageDb();

	        String tagName = trackingNumberElement.getTagName();
	        System.out.println("Tag name: " +tagName);
	        Assert.assertEquals(tagName, "code", "Tracking number should be inside a <code> tag");
	        ExtentManager.getTest().log(Status.PASS, "Tag name: " +tagName);

	        boolean isEditable = trackingNumberElement.isEnabled() && trackingNumberElement.getTagName().equals("input");
	        System.out.println("Is Editable?: "+isEditable);
	        Assert.assertFalse(isEditable, "Tracking number should not be editable");
	        ExtentManager.getTest().log(Status.PASS, "Is Editable?: "+isEditable);
	}
	
	public void verifyTrackingNumPlaceholder() throws IOException, InterruptedException {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumFieldLabelTestKitPageDb(), Duration.ofSeconds(20));
		System.out.println("Label(Dashboard): " +activate_test_kit_locators.get_trackingNumFieldLabelTestKitPageDb().getText());
		assertTrue(activate_test_kit_locators.get_trackingNumFieldLabelTestKitPageDb().isDisplayed(), "Label is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Label(Dashboard): " +activate_test_kit_locators.get_trackingNumFieldLabelTestKitPageDb().getText());
		
		dashboardUrlOfTims();
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_testKitId(), Duration.ofSeconds(20));
		System.out.println("Test kit id: "+customer_landing_locators.get_testKitId().getText());
		ExtentManager.getTest().log(Status.INFO, "Test kit id: "+customer_landing_locators.get_testKitId().getText());
		WebButton.JsclickButton(customer_landing_locators.get_testKitId(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumTimsLabel(), Duration.ofSeconds(20));
		System.out.println("Label(TIMS): "+activate_test_kit_locators.get_trackingNumTimsLabel().getText());
		assertTrue(activate_test_kit_locators.get_trackingNumTimsLabel().isDisplayed(), "Label is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Label(TIMS): " +activate_test_kit_locators.get_trackingNumTimsLabel().getText());
		
	}
	
	public void verifyTrackingNumDisplayedInTims() throws IOException, InterruptedException {
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumTimsTxt(), Duration.ofSeconds(20));
		String actualTrackingNum = activate_test_kit_locators.get_trackingNumTimsTxt().getText();
		System.out.println("Tracking no.: "+actualTrackingNum);
		assertEquals(actualTrackingNum, editedValue, "Tracking number mismatch");
	}
	
	public void verifyConfirmedTrackingNumOnTims() {
		String actualTrackingNum = activate_test_kit_locators.get_trackingNumTimsTxt().getText();
		System.out.println("Tracking no.: "+actualTrackingNum);
		assertEquals(actualTrackingNum, editedValue, "Tracking number mismatch");
	}
	
	public WebElement getTrackingNumMyResultsPage(String barcode) throws InterruptedException {
		WebElement trackingNumber = driver.findElement(By.xpath("//code[text()='" + Barcode1
				+ "']/ancestor::div[@data-testid='link-card']//span[text()='Tracking number']/following-sibling::code"));
		WebScrollView.scrollToElement(driver, trackingNumber);
		Thread.sleep(4000);
		return trackingNumber;
	}
	
	public void createMultipleBarcodes(String CustomerDrp, String TypeDrp, String SubType, String barcodeType) throws InterruptedException
	{
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(3000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), CustomerDrp);
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), TypeDrp);
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), SubType);
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "3");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		
		List<WebElement> barcodes = activate_test_kit_locators.get_allGeneratedBarcodes();
		 List<String> barcodeList = new ArrayList<>();

		    for (WebElement barcode : barcodes) {
		        String barcodeTxt = barcode.getText(); 
		        barcodeList.add(barcodeTxt); 
		    }

		    System.out.println("Generated Barcodes are: " + barcodeList);

		    switch (barcodeType) {
		        case "MG":
		            MGcode1 = barcodeList.get(0);
		            MGcode2 = barcodeList.get(1);
		            MGcode3 = barcodeList.get(2);
		            break;
		        case "PG":
		        	PGcode1 = barcodeList.get(0); 
		        	PGcode2 = barcodeList.get(1);
		            break;
		        case "BG":
		        	BGcode1 = barcodeList.get(0);
		        	BGcode2 = barcodeList.get(1);
		            break;
		        case "CO":
		        	COcode1 = barcodeList.get(0);
		            break;
		        case "BT":
		        	BTcode1 = barcodeList.get(0);
		            break;
		        case "ML":
		        	MLcode1 = barcodeList.get(0);
		            break;
		        case "MB":
		        	MBcode1 = barcodeList.get(0);
		            break;
		        case "PL":
		        	PLcode1 = barcodeList.get(0);
		            break;
		        case "BL":
		        	BLcode1 = barcodeList.get(0);
		            break;
				 default:
					break;
		        
		    }
	}
	
	public void uploadCSVForMultipleBarcodes() throws IOException, InterruptedException
	{
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());		
		WebButton.clickButton(activate_test_kit_locators.get_uploadCsvKitButton());
		
		Map<String, String> replacements = new HashMap<>();
		replacements.put("MGO-WNU-0793", MGcode1);
		replacements.put("MGO-WNU-0700", MGcode2);
		replacements.put("MLJ-FQO-0487", MLcode1);
		replacements.put("PGT-MKQ-7646", PGcode1);
		replacements.put("MGO-WNU-0701", MGcode3);
		replacements.put("MBM-YHV-9129", MBcode1);
		replacements.put("PGT-MKQ-7600", PGcode2);
		replacements.put("PLO-HTG-0275", PLcode1);
		replacements.put("BGI-MCT-6947", BGcode1);
		replacements.put("BGI-MCT-6900", BGcode2);
		replacements.put("BLR-BVV-3600", BLcode1);

		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadFileInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSVMultipleValues(driver,System.getProperty("user.dir") +"\\TestData\\MultipleBarcodes.csv",health_assessment_locators.get_uploadFileInput(),replacements);
		WebButton.clickButton(activate_test_kit_locators.get_uploadCsvKitInsideButton());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_csvuploadedSuccessMultiBarcodeToaster(), Duration.ofSeconds(30));
		System.out.println("Alert: "+activate_test_kit_locators.get_csvuploadedSuccessMultiBarcodeToaster().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+activate_test_kit_locators.get_csvuploadedSuccessMultiBarcodeToaster().getText());
	}
	
	public void activateKitMultipleBarcodeSingle() throws IOException, InterruptedException {
		List<String> primaryBarcodesSingle = new ArrayList<>();
		primaryBarcodesSingle.add(MGcode1);
		
		login_action.login_dashboard_staging();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		
		for (String barcode : primaryBarcodesSingle) {
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), barcode);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		    Thread.sleep(2000);
		    WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		    Thread.sleep(2000);
		    WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		    WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_kitActivatedToaster(), Duration.ofSeconds(20));
			System.out.println("Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			assertTrue(activate_test_kit_locators.get_kitActivatedToaster().isDisplayed());
			ExtentManager.getTest().log(Status.PASS, "Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			}
			
	}	
	
	public void activateKitMultipleBarcodeSingleBootsPrivate() throws InterruptedException, IOException {
		List<String> primaryBarcodesSingle = new ArrayList<>();
		primaryBarcodesSingle.add(BGcode1);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), BGcode1);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
	
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
	    
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_kitActivatedToaster(), Duration.ofSeconds(20));
		assertTrue(activate_test_kit_locators.get_kitActivatedToaster().isDisplayed());
		System.out.println("Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +BGcode1);
		ExtentManager.getTest().log(Status.PASS, "Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +BGcode1);
			
	}
	
	public void activateKitMultipleBarcodeDouble() throws InterruptedException, IOException {
		List<String> primaryBarcodesSingle = new ArrayList<>();
		primaryBarcodesSingle.add(MGcode2);
		
		for (String barcode : primaryBarcodesSingle) {
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), barcode);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		    Thread.sleep(2000);
		    WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		    Thread.sleep(2000);
		    WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		    WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_kitActivatedToaster(), Duration.ofSeconds(20));
			System.out.println("Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			assertTrue(activate_test_kit_locators.get_kitActivatedToaster().isDisplayed());
			ExtentManager.getTest().log(Status.PASS, "Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			}
	}
	
	public void activateKitMultipleBarcodeBootsPrivateDouble() throws InterruptedException {
		List<String> primaryBarcodesSingle = new ArrayList<>();
		primaryBarcodesSingle.add(BGcode2);
		
		for (String barcode : primaryBarcodesSingle) {
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), barcode);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);

			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_kitActivatedToaster(), Duration.ofSeconds(20));
			System.out.println("Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			assertTrue(activate_test_kit_locators.get_kitActivatedToaster().isDisplayed());
			ExtentManager.getTest().log(Status.PASS, "Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			}
	}
	
	public void activateKitMultipleBarcodeDoubleBlue() throws InterruptedException, IOException {
		List<String> primaryBarcodesSingle = new ArrayList<>();
		primaryBarcodesSingle.add(MGcode3);
		
		for (String barcode : primaryBarcodesSingle) {
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_shTestActivateKitBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_shTestActivateKitBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), barcode);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
			Thread.sleep(2000);
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		    Thread.sleep(2000);
		    WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		    Thread.sleep(2000);
		    WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		    WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
			WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_shTestWarningCloseBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(activate_test_kit_locators.get_shTestWarningCloseBtn(), driver);
			WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
			WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_kitActivatedToaster(), Duration.ofSeconds(20));
			System.out.println("Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			assertTrue(activate_test_kit_locators.get_kitActivatedToaster().isDisplayed());
			ExtentManager.getTest().log(Status.PASS, "Validation: "+activate_test_kit_locators.get_kitActivatedToaster().getText()+" for " +barcode);
			}
	}
	
	
	
	/*
	 * public void emptyFirstName() throws InterruptedException {
	 * WebWait.visibilityOfElement(driver,
	 * createAccountLocators.get_createAccountButtonPageFirst(),
	 * Duration.ofSeconds(10));
	 * WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst(
	 * )); Thread.sleep(3000);
	 * WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" +
	 * randomGenerator());
	 * WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" +
	 * randomGenerator() + "@gmail.com");
	 * WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" +
	 * randomGenerator()); WebScrollView.scrollToElement(driver,
	 * createAccountLocators.get_marketingConsentCheckbox());
	 * WebButton.clickButton(createAccountLocators.get_createBtn());
	 * Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().
	 * isDisplayed(), "Without First name account is created"); }
	 */

}
