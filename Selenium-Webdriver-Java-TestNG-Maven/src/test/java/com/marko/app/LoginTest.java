package com.marko.app;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginAccountUser;
import pageObjects.ShopHomepage;
import pageObjects.UserAccountPage;

public class LoginTest extends BasePage {

	public LoginTest() throws IOException {
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
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[2][2];
		
		data[0][0] = "test2@test.com";
		data[0][1] = "test12345";
		
		data[1][0] = "test@test.com";
		data[1][1] = "test123";
		
		return data;
	}
	/*
	 * @Test public void homePage () { HomePage home = new HomePage(driver);
	 * home.getTestStoreLink().click(); System.out.println("clicked to STORE LINK");
	 * }
	 */
	
	@Test(dataProvider = "getData")
	public void loginUser (String email, String pass) throws InterruptedException, IOException {
		driver.get(getLoginUrl());

		
		ShopHomepage shopHomePage = new ShopHomepage(driver);
		shopHomePage.getSignInButton().click();
		
		LoginAccountUser loginUser = new LoginAccountUser(driver);
		loginUser.getUserEmail().sendKeys(email);
		loginUser.getUserPassword().sendKeys(pass);
		loginUser.getSignInButton().click();
		Thread.sleep(2000);
		
		WebElement loginUserTest = driver.findElement(By.cssSelector("[title] .hidden-sm-down"));
		String formsGetText = loginUserTest.getText();
		
		Assert.assertEquals(formsGetText, "test test");
		
		if(driver.getPageSource().contains(formsGetText)) {
			System.out.println("contains " + formsGetText);
		}else {
			System.out.println("does not contain " + formsGetText);
		}
		UserAccountPage userAccount = new UserAccountPage(driver);
		userAccount.getSignOutButton().click();
		Thread.sleep(2000);
	}
	

}
