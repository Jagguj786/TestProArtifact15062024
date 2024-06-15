package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class windowSwitching extends BaseClass{
	
	
	
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
	public void verifylink() throws InterruptedException {
		indexPage = new IndexPage();
		//Below verifylinkinNewTab method has the switch to Window code
		indexPage.verifylinkinNewTab();
		
	} 

}
