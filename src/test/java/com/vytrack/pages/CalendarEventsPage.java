package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//*[@class='btn btn-link dropdown-toggle']")
    public WebElement Options;

    @FindBy(css = "ul.icons-holder li input")
    public WebElement pageNumber;

    @FindBy(css = "div.btn-group button")
    public WebElement viewPerPageNum;

    @FindBy(xpath = "//*[@data-size='100']")
    public WebElement viewPerPage100;

    @FindBy(css = ".dib:nth-of-type(3)")
    public WebElement numOfTotalRecords;

    @FindBy (css = ".dropdown-toggle>input[type='checkbox']")
    public WebElement checkAll;

    @FindBy(css = ".responsive-block")
    public WebElement generalInfoOfEvent;

    public int getTotalRecordNumFromHTML() {
        viewPerPageNum.click();
        viewPerPage100.click();
        BrowserUtils.waitFor(1);
        return Driver.get().findElements(By.xpath("//table/tbody/tr")).size();
    }

    public int getTotalRecordNumFromScreen(){
       return Integer.parseInt(numOfTotalRecords.getText().split(" ")[2]);
    }

    public int numberOfSelectedRows(){
        return Driver.get().findElements(By.cssSelector("tr[class*='row-selected']")).size();
    }
    public void clickWthVisibleText(String text){
       Driver.get().findElement(By.xpath("//*[.='"+text+"']")).click();
    }

}