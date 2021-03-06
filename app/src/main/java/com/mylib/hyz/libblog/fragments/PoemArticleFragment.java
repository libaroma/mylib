package com.mylib.hyz.libblog.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mylib.hyz.libblog.Base.BaseFragment;
import com.mylib.hyz.libblog.R;

public class PoemArticleFragment extends BaseFragment {
    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        View home = inflater.inflate(R.layout.fragment_poem_article, container,false);
        return home;
    }
}
