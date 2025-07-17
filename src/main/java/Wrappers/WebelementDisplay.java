package Wrappers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebelementDisplay {
	
	@SuppressWarnings("deprecation")
	public static boolean waitForElementDisplayed(WebDriver driver, WebElement element) {
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean result = false;
        try {
           
            WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(10));
            result = true;
        } catch (Exception e) {
           
        	System.out.println(element.getText() + " is not displayed");
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        return result;
    }

}
