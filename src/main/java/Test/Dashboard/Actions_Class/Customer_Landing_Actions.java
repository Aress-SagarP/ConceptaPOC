package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Customer_Landing_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.CalendlyCalendar;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.ExtentManager;

public class Customer_Landing_Actions {

	public WebDriver driver;
	// public static String Barcode1;
	public static String kitId;
	public static String timsKitType;
	public static String timsBookingRef;
	public static String timsStatus;
	 
	public static String expectedBookingReference;
	public static String expectedBarcode ;
	public static String expectedType ;
	public static String expectedStatus;
	
	
	Map<String, String> expectedResults = new HashMap<>();
	
	Customer_Landing_Locators customer_landing_locators;
	Health_Assessment_Locators health_assessment_locators;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Login_Action login_action;
	Login_Boot_Locators login_boot_locators;
	Health_Assessment_Actions health_assessment_actions;
	public Activate_Test_Kit_Actions activate_test_kit_actions;

	public Customer_Landing_Actions(WebDriver driver) {
		this.driver = driver;
		customer_landing_locators = new Customer_Landing_Locators(driver);
		health_assessment_locators = new Health_Assessment_Locators(driver);
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		login_action = new Login_Action(driver);
		login_boot_locators = new Login_Boot_Locators(driver);
		health_assessment_actions = new Health_Assessment_Actions(driver);
		activate_test_kit_actions = new Activate_Test_Kit_Actions(driver);
		activate_test_kit_actions.setCustomerLandingActions(this);
	}

	public WebElement getViewTestBtn(String Barcode1) {
		String xpath = "//code[text()='" + Barcode1
				+ "']/ancestor::div[@data-testid='link-card']//a[normalize-space()='View test']";
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getViewResultsBtn(String Barcode1) {
		String xpath = "//code[text()='" + Barcode1
				+ "']/ancestor::div[@data-testid='link-card']//a[normalize-space()='View results']";
		return driver.findElement(By.xpath(xpath));
	}

	public void activateTestKitBloodHarmoneTest() throws InterruptedException, IOException {
		health_assessment_actions.generateBarcodeBloodHormoneTest();

		login_action.login_dashboard_staging();
		
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		
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
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");

		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
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
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);

	}

	public void verifyTimelineStatuses() throws InterruptedException, IOException {
		activateTestKitBloodHarmoneTest();
		WebWait.visibilityListOfElements(driver, customer_landing_locators.get_timelineTitlesBHT(),
				Duration.ofSeconds(20));
		Thread.sleep(3000);
		List<String> expectedTitles = List.of(
			    "Test activated",
			    "Complete assessment",
			    "Sample taken & returned",
			    "Analysed at lab",
			    "In review with a doctor",
			    "Get results"
			);	
		
		List<WebElement> titles = customer_landing_locators.get_timelineTitlesBHT();
		List<String> actualTitles = new ArrayList<>();
		StringBuilder reportLog = new StringBuilder();
		reportLog.append("Titles displayed:<br>");
		System.out.println("Timeline Titles:");
		int count = 1;
		for (WebElement title : titles) {
			String text = title.getText().trim();
			assertTrue(title.isDisplayed(), "Timeline title not displayed: " + text);
			actualTitles.add(text);
			System.out.println(count + ". " + text);
			reportLog.append(count).append(". ").append(text).append("<br>");
			count++;
		}
		assertEquals(actualTitles, expectedTitles, "Timeline titles do not match expected list!");
		System.out.println("Timeline titles matched expected values.");
		ExtentManager.getTest().log(Status.PASS, reportLog.toString());
		ExtentManager.getTest().log(Status.PASS, "Timeline titles matched expected values.");
	}
	
	public void verifyDynamicTimelineUpdate() throws InterruptedException, IOException {
		activateTestKitBloodHarmoneTest();
		WebWait.visibilityListOfElements(driver, customer_landing_locators.get_timelineTitlesBHT(),
				Duration.ofSeconds(20));
		Thread.sleep(3000);
		List<WebElement> titles = customer_landing_locators.get_timelineTitlesBHT();
		System.out.println("Before update: "+titles.get(1).getText());
		ExtentManager.getTest().log(Status.INFO, "Before filling assessment: "+titles.get(1).getText());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_fillAssessmentTimelineBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_fillAssessmentTimelineBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);

		// Form2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		health_assessment_actions.selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		health_assessment_actions.selectOptionSmokeCigarettes("Yes");
		health_assessment_actions.selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_cycleLengthDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_dayOfCycleDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_contraceptionDrp(), "1", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_successAssessmentSubmissionAlert(), Duration.ofSeconds(20));
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_assessmentCompletedTimelineTitle(), Duration.ofSeconds(20));
		String actualTitle = customer_landing_locators.get_assessmentCompletedTimelineTitle().getText();
		System.out.println("After filling assessment: "+actualTitle);
		assertEquals(actualTitle, "Assessment completed","Title mismatch");
		ExtentManager.getTest().log(Status.PASS, "After filling assessment: "+actualTitle);
		Thread.sleep(2000);
	}
	
	public void verifyTimelineForCompletedTestSteps() {
		int completedStepsSize = customer_landing_locators.get_completedStepsCount();
		int greenTickSize = customer_landing_locators.get_greenCheckIconCount();
		
		List<WebElement> completedStepTitles = customer_landing_locators.get_completedStepTitles();
		
		List<String> titles = new ArrayList<>();
        for (WebElement title : completedStepTitles) {
            titles.add(title.getText().trim());
        }
        
        assertTrue(completedStepsSize == greenTickSize, "Green tick icon is not displayed for all completed steps!");
        System.out.println("Validation: "+"Completed steps are displayed with green tick");
        ExtentManager.getTest().log(Status.PASS, "Validation: "+"Completed steps are displayed with green tick");
        StringBuilder reportLog = new StringBuilder();
        reportLog.append("Completed Step Titles with green tick:<br>");
        List<String> completedTitles = titles;
        System.out.println("Completed Step Titles with green tick:");
        for (String title : completedTitles) {
            System.out.println(" - " + title);
            reportLog.append("-").append(title).append("<br>");
        }
        ExtentManager.getTest().log(Status.PASS, reportLog.toString());
	}
	
	public void incompleteTestKitActivation() throws InterruptedException, IOException {
		health_assessment_actions.generateBarcodeBloodHormoneTest();

		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox());
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");

		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(),
				health_assessment_actions.getSystemCurrentDate());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		String stepAltText = "Test activated";
		assertFalse(isGreenTickDisplayedForStep(stepAltText), "Green tick should NOT be visible for step: " + stepAltText);
		System.out.println("Green tick is not displayed for \"" + stepAltText + "\"");
		ExtentManager.getTest().log(Status.PASS, "Green tick is not displayed for \"" + stepAltText + "\"");
		Thread.sleep(2000);
	}
	
	public boolean isGreenTickDisplayedForStep(String stepAltText) {
	    try {
	        WebElement iconContainer = driver.findElement(By.xpath(
	            "//img[@alt='" + stepAltText + "']/ancestor::div[contains(@class, 'timeline__img-container')]/div[contains(@class, 'timeline__icon')]"
	        ));

	        WebElement greenCheck = iconContainer.findElement(By.xpath(".//svg[contains(@class, 'fa-check')]"));

	        return greenCheck.isDisplayed(); 
	    } catch (NoSuchElementException e) {
	        return false; 
	    }
	}
	
	public void timelineForRejectedKit() throws InterruptedException, IOException {
		verifyDynamicTimelineUpdate();
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(),Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitAsRejectedChkbox(), Duration.ofSeconds(20));
		WebCheckBox.checkBoxTest(health_assessment_locators.get_markKitAsRejectedChkbox());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_selectRejectReasonDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_selectRejectReasonDrp(), "1", driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsRejectedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsRejectedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_kitRejectedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_kitRejectedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_kitRejectedAlert().getText());
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_rejectedKitRedIcon(), Duration.ofSeconds(20));
		boolean status = customer_landing_locators.get_rejectedKitRedIcon().isDisplayed();
		System.out.println("\"Sample taken & returned\" has red icon: " +status);
		assertTrue(status, "Red icon is not displayed");
		ExtentManager.getTest().log(Status.PASS, "\"Sample taken & returned\" has red icon: " +status);
		Thread.sleep(2000);
	}
	
	public void verifyTimelineForDnaTests() throws IOException, InterruptedException {
		health_assessment_actions.verifySuccessfulHealthAssessmentForDNATest();
		WebWait.visibilityListOfElements(driver, customer_landing_locators.get_timelineTitlesDNATest(),
				Duration.ofSeconds(20));
		Thread.sleep(3000);
		List<String> expectedTitles = List.of(
			    "Test Purchased",
			    "Kit Dispatched",
			    "Sample Collected & Kit Activated",
			    "Awaiting Sample Return",
			    "Lab Analysis",
			    "Get Results"
			);	
		
		List<WebElement> titles = customer_landing_locators.get_timelineTitlesDNATest();
		List<String> actualTitles = new ArrayList<>();
		StringBuilder reportLog = new StringBuilder();
		reportLog.append("Titles displayed:<br>");
		System.out.println("Timeline Titles:");
		int count = 1;
		for (WebElement title : titles) {
			String text = title.getText().trim();
			assertTrue(title.isDisplayed(), "Timeline title not displayed: " + text);
			actualTitles.add(text);
			System.out.println(count + ". " + text);
			reportLog.append(count).append(". ").append(text).append("<br>");
			count++;
		}
		assertEquals(actualTitles, expectedTitles, "Timeline titles do not match expected list!");
		System.out.println("Timeline titles matched expected values.");
		ExtentManager.getTest().log(Status.PASS, reportLog.toString());
		ExtentManager.getTest().log(Status.PASS, "Timeline titles matched expected values.");
		
		int completedStepsSize = customer_landing_locators.get_completedStepsTitlesCountDNA();
		int greenTickSize = customer_landing_locators.get_completedStepsCountGreenTickDNA();
		
		List<WebElement> completedStepTitles = customer_landing_locators.get_completedStepsTitleDNA();
		
		List<String> titlesDNA = new ArrayList<>();
        for (WebElement title : completedStepTitles) {
        	titlesDNA.add(title.getText().trim());
        }
        
        assertTrue(completedStepsSize == greenTickSize, "Green tick icon is not displayed for all completed steps!");
        System.out.println("Validation: "+"Completed steps are displayed with green tick");
        ExtentManager.getTest().log(Status.PASS, "Validation: "+"Completed steps are displayed with green tick");
        StringBuilder reportLogDNA = new StringBuilder();
        reportLogDNA.append("Completed Step Titles with green tick:<br>");
        List<String> completedTitles = titlesDNA;
        System.out.println("Completed Step Titles with green tick:");
        for (String title : completedTitles) {
            System.out.println(" - " + title);
            reportLogDNA.append("-").append(title).append("<br>");
        }
        ExtentManager.getTest().log(Status.PASS, reportLogDNA.toString());	
	}

	public void verifyTimelineForRejectedDNATest() throws IOException, InterruptedException {
		//verifyTimelineForDnaTests();
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(),Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitAsRejectedChkbox(), Duration.ofSeconds(20));
		WebCheckBox.checkBoxTest(health_assessment_locators.get_markKitAsRejectedChkbox());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_selectRejectReasonDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_selectRejectReasonDrp(), "1", driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsRejectedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsRejectedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_kitRejectedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_kitRejectedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_kitRejectedAlert().getText());
		Thread.sleep(5000);
		expectedBookingReference = customer_landing_locators.get_timsBookingReferenceTxt().getText();
		expectedBarcode = Health_Assessment_Actions.Barcode1;
		expectedType = customer_landing_locators.get_timsKitTypeTxt().getText();
		expectedStatus = customer_landing_locators.get_timsStatusTxt().getText();
		
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(20000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_rejectedKitRedIconDNA(), Duration.ofSeconds(20));
		boolean status = customer_landing_locators.get_rejectedKitRedIconDNA().isDisplayed();
		System.out.println("Sample Received\" has red icon: " +status);
		assertTrue(status, "Red icon is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Sample Received\" has red icon: " +status);
		Thread.sleep(2000);
	}
	
	public void verifyFillAssemetBtnIsDisplayed() throws InterruptedException, IOException {
		health_assessment_actions.generateBarcodeBloodHormoneTest();
		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_activateTestSideMenuItem());
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn());
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		health_assessment_actions.selectSexAtBirth("Female");
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_ethnicityRadioBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_ethnicityRadioBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), health_assessment_actions.getSystemCurrentDate());
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(),  Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_msgTestKitActivatedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(30));
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_testSummaryFillAssessBtn(), Duration.ofSeconds(20));
		System.out.println("Button displayed: "+customer_landing_locators.get_testSummaryFillAssessBtn().getText());
		assertTrue(customer_landing_locators.get_testSummaryFillAssessBtn().isDisplayed(), "Fill assessment button is not displayed");
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_plsCompleteHealthAssessmentMsg(), Duration.ofSeconds(20));
		System.out.println("Message displayed: "+customer_landing_locators.get_plsCompleteHealthAssessmentMsg().getText());
		assertTrue(customer_landing_locators.get_plsCompleteHealthAssessmentMsg().isDisplayed(), "Message is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Button displayed: "+customer_landing_locators.get_testSummaryFillAssessBtn().getText());
		ExtentManager.getTest().log(Status.PASS, "Message displayed: "+customer_landing_locators.get_plsCompleteHealthAssessmentMsg().getText());
	}
	
	public void verifyEditAssessBtnWhenHAFilled() throws InterruptedException {
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_testSummaryFillAssessBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_testSummaryFillAssessBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		health_assessment_actions.selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		health_assessment_actions.selectOptionSmokeCigarettes("Yes");
		health_assessment_actions.selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(2000);
		WebDropDown.selectByIndex(health_assessment_locators.get_cycleLengthDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_dayOfCycleDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_contraceptionDrp(), "1", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_successAssessmentSubmissionAlert(), Duration.ofSeconds(20));
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(30));
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_testSummaryEditAssessBtn(), Duration.ofSeconds(20));
		System.out.println("Button displayed: "+customer_landing_locators.get_testSummaryEditAssessBtn().getText());
		assertTrue(customer_landing_locators.get_testSummaryEditAssessBtn().isDisplayed(), "Fill assessment button is not displayed");
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_feelFreeToEditAssessmentMsg(), Duration.ofSeconds(20));
		System.out.println("Message displayed: "+customer_landing_locators.get_feelFreeToEditAssessmentMsg().getText());
		assertTrue(customer_landing_locators.get_feelFreeToEditAssessmentMsg().isDisplayed(), "Message is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Button displayed: "+customer_landing_locators.get_testSummaryEditAssessBtn().getText());
		ExtentManager.getTest().log(Status.PASS, "Message displayed: "+customer_landing_locators.get_feelFreeToEditAssessmentMsg().getText());
	}
	
	public void verifyCalendlyCalendarWithMsg() throws InterruptedException, IOException {
		health_assessment_actions.verifyAdditionalStepForSexualHealth();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_sexuallyActiveDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_sexuallyActiveDrp(), "2", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_stiDiagnosedDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_stiDiagnosedDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_stiSymptomsDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_stiSymptomsDrp(), "2", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_potentialSTIExposureDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_potentialSTIExposureDrp(), "2", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_assessmentSubmitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		String successMsg = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + successMsg);
		assertTrue(health_assessment_locators.get_successAssessmentSubmissionAlert().isDisplayed(),
				"Assessment not submitted");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + successMsg);
		
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode2);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_chooseFileInputBloodResultCSV(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.shTestGoldUnconfirmed , customer_landing_locators.get_chooseFileInputBloodResultCSV(), "MGE-EEB-1208", Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(customer_landing_locators.get_bloodResultsCsvUploadBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg().getText());
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_chooseFileInputBloodResultCSV(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.shTestBlueUnconfirmed , customer_landing_locators.get_chooseFileInputBloodResultCSV(), "MBY-UUD-5445", Health_Assessment_Actions.Barcode2);
		WebButton.JsclickButton(customer_landing_locators.get_bloodResultsCsvUploadBtn(), driver);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement testkitId = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a"));
	    new WebDriverWait(driver, Duration.ofSeconds(20))
	        .until(ExpectedConditions.visibilityOf(testkitId));
		kitId = testkitId.getText();
		System.out.println("Test kit id: "+kitId);
		ExtentManager.getTest().log(Status.PASS, "Test kit id: "+kitId);
		
		WebButton.JsclickButton(customer_landing_locators.get_testKitId(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_viewReportLnkText(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_viewReportLnkText(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerMenuAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerMenuAssignBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_popUpAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_popUpAssignBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_doctorAssignedAlert(), Duration.ofSeconds(30));
		System.out.println("Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_shConsultationRequiredBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_shConsultationRequiredBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_shConsultationRequiredAlertYesBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_shConsultationRequiredAlertYesBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_bookingMailSentAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+customer_landing_locators.get_bookingMailSentAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_bookingMailSentAlert().getText());
		
		login_action.navToStagingDashboard();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(40));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(30));
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_phoneConsultationRequiredTitle(), Duration.ofSeconds(20));
		String actualConsultatonReqMsg = customer_landing_locators.get_phoneConsultationRequiredTitle().getText().trim();
		String expectedConsultationRequiredMsg = "Phone consultation required";
		System.out.println("Message: "+actualConsultatonReqMsg);
		assertEquals(actualConsultatonReqMsg, expectedConsultationRequiredMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualConsultatonReqMsg);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_shTestTimelineThankyouTxt(), Duration.ofSeconds(20));
		String actualThankYouMsg = customer_landing_locators.get_shTestTimelineThankyouTxt().getText().trim();
		String expectedThankYouMsg = "Thank you for choosing our services for your sexual health test. We understand that discussing your results can "
				+ "be a sensitive topic, and we want to assure you that we will communicate with you in a professional, non-judgmental, and caring manner.";
		System.out.println("Message: "+actualThankYouMsg);
		assertEquals(actualThankYouMsg, expectedThankYouMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualThankYouMsg);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_shTestTimelineToScheduleAppointmentTxt(), Duration.ofSeconds(20));
		String actualScheduleAppointmentMsg = customer_landing_locators.get_shTestTimelineToScheduleAppointmentTxt().getText().trim();
		String expectedScheduleAppointmentMsg = "To schedule an appointment with our Doctors and discuss your test results, please select a date & time below:";
		System.out.println("Message: "+actualScheduleAppointmentMsg);
		assertEquals(actualScheduleAppointmentMsg, expectedScheduleAppointmentMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualScheduleAppointmentMsg);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_shTestTimelinePleaseNoteTxt(), Duration.ofSeconds(20));
		String actualPleaseNoteMsg = customer_landing_locators.get_shTestTimelinePleaseNoteTxt().getText().trim();
		String expectedPleaseNoteMsg = "Please note that you have the option to reschedule your appointment up to 24 hours prior to the scheduled consultation.";
		System.out.println("Message: "+actualPleaseNoteMsg);
		assertEquals(actualPleaseNoteMsg, expectedPleaseNoteMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualPleaseNoteMsg);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_calendlyCalendar(), Duration.ofSeconds(20));
		System.out.println("Calendar: "+customer_landing_locators.get_calendlyCalendar().getAttribute("title"));
		assertTrue(customer_landing_locators.get_calendlyCalendar().isDisplayed(), "Calendar is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Calendar: "+customer_landing_locators.get_calendlyCalendar().getAttribute("title"));
		
	}
	
	public void verifyTimelineForBloodSHTest() throws InterruptedException {
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_shTestTimelineConsultationReqTitle(), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, customer_landing_locators.get_shTestTimelineConsultationReqTitle());
		Thread.sleep(3000);
		String consultationRequired = customer_landing_locators.get_shTestTimelineConsultationReqTitle().getText();
		System.out.println("Additional Timeline Step: "+consultationRequired);
		assertEquals(consultationRequired, "Consultation required");
		ExtentManager.getTest().log(Status.PASS, "Additional Timeline Step: '"+consultationRequired+"' is displayed");
	}
	
	public void verifySuccsessfulAppointmentBooking() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement iframeCalendar = customer_landing_locators.get_calendlyCalendar();
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, iframeCalendar);
		Thread.sleep(5000);
		driver.switchTo().frame(iframeCalendar);
		
		CalendlyCalendar.selectDateAfterTwoDaysSkippingWeekends(customer_landing_locators.get_calendlyCalendarDates());
		Thread.sleep(10000);
		//WebWait.ListOfelementsToBeClickable(driver, customer_landing_locators.get_calendlyCalendarTimes(), Duration.ofSeconds(20));
		CalendlyCalendar.selectTime(driver, customer_landing_locators.get_calendlyCalendarTimes());
		Thread.sleep(10000);
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_calendlyCalendarNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_calendlyCalendarNextBtn(), driver);
		//Thread.sleep(2000);
		Thread.sleep(10000);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_calendlyCalendarScheduleEventBtn(), Duration.ofSeconds(20));
		//Thread.sleep(2000);
		Thread.sleep(10000);
		WebButton.clickButton(customer_landing_locators.get_calendlyCalendarScheduleEventBtn());
		//Thread.sleep(2000);
		Thread.sleep(10000);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_calendlyCalendarSuccessfulAppointmentMsg(), Duration.ofSeconds(20));
		System.out.println("Message: "+customer_landing_locators.get_calendlyCalendarSuccessfulAppointmentMsg().getText());
		assertTrue(customer_landing_locators.get_calendlyCalendarSuccessfulAppointmentMsg().isDisplayed(), "Appointment not booked");
		ExtentManager.getTest().log(Status.PASS, "Message: "+customer_landing_locators.get_calendlyCalendarSuccessfulAppointmentMsg().getText());
		
		driver.switchTo().defaultContent();
	}
	
	public void verifyReportViewFunctionality() throws IOException, InterruptedException {
		health_assessment_actions.verifyAdditionalStepForSexualHealth();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_sexuallyActiveDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_sexuallyActiveDrp(), "2", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_stiDiagnosedDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_stiDiagnosedDrp(), "1", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_stiSymptomsDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_stiSymptomsDrp(), "2", driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_potentialSTIExposureDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(health_assessment_locators.get_potentialSTIExposureDrp(), "2", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_assessmentSubmitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		String successMsg = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + successMsg);
		assertTrue(health_assessment_locators.get_successAssessmentSubmissionAlert().isDisplayed(),
				"Assessment not submitted");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + successMsg);
		
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode2);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_chooseFileInputBloodResultCSV(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.shTestGold_csv, customer_landing_locators.get_chooseFileInputBloodResultCSV(), "MGE-EEB-1208", Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(customer_landing_locators.get_bloodResultsCsvUploadBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_bloodResultsCsvUploadSuccessMsg().getText());
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_chooseFileInputBloodResultCSV(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.shTestBlue_csv , customer_landing_locators.get_chooseFileInputBloodResultCSV(), "MBY-UUD-5445", Health_Assessment_Actions.Barcode2);
		WebButton.JsclickButton(customer_landing_locators.get_bloodResultsCsvUploadBtn(), driver);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement testkitId = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/a"));
	    new WebDriverWait(driver, Duration.ofSeconds(20))
	        .until(ExpectedConditions.visibilityOf(testkitId));
		kitId = testkitId.getText();
		System.out.println("Test kit id: "+kitId);
		ExtentManager.getTest().log(Status.PASS, "Test kit id: "+kitId);
		
		WebButton.JsclickButton(customer_landing_locators.get_testKitId(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_viewReportLnkText(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_viewReportLnkText(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerMenuAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerMenuAssignBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_popUpAssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_popUpAssignBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_doctorAssignedAlert(), Duration.ofSeconds(30));
		System.out.println("Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_doctorAssignedAlert().getText());
		
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_navTabReportBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_navTabReportBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_reportTabGeneralBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_reportTabGeneralBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_overallStatusDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(customer_landing_locators.get_overallStatusDrp(), "1", driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElementAndClick(driver, customer_landing_locators.get_reportTabSexualHealthBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_groupStatusDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByIndex(customer_landing_locators.get_groupStatusDrp(), "1", driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElementAndClick(driver, customer_landing_locators.get_reportTabSaveChangesBtn());
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_changesSavedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+customer_landing_locators.get_changesSavedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_changesSavedAlert().getText());
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerMenuPublishBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerMenuPublishBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_publishReportYesBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_publishReportYesBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_reportPublishedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+customer_landing_locators.get_reportPublishedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_reportPublishedAlert().getText());
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewResultsBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewResultsBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		System.out.println("Validation: '"+getViewResultsBtn(Health_Assessment_Actions.Barcode1).getText()+"' is displayed");
		assertTrue(getViewResultsBtn(Health_Assessment_Actions.Barcode1).isDisplayed());
		ExtentManager.getTest().log(Status.PASS, "Validation: '"+getViewResultsBtn(Health_Assessment_Actions.Barcode1).getText()+"' is displayed");
		WebButton.JsclickButton(getViewResultsBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_doctorsLetterBtn(), Duration.ofSeconds(20));
		System.out.println("Validation: '"+customer_landing_locators.get_doctorsLetterBtn().getText()+"' is displayed");
		assertTrue(customer_landing_locators.get_doctorsLetterBtn().isDisplayed(), "Doctor's Letter is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: "+customer_landing_locators.get_doctorsLetterBtn().getText());
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_yourResultsBtn(), Duration.ofSeconds(20));
		System.out.println("Validation: '"+customer_landing_locators.get_yourResultsBtn().getText()+"' is displayed");
		assertTrue(customer_landing_locators.get_yourResultsBtn().isDisplayed(), "Your results is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Validation: '"+customer_landing_locators.get_yourResultsBtn().getText()+"' is displayed");
	}
	
	public void verifyTestSummaryBloodTest() throws InterruptedException, IOException {
		activateTestKitBloodHarmoneTest();
		Thread.sleep(3000);
		WebWait.visibilityListOfElements(driver, customer_landing_locators.get_testSummaryFieldBlocks(), Duration.ofSeconds(20));
		List<WebElement> fieldBlocks = customer_landing_locators.get_testSummaryFieldBlocks();
		System.out.println("Size:"+fieldBlocks.size());
		for (WebElement block : fieldBlocks) {
		    WebElement title = block.findElement(By.tagName("h4"));
		    WebElement value = block.findElement(By.tagName("h5"));

		    String fieldName = title.getText().trim();
		    String fieldValue = value.getText().trim();

		    System.out.println(fieldName + " - " + fieldValue);
		    ExtentManager.getTest().log(Status.PASS, fieldName + " - " + fieldValue);
		    
		    assertTrue(title.isDisplayed(), "Field name not displayed: " + fieldName);
		    assertTrue(value.isDisplayed(), "Field value not displayed for: " + fieldName);
		}
    }
	
	public void verifyGenderAtBirthOnTestSummary() {
		List<WebElement> fieldBlocks = customer_landing_locators.get_testSummaryFieldBlocks();
		WebElement genderAtBirthBlock = fieldBlocks.get(2);
		WebElement title = genderAtBirthBlock.findElement(By.tagName("h4"));
		WebElement value = genderAtBirthBlock.findElement(By.tagName("h5"));
		String genderAtBirthTitle = title.getText().trim();
		String genderAtBirthValue = value.getText().trim();
		System.out.println(genderAtBirthTitle+" - "+genderAtBirthValue);
		assertTrue(title.isDisplayed(), "Field name not displayed");
		assertTrue(value.isDisplayed(), "Field value not displayed");
		ExtentManager.getTest().log(Status.PASS, genderAtBirthTitle + " - " + genderAtBirthValue);
	}
	
	public void verifyDataPersistsOnPageRefresh() throws InterruptedException {
		List<WebElement> fieldBlocks = customer_landing_locators.get_testSummaryFieldBlocks();
		for (WebElement block : fieldBlocks) {
		    WebElement title = block.findElement(By.tagName("h4"));
		    WebElement value = block.findElement(By.tagName("h5"));

		    String fieldName = title.getText().trim();
		    String fieldValue = value.getText().trim();

		    System.out.println(fieldName + " - " + fieldValue);
		    ExtentManager.getTest().log(Status.PASS, fieldName + " - " + fieldValue);
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		System.out.println("After page reload: ");
		ExtentManager.getTest().log(Status.INFO, "After page reload: ");
		for (WebElement block : fieldBlocks) {
		    WebElement title = block.findElement(By.tagName("h4"));
		    WebElement value = block.findElement(By.tagName("h5"));

		    String fieldName = title.getText().trim();
		    String fieldValue = value.getText().trim();

		    System.out.println(fieldName + " - " + fieldValue);
		    ExtentManager.getTest().log(Status.PASS, fieldName + " - " + fieldValue);
		    assertTrue(title.isDisplayed(), "Field name not displayed: " + fieldName);
		    assertTrue(value.isDisplayed(), "Field value not displayed for: " + fieldName);
		}
	}
	
	private void loadExpectedResultsFromCSV(String csvPath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(csvPath));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",", -1);
            if (values.length >= 10) {
                String testName = values[8].trim(); 
                String result = values[9].trim();
                expectedResults.put(testName, result);
            } else {
                System.out.println("Skipped line due to insufficient columns: " + values.length + " -> " + line);
            }
        }
        br.close();
    }
	
	public void verifyBiomarkerDetailsSHTest() throws Exception {
		WebButton.JsclickButton(customer_landing_locators.get_yourResultsBtn(), driver);
		loadExpectedResultsFromCSV(WebCommonPath.shTestGold_csv);
		loadExpectedResultsFromCSV(WebCommonPath.shTestBlue_csv);
		System.out.println("Expected Results loaded from CSV:");
	    for (Map.Entry<String, String> entry : expectedResults.entrySet()) {
	        System.out.println("Expected Test: " + entry.getKey() + " - " + entry.getValue());
	        ExtentManager.getTest().log(Status.INFO, "Expected: " + entry.getKey() + " - " + entry.getValue());
	    }
		
		Map<String, String> actualResults = new HashMap<>();
		List<WebElement> biomarkerBlocks = customer_landing_locators.get_biomarkerFieldBlocksSHTest();
		
		for (int i = 0; i < Math.min(4, biomarkerBlocks.size()); i++) {
		    WebElement block = biomarkerBlocks.get(i);
		    try {
		        WebElement testNameElement = block.findElement(By.xpath(".//h2[@class='markerCard__title']"));
		        WebElement resultElement = block.findElement(By.xpath(".//div[@class='markerCard__result_container']"));

		        String testName = testNameElement.getText().trim();
		        String resultValue = resultElement.getText().trim();

		        actualResults.put(testName, resultValue);

		        System.out.println("Test: " + testName + " - " + resultValue);
		        ExtentManager.getTest().log(Status.INFO, "Extracted: " + testName + " - " + resultValue);

		    } catch (Exception e) {
		        ExtentManager.getTest().log(Status.WARNING, "Error extracting test result: " + e.getMessage());
		    }
		}
		
		Map<String, String> testNameAliases = new HashMap<>();
		testNameAliases.put("CLAU", "Chlamydia");
		testNameAliases.put("GON", "Gonorrhoea");
		testNameAliases.put("SYPH", "Syphilis");
		
		
		for (Map.Entry<String, String> entry : expectedResults.entrySet()) {
		    String expectedTest = entry.getKey();
		    String expectedValue = entry.getValue();

		    String normalizedTestName = testNameAliases.getOrDefault(expectedTest, expectedTest);
		    
		    if (actualResults.containsKey(normalizedTestName)) {
		        String actualValue = actualResults.get(normalizedTestName);
		        
		        assertEquals(actualValue, expectedValue, "Mismatch for test: " + expectedTest);
		        ExtentManager.getTest().log(Status.PASS, "Match: " + expectedTest + " - " + actualValue);
		    } else {
		        ExtentManager.getTest().log(Status.FAIL, "Missing test in UI: " + expectedTest);
		        fail("Missing test in UI: " + expectedTest);
		    }
		}
		
	}
	
	public void verifyFillAssessmentAfterResultUploadBHT() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);

		// Generate Barcode1
		WebButton.clickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createBloodBatchBtn());
		Thread.sleep(2000);
		WebDropDown.selectByText(activate_test_kit_locators.get_customerDrp(), "Boots");
		WebDropDown.selectByText(activate_test_kit_locators.get_typeDrp(), "blood");
		WebDropDown.selectByText(activate_test_kit_locators.get_subTypeDrp(), "Gold");
		WebTextBox.sendInput(activate_test_kit_locators.get_barcodeCountTxt(), "2");
		WebButton.clickButton(activate_test_kit_locators.get_saveBtn());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Health_Assessment_Actions.Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode(Gold): " + Health_Assessment_Actions.Barcode1);
		ExtentManager.getTest().log(Status.PASS, "Generated Barcode(Gold): " + Health_Assessment_Actions.Barcode1);
		
		// Create Test Kit
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);

		// Assign Test Kit
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_assignKitTypeHeaderMenu(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Menopause Profile Test");
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_AssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
		
		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Health_Assessment_Actions.Barcode1);
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
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), health_assessment_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.bloodHormoneMenopause , health_assessment_locators.get_uploadBloodResultCsvInput(), "MGM-QDH-1285", Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), driver);
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(20000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_fillAssessmentTimelineBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_fillAssessmentTimelineBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);

		// Form2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		health_assessment_actions.selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		health_assessment_actions.selectOptionSmokeCigarettes("Yes");
		health_assessment_actions.selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_cycleLengthDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_dayOfCycleDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_contraceptionDrp(), "1", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_successAssessmentSubmissionAlert(), Duration.ofSeconds(20));
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
	}
	
	public String getKitTypeAlias(String type) {
	    Map<String, String> testNameAliases = new HashMap<>();
	    testNameAliases.put("dna-weight", "Weight Management DNA Test");
	    testNameAliases.put("blood-male-sex-health", "Male sexual health test");
	    testNameAliases.put("blood-menopause", "Menopause profile test");
	    
	       return testNameAliases.getOrDefault(type, type);
	    }
	
	public String getKitStatusAlias(String status) {
		Map<String, String> testStatusAliases = new HashMap<>();
		testStatusAliases.put("error", "Rejected");
		
	       return testStatusAliases.getOrDefault(status, status);
	}
	   
	public void verifyTestSummaryForDNATestCommon(Map<String, String> expectedSummary) {
		int count=1;
		List<WebElement> fieldBlocks = customer_landing_locators.get_testSummaryFieldBlocks();
		System.out.println("Size:"+fieldBlocks.size());
		for (WebElement block : fieldBlocks) {
		    WebElement title = block.findElement(By.tagName("h4"));
		    WebElement value = block.findElement(By.tagName("h5"));

		    String fieldName = title.getText().trim();
		    String fieldValue = value.getText().trim();

		    System.out.println(count+". "+fieldName + " - " + fieldValue);
		    //ExtentManager.getTest().log(Status.PASS, fieldName + " - " + fieldValue);

		    assertTrue(title.isDisplayed(), "Field name not displayed: " + fieldName);
		    assertTrue(value.isDisplayed(), "Field value not displayed for: " + fieldName);
		    
		    System.out.println("Validations-- ");
		    
		    StringBuilder logBuilder = new StringBuilder();
		    logBuilder.append(count).append(". ").append(fieldName).append(" - ").append(fieldValue).append("<Br>");
		    logBuilder.append("Validations-- <br>");
		    
		    if (fieldName.equalsIgnoreCase("Test kit type")) {
	            
		    	String expectedDisplayType = getKitTypeAlias(expectedSummary.get("Type"));  // alias -> full name
	            assertEquals(fieldValue, expectedDisplayType, 
	                "Test kit type does not match expected mapped value");
	            System.out.println("Dashboard: "+fieldValue+" Tims: " +expectedSummary.get("Type"));
	            logBuilder.append("Dashboard: ").append(fieldValue).append(" Tims: ").append(expectedSummary.get("Type"));
	        } else if ("Status".equalsIgnoreCase(fieldName)) {
	        	
	        	String expectedDisplayStatus = getKitStatusAlias(expectedSummary.get("Status"));
	            assertEquals(fieldValue, expectedDisplayStatus, 
	                "Status field does not match expected value");
	            System.out.println("Dashboard: "+fieldValue+" Tims: " +expectedSummary.get("Status"));
	            logBuilder.append("Dashboard: ").append(fieldValue).append(" Tims: ").append(expectedSummary.get("Status"));
	        } else if ("Booking reference".equalsIgnoreCase(fieldName)) {
	            assertEquals(fieldValue, expectedSummary.get("Booking reference"), 
	                "Booking reference field does not match expected value");
	            System.out.println("Dashboard: "+fieldValue+" Tims: " +expectedSummary.get("Booking reference"));
	            logBuilder.append("Dashboard: ").append(fieldValue).append(" Tims: ").append(expectedSummary.get("Booking reference"));
	        } else if ("Barcode".equalsIgnoreCase(fieldName)) {
	            assertEquals(fieldValue, expectedSummary.get("Primary barcode"), 
	                "Barcode field does not match expected value");
	            System.out.println("Dashboard: "+fieldValue+" Tims: " +expectedSummary.get("Primary barcode"));
	            logBuilder.append("Dashboard: ").append(fieldValue).append(" Tims: ").append(expectedSummary.get("Primary barcode"));
	        } else if ("Tracking number".equalsIgnoreCase(fieldName)) {
	        	assertEquals(fieldValue, "AA 1245 7991 5AG", 
	        		"Barcode field does not match expected value");
	        	System.out.println("Dashboard: "+fieldValue+" Csv: AA 1245 7991 5AG");
	        	logBuilder.append("Dashboard: ").append(fieldValue).append(" Tims: ").append("Csv: AA 1245 7991 5AG");
			}
		    
		    ExtentManager.getTest().log(Status.PASS, logBuilder.toString());
		    count++;
		    
	    }
	}
	
	public void verifyTestSummaryForDNATest() {
		//int count=1;
		Map<String, String> expectedSummary = new HashMap<>();
		expectedSummary.put("Booking reference", expectedBookingReference);
		expectedSummary.put("Primary barcode", expectedBarcode);
		expectedSummary.put("Type", expectedType);
		expectedSummary.put("Status", expectedStatus);
		
		verifyTestSummaryForDNATestCommon(expectedSummary);
		
	}
	
	public void verifyDynamicTestUpdatesDNATests() {
		
		Map<String, String> expectedSummary = new HashMap<>();
		expectedSummary.put("Booking reference", expectedBookingReference);
		expectedSummary.put("Primary barcode", expectedBarcode);
		expectedSummary.put("Type", expectedType);
		expectedSummary.put("Status", expectedStatus);
		
		verifyTestSummaryForDNATestCommon(expectedSummary);
	}
	
	public void verifyDashboardUpdateForDnaTestResultsPublished() throws IOException, InterruptedException {
		
		health_assessment_actions.verifySuccessfulHealthAssessmentForDNATest();
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markKitNextBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerUploadDnaResultsCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerUploadDnaResultsCsvBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_chooseFileToUploadDna(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.dnaWeight, customer_landing_locators.get_chooseFileToUploadDna(), "CONCZ32114", Health_Assessment_Actions.Barcode1);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadDnaResultsPopUpBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadDnaResultsPopUpBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_dnaResultsUploadedConfAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+customer_landing_locators.get_dnaResultsUploadedConfAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_dnaResultsUploadedConfAlert().getText());
		
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultsTitleTxt(), Duration.ofSeconds(20));
		//Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1));
		Thread.sleep(2000);
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_dnaTestViewReportBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_dnaTestViewReportBtn(), driver);
		Thread.sleep(5000);
		WebWait.visibilityListOfElements(driver, customer_landing_locators.get_dnaTestReportHealthAreas(), Duration.ofSeconds(20));
		List<WebElement> healthAreas = customer_landing_locators.get_dnaTestReportHealthAreas();
		System.out.println("Displayed Health Areas:");
		StringBuilder reportLog = new StringBuilder();
		for(WebElement healthArea : healthAreas) {
			System.out.println(healthArea.getText());
			assertTrue(healthArea.isDisplayed(), "Health Area not dispayed: "+healthArea);
			reportLog.append(healthArea.getText()+"<br>");
		}
		
		ExtentManager.getTest().log(Status.PASS, "Health Areas displayed:<br> " +reportLog.toString());
		
	}
	
	public void generateSingleBarcode(String testType) throws InterruptedException, IOException {
		activate_test_kit_actions.dashboardUrlOfTims();
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
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesValue(), Duration.ofSeconds(20));
		Health_Assessment_Actions.Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode: " + Health_Assessment_Actions.Barcode1);
		ExtentManager.getTest().log(Status.INFO, "Generated Barcode: " + Health_Assessment_Actions.Barcode1);
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), testType);
		Thread.sleep(2000);
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Health_Assessment_Actions.Barcode1);
		Thread.sleep(3000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
	}
	
	public void activateTestKit() throws InterruptedException, IOException {
		login_action.login_dashboard_staging();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateKitOfBloofTestBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateKitOfBloofTestBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Health_Assessment_Actions.Barcode1);
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
		health_assessment_actions.selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		health_assessment_actions.selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), health_assessment_actions.getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
	}
	
	public void markKitAsReceived() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);
		
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markKitReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markKitReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_inputBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Health_Assessment_Actions.Barcode1);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
	}
	
	public void uploadBloodResultsCsv(String filePath, WebElement element, String targetText, String replacementText) throws IOException, InterruptedException {
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadBloodResultCsvBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadBloodResultCsvInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, filePath , element, targetText, replacementText);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_csvResultsfileUploadWindowUploadBtn(), driver);
	}
	
	public void uploadDNAResultsCsv(String filePath, WebElement element, String targetText, String replacementText) throws IOException {
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_headerUploadDnaResultsCsvBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_headerUploadDnaResultsCsvBtn(), driver);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_chooseFileToUploadDna(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, filePath, element, targetText, replacementText);
		WebWait.elementToBeClickable(driver, customer_landing_locators.get_uploadDnaResultsPopUpBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(customer_landing_locators.get_uploadDnaResultsPopUpBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_dnaResultsUploadedConfAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+customer_landing_locators.get_dnaResultsUploadedConfAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+customer_landing_locators.get_dnaResultsUploadedConfAlert().getText());
		
	}
	
	public void verifyFillEditAssessBtnAfterResultUpload() throws InterruptedException, IOException {
		generateSingleBarcode("Thyroid Profile Test");
		activateTestKit();
		markKitAsReceived();
		uploadBloodResultsCsv(WebCommonPath.thyroidProfileResults, health_assessment_locators.get_uploadBloodResultCsvInput(),
				"MGX-GZI-8171", Health_Assessment_Actions.Barcode1);
		login_action.navToStagingDashboard();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		Thread.sleep(25000);
		WebWait.visibilityOfElement(driver, driver.findElement(
			    By.xpath("//code[text()='" + Health_Assessment_Actions.Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(text(),'assessment')]")), Duration.ofSeconds(30));
		WebElement myResultsFillAssessmentBtn = driver.findElement(
			    By.xpath("//code[text()='" + Health_Assessment_Actions.Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(text(),'assessment')]"));
		WebWait.elementToBeClickable(driver, myResultsFillAssessmentBtn, Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, myResultsFillAssessmentBtn);
		Thread.sleep(3000);
		String  classAttribute = myResultsFillAssessmentBtn.getAttribute("class");
		boolean status = classAttribute.contains("disabled");
		System.out.println("Validation: Fill or edit assessment button is disabled");
		assertTrue(status, "Fill or edit assessment button is enabled");
		ExtentManager.getTest().log(Status.PASS, "Validation: Fill or edit assessment button is disabled");
	}
	
	public void screenResolutionSizesShowsAllWebelementsProperly(int width, int height)
			throws IOException, InterruptedException {
		/*
		 * {1920, 1080}, // Desktop full HD {1366, 768}, // Laptop {768, 1024}, //
		 * Tablet Portrait {375, 667}, // iPhone 8 {414, 896} // iPhone XR
		 */

		driver.manage().window().setSize(new Dimension(width, height));

		System.out.println("Testing resolution: " + width + "x" + height);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyLayoutConsistencyDb() throws IOException, InterruptedException {
		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		Thread.sleep(3000);
		screenResolutionSizesShowsAllWebelementsProperly(1920, 1080);
		screenResolutionSizesShowsAllWebelementsProperly(1366, 768);
		screenResolutionSizesShowsAllWebelementsProperly(768, 1024);
		screenResolutionSizesShowsAllWebelementsProperly(375, 667);
	}
	
	public void verifyErrorMessageUI() {
		List<WebElement> errorMessages = health_assessment_locators.get_healthAssessForm2AllerrorMsg();

		if (errorMessages.isEmpty()) {
			ExtentManager.getTest().log(Status.WARNING, "No error messages found on the form.");
			System.out.println("No error messages found on the form.");
			return;
		}

		boolean allDisplayed = true;

		for (WebElement errorMessage : errorMessages) {
			try {
				if (errorMessage.isDisplayed()) {
					String messageText = errorMessage.getText();
					ExtentManager.getTest().log(Status.PASS, "Error message is displayed: " + messageText);
					System.out.println("Displayed error message: " + messageText);
				} else {
					allDisplayed = false;
					ExtentManager.getTest().log(Status.FAIL, "Error message is NOT displayed.");
					System.out.println("An error message is NOT displayed.");
				}
			} catch (Exception e) {
				allDisplayed = false;
				ExtentManager.getTest().log(Status.WARNING, "Error checking message: " + e.getMessage());
				System.err.println("Error checking message: " + e.getMessage());
			}
		}
		Assert.assertTrue(allDisplayed, "One or more error messages are not displayed.");
	}
	
	public void verifyFontConsistency() {
		String actualConsultatonReqMsg = customer_landing_locators.get_phoneConsultationRequiredTitle().getText().trim();
		String expectedConsultationRequiredMsg = "Phone consultation required";
		System.out.println("Message: "+actualConsultatonReqMsg);
		assertEquals(actualConsultatonReqMsg, expectedConsultationRequiredMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualConsultatonReqMsg);
		
		String actualThankYouMsg = customer_landing_locators.get_shTestTimelineThankyouTxt().getText().trim();
		String expectedThankYouMsg = "Thank you for choosing our services for your sexual health test. We understand that discussing your results can "
				+ "be a sensitive topic, and we want to assure you that we will communicate with you in a professional, non-judgmental, and caring manner.";
		System.out.println("Message: "+actualThankYouMsg);
		assertEquals(actualThankYouMsg, expectedThankYouMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualThankYouMsg);
		
		String actualScheduleAppointmentMsg = customer_landing_locators.get_shTestTimelineToScheduleAppointmentTxt().getText().trim();
		String expectedScheduleAppointmentMsg = "To schedule an appointment with our Doctors and discuss your test results, please select a date & time below:";
		System.out.println("Message: "+actualScheduleAppointmentMsg);
		assertEquals(actualScheduleAppointmentMsg, expectedScheduleAppointmentMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualScheduleAppointmentMsg);
		
		String actualPleaseNoteMsg = customer_landing_locators.get_shTestTimelinePleaseNoteTxt().getText().trim();
		String expectedPleaseNoteMsg = "Please note that you have the option to reschedule your appointment up to 24 hours prior to the scheduled consultation.";
		System.out.println("Message: "+actualPleaseNoteMsg);
		assertEquals(actualPleaseNoteMsg, expectedPleaseNoteMsg, "Message mismatch");
		ExtentManager.getTest().log(Status.PASS, "Message: "+actualPleaseNoteMsg);
	}
	
	public void verifyScrollingForLongTestSummaries() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Long initialScroll = (Long) js.executeScript("return window.pageYOffset");
		System.out.println("Initial Scroll: "+initialScroll+" px");
		ExtentManager.getTest().log(Status.INFO, "Initial Scroll: "+initialScroll+" px");
		
		WebScrollView.scrollDownByPixel(driver, 300);
		Thread.sleep(3000);
		Long secondScroll = ((Long) js.executeScript("return window.pageYOffset"));
		System.out.println("Second Sroll: "+secondScroll+" px");
		ExtentManager.getTest().log(Status.PASS, "Second Scroll: "+secondScroll+" px");
		
		WebScrollView.scrollDownVertically(driver);
		Thread.sleep(2000);
		Long finalScroll = (Long) js.executeScript("return window.pageYOffset");
		System.out.println("Final Scroll: " + finalScroll+" px");
		ExtentManager.getTest().log(Status.PASS, "Final Scroll: " + finalScroll+" px");
		
		Assert.assertTrue(finalScroll > initialScroll, "Scroll did not occur as expected");
	}
	
	public void verifyWrappingOfLongText() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

         boolean isOverflowing = (Boolean) js.executeScript(
             "var elem = arguments[0];" +
             "return elem.scrollHeight > elem.clientHeight || elem.scrollWidth > elem.clientWidth;"
            		 , customer_landing_locators.get_containerConsultationReq()
         );

         assertFalse(isOverflowing,"Text is overflowing its container.");
         System.out.println("Text fits fully within its container.");
         ExtentManager.getTest().log(Status.PASS, "Text fits fully within its container.");
	}
	
	public void visualConsistencyOfTimelineSteps() {
		boolean status = customer_landing_locators.get_rejectedKitRedIcon().isDisplayed();
		System.out.println("Sample Taken & Returned\" has red icon: " +status);
		assertTrue(status, "Red icon is not displayed");
		ExtentManager.getTest().log(Status.PASS, "\"Sample taken & returned\" has red icon: " +status);
	}
	
	public void verifyVisibilityOfButtons() throws InterruptedException {
		health_assessment_actions.cancel_Appointment();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_confirmBtn(), Duration.ofSeconds(20));
		assertTrue(health_assessment_locators.get_confirmBtn().isDisplayed(), "Confirm & Continue button is not displayed");
		WebButton.JsclickButton(health_assessment_locators.get_confirmBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_submitBtn(), Duration.ofSeconds(20));
		assertTrue(health_assessment_locators.get_submitBtn().isDisplayed(), "Submit button is not displayed");
		WebButton.JsclickButton(health_assessment_locators.get_submitBtn(), driver);
		Thread.sleep(2000);
		WebCheckBox.checkBoxTest(health_assessment_locators.get_consentCheckBox());
		WebCheckBox.checkBoxTest(health_assessment_locators.get_termsCheckBox());
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		health_assessment_locators.get_submitBtn().submit();
	}
	
	public void verifyClickableAreaOfButton() throws InterruptedException {
		health_assessment_actions.cancel_Appointment();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_confirmBtn(), Duration.ofSeconds(20));
		assertTrue(health_assessment_locators.get_confirmBtn().isDisplayed(), "Confirm & Continue button is not displayed");
		assertTrue(health_assessment_locators.get_confirmBtn().isEnabled(), "Confirm & Continue button is not enabled");
		WebButton.JsclickButton(health_assessment_locators.get_confirmBtn(), driver);
		System.out.println("Confirm & Continue button is clickable");
		ExtentManager.getTest().log(Status.PASS, "Confirm & Continue button is clickable");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_submitBtn(), Duration.ofSeconds(20));
		assertTrue(health_assessment_locators.get_submitBtn().isDisplayed(), "Submit button is not displayed");
		assertTrue(health_assessment_locators.get_submitBtn().isEnabled(), "Submit button is not enabled");
		WebButton.JsclickButton(health_assessment_locators.get_submitBtn(), driver);
		System.out.println("Submit button is clickable");
		ExtentManager.getTest().log(Status.PASS, "Submit button is clickable");
		Thread.sleep(2000);
		WebCheckBox.checkBoxTest(health_assessment_locators.get_consentCheckBox());
		WebCheckBox.checkBoxTest(health_assessment_locators.get_termsCheckBox());
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		health_assessment_locators.get_submitBtn().submit();
	}
	
	public void verifyMessageDisplayedWhenNoTestAvailable() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_newUser_email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
		login_action.clickLoginButton_Dashboard();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_leftSideBarDashhboardBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarDashhboardBtn(), driver);
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_buyTestLinkCard(), Duration.ofSeconds(10));
		String buyTest = customer_landing_locators.get_buyTestLinkCard().findElement(By.xpath(".//strong")).getText();
		assertTrue(customer_landing_locators.get_buyTestLinkCard().isDisplayed(), "Buy tests link card is not displayed");
		System.out.println("Card displayed: " +buyTest);
		ExtentManager.getTest().log(Status.PASS, "Card displayed: " +buyTest);
		
		WebWait.visibilityOfElement(driver, customer_landing_locators.get_activateTestLinkCard(), Duration.ofSeconds(10));
		String activateTest = customer_landing_locators.get_activateTestLinkCard().findElement(By.xpath(".//strong")).getText();
		assertTrue(customer_landing_locators.get_activateTestLinkCard().isDisplayed(), "Buy tests link card is not displayed");
		System.out.println("Card displayed: " +activateTest);
		ExtentManager.getTest().log(Status.PASS, "Card displayed: " +activateTest);
		
	}
	
	public void verifyDashboardEmptyState() {
		String actualBuyTestMessage = customer_landing_locators.get_buyTestLinkCard().findElement(By.xpath(".//p")).getText();
		String expectedBuyTestMessage = "Get started today by buying a wellness test with us!";
		assertEquals(actualBuyTestMessage, expectedBuyTestMessage, "Message mismatch");
		System.out.println("Buy Test message: " +actualBuyTestMessage);
		ExtentManager.getTest().log(Status.PASS, "Buy Test message: " +actualBuyTestMessage);
		
		String actualActivateTestMessage = customer_landing_locators.get_activateTestLinkCard().findElement(By.xpath(".//p")).getText();
		String expectedActivateTestMessage = "Already have a test and need to get it activated?";
		assertEquals(actualActivateTestMessage, expectedActivateTestMessage, "Message mismatch");
		System.out.println("Activate Test message: " +actualActivateTestMessage);
		ExtentManager.getTest().log(Status.PASS, "Buy Test message: " +actualActivateTestMessage);
		
	}
	
}
