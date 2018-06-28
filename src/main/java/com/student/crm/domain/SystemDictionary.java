package com.student.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter
public class SystemDictionary {
    private Long id;

    private String sn;

    private String name;

    private String intro;

    private List<SystemDictionaryItem> items = new ArrayList<>();

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<SystemDictionaryItem> getItems() {
        return items;
    }

    public void setItems(List<SystemDictionaryItem> items) {
        this.items = items;
    }
}