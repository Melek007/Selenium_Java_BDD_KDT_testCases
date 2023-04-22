package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script {
	public static void main(String[] args) {
		//Test Data
		String url="https://rahulshettyacademy.com/client";
		String firstName="User";
		String lastName="Test";
		String userEmail="user3.test@gmail.com";
		String userMobile= "1612345678";
		String occupation="Student";
		String userPassword="1234@User5678";
		//launch
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		//click to register
		driver.findElement(By.cssSelector("p.login-wrapper-footer-text")).click();
		//fill details
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(userEmail);
		driver.findElement(By.id("userMobile")).sendKeys(userMobile);
		WebElement dropDownElement= driver.findElement(By.cssSelector("select[class='custom-select ng-untouched ng-pristine ng-valid']"));
		Select options=new Select(dropDownElement);
		options.selectByVisibleText(occupation);
		driver.findElement(By.xpath("//span[.='Male']")).click();
		driver.findElement(By.id("userPassword")).sendKeys(userPassword);
		driver.findElement(By.id("confirmPassword")).sendKeys(userPassword);
		WebElement checkBoxElement= driver.findElement(By.xpath("//div/input[@type='checkbox']"));
		if(!checkBoxElement.isSelected())
		{
			checkBoxElement.click();
		}
		//click Register
		driver.findElement(By.id("login")).click();
		//verify 
		if (driver.findElement(By.xpath("//div/h1")).isDisplayed())
		{
			System.out.print("Register OK");
		}
	}
}
