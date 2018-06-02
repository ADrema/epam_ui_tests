package com.epam.uitests.homework4;

import com.epam.ui.base.TestBaseForSelenide;
import com.epam.ui.pageObjects.selenide.DatesPage;
import com.epam.ui.pageObjects.selenide.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SimpleSelenideTest2 extends TestBaseForSelenide {

    //    TODO: Cecge to Enum
    private List<String> serviceTabContent = Arrays.asList("Support", "Dates", "Complex Table",
            "Simple Table", "User Table", "Table with pages",
            "Different elements", "Performance");


    @AfterMethod
    public void afterMethod(){

    }
    @Test
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
//        1

//        10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
//        11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.moveSliders(100, 100);
//        12. Using drag-and-drop set Range sliders.
//        13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.moveSliders(30, 70);
//    24
    }
    
}
