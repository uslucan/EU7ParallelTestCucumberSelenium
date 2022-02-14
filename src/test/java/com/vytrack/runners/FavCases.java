package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/fav-cases-reports"
        },
        features = "@src/test/resources/myFavCases.txt",
        glue = "com/vytrack/step_definitions"

)
public class FavCases {
}
