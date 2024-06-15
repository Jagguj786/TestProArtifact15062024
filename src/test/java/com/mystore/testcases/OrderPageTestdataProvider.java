package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTestdataProvider extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		LaunchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="getProduct", dataProviderClass=DataProviders.class)
	public void orderPageTest(String productName,String size,String quan) throws InterruptedException {
		
		Log.startTestCase("-----orderPageTest------");
		indexPage = new IndexPage();
		//searchResultPage=indexPage.searchProduct("Printed Chiffon Dress");
		searchResultPage=indexPage.searchProduct(productName);
		addToCartPage=searchResultPage.clcikOnProduct();
		
		//Thread.sleep(5000);
		addToCartPage.enterSize(size);
		//addToCartPage.enterSize("M");
		System.out.println("Test22");
		Thread.sleep(3000);
		addToCartPage.enterQuantity(quan);
		//addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		Thread.sleep(3000);
		System.out.println("123222");
		boolean result=addToCartPage.verifyAfterAddtoCartclick();
		System.out.println(result);
		System.out.println("123333");
		Assert.assertTrue(result);
		orderPage=addToCartPage.clickOntheCheckOut();
		Thread.sleep(5000);
		
//		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),\"Proceed to checkout\")]"));
//		ele.click();
//		Thread.sleep(3000);
//		WebElement ele1=driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
//		ele1.click();
		
		
		System.out.println("0000");
		Thread.sleep(5000);
		Double Uprice = orderPage.getUnitPrice();
		System.out.println(Uprice);
    	Double Tprice = orderPage.getTotalPrice();
		System.out.println(Tprice);
		Double expected=(Uprice*2)+7;
		System.out.println(expected);
		Assert.assertEquals(Tprice, expected);
		
		loginPage=orderPage.clickOnCheckOut();
		Thread.sleep(5000);
		
		Log.endTestCase("-------orderPageTest-------");
		
		
	}
	

}
