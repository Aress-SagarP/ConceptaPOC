package Wrappers;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebWait {

	public static void visibilityOfElement(WebDriver driver, WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void InvisibilityOfElement(WebDriver driver, WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void elementToBeClickable(WebDriver driver, WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void visibilityListOfElements(WebDriver driver, List<WebElement> elements, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		for (WebElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	public static WebElement fluentWaitForVisibility(WebDriver driver, WebElement element, Duration timeout,
			Duration pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(pollingInterval)
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement fluentWaitForClickability(WebDriver driver, WebElement element, Duration timeout,
			Duration pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(pollingInterval)
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void fluentWaitForVisibilityOfElements(WebDriver driver, List<WebElement> elements, Duration timeout,
			Duration pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(pollingInterval)
				.ignoring(NoSuchElementException.class);

		for (WebElement element : elements) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	public static void elementToinvisible(WebDriver driver, WebElement element, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void ListOfelementsToBeClickable(WebDriver driver, List<WebElement> elements, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		for (WebElement element : elements) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	}
	
	public static void stalenessOfElement(WebDriver driver, WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.stalenessOf(element));
        } catch (StaleElementReferenceException e) {
            // Handle stale element exception if needed
            System.out.println("Element is already stale.");
        }
    }
	
	public static void waitForDOMLoad(WebDriver driver, Duration timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}


}
