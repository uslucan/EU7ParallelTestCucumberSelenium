package com.vytrack.step_definitions;


import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        //WebDriver driver = Driver.get();//böyle kullnaırsak diğer methodlarda bu objeyi göremez scope
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }
    @When("the user enters the salesmanager information")
    public void the_user_enters_the_salesmanager_information() {
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user enters the storemanager information")
    public void the_user_enters_the_storemanager_information() {
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String string, String string2) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(string,string2);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        BrowserUtils.waitFor(2);
        //System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        DashboardPage dashboardPage = new DashboardPage();
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        dashboardPage.waitUntilLoaderScreenDisappear();
        String expectedName = userInfo.get("firstname")+" "+userInfo.get("lastname");
        String actualName = dashboardPage.userName.getAttribute("innerText");
       // System.out.println("actualName = " + actualName);
        Assert.assertTrue(actualName.contains(expectedName));
    }

}
