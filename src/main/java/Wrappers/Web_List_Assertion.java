package Wrappers;



import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Web_List_Assertion {

	public static void suggDropdown(WebDriver driver, List<WebElement> listCon, String expected)
			throws InterruptedException {
		try {
			
			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				String actual = element.getText().trim();
				System.out.println(actual);
				if (element.getText().equalsIgnoreCase(expected)) {
					assertEquals(expected, actual);
			
					break;
				}
			}

		} catch (Exception e) {

			for (WebElement element : listCon) {
				WebWait.visibilityOfElement(driver, element, Duration.ofSeconds(20));
				String actual = element.getText().trim();
				System.out.println(actual);
				if (element.getText().equalsIgnoreCase(expected)) {
					assertEquals(expected, actual);
					break;
				}
			}
		}
	}

}
