package com.epam.ui.enumObjects.differentElementsPage;

public enum CheckBoxesEnum {
    WATER(0),
    EARTH(1),
    WIND(2),
    FIRE(3);

    public int index;

    CheckBoxesEnum(int index) {
        this.index = index;
    }

    public static String getTextValue(int index) {
        switch (index) {
            case 0:
                return "Water";
            case 1:
                return "Earth";
            case 2:
                return "Wind";
            case 3:
                return "Fire";
            default:
                return null;
        }
    }
}


