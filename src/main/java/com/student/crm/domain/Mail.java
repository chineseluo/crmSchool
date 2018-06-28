package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class Mail {
    private List<String> employee;
    private List<String> potential;
    private String title;
    private String contents;

    public List<String> getEmployee() {
        return employee;
    }

    public void setEmployee(List<String> employee) {
        this.employee = employee;
    }

    public List<String> getPotential() {
        return potential;
    }

    public void setPotential(List<String> potential) {
        this.potential = potential;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
