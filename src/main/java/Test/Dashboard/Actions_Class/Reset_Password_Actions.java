package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import java.io.IOException;
import java.time.Duration;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import com.aventstack.extentreports.Status;
import Test.Dashboard.Locators_Class.Reset_Password_Locators;

public class Reset_Password_Actions extends BaseClass {

	public WebDriver driver;
	Reset_Password_Locators reset_password_locators;
	ReadGmail read_gmail = new ReadGmail();
	public String getResetPasswordLinkFromEmail;
	private static String randomValue;
	private String var1, var2;

	public Reset_Password_Actions(WebDriver driver) {
		this.driver = driver;
		reset_password_locators = new Reset_Password_Locators(driver);

	}

	public void dashboardUrl() throws IOException {
		String urlKey = determineUrlKey("dashboard_automation_resetpassword_staging");
		driver.get(urlKey);

	}

	public void resetPasswordForgotPasswordLinkEnabledOrNot() throws Exception {

		Assert.assertTrue(reset_password_locators.get_forgotPasswordLink().isEnabled(),
				"Forgot Password Link is not enable");
		clickForgotPassword();

	}

	public void resetPasswordBehaviorWhenUserKeepEmailAddressFieldEmptyDuringThisProcess() throws Exception {
		clickResetPassword();
		Assert.assertTrue(reset_password_locators.get_blankEmailWarningMsg().isDisplayed(),
				"Does not Shown any error for blank email"); 
	}

	public void resetPasswordNavigationOfPasswordResetLinkAvailableInEmail() throws Exception {
		enterEmail();
		Thread.sleep(4000);
		clickResetPassword();
		Thread.sleep(8000);
		getResetPasswordLinkFromEmail = read_gmail.getButtonURL("URL_Redirect_Profile");
		System.out.print(getResetPasswordLinkFromEmail);
		Assert.assertTrue(getResetPasswordLinkFromEmail != null, "Email does not contain an email password link"); 
		driver.navigate().to(getResetPasswordLinkFromEmail);
		Thread.sleep(4000);
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
		            clickResetPassword();
		                                 
	}
	public void resetPasswordWithoutPassword() throws InterruptedException
	{
		Thread.sleep(4000);
		clickResetPassword();		
		Assert.assertTrue(reset_password_locators.get_errorMsg().isDisplayed(),
				"Without Entering Password is Resetted");
		
	}
	
	public void resetPasswordComplexity() throws Exception {
		enterConsecutivePassword();
		enterConsecutiveRepeatPassword();
		clickResetPassword();
		Thread.sleep(4000);
		Assert.assertTrue(reset_password_locators.get_consecutivePasswordWarningMsg().isDisplayed(),
				"Does not Shown any error for complex password"); 
	}

	public void resetPasswordSystemPreventsUsersFromReusingOldPasswordsWhenResetting() throws Exception {
		enterOldPassword();
		/*
		 * need to find the exact locator for this error msg
		 * Assert.assertTrue(reset_password_locators.getconsecutivePasswordWarningMsg().
		 * isDisplayed(), "Does not Shown any error for complex password"); // Assersion
		 * for TC_10
		 */}

	public void resetPasswordFunctionalityWithValidEmailAddress() throws Exception {
		randomNumberGenerator();
		enterNewPassword();
		enterNewConfirmPassword();
		clickResetPassword();
		Thread.sleep(8000);
		String UpdatesPasswordURL = driver.getCurrentUrl();
		String ActualUpdatesPasswordUR = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile,
				"AfterResetGoToLoginPageURL");
		Assert.assertEquals(ActualUpdatesPasswordUR, UpdatesPasswordURL); 
	}

	public void resetPasswordSuccessfulLoginAfterResettingNewPassword() throws Exception {
		enterEmailAfterPasswordReset();
		enterPasswordAfterReset();
		signInAfterResetPassword();
		Thread.sleep(3000);
		Assert.assertTrue(reset_password_locators.get_loginSuccessfulMsg().isDisplayed(),
				"Does not logged in successfully");

	}

	public void resetPasswordFunctionalityWithInvalidEmailAddress() throws IOException, InterruptedException {
		clickForgotPassword();
		enterInvalidEmail();
		clickResetPassword();
		Thread.sleep(2000);
		Assert.assertTrue(reset_password_locators.get_warningMsgEmailDoesNotMatch().isDisplayed(),
				"Entered Email is Correct");
	}

	public void resetPasswordEmailLinkSentVerification() throws IOException, InterruptedException {
		clickForgotPassword();
		enterEmail();
		clickResetPassword();
		Thread.sleep(2000);
		Assert.assertTrue(reset_password_locators.get_resetPasswordEmailLinkSentMsg().isDisplayed(),
				"Reset Password Link Has Not Been Sent");
	}

	public void resetPasswordUIElementsOnResetPasswordPagePresentOrNot() throws IOException, InterruptedException {
		Assert.assertTrue(reset_password_locators.get_forgotPasswordLink().isDisplayed(),
				"Forgot Password Link Not Displayed");
		clickForgotPassword();
		Assert.assertTrue(reset_password_locators.get_emailTextBox().isDisplayed(), "Email Text Feild Not Displayed");
		Assert.assertTrue(reset_password_locators.get_resetPasswordBtn().isDisplayed(),
				"Reset Password Button Not Displayed");

	}

	public void resetPasswordFunctionalityWithExpiredResetLink() throws IOException, InterruptedException {
		driver.navigate()
				.to(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "expired_reset_password_link"));
		Thread.sleep(1000);
		Assert.assertTrue(reset_password_locators.get_warningMsgResetPasswordLinkExpired().isDisplayed(),
				"Reset Password Link is Not Expired");
	}

	public void enterEmail() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_emailTextBox(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "ResetPassword_Email_Valid"));
	}

	public void enterInvalidEmail() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_emailTextBox(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "ResetPassword_Email_Invalid"));
	}

	public void clickResetPassword() {
		WebButton.JsclickButton(reset_password_locators.get_resetPasswordBtn(), driver);
	}

	public void signInAfterResetPassword() {
		WebButton.JsclickButton(reset_password_locators.get_signInBtnafterPasswordReset(), driver);
	}

	public void clickForgotPassword() {
		WebButton.JsclickButton(reset_password_locators.get_forgotPasswordLink(), driver);
	}

	public void enterNewPassword() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newPasswordText(), randomValue);
	}

	public void enterConsecutivePassword() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newPasswordText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "ConsecutivePasswordIssue"));
	}

	public void enterNewConfirmPassword() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newConfirmPasswordText(), randomValue);
	}

	public void enterConsecutiveRepeatPassword() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newConfirmPasswordText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "ConsecutivePasswordIssue"));
	}

	public void enterEmailAfterPasswordReset() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_emailTextBox(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "ResetPassword_Email_Valid"));
	}

	public void enterPasswordAfterReset() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newPasswordText(), randomValue);
	}

	public void signInAfterPasswordReset() throws IOException {
		WebButton.JsclickButton(reset_password_locators.get_signInAfterPasswordResettedBtn(), driver);
	}

	public void enterOldPassword() throws IOException {
		WebTextBox.sendInputUpdate(reset_password_locators.get_newPasswordText(),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "OldPassword"));
	}

	public void randomNumberGenerator() {
		Random rand = new Random();
		int randomnum = rand.nextInt(100000 - 100) + 100; // range: 100 to 99999
		randomValue = "AressTest$" + randomnum;
		System.out.println("Random 3-5 digit number: " + randomValue);
		var1 = var2 = randomValue;

	}
}
