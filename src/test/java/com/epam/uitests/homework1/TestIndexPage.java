package com.epam.uitests.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.*;

import java.util.Arrays;


import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class TestIndexPage {
    private WebDriver driver;


    @BeforeSuite
    public void openBrowser(){
//        Set options to avoid browser pop-up windows
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars")
//                .setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);

        driver =  new ChromeDriver(options);
        driver.manage().window().maximize();

    }
    @BeforeTest
    public void openURL(){
        driver.navigate().to("https://epam.github.io/JDI ");
    }

    @Test()
    public void IndexPageTest(){
        WebElement profile = driver.findElement(By.className("profile-photo"));
        WebElement login = driver.findElement(id("Name"));
        WebElement password = driver.findElement(id("Password"));
        WebElement enterButton = driver.findElement(By.className("fa-sign-in"));

//        Test-case steps
//          check the page title
        Assert.assertEquals(driver.getTitle(),"Home Page");
//          login
        profile.click();
        login.sendKeys("epam");
        password.sendKeys("1234");
        enterButton.click();
        WebElement userName = driver.findElement(By.xpath(".//span[contains(text(), 'Piter Chailovskii')]"));
//        Check UserName
        Assert.assertEquals(userName.getText(),"PITER CHAILOVSKII");
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(driver.getTitle(),"Home Page");
//       Check that the items are displayed
        WebElement homeItem = driver.findElement(By.xpath(".//a[@href = 'index.html']"));
        WebElement contactFormItem = driver.findElement(By.xpath(".//a[@href = 'contacts.html']"));
        WebElement serviceItem = driver.findElement(By.xpath(".//ul[contains(@class, 'uui-navigation')]//a[@class = 'dropdown-toggle']"));
        WebElement metalsAndColorsItem = driver.findElement(By.xpath(".//a[@href = 'metals-colors.html']"));

        Assert.assertTrue(homeItem.isDisplayed());
        Assert.assertTrue(contactFormItem.isDisplayed());
        Assert.assertTrue(serviceItem.isDisplayed());
        Assert.assertTrue(metalsAndColorsItem.isDisplayed());
//   Check that the items have proper text
        Assert.assertEquals(homeItem.getText(),"HOME");
        Assert.assertEquals(contactFormItem.getText(),"CONTACT FORM");
        Assert.assertEquals(serviceItem.getText(),"SERVICE");
        Assert.assertEquals(metalsAndColorsItem.getText(),"METALS & COLORS");
//        check that 4 images are displayed
        WebElement practiseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-practise')]"));
        WebElement customIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-custom')]"));
        WebElement multiIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-multi')]"));
        WebElement baseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-base')]"));
        practiseIcon.isDisplayed();
        customIcon.isDisplayed();
        multiIcon.isDisplayed();
        baseIcon.isDisplayed();
//        Check the text under previous 4 images
        WebElement textUderPractiseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=1]//span[@class = 'benefit-txt']"));
        WebElement textUnderCustomItem = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=2]//span[@class = 'benefit-txt']"));
        WebElement textUnderMultiIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=3]//span[@class = 'benefit-txt']"));
        WebElement textUnderBaseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=4]//span[@class = 'benefit-txt']"));

        textUderPractiseIcon.isDisplayed();
        textUnderCustomItem.isDisplayed();
        textUnderMultiIcon.isDisplayed();
        textUnderBaseIcon.isDisplayed();
        Assert.assertEquals(textUderPractiseIcon.getText(),
                "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project");
        Assert.assertEquals(textUnderCustomItem.getText(),
                    "To be flexible and\n" +
                    "customizable");
        Assert.assertEquals(textUnderMultiIcon.getText(),
                    "To be multiplatform");
        Assert.assertEquals(textUnderBaseIcon.getText(),
                    "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…");
//        Check that main text is displayed
        WebElement mainText = driver.findElement(By.xpath(".//div[@class = 'main-content']//h3[@name = 'main-title']"));
        WebElement jdiText = driver.findElement(By.xpath(".//div[@class = 'main-content']//p[@name = 'jdi-text']"));

        mainText.isDisplayed();
        jdiText.isDisplayed();
//        and has respective text
        Assert.assertEquals(mainText.getText(),"EPAM FRAMEWORK WISHES…");
        Assert.assertEquals(jdiText.getText(),"LOREM IPSUM DOLOR SIT AMET, " +
                                         "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                                         " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                                         " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
//Check JDI git link is Displayed and has proper text
        WebElement gitLinkToJDI = driver.findElement(By.xpath(".//div[@class = 'main-content']//h3[@class = 'text-center']/a"));
        gitLinkToJDI.isDisplayed();
        Assert.assertEquals(gitLinkToJDI.getText(),"JDI GITHUB");
        Assert.assertEquals(gitLinkToJDI.getAttribute("href"),"https://github.com/epam/JDI");
//        text-center
// Check Left section and footer are displayed
        WebElement leftSection = driver.findElement(By.xpath(".//body/div[@class ='wrapper']/div[@name = 'navigation-sidebar']"));
        WebElement footer = driver.findElement(By.xpath(".//body/footer"));
        leftSection.isDisplayed();
        footer.isDisplayed();
    }

    @AfterSuite
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }


}
