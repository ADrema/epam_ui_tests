package com.epam.uitests.homework2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestTextUsingDataProvider {

    private ChromeOptions options;
    private List<String> textContent = Arrays.asList(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"
    );

    @BeforeClass
    public void beforeClass() {
        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @DataProvider(parallel = true)
    public Object[][] textElementsProvider() {
        return new Object[][]{
                {0, textContent.get(0)},
                {1, textContent.get(1)},
                {2, textContent.get(2)},
                {3, textContent.get(3)}
        };
    }

    @Test(dataProvider = "textElementsProvider")
    public void textValidationTest(int i, String expectedValue) {
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

//       Text content validations
        List<WebElement> elements = driver.findElements(By.xpath(".//div[@class = 'row clerafix benefits']/div"));
        assertEquals(elements.get(i).getText(), expectedValue);

        driver.quit();
    }
}