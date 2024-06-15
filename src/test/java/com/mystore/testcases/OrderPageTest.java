package com.mystore.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class OrderPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void orderPageTest() throws InterruptedException {
		indexPage = new IndexPage();
		searchResultPage=indexPage.searchProduct("Printed Chiffon Dress");
		addToCartPage=searchResultPage.clcikOnProduct();
		
		//Thread.sleep(5000);
		addToCartPage.enterSize("M");
		System.out.println("Test22");
		Thread.sleep(3000);
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCartBtn();
		Thread.sleep(3000);
		System.out.println("123222");
		boolean result=addToCartPage.verifyAfterAddtoCartclick();
		System.out.println(result);
		System.out.println("123333");
		Assert.assertTrue(result);
		//orderPage = addToCartPage.clickOnCheckOut();
		Thread.sleep(3000);
		
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),\"Proceed to checkout\")]"));
		ele.click();
		Thread.sleep(3000);
		WebElement ele1=driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		ele1.click();
//		System.out.println("0000");
//		Thread.sleep(5000);
//		Double Uprice = orderPage.getUnitPrice();
//		System.out.println(Uprice);
//		Double Tprice = orderPage.getTotalPrice();
//		System.out.println(Tprice);
//		Double expected=Uprice*2+7;
//		System.out.println(expected);
//		Assert.assertEquals(Tprice, expected);
//		loginPage=orderPage.clickOnCheckOut();
//		Thread.sleep(3000);
		
		
	}
	

}
