package com.vikas.framework.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSuite {

	protected WebDriver driver;

	@AfterMethod
	protected void closeBrowser() {
		driver.close();
	}

	@BeforeMethod
	protected void initBrowser() {
		driver = WebDriverManager.getInstance();
		
	}
}
