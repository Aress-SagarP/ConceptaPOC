package Wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSelectAllClear {
	
	public static void selectAllAndClear(WebDriver driver, WebElement inputField) {
        // Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Execute JavaScript to select all text in the input field
        js.executeScript("arguments[0].select();", inputField);
        
        // Clear the selected text by sending the Delete key
        inputField.sendKeys("\u0008");
    }

}
