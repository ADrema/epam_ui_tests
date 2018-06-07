package com.epam.uitests.homework4;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.enumObjects.common.MainPages;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import com.epam.ui.enumObjects.homePage.Users;
import com.epam.ui.pageObjects.selenide.DatesPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class SimpleSelenideTest2 extends TestBaseForSelenide {
    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
    }

    @Test(testName = "Dates page tests")
    public void testDatesPageWithSelenide(){
//        1. Open test site by URL
        homePage.open(ServiceTabOptions.DATES.url);

//        2. Assert Browser title
        homePage.checkPageTitleEqualsTo(MainPages.HOMEPAGE.title);

//        3. Perform login
        homePage.signIn(Users.PITER_CHAILOVSKII);

//        4. Assert User name in the left-top side of screen that user is loggined homePage.
        homePage.checkUserName(Users.PITER_CHAILOVSKII);

//        5. Open through the header menu Service -> Different Elements Page
        datesPage.open(ServiceTabOptions.DATES.url);

//        6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position and assert the log row
        datesPage.moveSliders(0, 100);

//        7. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position and assert the log row
        datesPage.moveSliders(0, 0);

//        8. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most right position and assert the log row
        datesPage.moveSliders(100, 100);

//        9. Using drag-and-drop set Range sliders and assert the log row
        datesPage.moveSliders(30, 70);
    }
}
