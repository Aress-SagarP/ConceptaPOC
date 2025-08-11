package Test.Dashboard.Actions_Class;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import PreTestDataLocators.PreDataLocators;
import Test.Dashboard.Locators_Class.Create_Account_Locators;
import Wrappers.ReadGmail;
import Wrappers.WebButton;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.BaseClass;
import initializer.ExtentManager;

public class Create_Account_Actions extends BaseClass {

	public WebDriver driver;
	Create_Account_Locators createAccountLocators = null;

	public Create_Account_Actions(WebDriver driver) {
		this.driver = driver;
		createAccountLocators = new Create_Account_Locators(driver);
	}

	public void dashboardUrl() throws IOException {
		String urlKey = determineUrlKey("dashboard_automation_staging");
		driver.get(urlKey);
	}

	public void createAccount() throws Exception {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "aresssoftwareconceptaautomatio+" + randomGenerator() + "@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountSucessMsg(), Duration.ofSeconds(20));
		Assert.assertTrue(createAccountLocators.get_createAccountSucessMsg().isDisplayed(), "Account not created");
		
	}
	
	public void validateEmailLink() throws Exception
	{
		Thread.sleep(3000);
		ReadGmail read_gmail = new ReadGmail();
		String getCreateAccountLinkFromEmail;
		getCreateAccountLinkFromEmail = read_gmail.getButtonURL("URL_Create_Account");
		Thread.sleep(3000);
		System.out.print(getCreateAccountLinkFromEmail);
		driver.get(getCreateAccountLinkFromEmail);
		Thread.sleep(3000);
		Assert.assertTrue(createAccountLocators.get_emailLinkRedirectionSuccess().isDisplayed(),"Email Link Does Not Redirected To Actual Created Account");
	}

	public void emptyFirstName() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" + randomGenerator() + "@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Without First name account is created");
	}

	public void emptyLastName() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" + randomGenerator() + "@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Without First name account is created");
	}

	public void emptyPassword() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" + randomGenerator() + "@gmail.com");
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Without First name account is created");
	}

	public void emptyEmail() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Without First name account is created");
	}

	public void createAccountWithoutMarketingConsent() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" + randomGenerator() + "@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountSucessMsg(), Duration.ofSeconds(20));
		Assert.assertTrue(createAccountLocators.get_createAccountSucessMsg().isDisplayed(), "Account not created");
	}

	public void checkMandatoryFeilds() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"System does not shown the error for mandatory feilds");

	}

	public void invalidEmailCheck() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "ConcEpta@.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Invalid Email Accepted and created the Account");

	}

	public void invalidPasswordCheck() throws InterruptedException {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "testconcepta3+" + randomGenerator() + "@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Aress@1234");
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		Assert.assertTrue(createAccountLocators.get_mandatoryFeildErrorMsg().isDisplayed(),
				"Invalid Email Accepted and created the Account");

	}
	
	public void alreadyExisitngAccountError() throws InterruptedException
	{
		WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
				Duration.ofSeconds(10));
		WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());
		Thread.sleep(3000);
		WebTextBox.sendInput(createAccountLocators.get_fristNameTxt(), "AressTest");
		WebTextBox.sendInput(createAccountLocators.get_lastNameTxt(), "AressTest" + randomGenerator());
		WebTextBox.sendInput(createAccountLocators.get_emailTxt(), "aresssoftwareconceptaautomatio@gmail.com");
		WebTextBox.sendInput(createAccountLocators.get_passwordTxt(), "Test@" + randomGenerator());
		WebScrollView.scrollToElement(driver, createAccountLocators.get_marketingConsentCheckbox());
		WebButton.clickButton(createAccountLocators.get_createBtn());
		WebWait.visibilityOfElement(driver,createAccountLocators.get_errorMsg(),Duration.ofSeconds(10));
		Assert.assertTrue(createAccountLocators.get_errorMsg().isDisplayed(),
				"Allowed To Create Account Using Already Used Email");
	}
	

	public void verifyAllFieldsDisplayed() {
		try {
			WebWait.visibilityOfElement(driver, createAccountLocators.get_createAccountButtonPageFirst(),
					Duration.ofSeconds(10));
			WebButton.clickButton(createAccountLocators.get_createAccountButtonPageFirst());

			boolean status = createAccountLocators.get_fristNameTxt().isDisplayed()
					&& createAccountLocators.get_lastNameTxt().isDisplayed()
					&& createAccountLocators.get_emailTxt().isDisplayed()
					&& createAccountLocators.get_passwordTxt().isDisplayed()
					&& createAccountLocators.get_marketingConsentCheckbox().isDisplayed()
					&& createAccountLocators.get_createAccountButtonPageSecond().isDisplayed();
			assertTrue(status, "Some fields are missing");
			List<String> labels = new ArrayList<>();
			labels.add(createAccountLocators.get_labelFirstName().getText());
			labels.add(createAccountLocators.get_lableLastName().getText());
			labels.add(createAccountLocators.get_labelEmail().getText());
			labels.add(createAccountLocators.get_labelPassword().getText());
			labels.add(createAccountLocators.get_labelMarketingConsent().getText());
			labels.add(createAccountLocators.get_createAccountButtonPageSecond().getText());
			for (String label : labels) {
				System.out.println("Label: " + label);
			}
			System.out.println("Assertion passed: All fields are displayed");
			ExtentManager.getTest().log(Status.PASS, "All Fields are displayed");
		} catch (Exception e) {
			Assert.fail("Exception: " + e.getMessage());
		}
	}

	/*public int randomGenerator() {
		int randomNumber = new Random().nextInt(100000 - 100) + 100;
		; // Generates a number between 100 and 999
		System.out.println("Generated Random String: " + randomNumber);
		return randomNumber;
	}*/
	
	public int randomGenerator() {
        int randomNumber;
        do {
            randomNumber = new Random().nextInt(100000 - 100) + 100;
        } while (isRepeatingDigits(randomNumber) || isSequentialDigits(randomNumber));

        System.out.println("Generated Random Number: " + randomNumber);
        return randomNumber;
    }

    private boolean isRepeatingDigits(int number) {
        String numStr = String.valueOf(number);
        char firstChar = numStr.charAt(0);
        for (char c : numStr.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true; // All digits are the same
    }

    private boolean isSequentialDigits(int number) {
        String numStr = String.valueOf(number);
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < numStr.length(); i++) {
            int prev = numStr.charAt(i - 1) - '0';
            int curr = numStr.charAt(i) - '0';
            if (curr != prev + 1) ascending = false;
            if (curr != prev - 1) descending = false;
        }

        return ascending || descending;
    }

	public void clickSignUpBtn() {
		createAccountLocators.get_signUpBtn().click();
	}

	public String txtPwdStrength() {
		WebWait.visibilityOfElement(driver, createAccountLocators.get_pwdStrengthWeakh(), Duration.ofSeconds(30));
		System.out.println("Password Strength: " + createAccountLocators.get_pwdStrengthWeakh().getText());
		return createAccountLocators.get_pwdStrengthWeakh().getText();
	}

	
}
