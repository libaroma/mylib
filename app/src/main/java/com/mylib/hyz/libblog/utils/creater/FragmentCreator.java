package com.mylib.hyz.libblog.utils.creater;

import com.mylib.hyz.libblog.Base.BaseFragment;
import com.mylib.hyz.libblog.fragments.HomeArticleFragment;

import java.util.Map;

public class FragmentCreator {
    private static Map<Integer, BaseFragment> sCache = null;

    public static BaseFragment getFragment(int position, String title) {
        BaseFragment baseFragment = sCache.get(position);
        if (baseFragment == null) {
            baseFragment = new HomeArticleFragment(title);
        }
        return baseFragment;

    }
}
