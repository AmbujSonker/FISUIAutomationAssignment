package com.ebay.qa.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.base.TestBase;

public class ItemListingPage extends TestBase {
	
	//Page Objects
	private  WebElement lnkfirstbook= driver.findElement(By.xpath("(//*[@class='srp-results srp-list clearfix']//div[@class='s-item__title'])[1]"));
	
	//Page Constructor
	public ItemListingPage()
	{
		super();
	}

	//Methods in EBay ItemListing Page
	public ProductPage ClickOnFirstLink()
	{
			// Wait for search results to load and click the first item
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(lnkfirstbook));
			lnkfirstbook.click();

			// Store the current window handle
			String mainWindow = driver.getWindowHandle();

			// Get all window handles
			Set<String> allWindows = driver.getWindowHandles();

			// Switch to the new window
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(mainWindow)) {
					driver.switchTo().window(windowHandle);

				}
			}
			return new ProductPage();
	
	}
}
