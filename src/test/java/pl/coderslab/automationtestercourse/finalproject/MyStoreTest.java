package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features", plugin = {"pretty", "html:out.html"})
public class MyStoreTest {

}
