package com.ebay.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.utils.TestUtil;

public class TestBase {

	public static  WebDriver driver;
	public static  Properties prop;

	
	public TestBase() {
		init_prop();
	}
	/**
	 * This method is to initialize the properties from config file
	 * 
	 */
	public Properties init_prop()
	{
		try {
			FileInputStream ip= new FileInputStream("./src/main/java/com/ebay/qa/config/config.properties");
			prop = new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	return prop;
	}
	/**
	 * This method is to initialize the Webdriver
	 * 
	 */
	public static void initializeWebDriver() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.driver.chrome", "D:\\Learning\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			 
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.driver.chrome", "D:/Learning/Drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("msedge"))
		{
			System.setProperty("webdriver.driver.chrome", "D:/Learning/Drivers/chromedriver-win64/chromedriver-win64/chromedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	}
	
	/**
	 * This method is to initialize the Webdriver
	 * 
	 */
	public static void navigateToURL() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is to close the Browser
	 * 
	 */
	public static void CloseBrowser() {
		driver.close();
	}
	/**
	 * This method is to close all instance of the Browser
	 * 
	 */
	public static void quitBrowser() {
		 if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	}
	
}
