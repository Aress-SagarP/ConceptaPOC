package Test.Dashboard.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Account_Locators {
	public WebDriver driver;

	public Create_Account_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Sign up']")
	private WebElement createAccountPageFirst;

	public WebElement get_createAccountButtonPageFirst() {
		return createAccountPageFirst;
	}

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement fristNameTxt;

	public WebElement get_fristNameTxt() {
		return fristNameTxt;
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTxt;

	public WebElement get_lastNameTxt() {
		return lastNameTxt;
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTxt;

	public WebElement get_emailTxt() {
		return emailTxt;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTxt;

	public WebElement get_passwordTxt() {
		return passwordTxt;
	}

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-borderAnimation']")
	private WebElement checkboxRecapcha;

	public WebElement get_checkboxRecapcha() {
		return checkboxRecapcha;
	}

	@FindBy(xpath = "//button[contains(text(),'Create account')]")
	private WebElement createAccountPageSecond;

	public WebElement get_createAccountButtonPageSecond() {
		return createAccountPageSecond;
	}

	@FindBy(xpath = "//a[normalize-space()='Sign up']")
	private WebElement signUpBtn;

	public WebElement get_signUpBtn() {
		return signUpBtn;
	}

	@FindBy(xpath = "//div[@role='progressbar']")
	private WebElement pwdStrengthWeak;

	public WebElement get_pwdStrengthWeakh() {
		return pwdStrengthWeak;
	}

	@FindBy(xpath = "//input[@name='marketing_consent']")
	private WebElement marketingConsentCheckbox;

	public WebElement get_marketingConsentCheckbox() {
		return marketingConsentCheckbox;
	}

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement mandatoryFeildErrorMsg;

	public WebElement get_mandatoryFeildErrorMsg() {
		return mandatoryFeildErrorMsg;
	}

	@FindBy(xpath = "//label[normalize-space()='First name']")
	private WebElement labelFirstName;

	public WebElement get_labelFirstName() {
		return labelFirstName;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createBtn;

	public WebElement get_createBtn() {
		return createBtn;
	}
    	
	@FindBy(xpath = "//div[@class='toast-body']")
	private WebElement errorMsg;

	public WebElement get_errorMsg() {
		return errorMsg;
	}
	
	@FindBy(xpath = "//label[normalize-space()='Last name']")
	private WebElement lableLastName;

	public WebElement get_lableLastName() {
		return lableLastName;
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

	@FindBy(xpath = "//label[contains(text(),'like to get health tips, product updates,')]")
	private WebElement labelMarketingConsent;

	public WebElement get_labelMarketingConsent() {
		return labelMarketingConsent;
	}

	@FindBy(xpath = "//*[contains(text(),'Please check your email to confirm your new account and login')]")
	private WebElement createAccountSucessMsg;

	public WebElement get_createAccountSucessMsg() {
		return createAccountSucessMsg;
	}
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement emailLinkRedirectionSuccess;

	public WebElement get_emailLinkRedirectionSuccess() {
		return emailLinkRedirectionSuccess;
	}
}
