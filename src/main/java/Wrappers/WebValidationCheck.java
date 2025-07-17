package Wrappers;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebValidationCheck {

	public static void isRequired(WebDriver driver, WebElement targetElement,WebElement targetElement2, WebElement submit, String empty,
			WebElement expectedvalidationSMS, String actualValidationSMS) throws InterruptedException {

		WebTextBox.sendInputUpdate(targetElement, empty);
		Thread.sleep(2000);
		WebButton.clickButton(submit);
		Thread.sleep(2000);
		WebScrollView.scrollIntoView(driver, targetElement2);
		assertEquals(expectedvalidationSMS.getText().trim(), actualValidationSMS);
	}

	public static  void checkAboveMax(WebDriver driver, WebElement targetElement,String aboveMax,WebElement expectedvalidationSMS,
			String actualValidationSMS) throws InterruptedException {

		WebTextBox.sendInputUpdate(targetElement,
				aboveMax);
		Thread.sleep(2000);
		WebScrollView.scrollToElement(driver, expectedvalidationSMS);
		Thread.sleep(2000);
		assertEquals(expectedvalidationSMS.getText().trim(),
				actualValidationSMS);

	}
	
	public static void checkUniqueName(List<WebElement> elements, WebElement targetElement,WebElement expectedvalidationSMS,String actualValidationSMS) {
		
		
		for (int i = 0; i < elements.size(); i++) {
			String DivisionName = elements.get(i).getText().trim();
			System.out.println("Here is division name" + DivisionName );
			WebTextBox.sendInputUpdate(targetElement, DivisionName);
			assertEquals(expectedvalidationSMS.getText().trim(),
					actualValidationSMS);
			
		}
	}


}
