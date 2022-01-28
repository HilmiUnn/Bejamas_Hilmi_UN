package com.bejamas.step_definitions;

import com.bejamas.pages.HomePage;
import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.ConfigurationReader;
import com.bejamas.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


    @Then("the related results appear")
    public void the_related_results_appear() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("queryPageDisplayed=yes"));
    }

    @When("the user enters {string} to VIA station")
    public void the_user_enters_to_VIA_station(String viaStation) {
        homePage.addIntermediateStationField.sendKeys(viaStation);
        BrowserUtils.waitFor(2);                               //to show intermediate station on UI
    }


    @And("the user clicks on Add Intermediate Station icon")
    public void theUserClicksOnAddIntermediateStationIcon() {
        homePage.addIntermediateStation.click();
    }

    @And("the user selects DISABLED TRAVELLERS connection option")
    public void theUserSelectsDISABLEDTRAVELLERSConnectionOption() {
        homePage.disabledCheckBox.sendKeys(Keys.SPACE);
    }

    @And("the user selects Provider dropdown")
    public void theUserSelectsProviderDropdown() {
        homePage.providerDropdown.sendKeys(Keys.ENTER);
    }

    @When("the user select just {string} provider")
    public void the_user_select_just_provider(String providerOption) {
        BrowserUtils.clickWithJS( Driver.get().findElement(By.cssSelector(".first.ac")));
        homePage.getOptionFromProvider(providerOption).sendKeys(Keys.SPACE);
    }

    @And("the user clicks on Search Connection button")
    public void theUserClicksOnSearchConnectionButton() {
        homePage.searchButton.click();
        BrowserUtils.waitFor(2);
    }
}
