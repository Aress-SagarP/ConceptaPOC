package Test.Tims.Locators_Class;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SH_Locators {
	
	public WebDriver driver;

	public SH_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTxt;

	public WebElement get_emailTxt() {
		return emailTxt;
	}
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTxt;

	public WebElement get_passwordTxt() {
		return passwordTxt;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement get_submitBtn() {
		return submitBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Enable Later')]")
	private WebElement enableLaterBtn;

	public WebElement get_enableLaterBtn() {
		return enableLaterBtn;
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Activate kit')])[2]")
	private WebElement activateShKitBtn;

	public WebElement get_activateShKitBtn() {
	  return activateShKitBtn;
	}	
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement closeBtnOfWarningMsg;

	public WebElement get_closeBtnOfWarningMsg() {
	  return closeBtnOfWarningMsg;
	}
	
	// Tims xPath
	
	@FindBy(xpath = "//button[contains(text(),'Mark kit received')]")
	private WebElement markAsReceivedHeaderMenuBtn;

	public WebElement get_markAsReceivedHeaderMenuBtn() {
	  return markAsReceivedHeaderMenuBtn;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Mark as received')]")
	private WebElement markAsReceivedPopupWindowBtn;

	public WebElement get_markAsReceivedPopupWindowBtn() {
	  return markAsReceivedPopupWindowBtn;
	}
	@FindBy(xpath = "//input[@name='barcode']")
	private WebElement barcodeTxt;

	public WebElement get_barcodeTxt() {
	  return barcodeTxt;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	private WebElement nextBtn;

	public WebElement get_nextBtn() {
	  return nextBtn;
	}
		
	@FindBy(xpath = "//button[contains(text(),'Upload blood result CSV')]")
	private WebElement uploadBloodCsvHeaderMenuBtn;

	public WebElement get_uploadBloodCsvHeaderMenuBtn() {
	  return uploadBloodCsvHeaderMenuBtn;
	}
	
	@FindBy(xpath = "(//input[@name='kit_csv'])[2]")
	private WebElement uploadCsvChooseFileOptionTxt;

	public WebElement get_uploadCsvChooseFileOptionTxt() {
	  return uploadCsvChooseFileOptionTxt;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Upload')]")
	private WebElement uploadBtn;

	public WebElement get_uploadBtn() {
	  return uploadBtn;
	}
	
	@FindBy(xpath = "//table[contains(@class,'dataTable')]//tbody/tr[1]/td[last()]")
	private WebElement kitStatus;

	public WebElement get_kitStatus() {
	  return kitStatus;
	}
	
	@FindBy(xpath = "//table[contains(@class,'dataTable')]//tbody/tr[1]/td[5]")
	private WebElement primaryBarcodeStatus;

	public WebElement get_primaryBarcodeStatus() {
	  return primaryBarcodeStatus;
	}
		
	@FindBy(xpath = "//table[contains(@class,'dataTable')]//tbody/tr[1]/td[9]")
	private WebElement secondaryBarcodeStatus;

	public WebElement get_secondaryBarcodeStatus() {
	  return secondaryBarcodeStatus;
	}
	
	@FindBy(xpath = "//input[@id='searchInput3']")
	private WebElement primaryBarcodeSearchTxt;

	public WebElement get_primaryBarcodeSearchTxt() {
	  return primaryBarcodeSearchTxt;
	}
	
	@FindBy(xpath = "//a[normalize-space()='Test reports']")
	private WebElement testReportSideMenu;

	public WebElement get_testReportSideMenu() {
	  return testReportSideMenu;
	}
	
	@FindBy(xpath = "//h5[contains(text(),'In lab')]")
	private WebElement inLabBtn;

	public WebElement get_inLabBtn() {
	  return inLabBtn;
	}
	
	@FindBy(xpath = "//table[contains(@class,'dataTable')]//tbody/tr[1]/td[3]")
	private WebElement inLabPrimaryBarcode;

	public WebElement get_inLabPrimaryBarcode() {
	  return inLabPrimaryBarcode;
	}
	
	@FindBy(xpath = "//a[@type='button']")
	private WebElement inLabBackBtn;

	public WebElement get_inLabBackBtn() {
	  return inLabBackBtn;
	}
	
	@FindBy(xpath = "//h5[contains(text(),'Ready for review')]")
	private WebElement ReadyForReviewBtn;

	public WebElement get_ReadyForReviewBtn() {
	  return ReadyForReviewBtn;
	}
	
	@FindBy(xpath = "//td[@class='dt-empty']")
	private WebElement ReadyForReviewEmptyData;

	public WebElement get_ReadyForReviewEmptyData() {
	  return ReadyForReviewEmptyData;
	}
}
