package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTitle() {
		
		String expTitle = indexPage.getMyStoreTitle();
	    String actTitle = "MyStore";
	    //Assert.assertEquals(false, expTitle);
	    Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test
	public void verifyLogo() {
		
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifylink() throws InterruptedException {
		indexPage = new IndexPage();
		indexPage.verifylinkinNewTab();
		
	}

}
