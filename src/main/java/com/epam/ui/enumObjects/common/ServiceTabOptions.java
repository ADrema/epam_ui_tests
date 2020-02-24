package com.epam.ui.enumObjects.common;

import java.util.ArrayList;
import java.util.List;

public enum ServiceTabOptions {
    SUPPORT("Support", "https://epam.github.io/JDI/support.html"),
    DATES("Dates", "https://epam.github.io/JDI/dates.html"),
    COMPLEX_TABLE("Complex Table", "https://epam.github.io/JDI/complex-table.html"),
    SIMPLE_TABLE("Simple Table", "https://epam.github.io/JDI/simple-table.html"),
    USER_TABLE("User Table", "https://epam.github.io/JDI/user-table.html"),
    TABLES_AND_PAGES("Table with pages", "https://epam.github.io/JDI/table-pages.html"),
    DIFFERENT_ELEMENTS("Different elements", "https://epam.github.io/JDI/different-elements.html"),
    PERFORMANCE("Performance", "https://epam.github.io/JDI/performance.html");

    public String name;
    public String url;

    ServiceTabOptions(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public static List<String> getLinkNames() {
        List<String> container = new ArrayList<String>();
        for (ServiceTabOptions option : values()) {
            container.add(option.name);
        }
        return container;
    }
}
