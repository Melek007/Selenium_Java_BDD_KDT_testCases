package testSuite01;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	WebDriver driver;
	public LaunchBrowser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public OpenNewTab goToUrl(String url)
	{
		WebDriver driver= new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		OpenNewTab openNewTab=new OpenNewTab(driver);
		return openNewTab;
	}

}
