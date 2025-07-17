package Test.Dashboard.Locators_Class;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Reset_Password_Locators {
	public WebDriver driver;

	public Reset_Password_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(), 'forgot password?')]")
	private WebElement forgotPasswordLink;

	public WebElement get_forgotPasswordLink() {
		return forgotPasswordLink;
	}

	@FindBy(xpath = "//p[@class='text-muted']")
	private WebElement resetPasswordEmailLinkSentMsg;

	public WebElement get_resetPasswordEmailLinkSentMsg() {
		return resetPasswordEmailLinkSentMsg;
	}

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextBox;

	public WebElement get_emailTextBox() {
		return emailTextBox;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement resetPasswordBtn;

	public WebElement get_resetPasswordBtn() {
		return resetPasswordBtn;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement newPasswordText;

	public WebElement get_newPasswordText() {
		return newPasswordText;
	}

	@FindBy(xpath = "//input[@name='confirm_password']")
	private WebElement newConfirmPasswordText;

	public WebElement get_newConfirmPasswordText() {
		return newConfirmPasswordText;
	}

	@FindBy(xpath = "//p[contains(text(),'Your email does not match our records')]")
	private WebElement warningMsgEmailDoesNotMatch;

	public WebElement get_warningMsgEmailDoesNotMatch() {
		return warningMsgEmailDoesNotMatch;
	}

	@FindBy(xpath = "//div[@class='toast-body']")
	private WebElement warningMsgResetPasswordLinkExpired;

	public WebElement get_warningMsgResetPasswordLinkExpired() {
		return warningMsgResetPasswordLinkExpired;
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailLoginAfterPasswordResettedText;

	public WebElement get_emailLoginAfterPasswordResettedText() {
		return emailLoginAfterPasswordResettedText;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordLoginAfterPasswordResettedText;

	public WebElement get_passwordLoginAfterPasswordResettedText() {
		return passwordLoginAfterPasswordResettedText;
	}

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	private WebElement signInAfterPasswordResettedBtn;

	public WebElement get_signInAfterPasswordResettedBtn() {
		return signInAfterPasswordResettedBtn;
	}

	@FindBy(xpath = "//div[contains(text(),'Password must not contain repetitive characters')]")
	private WebElement consecutivePasswordWarningMsg;

	public WebElement get_consecutivePasswordWarningMsg() {
		return consecutivePasswordWarningMsg;
	}

	@FindBy(xpath = "//div[@class='invalid-feedback'][contains(text(),'Email is required')]")
	private WebElement blankEmailWarningMsg;

	public WebElement get_blankEmailWarningMsg() {
		return blankEmailWarningMsg;
	}

	@FindBy(xpath = "//div[contains(text(),'Enable MFA')]")
	private WebElement loginSuccessfulMsg;

	public WebElement get_loginSuccessfulMsg() {
		return loginSuccessfulMsg;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtnafterPasswordReset;

	public WebElement get_signInBtnafterPasswordReset() {
		return signInBtnafterPasswordReset;
	}
	
	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement errorMsg;

	public WebElement get_errorMsg() {
		return errorMsg;
	}
}
