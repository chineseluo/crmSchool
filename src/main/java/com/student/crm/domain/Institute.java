package com.student.crm.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;
//学院
@Getter@Setter@ObjectProp("学院")
public class Institute {
    private Long id;

    @ObjectProp("学院代码")
    private String sn;
    @ObjectProp("学院名称")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}