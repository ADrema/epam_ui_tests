package com.epam.ui.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseForSelenide {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "CHROME";
        Configuration.screenshots = false;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 2000;
        Configuration.collectionsPollingInterval = 300;

        Configuration.pageLoadStrategy = "normal";
    }

    @AfterSuite
    public void afterSuite() {

    }
}
