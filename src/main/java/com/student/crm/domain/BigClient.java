package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter@Setter
public class BigClient {
    private Long id;
    //学校名称
    private String school;
    //部门
    private String department;
    //简称1
    private String abbreviationOne;
    //简称2
    private String abbreviationTwo;
    //营销人员
    private Employee marketing;
    //跟进入员
    private Employee follow;
    //学校类型
    private String schoolType;
    //学历
    private String education;
    //地域
    private String region;
    //办学性质
    private String schoolProperties;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    //星级
    private String starLevel;
    //管理部门
    private String deptManage;
    //学制
    private String eductionalsystme;
    //地址
    private String address;
    //邮政编号
    private String postalCode;
    //电话
    private String phone;
    //传真
    private String fax;
    //邮箱
    private String email;
    //主页
    private String homepage;
    //校长
    private String principal;
    //员工数
    private Integer employeeNumber;
    //老师数
    private Integer teacherNumber;
    //在校人数
    private Integer inSchoolNumber;
    //IT专业人数
    private Integer itNumber;
    //合作高样
    private boolean cooperationSchool;
    //签约数
    private Integer signNumber;
    //热点等级
    private String hotspotLevel;
    //热点描述
    private String hotspotDescribe;
    //学校简介
    private String schoolInfo;
    //联系人
    private List<Linkman> linkman=new ArrayList<>();
    //实训次数
    private List<Train> trains=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAbbreviationOne() {
        return abbreviationOne;
    }

    public void setAbbreviationOne(String abbreviationOne) {
        this.abbreviationOne = abbreviationOne;
    }

    public String getAbbreviationTwo() {
        return abbreviationTwo;
    }

    public void setAbbreviationTwo(String abbreviationTwo) {
        this.abbreviationTwo = abbreviationTwo;
    }

    public Employee getMarketing() {
        return marketing;
    }

    public void setMarketing(Employee marketing) {
        this.marketing = marketing;
    }

    public Employee getFollow() {
        return follow;
    }

    public void setFollow(Employee follow) {
        this.follow = follow;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchoolProperties() {
        return schoolProperties;
    }

    public void setSchoolProperties(String schoolProperties) {
        this.schoolProperties = schoolProperties;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    public String getDeptManage() {
        return deptManage;
    }

    public void setDeptManage(String deptManage) {
        this.deptManage = deptManage;
    }

    public String getEductionalsystme() {
        return eductionalsystme;
    }

    public void setEductionalsystme(String eductionalsystme) {
        this.eductionalsystme = eductionalsystme;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Integer teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public Integer getInSchoolNumber() {
        return inSchoolNumber;
    }

    public void setInSchoolNumber(Integer inSchoolNumber) {
        this.inSchoolNumber = inSchoolNumber;
    }

    public Integer getItNumber() {
        return itNumber;
    }

    public void setItNumber(Integer itNumber) {
        this.itNumber = itNumber;
    }

    public boolean isCooperationSchool() {
        return cooperationSchool;
    }

    public void setCooperationSchool(boolean cooperationSchool) {
        this.cooperationSchool = cooperationSchool;
    }

    public Integer getSignNumber() {
        return signNumber;
    }

    public void setSignNumber(Integer signNumber) {
        this.signNumber = signNumber;
    }

    public String getHotspotLevel() {
        return hotspotLevel;
    }

    public void setHotspotLevel(String hotspotLevel) {
        this.hotspotLevel = hotspotLevel;
    }

    public String getHotspotDescribe() {
        return hotspotDescribe;
    }

    public void setHotspotDescribe(String hotspotDescribe) {
        this.hotspotDescribe = hotspotDescribe;
    }

    public String getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(String schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public List<Linkman> getLinkman() {
        return linkman;
    }

    public void setLinkman(List<Linkman> linkman) {
        this.linkman = linkman;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}