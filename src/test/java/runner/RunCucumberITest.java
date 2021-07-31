package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber/site/cucumber-report.html",
                "json:target/cucumber/cucumber.json"
        },
        features = {"src/test/resources/featureFiles"},
        glue = {"stepDefinitions"},
        publish = true
)
public class RunCucumberITest {
}
