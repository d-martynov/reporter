package ru.dmartynov.reporter.models;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Person {
    private String fullName;
    private Category category;

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
