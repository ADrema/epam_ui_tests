package com.epam.uitests.homework5.ex2;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.listeners.AllureAttachmentListener;
import com.epam.ui.pageObjects.selenide.DatesPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Story("Implement on Selenide framework in Page Object pattern")
@Feature("Test for Dates page")
@Listeners({AllureAttachmentListener.class})
public class AllureSimpleSelenideTest2 extends TestBaseForSelenide {

    @Test(groups = "Allure")
    public void testIndexPageWithSelenide() throws InterruptedException {
//        1. Open test site by URL
        HomePage homePage = open("https://epam.github.io/JDI", HomePage.class);

//        2. Assert Browser title
        homePage.checkPageTitleEqualsTo("Home Page");

//        3. Perform login
        homePage.signIn("epam", "1234");

//        4. Assert User name in the left-top side of screen that user is loggined
//        homePage.
        homePage.checkUserName("PITER CHAILOVSKII");

//        5. Open through the header menu Service -> Different Elements Page
        DatesPage datesPage = homePage.openDatesPage();

//        6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
//        7. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.moveSliders(0, 100);

//        8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
//        9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.moveSliders(0, 0);

//        10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
//        11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.moveSliders(100, 100);

//        12. Using drag-and-drop set Range sliders.
//        13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.moveSliders(30, 70);
    }
}
