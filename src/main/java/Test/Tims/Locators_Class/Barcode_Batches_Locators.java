package Test.Tims.Locators_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Barcode_Batches_Locators {

	public WebDriver driver;
	
	public Barcode_Batches_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel'][text()='Create blood batch']")
	private WebElement createBloodBatchWindow;
	
	public WebElement get_createBloodBatchWindow() {
		return createBloodBatchWindow;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//p[contains(text(),'How many barcodes')]")
	private WebElement howManyBarcodesHelpTxt;
	
	public WebElement get_howManyBarcodesHelpTxt() {
		return howManyBarcodesHelpTxt;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//textarea[@id='comment']")
	private WebElement commentFieldTxt;
	
	public WebElement get_commentFieldTxt() {
		return commentFieldTxt;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='btype']/following-sibling::div[@id='btype_error']")
	private WebElement typeDrpErrorMsg;
	
	public WebElement get_typeDrpErrorMsg() {
		return typeDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='sub_type']/following-sibling::div[@id='sub_type_error']")
	private WebElement subtypeDrpErrorMsg;
	
	public WebElement get_subtypeDrpErrorMsg() {
		return subtypeDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//label[@for='barcode_count']/following-sibling::div[@id='barcode_count_error']")
	private WebElement countDrpErrorMsg;
	
	public WebElement get_countDrpErrorMsg() {
		return countDrpErrorMsg;
	}
	
	@FindBy(xpath ="//form[@id='add_blood_form']//button[@type='button'][normalize-space()='Cancel']")
	private WebElement createBloodBatchCancelBtn;
	
	public WebElement get_createBloodBatchCancelBtn() {
		return createBloodBatchCancelBtn;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel' and text()='Create blood batch']")
	private WebElement createBloodBatchTitleTxt;
	
	public WebElement get_createBloodBatchTitleTxt() {
		return createBloodBatchTitleTxt;
	}
	
	@FindBy(xpath ="//div[@class='toast-body']//p")
	private WebElement toasterAlert;
	
	public WebElement get_toasterAlert() {
		return toasterAlert;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Create DNA batch']")
	private WebElement createDNABatchBtn;
	
	public WebElement get_createDNABatchBtn() {
		return createDNABatchBtn;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel'][text()='Create DNA batch']")
	private WebElement createDNABatchForm;
	
	public WebElement get_createDNABatchForm() {
		return createDNABatchForm;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//select[@id='btype']")
	private WebElement createDNABatchTypeDrp;
	
	public WebElement get_createDNABatchTypeDrp() {
		return createDNABatchTypeDrp;
	}
	
	@FindBy(xpath ="//input[@id='sub_type']")
	private WebElement createDNABatchSubTypeDrp;
	
	public WebElement get_createDNABatchSubTypeDrp() {
		return createDNABatchSubTypeDrp;
	}
	
	@FindBy(xpath = "//form[@id='add_wellness_form']//input[@id='barcode_count']") // 2
	private WebElement barcodeCountTxtDNA;

	public WebElement get_barcodeCountTxtDNA() {
		return barcodeCountTxtDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//p[contains(text(),'How many barcodes')]")
	private WebElement howManyBarcodesHelpTxtDNA;
	
	public WebElement get_howManyBarcodesHelpTxtDNA() {
		return howManyBarcodesHelpTxtDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//label[@for='barcode_count']/following-sibling::div[@id='barcode_count_error']")
	private WebElement countDrpErrorMsgDNA;
	
	public WebElement get_countDrpErrorMsgDNA() {
		return countDrpErrorMsgDNA;
	}
	
	@FindBy(xpath ="//form[@id='add_wellness_form']//select[@id='customer']")
	private WebElement createDNABatchCustDrp;
	
	public WebElement get_createDNABatchCustDrp() {
		return createDNABatchCustDrp;
	}
	
	@FindBy(xpath ="//h5[@id='addlocationsModalLabel' and text()='Create DNA batch']")
	private WebElement createDNABatchTitleTxt;
	
	public WebElement get_createDNABatchTitleTxt() {
		return createDNABatchTitleTxt;
	}
	
	
	
}
