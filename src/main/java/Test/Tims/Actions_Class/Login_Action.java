package Test.Tims.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import Test.Tims.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Login_Action extends BaseClass {

	public WebDriver driver;
	Login_Locators loginLocators = null;
	Login_Boot_Actions login_boot_actions;

	public Login_Action(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Login_Locators(driver);
	}

	// Tims
	public void Tims_staging_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("Tims_staging");
		driver.get(urlKey);

	}
	
	public void Tims_dev_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("Tims_dev");
		driver.get(urlKey);

	}

	public void enterEmailID(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(loginLocators.getemailAddress(), EmailID);

	}

	public void enterPassword(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(loginLocators.getpassword(), Password);
	}

	public void clickLoginButton() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn());
		// WebWait.waitForDOMLoad(driver, null);
	}

	// HCP
	public void HCP_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("HCP");
		driver.get(urlKey);

	}
	// HCP_staging
	public void HCP_staging_Url() throws IOException {
		// Performing action on URL
		String urlKey = determineUrlKey("HCP_staging");
		driver.get(urlKey);

	}

	public void enterEmailID_hcp(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(loginLocators.getemailAddress_hcp(), EmailID);

	}

	public void enterPassword_hcp(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(loginLocators.getpassword_hcp(), Password);
	}
	
	//Dashboard Staging
	public void enterEmailID_DB(String EmailID) {
		WebTextBox.sendInputUpdate(loginLocators.get_inputLoginEmail(), EmailID);
	}
	
	public void enterPassword_DB(String EmailID) {
		WebTextBox.sendInputUpdate(loginLocators.get_inputLoginPassword(), EmailID);
	}
	

	public void clickLoginButton_hcp() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		// WebWait.waitForDOMLoad(driver, null);
	}

	public void login_Tims_Staging() throws IOException {
		Tims_staging_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_staging"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_staging"));
		clickLoginButton();

	}

	public void login_Tims_dev() throws IOException {
		Tims_dev_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_dev"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_dev"));
		clickLoginButton();

	}

	public void login_HCP() throws IOException {
		HCP_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
		clickLoginButton_hcp();

	}
	
	public void login_staging_HCP() throws IOException {
		HCP_staging_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp_staging"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp_staging"));
		clickLoginButton_hcp();

	}

	public void Dashboard_Url() throws IOException {
		String urlKey = determineUrlKey("dashboard_staging");
		driver.get(urlKey);
	}

	public void login_Dashboard() throws IOException {
		Dashboard_Url();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_dashboard"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_dashboard"));
		clickLoginButton_Dashboard();
	}
	
	public void login_Dashboard2() {
		try {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Email"));
		enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
		clickLoginButton_Dashboard();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public void navToDashboard() {
		try {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	public void login_Tims_For_HCP() throws IOException, InterruptedException {
		Tims_staging_Url();
		enterEmailID(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_tims_for_hcp"));
		enterPassword(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_tims_for_hcp"));
		clickLoginButton();
		// clickOn_Enable_Later();

	}

	public void clickLoginButton_Dashboard() {
		// click on login
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn_hcp());
		// WebWait.waitForDOMLoad(driver, null);

	}
	
	public void login_dashboard_staging() throws IOException {
		try {
			String urlKey = determineUrlKey("dashboard_automation_staging");
			driver.get(urlKey);
			enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Email"));
			enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Dashboard_Password"));
			clickLoginButton_Dashboard();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public void navToStagingDashboard() {
		try {
			String urlKey = determineUrlKey("dashboard_automation_staging");
			driver.get(urlKey);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
