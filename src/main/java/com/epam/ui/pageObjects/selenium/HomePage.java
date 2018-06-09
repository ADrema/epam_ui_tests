package com.epam.ui.pageObjects.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {
    private List<String> navBarItemTexts = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private List<String> textContent = Arrays.asList(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable",
            "To be multiplatform",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" +
                    "wish to get more…"
    );
    private String mainTextValue = "EPAM FRAMEWORK WISHES…";
    private String subHeaderTextValue = "LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
            " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO" +
            " CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private String urlValue = "https://github.com/epam/JDI";


    @FindBy(css = ".uui-side-bar[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(className = "profile-photo")
    private WebElement profileIcon;

    @FindBy(id = "Name")
    private WebElement login;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(className = "fa-sign-in")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo > span")
    private WebElement user;

    @FindBy(css = ".nav.navbar-nav > li > a")
    private List<WebElement> navBarItems;

    @FindBy(css = ".benefits .icons-benefit")
    private List<WebElement> imageElements;

    @FindBy(css = ".benefits .benefit-txt")
    private List<WebElement> textsUndrImages;

    @FindBy(css = ".main-title")
    private WebElement headerText;

    @FindBy(css = ".main-txt")
    private WebElement subHeaderText;

    @FindBy(css = ".main-content .text-center a")
    private WebElement jdiGitHubLink;

    public void openMainPage(WebDriver driver){
        driver.navigate().to("https://epam.github.io/JDI");
    }

    public void checkHomePageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void signIn(String loginValue, String passwordValue) {
        profileIcon.click();
        login.sendKeys(loginValue);
        password.sendKeys(passwordValue);
        submitButton.click();
    }

    public void checkUserName(String userNameValue) {
        assertEquals(user.getText(), userNameValue);
    }

    public void checkTextsOfHeaderSection() {
        checkTextElementInCollection(navBarItems,navBarItemTexts);
    }

    public void check4imagesArePresented() {
        for (int i = 0; i < imageElements.size(); i++) {
            imageElements.get(i).isDisplayed();
        }
    }

    public void check4TextsUnderImages() {
        checkTextElementInCollection(textsUndrImages,textContent);
    }

    public void checkMainHeaderTextIsEqualTo() {
        checkElementText(headerText, mainTextValue);
    }

    public void checkSubheaderTextIsEqualTo() {
        checkElementText(subHeaderText, subHeaderTextValue);
    }

    public void checkJDIurlEqualsTo() {
        assertEquals(jdiGitHubLink.getAttribute("href"), urlValue);
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }

    private void checkElementText(WebElement element, String expectedText){
        assertEquals(element.getText(),expectedText);
    }

    private void checkTextElementInCollection(List<WebElement> elements, List<String> textContent){
        for (WebElement element : elements) {
            assertTrue(textContent.contains(element.getText()));
        }
    }
}