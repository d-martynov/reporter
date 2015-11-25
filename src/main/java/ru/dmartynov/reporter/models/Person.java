package ru.dmartynov.reporter.models;

import org.springframework.data.annotation.Id;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Person {
    @Id
    private String fullName;
    private Category category;

    public Person(String fullName, Category category) {
        this.fullName = fullName;
        this.category = category;
    }

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
