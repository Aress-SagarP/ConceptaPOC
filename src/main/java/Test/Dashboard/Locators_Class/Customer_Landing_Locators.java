package Test.Dashboard.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_Landing_Locators {

	public WebDriver driver;

	public Customer_Landing_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='timeline__title']")
	private List<WebElement> timelineTitlesBHT;

	public List<WebElement> get_timelineTitlesBHT() {
		return timelineTitlesBHT;
	}

	@FindBy(xpath = "//a[@role='button' and text()='Fill assessment']")
	private WebElement fillAssessmentTimelineBtn;

	public WebElement get_fillAssessmentTimelineBtn() {
		return  fillAssessmentTimelineBtn;
	}

	@FindBy(xpath = "//p[@class='timeline__title' and text()='Assessment completed']")
	private WebElement assessmentCompletedTimelineTitle;

	public WebElement get_assessmentCompletedTimelineTitle() {
		return  assessmentCompletedTimelineTitle;
	}
	
	@FindBy(css = ".timeline__step.timeline__step--complete")
    private List<WebElement> completedSteps;
	
	 public int get_completedStepsCount() {
        return completedSteps.size();
    }
	
	@FindBy(css = ".timeline__step.timeline__step--complete .timeline__icon .fa-check")
    private List<WebElement> greenCheckIcons;
	
	public int get_greenCheckIconCount() {
        return greenCheckIcons.size();
    }

    @FindBy(css = ".timeline__step.timeline__step--complete .timeline__title")
    private List<WebElement> completedStepTitles;
    
    public List<WebElement> get_completedStepTitles(){
    	return completedStepTitles;
    }
    
    @FindBy(xpath = "//img[@alt='Sample Taken & Returned']/ancestor::div[contains(@class,'timeline__img-container')]/div[contains(@class,'timeline__icon')]/*[contains(@class,'fa-exclamation')]")
	private WebElement rejectedKitRedIcon;

	public WebElement get_rejectedKitRedIcon() {
		return  rejectedKitRedIcon;
	}
	
	@FindBy(xpath = "//div[@class='svg-title text-dark-gray h6 text-center']")
	private List<WebElement> timelineTitlesDNATest;

	public List<WebElement> get_timelineTitlesDNATest() {
		return timelineTitlesDNATest;
	}
	
	@FindBy(xpath = "//*[@class='fill-success']")
    private List<WebElement> completedStepsGreenTickDNA;
	
	public int get_completedStepsCountGreenTickDNA() {
        return completedStepsGreenTickDNA.size();
    }
	
	@FindBy(xpath = "//*/div[contains(@class, 'svg-title')]/ancestor::*/following-sibling::*[*[@class='fill-success']]/preceding-sibling::*/div")
    private List<WebElement> completedStepsTitlesDNA;
	
	public int get_completedStepsTitlesCountDNA() {
        return completedStepsTitlesDNA.size();
    }
	
	public List<WebElement> get_completedStepsTitleDNA(){
		return completedStepsTitlesDNA;
	}
	
	@FindBy(xpath = "//*[name()='circle' and contains(@class,'fill-danger')]")
	private WebElement rejectedKitRedIconDNA;

	public WebElement get_rejectedKitRedIconDNA() {
		return  rejectedKitRedIconDNA;
	}
	
	@FindBy(xpath = "//div[@role='alert' and contains(@class, 'alert-dark')]")
	private WebElement plsCompleteHealthAssessmentMsg;

	public WebElement get_plsCompleteHealthAssessmentMsg() {
		return  plsCompleteHealthAssessmentMsg;
	}
	
	@FindBy(xpath = "//a[@role='button' and contains(text(), 'Fill assessment')]")
	private WebElement testSummaryFillAssessBtn;

	public WebElement get_testSummaryFillAssessBtn() {
		return  testSummaryFillAssessBtn;
	}
	
	@FindBy(xpath = "//div[@role='alert' and contains(@class, 'alert-dark')]")
	private WebElement feelFreeToEditAssessmentMsg;

	public WebElement get_feelFreeToEditAssessmentMsg() {
		return  feelFreeToEditAssessmentMsg;
	}
	
	@FindBy(xpath = "//a[@role='button' and contains(text(), 'Edit assessment')]")
	private WebElement testSummaryEditAssessBtn;

	public WebElement get_testSummaryEditAssessBtn() {
		return  testSummaryEditAssessBtn;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/a")
	private WebElement testKitId;

	public WebElement get_testKitId() {
		return  testKitId;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Upload blood result CSV']")
	private WebElement uploadBloodResultCsvBtn;

	public WebElement get_uploadBloodResultCsvBtn() {
		return  uploadBloodResultCsvBtn;
	}
	
	@FindBy(xpath = "//div[@id='uploadResultCSV']//input[@id='kit_csv_result']")
	private WebElement chooseFileInputBloodResultCSV;

	public WebElement get_chooseFileInputBloodResultCSV() {
		return  chooseFileInputBloodResultCSV;
	}
	
	@FindBy(xpath = "//button[@id='uploadButton']")
	private WebElement bloodResultsCsvUploadBtn;

	public WebElement get_bloodResultsCsvUploadBtn() {
		return  bloodResultsCsvUploadBtn;
	}
	
	@FindBy(xpath = "//div[@id='toaster-msg']//p[text()='Success']")
	private WebElement bloodResultsCsvUploadSuccessMsg;

	public WebElement get_bloodResultsCsvUploadSuccessMsg() {
		return  bloodResultsCsvUploadSuccessMsg;
	}
	
	@FindBy(xpath = "//a[@class='link-text' and text()='View report']")
	private WebElement viewReportLnkText;

	public WebElement get_viewReportLnkText() {
		return  viewReportLnkText;
	}
	
	@FindBy(xpath = "//button[@id='assign-btn']")
	private WebElement headerMenuAssignBtn;

	public WebElement get_headerMenuAssignBtn() {
		return  headerMenuAssignBtn;
	}
	
	@FindBy(xpath = "//button[@type='submit' and text()='Assign']")
	private WebElement popUpAssignBtn;

	public WebElement get_popUpAssignBtn() {
		return  popUpAssignBtn;
	}
	
	@FindBy(xpath = "//div[@role='alert']//p")
	private WebElement toasterAlert;

	public WebElement get_tosterAlert() {
		return  toasterAlert;
	}
	
	@FindBy(xpath = "//div[@class='error-show-hide']/div[3]//p")
	private WebElement doctorAssignedAlert;

	public WebElement get_doctorAssignedAlert() {
		return  doctorAssignedAlert;
	}
	
	@FindBy(xpath = "//button[@id='sh-consultation-required']")
	private WebElement shConsultationRequiredBtn;

	public WebElement get_shConsultationRequiredBtn() {
		return  shConsultationRequiredBtn;
	}
	
	@FindBy(xpath = "//div[@id='consultationModal']//button[@type='submit'][normalize-space()='Yes']")
	private WebElement shConsultationRequiredAlertYesBtn;

	public WebElement get_shConsultationRequiredAlertYesBtn() {
		return  shConsultationRequiredAlertYesBtn;
	}
	
	@FindBy(xpath = "//p[normalize-space()='Booking mail sent']")
	private WebElement bookingMailSentAlert;

	public WebElement get_bookingMailSentAlert() {
		return  bookingMailSentAlert;
	}
	
	@FindBy(xpath = "//p[normalize-space()='consultation required']")
	private WebElement shTestTimelineConsultationReqTitle;

	public WebElement get_shTestTimelineConsultationReqTitle() {
		return  shTestTimelineConsultationReqTitle;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Phone consultation required']")
	private WebElement phoneConsultationRequiredTitle;

	public WebElement get_phoneConsultationRequiredTitle() {
		return  phoneConsultationRequiredTitle;
	}
	
	@FindBy(xpath = "//div[@role='alert']/p[contains(text(),'Thank you')]")
	private WebElement shTestTimelineThankyouTxt;

	public WebElement get_shTestTimelineThankyouTxt() {
		return  shTestTimelineThankyouTxt;
	}
	
	@FindBy(xpath = "//div[@role='alert']//strong[contains(text(),'To schedule')]")
	private WebElement shTestTimelineToScheduleAppointmentTxt;

	public WebElement get_shTestTimelineToScheduleAppointmentTxt() {
		return  shTestTimelineToScheduleAppointmentTxt;
	}
	
	@FindBy(xpath = "//div[@role='alert']//li")
	private WebElement shTestTimelinePleaseNoteTxt;

	public WebElement get_shTestTimelinePleaseNoteTxt() {
		return  shTestTimelinePleaseNoteTxt;
	}
	
	@FindBy(xpath = "//iframe[@title='Calendly Scheduling Page']")
	private WebElement calendlyCalendar;

	public WebElement get_calendlyCalendar() {
		return  calendlyCalendar;
	}
	
	@FindBy(xpath = "//tbody[@data-testid='calendar-table']//td/button")
	private List<WebElement> calendlyCalendarDates;

	public List<WebElement> get_calendlyCalendarDates() {
		return  calendlyCalendarDates;
	}
	
	@FindBy(xpath = "//div[@role='listitem']/button")
	private List<WebElement> calendlyCalendarTimes;

	public List<WebElement> get_calendlyCalendarTimes() {
		return  calendlyCalendarTimes;
	}
	
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement calendlyCalendarNextBtn;

	public WebElement get_calendlyCalendarNextBtn() {
		return  calendlyCalendarNextBtn;
	}
	
	@FindBy(xpath = "//span[text()='Schedule Event']/parent::button")
	private WebElement calendlyCalendarScheduleEventBtn;

	public WebElement get_calendlyCalendarScheduleEventBtn() {
		return  calendlyCalendarScheduleEventBtn;
	}
	
	@FindBy(xpath = "//h1[normalize-space()='You are scheduled']")
	private WebElement calendlyCalendarSuccessfulAppointmentMsg;

	public WebElement get_calendlyCalendarSuccessfulAppointmentMsg() {
		return  calendlyCalendarSuccessfulAppointmentMsg;
	}
	
	@FindBy(xpath = "//a[@id='nav-report-tab']")
	private WebElement navTabReportBtn;

	public WebElement get_navTabReportBtn() {
		return  navTabReportBtn;
	}
	
	@FindBy(xpath = "//button[@id='generalButton']")
	private WebElement reportTabGeneralBtn;

	public WebElement get_reportTabGeneralBtn() {
		return  reportTabGeneralBtn;
	}
	
	@FindBy(xpath = "//select[@id='overallStatusSelect']")
	private WebElement overallStatusDrp;

	public WebElement get_overallStatusDrp() {
		return  overallStatusDrp;
	}
	
	@FindBy(xpath = "//h6[text()='Sexual Health']/parent::button")
	private WebElement reportTabSexualHealthBtn;

	public WebElement get_reportTabSexualHealthBtn() {
		return  reportTabSexualHealthBtn;
	}
	
	@FindBy(xpath = "//select[@id='sexualhealth-groupStatusSelect']")
	private WebElement groupStatusDrp;

	public WebElement get_groupStatusDrp() {
		return  groupStatusDrp;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Save changes']")
	private WebElement reportTabSaveChangesBtn;

	public WebElement get_reportTabSaveChangesBtn() {
		return  reportTabSaveChangesBtn;
	}
	
	@FindBy(xpath = "//button[@id='publish-btn']")
	private WebElement headerMenuPublishBtn;

	public WebElement get_headerMenuPublishBtn() {
		return  headerMenuPublishBtn;
	}
	
	@FindBy(xpath = "//div[@id='publishModal']//button[@type='submit'][normalize-space()='Yes']")
	private WebElement publishReportYesBtn;

	public WebElement get_publishReportYesBtn() {
		return  publishReportYesBtn;
	}
	
	@FindBy(xpath = "//span[text()=\"Doctor's letter\"]/ancestor::button")
	private WebElement doctorsLetterBtn;

	public WebElement get_doctorsLetterBtn() {
		return doctorsLetterBtn;
	}
	
	@FindBy(xpath = "//span[text()='Your results']/ancestor::button")
	private WebElement yourResultsBtn;

	public WebElement get_yourResultsBtn() {
		return yourResultsBtn;
	}
	
	@FindBy(xpath = "//p[normalize-space()='Changes saved successfully']")
	private WebElement changesSavedAlert;

	public WebElement get_changesSavedAlert() {
		return changesSavedAlert;
	}
	
	@FindBy(xpath = "//p[contains(text(),'Published Report')]")
	private WebElement reportPublishedAlert;

	public WebElement get_reportPublishedAlert() {
		return reportPublishedAlert;
	}
	
	@FindBy(xpath = "//div[@class='col-md-6']")
	private List<WebElement> testSummaryFieldBlocks;

	public List<WebElement> get_testSummaryFieldBlocks() {
		return testSummaryFieldBlocks;
	}
	
	@FindBy(xpath = "//div[@class='blood-report-main--desktop']//div[@class='markerCard__content']")
	private List<WebElement> biomarkerFieldBlocksSHTest;

	public List<WebElement> get_biomarkerFieldBlocksSHTest() {
		return biomarkerFieldBlocksSHTest;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement timsKitTypeTxt;

	public WebElement get_timsKitTypeTxt() {
		return timsKitTypeTxt;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]")
	private WebElement timsBookingReferenceTxt;

	public WebElement get_timsBookingReferenceTxt() {
		return timsBookingReferenceTxt;
	}
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	private WebElement timsStatusTxt;

	public WebElement get_timsStatusTxt() {
		return timsStatusTxt;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Upload DNA result CSV']")
	private WebElement headerUploadDnaResultsCsvBtn;

	public WebElement get_headerUploadDnaResultsCsvBtn() {
		return headerUploadDnaResultsCsvBtn;
	}
	
	@FindBy(xpath = "//div[@id='uploaddnaResultCSV']//input[@id='kit_csv_result']")
	private WebElement chooseFileToUploadDna;

	public WebElement get_chooseFileToUploadDna() {
		return chooseFileToUploadDna;
	}
	
	@FindBy(xpath = "//div[@id='uploaddnaResultCSV']//button[@type='submit'][normalize-space()='Upload']")
	private WebElement uploadDnaResultsPopUpBtn;

	public WebElement get_uploadDnaResultsPopUpBtn() {
		return uploadDnaResultsPopUpBtn;
	}
	
	@FindBy(xpath = "//div[@id='statusMessageContainer']")
	private WebElement dnaResultsUploadedConfAlert;

	public WebElement get_dnaResultsUploadedConfAlert() {
		return dnaResultsUploadedConfAlert;
	}
	
	@FindBy(xpath = "//button[normalize-space()='View report']")
	private WebElement dnaTestViewReportBtn;

	public WebElement get_dnaTestViewReportBtn() {
		return dnaTestViewReportBtn;
	}
	
	@FindBy(xpath = "//span[@class='sm-heading']")
	private List<WebElement> dnaTestReportHealthAreas;

	public List<WebElement> get_dnaTestReportHealthAreas() {
		return dnaTestReportHealthAreas;
	}
}
