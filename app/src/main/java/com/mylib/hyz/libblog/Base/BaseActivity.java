package com.mylib.hyz.libblog.Base;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.mylib.hyz.libblog.R;
import com.mylib.hyz.libblog.utils.TextUtils;

import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_THEME_KEY;
import static com.mylib.hyz.libblog.utils.Constance.Key.KEY_TOKEN_KEY;
import static com.mylib.hyz.libblog.utils.Constance.Name.SETTING_FILE_NAME;

public class BaseActivity extends FragmentActivity {
    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(getThemeFromLocal());
        super.onCreate(savedInstanceState);
    }

    public String getTokenKey() {
        SharedPreferences sp = getSharedPreferences(SETTING_FILE_NAME, MODE_PRIVATE);
        String tokenKey = sp.getString(KEY_TOKEN_KEY, "");
        if (TextUtils.isEmpty(tokenKey)) {
            return null;
        }
        return tokenKey;
    }

    public int getThemeFromLocal() {
        SharedPreferences sp = getSharedPreferences(SETTING_FILE_NAME, MODE_PRIVATE);
        int theme = sp.getInt(KEY_THEME_KEY, R.style.AppTheme_Day);
        if (theme != R.style.AppTheme_Day && theme != R.style.AppTheme_Dark) {
            theme = R.style.AppTheme_Dark;
        }
        return theme;
    }

}
