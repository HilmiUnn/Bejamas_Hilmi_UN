package com.bejamas.pages;

import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.Driver;
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

    @FindBy(className = "add-mid")
    public WebElement addIntermediateStation;

    @FindBy(id = "wcag-via")
    public WebElement addIntermediateStationField;

    @FindBy(id = "odj")
    public WebElement departure;

    @FindBy(id = "prz")
    public WebElement arrival;

    @FindBy(id = "singlebutton")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@id='disabledTravellersCheckbox']")
    public WebElement disabledCheckBox;

    @FindBy(css = "row.options-header.accordion-toggle.collapsed")
    public WebElement providerDropdown;

    @FindBy(className = "first ac")
    public WebElement uncheckAll;

    @FindBy(id = "P1")
    public WebElement pkpIntercity;



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



}
