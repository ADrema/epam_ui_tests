package com.epam.ui.base;

import com.codeborne.selenide.Configuration;
import com.epam.ui.listeners.AllureAttachmentListener;
import io.qameta.allure.Story;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Story("Implement on Selenide framework in Page Object pattern")
@Listeners({AllureAttachmentListener.class})
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
