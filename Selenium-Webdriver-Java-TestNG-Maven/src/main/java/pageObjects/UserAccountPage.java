package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAccountPage {

	public WebDriver driver;
	
	By signOutButton = By.cssSelector(".hidden-sm-down.logout");
	
	public UserAccountPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignOutButton () {
		return driver.findElement(signOutButton);
	}
}
