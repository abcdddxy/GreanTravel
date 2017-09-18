package com.example.zero.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zero.adapter.RouteSearchAdapter;
import com.example.zero.bean.RouteSearchBean;
import com.example.zero.greentravel.R;
import com.example.zero.view.SearchView;
import com.example.zero.view.SimpleSearchView;

import java.util.ArrayList;
import java.util.List;

public class RouteMultiFragment extends Fragment implements SimpleSearchView.SimpleSearchViewListener, SearchView.SearchViewListener {
    /**
     * 搜索view
     */
    private SearchView endSearchView;
    /**
     * 搜索结果列表view
     */
    private ListView lvResults;
    /**
     * 起点搜索view
     */
    private ArrayList<SimpleSearchView> searchViewList;
    /**
     * 起点添加按钮
     */
    private ArrayList<Button> btnaddList;
    /**
     * 搜索按钮
     */
    private Button btnsearch;

    /**
     * 热搜框列表adapter
     */
    private ArrayAdapter<String> hintAdapter;
    /**
     * 自动补全列表adapter
     */
    private ArrayAdapter<String> autoCompleteAdapter;
    /**
     * 搜索结果列表adapter
     */
    private RouteSearchAdapter resultAdapter;

    /**
     * 数据库数据，总数据
     */
    private List<RouteSearchBean> dbData;
    /**
     * 热搜版数据
     */
    private List<String> hintData;
    /**
     * 搜索过程中自动补全数据
     */
    private List<String> autoCompleteData;
    /**
     * 搜索结果的数据
     */
    private List<RouteSearchBean> resultData;
    /**
     * 默认提示框显示项的个数
     */
    private static int DEFAULT_HINT_SIZE = 4;
    /**
     * 提示框显示项的个数
     */
    private static int hintSize = DEFAULT_HINT_SIZE;

    private static final String TAG = "RouteMultiFragment";

    /**
     * 设置提示框显示项的个数
     *
     * @param hintSize 提示框显示个数
     */
    public static void setHintSize(int hintSize) {
        RouteMultiFragment.hintSize = hintSize;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_route_multi, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initViews();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //从数据库获取数据
        getDbData();
        //初始化热搜版数据
        getHintData();
        //初始化自动补全数据
        getAutoCompleteData(null);
        //初始化搜索结果数据
        getResultData(null);
    }

    /**
     * 初始化视图
     */
    private void initViews() {
        endSearchView = (SearchView) getView().findViewById(R.id.route_search_multi);
        lvResults = (ListView) getView().findViewById(R.id.route_lv_search_multi_results);
        btnsearch = (Button) getView().findViewById(R.id.route_btn_multi_search);

        int size = 4;
        searchViewList = new ArrayList<SimpleSearchView>(size);
        searchViewList.add((SimpleSearchView) getView().findViewById(R.id.route_search_multi0));
        searchViewList.add((SimpleSearchView) getView().findViewById(R.id.route_search_multi1));
        searchViewList.add((SimpleSearchView) getView().findViewById(R.id.route_search_multi2));
        btnaddList = new ArrayList<Button>(size);
        btnaddList.add((Button) getView().findViewById(R.id.route_btn_add_multi0));
        btnaddList.add((Button) getView().findViewById(R.id.route_btn_add_multi1));

        endSearchView.setHintText("请输入终点：");
        searchViewList.get(0).setHintText("情输入起点：");
        searchViewList.get(1).setHintText("情输入起点：");
        searchViewList.get(2).setHintText("情输入起点：");

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/9/11 具体搜索
                Toast.makeText(getActivity(), "开始搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //设置监听
        endSearchView.setSearchViewListener(this);
        searchViewList.get(0).setSearchViewListener(this);
        searchViewList.get(1).setSearchViewListener(this);
        searchViewList.get(2).setSearchViewListener(this);
        //设置adapter
        endSearchView.setTipsHintAdapter(hintAdapter);
        endSearchView.setAutoCompleteAdapter(autoCompleteAdapter);

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });

        btnaddList.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewList.get(1).setVisibility(View.VISIBLE);
                btnaddList.get(1).setVisibility(View.VISIBLE);
            }
        });
        btnaddList.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewList.get(2).setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * 获取db数据
     */
    private void getDbData() {
        int size = 100;
        dbData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            dbData.add(new RouteSearchBean(R.drawable.title_icon, "站点" + (i + 1),
                    "周围简介\n热门吃、喝、玩、乐", i * 20 + 2 + ""));
        }
    }

    /**
     * 获取热搜版data和adapter
     */
    private void getHintData() {
        hintData = new ArrayList<>(hintSize);
        hintData.add("热门搜索站点");
        for (int i = 1; i <= hintSize; i++) {
            hintData.add("站点" + i * 10);
        }

        hintAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, hintData);
    }

    /**
     * 获取自动补全data和adapter
     */
    private void getAutoCompleteData(String text) {
        if (autoCompleteData == null) {
            //初始化
            autoCompleteData = new ArrayList<>(hintSize);
        } else {
            // 根据text获取autodata
            autoCompleteData.clear();
            for (int i = 0, count = 0; i < dbData.size()
                    && count < hintSize; i++) {
                if (dbData.get(i).getTitle().contains(text.trim())) {
                    autoCompleteData.add(dbData.get(i).getTitle());
                    count++;
                }
            }
        }

        if (autoCompleteAdapter == null) {
            autoCompleteAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, autoCompleteData);
        } else {
            autoCompleteAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 获取搜索结果data和adapter
     */
    private void getResultData(String text) {
        if (resultData == null) {
            // 初始化
            resultData = new ArrayList<>();
        } else {
            resultData.clear();
            for (int i = 0; i < dbData.size(); i++) {
                if (dbData.get(i).getTitle().equals(text.trim())) {
                    resultData.add(dbData.get(i));
                }
            }
        }

        if (resultAdapter == null) {
            resultAdapter = new RouteSearchAdapter(getActivity(), resultData, R.layout.route_search_item_list);
        }
    }

    /**
     * 当搜索框文本改变时触发的回调 ,更新自动补全数据
     *
     * @param text 搜索栏文本
     */
    @Override
    public void onRefreshAutoComplete(String text) {
        //更新数据
        getAutoCompleteData(text);
    }

    /**
     * 点击搜索键时edit text触发的回调
     *
     * @param text 搜索栏文本
     */
    @Override
    public void onSearch(String text) {
        //更新result数据
        getResultData(text);
        lvResults.setVisibility(View.VISIBLE);

        //第一次获取结果 还未配置适配器
        if (lvResults.getAdapter() == null) {
            //获取搜索数据 设置适配器
            lvResults.setAdapter(resultAdapter);
        } else {
            //更新搜索数据
            resultAdapter.notifyDataSetChanged();
        }

        Toast.makeText(getActivity(), "完成搜索", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击返回键触发回调
     */
    @Override
    public void onBack() {
        lvResults.setVisibility(View.GONE);
        autoCompleteAdapter.notifyDataSetChanged();
        resultAdapter.notifyDataSetChanged();
        hintAdapter.notifyDataSetChanged();
    }

    /**
     * 自动补全提示框出现触发回调
     */
    @Override
    public void isFocus() {
        lvResults.setVisibility(View.GONE);
        autoCompleteAdapter.notifyDataSetChanged();
        resultAdapter.notifyDataSetChanged();
        hintAdapter.notifyDataSetChanged();
    }

    /**
     * 热门提示数据在数据库中是否存在
     *
     * @param text 热门提示
     * @return true存在，false不存在
     */
    @Override
    public boolean onHintClick(String text) {
        boolean JUD = false;
        for (int i = 0; i < dbData.size(); i++) {
            if (dbData.get(i).getTitle().equals(text.trim())) {
                JUD = true;
            }
        }
        hintAdapter.notifyDataSetChanged();
        return JUD;
    }
}
