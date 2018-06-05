package com.epam.uitests.homework5.ex1;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.enumObjects.differentElementsPage.CheckBoxesEnum;
import com.epam.ui.enumObjects.differentElementsPage.RadioButtonEnum;
import com.epam.ui.enumObjects.differentElementsPage.SelectEnum;
import com.epam.ui.pageObjects.selenide.DifferentElementsPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@Feature("Test for Different Elements page with failed result")
public class AllureSimpleSelenideTest1Failed extends TestBaseForSelenide {

    private List<String> serviceTabContent = Arrays.asList("Support", "Dates", "Complex Table",
            "Simple Table", "User Table", "Table with pages",
            "Different elements", "Performance");

    @Test(groups = "Allure")
    public void testIndexPageWithSelenide() {
//        1. Open test site by URL
        HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);

//        2. Assert Browser title
        homePage.checkPageTitleEqualsTo("Home Page");

//        3. Perform login
        homePage.signIn("epam", "1234");

//        4. Assert User name in the left-top side of screen that user is loggined
//        homePage.
        homePage.checkUserName("PITER CHAILOVSKII");
//
//        5. Check interface on Home page, it contains all needed elements: 4 - pictures, 4 texts under them, 2 text above
        homePage.checkBenefits(4);
        homePage.checkMainContentTexts();
//
//        6. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkNavBarServiceOptions(serviceTabContent);

//        7. Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkSideBarServiceOptions(serviceTabContent);

//        8. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage dePage = homePage.openDifferentElements();
//
//        9. Check interface on Different elements page, it contains all needed elements
        dePage.checkNumberOfCheckBoxElements(4);
        dePage.checkNumberOfRadioButtonElements(4);
        dePage.checkNumberOfButtonsElements(2);

//        10. Assert that there is Right Section
        dePage.checkFixPaneIsVisible();

//        11. Assert that there is Left Section
        dePage.checkNavBarIsVisible();

//        12. Select checkboxes
//        13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        dePage.clickCheckboxElement(CheckBoxesEnum.WATER.index, true);
        dePage.clickCheckboxElement(CheckBoxesEnum.WIND.index, true);

//        14. Select radio
//        15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        dePage.selectRadioElement(RadioButtonEnum.SELEN.index);

//        16. Select in dropdown
//        17. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        dePage.selectDropDownElement(SelectEnum.YELLOW.index);

//        18. Unselect and assert
//        19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        dePage.clickCheckboxElement(CheckBoxesEnum.WATER.index, false);
        dePage.clickCheckboxElement(CheckBoxesEnum.WIND.index, true);
    }
}