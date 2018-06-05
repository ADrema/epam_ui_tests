package com.epam.ui.enumObjects.common;

public enum ServiceTabOptions {
    SUPPORT("Support", "https://epam.github.io/JDI/support.html"),

    DATES("Dates", "https://epam.github.io/JDI/dates.html"),

    COMPLEXTABLE("Complex Table", "https://epam.github.io/JDI/complex-table.html"),

    SIMPLETBLE("Simple Table", "https://epam.github.io/JDI/simple-table.html"),

    USERTABLE("User Table", "https://epam.github.io/JDI/user-table.html"),

    TABLESANDPAGES("Table with pages", "https://epam.github.io/JDI/table-pages.html"),

    DIFFERENTELEMENTS("Different elements", "https://epam.github.io/JDI/different-elements.html"),

    PERFORMANCE("Performance", "https://epam.github.io/JDI/performance.html");

    public String tabs;
    public String url;

    ServiceTabOptions(String tabs, String url) {
        this.tabs = tabs;
        this.url = url;
    }
}
