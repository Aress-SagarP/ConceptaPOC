
package Wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebButton {

	public static Actions actions;
	
    public static void clickButton(WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            element.click();
         
        } else {
        	
          
        }
    }
    public static void JsclickButton(WebElement element, WebDriver driver) {
        try {
        	WebElementCommon.isClickable(element);
                element.click();
       
        } catch (Exception e) {
        	String javascript = "arguments[0].click()";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(javascript, element);
        }
    }
  
    public static void click_action( WebDriver driver,WebElement element) {
    	actions = new Actions(driver);
    	actions.moveToElement(element).click().build().perform();
//        actions.click(element).build().perform();
    }
}
