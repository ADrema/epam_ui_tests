package com.epam.uitests.homework4;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.pageObjects.selenide.DatesPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SimpleSelenideTest2 extends TestBaseForSelenide

        //    TODO: Cecge to Enum
        private List<String> serviceTabContent = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "User Table", "Table with pages",
                "Different elements", "Performance");

        @Test
        public void testIndexPageWithSelenide() {
//        1. Open test site by URL
            HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);

//        2. Assert Browser title
//        TODO: Doesn't work
//      homePage.checkPageTitleEqualsTo("Home Page");

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
//
//
//        7. Click on Service subcategory in the left section and check that drop down contains options
            homePage.checkSideBarServiceOptions(serviceTabContent);

//        8. Open through the header menu Service -> Different Elements Page
            DatesPage datesPage = homePage.openDatesPage();

//            9. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
            datesPage.moveSliders(int first, int second);
        }
}
