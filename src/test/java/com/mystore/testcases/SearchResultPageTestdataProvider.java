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

public class SearchResultPageTestdataProvider extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartpage;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(browser);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="searchProduct", dataProviderClass=DataProviders.class)
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
