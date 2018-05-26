package com.epam.ui.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {
    private long initTime;

    @BeforeSuite
    public void beforeSuite() {
        initTime = System.currentTimeMillis();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test-case execution time " + (System.currentTimeMillis() - initTime));
    }
}
