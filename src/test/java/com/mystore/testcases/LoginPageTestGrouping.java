package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTestGrouping extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		System.out.println("----Before Method----");
		LaunchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		System.out.println("----After Method----");
		driver.quit();
	}
	
	@Test(groups="Smoke",dataProvider="credentials", dataProviderClass=DataProviders.class)
	public void loginTest(String uname, String pswd) throws Exception {
		
		Log.startTestCase("-------loginTest----------");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Thread.sleep(3000);
		Log.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrentURL();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    //Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Success");
	    Log.endTestCase("------loginTest-------");
		
	}

}


