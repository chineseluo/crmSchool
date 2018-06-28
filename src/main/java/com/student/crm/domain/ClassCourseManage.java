package com.student.crm.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter@ObjectProp("班级课程")
public class ClassCourseManage {
    private Long id;
    @ObjectProp("班级")
    private Classroom classroom;
    @ObjectProp("备注")
    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
