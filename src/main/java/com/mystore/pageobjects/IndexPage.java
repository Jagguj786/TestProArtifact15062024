package com.mystore.pageobjects;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='login']") WebElement signInBtn;
	@FindBy(xpath="//img[@class='logo img-responsive']") WebElement myStoreLogo;
	@FindBy(id="search_query_top") WebElement searchProductBox;
	@FindBy(name="submit_search") WebElement searchBtn;
	@FindBy(xpath="//*[contains(text(),\"Ecommerce software by PrestaShop™\")]") WebElement link;
	@FindBy(xpath="//span[contains(text(),\"Marketplace\")]") WebElement link2;
	@FindBy(xpath="//button[contains(text(),\"Create an account\")]") WebElement link3;
	//*[contains(text(),"Ecommerce software by PrestaShop™")]
	//button[contains(text(),"Create an account")]
	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(driver, signInBtn);
		return new LoginPage();
		
	}
	
//	public LoginPage clickOnSignIn() throws Throwable {
//		action.fluentWait(getDriver(), signInBtn, 10);
//		action.click(getDriver(), signInBtn);
//		return new LoginPage();
//	}
	
	public boolean validateLogo() {
		
		return Action.isDisplayed(driver, myStoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		
		String myStoreTitle = Action.getTitle(driver);
	    return myStoreTitle;
		
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(driver, searchBtn);
		return new SearchResultPage();
		
	}
	
	
	public void verifylinkinNewTab() throws InterruptedException {
		
		Thread.sleep(3000);
		Action.click(driver, link);
  		Thread.sleep(7000);
  		System.out.println("11111111111111111111111111111111111");
  		Action.switchToNewWindow(driver);
		Thread.sleep(3000);
		String Url2=driver.getCurrentUrl();
		System.out.println(Url2);
		Action.click(driver, link2);
		Thread.sleep(3000);

//		Action.click(driver, link);
//		Thread.sleep(3000);
//		String Url1=driver.getCurrentUrl();
//		System.out.println(Url1);
//		Action.switchToNewWindow(driver);
//		Thread.sleep(3000);
//		String Url2=driver.getCurrentUrl();
//		System.out.println(Url2);
//		
//		Action.click(driver, link2);
//		String Url3=driver.getCurrentUrl();
//		System.out.println(Url3);
//		Action.switchToNewWindow(driver);
//		Thread.sleep(3000);
//		String Url4=driver.getCurrentUrl();
//		System.out.println(Url4);
//		
//		Action.switchToOldWindow(driver);
//		Thread.sleep(3000);
//		String Url5=driver.getCurrentUrl();
//		System.out.println(Url5);
//		
//		Action.switchToOldWindow(driver);
//		Thread.sleep(3000);
//		String Url6=driver.getCurrentUrl();
//		System.out.println(Url6);
//		
//		String title=Action.getTitle(driver);
//		System.out.println(title);
		
		Set<String> windowHandles = driver.getWindowHandles();

        // Loop through each window handle
        for (String handle : windowHandles) {
            // Switch to the window
            driver.switchTo().window(handle);

            // Get the title of the current window
            String windowTitle = driver.getTitle();
            System.out.println("Window Title: " + windowTitle);
            String url = driver.getCurrentUrl();
            System.out.println(url);
        }
      
        String url5 = driver.getCurrentUrl();
        System.out.println("346356938yr8toifgohjhkjhkj");
        System.out.println(url5);
        System.out.println("93456347777777777777");
      Action.switchWindowByTitle(driver, "My Shop", 1);
      String url6 = driver.getCurrentUrl();
      System.out.println("346356938yr8toifgohjhkjhkj");
      System.out.println(url6);

      Action.click(driver, signInBtn);
      Thread.sleep(5000);
      driver.close();
      Thread.sleep(3000);
      
      System.out.println("-------------------");
      Action.switchWindowByTitle(driver, "PrestaShop Addons Marketplace - Modules, Themes & Support", 2);
      String url7 = driver.getCurrentUrl();
      System.out.println(url7);
      System.out.println("-------------------");
      Action.click(driver, link3);
      Thread.sleep(5000);
      
     // Action.click(driver, signInBtn);
      Thread.sleep(5000);
      driver.close();
      Thread.sleep(5000);
		
}
	
	

}
