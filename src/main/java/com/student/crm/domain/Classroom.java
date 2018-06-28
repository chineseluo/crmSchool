package com.student.crm.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@ObjectProp("班级管理")
public class Classroom {
    private Long id;
    @ObjectProp("班级名称")
    private String name;
    @ObjectProp("学院")
    private Institute institute;
    @ObjectProp("班主任")
    private Employee classTeacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Employee getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Employee classTeacher) {
        this.classTeacher = classTeacher;
    }
}