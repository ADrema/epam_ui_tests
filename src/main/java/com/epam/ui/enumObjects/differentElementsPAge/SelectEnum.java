package com.epam.ui.enumObjects.differentElementsPAge;

public enum SelectEnum {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    public String textValue;

    SelectEnum(String textValue) {
        this.textValue = textValue;
    }

    public String getLocator() {
        switch (this) {
            case RED:
                return (".main-content-hg .colors select option:nth-child(1)");
            case GREEN:
                return (".main-content-hg .colors select option:nth-child(2)");
            case BLUE:
                return (".main-content-hg .colors select option:nth-child(3)");
            case YELLOW:
                return (".main-content-hg .colors select option:nth-child(4)");
            default:
                return null;
        }
    }
}
