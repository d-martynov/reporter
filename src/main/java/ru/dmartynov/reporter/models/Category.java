package ru.dmartynov.reporter.models;

/**
 * Created by d.martynov on 23.11.2015.
 */
public enum Category {
    ORGANISATION("ЮЛ"),
    PERSONAL("ФЛ"),
    ENTREPRENEUR("ИП");

    private final String readableName;

    Category(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
