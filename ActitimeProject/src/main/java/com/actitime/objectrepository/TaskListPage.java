package com.actitime.objectrepository;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.generics.WebDriverCommonLib;

public class TaskListPage extends BaseClass {
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement addnewcustomer;
	
	@FindBy(xpath="//input[contains(@class,'inputNameField')]")
	private WebElement customername;
	
	@FindBy(xpath="(//textarea[contains(@class,'textarea')])[9]")
	private WebElement customerdescription;
	
	@FindBy(xpath="(//div[.='- Select Customer -'])[2]")
	private WebElement customerdropdown;
	
	@FindBy(xpath="(//div[@class='searchInputPlaceholder'])[15]/div/div[1]/input")
	private WebElement text;
	
	@FindBy(xpath="//div[@class='searchItemList']/div[.='Our company']") //div[.='gfff' and @class='']
	private WebElement selectourcompany;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustomerbutton;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement verify;
	
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String createCustomer(String cname,String cdescription) throws InterruptedException, EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileLib f= new FileLib();
		WebDriverCommonLib l= new WebDriverCommonLib();
		l.WaitForElement(driver);
		addnew.click();
		addnewcustomer.click();
		customername.sendKeys(cname);
		customerdescription.sendKeys(cdescription);
		customerdropdown.click();
		text.sendKeys("Our");
		selectourcompany.click();
		createcustomerbutton.click();
		l.WaitForElement(driver, verify, "title", f.getPropertyExcel("createCustomer", 1, 5));
		String n=verify.getText();
		return n;
	}
}
