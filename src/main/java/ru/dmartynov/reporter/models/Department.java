package ru.dmartynov.reporter.models;

import org.springframework.data.annotation.Id;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Department {
    private String name;
    @Id
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
