package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Locators {
	
	public WebDriver driver;

	public Login_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Tims
	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtUsername;

	public WebElement getemailAddress() {
		return txtUsername;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	public WebElement getpassword() {
		return txtPassword;
	}

	@FindBy(xpath = "//button[@id='loginform']")
	private WebElement btnLogin;

	public WebElement getLoginBtn() {
		return btnLogin;
	}
	
	//HCP
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtUsernamehcp;

	public WebElement getemailAddress_hcp() {
		return txtUsernamehcp;
	}

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPasswordhcp;

	public WebElement getpassword_hcp() {
		return txtPasswordhcp;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLoginhcp;

	public WebElement getLoginBtn_hcp() {
		return btnLoginhcp;
	}
	
	//Dashboard
	@FindBy(xpath = "//input[@name='email']")
	private WebElement inputLoginEmail;
	
	public WebElement get_inputLoginEmail() {
		return inputLoginEmail;
	}
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement inputLoginPassword;
	
	public WebElement get_inputLoginPassword() {
		return inputLoginPassword;
	}
	
}
