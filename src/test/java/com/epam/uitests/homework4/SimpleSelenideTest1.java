package com.epam.uitests.homework4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.enumObjects.differentElementsPAge.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPAge.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPAge.SelectEnum;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class SimpleSelenideTest1 extends TestBaseForSelenide {

    private List<String> serviceTabContent = Arrays.asList("Support", "Dates", "Complex Table", "Simple Table",
            "Tables With Wages", "Different Elements");

    @Test
    public void testIndexPageWithSelenide() {
//        1. Open test site by URL
        open("https://epam.github.io/JDI");

//        2. Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

//        3. Perform login
        $(".profile-photo").click();
        $("#Name").sendKeys("epam");
        $("#Password").sendKeys("1234");
        $(".fa-sign-in").click();

//        4. Assert User name in the left-top side of screen that user is loggined
        $(".profile-photo").shouldBe(Condition.text("PITER CHAILOVSKII"));

//        5. Check interface on Home page, it contains all needed elements: 4 - pictures, 4 texts under them, 2 text above
        $$(".benefits .benefit-icon").shouldHaveSize(4);
        $$(".benefits .benefit-txt").shouldHaveSize(4);

        $(".main-content [name = 'main-title']").shouldBe(Condition.visible);
        $(".main-content [name = 'jdi-text']").shouldBe(Condition.visible);

//        6. Click on "Service" subcategory in the header and check that drop down contains options
        $(".uui-header .nav li.dropdown").click();
        ElementsCollection serviceTab = $$(".uui-header .nav li.dropdown .dropdown-menu a");
        serviceTab.shouldHaveSize(8);
        checkServiceOptions(serviceTab);

//        7. Click on Service subcategory in the left section and check that drop down contains options
        ElementsCollection serviceOptionsInSideBar = $$(".uui-side-bar[name = 'navigation-sidebar']  .sub a");
        serviceOptionsInSideBar.shouldHaveSize(8);
        checkServiceOptions(serviceOptionsInSideBar);
//        8. Open through the header menu Service -> Different Elements Page
        $(".uui-side-bar[name = 'navigation-sidebar']  .sub a[href = 'different-elements.html']").click();

//        9. Check interface on Different elements page, it contains all needed elements
        $$(".checkbox-row input[type = 'checkbox']").shouldHaveSize(4);
        $$(".checkbox-row input[type = 'radio']").shouldHaveSize(4);
        $$(".main-content-hg button, input[type = 'button']").shouldHaveSize(2);

//        10. Assert that there is Right Section
        $(".right-fix-panel").shouldBe(Condition.visible);

//        11. Assert that there is Left Section
        $(".uui-side-bar[name = 'navigation-sidebar']").shouldBe(Condition.visible);

//        12. Select checkboxes
//        13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        verifyCheckboxIsSelected(CheckBoxesEnum.WATER);
        verifyCheckboxIsSelected(CheckBoxesEnum.WIND);

//        14. Select radio
//        15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        verifyRadioButtonIsSelected(RadioButtonEnum.SELEN);

//        16. Select in dropdown
//        17. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        $(".main-content-hg .colors select").click();
        verifyDropDownItemIsSelected(SelectEnum.YELLOW);

//        18. Unselect and assert checkboxes
//        19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        verifyCheckboxIsUnchecked(CheckBoxesEnum.WATER);
        verifyCheckboxIsUnchecked(CheckBoxesEnum.WIND);
    }

    public void checkServiceOptions(ElementsCollection collection) {
        for (WebElement serviceOption : collection) {
            serviceTabContent.contains(serviceOption);
        }
    }

    public void verifyCheckboxIsSelected(CheckBoxesEnum enumValue) {
        $(enumValue.getLocator()).click();
        $(".panel-body-list.logs li:nth-child(1)")
                .shouldHave(Condition.text(enumValue.textValue + ": condition changed to true"));
    }

    public void verifyCheckboxIsUnchecked(CheckBoxesEnum enumValue) {
        $(enumValue.getLocator()).click();
        $(".panel-body-list.logs li:nth-child(1)")
                .shouldHave(Condition.text(enumValue.textValue + ": condition changed to false"));
    }

    public void verifyRadioButtonIsSelected(RadioButtonEnum enumValue) {
        $(enumValue.getLocator()).click();
        $(".panel-body-list.logs li:nth-child(1)")
                .shouldHave(Condition.text("metal: value changed to " + enumValue.textValue));
    }

    public void verifyDropDownItemIsSelected(SelectEnum enumValue) {
        $(enumValue.getLocator()).click();
        $(".panel-body-list.logs li:nth-child(1)")
                .shouldHave(Condition.text("Colors: value changed to " + enumValue.textValue));
    }
}