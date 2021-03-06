package com.mylib.hyz.libblog.utils;

public interface Constance {
    interface Url{
        String BASE_DOMAIN = "https://blog.hyz.cool";
        String BASE_SERVER_URL = "http://39.101.136.216:2020";
        String GET_CAPTCHA = BASE_SERVER_URL+"/user/captcha?captchaKey=";
        String CATEGORY = BASE_SERVER_URL+"/portal/website/categories";
        String QR_CODE = BASE_SERVER_URL+"/user/pc-login_day-qr-code/";
        String LOGIN = BASE_SERVER_URL+"/user/login/";
        String CHECK_LOGIN = BASE_SERVER_URL+"/user/check/android/";
        String CHECK_LOGIN_STATE = BASE_SERVER_URL+"/user/qr-code-state/";
        String UPDATE_QR_STATE = BASE_SERVER_URL+"/user/update-qr-code-state/android/";
        String TOP_ARTICLE = BASE_SERVER_URL+"/portal/article/top";
        String ARTICLE = BASE_SERVER_URL+"/portal/article/list/";
        String CATEGORY_ARTICLE = BASE_SERVER_URL+"/portal/article/list/category/";
    }
    interface Code{
        int LOGIN_SUCCESS_CODE =2999;
        int IS_LOGIN =2003;
        int CODE_WAITING_FOR_SCAN =4023;
        int CODE_QR_TIMEOUT =4020;
        int GET_CATEGORY_ARTICLE_SUCCESS =2019;
    }
    interface RequestMethod{
        String GET = "GET";
        String POST = "POST";
        String PUT = "PUT";
        String DELETE = "DELETE";
    }
    interface Key{
        String KEY_TOKEN_KEY ="key_token_key";
        String KEY_THEME_KEY ="key_theme_key";
        String KEY_QR_CODE ="key_qr_code";
    }
    interface Name{
        String SETTING_FILE_NAME="settings.info";
    }
}
