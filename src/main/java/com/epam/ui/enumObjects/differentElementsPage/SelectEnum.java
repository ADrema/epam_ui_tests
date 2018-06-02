package com.epam.ui.enumObjects.differentElementsPage;

public enum SelectEnum {
    RED(0),
    GREEN(1),
    BLUE(2),
    YELLOW(3);

    public int index;

    SelectEnum(int index) {
        this.index = index;
    }

    public  static String getTextValue(int index) {
        switch (index) {
            case 0:
                return "Red";
            case 1:
                return "Green";
            case 2:
                return "Blue";
            case 3:
                return "Yellow";
            default:
                return null;
        }
    }
}
