package Test.Dashboard.Locators_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Activate_Test_Kit_Locators {
	public WebDriver driver;

	public Activate_Test_Kit_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//  Below are the Locators from Tims which we required to generate the barcodes for Dashboard Activate Kit
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTimsLoginTxt;

	public WebElement get_emailTimsLoginTxt() {
		return emailTimsLoginTxt;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTimsLoginTxt;

	public WebElement get_passwordTimsLoginTxt() {
		return passwordTimsLoginTxt;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginTimsBtn;

	public WebElement get_loginTimsBtn() {
		return loginTimsBtn;
	}

	@FindBy(xpath = "//button[contains(text(),'Enable Later')]")
	private WebElement timsEnableLaterBtn;

	public WebElement get_timsEnableLaterBtn() {
		return timsEnableLaterBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Enable later')]")
	private WebElement dbEnableLaterBtn;

	public WebElement get_dbEnableLaterBtn() {
		return dbEnableLaterBtn;
	}

	@FindBy(xpath = "//a[normalize-space()='Barcode batches']")
	private WebElement barcodeBatchesSideMenuItem;

	public WebElement get_barcodeBatchesSideMenuItem() {
		return barcodeBatchesSideMenuItem;
	}

	@FindBy(xpath = "//button[normalize-space()='Create blood batch']")
	private WebElement createBloodBatchBtn;

	public WebElement get_createBloodBatchBtn() {
		return createBloodBatchBtn;
	}

	@FindBy(xpath = "//form[@id='add_blood_form']//select[@id='customer']") // boots
	private WebElement customerDrp;

	public WebElement get_customerDrp() {
		return customerDrp;
	}

	@FindBy(xpath = "//form[@id='add_blood_form']//select[@id='btype']") // blood
	private WebElement typeDrp;

	public WebElement get_typeDrp() {
		return typeDrp;
	}

	@FindBy(xpath = "//form[@id='add_blood_form']//select[@id='sub_type']") // gold
	private WebElement subTypeDrp;

	public WebElement get_subTypeDrp() {
		return subTypeDrp;
	}

	@FindBy(xpath = "//form[@id='add_blood_form']//input[@id='barcode_count']") // 2
	private WebElement barcodeCountTxt;

	public WebElement get_barcodeCountTxt() {
		return barcodeCountTxt;
	}

	@FindBy(xpath = "//form[@id='add_blood_form']//button[@id='save_button']")
	private WebElement saveBtn;

	public WebElement get_saveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//a[@id='nav-barcode-tab']")
	private WebElement barcodesHeaderMenuItem;

	public WebElement get_barcodesHeaderMenuItem() {
		return barcodesHeaderMenuItem;
	}

	//@FindBy(xpath = "(//table[@id='barcode-table']//tbody//tr[1]/td[1]/a)[1]")
	@FindBy(xpath = "//table[@id='barcode-table']//tbody//tr[1]/td[1]/a")
	private WebElement barcodesValue;

	public WebElement get_barcodesValue() {
		return barcodesValue;
	}
	// MGL-FZC-9074

	@FindBy(xpath = "//a[normalize-space()='Test kits']")
	private WebElement testKitSideMenuItem;

	public WebElement get_testKitSideMenuItem() {
		return testKitSideMenuItem;
	}

	@FindBy(xpath = "//button[normalize-space()='Create kit']")
	private WebElement createKitBtn;

	public WebElement get_createKitBtn() {
		return createKitBtn;
	}

	@FindBy(xpath = "//input[@id='primary_barcode']")
	private WebElement primaryBarcodeTxtForCreateKit;

	public WebElement get_primaryBarcodeTxtForCreateKit() {
		return primaryBarcodeTxtForCreateKit;
	}

	@FindBy(xpath = "//input[@id='secondary_barcode']")
	private WebElement secondaryBarcodeTxtForCreateKit;

	public WebElement get_secondaryBarcodeTxtForCreateKit() {
		return secondaryBarcodeTxtForCreateKit;
	}

	@FindBy(xpath = "//input[@id='primary-barcode-id']")
	private WebElement primaryBarcodeTxtForAssignKit;

	public WebElement get_primaryBarcodeTxtForAssignKit() {
		return primaryBarcodeTxtForAssignKit;
	}

	@FindBy(xpath = "(//button[contains(text(),'Create')])[2]")
	private WebElement createBtn;

	public WebElement get_createBtn() {
		return createBtn;
	}

	@FindBy(xpath = "(//button[contains(text(),'Assign')])[2]")
	private WebElement AssignBtn;

	public WebElement get_AssignBtn() {
		return AssignBtn;
	}

	@FindBy(xpath = "//button[normalize-space()='Assign kit type']")
	private WebElement assignKitTypeHeaderMenu;

	public WebElement get_assignKitTypeHeaderMenu() {
		return assignKitTypeHeaderMenu;
	}

	@FindBy(xpath = "//select[@name='assign_testkit_type']")
	private WebElement typeOfTestKitDrp;

	public WebElement get_typeOfTestKitDrp() {
		return typeOfTestKitDrp;
	}
	// End of Tims locators
	// *******************************
	// Strat of Activate Kit Locators

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailDashboardLoginTxt;

	public WebElement get_emailDashboardLoginTxt() {
		return emailDashboardLoginTxt;
	}

	@FindBy(xpath = "//a")
	private List<WebElement> allWebelements;

	public List<WebElement> get_allWebelements() {
		return allWebelements;
	}

	@FindBy(xpath = "//img[@class='m-2 check-list-img']")
	private List<WebElement> all12Webelements;

	public List<WebElement> get_all12Webelements() {
		return all12Webelements;
	}

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordDashboardLoginTxt;

	public WebElement get_passwordDashboardLoginTxt() {
		return passwordDashboardLoginTxt;
	}

	@FindBy(xpath = "//p[normalize-space()='10 character code printed on the sticker.']")
	private WebElement placeholderBarcodeTxt;

	public WebElement get_placeholderBarcodeTxt() {
		return placeholderBarcodeTxt;
	}

	@FindBy(xpath = "//p[contains(text(),'This number can be found on the royal mail return ')]")
	private WebElement placeholderTrackingNumberTxt;

	public WebElement get_placeholderTrackingNumberTxt() {
		return placeholderTrackingNumberTxt;
	}

	@FindBy(xpath = "//input[contains(@class, 'form-control is-invalid form-control')]")
	private WebElement emptyFeildRequiredIcon;

	public WebElement get_emptyFeildRequiredIcon() {
		return emptyFeildRequiredIcon;
	}

	@FindBy(xpath = "//span[@aria-describedby='tooltip-sit-comfortably']")
	private WebElement tooltipOnHowToPage;

	public WebElement get_tooltipOnHowToPage() {
		return tooltipOnHowToPage;
	}

	@FindBy(xpath = "(//span[contains(text(),'See Why')])[1]")
	private WebElement tooltipTxt;

	public WebElement get_tooltipTxt() {
		return tooltipTxt;
	}

	@FindBy(xpath = "//span[contains(text(),'Access denied: please complete the previous steps')]")
	private WebElement errorMsgForUpdateDateAfterActivationProcess;

	public WebElement get_errorMsgForUpdateDateAfterActivationProcess() {
		return errorMsgForUpdateDateAfterActivationProcess;
	}

	@FindBy(xpath = "//div[normalize-space()='Activate test']")
	private WebElement activateTestSideMenuItem;

	public WebElement get_activateTestSideMenuItem() {
		return activateTestSideMenuItem;
	}

	@FindBy(xpath = "//a[@href='/tests/bloods/activate'][normalize-space()='Activate kit']")
	private WebElement activateKitOfBloofTestBtn;

	public WebElement get_activateKitOfBloofTestBtn() {
		return activateKitOfBloofTestBtn;
	}

	@FindBy(xpath = "//input[@id='barcode']")
	private WebElement goldBarcodeTxt;

	public WebElement get_goldBarcodeTxt() {
		return goldBarcodeTxt;
	}

	@FindBy(xpath = "//input[@id='trackingNumber']") // AA 1234 5678 9BB
	private WebElement trackingNumberTxt;

	public WebElement get_trackingNumberTxt() {
		return trackingNumberTxt;
	}

	@FindBy(xpath = "//button[contains(text(),'Confirm & continue')]")
	private WebElement confirmAndContinueBtn;

	public WebElement get_confirmAndContinueBtn() {
		return confirmAndContinueBtn;
	}

	@FindBy(xpath = "//input[@id='consentGiven']")
	private WebElement consentInfoFirstCheckBox;

	public WebElement get_consentInfoFirstCheckBox() {
		return consentInfoFirstCheckBox;
	}

	@FindBy(xpath = "//input[@id='termsAccepted']")
	private WebElement consentPrivacyAndTermsSecondCheckBox;

	public WebElement get_consentPrivacyAndTermsSecondCheckBox() {
		return consentPrivacyAndTermsSecondCheckBox;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement get_submitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//h1[contains(text(),'Health assessment')]")
	private WebElement healtAssessmentText;

	public WebElement get_healtAssessmentText() {
		return healtAssessmentText;
	}

	@FindBy(xpath = "//input[@name='phone_number_primary']")
	private WebElement phoneNumberTxt;

	public WebElement get_phoneNumberTxt() {
		return phoneNumberTxt;
	}

	@FindBy(xpath = "//input[@id='dob']")
	private WebElement dobTxt;

	public WebElement get_dobTxt() {
		return dobTxt;
	}

	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement genderBtn;

	public WebElement get_genderBtn() {
		return genderBtn;
	}

	@FindBy(xpath = "//label[contains(text(),'Yes')]")
	private WebElement genderConfirmBtn;

	public WebElement get_genderConfirmBtn() {
		return genderConfirmBtn;
	}

	@FindBy(xpath = "//input[@id='ethnicity-asian']")
	private WebElement ethnicityRadioBtn;

	public WebElement get_ethnicityRadioBtn() {
		return ethnicityRadioBtn;
	}

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	public WebElement get_continueBtn() {
		return continueBtn;
	}

	@FindBy(xpath = "//input[@id='sample_collection_date']")
	private WebElement dateTxt;

	public WebElement get_dateTxt() {
		return dateTxt;
	}

	@FindBy(xpath = "//input[@id='sample_collection_time']")
	private WebElement timeTxt;

	public WebElement get_timeTxt() {
		return timeTxt;
	}

	@FindBy(xpath = "//div[@class='toast-body']")
	private WebElement toastMsg;

	public WebElement get_toastMsg() {
		return toastMsg;
	}

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement errorMsg;

	public WebElement get_errorMsg() {
		return errorMsg;
	}

	@FindBy(xpath = "//button[@class='logout-button btn mt-2 btn btn-primary']")
	private WebElement logoutBtn;

	public WebElement get_logoutBtn() {
		return logoutBtn;
	}

	@FindBy(xpath = "//button[@class='capsule-right-button btn btn-primary']")
	private WebElement confirmLogoutBtn;

	public WebElement get_confirmLogoutBtn() {
		return confirmLogoutBtn;
	}

	@FindBy(xpath = "//h3[normalize-space()='Please confirm consent to the above conditions.']")
	private WebElement otherElementInConsentPage;

	public WebElement get_otherElementInConsentPage() {
		return otherElementInConsentPage;
	}

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstNameOnDetailsPage;

	public WebElement get_firstNameOnDetailsPage() {
		return firstNameOnDetailsPage;
	}

	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastNameOnDetailsPage;

	public WebElement get_lastNameOnDetailsPage() {
		return lastNameOnDetailsPage;
	}

	@FindBy(xpath = "//p[contains(text(), 'How to')]")
	private WebElement howToPageText;

	public WebElement get_howToPageText() {
		return howToPageText;
	}

	@FindBy(xpath = "//img[@class='m-2 check-list-img']")
	private WebElement contentOfHowToPage;

	public WebElement get_contentOfHowToPage() {
		return contentOfHowToPage;
	}
	
	@FindBy(xpath = "//div[@class='invalid-feedback' and text()='Tracking number is required']")
	private WebElement errorMsgTrackingNumRequired;

	public WebElement get_errorMsgTrackingNumRequired() {
		return errorMsgTrackingNumRequired;
	}
	
	@FindBy(xpath = "//th[normalize-space()='Tracking number:']/following-sibling::td")
	private WebElement trackingNumTimsTxt;

	public WebElement get_trackingNumTimsTxt() {
		return trackingNumTimsTxt;
	}
	
	@FindBy(xpath = "//th[normalize-space()='Tracking number:']")
	private WebElement trackingNumTimsLabel;

	public WebElement get_trackingNumTimsLabel() {
		return trackingNumTimsLabel;
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Tracking number')]/following-sibling::h5/code")
	private WebElement trackingNumTestKitPageDb;

	public WebElement get_trackingNumTestKitPageDb() {
		return trackingNumTestKitPageDb;
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Tracking number')]")
	private WebElement trackingNumFieldLabelTestKitPageDb;

	public WebElement get_trackingNumFieldLabelTestKitPageDb() {
		return trackingNumFieldLabelTestKitPageDb;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Upload kit CSV')]")
	private WebElement uploadCsvKitButton;

	public WebElement get_uploadCsvKitButton() {
	  return uploadCsvKitButton;
	}
	
	@FindBy(xpath = "(//button[@type='submit'])[5]")
	private WebElement uploadCsvKitInsideButton;

	public WebElement get_uploadCsvKitInsideButton() {
	  return uploadCsvKitInsideButton;
	}
	
	@FindBy(xpath = "(//input[@name='kit_csv'])[3]")
	private WebElement uploadCsvChooseFileOptionTxt;

	public WebElement get_uploadCsvChooseFileOptionTxt() {
	  return uploadCsvChooseFileOptionTxt;
	}
	
	@FindBy(xpath = "//table[@id='barcode-table']//td/a")
	private List<WebElement> allGeneratedBarcodes;

	public List<WebElement> get_allGeneratedBarcodes() {
	  return allGeneratedBarcodes;
	}
	
	@FindBy(xpath = "//div[@id='statusMessageContainer']/span[contains(text(),'CSV uploaded')]")
	private WebElement csvuploadedSuccessMultiBarcodeToaster;

	public WebElement get_csvuploadedSuccessMultiBarcodeToaster() {
	  return csvuploadedSuccessMultiBarcodeToaster;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Test kit activated successfully!']")
	private WebElement kitActivatedToaster;

	public WebElement get_kitActivatedToaster() {
	  return kitActivatedToaster;
	}
	
	@FindBy(xpath = "//a[@href='/tests/sh/activate' and text()='Activate kit']")
	private WebElement shTestActivateKitBtn;

	public WebElement get_shTestActivateKitBtn() {
	  return shTestActivateKitBtn;
	}
	
	@FindBy(xpath = "//button[@type='button' and text()='Close']")
	private WebElement shTestWarningCloseBtn;

	public WebElement get_shTestWarningCloseBtn() {
	  return shTestWarningCloseBtn;
	}
	
	
}
