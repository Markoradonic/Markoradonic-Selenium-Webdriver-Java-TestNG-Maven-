package com.marko.app;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.ShopContPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

public class AddAndRemoveItem extends BasePage {

	public AddAndRemoveItem() throws IOException {
		super();
		
	}
	
	@BeforeTest
	public void setup() throws IOException {
		driver = getDriver();
		driver.get(getUrl());
	}
	
	@AfterTest
	public void tearDown () {
		driver.close();
		driver = null;
	}
	
	@Test
	public void addAndRemoveItme () {
		HomePage home = new HomePage(driver);
		home.getTestStoreLink().click();

		ShopHomepage shopHome = new ShopHomepage(driver);
		shopHome.getProdOne().click();

		ShopProductPage shopProd = new ShopProductPage(driver);
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		shopProd.getQuantIncrease().click();
		shopProd.getAddToCartBtn().click();

		ShopContPanel cPanel = new ShopContPanel(driver);
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart cart = new ShoppingCart(driver);
		cart.getDeleteItemTwo().click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));
		
		System.out.println(cart.getTotalAmount().getText());
	}
}
