package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import Test.Dashboard.Locators_Class.Login_Boot_Locators;
import Test.Tims.Actions_Class.Login_Action;
import Test.Tims.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;

public class Login_Boot_Actions extends BaseClass {

	public WebDriver driver;
	Login_Boot_Locators login_boot_locators;
	Login_Action login_action;
	Login_Locators login_locators;

	public Login_Boot_Actions(WebDriver driver) {
		this.driver = driver;
		login_boot_locators = new Login_Boot_Locators(driver);
	}
	

	public void bootUrl() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("dashboard_dev");
		driver.get(urlKey);

	}
	
	

	public void enterEmailIDBoot(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(login_boot_locators.get_emailBootTxt(), EmailID);

	}

	public void enterPasswordBoot(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(login_boot_locators.get_passwordBootTxt(), Password);
	}

	public void clickLoginButton_boot() {
		// click on login
		WebWait.elementToBeClickable(driver, login_boot_locators.get_loginBootBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(login_boot_locators.get_loginBootBtn());

	}

	public void verifySuccessMsg_boot() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.get_loginSuccessMsg(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.get_loginSuccessMsg().getText());

	}

	public void checkEnableBtn() throws IOException, InterruptedException {

		WebWait.elementToBeClickable(driver, login_boot_locators.get_enableLaterBtn(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_enableLaterBtn(), driver);

	}
	
	public void successfulLogin() throws IOException, InterruptedException {
		WebWait.elementToBeClickable(driver, login_boot_locators.get_enableLaterBtn(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_enableLaterBtn(), driver);
		WebWait.visibilityOfElement(driver, login_boot_locators.get_loginSuccessMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_loginSuccessMsg().getText());
		assertTrue(login_boot_locators.get_loginSuccessMsg().isDisplayed(), "User did not login successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+login_boot_locators.get_loginSuccessMsg().getText());
	}
	
	public void successfulLogout() {
		WebWait.visibilityOfElement(driver, login_boot_locators.get_bootMenuLogoutBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(login_boot_locators.get_bootMenuLogoutBtn(), driver);
		WebWait.visibilityOfElement(driver, login_boot_locators.get_logoutBtn(), Duration.ofSeconds(10));
		WebButton.JsclickButton(login_boot_locators.get_logoutBtn(), driver);
		WebWait.visibilityOfElement(driver, login_boot_locators.get_successfulLogoutMsg(), Duration.ofSeconds(10));
		System.out.println("Alert: "+login_boot_locators.get_successfulLogoutMsg().getText());
		assertTrue(login_boot_locators.get_successfulLogoutMsg().isDisplayed(), "User did not logout successfully");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+login_boot_locators.get_successfulLogoutMsg().getText());
		
	}
	
	public void incorrectEmailPassword() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_incorrect_email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_incorrect_password"));
		login_action.clickLoginButton_Dashboard();
		WebWait.visibilityOfElement(driver, login_boot_locators.get_emailNotFoundAlert(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_emailNotFoundAlert().getText());
		assertEquals(login_boot_locators.get_emailNotFoundAlert().getText(), "Email not found in our records.");
		ExtentManager.getTest().log(Status.PASS,"Alert: "+login_boot_locators.get_emailNotFoundAlert().getText());
	}
	
	public void emptyEmailLogin() throws IOException, InterruptedException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_emptyEmail"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_incorrect_password"));
		login_action.clickLoginButton_Dashboard();
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, login_boot_locators.get_emailIsRequiredErrorMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_emailIsRequiredErrorMsg().getText());
		assertEquals(login_boot_locators.get_emailIsRequiredErrorMsg().getText(), "Email is required");
		ExtentManager.getTest().log(Status.PASS,"Alert: "+login_boot_locators.get_emailIsRequiredErrorMsg().getText());
	}
	
	public void emptyPasswordLogin() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_emptyPassword"));
		login_action.clickLoginButton_Dashboard();
		WebWait.visibilityOfElement(driver, login_boot_locators.get_passwordIsRequiredErrorMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_passwordIsRequiredErrorMsg().getText());
		assertEquals(login_boot_locators.get_passwordIsRequiredErrorMsg().getText(), "Password is required", "Password error message mismatch");
		ExtentManager.getTest().log(Status.PASS,"Alert: "+login_boot_locators.get_passwordIsRequiredErrorMsg().getText());
	}
	
	public void invalidEmail() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_invalid_email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
		login_action.clickLoginButton_Dashboard();
		WebWait.visibilityOfElement(driver, login_boot_locators.get_invalidEmailErrorMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_invalidEmailErrorMsg().getText());
		assertEquals(login_boot_locators.get_invalidEmailErrorMsg().getText(), "Please enter a valid email", "Email error message mismatch");
		ExtentManager.getTest().log(Status.PASS,"Alert: "+login_boot_locators.get_invalidEmailErrorMsg().getText());
	}
	
	public String invalidEmailMsg() {
		WebWait.visibilityOfElement(driver, login_boot_locators.getErrorInvalidEmail_boot(), Duration.ofSeconds(30));
		System.out.println("Error: "+login_boot_locators.getErrorInvalidEmail_boot().getText());
		return login_boot_locators.getErrorInvalidEmail_boot().getText();
	}

	public void checkContinueBtn() throws IOException, InterruptedException {
		WebButton.clickButton(login_boot_locators.get_bootsAppointment());
		//WebWait.elementToBeClickable(driver, login_boot_locators.getboots_Appointment(), Duration.ofSeconds(30));

		Thread.sleep(2000);
		//WebWait.elementToBeClickable(driver, login_boot_locators.getContinueBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(login_boot_locators.get_continueBtn());
		System.out.println(login_boot_locators.get_continueBtn().getText());
		
		Assert.assertEquals(driver, login_boot_locators.get_continueBtn().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_continueBtn"));
		WebButton.JsclickButton(login_boot_locators.get_continueBtn(), driver);

	}
	
	public void passwordCaseSensitivity() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_pass_case_sensitive"));
		login_action.clickLoginButton_Dashboard();
		WebWait.visibilityOfElement(driver, login_boot_locators.get_incorrectPasswordBootMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_incorrectPasswordBootMsg().getText());
		assertTrue(login_boot_locators.get_incorrectPasswordBootMsg().isDisplayed(), "Error message is not displayed");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+login_boot_locators.get_incorrectPasswordBootMsg().getText());
	}
	
	public void emailCaseSensitivity() throws IOException {
		login_action = new Login_Action(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_email_case_sensitive"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
		login_action.clickLoginButton_Dashboard();
		WebWait.visibilityOfElement(driver, login_boot_locators.get_loginSuccessMsg(), Duration.ofSeconds(30));
		System.out.println("Alert: "+login_boot_locators.get_loginSuccessMsg().getText());
		assertTrue(login_boot_locators.get_loginSuccessMsg().isDisplayed(), "Login failed");
		ExtentManager.getTest().log(Status.PASS, "Alert: "+login_boot_locators.get_loginSuccessMsg().getText());
	}
	
	public void passwordVisibilityToggle() throws IOException {
		login_action = new Login_Action(driver);
		login_locators = new Login_Locators(driver);
		login_action.enterEmailID_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Email"));
		login_action.enterPassword_DB(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
		String initialType = login_locators.get_inputLoginPassword().getAttribute("type");
		System.out.println("Initial password field type: " + initialType);
	    Assert.assertEquals(initialType, "password", "Initial input type should be 'password'");
	    ExtentManager.getTest().log(Status.PASS, "Initial password field type: " + initialType);
	    WebButton.JsclickButton(login_boot_locators.get_loginEyeIcon(), driver);
	    String visibleType = login_locators.get_inputLoginPassword().getAttribute("type");
	    System.out.println("Password field type after clicking eye icon: " + visibleType);
	    Assert.assertEquals(visibleType, "text", "Input type should be 'text' after clicking eye icon");
	    ExtentManager.getTest().log(Status.PASS, "Password field type after clicking eye icon: " + visibleType);
	}
	
	public void visibilityOfLoginPageElements() {
		login_locators = new Login_Locators(driver);
		WebElement email = login_locators.get_inputLoginEmail();
		WebElement password = login_locators.get_inputLoginPassword();
		WebElement loginBtn = login_boot_locators.get_loginBootBtn();
		WebWait.visibilityOfElement(driver, email , Duration.ofSeconds(10));
		WebWait.visibilityOfElement(driver, password, Duration.ofSeconds(10));
		WebWait.visibilityOfElement(driver, loginBtn , Duration.ofSeconds(10));
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(email.isDisplayed(), "Email input field is not displayed.");
		softAssert.assertTrue(password.isDisplayed(), "Password input field is not displayed.");
		softAssert.assertTrue(loginBtn.isDisplayed(), "Login button is not displayed.");

		if (email.isDisplayed()) {
			System.out.println("Label - " + login_boot_locators.get_labelEmail().getText());
			ExtentManager.getTest().log(Status.PASS, "Label - " + login_boot_locators.get_labelEmail().getText());
		}
		if (password.isDisplayed()) {
			System.out.println("Label - " + login_boot_locators.get_labelPassword().getText());
			ExtentManager.getTest().log(Status.PASS, "Label - " + login_boot_locators.get_labelPassword().getText());
		}
		if (loginBtn.isDisplayed()) {
			System.out.println("Login Button Text: " + loginBtn.getText());
			ExtentManager.getTest().log(Status.PASS, "Login Button Text: " + loginBtn.getText());
		}
		softAssert.assertAll();
	}

	public void clickDropdown() {
		WebWait.elementToBeClickable(driver, login_boot_locators.get_testTypeDrp(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_testTypeDrp(), driver);

	}

	public void clickconfirmCtnBtn() throws InterruptedException {
		WebWait.elementToBeClickable(driver, login_boot_locators.get_confirmCtnBtn(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_confirmCtnBtn(), driver);

		Thread.sleep(3000);
	}

	public void verifyTestTypeCnfmsg() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.get_testTypeCnfmMsg(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.get_testTypeCnfmMsg().getText());
		Assert.assertEquals(driver, login_boot_locators.get_testTypeCnfmMsg().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_testTypeConfirm"));

	}

	public void clickEmptyDropdown() {
		WebWait.elementToBeClickable(driver, login_boot_locators.get_noSelectDrp(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_noSelectDrp(), driver);

	}

	public void clickChkboxSubmit() {
		WebWait.elementToBeClickable(driver, login_boot_locators.get_consentChkbox(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_consentChkbox(), driver);
		WebWait.elementToBeClickable(driver, login_boot_locators.get_acceptTermsChkbox(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_acceptTermsChkbox(), driver);
		WebWait.elementToBeClickable(driver, login_boot_locators.get_submitConsentBtn(), Duration.ofSeconds(30));
		WebButton.JsclickButton(login_boot_locators.get_submitConsentBtn(), driver);
	}

	public void verifyConsentMsg() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, login_boot_locators.get_consentSaveSuccessMsg(), Duration.ofSeconds(30));
		System.out.println(login_boot_locators.get_consentSaveSuccessMsg().getText());
		Assert.assertEquals(driver, login_boot_locators.get_consentSaveSuccessMsg().getText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Assertion_Consent"));

	}

	public void login_boot() throws IOException, InterruptedException {
		bootUrl();
		enterEmailIDBoot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_boot"));
		enterPasswordBoot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_boot"));
		clickLoginButton_boot();
		checkEnableBtn();
		verifySuccessMsg_boot();
		checkContinueBtn();
		clickDropdown();
		clickconfirmCtnBtn();
		verifyTestTypeCnfmsg();
		clickChkboxSubmit();
		verifyConsentMsg();
	}

	public void negativeWithoutTetstype() throws IOException, InterruptedException {
		bootUrl();
		enterEmailIDBoot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_boot"));
		enterPasswordBoot(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_boot"));
		clickLoginButton_boot();
		checkEnableBtn();
		checkContinueBtn();
		clickEmptyDropdown();
		clickconfirmCtnBtn();

	}

}
