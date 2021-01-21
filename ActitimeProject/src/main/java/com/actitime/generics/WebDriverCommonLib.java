package com.actitime.generics;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib{
	public void WaitForElement(WebDriver driver, WebElement element,String attribute,String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));//texttobe
		
	}

	public void WaitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void WaitForElement(WebElement element) {
		int i = 100;
		while (i < 100) {
			try {
				element.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				i++;
			}
		}
	}

}
