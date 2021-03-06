package com.mylib.hyz.libblog.utils.getItem;

import java.util.List;

public class GetCategoryItem {

    /**
     * success : true
     * code : 2011
     * message : 获取成功！
     * data : [{"id":"1sdsds","categoryName":"文学","categoryPy":"wx","description":"文学","order":1,"state":"1","createTime":"2020-10-22T12:21:50.000+0000","updateTime":"2020-11-12T09:05:29.000+0000"},{"id":"767052595842777088","categoryName":"流行音乐","categoryPy":"lxyy","description":"很受年轻人喜欢的东西","order":1,"state":"1","createTime":"2020-10-17T07:53:10.000+0000","updateTime":"2020-11-10T07:07:13.000+0000"},{"id":"767053463698123456","categoryName":"安卓","categoryPy":"az","description":"编程语言，主流手机操作系统","order":1,"state":"1","createTime":"2020-10-31T07:56:37.000+0000","updateTime":"2020-11-12T12:30:18.000+0000"},{"id":"776549665410646016","categoryName":"米瑶留言","categoryPy":"myly","description":"米瑶留言小程序上线啦","order":1,"state":"1","createTime":"2020-11-12T12:51:08.000+0000","updateTime":"2020-11-12T12:51:08.000+0000"},{"id":"776572170389159936","categoryName":"计算机","categoryPy":"computer","description":"计算机技术","order":1,"state":"1","createTime":"2020-11-12T14:20:33.000+0000","updateTime":"2020-11-12T14:20:33.000+0000"},{"id":"776572327348404224","categoryName":"电影","categoryPy":"movie","description":"电影艺术","order":1,"state":"1","createTime":"2020-11-12T14:21:11.000+0000","updateTime":"2020-11-12T14:21:11.000+0000"},{"id":"776572450451226624","categoryName":"图片文章","categoryPy":"pic","description":"图片文章","order":1,"state":"1","createTime":"2020-11-12T14:21:40.000+0000","updateTime":"2020-11-12T14:21:40.000+0000"},{"id":"776572536145051648","categoryName":"英语学习","categoryPy":"english","description":"英语学习","order":1,"state":"1","createTime":"2020-11-12T14:22:01.000+0000","updateTime":"2020-11-12T14:22:01.000+0000"},{"id":"776572636531523584","categoryName":"小程序","categoryPy":"miniprogram","description":"小程序技术","order":1,"state":"1","createTime":"2020-11-12T14:22:25.000+0000","updateTime":"2020-11-12T14:22:25.000+0000"},{"id":"810918487890329600","categoryName":"ubuntu","categoryPy":"ubuntu","description":"关于Ubuntu的一些技巧","order":1,"state":"1","createTime":"2021-02-15T09:00:34.000+0000","updateTime":"2021-02-15T09:00:34.000+0000"},{"id":"810918775514726400","categoryName":"JavaScript","categoryPy":"JS","description":"一些JavaScript的技巧","order":1,"state":"1","createTime":"2021-02-15T09:01:42.000+0000","updateTime":"2021-02-15T09:01:42.000+0000"},{"id":"810918903940120576","categoryName":"Java","categoryPy":"Java","description":"一些Java的技巧","order":1,"state":"1","createTime":"2021-02-15T09:02:13.000+0000","updateTime":"2021-02-15T09:02:13.000+0000"},{"id":"810976279321903104","categoryName":"视频","categoryPy":"sp","description":"一些视频","order":1,"state":"1","createTime":"2021-02-15T12:50:12.000+0000","updateTime":"2021-02-15T12:50:12.000+0000"},{"id":"811628973199982592","categoryName":"诗歌","categoryPy":"sg","description":"我的一些故事","order":1,"state":"1","createTime":"2021-02-17T08:03:47.000+0000","updateTime":"2021-02-17T08:03:47.000+0000"},{"id":"811629071434776576","categoryName":"日记","categoryPy":"rj","description":"我的一些故事","order":1,"state":"1","createTime":"2021-02-17T08:04:10.000+0000","updateTime":"2021-02-17T08:04:10.000+0000"},{"id":"816468026143539200","categoryName":"思维导图","categoryPy":"swdt","description":"一些思维导图","order":1,"state":"1","createTime":"2021-03-02T16:32:27.000+0000","updateTime":"2021-03-02T16:32:27.000+0000"}]
     */

    private boolean success;
    private int code;
    private String message;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1sdsds
         * categoryName : 文学
         * categoryPy : wx
         * description : 文学
         * order : 1
         * state : 1
         * createTime : 2020-10-22T12:21:50.000+0000
         * updateTime : 2020-11-12T09:05:29.000+0000
         */

        private String id;
        private String categoryName;
        private String categoryPy;
        private String description;
        private int order;
        private String state;
        private String createTime;
        private String updateTime;
        public DataBean(String id,String name){
            this.id=id;
            this.categoryName=name;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryPy() {
            return categoryPy;
        }

        public void setCategoryPy(String categoryPy) {
            this.categoryPy = categoryPy;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
