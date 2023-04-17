package testSuite01;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/testSuite01", glue = "testSuite01", monochrome = true, plugin = {"html: target/cucumber.html"})
public class CucumberTestNGTestrunner extends AbstractTestNGCucumberTests{

}
