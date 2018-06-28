package com.student.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter@Getter
public class NetDisc {
    public static final int SHARE_YES=1;
    public static final int SHARE_NO=0;
    //文件id
    private Long id;
    //文件名称
    private String text;
    //文件大小
    private Long size;
    //图标
    private String iconCls="icon-folder";
//    private String state ="closed";
    //类型
    private Type type;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //上传时间
    private Date uploadTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //共享时间
    private Date shareTime;
    //用户
    private Employee user;
    //共享状态
    private int share= NetDisc.SHARE_NO;
    //父目录
    private Long parentId;
    //子目录
    private List<NetDisc> children=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<NetDisc> getChildren() {
        return children;
    }

    public void setChildren(List<NetDisc> children) {
        this.children = children;
    }
}