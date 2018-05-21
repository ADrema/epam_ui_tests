package com.epam.uitests.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    @Test (testName = "Test1")
    public void SimpleSeleniumTest(){
//        System.setProperties("chromedriver.exe","C:\\Users\\Anastasiia_Dremina\\IdeaProjects\\AnastasiiaDremina\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getTitle(),"Index Page");
        driver.close();
        driver.quit();

    }
}
