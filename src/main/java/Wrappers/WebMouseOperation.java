package Wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebMouseOperation {

    public static void moveToElement(WebDriver driver, WebElement element) {
        if (WebElementCommon.isVisible(driver, element)) {
            new Actions(driver).moveToElement(element).perform();
        }
    }

    public static void moveToElementClick(WebDriver driver, WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            new Actions(driver).moveToElement(element).click().perform();
        }
    }

    public static void moveToElementDoubleClick(WebDriver driver, WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            new Actions(driver).moveToElement(element).doubleClick().perform();
        }
    }

    // New Method: Right Click (Context Click)
    public static void moveToElementRightClick(WebDriver driver, WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            new Actions(driver).moveToElement(element).contextClick().perform();
        }
    }

    // New Method: Click and Hold
    public static void moveToElementClickAndHold(WebDriver driver, WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            new Actions(driver).moveToElement(element).clickAndHold().perform();
        }
    }

    // New Method: Release (after Click and Hold)
    public static void releaseElement(WebDriver driver, WebElement element) {
        if (WebElementCommon.isClickable(element)) {
            new Actions(driver).release(element).perform();
        }
    }

    // New Method: Drag and Drop
    public static void dragAndDropElement(WebDriver driver, WebElement source, WebElement target) {
        if (WebElementCommon.isClickable(source) && WebElementCommon.isClickable(target)) {
            new Actions(driver).dragAndDrop(source, target).perform();
        }
    }

    // New Method: Drag and Drop by Offset
    public static void dragAndDropByOffset(WebDriver driver, WebElement source, int xOffset, int yOffset) {
        if (WebElementCommon.isClickable(source)) {
            new Actions(driver).dragAndDropBy(source, xOffset, yOffset).perform();
        }
    }
}
