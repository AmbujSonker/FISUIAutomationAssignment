package com.ebay.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.qa.base.TestBase;
import com.ebay.qa.pages.HomePage;
import com.ebay.qa.pages.ItemListingPage;
import com.ebay.qa.pages.ProductPage;
import com.ebay.qa.pages.ShoppingCartPage;

public class AddToCartTest extends TestBase {
	private int itemcount;

	public AddToCartTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		//Initialize WebDriver
		initializeWebDriver();

		// Navigate to eBay
		navigateToURL();	
	}

	@Test
	public void addToCartTest()
	{
		HomePage homepage=new HomePage();

		// Locate the search bar and search for a book
		homepage.BookSearch(prop.getProperty("searcheditem"));

		ItemListingPage itemlistpage= new ItemListingPage();
		itemlistpage.ClickOnFirstLink();
		
		//Add the item to the cart in Product Page
		ProductPage productpage= new ProductPage();
		productpage.AddItemToCart();

		
		// Validate if the item was added to the cart successfully in Shopping Card Page
		ShoppingCartPage cartpage= new ShoppingCartPage(itemcount);
		cartpage.VerifyUpdatedCart();

	}

	@AfterMethod
	public void tearDown()
	{
		CloseBrowser();
		quitBrowser();
	}
}
