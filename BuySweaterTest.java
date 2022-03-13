package Zadanie2;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/buy-sweater.feature",
        plugin = {"pretty","html:target/cucumber/report-buy-sweater.html"})

public class BuySweaterTest {
}
