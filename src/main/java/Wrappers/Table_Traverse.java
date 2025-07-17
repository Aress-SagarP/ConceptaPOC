package Wrappers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Table_Traverse {
	
	public WebDriver driver;

	public Table_Traverse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static int getColoumnName(List<WebElement> tableHeader, String coloumnTitle) {
		int i;
		int j = 0;
		for (i = 0; i < tableHeader.size(); i++) {
			if (tableHeader.get(i).getText().equalsIgnoreCase(coloumnTitle)) {
				j = i + 1;
				break;
			
			}
		
		}
		return j;

	}
}
