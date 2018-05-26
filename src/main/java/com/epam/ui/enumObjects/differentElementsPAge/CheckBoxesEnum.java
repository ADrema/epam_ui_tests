package com.epam.ui.enumObjects.differentElementsPAge;

public enum CheckBoxesEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String textValue;

    CheckBoxesEnum(String textValue) {
        this.textValue = textValue;
    }

    public String getLocator() {
        switch (this) {
            case WATER:
                return (".checkbox-row label:nth-child(1) input[type='checkbox']");
            case EARTH:
                return (".checkbox-row label:nth-child(2) input[type='checkbox']");
            case WIND:
                return (".checkbox-row label:nth-child(3) input[type='checkbox']");
            case FIRE:
                return (".checkbox-row label:nth-child()4 input[type='checkbox']");
            default:
                return null;
        }
    }
}


