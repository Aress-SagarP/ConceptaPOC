package Wrappers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementCommon {
	public static boolean isPresent(WebElement element) {
		//As a user, I want to check whether element is present in DOM.
		boolean isPre =  false;
		if(element.isDisplayed()) {
			isPre = true;
		}return isPre;
		
	}
	public static boolean isClickable(WebElement element) {
		//As a user, I want to check whether element is clickble or Not
		boolean isclick =  false;
		if(isPresent(element)) {
			if(element.isEnabled()) {
				isclick = true;
			}
		}return isclick;
	}
	public static boolean clearField(WebElement element) {
		//As a user, I want to clear text Box.
		boolean isClear = false;
		if(isPresent(element)) {
			element.clear();
		}return isClear;
	}
	public static boolean isSelected(WebElement element) {
		// As a user, I want to check whether element is selected or not.
		boolean isSelect = false;
		if(isPresent(element)) {
			if(element.isSelected()) {
				isSelect = true;
			}
		}return isSelect;
		
			
	}
	
	public static boolean isVisible(WebDriver driver, WebElement locator) {
        try {
            
            return locator.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
	
	public static boolean isElementPresentAndDisplayed(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        return element.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

}