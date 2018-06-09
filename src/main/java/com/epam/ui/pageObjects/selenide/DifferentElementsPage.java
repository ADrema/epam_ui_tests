package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import com.epam.ui.enumObjects.differentElementsPage.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPage.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPage.SelectEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DifferentElementsPage {
    private int checkBoxesAmount = 4;
    private int radioButtonsAmount = 4;
    private int buttonsAmount = 2;

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

    @Step("Open  Different Elements page")
    public void open() {
        Selenide.open(ServiceTabOptions.DIFFERENTELEMENTS.url);
    }

    @Step("Check interface on Different elements page, CheckBox elements are presented")
    public void checkNumberOfCheckBoxElements() {
        checkBoxesBoard.shouldHaveSize(checkBoxesAmount);
    }

    @Step("Check interface on Different elements page, Radio button elements are presented")
    public void checkNumberOfRadioButtonElements() {
        radioButtonsBoard.shouldHaveSize(radioButtonsAmount);
    }

    @Step("Check dropdown menu is presented")
    public void checkDropDownMwnuIsPresent() {
        dropDownEntryMode.should(Condition.visible);
    }

    @Step("Check interface on Different elements page, Button elements are presented")
    public void checkNumberOfButtonsElements() {
        buttonsBoard.shouldHaveSize(buttonsAmount);
    }

    @Step("Assert that there is Right Section")
    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    @Step("Assert that there is Left Section")
    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

    @Step("Select checkboxes and check the log row")
    public void selectCheckboxElement(int index) {
        checkBoxesBoard.get(index).click();
    }

    @Step("Assert that for checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void verifyCheckBoxLogRow(int index, boolean action, int logRow) {
        log.get(logRow - 1).shouldHave(Condition.text(CheckBoxesEnum.getTextValue(index) + ": condition changed to " + String.valueOf(action)));
    }

    @Step("Select radioButton element and check log row")
    public void selectRadioElement(int index) {
        radioButtonsBoard.get(index).click();
    }

    @Step("Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. ")
    public void verifyRadioButtonLogRow(int index, int logRow) {
        log.get(logRow - 1).shouldHave(Condition.text("metal: value changed to " + RadioButtonEnum.getTextValue(index)));
    }

    @Step("Select in dropdown and check log row")
    public void selectDropDownElement(int index) {
        dropDownEntryMode.click();
        dropDownElements.get(index).click();
    }

    @Step("Assert log row")
    public void verifyDropDownElementLogRow(int index, int logRow) {
        log.get(logRow - 1).shouldHave(Condition.text("Colors: value changed to " + SelectEnum.getTextValue(index)));
    }
}
