package com.epam.ui.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = ".//body/div[@class ='wrapper']/div[@name = 'navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(xpath = ".//body/footer")
    private WebElement footer;

    @FindBy(className = "profile-photo")
    private WebElement profileIcon;

    @FindBy(id = "Name")
    private WebElement login;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(className = "fa-sign-in")
    private WebElement submitButton;

    @FindBy(xpath = ".//div[@class = 'profile-photo']/span[@ui = 'label']")
    private WebElement user;

    @FindBy(xpath = ".//nav[@role = 'navigation']//ul[contains(@class, 'navbar-nav')][0]/li/a")
    private List<WebElement> navBarItems;

    @FindBy(xpath = ".//div[@class = 'row clerafix benefits']//div[contains(@class, 'benefit-icon')]//a")
    private List<WebElement> imageElements;

    @FindBy(xpath = ".//div[@class = 'row clerafix benefits']/div")
    private List<WebElement> textsUndrImages;

    @FindBy(xpath = ".//div[@class = 'main-content']//h3[@name = 'main-title']")
    private WebElement headerText;

    @FindBy(xpath = ".//div[@class = 'main-content']//p[@name = 'jdi-text']")
    private WebElement subHeaderText;

    @FindBy(xpath = ".//div[@class = 'main-content']//h3[@class = 'text-center']/a")
    private WebElement jdiGitHubLink;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void checkPageTitleEqualsTo(String title) {
        assertEquals(driver.getTitle(), title);
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

    public void checkTextsOfHeaderSection(List<String> itemsText) {
        for (WebElement element : navBarItems) {
            System.out.println(element.getText());
            assertTrue(itemsText.contains(element.getText()));
        }
    }

    public void check4imagesArePresented() {
        for (int i = 0; i < imageElements.size(); i++) {
            imageElements.get(i).isDisplayed();
        }
    }

    public void check4TextsUnderImages(List<String> textContent) {
        for (WebElement element : textsUndrImages) {
            assertTrue(textContent.contains(element.getText()));
        }
    }

    public void checkMainHeaderTextIsEqualTo(String textValue) {
        assertEquals(headerText.getText(), textValue);
    }

    public void checkSubheaderTextIsEqualTo(String textValue) {
        assertEquals(subHeaderText.getText(), textValue);
    }

    public void checkJDIurlEqualsTo(String urlValue) {
        assertEquals(jdiGitHubLink.getAttribute("href"), urlValue);
    }

    public void checkLeftSectionIsDisplayed() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        assertTrue(footer.isDisplayed());
    }
}