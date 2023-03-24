package uploadDownloadFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver=null;
	
	@Given("I Launch browser")
	public void I_Launch_browser()
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@And("^I Navigate to (.+)$")
	public void I_Navigate_to_url(String url)
	{
		driver.get(url);
	}
	
	@When("^I Upload (.+)$")
	public void I_Upload_filePath(String filePath) throws InterruptedException, AWTException
	{
		driver.findElement(By.id("browse")).click();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@And("I Convert file")
	public void I_Convert_file()
	{
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[1]/i"))));
		 driver.findElement(By.id("submit_btn")).click();
	}
	
	@Then("I Download file")
	public void I_Download_file()
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.text-primary"))));
	    driver.findElement(By.cssSelector("a.btn.btn-primary.btn-sm")).click();
	}

}
