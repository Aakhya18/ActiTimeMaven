package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	@FindBy(id="container_tasks")
	private WebElement taskbar;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logoutclick()
	{
		logout.click();
	}
	public void taskclick()
	{
		taskbar.click();
	}
	
}
