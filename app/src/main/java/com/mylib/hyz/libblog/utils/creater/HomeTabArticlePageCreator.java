package com.mylib.hyz.libblog.utils.creater;

import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.mylib.hyz.libblog.adapter.ArticleListAdapter;
import com.mylib.hyz.libblog.utils.HttpService;
import com.mylib.hyz.libblog.utils.LogUtils;
import com.mylib.hyz.libblog.utils.TextUtils;
import com.mylib.hyz.libblog.utils.getItem.GetArticleItem;
import com.mylib.hyz.libblog.utils.getItem.GetArticleListItem;
import com.mylib.hyz.libblog.utils.getItem.GetCategoryArticleItem;
import com.mylib.hyz.libblog.utils.getItem.GetTopArticleListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mylib.hyz.libblog.utils.Constance.Url.ARTICLE;
import static com.mylib.hyz.libblog.utils.Constance.Url.CATEGORY_ARTICLE;
import static com.mylib.hyz.libblog.utils.Constance.Url.TOP_ARTICLE;

public class HomeTabArticlePageCreator {
    private static HttpService http = new HttpService();
    private static final String TAG = "HomeTabArticlePageCreator";
    private static Map<Integer, RecyclerView> sCacheView = new HashMap<>();
    private static Map<Integer, ArticleListAdapter> sCacheAdapter = new HashMap<>();

    public static RecyclerView getArticlePage(ViewGroup container, int position, String id,int theme) {
        RecyclerView recyclerView = sCacheView.get(position);
        if (recyclerView == null) {
            List<GetArticleItem> articleList = getCategoryArticle(id);
            LogUtils.d(TAG,"articleList --> "+articleList.size());
             recyclerView =new RecyclerView(container.getContext());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            //设置适配器
            recyclerView.setLayoutManager(linearLayoutManager);
            ArticleListAdapter articleListAdapter = sCacheAdapter.get(position);
            if (articleListAdapter == null) {
                articleListAdapter = new ArticleListAdapter();
            }
            recyclerView.setAdapter(articleListAdapter);
            articleListAdapter.setData(articleList,theme);

            sCacheView.put(position, recyclerView);
            LogUtils.d(TAG, "==>CREATE_NEW_TAB");
        }
        container.addView(recyclerView);
        return recyclerView;
    }

    private static List<GetArticleItem> getCategoryArticle(String id) {
        int page = 1, size = 5;
        List<GetArticleItem> list = new ArrayList<>();
        try {
            if (id.equals("all")) {
                String responseTop = http.requestGet(TOP_ARTICLE);

                if (!TextUtils.isEmpty(responseTop)) {
                    GetTopArticleListItem topArticleListItem = new Gson().fromJson(responseTop, GetTopArticleListItem.class);
                    List<GetTopArticleListItem.DataBean> topArticleList = topArticleListItem.getData();
                    if (topArticleList.size() > 0) {
                        for (GetArticleItem dataBean : topArticleList) {
                            list.add(dataBean);
                        }
                    }
                }
                String responseArticle = http.requestGet(ARTICLE + page + "/" + size);
                if (!TextUtils.isEmpty(responseArticle)) {
                    GetArticleListItem articleListItem = new Gson().fromJson(responseArticle, GetArticleListItem.class);
                    List<GetArticleListItem.DataBean.ContentBean> articleList = articleListItem.getData().getContent();
                    if (articleList.size() > 0) {
                        for (GetArticleItem dataBean : articleList) {
                            list.add(dataBean);
                        }
                    }
                }
                return list;

            } else {
                String response = http.requestGet(CATEGORY_ARTICLE + id + "/" + page + "/" + size);
                if (!TextUtils.isEmpty(response)) {
                    GetCategoryArticleItem categoryArticleItem = new Gson().fromJson(response, GetCategoryArticleItem.class);
                    List<GetCategoryArticleItem.DataBean.ContentBean> categoryArticleList = categoryArticleItem.getData().getContent();
                    if (categoryArticleList.size() > 0) {
                        for (GetArticleItem dataBean : categoryArticleList) {
                            list.add(dataBean);
                        }
                    }
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }
}
