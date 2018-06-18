package com.epam.uitests.homework5.ex2;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.enumObjects.homePage.Users;
import com.epam.ui.pageObjects.selenide.DatesPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

@Feature("Test for Dates page")

public class AllureSimpleSelenideTest2 extends TestBaseForSelenide {
    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
    }

    @Test()
    public void testIndexPageWithSelenide() {
//        1. Open test site by URL
        homePage.open();

//        2. Assert Browser title
        homePage.checkHomePageTitle();

//        3. Perform login
        homePage.signIn(Users.PITER_CHAILOVSKII);

//        4. Assert User name in the left-top side of screen that user is loggined homePage.
        homePage.checkUserName(Users.PITER_CHAILOVSKII);

//        5. Open through the header menu Service -> Different Elements Page
        datesPage.open();

//        6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveSliders(0, 100);

//        7. Assert log row
        datesPage.verifyLogRow(0, 2, 100, 1);

//        8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position and assert the log row
        datesPage.moveSliders(0, 0);

//        9. Assert log row
        datesPage.verifyLogRow(0, 2, 0, 1);

//        10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most right position and assert the log row
        datesPage.moveSliders(100, 100);

//        11. Assert log row
        datesPage.verifyLogRow(100, 1, 100, 2);

//        12. Using drag-and-drop set Range sliders and assert the log row
        datesPage.moveSliders(30, 70);

//        13. Assert log row
        datesPage.verifyLogRow(30, 2, 70, 1);
    }
}
