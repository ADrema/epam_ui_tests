package com.epam.ui.pageObjects.cucumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.common.MainPages;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import com.epam.ui.enumObjects.homePage.Users;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.title;
import static com.epam.ui.enumObjects.homePage.Users.valueOf;
import static org.testng.Assert.assertEquals;

public class HomeCucumberPage {

    public HomeCucumberPage() {
        page(this);
    }

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

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a")
    private ElementsCollection sideBarServices;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']")
    private SelenideElement navigationBar;

    @Step("Open Home Page")
    @Given("I'm on the Home Page")
    public void open() {
        Selenide.open(MainPages.HOMEPAGE.url);
    }

    @Step("Perform login")
    @When("I am logged in as (.+)")
    public void signIn(String userName) {
        profileIcon.click();
        Users userProfile = valueOf(userName);
        login.sendKeys(userProfile.login);
        password.sendKeys(userProfile.password);
        submitButton.click();
    }

    @Step("Assert Browser title")
    @Then("The browser title is HomePage")
    public void checkHomePageTitle() {
        assertEquals(title(), MainPages.HOMEPAGE.title);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined")
    @Then("The user name (.+) is displayed on the left-side of the screen")
    public void checkUserName(String userName) {
        Users userProfile = valueOf(userName);
        user.shouldHave(Condition.exactText(userProfile.name));
    }

    @Step("Check interface on Home page, it contains all needed elements:")
    @Then("Home Page contains Benefits")
        public void checkBenefitssize() {
        imageElements.shouldHaveSize(4);
        textsUndrImages.shouldHaveSize(4);
    }

    @Step("Check that texts above benefits are presented")
    @Then("Home Page contains texts above the benefits")
    public void checkMainContentTexts() {
        headerText.shouldBe(Condition.visible);
        subHeaderText.shouldBe(Condition.visible);
    }

    @Step("Click on 'Service' subcategory in the header and check that drop down contains options")
    @Then("Home Page navigation bar contains respective options")
    public void checkNavBarServiceOptions() {
        serviceDropDownMenu.click();
        checkElementsTexts(serviceTab, ServiceTabOptions.getLinkNames());
    }

    @Step("Click on Service subcategory in the left section and check that drop down contains options")
    @Then("Home Page side bar also contains the respective options")
    public void checkSideBarServiceOptions() {
        checkElementsTexts(sideBarServices, ServiceTabOptions.getLinkNames());
    }

    public void check4imagesArePresented() {
        for (SelenideElement image : imageElements) {
            image.shouldBe(Condition.visible);
        }
    }

    private void checkElementsTexts(ElementsCollection elements, List<String> texts) {
        int textsCount = texts.size();
        elements.shouldHaveSize(textsCount);
        for (int i = 0; i < textsCount; i++) {
            elements.get(i).shouldHave(Condition.exactText(texts.get(i)));
        }
    }
}
