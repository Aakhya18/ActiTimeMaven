package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	@FindBy(id = "username")
	private WebElement Unbtx;
	@FindBy(name = "pwd")
	private WebElement pswdbx;
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement logIn;

	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogin(String un, String pw) {

		Unbtx.sendKeys(un);
		pswdbx.sendKeys(pw);
		logIn.click();
	}	

}
