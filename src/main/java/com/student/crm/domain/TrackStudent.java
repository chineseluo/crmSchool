package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter
public class TrackStudent {
    private Long id;
    // 跟踪的学原
    private PotentialCustom student;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextVisitTime;

    // 跟踪的目的
    private String trackAim;
    //咨询的方式
    private SystemDictionaryItem consultType;
    // 再要
    private String summary;
    // 交流的方式
    private SystemDictionaryItem talkType;

    private Long consultTime; // 咨询次数
    // 交流文件的截图
    private String fileAddress;
    // 交流的内柔
    private String talkContent;
    // 所属的学校
    private BigClient school;
    // 学校联系人
    private Long schoolLinkMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    // 跟踪的时间
    private Date trackTime;

    private Employee consultPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PotentialCustom getStudent() {
        return student;
    }

    public void setStudent(PotentialCustom student) {
        this.student = student;
    }

    public Date getNextVisitTime() {
        return nextVisitTime;
    }

    public void setNextVisitTime(Date nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
    }

    public String getTrackAim() {
        return trackAim;
    }

    public void setTrackAim(String trackAim) {
        this.trackAim = trackAim;
    }

    public SystemDictionaryItem getConsultType() {
        return consultType;
    }

    public void setConsultType(SystemDictionaryItem consultType) {
        this.consultType = consultType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SystemDictionaryItem getTalkType() {
        return talkType;
    }

    public void setTalkType(SystemDictionaryItem talkType) {
        this.talkType = talkType;
    }

    public Long getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(Long consultTime) {
        this.consultTime = consultTime;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent;
    }

    public BigClient getSchool() {
        return school;
    }

    public void setSchool(BigClient school) {
        this.school = school;
    }

    public Long getSchoolLinkMan() {
        return schoolLinkMan;
    }

    public void setSchoolLinkMan(Long schoolLinkMan) {
        this.schoolLinkMan = schoolLinkMan;
    }

    public Date getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    public Employee getConsultPerson() {
        return consultPerson;
    }

    public void setConsultPerson(Employee consultPerson) {
        this.consultPerson = consultPerson;
    }
}