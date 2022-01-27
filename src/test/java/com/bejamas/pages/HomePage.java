package com.bejamas.pages;

import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@mode='primary']")
    public WebElement cookieAcceptButton;

    @FindBy(css = ".anchor_close")
    public WebElement advertisement;

    @FindBy(id="from-station")
    public WebElement departureStation;

    @FindBy(id="to-station")
    public WebElement arrivalStation;

    @FindBy(xpath ="//button[@class='right btn-pkp-reverse']" )
    public WebElement futureDateArrow;

    @FindBy(xpath = "(//span[@class='ico-main-search-2 midpoint pover qhelp'])[1]")
    public WebElement addIntermediateStation;

    @FindBy(id = "wcag-via")
    public WebElement addIntermediateStationField;

    @FindBy(xpath = "(//input[@name='REQ0HafasSearchForw']//following-sibling::ins)[1]")
    public WebElement departure;

    @FindBy(xpath = "(//input[@name='REQ0HafasSearchForw']//following-sibling::ins)[2]")
    public WebElement arrival;

    @FindBy(id = "singlebutton")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@id='disabledTravellersCheckbox']")
    public WebElement disabledCheckBox;

    @FindBy(css = ".row.options-header.accordion-toggle.collapsed")
    public WebElement providerDropdown;

    @FindBy(css = ".first.ac")
    public WebElement uncheckAll;

    public void advertisementClose(){
        BrowserUtils.waitForClickablility(advertisement,5);
        BrowserUtils.clickWithJS(advertisement);
    }

    public void destinations(String from, String to){
        departureStation.sendKeys(from);
        arrivalStation.sendKeys(to);
    }

    public void timeOption(String time){
        if (time.equals("Departure")){
            BrowserUtils.clickWithJS(departure);
        }else if (time.equals("Arrival")){
            BrowserUtils.clickWithJS(arrival);
        }
    }

    public WebElement getOptionFromProvider(String optionName)
    {

        if (optionName.equals("PKP INTERCITY"))
            return Driver.get().findElement(By.id("P1"));
        else if (optionName.equals("POLREGIO"))
            return Driver.get().findElement(By.id("P2"));
        else
            return null;
    }

}
