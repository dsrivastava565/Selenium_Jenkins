package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"src/main/resources/features/LoginPage.feature"}, glue = {"definition"},
                 plugin = {})
    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}
