package com.mylib.hyz.libblog.utils.getItem;

public class GetCheckLoginItem {

    /**
     * success : true
     * code : 2003
     * message : 获取用户成功
     * data : {"id":"766394825724395520","userName":"小惠","password":null,"roles":"role_admin","avatar":"/portal/image/get/XH*&&*1614827138230_816989762320596992.png","email":"mylibhyz@163.com","sign":"明天你好鸭哈","state":null,"createTime":null,"updateTime":null,"login_ip":null,"reg_ip":null}
     */

    private boolean success;
    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 766394825724395520
         * userName : 小惠
         * password : null
         * roles : role_admin
         * avatar : /portal/image/get/XH*&&*1614827138230_816989762320596992.png
         * email : mylibhyz@163.com
         * sign : 明天你好鸭哈
         * state : null
         * createTime : null
         * updateTime : null
         * login_ip : null
         * reg_ip : null
         */

        private String id;
        private String userName;
        private Object password;
        private String roles;
        private String avatar;
        private String email;
        private String sign;
        private Object state;
        private Object createTime;
        private Object updateTime;
        private Object login_ip;
        private Object reg_ip;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getLogin_ip() {
            return login_ip;
        }

        public void setLogin_ip(Object login_ip) {
            this.login_ip = login_ip;
        }

        public Object getReg_ip() {
            return reg_ip;
        }

        public void setReg_ip(Object reg_ip) {
            this.reg_ip = reg_ip;
        }
    }
}
