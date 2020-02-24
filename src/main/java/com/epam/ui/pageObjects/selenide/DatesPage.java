package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.enumObjects.common.ServiceTabOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    @FindBy(how = How.CSS, using = ".uui-slider.range .ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(how = How.CSS, using = ".logs li")
    private List<SelenideElement> log;

//    TODO: yOffset can be defined as local constant variable
    public static void additionalClickRightBorder(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementL, diffL, 0).perform();
        elementL.click();
        actions().dragAndDropBy(elementR, diffR, 0).perform();
    }

    public static void reverseSteps(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementR, diffR, 0).perform();
        actions().dragAndDropBy(elementL, diffL, 0).perform();
    }

    public static void directSteps(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementL, diffL, 0).perform();
        actions().dragAndDropBy(elementR, diffR, 0).perform();
    }

    @Step("Open Dates page")
    public void open() {
        Selenide.open(ServiceTabOptions.DATES.url);
    }

    @Step("Move sliders to respective position")
    public void moveSliders(int expectedLS, int expectedRS) {
        float onePercent = (float) 2.74;
        int zeroPosition = 800;

        int currentPositionLS = sliders.get(0).getLocation().getX();
        int currentPositionRS = sliders.get(1).getLocation().getX();
        int sliderValueL = Integer.parseInt(sliders.get(0).getText());
        int sliderValueR = Integer.parseInt(sliders.get(1).getText());
        int expectedPositionLS = (int) (zeroPosition + expectedLS * onePercent);
        int expectedPositionRS = (int) (zeroPosition + expectedRS * onePercent);
        int diffLS = expectedPositionLS - currentPositionLS;
        int diffRS = expectedPositionRS - currentPositionRS;

        if (expectedLS == 0) {
            diffLS--;
        }

        if (expectedRS == 0) {
            diffRS--;
        }
//        work around due to the bag or feature on the page
        if ((sliderValueL == sliderValueR) & (sliderValueL == 100)) {
            additionalClickRightBorder(sliders.get(0), diffLS, expectedLS, sliders.get(1), diffRS, expectedRS);
        } else if ((sliderValueL == sliderValueR) & (sliderValueL == 0)) {
            reverseSteps(sliders.get(0), diffLS, expectedLS, sliders.get(1), diffRS, expectedRS);
        } else
            directSteps(sliders.get(0), diffLS, expectedLS, sliders.get(1), diffRS, expectedRS);
    }

    public void checkPageTitleEqualsTo(String titleValue) {
        assertEquals(title(), titleValue);
    }

    @Step("Assert the log row")
    public void verifyLogRow(int expectedLC, int logRowLSindex, int expectedRS, int logRowRSindex) {
        log.get(logRowLSindex - 1).shouldHave(Condition.text("Range 2(From):" + expectedLC + " link clicked"));
        log.get(logRowRSindex - 1).shouldHave(Condition.text("Range 2(To):" + expectedRS + " link clicked"));
    }
}
