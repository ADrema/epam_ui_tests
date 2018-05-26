package com.epam.uitests.homework3;

import com.epam.ui.pageObjects.selenium.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestIndexPage {

    private WebDriver driver;
    private ChromeOptions options;
    private HomePage homePage;
    private List<String> navBarItemTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private List<String> textContent = Arrays.asList(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable",
            "To be multiplatform",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                    "wish to get more…"
    );

    @BeforeClass
    public void beforeClass() {
        options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test()
    public void IndexPageTest() {
//        1. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI");

//        2. Assert Browser title
        homePage.checkPageTitleEqualsTo("Home Page");

//        3. Perform login
        homePage.signIn("epam", "1234");

//        4. Assert User name in the left-top side of screen that user is
        homePage.checkUserName("PITER CHAILOVSKII");

//        5. Assert Browser title
        homePage.checkPageTitleEqualsTo("Home Page");

//        6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkTextsOfHeaderSection(navBarItemTexts);

//        7. Assert that there are 4 images on the Index Page and they are displayed
        homePage.check4imagesArePresented();

//        8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.check4TextsUnderImages(textContent);

//        9. Assert a text of the main header
        homePage.checkMainHeaderTextIsEqualTo("EPAM FRAMEWORK WISHES…");

//        10. Assert a text of the sub header
        homePage.checkSubheaderTextIsEqualTo("LOREM IPSUM DOLOR SIT AMET," +
                " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
                " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

//         11. Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDIurlEqualsTo("https://github.com/epam/JDI");

//        12.Assert that there is Left Section
        homePage.checkLeftSectionIsDisplayed();

//        13. Assert that there is Footer
        homePage.checkFooterIsDisplayed();
    }
}
