package com.ebay.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ebay.qa.base.TestBase;

public class ShoppingCartPage extends TestBase {
	private int itemcount;
	//Page Objects
	private  WebElement cartItems= driver.findElement(By.xpath("//*[@class='badge' or @class='badge hidden']"));

	//Page Constructor
	public ShoppingCartPage(int itemcount)
	{
		super();
		this.itemcount=itemcount;
	}


	public void  VerifyUpdatedCart()
	{
		String count=cartItems.getText();
		if(count.equals("1"))
		{
			System.out.println("Test Passed: Item successfully added to the cart!");
		}

		else 
		{
			//verify the updated count
			String countupdated=cartItems.getText();
			int itemcountupdated= Integer.parseInt(countupdated);
			if(itemcountupdated==(itemcount+1))
			{
				System.out.println("Test Passed: Item successfully added to the cart!");
			}else {
				System.out.println("Test Failed: Item not added to the cart.");
			}
		}
	}

}
