package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {

	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");
	
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signingBtnLocator = By.name("submit");
	By homePageLocator = By.xpath("//h3['Login Successfully']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/"); 
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			driver.findElement(registerBtnLocator).click();
		}
		else {
			System.out.println("Register pages was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualityadmin.",fonts.get(5).getText());
	}
	
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signingBtnLocator).click();
		
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
			
		}
		else {
			System.out.println("User textbox was not present");
		}
	}

}
