
package Wrappers;

import org.openqa.selenium.WebElement;
 
 
public class WebTextBox {


	public static void sendInput(WebElement textBox, String text) {

		// This method send text to TextBox

		if(WebElementCommon.isPresent(textBox)) {
				textBox.clear();
				textBox.sendKeys(text);	

		}

	}
	
	public static void sendInputUpdate(WebElement textBox, String text) {
		 
        try {
 
            if (WebElementCommon.isPresent(textBox)) {
                textBox.clear();
                textBox.sendKeys(text);
 
                System.out.println("Input sent successfully: " + text);
 
            } else {
 
                System.out.println("Element not found or not visible. Input not sent.");
 
            }
 
        } catch (Exception e) {
 
            System.out.println("Error occurred while sending input: " + e.getMessage());
 
        }
 
    }

	
	

}
