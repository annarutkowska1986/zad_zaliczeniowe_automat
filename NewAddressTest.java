package Zadanie1;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/new-address.feature",
        plugin = {"pretty","html:target/cucumber/report-new-address.html"})

public class NewAddressTest {
}