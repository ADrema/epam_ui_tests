package com.epam.uitests.homework5.ex1;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.enumObjects.differentElementsPage.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPage.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPage.SelectEnum;
import com.epam.ui.enumObjects.homePage.Users;
import com.epam.ui.pageObjects.selenide.DifferentElementsPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

@Feature("Test for Different Elements page with failed result")
public class AllureSimpleSelenideTest1Failed extends TestBaseForSelenide {
    private HomePage homePage;
    private DifferentElementsPage dePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        dePage = page(DifferentElementsPage.class);
    }
    @Test()
    public void testIndexPageWithSelenide() {
//        1. Open test site by URL
        homePage.open();

//        2. Assert Browser title
        homePage.checkHomePageTitle();

//        3. Perform login
        homePage.signIn(Users.PITER_CHAILOVSKII);

//        4. Assert User name in the left-top side of screen that user is loggined  homePage.
        homePage.checkUserName(Users.PITER_CHAILOVSKII);

//        5. Check interface on Home page, it contains all needed elements: 4 - pictures, 4 texts under them, 2 text above
        homePage.checkBenefitssize();
        homePage.checkMainContentTexts();
//
//        6. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkNavBarServiceOptions();

//        7. Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkSideBarServiceOptions();

//        8. Open through the header menu Service -> Different Elements Page
        dePage.open();

//        9. Check interface on Different elements page, it contains all needed elements
        dePage.checkNumberOfCheckBoxElements();
        dePage.checkNumberOfRadioButtonElements();
        dePage.checkNumberOfButtonsElements();
        dePage.checkDropDownMwnuIsPresent();

//        10. Assert that there is Right Section
        dePage.checkFixPaneIsVisible();

//        11. Assert that there is Left Section
        dePage.checkNavBarIsVisible();

//        12. Select checkboxes
        dePage.selectCheckboxElement(CheckBoxesEnum.WATER.index);
        dePage.selectCheckboxElement(CheckBoxesEnum.WIND.index);

//        13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WATER.index, true, 2);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WIND.index, true, 1);

//        13. Select radio
        dePage.selectRadioElement(RadioButtonEnum.SELEN.index);

//        14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        dePage.verifyRadioButtonLogRow(RadioButtonEnum.SELEN.index, 1);

//        14. Select elements in dropdown
        dePage.selectDropDownElement(SelectEnum.YELLOW.index);

//        15. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        dePage.verifyDropDownElementLogRow(SelectEnum.YELLOW.index, 1);

//        15. Unselect checkboxes
        dePage.selectCheckboxElement(CheckBoxesEnum.WATER.index);
        dePage.selectCheckboxElement(CheckBoxesEnum.WIND.index);

//        16. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WATER.index, false, 2);
        dePage.verifyCheckBoxLogRow(CheckBoxesEnum.WIND.index, true, 1);
    }
}