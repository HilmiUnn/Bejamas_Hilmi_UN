package com.bejamas.step_definitions;

import com.bejamas.pages.HomePage;
import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        Driver.get().manage().window().maximize();

        if (scenario.getSourceTagNames().contains("@firefox")) {
            Driver.setDriver("firefox");
        } else if (scenario.getSourceTagNames().contains("@chrome")) {
            Driver.setDriver("chrome");

        }
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        BrowserUtils.waitFor(5);
        Driver.closeDriver();
    }
}
