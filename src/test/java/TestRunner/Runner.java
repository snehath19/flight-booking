package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features = "src/test/java/features"
            ,glue="stepDefenitions"
            ,monochrome = true,
            plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"}
    )
    public class Runner extends AbstractTestNGCucumberTests {

    }
