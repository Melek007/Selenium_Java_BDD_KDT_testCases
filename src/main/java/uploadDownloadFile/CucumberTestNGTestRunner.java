package uploadDownloadFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/uploadDownloadFile", glue = "uploadDownloadFile", monochrome = true, plugin = {"html: target/cucumber.html"})
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests{

}
