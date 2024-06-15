package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void orderHistoryandDetailsTest() throws Exception {
		
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(3000);
		Log.info("Enter Username and Password");
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
	    Thread.sleep(3000);
	    boolean result= homePage.orderHistory();
	    Assert.assertTrue(result);
	    
	}
	


}
