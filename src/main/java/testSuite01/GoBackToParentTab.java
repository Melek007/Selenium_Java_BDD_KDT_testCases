package testSuite01;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GoBackToParentTab {
	WebDriver driver;
	public GoBackToParentTab(WebDriver driver)
	{
		this.driver=driver;
	}
	public void goBack()
	{
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow=it.next();
		driver.switchTo().window(parentWindow);
	}

}
