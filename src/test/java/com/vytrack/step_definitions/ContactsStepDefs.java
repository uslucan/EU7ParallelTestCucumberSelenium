package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactsStepDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        String username=null;
        String password = null;

        if(userType.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        } else if(userType.equals("sales manager")){
            username=ConfigurationReader.get("salesmanager_username");
            password=ConfigurationReader.get("salesmanager_password");
        } else if(userType.equals("store manager")){
            username=ConfigurationReader.get("storemanager_username");
            password=ConfigurationReader.get("storemanager_password");
        }
        new LoginPage().login(username,password);
    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        List<String> actualMenuOptions = new ArrayList<>();
        for (WebElement options : dashboardPage.menuOptions) {
            actualMenuOptions.add(options.getText());
        }
        Assert.assertEquals("verify lists are equals",menuOptions,actualMenuOptions);
    }

}
