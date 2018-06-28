package com.student.crm.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter@ObjectProp("教室设置")
public class ClassRoomManage {
    private Long id;
    @ObjectProp("名称")
    private String name;
    @ObjectProp("地址")
    private String address;
    @ObjectProp("座位数")
    private Integer seatNumber;
    @ObjectProp("状态")
    private int state;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
