package com.mylib.hyz.libblog.utils.getItem;

import java.util.List;

public class GetArticleItem {

    /**
     * id : 816995205814157312
     * title : 博客数据表
     * userId : 766394825724395520
     * categoryId : 816468026143539200
     * type : 2
     * state : 1
     * coverImg : /portal/image/get/XH*&&*1613376732860_810906321120395264.png?mode=scale&scale=0.5
     * summary : 博客数据表思维导图
     * labels : 博客-数据表结构-思维导图
     * viewCount : 10
     * publishTime : 1614828436103
     * updateTime : 1614828436103
     * labelArr : ["博客","数据表结构","思维导图"]
     */

    private String id;
    private String title;
    private String userId;
    private String categoryId;
    private String type;
    private String state;
    private String coverImg;
    private String summary;
    private String labels;
    private int viewCount;
    private long publishTime;
    private long updateTime;
    private List<String> labelArr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public List<String> getLabelArr() {
        return labelArr;
    }

    public void setLabelArr(List<String> labelArr) {
        this.labelArr = labelArr;
    }
}
