package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    private int expectedCoordinate;

    @FindBy(how = How.CSS, using = ".range-from input")
    private ElementsCollection rangeForms;

    @FindBy(how = How.CSS, using = ".uui-slider.range .ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(how = How.CSS, using = ".uui-slider")
    private SelenideElement sliderBar;

    @FindBy(how = How.CSS, using = ".panel-body-list.logs li:nth-child(1)")
    private static SelenideElement lastLogRecord;

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

    public static void additionalClickRightBorder(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementL, diffL, 0).perform();
        elementL.click();
        lastLogRecord.shouldHave(Condition.text("Range 2(From):" + expectedL + " link clicked"));
        actions().dragAndDropBy(elementR, diffR, 0).perform();
        lastLogRecord.shouldHave(Condition.text("Range 2(To):" + expectedR + " link clicked"));
    }

    public static void reverseSteps(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementR, diffR, 0).perform();
        lastLogRecord.shouldHave(Condition.text("Range 2(To):" + expectedR + " link clicked"));
        actions().dragAndDropBy(elementL, diffL, 0).perform();
        lastLogRecord.shouldHave(Condition.text("Range 2(From):" + expectedL + " link clicked"));
    }

    public static void directSteps(SelenideElement elementL, int diffL, int expectedL, SelenideElement elementR, int diffR, int expectedR) {
        actions().dragAndDropBy(elementL, diffL, 0).perform();
        lastLogRecord.shouldHave(Condition.text("Range 2(From):" + expectedL + " link clicked"));

        actions().dragAndDropBy(elementR, diffR, 0).perform();
        lastLogRecord.shouldHave(Condition.text("Range 2(To):" + expectedR + " link clicked"));
    }

}
