package Wrappers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebRadioButton {
    
    public static void selectRadioButton(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Radio button element cannot be null");
        }

        // Check if the radio button is already selected
        if (!element.isSelected()) {
            element.click();
            System.out.println("Radio button is selected.");
        } else {
            System.out.println("Radio button is already selected.");
        }
    }

    public static void selectRadioButtonByAria(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Radio button element cannot be null");
        }

        // Check "aria-checked" attribute
        String isCheckedActive = element.getAttribute("aria-checked");
        if (isCheckedActive != null) {
            if (isCheckedActive.equals("false")) {
                element.click();
                System.out.println("Radio button is selected using 'aria-checked'.");
            } else {
                System.out.println("Radio button is already selected using 'aria-checked'.");
            }
        } else if (!element.isSelected()) {
            element.click();
            System.out.println("Radio button is selected now.");
        } else {
            System.out.println("Radio button is already selected.");
        }
    }

    public static void selectAllRadioButtons(WebDriver driver, List<WebElement> radioButtons) {
        if (driver == null || radioButtons == null || radioButtons.isEmpty()) {
            throw new IllegalArgumentException("Driver or radio button list cannot be null or empty");
        }

        for (WebElement radioButton : radioButtons) {
            if (!radioButton.isSelected()) {
                Actions act = new Actions(driver);
                act.moveToElement(radioButton).click().build().perform();
            }
        }
    }
}

