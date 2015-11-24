package ru.dmartynov.reporter.models;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Department {
    private String name;
    private Long departamentCode;

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartamentCode() {
        return departamentCode;
    }

    public void setDepartamentCode(Long departamentCode) {
        this.departamentCode = departamentCode;
    }
}
