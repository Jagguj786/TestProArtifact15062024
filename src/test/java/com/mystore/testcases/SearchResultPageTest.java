package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addtocartpage;
	
	//@Parameters("browser")
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyProductSearch() {
		
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct("Printed Chiffon Dress");
		boolean result=searchResultPage.productResultDisplayed();
		Assert.assertTrue(result);
		addtocartpage=searchResultPage.clcikOnProduct();
		
		
		
	}
	

}
