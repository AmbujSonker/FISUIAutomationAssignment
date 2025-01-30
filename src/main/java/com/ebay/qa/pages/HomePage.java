package com.ebay.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ebay.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Objects

	private  WebElement inputSearchbar= driver.findElement(By.xpath("//*[@placeholder='Search for anything']"));
	private  WebElement btnSearch= driver.findElement(By.xpath("//*[@id='gh-search-btn']"));
	
	//Page Constructor
	public HomePage()
	{
		super();
	}

	
	//Methods in EBay Home Page
	public ItemListingPage BookSearch(String book)
	{
		inputSearchbar.sendKeys(book);
		btnSearch.click();
		return new ItemListingPage();

	}

}
