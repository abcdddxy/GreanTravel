package com.example.zero.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zero.activity.RouteResultActivity;
import com.example.zero.adapter.RouteSearchAdapter;
import com.example.zero.bean.RouteSearchBean;
import com.example.zero.greentravel.R;
import com.example.zero.view.SearchView;

import java.util.ArrayList;
import java.util.List;

public class RouteSingleFragment extends Fragment implements SearchView.SearchViewListener {

    /**
     * 搜索结果列表view
     */
    private ListView lvResults;
    /**
     * 搜索view
     */
    private SearchView searchView;
    /**
     * 搜索结果列表view
     */
    private ListView lvResults2;
    /**
     * 搜索view
     */
    private SearchView searchView2;
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
     * 自动补全列表adapter
     */
    private ArrayAdapter<String> autoCompleteAdapter2;
    /**
     * 搜索结果列表adapter
     */
    private RouteSearchAdapter resultAdapter;
    /**
     * 搜索结果列表adapter
     */
    private RouteSearchAdapter resultAdapter2;

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

    private static final String TAG = "RouteSingleFragment";

    /**
     * 设置提示框显示项的个数
     *
     * @param hintSize 提示框显示个数
     */
    public static void setHintSize(int hintSize) {
        RouteSingleFragment.hintSize = hintSize;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_route_single, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        initViews();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化视图
     */
    private void initViews() {
        searchView = (SearchView) getView().findViewById(R.id.route_search_single);
        lvResults = (ListView) getView().findViewById(R.id.route_lv_search_single_results);
        searchView2 = (SearchView) getView().findViewById(R.id.route_search_single2);
        lvResults2 = (ListView) getView().findViewById(R.id.route_lv_search_single_results2);
        btnsearch = (Button) getView().findViewById(R.id.route_btn_single_search);

        searchView.setHintText("请输入起点：");
        searchView2.setHintText("请输入终点：");

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/9/11 具体搜索
//                Toast.makeText(getActivity(), "开始搜索", Toast.LENGTH_SHORT).show();
                String beginStation = searchView.getText();
                String endStation = searchView2.getText();
                Bundle mBundle = new Bundle();
                mBundle.putString("origin", "Single");
                mBundle.putString("beginStation", beginStation);
                mBundle.putString("endStation", endStation);
                if ((!beginStation.equals("")) & (!endStation.equals(""))) {
                    Intent intent = new Intent(getActivity(), RouteResultActivity.class);
                    intent.putExtras(mBundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "搜索框消息不完善，请填充完整后在开始搜索！", Toast.LENGTH_LONG).show();
                }
            }
        });

        //设置监听
        searchView.setSearchViewListener(this);
        searchView2.setSearchViewListener(this);
        //设置adapter
        searchView.setTipsHintAdapter(hintAdapter);
        searchView.setAutoCompleteAdapter(autoCompleteAdapter);
        searchView2.setTipsHintAdapter(hintAdapter);
        searchView2.setAutoCompleteAdapter(autoCompleteAdapter2);

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), "1-" + position + "", Toast.LENGTH_SHORT).show();
            }
        });
        lvResults2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), "2-" + position + "", Toast.LENGTH_SHORT).show();
            }
        });
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
     * 获取db数据
     */
    private void getDbData() {
        int size = 100;
        dbData = new ArrayList<>(size);
        dbData.add(new RouteSearchBean(R.drawable.title_icon, "北京站",
                "周围简介\n热门吃、喝、玩、乐", 99 + ""));
        dbData.add(new RouteSearchBean(R.drawable.title_icon, "北京南站",
                "周围简介\n热门吃、喝、玩、乐", 99 + ""));
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
//        hintData.add("热门搜索站点");
        hintData.add("北京站");
        hintData.add("北京南站");
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
            if (searchView.hasFocus()) {
                autoCompleteAdapter.notifyDataSetChanged();
            }
        }

        if (autoCompleteAdapter2 == null) {
            autoCompleteAdapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, autoCompleteData);
        } else {
            if (searchView2.hasFocus()) {
                autoCompleteAdapter2.notifyDataSetChanged();
            }
        }
        Log.d(TAG, "getAutoCompleteData: finish");
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

        if (resultAdapter2 == null) {
            resultAdapter2 = new RouteSearchAdapter(getActivity(), resultData, R.layout.route_search_item_list);
        }
        Log.d(TAG, "getResultData: finish");
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
        if (!searchView.getText().equals("")) {
            lvResults.setVisibility(View.VISIBLE);
        }
        if (!searchView2.getText().equals("")) {
            lvResults2.setVisibility(View.VISIBLE);
        }

        //第一次获取结果 还未配置适配器
        if (searchView.hasFocus()) {
            if (lvResults.getAdapter() == null) {
                //获取搜索数据 设置适配器
                lvResults.setAdapter(resultAdapter);
            } else {
                //更新搜索数据
                resultAdapter.notifyDataSetChanged();
            }
        }

        if (searchView2.hasFocus()) {
            if (lvResults2.getAdapter() == null) {
                //获取搜索数据 设置适配器
                lvResults2.setAdapter(resultAdapter2);
            } else {
                //更新搜索数据
                resultAdapter2.notifyDataSetChanged();
            }
        }

        Toast.makeText(getActivity(), "完成搜索", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击返回键触发回调
     */
    @Override
    public void onBack() {
        Log.d(TAG, "onBack: start");
        if (searchView.getText().equals("")) {
            autoCompleteAdapter.notifyDataSetChanged();
            resultAdapter.notifyDataSetChanged();
            lvResults.setVisibility(View.GONE);
        }
        if (searchView2.getText().equals("")) {
            autoCompleteAdapter2.notifyDataSetChanged();
            resultAdapter2.notifyDataSetChanged();
            lvResults2.setVisibility(View.GONE);
        }
        hintAdapter.notifyDataSetChanged();
        Log.d(TAG, "onBack: finish");
    }

    /**
     * 自动补全提示框出现触发回调
     */
    @Override
    public void isFocus() {
        Log.d(TAG, "isFocus: start");
        if (searchView.hasFocus()) {
            autoCompleteAdapter.notifyDataSetChanged();
            resultAdapter.notifyDataSetChanged();
            lvResults.setVisibility(View.GONE);
        }
        if (searchView2.hasFocus()) {
            autoCompleteAdapter2.notifyDataSetChanged();
            resultAdapter2.notifyDataSetChanged();
            lvResults2.setVisibility(View.GONE);
        }
        hintAdapter.notifyDataSetChanged();
        Log.d(TAG, "isFocus: finish");
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
