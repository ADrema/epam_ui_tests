package com.epam.ui.pageObjects.cucumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import com.epam.ui.enumObjects.differentElementsPage.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPage.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPage.SelectEnum;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsCucumberPage {

    private CheckBoxesEnum element;
    private int checkBoxesAmount = 4;
    private int radioButtonsAmount = 4;
    private int buttonsAmount = 2;

    public DifferentElementsCucumberPage() {
        page(this);
    }

    @FindBy(how = How.CSS, using = ".checkbox-row input[type = 'checkbox']")
    private ElementsCollection checkBoxesBoard;

    @FindBy(how = How.CSS, using = ".checkbox-row input[type = 'radio']")
    private ElementsCollection radioButtonsBoard;

    @FindBy(how = How.CSS, using = ".main-content-hg button, input[type = 'button']")
    private ElementsCollection buttonsBoard;

    @FindBy(how = How.CSS, using = ".right-fix-panel")
    private SelenideElement fixPanel;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']")
    private SelenideElement navBar;

    @FindBy(how = How.CSS, using = ".logs li")
    private List<SelenideElement> log;

    @FindBy(how = How.CSS, using = ".main-content-hg .colors select")
    private SelenideElement dropDownEntryMode;

    @FindBy(how = How.CSS, using = ".main-content-hg .colors select option")
    private ElementsCollection dropDownElements;

    @FindBy(how = How.CSS, using = ".profile-photo")
    private SelenideElement profile;

    @Step("Open  Different Elements page")
    @When("I'm on Different elements page")
    public void open() {
        Selenide.open(ServiceTabOptions.DIFFERENTELEMENTS.url);
    }

    @Step("Check interface on Different elements page, CheckBox elements are presented")
    @Then("Different elements page contains checkboxed")
    public void checkNumberOfCheckBoxElements() {
        checkBoxesBoard.shouldHaveSize(checkBoxesAmount);
    }

    @Step("Check interface on Different elements page, Radio button elements are presented")
    @Then("Different elements page contains radiobuttons")
    public void checkNumberOfRadioButtonElements() {
        radioButtonsBoard.shouldHaveSize(radioButtonsAmount);
    }

    @Step("Check dropdown menu is presented")
    @Then("Different elements page contains dropdown menu")
    public void checkDropDownMwnuIsPresent() {
        dropDownEntryMode.should(Condition.visible);
    }

    @Step("Check interface on Different elements page, Button elements are presented")
    @Then("Different elements page contains buttons")
    public void checkNumberOfButtonsElements() {
        buttonsBoard.shouldHaveSize(buttonsAmount);
    }

    @Step("Assert that there is Right Section")
    @Then("Different elements page contains right section")
    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    @Step("Assert that there is Left Section")
    @Then("Different elements page contains left section")
    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

    @Step("Select checkboxes")
    @When("(.+) checkbox is clicked")
    public void selectCheckboxElement(String element){
        checkBoxesBoard.get(CheckBoxesEnum.valueOf(element).index).click();
    }

    @Step("Assert that for checkbox there is an individual log row and value is corresponded to the status of checkbox")
    @Then("(\\d+) logrow contains (.+) and (.+) condition")
    public void verifyCheckBoxLogRow(int logRow, String element, String condition) {
        log.get(logRow - 1).shouldHave(Condition.text(CheckBoxesEnum.valueOf(element).name() + ": condition changed to " + condition));
    }

    @Step("Select radioButton element and check log row")
    @When("(.+) radioButton is selected")
    public void selectRadioElement(String element) {
        radioButtonsBoard.get(RadioButtonEnum.valueOf(element).index).click();
    }

    @Step("Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.")
    @Then("(\\d+) logrow contains (.+) value")
    public void verifyRadioButtonLogRow(int logRow, String element) {
        log.get(logRow - 1).shouldHave(Condition.text("metal: value changed to " + RadioButtonEnum.valueOf(element).name()));
    }

    @Step("Select in dropdown and check log row")
    @When("(.+) color is selected in dropdown menu")
    public void selectDropDownElement(String element) {
        dropDownEntryMode.click();
        dropDownElements.get(SelectEnum.valueOf(element).index).click();
    }

    @Step("Assert log row")
    @Then("(\\d+) logrow contains value (.+)")
    public void verifyDropDownElementLogRow(int logRow, String element) {
        log.get(logRow - 1).shouldHave(Condition.text("Colors: value changed to " + SelectEnum.valueOf(element).name()));
    }
}