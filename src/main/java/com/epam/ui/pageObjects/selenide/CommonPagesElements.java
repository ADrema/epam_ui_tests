package com.epam.ui.pageObjects.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CommonPagesElements {

    @FindBy(how = How.CSS, using = "title")
    public SelenideElement title;

    @FindBy(how = How.CSS, using = ".uui-side-bar[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(how = How.TAG_NAME, using = "footer")
    private SelenideElement footer;

    @FindBy(className = "profile-photo")
    private SelenideElement profileIcon;
}
