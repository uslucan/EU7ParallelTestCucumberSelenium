package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {
    @When("the user clicks on Fleets,Vehicles")
    public void the_user_clicks_on_Fleets_Vehicles() {
        System.out.println("I clicked on Fleets then Vehicles");
    }

    @Then("the title should be Vehicles")
    public void the_title_should_be_Vehicles() {
        System.out.println("Title is Vehicle");
    }

    @When("the user clicks on Marketing,Campaigns")
    public void the_user_clicks_on_Marketing_Campaigns() {
        System.out.println("I clicked on Marketing_Campaigns");
    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("Title is Campaigns");
    }

    @When("the user clicks on Activitie,Calendar")
    public void the_user_clicks_on_Activitie_Calendar() {
        System.out.println("I clicked on Activities,Calendar");
    }

    @Then("the title should be Calendar")
    public void the_title_should_be_Calendar() {
        System.out.println("Title is Calendar");
    }
    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
       new DashboardPage().navigateToModule(tab,module);
    }
    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum,actualNumber);
    }
}