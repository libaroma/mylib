package com.mylib.hyz.libblog.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.mylib.hyz.libblog.utils.LogUtils;
import com.mylib.hyz.libblog.utils.creater.HomeTabArticlePageCreator;
import com.mylib.hyz.libblog.utils.getItem.GetCategoryItem;

import java.util.List;

public class MainContentAdapter extends PagerAdapter {
    public static final String TAG = "MainContentAdapter";
    private List<GetCategoryItem.DataBean> mDataList;
    private int mTheme;

    public MainContentAdapter(List<GetCategoryItem.DataBean> dataList,int theme) {
        mDataList=dataList;
        mTheme=theme;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtils.d(TAG, String.valueOf(container.getChildCount()));
        return HomeTabArticlePageCreator.getArticlePage(container, position, mDataList.get(position).getId(),mTheme);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        TextView textView = (TextView) object;
        String text = textView.getText().toString();
        int index = mDataList.indexOf(text);
        if (index >= 0) {
            return index;
        }
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position).getCategoryName();
    }
}

