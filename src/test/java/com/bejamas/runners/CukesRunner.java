package com.bejamas.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-html-reports",
                  "rerun:target/rerun.txt"
                },
        features = "src/test/resources/features",
        glue = "com/bejamas/step_definitions",
        dryRun=false,
        tags="@TC-8"
)
public class CukesRunner {


}
