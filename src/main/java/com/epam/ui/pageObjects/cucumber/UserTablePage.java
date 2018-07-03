package com.epam.ui.pageObjects.cucumber;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.common.MainPages;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePage {

    public UserTablePage() {
        page(this);
    }

    @FindBy(how = How.CSS, using = ".uui-header")
    private SelenideElement header;

    @FindBy(how = How.CSS, using = ".right-fix-panel")
    private SelenideElement fixPanel;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name = 'navigation-sidebar']")
    private SelenideElement navBar;

    @FindBy(how = How.CSS, using = ".uui-pagination")
    private SelenideElement pagination;

    @FindBy(how = How.TAG_NAME, using = "footer")
    private SelenideElement footer;

    @FindBy(how = How.CSS, using = "#user-table tr")
    private List<SelenideElement> userTable;

    @FindBy(how = How.CSS, using = ".logs li")
    private List<SelenideElement> log;

    @Step("Open  User Table page")
    @When("I open User Table Page through the header menu Service -> (.+)")
    public void open(String option) {
        Selenide.open(ServiceTabOptions.valueOf(option).url);
    }

    @Step("Check url")
    @When("I am on Users Table Page")
    public void checkThePageIsOpened() {
        assertEquals(url(), "https://epam.github.io/JDI/user-table.html");
    }

    @Step("Check Page Title")
    @When("User Table Page is Active")
    public void checkUserTablePageTitle() {
        assertEquals(title(), MainPages.USER_TABLE.title);
    }

    @Step("Content of User Table Page")
    @When("User Table Page's interface contains correct elements")
    public void cheInterfaceContainsElements() {
        header.shouldBe(Condition.visible);
        navBar.shouldBe(Condition.visible);
        fixPanel.shouldBe(Condition.visible);
        pagination.shouldBe(Condition.visible);
        footer.shouldBe(Condition.visible);
    }

    @Step("Check table header section")
    @When("I check (.+) and (.+) columns of Users table")
    public void checkNumberAndUserColumn(String column1, String column2) {
        userTable.get(0).shouldHave(Condition.matchesText(column1));
        userTable.get(0).shouldHave(Condition.matchesText(column2));
    }

    @Step("Check User column content")
    @Then("User table contains correct values for numbers and users")
    public void checkNumbersAndUsersInTable(DataTable table) {
        int tableSize = table.height();
        for (int i = 0; i < tableSize; i++) {
            List<String> row = table.row(i);
            String number = row.get(0);
            String name = row.get(1);
            userTable.get(i).shouldHave(Condition.text(number));
            userTable.get(i).shouldHave(Condition.text(name));
        }
    }

    @Step("Check Description column is present")
    @When("I check (.+) column of Users table")
    public void checkDescriptionColumn(String column) {
        userTable.get(0).shouldHave(Condition.matchesText(column));
    }

    @Step("Check content of Description column")
    @Then("All cells of 'Description' column contains text")
    public void checkDescriptionField(DataTable table) {
        int tableSize = table.height();
        for (int i = 0; i < tableSize; i++) {
            List<String> row = table.row(i);
            String number = row.get(0);
            String description = row.get(1);
            userTable.get(i).shouldHave(Condition.text(number));
            userTable.get(i).shouldHave(Condition.matchesText(description));
        }
    }

    @Step("set Vip status")
    @When("I set 'Vip' status to (.+)")
    public void setVIPStatus(String user) {
        $$("#user-table tr").findBy(Condition.text(user))
                .findElementByCssSelector("[type = 'checkbox']").click();
    }

    @Step("Check log")
    @Then("'Log' section shows a log row in format: (.+)")
    public void checkLogRow(String result) {
        log.get(0).shouldHave(Condition.text(result));
    }

    @Step("Click on Dropdown element")
    @When("I click on dropdown in column Type for user (.+)")
    public void clickOnDropDown(String user) {
        $$("#user-table tr").findBy(Condition.text(user))
                .findElementByTagName("select").click();
    }

    @Step("Check droplist options")
    @Then("droplist for (.+) contains values")
    public void checkDropDownOptions(String user, DataTable table) {
        int tableSize = table.height();
        List<String> column = table.column(0);
        String select = $$("#user-table tr").findBy(Condition.text(user))
                .findElementByTagName("select").getText();

        for (int i = 1; i < tableSize; i++) {
            assertTrue(select.contains(column.get(i)));
        }
    }
}