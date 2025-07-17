package Test.Hcp.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Health_Professional_Locators {

	public WebDriver driver;

	public Login_Health_Professional_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Enable Later']")
	WebElement enableLater_btn;
 
	public WebElement getenableLater_btn() {
		return enableLater_btn;
	}
	
	@FindBy(xpath = "//div[@class='server-error']")
	WebElement error_msg_invalid_password;
 
	public WebElement invalid_Error_msg() {
		return error_msg_invalid_password;
	}
	
	@FindBy(xpath = "//input[@placeholder='First name']")
	WebElement firstname;
 
	public WebElement getfirstname() {
		return firstname;
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Last name']")
	WebElement lastname;
 
	public WebElement getlastname() {
		return lastname;
	}
	
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search_btn;
 
	public WebElement getsearch_btn() {
		return search_btn;
	}
	
	
	@FindBy(xpath = "//span[@class='server-error']")
	WebElement error_msg;
 
	public WebElement geterror_msg() {
		return error_msg;
	}
}
