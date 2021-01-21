package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.generics.WebDriverCommonLib;
import com.actitime.objectrepository.EnterTimeTrackPage;
import com.actitime.objectrepository.LogInPage;
import com.actitime.objectrepository.TaskListPage;

@Listeners(com.actitime.generics.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public static void createCustomer() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		/*
		 * WebDriverCommonLib l1 = new WebDriverCommonLib(); l1.WaitForElement(driver);
		 */
		
		FileLib g = new FileLib();
		
		EnterTimeTrackPage e= new EnterTimeTrackPage(driver);
		e.taskclick();
		
		TaskListPage t = new TaskListPage(driver);
		String cn = g.getPropertyExcel("createCustomer", 1, 5);
		String cd = g.getPropertyExcel("createCustomer", 1, 6);
		String n = t.createCustomer(cn, cd);
		System.out.println(cn +" original");
		System.out.println(n +" not original");
		Assert.assertEquals(n, cn);
		if (n.equals(cn)) {
			g.SetPropertyExcel("pass", "createCustomer", 1, 7);
		} else {
			g.SetPropertyExcel("fail", "createCustomer", 1, 7);
		}
	}

}
