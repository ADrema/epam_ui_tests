package com.epam.ui.enumObjects.common;

public enum MainPages {
    HOMEPAGE("Home Page", "https://epam.github.io/JDI/index.html"),
    CONTACTFORM("Contact Form", "https://epam.github.io/JDI/contacts.html"),
    MATALSANDCOLORS("Metal and Colors", "https://epam.github.io/JDI/metals-colors.html");

    public String title;
    public String url;

    MainPages(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
