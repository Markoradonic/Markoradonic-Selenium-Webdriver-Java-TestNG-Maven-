package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAccountUser {
	
	public WebDriver driver;
	
	By userEmail = By.cssSelector("section input[name='email']");
	By userPassword = By.cssSelector("input[name='password']");
	By signInButton = By.cssSelector("button#submit-login");
	
	public LoginAccountUser(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserEmail() {
		return driver.findElement(userEmail);
	}

	public WebElement getUserPassword() {
		return driver.findElement(userPassword);
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(signInButton);
	}
	
	
}
