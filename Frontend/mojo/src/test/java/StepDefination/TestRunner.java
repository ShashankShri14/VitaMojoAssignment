package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefination"},
monochrome = true,
plugin={"pretty", "html:target/HtmlReports/Report.html"}
		)
public class TestRunner {

	
}
