package testSuite01;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase01 {
	public static void main(String[] args) {
		//Test Data
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		//launch browser
		WebDriver driver= new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		//Click on open Tab btn
		driver.findElement(By.id("opentab")).click();
		//open new tab and go back
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow=it.next();
		driver.switchTo().window(parentWindow);
	}

}
