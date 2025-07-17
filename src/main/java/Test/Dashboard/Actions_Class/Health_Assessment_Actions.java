package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import Test.Dashboard.Locators_Class.Health_Assessment_Locators;
import Test.Tims.Actions_Class.Login_Action;
import Wrappers.CSVUploaderWithTextReplacement;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Health_Assessment_Actions {

	public WebDriver driver;
	public static String Barcode1;
	public static String Barcode2;
	public static String formattedDate;

	Health_Assessment_Locators health_assessment_locators;
	Activate_Test_Kit_Actions activate_test_kit_actions;
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Login_Action login_action;
	

	public Health_Assessment_Actions(WebDriver driver) {
		this.driver = driver;
		health_assessment_locators = new Health_Assessment_Locators(driver);
		activate_test_kit_actions = new Activate_Test_Kit_Actions(driver);
		activate_test_kit_locators = new Activate_Test_Kit_Locators(driver);
		login_action = new Login_Action(driver);
	}

	public void clickOnEnableLaterBtn() {
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(health_assessment_locators.get_enableLaterBtn());
	}

	public void cancel_Appointment() throws InterruptedException {
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(health_assessment_locators.get_enableLaterBtn());
		WebButton.clickButton(health_assessment_locators.get_bootsAppointmentAppMenuBtn());
		try {
			Thread.sleep(2000);
			WebButton.clickButton(health_assessment_locators.get_continueBtn());
		} catch (Exception e) {
			Thread.sleep(2000);
			WebButton.clickButton(health_assessment_locators.get_cancelRegistrationBtn());

			WebWait.elementToBeClickable(driver, health_assessment_locators.get_rejectConfirmBtn(),
					Duration.ofSeconds(20));
			WebButton.clickButton(health_assessment_locators.get_rejectConfirmBtn());
		}

	}

	public void navigate_To_Reg_Page() throws InterruptedException {
		clickOnEnableLaterBtn();
		try {
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_myRegistrationTitleTxt(),
					Duration.ofSeconds(30));
			String alert_expected = health_assessment_locators.get_myRegistrationTitleTxt().getText().trim();
			System.out.println("Registration Page Heading = " + alert_expected);
			String ActualValue = "MY REGISTRATION";
			assertEquals(ActualValue, alert_expected);
			assertTrue(health_assessment_locators.get_bootsAppointmentAppMenuBtn().isDisplayed());
			ExtentManager.getTest().log(Status.PASS, "Navigated to Registration Page");
		} catch (Exception e) {
			System.out.println("Registration is aleady In Progress.");
		}

	}

	public void navigateToConfirmDetails() throws InterruptedException {
		cancel_Appointment();
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(health_assessment_locators.get_continueBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_submitBtn(), driver);
		Thread.sleep(2000);
		WebCheckBox.checkBoxTest(health_assessment_locators.get_consentCheckBox());
		WebCheckBox.checkBoxTest(health_assessment_locators.get_termsCheckBox());
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 800).perform();
		health_assessment_locators.get_submitBtn().submit();
	}

	public void selectSexAtBirth(String sex) {
		if (sex.equalsIgnoreCase("Female")) {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_femaleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_femaleBtn(), driver);
		} else {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_maleBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_maleBtn(), driver);
		}
	}

	public void selectIfStillIdentifiesWithGender(String response) {
		if (response.equalsIgnoreCase("No")) {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderNoBtn(),
					Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderNoBtn(), driver);
		} else {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_identifyGenderYesBtn(),
					Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_identifyGenderYesBtn(), driver);
		}
	}

	public void selectUnit(String unit) {
		if (unit.equalsIgnoreCase("Imperial")) {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_imperialBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_imperialBtn(), driver);
		} else {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_metricBtn(), Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_metricBtn(), driver);
		}
	}

	public void selectMultipleMedicalConditions(List<String> conditions) {
		List<WebElement> listMedicalConditions = health_assessment_locators.get_listMedicalConditions();
		List<String> selectedConditions = new ArrayList<>();
		for (String conditionName : conditions) {
			for (WebElement checkbox : listMedicalConditions) {
				WebElement label = checkbox.findElement(By.xpath("following-sibling::label"));
				if (label.getText().equalsIgnoreCase(conditionName)) {
					if (!checkbox.isSelected()) {
						checkbox.click();
						selectedConditions.add(conditionName);
					}
					break;
				}
			}
		}
		System.out.println("Selected checkboxes(Medical Condition): " + String.join(", ", selectedConditions));
	}

	private WebElement getCheckboxForConditionName(String conditionName) {
		for (WebElement checkbox : health_assessment_locators.get_listMedicalConditions()) {
			WebElement label = checkbox.findElement(By.xpath("following-sibling::label"));
			if (label.getText().equalsIgnoreCase(conditionName)) {
				return checkbox;
			}
		}
		return null;
	}

	public void selectMultipleMedicalConditionsByName(List<String> conditions) {
		selectMultipleMedicalConditions(conditions);

		for (String conditionName : conditions) {
			WebElement checkbox = getCheckboxForConditionName(conditionName);
			assertTrue(checkbox.isSelected(), "The checkbox for " + conditionName + " was not selected!");
		}
	}

	public void confirmDetails(String dob, String mobNum) {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), dob);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), mobNum);
		selectSexAtBirth("Male");
		selectIfStillIdentifiesWithGender("Yes");
	}

	public void submitConfirmDetailsForm() throws InterruptedException {
		navigateToConfirmDetails();
		confirmDetails("03/01/1999", "3333333333");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueOnCfmDetailsBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueOnCfmDetailsBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_detailsCfrmAlert(), Duration.ofSeconds(20));
		String successMsg = health_assessment_locators.get_detailsCfrmAlert().getText();
		System.out.println("Alert: " + successMsg);
		assertEquals(successMsg, "User details confirmed!");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + successMsg);
	}

	public void selectOptionSmokeCigarettes(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_smokeCigarettesDrp(), "Yes");
			System.out.println("Do you Smoke Cigarettes?: "
					+ health_assessment_locators.get_smokeCigarettesDrp().getAttribute("value"));
			WebDropDown.selectByIndex(health_assessment_locators.get_cigarettesPerDayDrp(), "1", driver);
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_smokeCigarettesDrp(), "No");
			System.out.println("Do you Smoke Cigarettes?: "
					+ health_assessment_locators.get_smokeCigarettesDrp().getAttribute("value"));
		}
	}

	public void selectOptionDrinkalcohol(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_drinkAlcoholDrp(), "Yes");
			WebDropDown.selectByIndex(health_assessment_locators.get_alcoholPerWeekDrp(), "1", driver);
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_drinkAlcoholDrp(), "No");
		}
	}

	public void submitAssessmentForm2() {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
	}

	public void selectOptionPhysicalActivity(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			WebWait.elementToBeClickable(driver, health_assessment_locators.get_physicalActivityDrp(), Duration.ofSeconds(20));
			WebDropDown.selectByText(health_assessment_locators.get_physicalActivityDrp(), "Yes");
			WebDropDown.selectByText(health_assessment_locators.get_lightActivityDrp(), "1");
			WebDropDown.selectByText(health_assessment_locators.get_moderateActivityDrp(), "0");
			WebDropDown.selectByText(health_assessment_locators.get_vigorousActivityDrp(), "0");
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_physicalActivityDrp(), "No");
		}
	}

	public void submitAssessmentForm3() {
		selectOptionPhysicalActivity("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
	}

	public void selectOptionMedicalCondition(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_wasDiagnosedDrp(), "Yes");
			List<String> conditions = Arrays.asList("Diabetes", "Anaemia", "High blood pressure");
			selectMultipleMedicalConditionsByName(conditions);
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_wasDiagnosedDrp(), "No");
		}
	}

	public void submitAssessmentForm4() {
		selectOptionMedicalCondition("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
	}

	public void selectMedication(List<String> conditions) {
		List<WebElement> listMedication = health_assessment_locators.get_listMedications();
		List<String> selectedConditions = new ArrayList<>();
		for (String conditionName : conditions) {
			for (WebElement checkbox : listMedication) {
				WebElement label = checkbox.findElement(By.xpath("following-sibling::label"));
				if (label.getText().equalsIgnoreCase(conditionName)) {
					if (!checkbox.isSelected()) {
						checkbox.click();
						selectedConditions.add(conditionName);
					}
					break;
				}
			}
		}
		System.out.println("Selected checkboxes(Medication): " + String.join(", ", selectedConditions));
	}

	private WebElement getCheckboxForMediactionName(String medicationName) {
		for (WebElement checkbox : health_assessment_locators.get_listMedications()) {
			WebElement label = checkbox.findElement(By.xpath("following-sibling::label"));
			if (label.getText().equalsIgnoreCase(medicationName)) {
				return checkbox;
			}
		}
		return null;
	}

	public void selectMultipleMedicationByName(List<String> conditions) {
		selectMedication(conditions);
		for (String conditionName : conditions) {
			WebElement checkbox = getCheckboxForMediactionName(conditionName);
			assertTrue(checkbox.isSelected(), "The checkbox for " + conditionName + " was not selected!");
		}
	}

	public void selectOptionMedication(String option) {
		List<String> conditions = Arrays.asList("Heart medication", "Blood pressure medication");
		if (option.equalsIgnoreCase("Yes")) {
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_medicationDrp(), Duration.ofSeconds(10));
			WebDropDown.selectByText(health_assessment_locators.get_medicationDrp(), "Yes");
			selectMultipleMedicationByName(conditions);
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_medicationDrp(), "No");
		}
	}

	public void submitAssessmentForm5() {
		selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_successAssessmentSubmissionAlert(),
				Duration.ofSeconds(20));
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
	}

	public void verifySelectionOfMultipleChkboxesdiseases() {
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
	}

	public void verifyAssessmentSubmissionPageIsDisplayed() {
		String actualText = health_assessment_locators.get_appointmentConfirmationTitle().getText();
		System.out.println("Page: " + actualText);
		assertEquals(actualText, "APPOINTMENT CONFIRMATION");
	}

	public void verifyAdditionalOptionsSmoking_TC_05() {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		boolean status = health_assessment_locators.get_cigarettesPerDayDrp().isDisplayed();
		System.out.println(
				"Additional field:" + health_assessment_locators.get_cigarettesPerDayDrp().getAttribute("label"));
		assertTrue(status, "Additional field is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_cigarettesPerDayDrp().getAttribute("label"));

	}

	public void verifyAdditionalOptionsAlcohol_TC_06() {
		selectOptionDrinkalcohol("Yes");
		boolean status = health_assessment_locators.get_alcoholPerWeekDrp().isDisplayed();
		System.out.println(
				"Additional field:" + health_assessment_locators.get_alcoholPerWeekDrp().getAttribute("label"));
		assertTrue(status, "Additional field is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_alcoholPerWeekDrp().getAttribute("label"));
	}

	public void verifyAdditionalOptionsPhysicalActivity() {
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		selectOptionPhysicalActivity("Yes");
		boolean status = health_assessment_locators.get_lightActivityDrp().isDisplayed()
				&& health_assessment_locators.get_moderateActivityDrp().isDisplayed()
				&& health_assessment_locators.get_vigorousActivityDrp().isDisplayed();
		System.out
				.println("Additional field:" + health_assessment_locators.get_lightActivityDrp().getAttribute("label"));
		System.out.println(
				"Additional field:" + health_assessment_locators.get_moderateActivityDrp().getAttribute("label"));
		System.out.println(
				"Additional field:" + health_assessment_locators.get_vigorousActivityDrp().getAttribute("label"));
		assertTrue(status, "Additional field is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_lightActivityDrp().getAttribute("label"));
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_moderateActivityDrp().getAttribute("label"));
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_vigorousActivityDrp().getAttribute("label"));

	}

	public void verifyAdditionalOptionsMedicalConditions() {
		submitAssessmentForm3();
		selectOptionMedicalCondition("Yes");
		List<WebElement> medicalConditionCheckboxes = health_assessment_locators.get_listMedicalConditions();

		boolean allDisplayed = true;

		if (medicalConditionCheckboxes.isEmpty()) {
			ExtentManager.getTest().log(Status.WARNING, "No medical condition checkboxes found on the page.");
			Assert.fail("No medical condition checkboxes found on the page.");
		}

		for (int i = 0; i < medicalConditionCheckboxes.size(); i++) {
			WebElement checkbox = medicalConditionCheckboxes.get(i);
			try {
				if (checkbox.isDisplayed()) {
					ExtentManager.getTest().log(Status.PASS,
							"Medical condition checkbox at index " + i + " is displayed.");
				} else {
					allDisplayed = false;
					ExtentManager.getTest().log(Status.FAIL,
							"Medical condition checkbox at index " + i + " is NOT displayed.");
					System.out.println("Checkbox at index " + i + " is NOT displayed.");
				}
			} catch (Exception e) {
				allDisplayed = false;
				ExtentManager.getTest().log(Status.WARNING,
						"Exception checking checkbox at index " + i + ": " + e.getMessage());
				System.err.println("Exception at checkbox " + i + ": " + e.getMessage());
			}
		}

		Assert.assertTrue(allDisplayed, "One or more medical condition checkboxes are not displayed.");
	}

	public void verifyMedicalConditionOthersDescTextBox() throws InterruptedException {
		selectOptionMedicalCondition("Yes");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		List<String> conditions = Arrays.asList("Other");
		selectMultipleMedicalConditionsByName(conditions);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		boolean status = health_assessment_locators.get_medicalConditionOthersDescTxt().isDisplayed();
		System.out.println("Additional Field:"
				+ health_assessment_locators.get_medicalConditionOthersDescTxt().getAttribute("placeholder"));
		assertTrue(status, "Additional textbox is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Additional Field:"
				+ health_assessment_locators.get_medicalConditionOthersDescTxt().getAttribute("placeholder"));

	}

	public void verifyAdditionalOptionsMedications() {

		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		selectOptionMedication("Yes");
		List<WebElement> medicationCheckboxes = health_assessment_locators.get_listMedications();

		boolean allDisplayed = true;

		if (medicationCheckboxes.isEmpty()) {
			ExtentManager.getTest().log(Status.WARNING, "No medication checkboxes found on the page.");
			Assert.fail("No medication checkboxes found on the page.");
		}

		for (int i = 0; i < medicationCheckboxes.size(); i++) {
			WebElement checkbox = medicationCheckboxes.get(i);
			try {
				if (checkbox.isDisplayed()) {
					ExtentManager.getTest().log(Status.PASS, "Medication checkbox at index " + i + " is displayed.");
				} else {
					allDisplayed = false;
					ExtentManager.getTest().log(Status.FAIL,
							"Medication checkbox at index " + i + " is NOT displayed.");
					System.out.println("Checkbox at index " + i + " is NOT displayed.");
				}
			} catch (Exception e) {
				allDisplayed = false;
				ExtentManager.getTest().log(Status.WARNING,
						"Exception checking checkbox at index " + i + ": " + e.getMessage());
				System.err.println("Exception at checkbox " + i + ": " + e.getMessage());
			}
		}
		Assert.assertTrue(allDisplayed, "One or more medical condition checkboxes are not displayed.");
	}

	public void verifyValidationConditionalFields() {
		boolean status = health_assessment_locators.get_cigarettesPerDayDrp().isDisplayed();
		System.out.println(
				"Additional field:" + health_assessment_locators.get_cigarettesPerDayDrp().getAttribute("label"));
		assertTrue(status, "Additional field is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_cigarettesPerDayDrp().getAttribute("label"));

		boolean status2 = health_assessment_locators.get_alcoholPerWeekDrp().isDisplayed();
		System.out.println(
				"Additional field:" + health_assessment_locators.get_alcoholPerWeekDrp().getAttribute("label"));
		assertTrue(status2, "Additional field is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Additional field:" + health_assessment_locators.get_alcoholPerWeekDrp().getAttribute("label"));
	}

	public void verifyMedicationOthersDescTextBox() {
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		selectOptionMedication("Yes");
		List<String> conditions = Arrays.asList("Other - please specify in box below");
		selectMultipleMedicationByName(conditions);
		boolean status = health_assessment_locators.get_medicationOthersDescTxt().isDisplayed();
		System.out.println("Additional Field:"
				+ health_assessment_locators.get_medicationOthersDescTxt().getAttribute("placeholder"));
		assertTrue(status, "Additional textbox is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Additional Field:"
				+ health_assessment_locators.get_medicationOthersDescTxt().getAttribute("placeholder"));
	}

	public void verifyFunctionalityOfMedicalConditionTxtBox() {
		WebTextBox.sendInputUpdate(health_assessment_locators.get_medicalConditionOthersDescTxt(),
				"Medical Condition Test");
		String medicalConditon = health_assessment_locators.get_medicalConditionOthersDescTxt().getText();
		assertEquals(medicalConditon, "Medical Condition Test");
		ExtentManager.getTest().log(Status.PASS, "Input: " + medicalConditon);
	}

	public void verifyFunctionalityOfMedicationTxtBox() {
		WebTextBox.sendInputUpdate(health_assessment_locators.get_medicationOthersDescTxt(), "Medication Test");
		String medication = health_assessment_locators.get_medicationOthersDescTxt().getText();
		assertEquals(medication, "Medication Test");
		ExtentManager.getTest().log(Status.PASS, "Input: " + medication);
	}

	public void verifySubmittingHealthAssessWithoutData() throws InterruptedException {
		submitConfirmDetailsForm();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

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

	public void verifyErrorMessageDisplayedforEmptyFields() {
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

	public void verifyEditBtnFunctionalityHealthAssessment() {
		WebButton.JsclickButton(health_assessment_locators.get_editDetailsHealthAssessment(), driver);
		boolean status = health_assessment_locators.get_assessmentDetailsTitle().isDisplayed();
		System.out.println("Expected page: " + health_assessment_locators.get_assessmentDetailsTitle().getText());
		assertTrue(status, "Assessment details page is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Expected page: " + health_assessment_locators.get_assessmentDetailsTitle().getText());
	}

	public void navigationFuncHealthAssessment() throws InterruptedException {
		submitAssessmentForm2();
		Thread.sleep(2000);
		WebButton.JsclickButton(health_assessment_locators.get_previousStepBtn(), driver);
		System.out.println("Clicked on: " + health_assessment_locators.get_previousStepBtn().getText());
		System.out.println("Assessment Page: " + health_assessment_locators.get_heightWeightTitle().getText());
		assertTrue(health_assessment_locators.get_heightWeightTitle().isDisplayed(),
				"User did not navigate to previous page");
		ExtentManager.getTest().log(Status.PASS,
				"Assessment Page: " + health_assessment_locators.get_heightWeightTitle().getText());
		Thread.sleep(2000);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		System.out.println("Clicked on: " + health_assessment_locators.get_cnfCntHealthAssessBtn().getText());
		System.out.println("Assessment Page: " + health_assessment_locators.get_exerciseTitle().getText());
		assertTrue(health_assessment_locators.get_exerciseTitle().isDisplayed(),
				"User did not navigate to previous page");
		ExtentManager.getTest().log(Status.PASS,
				"Assessment Page: " + health_assessment_locators.get_exerciseTitle().getText());
	}

	public void verifyPromptForUnsavedChanges() throws InterruptedException {
		submitAssessmentForm2();
		Thread.sleep(2000);
		selectOptionPhysicalActivity("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedtext = "Changes you made may not be saved.";
		System.out.println("Alert text: " + actualText);
		assertTrue(actualText.contains(expectedtext));
	}

	public void verifyCorrectDetailsOnAssessmentSummary() {
		assertEquals(health_assessment_locators.get_heightAssessmentSummaryValue().getText(), "180");
		assertEquals(health_assessment_locators.get_weightAssessmentSummaryValue().getText(), "70");
		ExtentManager.getTest().log(Status.PASS, "Validation: All details are displayed correctly");
		System.out.println("Validation: All details are displayed correctly");
	}

	public void verifyPreviouslySavedDataIsDisplayedCorrectly() {
		assertEquals(health_assessment_locators.get_heightAssessmentSummaryValue().getText(), "180");
		assertEquals(health_assessment_locators.get_weightAssessmentSummaryValue().getText(), "70");
		ExtentManager.getTest().log(Status.PASS, "Validation: All details are displayed correctly");
		System.out.println("Validation: All details are displayed correctly");
	}

	public void editAssessmentDetails() throws InterruptedException {
		WebButton.JsclickButton(health_assessment_locators.get_heightWeightEditBtn(), driver);
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "170");
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "80");
		Thread.sleep(2000);

		for (int i = 0; i < 2; i++) {
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(),
					Duration.ofSeconds(20));
			WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		}

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);

		for (int i = 0; i < 2; i++) {
			WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(),
					Duration.ofSeconds(40));
			WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		}

		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_assessmentSubmitBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_editDetailsHealthAssessment(), driver);
		assertEquals(health_assessment_locators.get_heightAssessmentSummaryValue().getText(), "170");
		assertEquals(health_assessment_locators.get_weightAssessmentSummaryValue().getText(), "80");
		System.out.println("Validation: Details updated successfully");
		ExtentManager.getTest().log(Status.PASS, "Validation: Details updated successfully");
	}

	public void verifyProgressBarIsDisplayed() {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_progressBar(), Duration.ofSeconds(20));
		assertTrue(health_assessment_locators.get_progressBar().isDisplayed(), "Progress bar is not displayed");
		System.out.println("Progress bar is displayed");
		ExtentManager.getTest().log(Status.PASS, "Progress Bar is displayed");
	}

	public List<String> getMandatoryFieldLabels() {
		List<WebElement> requiredSpans = driver.findElements(By.cssSelector("label.form-label span.required"));
		List<String> labelsText = new ArrayList<>();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement span : requiredSpans) {
			WebElement label = span.findElement(By.xpath(".."));

			String labelText = (String) js
					.executeScript("var element = arguments[0];" + "var childNodes = element.childNodes;"
							+ "var text = '';" + "for(var i=0; i<childNodes.length; i++) {"
							+ "  if(childNodes[i].nodeType === 3) { text += childNodes[i].textContent.trim(); }" + "}"
							+ "return text;", label);

			labelsText.add(labelText);
		}
		return labelsText;
	}

	private void logMandatoryFields(String formName, List<String> labels) {
		System.out.println("Mandatory fields found with asterisk (" + formName + "):");
		StringBuilder logBuilder = new StringBuilder();
		int count = 1;
		for (String label : labels) {
			System.out.println(count + ". " + label);
			logBuilder.append(count).append(". ").append(label).append("<br>");
			count++;
		}
		ExtentManager.getTest().log(Status.PASS,
				"Mandatory fields found with asterisk (" + formName + "):<br>" + logBuilder.toString());
		Assert.assertFalse(labels.isEmpty(), "No mandatory fields with asterisk were found in " + formName);
	}

	public void verifyAsteriskForMandatoryFields() {

		// Form2
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");

		List<String> mandatoryLabelsForm2 = getMandatoryFieldLabels();
		logMandatoryFields("Form 2", mandatoryLabelsForm2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form3
		selectOptionPhysicalActivity("Yes");
		List<String> mandatoryLabelsForm3 = getMandatoryFieldLabels();
		logMandatoryFields("Form 3", mandatoryLabelsForm3);

		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form4
		selectOptionMedicalCondition("Yes");
		List<String> mandatoryLabelsForm4 = getMandatoryFieldLabels();
		logMandatoryFields("Form 4", mandatoryLabelsForm4);

		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form5
		selectOptionMedication("Yes");
		List<String> mandatoryLabelsForm5 = getMandatoryFieldLabels();
		logMandatoryFields("Form 5", mandatoryLabelsForm5);

	}

	private void logPlaceholders(String formName, List<String> labels) {
		System.out.println("Fields found with placeholder(" + formName + "):");
		StringBuilder logBuilder = new StringBuilder();
		int count = 1;
		for (String label : labels) {
			System.out.println(count + ". " + label);
			logBuilder.append(count).append(". ").append(label).append("<br>");
			count++;
		}
		ExtentManager.getTest().log(Status.PASS,
				"Fields found with placeholder (" + formName + "):<br>" + logBuilder.toString());
		Assert.assertFalse(labels.isEmpty(), "No fields with placeholder were found in " + formName);
	}

	public void verifyPlaceholderIsPresent() {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");

		List<String> LabelsForm2 = getMandatoryFieldLabels();
		logPlaceholders("Form 2", LabelsForm2);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form3
		selectOptionPhysicalActivity("Yes");
		List<String> LabelsForm3 = getMandatoryFieldLabels();
		logPlaceholders("Form 3", LabelsForm3);

		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form4
		selectOptionMedicalCondition("Yes");
		List<String> LabelsForm4 = getMandatoryFieldLabels();
		logPlaceholders("Form 4", LabelsForm4);

		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		// Form5
		selectOptionMedication("Yes");
		List<String> LabelsForm5 = getMandatoryFieldLabels();
		logPlaceholders("Form 5", LabelsForm5);
	}

	public void verifyAllFieldsAreVisible() {
		verifyPlaceholderIsPresent();
	}

	public void verifySpecialCharForInputFields() throws InterruptedException {
		submitConfirmDetailsForm();
		submitAssessmentForm2();
		submitAssessmentForm3();
		selectOptionMedicalCondition("Yes");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<String> conditions = Arrays.asList("Other");
		selectMultipleMedicalConditionsByName(conditions);
		WebTextBox.sendInputUpdate(health_assessment_locators.get_medicalConditionOthersDescTxt(), "@#$Wwef");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		selectOptionMedication("Yes");
		List<String> conditions2 = Arrays.asList("Other - please specify in box below");
		selectMultipleMedicationByName(conditions2);
		WebTextBox.sendInputUpdate(health_assessment_locators.get_medicationOthersDescTxt(), "^&$TGds");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_editDetailsHealthAssessment(), driver);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 800);");
		String medicalCond = health_assessment_locators.get_otherMedicalConditionAssessmentSummaryValue().getText();
		String medication = health_assessment_locators.get_otherMedicationAssessmentSummaryValue().getText();
		System.out.println("Medical Condition: " + medicalCond);
		System.out.println("Medication: " + medication);
		assertEquals(medicalCond, "@#$Wwef");
		assertEquals(medication, "^&$TGds");
		ExtentManager.getTest().log(Status.PASS, "Medical Condition: " + medicalCond);
		ExtentManager.getTest().log(Status.PASS, "Medication: " + medication);
	}

	public void verifyNavigationUsingTabKey() throws InterruptedException {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.click(health_assessment_locators.get_heightTxt()).perform();
		WebElement activeElement = driver.switchTo().activeElement();
		System.out.println("Active element before TAB: " + activeElement.getAttribute("name"));
		ExtentManager.getTest().log(Status.PASS, "Active element before TAB: " + activeElement.getAttribute("name"));
		Thread.sleep(2000);
		act.keyDown(Keys.TAB).perform();
		WebElement activeElement2 = driver.switchTo().activeElement();
		assertTrue(health_assessment_locators.get_weightTxt().equals(activeElement2),
				"Tab did not move to next element");
		System.out.println("Active element after TAB: " + activeElement2.getAttribute("name"));
		ExtentManager.getTest().log(Status.PASS, "Active element after TAB: " + activeElement2.getAttribute("name"));
	}

	public void verifyNHSLinkNav() throws InterruptedException {
		submitConfirmDetailsForm();
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		String currentWindow = driver.getWindowHandle();
		WebButton.JsclickButton(health_assessment_locators.get_nhsLink(), driver);

		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		for (String window : windows) {
			if (!window.equals(currentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		System.out.println("Switched to NHS tab → Title: " + driver.getTitle());
		System.out.println("Switched to NHS tab → URL: " + driver.getCurrentUrl());

		Assert.assertTrue(driver.getCurrentUrl().contains("nhs") || driver.getTitle().toLowerCase().contains("nhs"),
				"NHS page did not open as expected");
		ExtentManager.getTest().log(Status.PASS, "Switched to NHS tab → Title: " + driver.getTitle());
		ExtentManager.getTest().log(Status.PASS, "Switched to NHS tab → URL: " + driver.getCurrentUrl());

		driver.close();
		driver.switchTo().window(currentWindow);

	}

	public void unitConversion(String height, String weight) throws InterruptedException {
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), height);
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), weight);
		String heightValueMetric = health_assessment_locators.get_heightTxt().getAttribute("value");
		String weightValueMetric = health_assessment_locators.get_weightTxt().getAttribute("value");
		System.out.println("Height(cm): " + heightValueMetric);
		System.out.println("Weight(kg): " + weightValueMetric);
		ExtentManager.getTest().log(Status.PASS, "Height(cm): " + heightValueMetric);
		ExtentManager.getTest().log(Status.PASS, "Weight(kg): " + weightValueMetric);
		Thread.sleep(2000);
		selectUnit("Imperial");
		Thread.sleep(2000);
		String heightValueImperial = health_assessment_locators.get_heightTxt().getAttribute("value");
		String weightValueImperial = health_assessment_locators.get_weightTxt().getAttribute("value");
		System.out.println("Height(in): " + heightValueImperial);
		System.out.println("Weight(lbs): " + weightValueImperial);
		ExtentManager.getTest().log(Status.PASS, "Height(in): " + heightValueImperial);
		ExtentManager.getTest().log(Status.PASS, "Weight(lbs): " + weightValueImperial);
		double expectedHeightInches = Double.parseDouble(height) / 2.54;
		double expectedWeightLbs = Double.parseDouble(weight) * 2.20462;
		double actualHeightInches = Double.parseDouble(heightValueImperial);
		double actualWeightLbs = Double.parseDouble(weightValueImperial);
		double tolerance = 0.1;
		assertTrue(Math.abs(expectedHeightInches - actualHeightInches) < tolerance,
				"Height conversion (cm to in) is incorrect. Expected: " + expectedHeightInches + ", Actual: "
						+ actualHeightInches);

		assertTrue(Math.abs(expectedWeightLbs - actualWeightLbs) < tolerance,
				"Weight conversion (kg to lb) is incorrect. Expected: " + expectedWeightLbs + ", Actual: "
						+ actualWeightLbs);

	}

	public void verifyUnitConversion() throws InterruptedException {
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_startHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_startHealthAssessmentBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		unitConversion("180", "70");
	}

	public void generateBarcodeBloodHormoneTest() throws InterruptedException, IOException {
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
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode: " + Barcode1);
		ExtentManager.getTest().log(Status.INFO, "Generated Barcode: " + Barcode1);
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);
		WebButton.clickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Menopause Profile Test");
		Thread.sleep(2000);
		WebElement selectedOption = WebDropDown.getSelectedOption(driver,activate_test_kit_locators.get_typeOfTestKitDrp());
		System.out.println("Kit Type: "+selectedOption.getText());
		ExtentManager.getTest().log(Status.INFO, "Kit Type: "+selectedOption.getText());
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		Thread.sleep(3000);
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);

	}

	public void generateBarcodeBloodSexHealth() throws IOException, InterruptedException {
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
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesValue(), Duration.ofSeconds(20));
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode(Gold): " + Barcode1);

		// Generate Barcode2
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
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_barcodesValue(), Duration.ofSeconds(20));
		Barcode2 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode(Blue): " + Barcode2);

		// Create Test Kit
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
		WebTextBox.sendInput(activate_test_kit_locators.get_secondaryBarcodeTxtForCreateKit(), Barcode2);
		WebButton.JsclickButton(activate_test_kit_locators.get_createBtn(), driver);
		Thread.sleep(3000);

		// Assign Test Kit
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_assignKitTypeHeaderMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_assignKitTypeHeaderMenu(), driver);
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_typeOfTestKitDrp(), Duration.ofSeconds(20));
		WebDropDown.selectByText(activate_test_kit_locators.get_typeOfTestKitDrp(), "Male Sexual Health Test");
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
		//Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_AssignBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_AssignBtn(), driver);
 
	}

	public void selectOptionSexuallyActive(String activeSexOption, String unprotectedSexOption)
			throws InterruptedException {
		if (activeSexOption.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_sexuallyActiveDrp(), "Yes");
			WebDropDown.selectByText(health_assessment_locators.get_sexualPartnersDrp(), "Women");
			WebDropDown.selectByText(health_assessment_locators.get_recentSexDrp(), "Less than a week ago");
			if (unprotectedSexOption.equalsIgnoreCase("Yes")) {
				WebDropDown.selectByText(health_assessment_locators.get_unprotectedSexDrp(), "Yes");
				Thread.sleep(2000);
				WebScrollView.scrollToElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn());
				Thread.sleep(2000);
				WebCheckBox.checkBoxTest(health_assessment_locators.get_oralSexChkBox());
				WebCheckBox.checkBoxTest(health_assessment_locators.get_vaginalSexChkBox());
			} else {
				WebDropDown.selectByText(health_assessment_locators.get_unprotectedSexDrp(), "No");
			}
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_sexuallyActiveDrp(), "No");
		}
	}

	public void selectOptionSTIsymptoms(String stiSymptoms) {
		if (stiSymptoms.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_stiSymptomsDrp(), "Yes");
			WebTextBox.sendInput(health_assessment_locators.get_stiSymptomsDescriptionTxt(), "STI Symptoms Test");
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_stiSymptomsDrp(), "No");
		}
	}

	public void selectMultipleStiExposure(List<String> exposures) {

		List<WebElement> listStiExposures = health_assessment_locators.get_potentialSTIExposureTypeChkBox();
		List<String> selectedExposures = new ArrayList<>();
		for (String exposureName : exposures) {
			for (WebElement checkbox : listStiExposures) {
				WebElement label = checkbox.findElement(By.xpath("following-sibling::label"));
				if (label.getText().equalsIgnoreCase(exposureName)) {
					if (!checkbox.isSelected()) {
						checkbox.click();
						selectedExposures.add(exposureName);
					}
					break;
				}
			}
		}
		System.out.println("Selected checkboxes(STI Exposure): " + String.join(", ", selectedExposures));
	}

	public void selectOptionSTIexposure(String stiExposure) throws InterruptedException {
		if (stiExposure.equalsIgnoreCase("Yes")) {
			WebDropDown.selectByText(health_assessment_locators.get_potentialSTIExposureDrp(), "Yes");
			Thread.sleep(2000);
			WebScrollView.scrollToElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn());
			Thread.sleep(2000);
			List<String> exposures = Arrays.asList("Gonorrhoea", "Herpes", "Syphilis");
			selectMultipleStiExposure(exposures);
		} else {
			WebDropDown.selectByText(health_assessment_locators.get_potentialSTIExposureDrp(), "No");
		}
	}

	public void verifyAdditionalStepForSexualHealth() throws InterruptedException, IOException {
		generateBarcodeBloodSexHealth();
		login_action.login_Dashboard2();
		//Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_enableLaterBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_activateTestSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_activateTestSideMenuItem(), driver);
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_activateKitSexualHealthBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_activateKitSexualHealthBtn(), driver);
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_trackingNumberTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_trackingNumberTxt(), "AA 1234 5678 9BB");
		//Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_confirmAndContinueBtn());
		//Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		//Thread.sleep(3000);
		WebButton.JsclickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox(), driver);
		//Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		//Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_submitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_submitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		selectSexAtBirth("Male");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		//Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		//Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		//Thread.sleep(2000);
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_stiWarningCloseBtn(),
				Duration.ofSeconds(20));
		WebButton.clickButton(health_assessment_locators.get_stiWarningCloseBtn());
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_msgTestKitActivatedAlert(),
				Duration.ofSeconds(20));
		System.out.println("Status: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		ExtentManager.getTest().log(Status.PASS,
				"Status: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		submitAssessmentForm3();
		submitAssessmentForm4();
		selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(2000);
		String sexHealthTitle = health_assessment_locators.get_sexualHealthTitle().getText();
		System.out.println("Assessment Page: " + sexHealthTitle);
		assertTrue(health_assessment_locators.get_sexualHealthTitle().isDisplayed(),
				"Sexual Health Details Page is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Assessment Page: " + sexHealthTitle);

	}

	public void verifyAdditionalOptsForSexualActiveness() throws InterruptedException {
		selectOptionSexuallyActive("Yes", "Yes");
		// WebDropDown.selectByText(health_assessment_locators.get_sexuallyActiveDrp(),
		// "Yes");
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			boolean allDisplayed = health_assessment_locators.get_sexualPartnersDrp().isDisplayed()
					&& health_assessment_locators.get_recentSexDrp().isDisplayed()
					&& health_assessment_locators.get_unprotectedSexDrp().isDisplayed();

			if (allDisplayed) {
				System.out.println("Additional Field: "
						+ health_assessment_locators.get_sexualPartnersDrp().getAttribute("label"));
				System.out.println(
						"Additional Field: " + health_assessment_locators.get_recentSexDrp().getAttribute("label"));
				System.out.println("Additional Field: "
						+ health_assessment_locators.get_unprotectedSexDrp().getAttribute("label"));

				String fieldLabels = "Additional Fields:<br>" + 
						"1. "+ health_assessment_locators.get_sexualPartnersDrp().getAttribute("label") + "<br>" + 
						"2. "+ health_assessment_locators.get_recentSexDrp().getAttribute("label") + "<br>" + 
						"3. "+ health_assessment_locators.get_unprotectedSexDrp().getAttribute("label");

				ExtentManager.getTest().log(Status.PASS, fieldLabels);

				assertTrue(allDisplayed);
			} else {
				fail("One or more fields are not displayed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyAdditionalOptsForUnprotectedSex() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean allDisplayed = health_assessment_locators.get_whichTypeOfUnprotectedSexFieldTitle().isDisplayed()
				&& health_assessment_locators.get_oralSexChkBox().isDisplayed()
				&& health_assessment_locators.get_vaginalSexChkBox().isDisplayed()
				&& health_assessment_locators.get_analSexChkBox().isDisplayed();
		if (allDisplayed) {
			System.out.println("Additional Field: "
					+ health_assessment_locators.get_whichTypeOfUnprotectedSexFieldTitle().getText());
			System.out.println(
					"Additional Checkbox: " + health_assessment_locators.get_oralSexChkBox().getAttribute("value"));
			System.out.println(
					"Additional Checkbox: " + health_assessment_locators.get_vaginalSexChkBox().getAttribute("value"));
			System.out.println(
					"Additional Checkbox: " + health_assessment_locators.get_analSexChkBox().getAttribute("value"));

			String fieldLabels = "Additional Fields:<br>"
					+ health_assessment_locators.get_whichTypeOfUnprotectedSexFieldTitle().getText() + "<br>" + 
					"1. "+ health_assessment_locators.get_oralSexChkBox().getAttribute("value") + "<br>" + 
					"2. "+ health_assessment_locators.get_vaginalSexChkBox().getAttribute("value") + "<br>" + 
					"3. "+ health_assessment_locators.get_analSexChkBox().getAttribute("value");

			ExtentManager.getTest().log(Status.PASS, fieldLabels);

			assertTrue(allDisplayed);
		} else {
			fail("One or more fields are not displayed");
		}
	}
	
	public void verifyAdditionalOptsForSymptoms() throws InterruptedException {
		WebDropDown.selectByText(health_assessment_locators.get_stiDiagnosedDrp(), "Yes, currently diagnosed");
		Thread.sleep(2000);
		selectOptionSTIsymptoms("Yes");
		WebElement symptomsDescriptionTxt = health_assessment_locators.get_stiSymptomsDescriptionTxt();
		WebElement label = symptomsDescriptionTxt.findElement(By.xpath("preceding-sibling::label"));
		System.out.println("Additional Field: "+label.getText());
		assertTrue(symptomsDescriptionTxt.isDisplayed(), "Additional field is not displayed for symptoms");
		ExtentManager.getTest().log(Status.PASS, "Additional Field: "+label.getText() );
	}
	
	public void verifyAdditionalOptsForSTI() throws InterruptedException {
		selectOptionSTIexposure("Yes");
		List<WebElement> checkboxes = health_assessment_locators.get_potentialSTIExposureTypeChkBox();
		StringBuilder logReport = new StringBuilder();
		int count = 1;
		String label = health_assessment_locators.get_pleaseSpecifyTitle().getText();
		System.out.println("Additional Field:\n"+label);
		for(WebElement checkbox : checkboxes) {
			assertTrue(checkbox.isDisplayed(), "Checkbox is not displayed: "+checkbox.getAttribute("value"));
			System.out.println("Checkbox label: "+checkbox.getAttribute("value"));
			logReport.append(count).append(". ").append(checkbox.getAttribute("value")).append("<br>");
			count++;
		}
		ExtentManager.getTest().log(Status.PASS, "STI Exposure checkboxes found:<br>"+label+"<br>"+ logReport.toString());
	}

	public void successfullHealthAssessmentForSexualHealthTest() throws IOException, InterruptedException {
		Thread.sleep(2000);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		String successMsg = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + successMsg);
		assertTrue(health_assessment_locators.get_successAssessmentSubmissionAlert().isDisplayed(),
				"Assessment not submitted");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + successMsg);
	}
	
	public void successfullHAForSHTestYesOption() {
		String successMsg = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + successMsg);
		assertTrue(health_assessment_locators.get_successAssessmentSubmissionAlert().isDisplayed(),
				"Assessment not submitted");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + successMsg);
	}

	public void verifyMenstrualCyclePageIsDisplayed() throws InterruptedException, IOException {
		generateBarcodeBloodHormoneTest();
		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
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
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		selectIfStillIdentifiesWithGender("Yes");

		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(30));
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(30));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);

		// Form2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		submitAssessmentForm3();
		submitAssessmentForm4();
		selectOptionMedication("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		System.out.println(
				"Assessment Page: " + health_assessment_locators.get_menstrualCycleTitle().getText() + " is displayed");
		assertTrue(health_assessment_locators.get_menstrualCycleTitle().isDisplayed(),
				"Additional step for menstrual cycle is not displayed");
		ExtentManager.getTest().log(Status.PASS,
				"Assessment Page: " + health_assessment_locators.get_menstrualCycleTitle().getText() + " is displayed");
	}

	public void successfulHealthAssessmentBloodHormoneTest() throws InterruptedException, IOException {
		WebDropDown.selectByIndex(health_assessment_locators.get_cycleLengthDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_dayOfCycleDrp(), "1", driver);
		WebDropDown.selectByIndex(health_assessment_locators.get_contraceptionDrp(), "1", driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
	}

	public void successfulHealthAssessmentBloodHormoneTestOptionYes() {
		String actualAlert = health_assessment_locators.get_successAssessmentSubmissionAlert().getText();
		System.out.println("Alert: " + actualAlert);
		assertEquals(actualAlert, "All steps completed successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: " + actualAlert);
	}
	
	public void verifyFillAssessmentBtnChangeToEdit() throws InterruptedException, IOException {
		generateBarcodeBloodHormoneTest();
		login_action.login_Dashboard2();
		Thread.sleep(3000);
		WebButton.JsclickButton(health_assessment_locators.get_enableLaterBtn(), driver);
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
		Thread.sleep(5000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_consentInfoFirstCheckBox(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_consentInfoFirstCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_consentPrivacyAndTermsSecondCheckBox());
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_submitBtn());
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_dobTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_dobTxt(), "03/01/1999");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_mobNoTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_mobNoTxt(), "3333333333");
		selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		selectIfStillIdentifiesWithGender("Yes");
		Thread.sleep(3000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_ethnicityRadioBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_ethnicityRadioBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(4000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(),  Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		Thread.sleep(2000);
		WebButton.clickButton(activate_test_kit_locators.get_confirmAndContinueBtn());
		Thread.sleep(4000);
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_leftSideBarMyResultsBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		Thread.sleep(15000);
		WebWait.visibilityOfElement(driver, driver.findElement(
			    By.xpath("//code[text()='" + Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(@href,'assessment')]")), Duration.ofSeconds(30));
		WebElement myResultsFillAssessmentBtn = driver.findElement(
			    By.xpath("//code[text()='" + Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(@href,'assessment')]"));
		WebWait.elementToBeClickable(driver, myResultsFillAssessmentBtn, Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, myResultsFillAssessmentBtn);
		Thread.sleep(3000);
		System.out.println("Before filling Heath Assessment: "+myResultsFillAssessmentBtn.getText());
		assertEquals(myResultsFillAssessmentBtn.getText(), "Fill assessment");
		ExtentManager.getTest().log(Status.PASS, "Before filling Heath Assessment: "+myResultsFillAssessmentBtn.getText());
		WebButton.JsclickButton(myResultsFillAssessmentBtn, driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		submitAssessmentForm3();
		submitAssessmentForm4();
		selectOptionMedication("Yes");
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
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		Thread.sleep(3000);
		WebElement myResultsEditAssessmentBtn = driver.findElement(
			    By.xpath("//code[text()='" + Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(@href,'assessment')]"));
		WebWait.visibilityOfElement(driver, myResultsEditAssessmentBtn, Duration.ofSeconds(20));
		
		System.out.println("After filling Heath Assessment: "+myResultsEditAssessmentBtn.getText());
		Thread.sleep(4000);
		WebScrollView.scrollToElement(driver, myResultsEditAssessmentBtn);
		Thread.sleep(4000);
		assertEquals(myResultsEditAssessmentBtn.getText(), "Edit assessment");
		ExtentManager.getTest().log(Status.PASS, "After filling Heath Assessment: "+myResultsEditAssessmentBtn.getText());
	}
	
	public void editAssessmentBeforeSampleReachLab() throws InterruptedException {
		Thread.sleep(3000);
		WebElement myResultsEditAssessmentBtn = driver.findElement(
			    By.xpath("//code[text()='" + Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(@href,'assessment')]"));
		Thread.sleep(3000);
		WebButton.JsclickButton(myResultsEditAssessmentBtn, driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_heightWeightEditBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_heightWeightEditBtn(), driver);
		Thread.sleep(4000);
		WebTextBox.sendInput(health_assessment_locators.get_heightTxt(), "150");
		WebTextBox.sendInput(health_assessment_locators.get_weightTxt(), "50");
		WebDropDown.selectByText(health_assessment_locators.get_smokeCigarettesDrp(), "No");
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(),
					Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_assessmentSubmitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		Thread.sleep(3000);
		assertEquals(health_assessment_locators.get_heightAssessmentSummaryValue().getText(), "150");
		assertEquals(health_assessment_locators.get_weightAssessmentSummaryValue().getText(), "50");
		System.out.println("Validation: Details updated successfully");
		ExtentManager.getTest().log(Status.PASS, "Validation: Details updated successfully");
	}
	
	public void fillAssessmentAfterSampleReachLab() throws IOException, InterruptedException {
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
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode(Gold): " + Barcode1);
		ExtentManager.getTest().log(Status.PASS, "Generated Barcode(Gold): " + Barcode1);
		
		// Create Test Kit
		WebButton.clickButton(activate_test_kit_locators.get_testKitSideMenuItem());
		WebButton.clickButton(activate_test_kit_locators.get_createKitBtn());
		Thread.sleep(2000);
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForCreateKit(), Barcode1);
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
		WebTextBox.sendInput(activate_test_kit_locators.get_primaryBarcodeTxtForAssignKit(), Barcode1);
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
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
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
		selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		selectIfStillIdentifiesWithGender("Yes");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
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
		WebTextBox.sendInput(health_assessment_locators.get_inputBarcodeTxt(), Barcode1);
		WebButton.JsclickButton(health_assessment_locators.get_markKitNextBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_markAsReceivedBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_markAsReceivedBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_testMarkedAsReceivedAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_testMarkedAsReceivedAlert().getText());

		login_action.navToDashboard();
		Thread.sleep(3000);
		WebButton.JsclickButton(health_assessment_locators.get_leftSideBarMyResultsBtn(), driver);
		Thread.sleep(15000);
		WebElement fillAssessmentMyResult = driver.findElement(By.xpath("//code[text()='" + Barcode1 + "']/ancestor::div[@data-testid='link-card']//a[contains(@href,'assessment')]"));
		WebWait.visibilityOfElement(driver,fillAssessmentMyResult , Duration.ofSeconds(20));
		Thread.sleep(4000);
		WebScrollView.scrollToElement(driver, fillAssessmentMyResult);
		Thread.sleep(4000);
		WebButton.JsclickButton(fillAssessmentMyResult, driver);
		
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_continueHealthAssessmentBtn(),
				Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_continueHealthAssessmentBtn(), driver);

		// Form2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		selectUnit("Metric");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "180");
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "70");
		selectOptionSmokeCigarettes("Yes");
		selectOptionDrinkalcohol("Yes");
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);

		submitAssessmentForm3();
		submitAssessmentForm4();
		selectOptionMedication("Yes");
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
	}
	
	public void editAssessmentAfterSampleReachLab() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Height(Before edit): "+health_assessment_locators.get_heightAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.INFO, "Height(Before edit): "+health_assessment_locators.get_heightAssessmentSummaryValue().getText());
		System.out.println("Weight(Before edit): "+health_assessment_locators.get_weightAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.INFO, "Weight(Before edit): "+health_assessment_locators.get_weightAssessmentSummaryValue().getText());
		System.out.println("Alcohol(Before edit): "+health_assessment_locators.get_alcoholAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.INFO, "Alcohol(Before edit): "+health_assessment_locators.get_alcoholAssessmentSummaryValue().getText());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_heightWeightEditBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_heightWeightEditBtn(), driver);
		
		//WebWait.visibilityOfElement(driver, health_assessment_locators.get_drinkAlcoholDrp(), Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_heightTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_heightTxt(), "165");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_weightTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(health_assessment_locators.get_weightTxt(), "65");
		selectOptionDrinkalcohol("No");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_cnfCntHealthAssessBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		WebButton.JsclickButton(health_assessment_locators.get_cnfCntHealthAssessBtn(), driver);
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_assessmentSubmitBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_assessmentSubmitBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_successAssessmentSubmissionAlert(), Duration.ofSeconds(20));
		System.out.println("Alert: "+health_assessment_locators.get_successAssessmentSubmissionAlert().getText());
		ExtentManager.getTest().log(Status.PASS, "Alert: "+health_assessment_locators.get_successAssessmentSubmissionAlert().getText());
		Thread.sleep(3000);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_heightAssessmentSummaryValue(), Duration.ofSeconds(20));
		System.out.println("Height(After edit): "+health_assessment_locators.get_heightAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.PASS, "Height(After edit): "+health_assessment_locators.get_heightAssessmentSummaryValue().getText());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_weightAssessmentSummaryValue(), Duration.ofSeconds(20));
		System.out.println("Weight(After edit): "+health_assessment_locators.get_weightAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.PASS, "Weight(After edit): "+health_assessment_locators.get_weightAssessmentSummaryValue().getText());
		System.out.println("Alcohol(After edit): "+health_assessment_locators.get_alcoholAssessmentSummaryValue().getText());
		ExtentManager.getTest().log(Status.PASS, "Alcohol(After edit): "+health_assessment_locators.get_alcoholAssessmentSummaryValue().getText());
		assertEquals(health_assessment_locators.get_heightAssessmentSummaryValue().getText(), "165");
		assertEquals(health_assessment_locators.get_weightAssessmentSummaryValue().getText(), "65");
		assertEquals(health_assessment_locators.get_alcoholAssessmentSummaryValue().getText(), "No");
		System.out.println("Validation: All details updated successfully");
		ExtentManager.getTest().log(Status.PASS, "Validation: All details updated successfully");
	}
	
	public void verifySuccessfulHealthAssessmentForDNATest() throws IOException, InterruptedException {
		activate_test_kit_actions.dashboardUrlOfTims();
		Thread.sleep(2000);

		// Generate Barcode1
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_barcodeBatchesSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_createDNABatchBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_createDNABatchBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_createDNABatchBtn(), Duration.ofSeconds(20));
		WebDropDown.selectByText(health_assessment_locators.get_typeDNABatchDrp(), "wellness");
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_countDNABatchTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(health_assessment_locators.get_countDNABatchTxt(), "2");
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_saveDNABatchBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_saveDNABatchBtn(), driver);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_barcodesHeaderMenuItem(), Duration.ofSeconds(20));
		WebButton.clickButton(activate_test_kit_locators.get_barcodesHeaderMenuItem());
		Thread.sleep(2000);
		Barcode1 = activate_test_kit_locators.get_barcodesValue().getText();
		System.out.println("Generated Barcode(Gold): " + Barcode1);
		ExtentManager.getTest().log(Status.PASS, "Generated Barcode(Gold): " + Barcode1);
		
		// Create Test Kit
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_testKitSideMenuItem(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_testKitSideMenuItem(), driver);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_uploadKitCSVHeaderMenuBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_uploadKitCSVHeaderMenuBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_uploadFileInput(), Duration.ofSeconds(20));
		CSVUploaderWithTextReplacement.updateAndUploadCSV(driver, WebCommonPath.DNAKitCreation_csv , health_assessment_locators.get_uploadFileInput(), "CONCS25164", Barcode1);
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
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_activateKitDNABtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_activateKitDNABtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_goldBarcodeTxt(), Duration.ofSeconds(20));		
		WebTextBox.sendInput(activate_test_kit_locators.get_goldBarcodeTxt(), Barcode1);
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
		selectSexAtBirth("Female");
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, activate_test_kit_locators.get_continueBtn());
		Thread.sleep(4000);
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_continueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_continueBtn(), driver);
		Thread.sleep(3000);
		WebWait.visibilityListOfElements(driver, health_assessment_locators.get_DNATestConsentChkboxes(), Duration.ofSeconds(20));
		WebCheckBox.selectAllCheckboxes(driver, health_assessment_locators.get_DNATestConsentChkboxes());
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_confirmContinueDNAConsentBtn(), Duration.ofSeconds(20));
		WebScrollView.scrollToElement(driver, health_assessment_locators.get_confirmContinueDNAConsentBtn());
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, health_assessment_locators.get_confirmContinueDNAConsentBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_confirmContinueDNAConsentBtn(), driver);
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_dateTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(activate_test_kit_locators.get_dateTxt(), getSystemCurrentDate());
		WebWait.visibilityOfElement(driver, activate_test_kit_locators.get_timeTxt(), Duration.ofSeconds(20));
		WebTextBox.sendInput(activate_test_kit_locators.get_timeTxt(), "0909AM");
		WebWait.elementToBeClickable(driver, activate_test_kit_locators.get_confirmAndContinueBtn(), Duration.ofSeconds(20));
		WebButton.JsclickButton(activate_test_kit_locators.get_confirmAndContinueBtn(), driver);
		WebWait.visibilityOfElement(driver, health_assessment_locators.get_msgTestKitActivatedAlert(),
				Duration.ofSeconds(20));
		System.out.println("Status: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		ExtentManager.getTest().log(Status.PASS,
				"Status: " + health_assessment_locators.get_msgTestKitActivatedAlert().getText());
		Map<String, String> preferences = new HashMap<>();
        preferences.put("dairy", "eat");
        preferences.put("nuts", "eat");
        preferences.put("gluten", "dont_eat");
        preferences.put("shellfish", "eat");
        preferences.put("oily_fish", "dont_eat");
        preferences.put("eggs", "eat");
        preferences.put("poultry", "eat");
        preferences.put("red_meat", "dont_eat");
        preferences.put("pork", "dont_eat");
        preferences.put("alcohol", "dont_eat");
        
        selectFoodPreferences(preferences);
        WebWait.visibilityOfElement(driver, health_assessment_locators.get_submitBtn(), Duration.ofSeconds(20));
        WebButton.JsclickButton(health_assessment_locators.get_submitBtn(), driver);
        
        WebWait.visibilityOfElement(driver, health_assessment_locators.get_myResultBootsMenu(), Duration.ofSeconds(20));
		WebButton.JsclickButton(health_assessment_locators.get_myResultBootsMenu(), driver);
		Thread.sleep(20000);
		WebWait.elementToBeClickable(driver, getViewTestBtn(Barcode1), Duration.ofSeconds(30));
		WebScrollView.scrollToElement(driver,getViewTestBtn(Barcode1));
		Thread.sleep(2000);
		WebWait.elementToBeClickable(driver, getViewTestBtn(Health_Assessment_Actions.Barcode1), Duration.ofSeconds(30));
		WebButton.JsclickButton(getViewTestBtn(Health_Assessment_Actions.Barcode1), driver);
        
	
        WebWait.visibilityOfElement(driver, health_assessment_locators.get_DNATestPurchasedGreenTick(), Duration.ofSeconds(30));
        Thread.sleep(4000);
        assertTrue(health_assessment_locators.get_DNATestPurchasedGreenTick().isDisplayed(), "Green tick not displayed");
        System.out.println("Element displayed: "+health_assessment_locators.get_DNATestPurchasedGreenTick().getAttribute("class"));
        ExtentManager.getTest().log(Status.PASS, "Element displayed: "+health_assessment_locators.get_DNATestPurchasedGreenTick().getAttribute("class"));
	}
	
	public void selectFoodPreferences(Map<String, String> preferences) throws InterruptedException {
        for (Map.Entry<String, String> entry : preferences.entrySet()) {
            String category = entry.getKey();
            String choice = entry.getValue(); 
            String xpath = String.format("//input[@name='%s' and @value='%s']/following-sibling::label", category, choice);
            Thread.sleep(500);
            WebElement radioInput = driver.findElement(By.xpath(xpath));
            WebWait.visibilityOfElement(driver, radioInput, Duration.ofSeconds(20));
            if (!radioInput.isSelected()) {
                radioInput.click();
            }
        }
    }
	
	public WebElement getViewTestBtn(String Barcode1) {
		String xpath = "//code[text()='" + Barcode1
				+ "']/ancestor::div[@data-testid='link-card']//a[normalize-space()='View test']";
		return driver.findElement(By.xpath(xpath));
	}

	public String getSystemCurrentDate() {
		Date currentDate = new Date();
		// System.out.println("System raw date: " + currentDate);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
		formatter.setTimeZone(TimeZone.getDefault()); // Or specify a fixed one
		String formattedDate = formatter.format(currentDate);
		// System.out.println("Formatted system date: " + formattedDate);
		return formattedDate;
	}

}
