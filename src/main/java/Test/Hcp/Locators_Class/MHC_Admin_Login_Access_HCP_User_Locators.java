package Test.Hcp.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MHC_Admin_Login_Access_HCP_User_Locators {
	public WebDriver driver;

	public MHC_Admin_Login_Access_HCP_User_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Tims
	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtUsername;

	public WebElement getemailAddress() {
		return txtUsername;
	}
	
	
	@FindBy(xpath = "//a[contains(.,'HCP users')]")
	private WebElement hcpUser;

	public WebElement hcpUserLink() {
		return hcpUser;
	}
	
	
	@FindBy(xpath = "//button[contains(.,'Import phlebotomists')]")
	private WebElement importPhlebotomist;

	public WebElement importPhlebotomistButton() {
		return importPhlebotomist;
	}
	
	
	@FindBy(xpath = "//input[contains(@id,'csvFile')]")
	private WebElement uploadcsvPhlebotomist;

	public WebElement uploadCsvSection() {
		return uploadcsvPhlebotomist;
	}
	
	
	@FindBy(xpath = "//button[contains(@id,'upload_csv_for_location')]")
	private WebElement uploadcsvsavebutton;

	public WebElement saveButton() {
		return uploadcsvsavebutton;
	}
	
	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement enable_later;

	public WebElement Enable_Later() {
		return enable_later;
	
	}
	
	@FindBy(xpath = "//td[contains(.,'testconcepta3+6@gmail.com')]")
	private WebElement datauploaded;

	public WebElement dataAdded() {
		return datauploaded;
	}
}
