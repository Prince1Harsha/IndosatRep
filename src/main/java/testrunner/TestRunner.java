package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:\\SH WORK\\IndosatProjectAutomation\\src\\main\\java\\features\\login.feature",
		glue={"E:\\SH WORK\\IndosatProjectAutomation\\src\\main\\java\\com\\enhancesys\\qa\\pages\\ProductPage.java"}
		)
public class TestRunner {

}
