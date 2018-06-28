package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter@Getter
public class PotentialCustom {
    public static final Long POOL_CUSTOM = -1L ; // 放入客户池的学员
    public static final Long EXAM_REGISTER = 0L ; // 等级考试的学员和潜在的客户

    public static final Long FORMAL_CUSTOM = 1L ; // 正式的学员
    public static final Long UP_TO_CLASS = 2L ; // 升班
    public static final Long DOWN_TO_CLASS = 3L ; // 流级
    public static final Long LOSS_STATE = 4L ; // 学员流失
    public static final Long STUDENT_DROP_OUT = 5L ; // 学员休学


    private Long id;

    private String name;

    private Integer age;

    private String weChat;

    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date buildFileTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date inputTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date vistitTime;

    private SystemDictionaryItem education; // 学历

    private SystemDictionaryItem workYear;

    private Classroom intentionClass;

    private SystemDictionaryItem clientType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date collegeEnrolTime;

    private SystemDictionaryItem intentionSubject;

    private String careQuestion;

    private String remark;

    private Employee marketingMan;// 销售人员

    private SystemDictionaryItem intentionSchoolRegion;

    private SystemDictionaryItem source;

    private String qq;

    private String gender;

    private String schoolOrTrainOrganization;

    private String profession;

    private SystemDictionaryItem intentionLevel;

    private Employee otherMarketingMan;

    private String collegeClass;

    private Employee inputMan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextFollowUpTime;

    private String telephone;

    private String email;

    private BigClient schoolClient;// 学校大客户

    private SystemDictionaryItem region;

    private String introducer;

    private SystemDictionaryItem currentState;

    private Boolean bringComputer;

    private Boolean zeroPay;

    private SystemDictionaryItem collegeEnglishTest;

    private SystemDictionaryItem payWay;

    private String currentHouseAddress;

    private String familyAddress;
    private String registeredAddress;

    private String otherLevel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date trainStartTime;

    private Classroom selectClass;  // 班级的基本的信息

    private Long planTuition; // 计划的学费

    private Long trainTuition; // 培训的学费

    private String discountInstruction;//  优惠的说明

    private Long defraiedTuition; //已付款的学费
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date previousUrgeTime;//上次的催款的时间

    private Boolean completePay; // 是否已经全额付款了

    private SystemDictionaryItem discountWay;// 优惠的方式

    private Long otherTuition;

    private Long totalTuition;

    private Long dueTuition;// 还欠的学费
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextUrgeTime; // 下次催款的时间

    private Long discountAmount; // 优惠的金额

    private Long otherDiscount; // 其他的优惠

    private String marketStream; // 销售的流水
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date finalPayTime; // 最后的付款的时间

    private Integer urgePayTimes;// 催款的次数

    private String headPortrait; // 照片

    private String idCardNumber;  // 身份证号码

    private String urgentLinkMan; // 紧急的联系人

    private String urgentTelephone;// 紧急的联系电话

    private String idCardCopies; // 身份证复印件

    private String degreeCertificateCopies; // 学位证复硬件

    private String workExperience; // 工作的经历

    private Classroom currentClass;

    private Classroom beforeClass;

    private Classroom flowClass;

    private Long studentState;//  表示学员的状态   这里的状态 需要上面直接的常量

    private SystemDictionaryItem payState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date enrolTime;// 入学的时间
    //通知状态
    private Integer inform=0;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lossTime;// 流失的时间

    private Long fatalisminSchool; // 上课的天数

    private String losssTage;  // 流失的阶段

    private String lossCause; // 流失的原因

    private Employee handlerPerson;

    private Boolean refundment;

}