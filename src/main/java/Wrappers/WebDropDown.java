package Wrappers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDropDown {

	public static void suggDropdown(WebDriver driver, List<WebElement> listCon, String expected)
			throws InterruptedException {
		try {

			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				String string = element.getText().trim();
				System.out.println(string);
				if (element.getText().equalsIgnoreCase(expected)) {
					element.click();
					break;
				}
			}

		} catch (Exception e) {

			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				if (element.getText().equalsIgnoreCase(expected)) {
					element.click();
					break;
				}
			}
		}
	}

	public static void searchAndSelect(WebDriver driver, WebElement searchBox, String searchText) {
		try {
			WebWait.elementToBeClickable(driver, searchBox, Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(searchBox, searchText);

			String text;
			do {
				searchBox.sendKeys(Keys.DOWN);
				text = searchBox.getAttribute("value");
				if (text.equals(searchText)) {
					Thread.sleep(200);
					searchBox.sendKeys(Keys.ENTER);
					break; // Exit the loop after sending ENTER
				}
			} while (!text.isEmpty());
		} catch (Exception e) {
			// Handle exception or log an error
			e.printStackTrace();
		}
	}

	public static void searchAndSelectMatches(WebDriver driver, WebElement searchBox, String searchText) {
		try {
			WebWait.visibilityOfElement(driver, searchBox, Duration.ofSeconds(20));
			WebTextBox.sendInputUpdate(searchBox, searchText);

			searchBox.sendKeys(Keys.DOWN);

			List<WebElement> options = driver.findElements(By.xpath("//ng-dropdown-panel//div[@role='option']"));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(searchText)) {
					option.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void suggDropdownContains(WebDriver driver, List<WebElement> listCon, String expected)
			throws InterruptedException {
		try {

			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				String string = element.getText().trim();
				System.out.println(string);
				if (element.getText().contains(expected)) {
					element.click();
					break;
				}
			}

		} catch (Exception e) {

			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				if (element.getText().equals(expected)) {
					element.click();
					break;
				}
			}
		}
	}

	// select the drop-down using "select by visible text".
//    public static void selectByText(WebDriver driver,WebElement element, String visibleText) {
//        try {
//        	WebWait.elementToBeClickable(driver, element,Duration.ofSeconds(10));
//            Select selObj = new Select(element);
//            selObj.selectByVisibleText(visibleText);
//            // Add logging statement if needed
//        } catch (Exception e) {
//            // Handle exception or log an error
//            e.printStackTrace();
//        }
//    }

	public static void selectByText(WebElement element, String VisibleText) {

		Select selObj = new Select(element);
		selObj.selectByVisibleText(VisibleText);
	}

	// select the drop-down using "select by index".
	public static void selectByIndex(WebElement element, String ddvalue, WebDriver driver) {
		try {
			WebWait.elementToBeClickable(driver, element, Duration.ofSeconds(10));
			Select selObj = new Select(element);
			int value = Integer.parseInt(ddvalue);
			selObj.selectByIndex(value);
			// Add logging statement if needed
		} catch (Exception e) {
			// Handle exception or log an error
			e.printStackTrace();
		}
	}

	// select the drop-down using "select by value".
	public static void selectByValue(WebDriver driver, WebElement element, String value) {
		try {
			WebWait.elementToBeClickable(driver, element, Duration.ofSeconds(10));
			Select selObj = new Select(element);
			selObj.selectByValue(value);
			// Add logging statement if needed
		} catch (Exception e) {
			// Handle exception or log an error
			e.printStackTrace();
		}
	}
	
	public static WebElement getSelectedOption(WebDriver driver, WebElement element) {
		try {
            WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(10));
            Select selObj = new Select(element);
            return selObj.getFirstSelectedOption();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Or throw exception depending on your framework style
        }
    }
	
	 public static List<String> getDropdownOptions(WebDriver driver, WebElement dropdownElement) {
	        Select select = new Select(dropdownElement);
	        List<WebElement> options = select.getOptions();
	        List<String> optionTexts = new ArrayList<>();

	        for (WebElement option : options) {
	            optionTexts.add(option.getText().trim());
	        }

	        return optionTexts;
	    }
}
