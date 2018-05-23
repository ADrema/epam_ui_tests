package com.epam.uitests.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.openqa.selenium.By.id;
import static org.testng.Assert.assertTrue;

public class TestIndexPage {
    private WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
//        Set options to avoid browser pop-up windows
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars")
//                .setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Test()
    public void IndexPageTest() {
//        1. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI ");

//        2. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

//        3. Perform login
        WebElement profile = driver.findElement(By.className("profile-photo"));
        WebElement login = driver.findElement(id("Name"));
        WebElement password = driver.findElement(id("Password"));
        WebElement enterButton = driver.findElement(By.className("fa-sign-in"));

        profile.click();
        login.sendKeys("epam");
        password.sendKeys("1234");
        enterButton.click();
        WebElement userName = driver.findElement(By.xpath(".//span[contains(text(), 'Piter Chailovskii')]"));

//        4. Assert User name in the left-top side of screen that user is loggined
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

//        5. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

//        6. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeItem = driver.findElement(By.xpath(".//a[@href = 'index.html']"));
        WebElement contactFormItem = driver.findElement(By.xpath(".//a[@href = 'contacts.html']"));
        WebElement serviceItem = driver.findElement(By.xpath(".//ul[contains(@class, 'uui-navigation')]//a[@class = 'dropdown-toggle']"));
        WebElement metalsAndColorsItem = driver.findElement(By.xpath(".//a[@href = 'metals-colors.html']"));

        Assert.assertEquals(homeItem.getText(), "HOME");
        Assert.assertEquals(contactFormItem.getText(), "CONTACT FORM");
        Assert.assertEquals(serviceItem.getText(), "SERVICE");
        Assert.assertEquals(metalsAndColorsItem.getText(), "METALS & COLORS");

//        7. Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-practise')]"));
        WebElement customIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-custom')]"));
        WebElement multiIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-multi')]"));
        WebElement baseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']//span[contains(@class, 'icon-base')]"));

        practiseIcon.isDisplayed();
        customIcon.isDisplayed();
        multiIcon.isDisplayed();
        baseIcon.isDisplayed();

//        8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement textUderPractiseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=1]//span[@class = 'benefit-txt']"));
        WebElement textUnderCustomItem = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=2]//span[@class = 'benefit-txt']"));
        WebElement textUnderMultiIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=3]//span[@class = 'benefit-txt']"));
        WebElement textUnderBaseIcon = driver.findElement(By.xpath(".//div[@class = 'row clerafix benefits']/div[position()=4]//span[@class = 'benefit-txt']"));

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

//        9. Assert a text of the main header
        WebElement mainText = driver.findElement(By.xpath(".//div[@class = 'main-content']//h3[@name = 'main-title']"));

        Assert.assertEquals(mainText.getText(), "EPAM FRAMEWORK WISHES…");

//        10. Assert a text of the sub header
        WebElement jdiText = driver.findElement(By.xpath(".//div[@class = 'main-content']//p[@name = 'jdi-text']"));

        Assert.assertEquals(jdiText.getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

//         11. Assert that JDI GITHUB is a link and has a proper URL
        WebElement gitLinkToJDI = driver.findElement(By.xpath(".//div[@class = 'main-content']//h3[@class = 'text-center']/a"));

        Assert.assertEquals(gitLinkToJDI.getText(), "JDI GITHUB");
        Assert.assertEquals(gitLinkToJDI.getAttribute("href"), "https://github.com/epam/JDI");

//        12.Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.xpath(".//body/div[@class ='wrapper']/div[@name = 'navigation-sidebar']"));
        assertTrue(leftSection.isDisplayed());

//        13. Assert that there is Footer
        WebElement footer = driver.findElement(By.xpath(".//body/footer"));
        assertTrue(footer.isDisplayed());
    }


}
