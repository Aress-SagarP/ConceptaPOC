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
	Health_Assessment_Locators health_assessment_locators;
	Login_Action login_action;
	public static String Barcode1;
	public static String Barcode2;
	public static String formattedDate;
	public static String validationMsg;
	ReadGmail read_gmail = new ReadGmail();

	public Activate_Test_Kit_Actions(WebDriver driver) {
		this.driver = driver;
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		customer_landing_locators = new Customer_Landing_Locators(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
		login_action = new Login_Action(driver);
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
		//WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB ");
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
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Error Msg Dot Displayed");
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
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Error Msg Dot Displayed");
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
        return modifiedDate.format(formatter);
    }
	
	public void sensitiveInfoNotDisplayed() {
		System.out.println("Error Message: "+activate_test_kit_locators.get_errorMsg().getText());
		Assert.assertTrue(activate_test_kit_locators.get_errorMsg().isDisplayed(),
				"Sensitive information is displayed");
		ExtentManager.getTest().log(Status.PASS, "Error Message: "+activate_test_kit_locators.get_errorMsg().getText());
	}
	
	public void verifyTrackingNumIsAutopopulated() throws InterruptedException, IOException {
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
		
		login_action.login_Dashboard2();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
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
