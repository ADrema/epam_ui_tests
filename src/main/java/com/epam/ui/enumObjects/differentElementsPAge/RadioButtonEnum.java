package com.epam.ui.enumObjects.differentElementsPAge;

public enum RadioButtonEnum {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String textValue;

    RadioButtonEnum(String textValue) {
        this.textValue = textValue;
    }

    public String getLocator() {
        switch (this) {
            case GOLD:
                return (".checkbox-row label:nth-child(1) input[type='radio']");
            case SILVER:
                return (".checkbox-row label:nth-child(2) input[type='radio']");
            case BRONZE:
                return (".checkbox-row label:nth-child(3) input[type='radio']");
            case SELEN:
                return (".checkbox-row label:nth-child(4) input[type='radio']");
            default:
                return null;
        }

    }

}
