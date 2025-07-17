package Wrappers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebZoom {
	
	public static void zoomOut(WebDriver driver) {
	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    jsExecutor.executeScript("document.body.style.zoom='65%'");
	}

}
