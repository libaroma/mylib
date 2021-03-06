package com.mylib.hyz.libblog;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.mylib.hyz.libblog.Base.BaseActivity;
import com.mylib.hyz.libblog.adapter.IndicatorAdapter;
import com.mylib.hyz.libblog.adapter.MainContentAdapter;
import com.mylib.hyz.libblog.utils.HttpService;
import com.mylib.hyz.libblog.utils.LogUtils;
import com.mylib.hyz.libblog.utils.TextUtils;
import com.mylib.hyz.libblog.utils.getItem.GetCategoryItem;
import com.mylib.hyz.libblog.utils.getItem.GetCheckLoginItem;
import com.squareup.picasso.Picasso;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.List;

import static com.mylib.hyz.libblog.utils.Constance.Code.IS_LOGIN;
import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_QR_CODE;
import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_THEME_KEY;
import static com.mylib.hyz.libblog.utils.Constance.Name.SETTING_FILE_NAME;
import static com.mylib.hyz.libblog.utils.Constance.Url.BASE_DOMAIN;
import static com.mylib.hyz.libblog.utils.Constance.Url.CATEGORY;
import static com.mylib.hyz.libblog.utils.Constance.Url.CHECK_LOGIN;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private ImageView mLogin;
    private ImageView mScan;
    private HttpService http = new HttpService();
    private String mResponseCategory;
    private List<GetCategoryItem.DataBean> mCategoryList =new ArrayList<>();
    private ViewPager mArticlePager;
    private MagicIndicator mMagicIndicator;
    private IndicatorAdapter mIndicatorAdapter;
    private boolean mIsLogin = false;
    private int mThemeFromLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mThemeFromLocal = getThemeFromLocal();
        initData();
        initView();
        initAccount();
        initListener();
    }


    private void initAccount() {
        String tokenKey = getTokenKey();
        String responseStr = null;
        try {
            responseStr = http.requestGet(CHECK_LOGIN + tokenKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final GetCheckLoginItem checkLoginItem = new Gson().fromJson(responseStr, GetCheckLoginItem.class);
        if (checkLoginItem != null) {
            if (checkLoginItem.getCode() == IS_LOGIN) {
                if (mLogin != null) {
                    mIsLogin = true;
                    LogUtils.d(TAG, " Picasso.with(this).load(BaseDomain+checkLoginItem.getData().getAvatar()).into(mLogin);");
                    Picasso.with(this).load(BASE_DOMAIN + checkLoginItem.getData().getAvatar()).into(mLogin);
                }
            } else {
                if (mThemeFromLocal == R.style.AppTheme_Dark && mLogin != null) {
                    mLogin.setImageResource(R.mipmap.login_dark);
                }
            }
        }

    }

    private boolean initPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            //否则去请求相机权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
            return false;
        }
    }


    private void initView() {

        mLogin = findViewById(R.id.login);
        mScan = findViewById(R.id.scan);
        if (mThemeFromLocal == R.style.AppTheme_Dark && mScan != null) {
            mScan.setImageResource(R.mipmap.scan_dark);
        }
        mArticlePager = findViewById(R.id.page_article);

        mMagicIndicator = findViewById(R.id.magic_indicator);

        //创建适配器
        mIndicatorAdapter = new IndicatorAdapter(this, mCategoryList);

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(mIndicatorAdapter);
        mMagicIndicator.setNavigator(commonNavigator);


        //创建适配器
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MainContentAdapter mainContentAdapter = new MainContentAdapter(mCategoryList,mThemeFromLocal);
        mArticlePager.setAdapter(mainContentAdapter);

        ViewPagerHelper.bind(mMagicIndicator, mArticlePager);


    }

    private void initListener() {
        if (mLogin != null) {
            mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIsLogin) {
                        SharedPreferences sp = getSharedPreferences(SETTING_FILE_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();
                        if (mThemeFromLocal == R.style.AppTheme_Dark) {
                            edit.putInt(KEY_THEME_KEY, R.style.AppTheme_Day);
                        } else {
                            edit.putInt(KEY_THEME_KEY, R.style.AppTheme_Dark);
                        }
                        edit.commit();
                        recreate();
                    } else {
                        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
        if (mScan != null) {
            mScan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (initPermission()) {
                        doScan();
                    }

                }
            });
        }
        if (mIndicatorAdapter != null) {
            mIndicatorAdapter.setOnIndicateTabClickListener(new IndicatorAdapter.OnIndicateTabClickListener() {
                @Override
                public void onTabClick(int position) {
                    if (mArticlePager != null) {
                        mArticlePager.setCurrentItem(position);
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String code = (String) bundle.get("qr_scan_result");
            if (TextUtils.isEmpty(code)) {
                Toast.makeText(this, "二维码无效或者过期", Toast.LENGTH_SHORT).show();
            }
            String[] split = code.split("===");
            if (split.length == 2) {
                code = code.split("===")[1];
                LogUtils.d(TAG, "code -->" + code);
                Intent intent = new Intent(this, ConfirmLoginActivity.class);
                intent.putExtra(KEY_QR_CODE, code);
                startActivity(intent);
            }

        } else {

        }
    }

    public void doScan() {
        // 二维码扫码
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    public void initData() {

        int page = 1, size = 10;
        try {
            mResponseCategory = http.requestGet(CATEGORY);
            if (!TextUtils.isEmpty(mResponseCategory)) {
                GetCategoryItem categoryItem = new Gson().fromJson(mResponseCategory, GetCategoryItem.class);
                mCategoryList.add(new GetCategoryItem.DataBean("all", "全部"));
                for (GetCategoryItem.DataBean dataBean : categoryItem.getData()) {
                    mCategoryList.add(dataBean);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}