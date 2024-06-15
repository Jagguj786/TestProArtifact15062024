package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	PaymentPage paymentPage;
	ShippingPage shippingPage;
	AddressPage addressPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void endToEndTest() throws Exception {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
	    homePage.ValidateHomePageAfterLogin();
	    searchResultPage=homePage.searchProduct("Printed Chiffon Dress");
	    addToCartPage=searchResultPage.clcikOnProduct();
	    Thread.sleep(3000);
	    addToCartPage.enterSize("M");
	    addToCartPage.enterQuantity("2");
	    addToCartPage.clickOnAddToCartBtn();
	    orderPage=addToCartPage.clickOntheCheckOut();
	    addressPage=orderPage.clickOnCheckOut1();
	    shippingPage=addressPage.clickOnChectOut();
	    shippingPage.clickonTerms();
	    paymentPage=shippingPage.clcikOnProceedToCheckoutBtn();
	    orderSummaryPage=paymentPage.clickOnPaymentMethod();
	    orderConfirmationPage=orderSummaryPage.clickOnConfirmOrderBtn();
	    String msg=orderConfirmationPage.getConfirmMessage();
	    System.out.println(msg);
	    orderConfirmationPage.validateConfirmMsg();
	    Thread.sleep(3000);
	    
	}
}
