package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.homePage.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class HomePage {

    @FindBy(how = How.CSS, using = ".uui-side-bar[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(how = How.TAG_NAME, using = "footer")
    private SelenideElement footer;

    @FindBy(how = How.CSS, using = ".profile-photo")
    private SelenideElement profileIcon;

    @FindBy(how = How.ID, using = "Name")
    private SelenideElement login;

    @FindBy(how = How.ID, using = "Password")
    private SelenideElement password;

    @FindBy(how = How.CLASS_NAME, using = "fa-sign-in")
    private SelenideElement submitButton;

    @FindBy(how = How.CSS, using = ".profile-photo > span")
    private SelenideElement user;

    @FindBy(how = How.CSS, using = ".nav.navbar-nav > li > a")
    private ElementsCollection navBarItems;

    @FindBy(how = How.CSS, using = ".benefits .icons-benefit")
    private ElementsCollection imageElements;

    @FindBy(how = How.CSS, using = ".benefits .benefit-txt")
    private ElementsCollection textsUndrImages;

    @FindBy(how = How.CSS, using = ".main-title")
    private SelenideElement headerText;

    @FindBy(how = How.CSS, using = ".main-txt")
    private SelenideElement subHeaderText;

    @FindBy(how = How.CSS, using = ".main-content .text-center a")
    private SelenideElement jdiGitHubLink;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']")
    private SelenideElement serviceDifferentElemetsPageLink;

    @FindBy(how = How.CSS, using = ".uui-header .nav li.dropdown")
    private SelenideElement serviceDropDownMenu;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a")
    private ElementsCollection serviceTab;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a" )
    private ElementsCollection sideBarServices;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']")
    private SelenideElement navigationBar;

    @Step("Perform login")
    public void signIn(Users user) {
        profileIcon.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Assert Browser title")
    public void checkPageTitleEqualsTo(String titleValue) {
        assertEquals(title(), titleValue);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined")
    public void checkUserName(Users userProfile) {
        user.shouldHave(Condition.exactText(userProfile.name));
    }

    @Step("Check interface on Home page, it contains all needed elements:")
    public void checkBenefits(int size) {
        imageElements.shouldHaveSize(size);
        textsUndrImages.shouldHaveSize(size);
    }

    public void checkMainContentTexts() {
        headerText.shouldBe(Condition.visible);
        subHeaderText.shouldBe(Condition.visible);
    }

    @Step("Click on 'Service' subcategory in the header and check that drop down contains options")
    public void checkNavBarServiceOptions(List<String> serviceTabContent) {
        serviceDropDownMenu.click();
//        ElementsCollection serviceTab = $$(".uui-header .nav li.dropdown .dropdown-menu a");
        checkElementsTexts(serviceTab, serviceTabContent);
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options")
    public void checkSideBarServiceOptions(List<String> serviceTabContent) {
//        ElementsCollection sideBarServices = $$(".uui-side-bar[name = 'navigation-sidebar']  .sub a");
        checkElementsTexts(sideBarServices, serviceTabContent);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public DifferentElementsPage openDifferentElements() {
        navigationBar.click();
        return open("https://epam.github.io/JDI/different-elements.html", DifferentElementsPage.class);
    }

    public DatesPage openDatesPage() {
        navigationBar.click();
        return open("https://epam.github.io/JDI/dates.html", DatesPage.class);
    }

    public void check4imagesArePresented() {
        for (SelenideElement image : imageElements) {
            image.shouldBe(Condition.visible);
        }
    }

    public void check4TextsUnderImages(List<String> textContent) {
        checkElementsTexts(textsUndrImages, textContent);
    }

    public void checkMainHeaderTextIsEqualTo(String textValue) {
        headerText.shouldHave(Condition.exactText(textValue));
    }

    public void checkSubheaderTextIsEqualTo(String textValue) {
        subHeaderText.shouldHave(Condition.exactText(textValue));
    }

    public void checkJDIurlEqualsTo(String urlValue) {
        jdiGitHubLink.shouldHave(Condition.exactText(urlValue));
    }

    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(Condition.visible);
    }

    public void checkFooterIsDisplayed() {
        footer.shouldBe(Condition.visible);
    }

    private void checkElementsTexts(ElementsCollection elements, List<String> texts) {
        int textsCount = texts.size();
        elements.shouldHaveSize(textsCount);
        for (int i = 0; i < textsCount; i++) {
            elements.get(i).shouldHave(Condition.exactText(texts.get(i)));
        }
    }
}
