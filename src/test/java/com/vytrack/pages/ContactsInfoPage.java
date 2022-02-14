package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfoPage extends BasePage{

    // @FindBy (xpath = "//*[text()='mbrackstone9@example.com']")

    @FindBy(css = ".user-name")
    public WebElement fullName;

    @FindBy (css="a.phone")
    public WebElement phoneNumber;

    @FindBy (css="a.email")
    public WebElement email;

    public String getText(WebElement element){
        return element.getText();
    }
}
