package com.mylib.hyz.libblog.utils.getItem;

public class GetLoginItem {

    /**
     * success : true
     * code : 2999
     * message : 登录成功
     * data : m_a907a290e03ea2065dc9ff536e119c912lib3766394825724395520
     */

    private boolean success;
    private int code;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
