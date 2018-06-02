package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
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

    public void signIn(String loginValue, String passwordValue) {
        profileIcon.click();
        login.sendKeys(loginValue);
        password.sendKeys(passwordValue);
        submitButton.click();
    }

    public void checkPageTitleEqualsTo(String titleValue) {
        assertEquals(title(), titleValue);
    }

    public void checkUserName(String userNameValue) {
        user.shouldHave(Condition.exactText(userNameValue));
    }

    public void checkBenefits(int size) {
        imageElements.shouldHaveSize(size);
        textsUndrImages.shouldHaveSize(size);
    }

    public void checkMainContentTexts() {
        headerText.shouldBe(Condition.visible);
        subHeaderText.shouldBe(Condition.visible);
    }

    public void checkNavBarServiceOptions(List<String> serviceTabContent) {
        $(".uui-header .nav li.dropdown").click();
        ElementsCollection serviceTab = $$(".uui-header .nav li.dropdown .dropdown-menu a");
        checkElementsTexts(serviceTab, serviceTabContent);
    }

    public void checkSideBarServiceOptions(List<String> serviceTabContent) {
        ElementsCollection sideBarServices = $$(".uui-side-bar[name = 'navigation-sidebar']  .sub a");
        checkElementsTexts(sideBarServices, serviceTabContent);
    }

    public DifferentElementsPage openDifferentElements() {
        $(".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']").click();
        return open("https://epam.github.io/JDI/different-elements.html", DifferentElementsPage.class);
    }

    public DatesPage openDatesPage() {
        $(".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']").click();
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
