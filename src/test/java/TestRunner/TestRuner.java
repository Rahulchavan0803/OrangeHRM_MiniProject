package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
				(
						features=".//Features/Login.feature",
						glue="StepDefinations",
						//tags = "@DeleteEmployee",
						dryRun=false,
						monochrome = true,
						plugin = {"pretty","html:target/cucumber-reports.html","html:target/cucumber-reports.html",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
						
						)
public class TestRuner {
	
}
