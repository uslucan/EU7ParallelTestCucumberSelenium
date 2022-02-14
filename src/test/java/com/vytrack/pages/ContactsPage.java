package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    @FindBy(css=".input-widget")
    public WebElement pageNumber;


    public void clickOnEmail(String email){

        Driver.get().findElement(By.xpath("//td[text()='"+email+"']")).click();
    }

    public WebElement getContactEmail(String email){
        return Driver.get().findElement(By.xpath("//td[text()='"+email+"']"));
    }
}
