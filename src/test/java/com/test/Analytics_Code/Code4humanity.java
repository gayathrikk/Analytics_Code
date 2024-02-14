package com.test.Analytics_Code;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Code4humanity {
	
	 private RemoteWebDriver driver;
	 private WebDriverWait wait;
	   
		
	 @BeforeTest
	    public void setup() throws MalformedURLException {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.7:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	        
	    }
	 
	 @Test(priority=1)
	 public void launch() throws InterruptedException
	 {
		 driver.get("http://code4humanity.humanbrain.in/annotation/analytics/home");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
	 }
	 
	 @Test(priority=2)
	 public void login() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 30);

	        WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Code']")));
	        if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	            viewerElement.click();
	            System.out.println("code option is clicked");
	        } else {
	            System.out.println("code option is not clickable");
	        }
	        Thread.sleep(2000);
	        

	        // Switch to the iframe 
	        //driver.switchTo().frame(0);
	       
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	    
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("teamsoftware457@gmail.com");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	      
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	        
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Health#123");
	        if (passwordInput.getAttribute("value").equals("Health#123")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	       
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	      
	        System.out.println("************************Login validation done***********************");
	        Thread.sleep(6000);
	 }
	 
	 @Test(priority=3)
	 public void code() throws InterruptedException
	 {
		 Thread.sleep(6000);
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		    driver.switchTo().frame(0);
		    
		    WebElement iconElement = driver.findElement(By.xpath("//div[@class='lm-Widget f1xpzunt']"));

		    String iconValue;
	        if (iconElement.getTagName().equals("img")) {
	            iconValue = iconElement.getAttribute("src");
	        } else {
	            iconValue = iconElement.getAttribute("class");
	        }

	        // Print the value of the icon
	        System.out.println("Icon value: " + iconValue);
//		    
//		     WebElement newButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//jp-button[@title='New Launcher (Ctrl+Shift+L)']")));
//	        if (newButton.isEnabled() && newButton.isDisplayed()) {
//	            newButton.click();
//	            System.out.println("new option is clicked");
//	        } else {
//	            System.out.println("new option is not clickable");
//	        }
//
//	        WebElement notebook = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@class='jp-Launcher-kernelIcon'])[1]")));
//	        if (notebook.isEnabled() && notebook.isDisplayed()) {
//	            notebook.click();
//	            System.out.println("notebook option is clicked");
//	        } else {
//	            System.out.println("notebook option is not clickable");
//	        } 
		    
//		    WebElement newButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='lm-Widget jp-Toolbar-spacer jp-Toolbar-item'])[1]")));
//	        if (newButton.isEnabled() && newButton.isDisplayed()) {
//	           
//	            System.out.println("Toolbar is enabled");
//	        } else {
//	            System.out.println("Toolbar is disabled");
//	        }
	 }
	 
	 @AfterTest
	 public void close()
	 {
		 driver.quit();
	 }

}
