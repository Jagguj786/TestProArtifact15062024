package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTestGrouping extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartpage;
	
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
	
	@Test(groups = "Smoke",dataProvider="searchProduct", dataProviderClass=DataProviders.class)
	public void verifyProductSearch(String productName) {
		Log.startTestCase("-------verifyProductSearch--------");
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct(productName);
		boolean result=searchResultPage.productResultDisplayed();
		Assert.assertTrue(result);
		addtocartpage=searchResultPage.clcikOnProduct();
		Log.endTestCase("-------verifyProductSearch-------");
		
	}
}