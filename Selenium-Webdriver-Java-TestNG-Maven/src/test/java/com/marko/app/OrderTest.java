package com.marko.app;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;

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
	}
}
