package com.mylib.hyz.libblog.utils.getItem;

public class GetQrCodeItem {

    /**
     * success : true
     * code : 2011
     * message : 获取成功！
     * data : {"code":"817181489295785984","url":"http://39.101.136.216:2020/portal/image/qr-code/817181489295785984"}
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
         * code : 817181489295785984
         * url : http://39.101.136.216:2020/portal/image/qr-code/817181489295785984
         */

        private String code;
        private String url;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
