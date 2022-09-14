package com.marko.app;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContPanel;
import pageObjects.ShopHomepage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

public class OrderTest extends BasePage {

	public OrderTest() throws IOException {
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
	public void allTests () {
		
		HomePage home = new HomePage(driver);
		home.getTestStoreLink().click();
		
		ShopHomepage shopPage = new ShopHomepage(driver);
		shopPage.getProdOne().click();
		
		ShopProductPage productPage = new ShopProductPage(driver);
		Select option = new Select(productPage.getSizeOption());
		option.selectByVisibleText("M");
		productPage.getQuantIncrease().click();
		productPage.getAddToCartBtn().click();
		
		
		ShopContPanel cPanel = new ShopContPanel(driver);
		cPanel.getCheckoutBtn().click();
		
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.getHavePromo().click();
		shoppingCart.getPromoTextbox().sendKeys("20OFF");
		shoppingCart.getPromoAddBtn().click();
		shoppingCart.getProceedCheckoutBtn().click();
		
		OrderFormPersInfo orderformInfo = new OrderFormPersInfo(driver);
		orderformInfo.getGenderMr().click();
		orderformInfo.getFirstNameField().sendKeys("Marko");
		orderformInfo.getLastnameField().sendKeys("Radonic");
		orderformInfo.getEmailField().sendKeys("marko.radonic@test.com");
		orderformInfo.getTermsConditionsCheckbox().click();
		orderformInfo.getContinueBtn().click();
		
		OrderFormDelivery orderFormDelivery = new OrderFormDelivery(driver);
		orderFormDelivery.getAddressField().sendKeys("Zlatiborska");
		orderFormDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderFormDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderFormDelivery.getPostcodeField().sendKeys("77021");
		orderFormDelivery.getContinueBtn().click();
		
		OrderFormShippingMethod shipMethod = new OrderFormShippingMethod(driver);
		shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
		shipMethod.getContinueBtn().click();
		
		OrderFormPayment orderPay = new OrderFormPayment(driver);
		orderPay.getPayByCheckRadioBtn().click();
		orderPay.getTermsConditionsCheckbox().click();
		orderPay.getOrderBtn().click();
		
	}
}
