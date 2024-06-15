package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTestxml extends BaseClass{
IndexPage indexPage;



    @Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException  {
		
		System.out.println("Before Method");
		LaunchApp(browser);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTitle() {
		
		Log.startTestCase("------verifyTitle------");
		String expTitle = indexPage.getMyStoreTitle();
	    String actTitle = "My Shop";
	    //Assert.assertEquals(false, expTitle);
	    Assert.assertEquals(expTitle, actTitle);
	    Log.endTestCase("------verifyTitle------");
	}
	
	@Test
	public void verifyLogo() {
		
		Log.startTestCase("------verifyLogo------");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("------verifyLogo------");
	}

}
