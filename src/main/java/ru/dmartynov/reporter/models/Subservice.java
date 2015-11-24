package ru.dmartynov.reporter.models;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Subservice {
    private Long targetCode;
    private String name;

    public Subservice() {
    }

    public Long getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(Long targetCode) {
        this.targetCode = targetCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
