package com.mylib.hyz.libblog.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.mylib.hyz.libblog.Base.BaseFragment;
import com.mylib.hyz.libblog.R;

public class HomeArticleFragment extends BaseFragment {
    public HomeArticleFragment(String title) {
        getFragmentManager().beginTransaction().add(new Fragment(), title).commit();
        return;
    }

    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        View home = inflater.inflate(R.layout.fragment_home_article, container, false);
        return home;
    }
}
