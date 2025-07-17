package Wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebScrollView {
    
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        String javascript = "arguments[0].scrollIntoView();";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, element);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            // Scroll the element into view
            String javascript = "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });";
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(javascript, element);
            
            // Optionally, you can wait for the page to stabilize after scrolling
            Thread.sleep(500); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElementAndClick(WebDriver driver, WebElement element) {
        scrollToElement(driver, element);
        element.click();
    }

    public static void scrollDownVertically(WebDriver driver) {
        String javascript = "window.scrollTo(0, document.body.scrollHeight);";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);
    }

    public static void scrollUpVertically(WebDriver driver) {
        String javascript = "window.scrollTo(0, -document.body.scrollHeight);";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);
    }

    public static void scrollDownByPixel(WebDriver driver, int pixels) {
        String javascript = "window.scrollBy(0, " + pixels + ");";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);
    }

    public static void scrollUpByPixel(WebDriver driver, int pixels) {
        String javascript = "window.scrollBy(0, -" + pixels + ");";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);
    }

    public static void zoomInByPercentage(WebDriver driver, int percentage) {
        String javascript = "document.body.style.zoom='" + percentage + "%';";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript);
    }

    public static void zoomBy100Percentage(WebDriver driver) {
        zoomInByPercentage(driver, 100);
    }
}
