package com.turgayzengin.simplecrm.guitest;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWebTestWithSelenium {
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/jboss/chromedriver.exe");
	}

    @Test
    public void testLogin() {
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://localhost:8080/simplecrm/login.jsf");		
		
    	driver.findElement(By.id("loginForm:username")).sendKeys("admin");
		
    	driver.findElement(By.id("loginForm:password")).sendKeys("admin");
		
    	driver.findElement(By.id("loginForm:login")).click();
					
		WebElement welcomePanelGroup = driver.findElement(By.id("homePageForm:welcome"));
		assertNotNull(welcomePanelGroup);
		
		driver.quit();
    }
}
