package PreTestDataActions;

import static initializer.BaseClass.driver;
import static org.testng.Assert.assertTrue;
import java.util.List;
//import java.awt.List;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;


import PreTestDataLocators.PreDataLocators;

import initializer.BaseClass;

public class PreDataAction extends BaseClass
{
	public WebDriver driver;
	PreDataLocators preDataLocators = null;

	public PreDataAction(WebDriver driver)
	{
		this.driver = driver;
		preDataLocators = new PreDataLocators(driver);
	}
	
	
	
}
