package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.objectrepository.EnterTimeTrackPage;
import com.actitime.objectrepository.LogInPage;

public class BaseClass{
	public static WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
	}

	@BeforeClass
	public WebDriver openBrowser() {
		Reporter.log("Open Browser", true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@AfterClass
	public void closeBrowser() {
		Reporter.log("Close Browser", true);
		driver.close();
	}

	@BeforeMethod
	public void logIn() throws IOException {
		Reporter.log("Log In", true);
		FileLib g = new FileLib();
		LogInPage l = new LogInPage(driver);
		String url = g.GetProperty("url");
		driver.get(url);
		l.setLogin(g.GetProperty("username"), g.GetProperty("password"));
		/*
		 * g.GetProperty("username"); g.GetProperty("password");
		 */
		
	}

	@AfterMethod
	public void logOut() {
		Reporter.log("Log Out", true);
		EnterTimeTrackPage l= new EnterTimeTrackPage(driver);
		l.logoutclick();
		//driver.findElement(By.id("logoutLink")).click();
	}
}
