package com.mylib.hyz.libblog;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.mylib.hyz.libblog.Base.BaseActivity;
import com.mylib.hyz.libblog.utils.HttpService;
import com.mylib.hyz.libblog.utils.IdWorker;
import com.mylib.hyz.libblog.utils.LogUtils;
import com.mylib.hyz.libblog.utils.TextUtils;
import com.mylib.hyz.libblog.utils.getItem.GetCheckLoginItem;
import com.mylib.hyz.libblog.utils.getItem.GetLoginItem;
import com.mylib.hyz.libblog.utils.getItem.GetQrCodeItem;
import com.mylib.hyz.libblog.utils.getItem.GetUserItem;
import com.squareup.picasso.Picasso;

import static com.mylib.hyz.libblog.utils.Constance.Code.IS_LOGIN;
import static com.mylib.hyz.libblog.utils.Constance.Code.LOGIN_SUCCESS_CODE;
import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_TOKEN_KEY;
import static com.mylib.hyz.libblog.utils.Constance.Name.SETTING_FILE_NAME;
import static com.mylib.hyz.libblog.utils.Constance.Url.CHECK_LOGIN;
import static com.mylib.hyz.libblog.utils.Constance.Url.GET_CAPTCHA;
import static com.mylib.hyz.libblog.utils.Constance.Url.LOGIN;
import static com.mylib.hyz.libblog.utils.Constance.Url.QR_CODE;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private EditText mCaptchaCode;
    private ImageView mCaptchaImage;
    private Handler mMainHandler;
    private IdWorker mIdWorker = new IdWorker();
    private HttpService http = new HttpService();
    private String captchaKey = "";
    private EditText mUserName;
    private EditText mPassword;
    private TextView mLogin;
    private TextView mSignUp;
    private TextView mForgotPassword;
    private SharedPreferences mMsp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mMainHandler = new Handler(getBaseContext().getMainLooper());
        init();
    }

    private void init() {
        getCaptchaKey();
        initView();
        initListener();
        getCaptcha();
        try {
            String tokenKey = getTokenKey();
            String responseStr = http.requestGet(CHECK_LOGIN + tokenKey);
            final GetCheckLoginItem checkLoginItem = new Gson().fromJson(responseStr, GetCheckLoginItem.class);
            if (checkLoginItem != null) {
                if (checkLoginItem.getCode() == IS_LOGIN) {
                    Toast.makeText(this, "已经登陆过啦！", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getCaptchaKey() {
        captchaKey = mIdWorker.nextId() + "";
    }

    private void initView() {
        mUserName = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
        mCaptchaCode = findViewById(R.id.captcha_code);
        mCaptchaImage = findViewById(R.id.captcha_image);
        mLogin = findViewById(R.id.login);
        mSignUp = findViewById(R.id.sign_up);
        mForgotPassword = findViewById(R.id.forget_password);
    }

    private void initListener() {
        if (mCaptchaImage != null) {
            mCaptchaImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getCaptcha();
                }
            });
        }
        if (mLogin != null) {
            mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        doLogin();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (mSignUp != null) {
            mSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        loadQrCodeImage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (mForgotPassword != null) {
            mForgotPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        if (mCaptchaImage != null) {
            mCaptchaImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getCaptcha();
                }
            });
        }
    }

    private void getCaptcha() {
        int code = (int) (Math.random() * 100000000);
        String flag = String.valueOf(code);
        if (flag.length() == 8 && flag.substring(0, 1).equals("9")) {
            System.out.println(code);
        } else {
            code = code + 10000000;
        }
        final String urlAddress = GET_CAPTCHA + captchaKey + "&r=" + code;
        if (mCaptchaImage != null) {
            Picasso.with(this).load(urlAddress).into(mCaptchaImage);
        }
    }


    private void doLogin() throws Exception {
        String userName = "";
        if (mUserName != null) {
            userName = String.valueOf(mUserName.getText());
            if (TextUtils.isEmpty(userName)) {
                Toast.makeText(this, "用户名为空！", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            return;
        }
        String password = "";
        if (mPassword != null) {
            password = String.valueOf(mPassword.getText());
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "密码为空！", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            return;
        }
        String captchaText = "";
        if (mCaptchaCode != null) {
            captchaText = String.valueOf(mCaptchaCode.getText());
            if (TextUtils.isEmpty(captchaText)) {
                Toast.makeText(this, "验证码为空！", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            return;
        }
        GetUserItem libUser = new GetUserItem();
        libUser.setUserName(userName);
        libUser.setPassword(password);
        String libUserStr = new Gson().toJson(libUser);
        String responseStr = http.requestPost(LOGIN + captchaText + "/" + captchaKey + "?from=m_", libUserStr);
        LogUtils.d(TAG, "responseStr -- >" + responseStr);
        GetLoginItem loginItem = new Gson().fromJson(responseStr, GetLoginItem.class);
        if (loginItem == null) {
            Toast.makeText(this, "response为空！", Toast.LENGTH_SHORT).show();
            return;
        } else if (loginItem.getCode() == LOGIN_SUCCESS_CODE) {
            Toast.makeText(this, loginItem.getMessage() + "", Toast.LENGTH_SHORT).show();
            mMsp = this.getSharedPreferences(SETTING_FILE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor edit = mMsp.edit();
            LogUtils.d(TAG, "loginItem.getData().toString() -- >" + loginItem.getData().toString());
            edit.putString(KEY_TOKEN_KEY, loginItem.getData().toString());
            edit.commit();
            String tokenKey = mMsp.getString(KEY_TOKEN_KEY, "");
            LogUtils.d(TAG, "tokenKey -- >" + tokenKey);
        } else {
            Toast.makeText(this, loginItem.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void loadQrCodeImage() throws Exception {
        String responseStr = http.requestGet(QR_CODE);
        final GetQrCodeItem qrCodeItem = new Gson().fromJson(responseStr, GetQrCodeItem.class);
        if (qrCodeItem == null) {
            Toast.makeText(this, "response为空！", Toast.LENGTH_SHORT).show();
            return;
        } else if (qrCodeItem.getCode() == 2011) {
            if (mCaptchaImage != null) {
                final String imgUrl = qrCodeItem.getData().getUrl();
                //更新UI在主线程
                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(getBaseContext()).load(imgUrl).into(mCaptchaImage);
                    }
                };
                mMainHandler.post(myRunnable);
            }
        }
    }


}

