package Test.Dashboard.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Health_Assessment_Locators {

	public WebDriver driver;

	public Health_Assessment_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Enable later']")
	WebElement enableLaterBtn;
 
	public WebElement get_enableLaterBtn() {
		return enableLaterBtn;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Boots appointment')]")
	private WebElement bootsAppointmentAppMenuBtn;

	public WebElement get_bootsAppointmentAppMenuBtn() {
		return bootsAppointmentAppMenuBtn;
	}
	
	@FindBy(xpath = "//h1[contains(text(),'MY REGISTRATION')]")
	private WebElement myRegistrationTitleTxt;

	public WebElement get_myRegistrationTitleTxt() {
		return myRegistrationTitleTxt;
	}
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueBtn;

	public WebElement get_continueBtn() {
		return continueBtn;
	}
	
	@FindBy(xpath = "//span/button[contains(text(),'Cancel registration')]")
	private WebElement cancelRegistrationBtn;

	public WebElement get_cancelRegistrationBtn() {
		return cancelRegistrationBtn;
	}
	
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement rejectConfirmBtn;

	public WebElement get_rejectConfirmBtn() {
		return rejectConfirmBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Confirm & Continue')]")
	private WebElement confirmBtn;

	public WebElement get_confirmBtn() {
		return confirmBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Confirm and continue')]")
	private WebElement confirmAndContinueBtn;

	public WebElement get_confirmAndContinueBtn() {
		return confirmAndContinueBtn;
	}
	
	@FindBy(id = "consentGiven")
	private WebElement consentCheckBox;
	
	public WebElement get_consentCheckBox() {
		return consentCheckBox;
	}
	
	@FindBy(id = "termsAccepted")
	private WebElement termsCheckBox;
	
	public WebElement get_termsCheckBox() {
		return termsCheckBox;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement get_submitBtn() {
		return submitBtn;
	}
	
	@FindBy(id = "input-test_type")
	private WebElement testTypeDrp;

	public WebElement get_testTypeDrp() {
		return testTypeDrp;
	}
	
	//Confirm your details page
	@FindBy(xpath = "//*[@id='firstname']")
	private WebElement firstNameTxt;
	
	public WebElement get_firstNameTxt() {
		return firstNameTxt;
	}
	
	@FindBy(xpath = "//*[@id='lastname']")
	private WebElement lastNameTxt;
	
	public WebElement get_lastNameTxt() {
		return lastNameTxt;
	}
	
	@FindBy(xpath = "//input[@id='dob']")
	private WebElement dobTxt;

	public WebElement get_dobTxt() {
		return dobTxt;
	}
	
	@FindBy(xpath = "//input[@id='number']")
	private WebElement mobNoTxt;

	public WebElement get_mobNoTxt() {
		return mobNoTxt;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	private WebElement maleBtn;

	public WebElement get_maleBtn() {
		return maleBtn;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Female']")
	private WebElement femaleBtn;
	
	public WebElement get_femaleBtn() {
		return femaleBtn;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement identifyGenderYesBtn;

	public WebElement get_identifyGenderYesBtn() {
		return identifyGenderYesBtn;
	}
	
	@FindBy(xpath = "//label[normalize-space()='No']")
	private WebElement identifyGenderNoBtn;

	public WebElement get_identifyGenderNoBtn() {
		return identifyGenderNoBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueOnCfmDetailsBtn;

	public WebElement get_continueOnCfmDetailsBtn() {
		return continueOnCfmDetailsBtn;
	}
	
	@FindBy(xpath = "//div[contains(text(),'User details confirmed!')]")
	private WebElement detailsCfrmAlert;

	public WebElement get_detailsCfrmAlert() {
		return detailsCfrmAlert;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Start health assessment')]")
	private WebElement startHealthAssessmentBtn;

	public WebElement get_startHealthAssessmentBtn() {
		return startHealthAssessmentBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement continueHealthAssessmentBtn;

	public WebElement get_continueHealthAssessmentBtn() {
		return continueHealthAssessmentBtn;
	}
	
	//Assessment Form2
	@FindBy(xpath = "//input[@name='height']")
	private WebElement heightTxt;

	public WebElement get_heightTxt() {
		return heightTxt;
	}
	
	@FindBy(xpath = "//input[@name='weight']")
	private WebElement weightTxt;

	public WebElement get_weightTxt() {
		return weightTxt;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Metric']")
	private WebElement metricBtn;

	public WebElement get_metricBtn() {
		return metricBtn;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Imperial']")
	private WebElement imperialBtn;

	public WebElement get_imperialBtn() {
		return imperialBtn;
	}
	
	@FindBy(xpath = "//select[@label='Do you smoke cigarettes?']")
	private WebElement smokeCigarettesDrp;

	public WebElement get_smokeCigarettesDrp() {
		return smokeCigarettesDrp;
	}
	
	@FindBy(xpath = "//select[@label='Do you drink alcohol?']")
	private WebElement drinkAlcoholDrp;

	public WebElement get_drinkAlcoholDrp() {
		return drinkAlcoholDrp;
	}
	
	@FindBy(xpath = "//select[@name='cigarettes_per_day']")
	private WebElement cigarettesPerDayDrp;

	public WebElement get_cigarettesPerDayDrp() {
		return cigarettesPerDayDrp;
	}
	
	@FindBy(xpath = "//select[@name='alcohol_units_per_week']")
	private WebElement alcoholPerWeekDrp;

	public WebElement get_alcoholPerWeekDrp() {
		return alcoholPerWeekDrp;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Confirm and continue']")
	private WebElement cnfCntHealthAssessBtn;
	
	public WebElement get_cnfCntHealthAssessBtn() {
		return cnfCntHealthAssessBtn;
	}
	
	//Assessment Form3
	@FindBy(xpath = "//select[@name='physical_activity']")
	private WebElement physicalActivityDrp;
	
	public WebElement get_physicalActivityDrp() {
		return physicalActivityDrp;
	}
	
	@FindBy(xpath = "//select[@name='light_activity_hours_per_week']")
	private WebElement lightActivityDrp;
	
	public WebElement get_lightActivityDrp() {
		return lightActivityDrp;
	}
	
	@FindBy(xpath = "//select[@name='moderate_activity_hours_per_week']")
	private WebElement moderateActivityDrp;
	
	public WebElement get_moderateActivityDrp() {
		return moderateActivityDrp;
	}
	
	@FindBy(xpath = "//select[@name='vigorous_activity_hours_per_week']")
	private WebElement vigorousActivityDrp;
	
	public WebElement get_vigorousActivityDrp() {
		return vigorousActivityDrp;
	}
	
	@FindBy(xpath = "//select[@name='was_diagnosed']")
	private WebElement wasDiagnosedDrp;
	
	public WebElement get_wasDiagnosedDrp() {
		return wasDiagnosedDrp;
	}
	
	@FindBy(xpath = "//select[@label='Have you been diagnosed with any medical conditions?']")
	private WebElement medicalConditionDrp;

	public WebElement get_medicalConditionDrp() {
		return medicalConditionDrp;
	}
	
	@FindBy(xpath = "//input[@name='condition' and @type='checkbox']")
	private List<WebElement> listMedicalConditions;
	
	public List<WebElement> get_listMedicalConditions() {
		return  listMedicalConditions;
	}
	
	@FindBy(xpath = "//select[@name='medication']")
	private WebElement medicationDrp;
	
	public WebElement get_medicationDrp() {
		return  medicationDrp;
	}
	
	@FindBy(xpath = "//input[@name='medications' and @type='checkbox']")
	private List<WebElement> listMedications;
	
	public List<WebElement> get_listMedications() {
		return  listMedications;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Assessment submit']")
	private WebElement assessmentSubmitBtn;

	public WebElement get_assessmentSubmitBtn() {
		return assessmentSubmitBtn;
	}
	
	@FindBy(xpath = "//div[text()='All steps completed successfully']")
	private WebElement successAssessmentSubmissionAlert;

	public WebElement get_successAssessmentSubmissionAlert() {
		return successAssessmentSubmissionAlert;
	}
	
	@FindBy(xpath = "//textarea[@name='other_description']")
	private WebElement medicalConditionOthersDescTxt;

	public WebElement get_medicalConditionOthersDescTxt() {
		return medicalConditionOthersDescTxt;
	}
	
	@FindBy(xpath = "//textarea[@placeholder='Please specify medications here']")
	private WebElement medicationOthersDescTxt;

	public WebElement get_medicationOthersDescTxt() {
		return medicationOthersDescTxt;
	}
	
	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private List<WebElement> healthAssessForm2AllerrorMsg;

	public List<WebElement> get_healthAssessForm2AllerrorMsg() {
		return healthAssessForm2AllerrorMsg;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Edit details']")
	private WebElement editDetailsHealthAssessment;

	public WebElement get_editDetailsHealthAssessment() {
		return editDetailsHealthAssessment;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Assessment details']")
	private WebElement assessmentDetailsTitle;

	public WebElement get_assessmentDetailsTitle() {
		return assessmentDetailsTitle;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Previous step']")
	private WebElement previousStepBtn;

	public WebElement get_previousStepBtn() {
		return previousStepBtn;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Exercise']")
	private WebElement exerciseTitle;

	public WebElement get_exerciseTitle() {
		return exerciseTitle;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Height and weight']")
	private WebElement heightWeightTitle;

	public WebElement get_heightWeightTitle() {
		return heightWeightTitle;
	}
	
	@FindBy(xpath = "//div[normalize-space()='My results']")
	private WebElement myResultBootsMenu;

	public WebElement get_myResultBootsMenu() {
		return myResultBootsMenu;
	}
	
	@FindBy(xpath = "//p[@class='mt-1' and small[text()='Height']]/strong")
	private WebElement heightAssessmentSummaryValue;

	public WebElement get_heightAssessmentSummaryValue() {
		return heightAssessmentSummaryValue;
	}
	
	@FindBy(xpath = "//p[@class='mt-1' and small[text()='Weight']]/strong")
	private WebElement weightAssessmentSummaryValue;

	public WebElement get_weightAssessmentSummaryValue() {
		return weightAssessmentSummaryValue;
	}
	
	@FindBy(xpath = "//p[@class='mt-1' and small[text()='Do you drink alcohol?']]/strong")
	private WebElement alcoholAssessmentSummaryValue;
	
	public WebElement get_alcoholAssessmentSummaryValue() {
		return alcoholAssessmentSummaryValue;
	}
	
	@FindBy(xpath = "//button[@data-testid='Height & weight']")
	private WebElement heightWeightEditBtn;

	public WebElement get_heightWeightEditBtn() {
		return heightWeightEditBtn;
	}
	
	@FindBy(xpath = "//div[@name='progress-bar']")
	private WebElement progressBar;

	public WebElement get_progressBar() {
		return progressBar;
	}
	
	@FindBy(xpath = "//label[@class='labels form-label']")
	private List<WebElement> asteriskLabels;

	public List<WebElement> get_asteriskLabels() {
		return asteriskLabels;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='APPOINTMENT CONFIRMATION']")
	private WebElement appointmentConfirmationTitle;

	public WebElement get_appointmentConfirmationTitle() {
		return appointmentConfirmationTitle;
	}
	
	@FindBy(xpath = "//p[@class='mt-1' and small[text()='Please specify other conditions']]/strong")
	private WebElement otherMedicalConditionAssessmentSummaryValue;

	public WebElement get_otherMedicalConditionAssessmentSummaryValue() {
		return otherMedicalConditionAssessmentSummaryValue;
	}
	
	@FindBy(xpath = "//p[@class='mt-1' and small[text()='Please specify other medications']]/strong")
	private WebElement otherMedicationAssessmentSummaryValue;

	public WebElement get_otherMedicationAssessmentSummaryValue() {
		return otherMedicationAssessmentSummaryValue;
	}
	
	@FindBy(xpath = "//a[normalize-space()='NHS LINK']")
	private WebElement nhsLink;

	public WebElement get_nhsLink() {
		return nhsLink;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Menstrual cycle']")
	private WebElement menstrualCycleTitle;

	public WebElement get_menstrualCycleTitle() {
		return menstrualCycleTitle;
	}
	
	@FindBy(xpath = "//select[@name='cycle_length']")
	private WebElement cycleLengthDrp;

	public WebElement get_cycleLengthDrp() {
		return cycleLengthDrp;
	}
	
	@FindBy(xpath = "//select[@name='day_of_cycle']")
	private WebElement dayOfCycleDrp;

	public WebElement get_dayOfCycleDrp() {
		return dayOfCycleDrp;
	}
	
	@FindBy(xpath = "//select[@name='contraception']")
	private WebElement contraceptionDrp;

	public WebElement get_contraceptionDrp() {
		return contraceptionDrp;
	}
	
	@FindBy(xpath = "//a[@href='/tests/sh/activate'][normalize-space()='Activate kit']")
	private WebElement activateKitSexualHealthBtn;

	public WebElement get_activateKitSexualHealthBtn() {
		return activateKitSexualHealthBtn;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Sexual health']")
	private WebElement sexualHealthTitle;

	public WebElement get_sexualHealthTitle() {
		return sexualHealthTitle;
	}
	
	@FindBy(xpath = "//select[@name='sexually_active']")
	private WebElement sexuallyActiveDrp;

	public WebElement get_sexuallyActiveDrp() {
		return sexuallyActiveDrp;
	}
	
	@FindBy(xpath = "//select[@name='partners']")
	private WebElement sexualPartnersDrp;

	public WebElement get_sexualPartnersDrp() {
		return sexualPartnersDrp;
	}
	
	@FindBy(xpath = "//select[@name='recent_sex']")
	private WebElement recentSexDrp;

	public WebElement get_recentSexDrp() {
		return recentSexDrp;
	}
	
	@FindBy(xpath = "//select[@name='had_unprotected_sex']")
	private WebElement unprotectedSexDrp;

	public WebElement get_unprotectedSexDrp() {
		return unprotectedSexDrp;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Which type of sex was unprotected?']")
	private WebElement whichTypeOfUnprotectedSexFieldTitle;

	public WebElement get_whichTypeOfUnprotectedSexFieldTitle() {
		return whichTypeOfUnprotectedSexFieldTitle;
	}
	
	@FindBy(xpath = "//input[@type='checkbox'][@value='Oral sex']")
	private WebElement oralSexChkBox;

	public WebElement get_oralSexChkBox() {
		return oralSexChkBox;
	}
	
	@FindBy(xpath = "//input[@type='checkbox'][@value='Vaginal sex']")
	private WebElement vaginalSexChkBox;

	public WebElement get_vaginalSexChkBox() {
		return vaginalSexChkBox;
	}
	
	@FindBy(xpath = "//input[@type='checkbox'][@value='Anal sex']")
	private WebElement analSexChkBox;

	public WebElement get_analSexChkBox() {
		return analSexChkBox;
	}
	
	
	@FindBy(xpath = "//select[@name='sti_diagnosed']")
	private WebElement stiDiagnosedDrp;

	public WebElement get_stiDiagnosedDrp() {
		return stiDiagnosedDrp;
	}
	
	@FindBy(xpath = "//select[@name='sti_symptoms']")
	private WebElement stiSymptomsDrp;

	public WebElement get_stiSymptomsDrp() {
		return stiSymptomsDrp;
	}
	
	@FindBy(xpath = "//textarea[@name='sti_symptoms_description']")
	private WebElement stiSymptomsDescriptionTxt;

	public WebElement get_stiSymptomsDescriptionTxt() {
		return stiSymptomsDescriptionTxt;
	}
	
	@FindBy(xpath = "(//label[normalize-space()='Please specify'])[2]")
	private WebElement pleaseSpecifyTitle;

	public WebElement get_pleaseSpecifyTitle() {
		return pleaseSpecifyTitle;
	}
	
	@FindBy(xpath = "//select[@name='potential_sti_exposure']")
	private WebElement potentialSTIExposureDrp;

	public WebElement get_potentialSTIExposureDrp() {
		return potentialSTIExposureDrp;
	}
	
	@FindBy(xpath = "//input[@type='checkbox'][@name='potential_sti_exposure_type']")
	private List<WebElement> potentialSTIExposureTypeChkBox;

	public List<WebElement> get_potentialSTIExposureTypeChkBox() {
		return potentialSTIExposureTypeChkBox;
	}
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement stiWarningCloseBtn;

	public WebElement get_stiWarningCloseBtn() {
		return stiWarningCloseBtn;
	}
	
	@FindBy(xpath = "//div[@class='toast-body'][contains(text(),'Test kit activated')]")
	private WebElement msgTestKitActivatedAlert;

	public WebElement get_msgTestKitActivatedAlert() {
		return msgTestKitActivatedAlert;
	}
	
	@FindBy(xpath = "(//div[@class='bottom-sidebar-text'][normalize-space()='Dashboard'])[1]")
	private WebElement leftSideBarDashhboardBtn;

	public WebElement get_leftSideBarDashhboardBtn() {
		return leftSideBarDashhboardBtn;
	}
	
	@FindBy(xpath = "//div[@role='alert']/a[@role='button']")
	private WebElement dashboardFillAssessmentBtn;

	public WebElement get_dashboardFillAssessmentBtn() {
		return dashboardFillAssessmentBtn;
	}
	
	@FindBy(xpath = "//div[normalize-space()='My results']")
	private WebElement leftSideBarMyResultsBtn;

	public WebElement get_leftSideBarMyResultsBtn() {
		return leftSideBarMyResultsBtn;
	}
	
	@FindBy(xpath = "//input[@id='ethnicity-asian']")
	private WebElement ethnicityRadioBtn;

	public WebElement get_ethnicityRadioBtn() {
		return ethnicityRadioBtn;
	}
	
	
	//TIMS Activate Kit Locators
	@FindBy(xpath = "//button[normalize-space()='Mark kit received']")
	private WebElement markKitReceivedBtn;

	public WebElement get_markKitReceivedBtn() {
		return markKitReceivedBtn;
	}
	
	@FindBy(xpath = "//input[@id='barcode']")
	private WebElement inputBarcodeTxt;

	public WebElement get_inputBarcodeTxt() {
		return inputBarcodeTxt;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement markKitNextBtn;

	public WebElement get_markKitNextBtn() {
		return markKitNextBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Mark as received']")
	private WebElement markAsReceivedBtn;

	public WebElement get_markAsReceivedBtn() {
		return markAsReceivedBtn;
	}
	
	@FindBy(xpath = "//div[@class='toast-body']/p[contains(text(),'test marked as received')]")
	private WebElement testMarkedAsReceivedAlert;

	public WebElement get_testMarkedAsReceivedAlert() {
		return testMarkedAsReceivedAlert;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Upload kit CSV']")
	private WebElement uploadKitCSVHeaderMenuBtn;

	public WebElement get_uploadKitCSVHeaderMenuBtn() {
		return uploadKitCSVHeaderMenuBtn;
	}
	
	@FindBy(xpath = "//input[@id='kit_csv_kit']")
	private WebElement uploadFileInput;

	public WebElement get_uploadFileInput() {
		return uploadFileInput;
	}
	
	@FindBy(xpath = "//form[@id='uploadkitcsv']//button[@type='submit'][normalize-space()='Upload']")
	private WebElement uploadBtn;

	public WebElement get_uploadBtn() {
		return uploadBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Create DNA batch']")
	private WebElement createDNABatchBtn;

	public WebElement get_createDNABatchBtn() {
		return createDNABatchBtn;
	}
	
	@FindBy(xpath = "//form[@id='add_wellness_form']//select[@id='btype']")
	private WebElement typeDNABatchDrp;

	public WebElement get_typeDNABatchDrp() {
		return typeDNABatchDrp;
	}
	
	@FindBy(xpath = "//form[@id='add_wellness_form']//input[@id='barcode_count']")
	private WebElement countDNABatchTxt;

	public WebElement get_countDNABatchTxt() {
		return countDNABatchTxt;
	}
	
	@FindBy(xpath = "//form[@id='add_wellness_form']//button[@id='save_button']")
	private WebElement saveDNABatchBtn;

	public WebElement get_saveDNABatchBtn() {
		return saveDNABatchBtn;
	}
	
	@FindBy(xpath = "//a[@href='/tests/dna/activate'][normalize-space()='Activate kit']")
	private WebElement activateKitDNABtn;

	public WebElement get_activateKitDNABtn() {
		return activateKitDNABtn;
	}
	
	@FindBy(xpath = "//input[@type='checkbox'][@class='form-check-input']")
	private List<WebElement> DNATestConsentChkboxes;
	
	public List<WebElement> get_DNATestConsentChkboxes(){
		return DNATestConsentChkboxes;
	}
	
	@FindBy(xpath = "//div[@id='statusMessageContainer']/span[contains(text(),'CSV uploaded')]")
	private WebElement csvUploadedAlert;

	public WebElement get_csvUploadedAlert() {
		return csvUploadedAlert;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Confirm & continue']")
	private WebElement confirmContinueDNAConsentBtn;

	public WebElement get_confirmContinueDNAConsentBtn() {
		return confirmContinueDNAConsentBtn;
	}
	
	@FindBy(xpath = "//*[name()='circle' and contains(@class,'fill-succe')]")
	private WebElement DNATestPurchasedGreenTick;

	public WebElement get_DNATestPurchasedGreenTick() {
		return DNATestPurchasedGreenTick;
	}
	
	@FindBy(xpath = "//input[@id='is_rejected']")
	private WebElement markKitAsRejectedChkbox;

	public WebElement get_markKitAsRejectedChkbox() {
		return markKitAsRejectedChkbox;
	}
	
	@FindBy(xpath = "//select[@id='rejection_reason']")
	private WebElement selectRejectReasonDrp;

	public WebElement get_selectRejectReasonDrp() {
		return selectRejectReasonDrp;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Mark as Reject']")
	private WebElement markAsRejectedBtn;

	public WebElement get_markAsRejectedBtn() {
		return markAsRejectedBtn;
	}
	
	@FindBy(xpath = "//div[@class='toast-body']/p[contains(text(),'marked as rejected')]")
	private WebElement kitRejectedAlert;

	public WebElement get_kitRejectedAlert() {
		return kitRejectedAlert;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Upload blood result CSV']")
	private WebElement uploadBloodResultCsvBtn;

	public WebElement get_uploadBloodResultCsvBtn() {
		return uploadBloodResultCsvBtn;
	}
	
	@FindBy(xpath = "//div[@id='uploadResultCSV']//input[@id='kit_csv_result']")
	private WebElement uploadBloodResultCsvInput;

	public WebElement get_uploadBloodResultCsvInput() {
		return uploadBloodResultCsvInput;
	}
	
	@FindBy(xpath = "//button[@id='uploadButton']")
	private WebElement csvResultsfileUploadWindowUploadBtn;

	public WebElement get_csvResultsfileUploadWindowUploadBtn() {
		return csvResultsfileUploadWindowUploadBtn;
	}
	
	
}
