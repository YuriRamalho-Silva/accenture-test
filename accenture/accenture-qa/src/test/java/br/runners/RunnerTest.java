package br.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "br.steps",
        plugin = {"pretty", "html:target/report-html"})
public class RunnerTest {




}
