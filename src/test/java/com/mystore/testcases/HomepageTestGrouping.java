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

public class HomepageTestGrouping extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
//	@BeforeMethod
//	public void setup() throws InterruptedException {
//		LaunchApp(); 
//	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException {
		LaunchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Sanity",dataProvider="credentials", dataProviderClass=DataProviders.class)
	public void orderHistoryandDetailsTest(String Uname,String pswd) throws Exception {
	Thread.sleep(3000);	
	Log.startTestCase("--------orderHistoryandDetailsTest--------");
	indexPage= new IndexPage();
	Log.info("user is going to click on SignIn");
	loginPage=indexPage.clickOnSignIn();
	Thread.sleep(3000);
	Log.info("Enter Username and Password");
	homePage = loginPage.login(Uname,pswd,homePage);
    //homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
    Thread.sleep(3000);
    boolean result= homePage.orderHistory();
    Assert.assertTrue(result);
    Log.endTestCase("--------orderHistoryandDetailsTest--------");

}
}
