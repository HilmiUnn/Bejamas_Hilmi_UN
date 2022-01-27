package com.bejamas.pages;

import com.bejamas.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {


    @FindBy(xpath = "(//span[@class='footable-toggle'])[1]")
    public WebElement expandArrow;

    @FindBy(xpath = "(//div[@class='tab-content tab-content-0'])[2]")
    public WebElement contentTable;

    public void contentVerify(){
        BrowserUtils.waitForClickablility(expandArrow,10);
        expandArrow.click();
        BrowserUtils.waitForVisibility(contentTable,10);
        Assert.assertTrue(contentTable.getAttribute("innerHtml").contains("disabled ") );
    }

}
