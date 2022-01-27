package com.bejamas.step_definitions;

import com.bejamas.pages.HomePage;
import com.bejamas.pages.ResultPage;
import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.ConfigurationReader;
import com.bejamas.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;


public class HomePageStepDefs {
    HomePage homePage;

    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
        homePage=new HomePage();

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
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("queryPageDisplayed=yes"));
    }

    @When("the user clicks on {string} icon")
    public void the_user_clicks_on_icon() {
       homePage.addIntermediateStation.click();
    }

    @When("the user enters {string} to VIA station")
    public void the_user_enters_to_VIA_station(String viaStation) {
        homePage.addIntermediateStationField.sendKeys(viaStation);
    }

    @When("the user selects {string} connection option")
    public void the_user_selects_connection_option(String connectionOption) {
     BrowserUtils.clickWithJS(homePage.disabledCheckBox);

    }
    @Then("the related results include option")
    public void the_related_results_include_option() {
        new ResultPage().contentVerify();
    }

    @When("the user selects {string} dropdown")
    public void the_user_selects_dropdown(String string) {
        BrowserUtils.clickWithJS(homePage.providerDropdown);
        BrowserUtils.waitFor(1);
    }

    @When("the user select just {string} provider")
    public void the_user_select_just_provider(String string) {
       homePage.uncheckAll.click();
       BrowserUtils.waitFor(1);
       homePage.pkpIntercity.click();
    }

}
