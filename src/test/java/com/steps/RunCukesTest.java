package com.steps;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@Cucumber.Options(format = { "pretty", "html:target/cucumber-html-report" },
                    features = "src/test/resources/com/features/",
                    dryRun = false,
                    glue = {"com.steps"}
                    )
@RunWith(Cucumber.class)
public class RunCukesTest {


}
