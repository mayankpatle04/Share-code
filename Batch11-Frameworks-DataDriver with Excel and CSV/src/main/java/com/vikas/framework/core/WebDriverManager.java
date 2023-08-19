package com.vikas.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
	public static WebDriver getInstance(){
		return getInstance(Config.SELECTED_BROWSER);
	}
	public static WebDriver getInstance(Browser browser){
		WebDriver driver = null;
		System.setProperty(browser.getProName(), browser.getDriverPath());
		switch (browser) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			throw new RuntimeException("Not Implemented yet...");
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser parameter :"+browser);
		}
		return driver;
	}
}
