package com.vikas.framework.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 60);
	}

	public void removeAttribute(WebElement elem, String attributeName) {
		executeJavascript("arguments[0].removeAttribute(\"" + attributeName + "\")", elem);
	}

	public void executeJavascript(String jsToExecute) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jsToExecute);
	}

	public void executeJavascript(String jsToExecute, WebElement e) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(jsToExecute, e);
	}

	public List<WebElement> waitForElement(By locator) {
		return wait.until(ExpectedConditions.numberOfElementsToBe(locator, 2));
	}

	public void waitForElementToBeVisible(WebElement elem) {
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	protected void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
