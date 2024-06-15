package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.SFLoginPage;

public class SFLoginTest extends BaseClass{

	SFLoginPage sfloginpage;
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		
		sfloginpage = new SFLoginPage();
		
		sfloginpage.verifyLoginPage();
		
		
	}
}
