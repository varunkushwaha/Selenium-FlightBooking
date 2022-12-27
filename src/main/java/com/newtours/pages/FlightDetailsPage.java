package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    WebElement passengers;

    @FindBy(name="findFlights")
    WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String noOfPassengers) {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengers));
        Select select = new Select(this.passengers);
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightPage() {
        this.submitBtn.click();

    }


}
