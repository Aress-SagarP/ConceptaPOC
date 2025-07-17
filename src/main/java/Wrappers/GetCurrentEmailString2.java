package Wrappers;

import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.Tims.Locators_Class.Login_Locators;
import initializer.BaseClass;

public class GetCurrentEmailString2 extends BaseClass{
	public static WebDriver driver;

	public GetCurrentEmailString2(WebDriver driver) {
		this.driver = driver;
		
	}
	  public static String getVerificationLink(String email) {
	        try {
	            // Mailinator API (Example)
	            String inboxUrl = "https://www.mailinator.com/v3/index.jsp?zone=public&query=" + email.split("@")[0];
	            driver = new ChromeDriver();
	            driver.get(inboxUrl);
	            //WebDriver driver = new ChromeDriver();
	            
	            
	            Thread.sleep(5000);  // Wait for emails to load
	            
	            // Open the first email
	            List<WebElement> emails = driver.findElements(By.cssSelector(".inbox-row-subject"));
	            if (!emails.isEmpty()) {
	                emails.get(0).click();  // Open the first email
	                Thread.sleep(3000);
	                
	                // Extract email body
	                WebElement emailBody = driver.findElement(By.cssSelector(".email-body"));
	                String emailContent = emailBody.getText();
	                
	                // Extract the verification link using regex
	                Pattern linkPattern = Pattern.compile("https://example.com/verify\\?token=[a-zA-Z0-9]+");
	                Matcher matcher = linkPattern.matcher(emailContent);
	                
	                if (matcher.find()) {
	                    String verificationLink = matcher.group();
	                    driver.quit();
	                    return verificationLink;
	                }
	            }
	            driver.quit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}

