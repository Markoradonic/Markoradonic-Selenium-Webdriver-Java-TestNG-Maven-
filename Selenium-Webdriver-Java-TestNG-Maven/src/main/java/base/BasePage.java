package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	private String url;
	private String loginUrl;
	private Properties prop;
	
	public BasePage() throws IOException {
		prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(data);
	}
	
	public WebDriver getDriver() throws IOException {
		if (prop.getProperty("browser").equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} 
		
		return driver;
	}
	
	public String getUrl() throws IOException {
		url = prop.getProperty("url");
		return url;
	}
	
	public String getLoginUrl() throws IOException {
		loginUrl = prop.getProperty("loginUrl");
		return loginUrl;
	}

}
