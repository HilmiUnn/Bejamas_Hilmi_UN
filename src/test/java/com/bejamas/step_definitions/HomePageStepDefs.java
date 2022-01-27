package com.bejamas.step_definitions;

import com.bejamas.pages.HomePage;
import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.ConfigurationReader;
import com.bejamas.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class HomePageStepDefs {
    HomePage homePage=new HomePage();
    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);

        BrowserUtils.waitForClickablility(homePage.cookieAcceptButton,10);
        homePage.cookieAcceptButton.click();

        homePage.advertisementClose();
    }

    @When("the user enters the following destination and arrival stations")
    public void the_user_enters_the_following_destination_and_arrival_stations(Map<String,String> stations) {
        new HomePage().destinations(stations.get("From"),stations.get("To"));

    }

    @When("the user selects any date in the future")
    public void the_user_selects_any_date_in_the_future() {
       BrowserUtils.clickWithJS(homePage.futureDateArrow);
    }

    @When("the user selects {string} option")
    public void the_user_selects_option(String time) {
      homePage.timeOption(time);
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String searchButton) {
      homePage.searchButton.click();
    }

    @Then("the related results appear")
    public void the_related_results_appear() {
    //    homePage.advertisementClose();
        homePage.verifyResults();
    }
    @When("the user clicks on {string} icon")
    public void the_user_clicks_on_icon(String string) {
       homePage.addIntermediateStation.click();
    }

    @When("the user enters {string} to VIA station")
    public void the_user_enters_to_VIA_station(String vıaStation) {
        homePage.addIntermediateStationField.sendKeys(vıaStation);
    }

}
