package com.mylib.hyz.libblog.adapter;

import android.content.Context;
import android.view.View;

import com.mylib.hyz.libblog.R;
import com.mylib.hyz.libblog.utils.ResourcesUtils;
import com.mylib.hyz.libblog.utils.getItem.GetCategoryItem;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

public class IndicatorAdapter extends CommonNavigatorAdapter {
    private static final String TAG = "IndicatorAdapter";
    private final List<GetCategoryItem.DataBean> mDataList ;
    private final int mColorTextNormal;
    private final int mColorTextSelect;
    private final int mColorIndicator;
    private OnIndicateTabClickListener mOnTabClickListener;

    public IndicatorAdapter(Context context, List<GetCategoryItem.DataBean> dataList) {
        mDataList = dataList;
        mColorTextNormal = ResourcesUtils.getColorValue(context, R.attr.custom_attr_text_color);
        mColorTextSelect = ResourcesUtils.getColorValue(context, R.attr.custom_attr_text_select_color);
        mColorIndicator = ResourcesUtils.getColorValue(context, R.attr.custom_attr_indicator_color);
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size() ;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setText(mDataList.get(index).getCategoryName());
        simplePagerTitleView.setNormalColor(mColorTextNormal);
        simplePagerTitleView.setSelectedColor(mColorTextSelect);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnTabClickListener != null) {
                    mOnTabClickListener.onTabClick(index);
                }
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setColors(mColorIndicator);
        return indicator;
    }

    public void setOnIndicateTabClickListener(OnIndicateTabClickListener listener) {
        this.mOnTabClickListener = listener;
    }

    public interface OnIndicateTabClickListener {
        void onTabClick(int position);
    }

    ;
}
