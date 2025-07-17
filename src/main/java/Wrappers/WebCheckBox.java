package Wrappers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebCheckBox {
	public static void checkBox_aria(WebElement element) {
		// Check "aria-checked" attribute
		String isCheckedActive = element.getAttribute("aria-checked");
		if (isCheckedActive != null) {
			// If "aria-checked" is present, check its value
			if (isCheckedActive.equals("false")) {
				// If "aria-checked" is false, click on the checkbox
				element.click();
				System.out.println("Checkbox is checked using 'aria-checked'.");
			} else {
				// If "aria-checked" is true, print a message
//	            System.out.println("Checkbox is already checked using 'aria-checked'.");
			}
		} else if (!element.isSelected()) {
			// If "aria-checked" attribute is not present and checkbox is not selected,
			// click on the checkbox
			element.click();
			System.out.println("Checkbox is selected now.");
		} else {
			// If "aria-checked" attribute is not present and checkbox is already selected,
			// print a message
			System.out.println("Checkbox is already selected.");
		}
	}

	public static void checkBoxTest(WebElement element) {

		if (!element.isSelected()) {
			element.click();

		} else {

		}
	}

	public static void selectAllCheckboxes(WebDriver driver, List<WebElement> checkboxes) {
		if (driver == null || checkboxes == null || checkboxes.isEmpty()) {
			throw new IllegalArgumentException("Driver or checkbox list cannot be null or empty");
		}

		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				Actions act = new Actions(driver);
				act.moveToElement(checkbox).click().build().perform();
			}
		}
	}
}