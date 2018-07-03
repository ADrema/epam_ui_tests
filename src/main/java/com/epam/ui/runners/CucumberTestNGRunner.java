package com.epam.ui.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "src/test/java/com/epam/uitests/homework6", glue = "com.epam.ui.pageObjects")
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        Configuration.browser = "chrome";
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        WebDriverRunner.closeWebDriver();
    }
}
