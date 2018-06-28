package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter@ObjectProp("课程安排明细")
public class ClassCourseManageItem {
    private Long id;
    @ObjectProp("日期")
    @JsonFormat( pattern ="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date date;
    @ObjectProp("星期")
    private Integer weekday;
    @ObjectProp("班级")
    private Classroom classGrade;
    @ObjectProp("课程名称")
    private String courseName;
    @ObjectProp("班主任")
    private Employee gradeTeacher;
    @ObjectProp("上课老师")
    private Employee courseTeacher;
    @ObjectProp("教室")
    private ClassRoomManage classroomManage;
    @ObjectProp("备注")
    private String remark;
    @ObjectProp("状态")
    private Integer state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Classroom getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(Classroom classGrade) {
        this.classGrade = classGrade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Employee getGradeTeacher() {
        return gradeTeacher;
    }

    public void setGradeTeacher(Employee gradeTeacher) {
        this.gradeTeacher = gradeTeacher;
    }

    public Employee getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Employee courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public ClassRoomManage getClassroomManage() {
        return classroomManage;
    }

    public void setClassroomManage(ClassRoomManage classroomManage) {
        this.classroomManage = classroomManage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
