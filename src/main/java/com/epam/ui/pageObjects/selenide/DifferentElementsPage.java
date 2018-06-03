package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.differentElementsPage.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPage.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPage.SelectEnum;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DifferentElementsPage {

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

    @FindBy(how = How.CSS, using = ".panel-body-list.logs li:nth-child(1)")
    private SelenideElement lastLogRecord;

    @FindBy(how = How.CSS, using = ".main-content-hg .colors select")
    private SelenideElement dropDownEntryMode;

    @FindBy(how = How.CSS, using = ".main-content-hg .colors select option")
    private ElementsCollection dropDownElement;

    @Step("Check interface on Different elements page, CheckBox elements are presented")
    public void checkNumberOfCheckBoxElements(int amount) {
        checkBoxesBoard.shouldHaveSize(amount);
        System.out.println("actual size: " + checkBoxesBoard.size());
    }

    @Step("Check interface on Different elements page, Radio button elements are presented")
    public void checkNumberOfRadioButtonElements(int amount) {
        radioButtonsBoard.shouldHaveSize(amount);
    }

    @Step("Check interface on Different elements page, Button elements are presented")
    public void checkNumberOfButtonsElements(int amount) {
        buttonsBoard.shouldHaveSize(amount);
    }

    @Step("Assert that there is Right Section")
    public void checkFixPaneIsVisible() {
        fixPanel.shouldBe(Condition.visible);
    }

    @Step("Assert that there is Left Section")
    public void checkNavBarIsVisible() {
        navBar.shouldBe(Condition.visible);
    }

    @Step("Select checkbox")
    public void selectCheckBoxElement(int index) {
        checkBoxesBoard.get(index).click();
    }

    @Step("Assert that for the checkbox there is an individual log row")
    public void verifyCheckboxIsSelected(int index) {
        lastLogRecord.shouldHave(Condition.text(CheckBoxesEnum.getTextValue(index) + ": condition changed to true"));
    }

    @Step("Select radioButton elemet")
    public void selectRadioElement(int index) {
        radioButtonsBoard.get(index).click();
    }

    @Step("Assert that for radiobutton there is a log row")
    public void verifyRadioElementIsSelected(int index) {
        lastLogRecord.shouldHave(Condition.text("metal: value changed to " + RadioButtonEnum.getTextValue(index)));
    }

    @Step("Select in dropdown")
    public void selectDropDownElement(int index) {
        dropDownEntryMode.click();
        dropDownElement.get(index).click();
    }

    @Step("Assert that for dropdown there is a log row ")
    public void verifyDropDownItemIsSelected(int index) {
        lastLogRecord.shouldHave(Condition.text("Colors: value changed to " + SelectEnum.getTextValue(index)));
    }

    @Step("Unselect and assert")
    //    TODO: Add condition, to check that it was selected/unselected. The same for other controls
    public void unselectCheckboxElement(int index) {
        checkBoxesBoard.get(index).click();
    }

    @Step("Assert that for the checkbox there is an individual log row")
    public void verifyCheckboxIsUnselected(int index) {
        lastLogRecord.shouldHave(Condition.text(CheckBoxesEnum.getTextValue(index) + ": condition changed to false"));
    }
}
