package testSuite01;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver=null;
	@Given("^I launch browser (.+)$")
	public void I_launch_browser(String url)
	{
		driver= new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	@When("I click on open Tab btn")
	public void I_click_on_open_Tab_btn()
	{
		driver.findElement(By.id("opentab")).click();
	}
	@Then("I open new tab and go back")
	public void I_open_new_tab_and_go_back()
	{
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow=it.next();
		driver.switchTo().window(parentWindow);
	}

}
