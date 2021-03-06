package com.mylib.hyz.libblog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.mylib.hyz.libblog.Base.BaseActivity;
import com.mylib.hyz.libblog.utils.HttpService;
import com.mylib.hyz.libblog.utils.TextUtils;
import com.mylib.hyz.libblog.utils.getItem.GetCheckQrStateItem;

import static com.mylib.hyz.libblog.utils.Constance.Code.CODE_QR_TIMEOUT;
import static com.mylib.hyz.libblog.utils.Constance.Code.CODE_WAITING_FOR_SCAN;
import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_QR_CODE;
import static com.mylib.hyz.libblog.utils.Constance.Url.CHECK_LOGIN_STATE;
import static com.mylib.hyz.libblog.utils.Constance.Url.UPDATE_QR_STATE;

public class ConfirmLoginActivity extends BaseActivity {

    private String mCode;
    private HttpService http = new HttpService();
    private static final String TAG = "ConfirmLoginActivity";
    private TextView mConfirmBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        init();
    }

    private void init() {
        initView();
        initListener();
        Intent intent = getIntent();
        if (intent != null) {
            mCode = intent.getStringExtra(KEY_QR_CODE);
        }
        if (!TextUtils.isEmpty(mCode)) {
            doCheckQrCodeState();
        }
    }

    protected void initView() {
        mConfirmBtn = findViewById(R.id.confirm_btn);
    }

    protected void initListener() {
        if (mConfirmBtn != null) {
            mConfirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onConfirmBtnClick();
                }
            });
        }
    }

    private void doCheckQrCodeState() {
        try {
            String tokenKey = getTokenKey();
            Log.d(TAG, "tokenKey-->" + tokenKey);
            Log.d(TAG, "CHECK_LOGIN_STATE + mCode + \"/\" + tokenKey-->" + CHECK_LOGIN_STATE + mCode + "/" + tokenKey);
            String response = http.requestGet(CHECK_LOGIN_STATE + mCode + "/" + tokenKey);
            Log.d(TAG, "response-->" + response);
            if (!TextUtils.isEmpty(response)) {
                GetCheckQrStateItem qrStateItem = new Gson().fromJson(response, GetCheckQrStateItem.class);
                Log.d(TAG, "qrStateItem-->" + qrStateItem.getCode());
                if (qrStateItem.getCode() == CODE_WAITING_FOR_SCAN) {
                    if (mConfirmBtn != null) {
                        mConfirmBtn.setText("确认登陆");

                    }
                } else if (qrStateItem.getCode() == CODE_QR_TIMEOUT) {
                    Toast.makeText(this, "二维码已过期", Toast.LENGTH_SHORT).show();

                    if (mConfirmBtn != null) {

                        mConfirmBtn.setText("返回首页");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onConfirmBtnClick() {
        if (mConfirmBtn != null) {
            if (mConfirmBtn.getText().equals("确认登陆")) {
                doConfirmLogin();
            } else if (mConfirmBtn.getText().equals("返回首页")) {
                doBackHome();
            }
        }
    }


    private void doBackHome() {
        this.finish();
    }

    private void doConfirmLogin() {
        try {
            String tokenKey = getTokenKey();
            Log.d(TAG, "UPDATE_QR_STATE + mCode + \"/\" + tokenKey, \"\"" + UPDATE_QR_STATE + mCode + "/" + tokenKey);
            String response = http.requestPut(UPDATE_QR_STATE + mCode + "/" + tokenKey, "");
            if (!TextUtils.isEmpty(response)) {
                GetCheckQrStateItem confirmStateItem = new Gson().fromJson(response, GetCheckQrStateItem.class);
                if (confirmStateItem.getCode() == 2999) {
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                    if (mConfirmBtn != null) {
                        mConfirmBtn.setText("返回首页");
                    }
                }else {
                    Toast.makeText(this, confirmStateItem.getMessage(), Toast.LENGTH_SHORT).show();
                    if (mConfirmBtn != null) {
                        mConfirmBtn.setText("返回首页");
                    }
                }
            }
            Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

}
