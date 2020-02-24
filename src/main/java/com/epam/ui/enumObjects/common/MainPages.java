package com.epam.ui.enumObjects.common;

public enum MainPages {
//    TODO: Check spelling
    HOMEPAGE("Home Page", "https://epam.github.io/JDI/index.html"),
    CONTACTF_ORM("Contact Form", "https://epam.github.io/JDI/contacts.html"),
    MATALS_AND_COLORS("Metal and Colors", "https://epam.github.io/JDI/metals-colors.html"),
    USER_TABLE("User Table", "https://epam.github.io/JDI/user-table.html");


    public String title;
    public String url;

    MainPages(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
