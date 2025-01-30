package com.ebay.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.qa.base.TestBase;

import dev.failsafe.internal.util.Assert;

public class ProductPage extends TestBase {
	public String count="";
	public int itemcount=0;

	//Page Objects

	private  WebElement btnAddToCart= driver.findElement(By.xpath("//*[text()='Add to cart']"));
	private  WebElement cartItemsBlank= driver.findElement(By.xpath("//*[@class='gh-cart__icon' and @aria-label='Cart']"));
	private  WebElement cartItems= driver.findElement(By.xpath("//*[@class='badge' or @class='badge hidden']"));

	//Page Constructor
	public ProductPage()
	{
		super();
	}

	//Methods in EBay ItemListing Page
	
	public ShoppingCartPage AddItemToCart()
	{
		if(cartItemsBlank.isDisplayed())
		{
			btnAddToCart.click();
		}
		else 
		{
			count=cartItems.getText();
			itemcount= Integer.parseInt(count);


			// Wait for the "Add to cart" button to appear and click it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
			btnAddToCart.click();
		}
		return new ShoppingCartPage(itemcount);
	}
}
