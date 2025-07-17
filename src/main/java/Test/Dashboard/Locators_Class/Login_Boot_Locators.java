package Test.Dashboard.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Boot_Locators {
	public WebDriver driver;

	public Login_Boot_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailBootTxt;

	public WebElement get_emailBootTxt() {
		return emailBootTxt;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordBootTxt;

	public WebElement get_passwordBootTxt() {
		return passwordBootTxt;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Incorrect password.']")
	private WebElement incorrectPasswordBootMsg;
	
	public WebElement get_incorrectPasswordBootMsg() {
		return incorrectPasswordBootMsg;
	}
	
	@FindBy(xpath ="//div[@class='invalid-feedback']")
	private WebElement errorInvalidEmail;
	
	public WebElement getErrorInvalidEmail_boot() {
		return errorInvalidEmail;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBootBtn;

	public WebElement get_loginBootBtn() {
		return loginBootBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Log out']")
	private WebElement bootMenuLogoutBtn;
	
	public WebElement get_bootMenuLogoutBtn() {
		return bootMenuLogoutBtn;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Logout']")
	private WebElement logoutBtn;
	
	public WebElement get_logoutBtn() {
		return logoutBtn;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Logged out successfully!']")
	private WebElement successfulLogoutMsg;
	
	public WebElement get_successfulLogoutMsg() {
		return successfulLogoutMsg;
	}

	@FindBy(xpath = "//button[normalize-space()='Enable Later']")
	private WebElement enableLaterBtn;

	public WebElement get_enableLaterBtn() {
		return enableLaterBtn;
	}
	
	@FindBy(xpath = "//*[contains(text(), 'Boots appointment')]")
	private WebElement bootsAppointment;

	public WebElement get_bootsAppointment() {
		return bootsAppointment;
	}

	@FindBy(xpath = "//*[contains(text(), 'Logged in successfully!')]")
	private WebElement loginSuccessMsg;

	public WebElement get_loginSuccessMsg() {
		return loginSuccessMsg;
	}
	
	@FindBy(xpath = "//p[contains(text(),'Welcome to your personalised MyHealthChecked panel')]")
	private WebElement WelcomeMsg;
	
	public WebElement get_WelcomeMsg() {
		return WelcomeMsg;
	}

	@FindBy(xpath = "//a[contains(@href,'/bloods/boots/registration/blood-thyroid')]")
	private WebElement continueBtn;

	public WebElement get_continueBtn() {
		return continueBtn;
	}

	@FindBy(xpath = "(//option[@value='blood-thyroid'])[1]")
	private WebElement testTypeDrp;

	public WebElement get_testTypeDrp() {
		return testTypeDrp;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement confirmCtnBtn;

	public WebElement get_confirmCtnBtn() {
		return confirmCtnBtn;
	}

	@FindBy(xpath = "//*[contains(text(), 'Test type confirmed!')]")
	private WebElement testTypeCnfmMsg;

	public WebElement get_testTypeCnfmMsg() {
		return testTypeCnfmMsg;
	}

	@FindBy(xpath = "(//select[@id='input-test_type'])")
	private WebElement noSelectDrp;

	public WebElement get_noSelectDrp() {
		return noSelectDrp;
	}

	@FindBy(xpath = "(//input[@id='consentGiven'])")
	private WebElement consentChkbox;

	public WebElement get_consentChkbox() {
		return consentChkbox;
	}

	@FindBy(xpath = "(//input[@id='termsAccepted'])")
	private WebElement acceptTermsChkbox;

	public WebElement get_acceptTermsChkbox() {
		return acceptTermsChkbox;
	}

	@FindBy(xpath = "(//button[@type='submit'])")
	private WebElement submitConsentBtn;

	public WebElement get_submitConsentBtn() {
		return submitConsentBtn;
	}
	
	@FindBy(xpath = "//*[contains(text(), 'Consent saved!')]")
	private WebElement consentSaveSuccessMsg;

	public WebElement get_consentSaveSuccessMsg() {
		return consentSaveSuccessMsg;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Email not found')]")
	private WebElement emailNotFoundAlert;
	
	public WebElement get_emailNotFoundAlert() {
		return emailNotFoundAlert;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Email is required']")
	private WebElement emailIsRequiredErrorMsg;
	
	public WebElement get_emailIsRequiredErrorMsg() {
		return emailIsRequiredErrorMsg;
	}
	
	@FindBy(xpath = "//div[@class='input-group']/div[1]")
	private WebElement passwordIsRequiredErrorMsg;
	
	public WebElement get_passwordIsRequiredErrorMsg() {
		return passwordIsRequiredErrorMsg;
	}
	
	@FindBy(xpath = "//div[normalize-space()='Please enter a valid email']")
	private WebElement invalidEmailErrorMsg;
	
	public WebElement get_invalidEmailErrorMsg() {
		return invalidEmailErrorMsg;
	}
	
	@FindBy(xpath = "//span[@class='password-input input-group-text']")
	private WebElement loginEyeIcon;
	
	public WebElement get_loginEyeIcon() {
		return loginEyeIcon;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Email']")
	private WebElement labelEmail;
	
	public WebElement get_labelEmail() {
		return labelEmail;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Password']")
	private WebElement labelPassword;
	
	public WebElement get_labelPassword() {
		return labelPassword;
	}
	
}
