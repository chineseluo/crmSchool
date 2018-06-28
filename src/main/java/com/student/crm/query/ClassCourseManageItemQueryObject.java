package com.student.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ClassCourseManageItemQueryObject extends QueryObject {


 private Long courseTeacherId;
 private Long roomId;
 private Long classId;
 private String date;
 private String beginDate;
 private String endDate;
 private Long classroomNameId;
}
