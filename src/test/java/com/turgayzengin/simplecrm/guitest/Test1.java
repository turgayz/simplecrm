package com.turgayzengin.simplecrm.guitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:/jboss/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {
		driver.get(baseUrl + "/simplecrm/login.jsf");
		driver.findElement(By.id("loginForm:username")).clear();
		driver.findElement(By.id("loginForm:username")).sendKeys("admin");
		driver.findElement(By.id("loginForm:password")).clear();
		driver.findElement(By.id("loginForm:password")).sendKeys("admin");
		driver.findElement(By.id("loginForm:login")).click();
		try {
			assertEquals("Welcome", driver.findElement(By.cssSelector("li")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
