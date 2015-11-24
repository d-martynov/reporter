package ru.dmartynov.reporter.models;

import java.util.List;

/**
 * Created by d.martynov on 23.11.2015.
 */
public class Service {
    private Long targetCode;
    private Long formCode;
    private Category category;
    private List<Subservice> subservices;

    public Service() {
    }

    public Long getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(Long targetCode) {
        this.targetCode = targetCode;
    }

    public Long getFormCode() {
        return formCode;
    }

    public void setFormCode(Long formCode) {
        this.formCode = formCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Subservice> getSubservices() {
        return subservices;
    }

    public void setSubservices(List<Subservice> subservices) {
        this.subservices = subservices;
    }
}
