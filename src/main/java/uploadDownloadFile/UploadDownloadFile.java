package uploadDownloadFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadDownloadFile {
	public static void main(String[] args) throws AWTException, InterruptedException {
		//Test data
		String url="https://altoconvertpdftojpg.com/";
		String filePath="C:\\Users\\melek\\Downloads\\TestPdf.pdf\\";
		
		//Launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Navigate to link
		driver.get(url);
		
		//Upload file
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
	    
	    //Convert file
	    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[1]/i"))));
	    driver.findElement(By.id("submit_btn")).click();
	    
	    //Download file
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.text-primary"))));
	    driver.findElement(By.cssSelector("a.btn.btn-primary.btn-sm")).click();
	}

}
