package com.epam.ui.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/com/epam/uitests/homework6", glue = "com.epam.ui.pageObjects")
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }

    @AfterTest
    public void afterTest(){

    }
}
