package com.mylib.hyz.libblog.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mylib.hyz.libblog.R;
import com.mylib.hyz.libblog.utils.getItem.GetArticleItem;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mylib.hyz.libblog.utils.Constance.Url.BASE_DOMAIN;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.InnerHolder> {
    private List<GetArticleItem> mData = new ArrayList<>();
    private int mTheme;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //载入View
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_view, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleListAdapter.InnerHolder holder, int position) {
        //封装数据
        holder.itemView.setTag(position);
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(GetArticleItem articleItem) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            //找到各个控件
            ImageView coverImg = itemView.findViewById(R.id.cover);
            ImageView timeImg = itemView.findViewById(R.id.time_icon);
            ImageView viewCountImg = itemView.findViewById(R.id.view_count_icon);
            TextView title = itemView.findViewById(R.id.title);
            TextView description = itemView.findViewById(R.id.description);
            TextView publishTime = itemView.findViewById(R.id.post_time);
            TextView viewCount = itemView.findViewById(R.id.view_count);
            TextView label1 = itemView.findViewById(R.id.label1);
            TextView label2 = itemView.findViewById(R.id.label2);
            if (coverImg != null) {
                Picasso.with(itemView.getContext()).load(BASE_DOMAIN + articleItem.getCoverImg()).into(coverImg);
            }
            if (mTheme == R.style.AppTheme_Dark) {
                if (timeImg != null) {
                    timeImg.setImageResource(R.mipmap.time_dark);
                }
                if (viewCountImg != null) {
                    viewCountImg.setImageResource(R.mipmap.view_dark);
                }
            }
            if (title != null) {
                title.setText(articleItem.getTitle());
            }
            if (description != null) {
                description.setText(articleItem.getSummary());
            }
            if (publishTime != null) {
                publishTime.setText(simpleDateFormat.format(new Date(articleItem.getPublishTime())) + "");
            }
            if (viewCount != null) {
                viewCount.setText(articleItem.getViewCount() + "");
            }
            List<String> labelArr = articleItem.getLabelArr();
            if (labelArr.size() > 0) {
                if (label1 != null) {
                    label1.setText(labelArr.get(0));
                }
                if (label2 != null) {
                    if (labelArr.size() >= 2) {
                        label2.setText(labelArr.get(1));
                    }
                }
            }
        }
    }

    public void setData(List<GetArticleItem> articleList, int theme) {
        if (mData != null) {
            mData.clear();
            mData.addAll(articleList);
        }
        mTheme = theme;
    }
}
