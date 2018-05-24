package com.epam.uitests.homework2.ex1;
/*
 * Develop a dedicated test for asserting 4 texts below 4 pictures
 * on the Index Page -https://epam.github.io/JDI/index.html.
 * The test must be developed with help of the DataProvider.
 * Run it in the parallel by methods through the configuring parameters
 * in a @DataProvider annotation.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestTextUsingDataProvider {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
//        Set options to avoid browser pop-up windows
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    @DataProvider
    public Object[][] textElementsProvide() {

        List<String> elementsText = getElementsText();
        return new Object[][] {
                {elementsText.get(0), ("To include good practices\n" +
                                                "and ideas from successful\n" +
                                                "EPAM project")},
                {elementsText.get(1), ("To be flexible and\n" +
                                                "customizable")},
                {elementsText.get(2), ("To be multiplatform")},
                {elementsText.get(3), ("Already have good base\n" +
                                                "(about 20 internal and\n" +
                                                "some external projects),\n" +
                                                "wish to get more…")}
        };
    }

    @Test (dataProvider = "textElementsProvide")
    public void textValidationTest (String actualValue, String expectedValue){

//        2. Text content validations
        assertEquals(actualValue,expectedValue);
    }

    public List<String> getElementsText(){
        List<String> textContent = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(By.xpath(".//div[@class = 'row clerafix benefits']/div"));

        for (WebElement element : elements){
            String textValue = element.getText();
            textContent.add(textValue);
        }
        return textContent;

    }

}


