package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"Smoke","Regression","Sanity"})
	public void loadconfig() {
		System.out.println("----BeforeSuite Method----");
		System.out.println("Before Load Config");
		//Below line is Extent Report Setup
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("After Load Config");
		
	}
	
	
	  public static void LaunchApp() throws InterruptedException {
      //public static void LaunchApp(String browserName) throws InterruptedException {	
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(111);
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			
			System.out.println(222);
			//To run in Chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//To run in Chrome
			System.out.println(333);
			
//		    //To run in Chrome Headless
//			WebDriverManager.chromedriver().setup();
//
//	        // Set ChromeOptions to enable headless mode
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");
//	        options.addArguments("--disable-gpu");
//	        options.addArguments("--window-size=1920,1080");
//	        options.addArguments("--ignore-certificate-errors");
//	        options.addArguments("--disable-extensions");
//	        options.addArguments("--no-sandbox");
//	        options.addArguments("--disable-dev-shm-usage");
//
//	        // Initialize WebDriver with ChromeDriver and ChromeOptions
//	        driver = new ChromeDriver(options);
//	        //To run in Chrome Headless	
			
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	    
	      else if (browserName.equalsIgnoreCase("Edge")) {
		    WebDriverManager.iedriver().setup();
		    driver=new EdgeDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
		//Action.implicitWait(driver, 5);
		
		//Implicit TimeOuts
//		driver.manage().timeouts().implicitlyWait
//		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//		//PageLoad TimeOuts
//		driver.manage().timeouts().pageLoadTimeout
//		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//		//Launching the URL
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
	}
      
      @BeforeTest
      public void beforeTest() {
    	  System.out.println("----BeforeTest Method----");
      }
      
      @BeforeClass
      public void beforeClass() {
    	  System.out.println("----BeforeClass Method----");
      }
      
      @AfterTest
      public void afterTest() {
    	  System.out.println("----AfterTest Method----");
      }
      
      @AfterClass
      public void afterClass() {
    	  System.out.println("----AfterClass Method----");
      }
      
      @AfterSuite(groups = { "Smoke", "Regression","Sanity" })
  	  public void afterSuite() {
    	System.out.println("----AfterSuite Method----");
  		ExtentManager.endReport();
  	}

     
}
