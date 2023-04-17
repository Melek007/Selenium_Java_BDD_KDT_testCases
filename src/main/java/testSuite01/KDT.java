package testSuite01;

import org.openqa.selenium.WebDriver;

public class KDT {
	public static void main(String[] args) {
		//Test Data
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		//Initialize 
		WebDriver driver=null;
		LaunchBrowser launchBrowser= new LaunchBrowser(driver);
		//Script
		OpenNewTab openNewTab=launchBrowser.goToUrl(url);
		GoBackToParentTab window= openNewTab.clickToOpenNewTab();
		window.goBack();
	}

}
