package com.bejamas.pages;

import com.bejamas.utilities.BrowserUtils;
import com.bejamas.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

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

    @FindBy(xpath = "//button[@mode='primary']")
    public WebElement cookieAcceptButton;

    @FindBy(xpath = "//span[@class='anchor_close']")
    public WebElement advertisement;

    @FindBy(xpath = "//tbody")
    public WebElement verificationTable;

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

    public void verifyResults(){
      if(verificationTable.getAttribute("innerHtml").contains(departureStation.getText())&&
              verificationTable.getAttribute("innerHtml").contains(arrivalStation.getText())){
          System.out.println("Results are matching with searching");
        }
      else {
          System.out.println("Results are not related with search");
      }

    }





}
