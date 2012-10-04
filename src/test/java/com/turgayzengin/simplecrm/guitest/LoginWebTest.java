package com.turgayzengin.simplecrm.guitest;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Arquillian.class)
public class LoginWebTest {		
	
	@Drone
	private ChromeDriver driver;
	
	@ArquillianResource
	private URL deploymentUrl;
		
	@Deployment(testable=false)
	public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        		.addPackage("com.turgayzengin.simplecrm.dao")
				.addPackage("com.turgayzengin.simplecrm.model")
				.addPackage("com.turgayzengin.simplecrm.service")
				.addPackage("com.turgayzengin.simplecrm.web")
				.addPackage("com.turgayzengin.simplecrm.util")
                .addAsWebResource(new File("src/main/webapp/login.xhtml"))
                .addAsWebResource(new File("src/main/webapp/home.xhtml"))                
                .addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml").addAsResource("log4j.xml")
				.addAsResource("import.sql")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF", "faces-config.xml"));
	}
	
	@Test
	public void should_login_successfullly() {
		driver.get(deploymentUrl + "login.jsf");		
		
		driver.findElement(By.id("loginForm:username")).sendKeys("admin");
		
		driver.findElement(By.id("loginForm:password")).sendKeys("admin");
		
		driver.findElement(By.id("loginForm:login")).click();
					
		WebElement welcomePanelGroup = driver.findElement(By.id("homePageForm:welcome"));
		assertNotNull(welcomePanelGroup);
	}
			
}
