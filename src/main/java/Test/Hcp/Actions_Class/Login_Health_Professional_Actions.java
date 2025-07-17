package Test.Hcp.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;

import Test.Hcp.Locators_Class.Login_Health_Professional_Locators;
import Test.Tims.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebScreenshot;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.ExtentManager;


public class Login_Health_Professional_Actions extends BaseClass {

	public WebDriver driver;
	Login_Locators loginLocators = null;
	Login_Health_Professional_Locators login_health_professional_Locators;
	Login_Health_Professional_Locators login_health_professional_locators = null;
	 private String barcode;

	public Login_Health_Professional_Actions(WebDriver driver) {
		this.driver = driver;
		login_health_professional_Locators = new Login_Health_Professional_Locators(driver);
	}

	public void clickOnEnableLaterBtn() {
		WebWait.elementToBeClickable(driver, login_health_professional_Locators.getenableLater_btn(), Duration.ofSeconds(30));
	//	WebButton.JsclickButton(login_health_professional_Locators.getenableLater_btn(), driver);
		WebButton.clickButton(login_health_professional_Locators.getenableLater_btn());
 
	}
	public void enter_firstname() {
		//TextBox.sendInput(driver, firstname, Enterfirstname);
		WebWait.visibilityOfElement(driver, login_health_professional_Locators.getfirstname(), Duration.ofSeconds(30));
		WebTextBox.sendInput(login_health_professional_Locators.getfirstname(), "saufin");
 
	}
	public void enter_lastname() {
		//TextBox.sendInput(driver, lastname, Enterlastname);
		WebWait.visibilityOfElement(driver, login_health_professional_Locators.getlastname(), Duration.ofSeconds(30));
		WebTextBox.sendInput(login_health_professional_Locators.getlastname(), "s");
 
	}
	public void clickOnsearchBtn() {
	//	WebMouseOperation.moveToElementClick(driver, search_btn);
		WebButton.clickButton(login_health_professional_Locators.getsearch_btn());
 
	}
	 public void getMsg() {
//	        String ab= WebElementUtils.getText(driver, error_msg);
//	        return ab;// Return the text instead of just calling the method
	        
	        WebWait.visibilityOfElement(driver, login_health_professional_Locators.geterror_msg(),Duration.ofSeconds(30));
			String alert_expected = login_health_professional_Locators.geterror_msg().getText().trim();
			System.out.println("Verify-" + alert_expected);
			String Alert = "Please fill in at least 3 fields to submit the form";
			String ActualValue = Alert;
			//Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified");
	        
	   }

	 public void login_HCP() throws IOException, InterruptedException {
			HCP_Url();
			enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
			enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
			clickLoginButton_hcp();
			Thread.sleep(5000);
	 }
	 public void enterEmailID_hcp(String EmailID) {
			// Performing action on Email ID Text Box
		  loginLocators = new Login_Locators(getDriver());
			WebTextBox.sendInputUpdate(loginLocators.getemailAddress_hcp(), EmailID);
			
		}
	 //31
	 public void Account_Creation_Url_Check(String URL)
	 {
		 driver.get(URL);		 
	 }

		public void enterPassword_hcp(String Password) {
			// Performing action on Password Text Box
			loginLocators = new Login_Locators(getDriver());
			WebTextBox.sendInputUpdate(loginLocators.getpassword_hcp(), Password);
		}
		public void clickLoginButton_hcp() {
			// click on login 
			loginLocators = new Login_Locators(getDriver());
			WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn_hcp(), Duration.ofSeconds(30));
			WebButton.clickButton(loginLocators.getLoginBtn_hcp());
			//WebWait.waitForDOMLoad(driver, null);
		}
		
		public void HitAccountGmailURL(String URL)
		{
			Account_Creation_Url_Check(URL);
		}
		
		public void login_HCP_With_Valid_Data() throws IOException, InterruptedException {
			HCP_Url();
			enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
			enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password_hcp"));
			clickLoginButton_hcp();
			String loggedInUrl = driver.getTitle();
			String expectedUrl = "https://hcp-portal-staging.myhealthchecked.com/patient-record";
			Thread.sleep(3000);
			if (loggedInUrl ==expectedUrl)
			{
				System.out.print("Logged in successsfully");
			}
				
					
		}
		
			
		//32
		public void login_HCP_With_Invalid_Data() throws IOException, InterruptedException {
			HCP_Url();
			enterEmailID_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID_hcp"));
			enterPassword_hcp(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Invalid_Password_hcp"));
			clickLoginButton_hcp();
			login_health_professional_locators  = new Login_Health_Professional_Locators(driver);
			Thread.sleep(3000);
			if(login_health_professional_locators.invalid_Error_msg().isDisplayed())
			{
				System.out.print("Error msg is displayed");
			}
			
		}
		 public void HCP_Url() throws IOException {
				// Performing action on URL
			 String urlKey = determineUrlKey("HCP");
			 driver.get(urlKey);
				
			}
		 
		 

	public void verify_hcp_locin() throws InterruptedException {
		clickOnEnableLaterBtn();
		enter_firstname();
		enter_lastname();
		clickOnsearchBtn();
		getMsg();
	
	}

	}	
	