package com.epam.ui.enumObjects.homePage;

public enum  TextsUnderImagesEnum {

        PRACTISE("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
        CUSTOM("To be flexible and\n" + "customizable"),
        MULTIPLATFORM("To be multiplatform"),
        BASE("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…");

    public String textValue;

    TextsUnderImagesEnum(String textValue) {
        this.textValue = textValue;
    }
}
