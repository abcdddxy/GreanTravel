package com.example.zero.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import com.donkingliang.labels.LabelsView;

import com.example.zero.adapter.RouteSearchAdapter;
import com.example.zero.bean.RouteSearchBean;
import com.example.zero.greentravel.R;
import com.example.zero.view.SearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuwan122 on 2017/9/7.
 * 目的地搜索fragment
 */

public class AdvDestinFragment extends Fragment {

    private EditText editText;
    private LabelsView labelsView;
    private ArrayList<String> labels;

//
//
//    /**
//     * 搜索结果列表view
//     */
//    private ListView lvResults;
//    /**
//     * 搜索view
//     */
//    private SearchView searchView;
//    /**
//     * 热搜框列表adapter
//     */
//    private ArrayAdapter<String> hintAdapter;
//    /**
//     * 自动补全列表adapter
//     */
//    private ArrayAdapter<String> autoCompleteAdapter;
//    /**
//     * 搜索结果列表adapter
//     */
//    private RouteSearchAdapter resultAdapter;
//    /**
//     * 数据库数据，总数据
//     */
//    private List<RouteSearchBean> dbData;
//    /**
//     * 热搜版数据
//     */
//    private List<String> hintData;
//    /**
//     * 搜索过程中自动补全数据
//     */
//    private List<String> autoCompleteData;
//    /**
//     * 搜索结果的数据
//     */
//    private List<RouteSearchBean> resultData;
//
//    /**
//     * 默认提示框显示项的个数
//     */
//    private static int DEFAULT_HINT_SIZE = 4;
//    /**
//     * 提示框显示项的个数
//     */
//    private static int hintSize = DEFAULT_HINT_SIZE;
//
//    private static final String TAG = "AdvDestinFragment";
//
//    /**
//     * 设置提示框显示项的个数
//     *
//     * @param hintSize 提示框显示个数
//     */
//    public static void setHintSize(int hintSize) {
//        AdvDestinFragment.hintSize = hintSize;
//    }
//


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adv_destin, container, false);
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
        editText = getView().findViewById(R.id.editText);
        //使用了网上的labelView
        labelsView = getView().findViewById(R.id.labels);
        labels = getLabels();
        labelsView.setLabels(labels);
        labelsView.setOnLabelClickListener(new LabelsView.OnLabelClickListener() {
            @Override
            public void onLabelClick(View label, String labelText, int position) {
                //label是被点击的标签，labelText是标签的文字，position是标签的位置。
                ArrayList<Integer> selected = labelsView.getSelectLabels();
                String s = "";
                for(Integer i:selected)
                {
                    s = s + labels.get(i) + "";
                }
                editText.setText(s);
                //TODO 考虑改成点击标签开始搜索
            }
        });

 //       searchView = (SearchView) getView().findViewById(R.id.adv_destin_search);
//        listPopupWindow = new ListPopupWindow(getActivity());
//        listPopupWindow.setAdapter(new ArrayAdapter(getActivity(), R.layout.route_search_item_list, products));
//        listPopupWindow.setAnchorView(searchView);
//
//
//        listPopupWindow.setModal(true);
//
//        searchView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listPopupWindow.show();
//            }
//        });

//        lvResults = (ListView) getView().findViewById(R.id.adv_search_results);
//        searchView = (SearchView) getView().findViewById(R.id.adv_destin_search);
//        //设置监听
//        searchView.setSearchViewListener(this);
//        //设置adapter
//        searchView.setTipsHintAdapter(hintAdapter);
//        searchView.setAutoCompleteAdapter(autoCompleteAdapter);
//
//        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        getLabels();
//        //从数据库获取数据
//        getDbData();
//        //初始化热搜版数据
//        getHintData();
//        //初始化自动补全数据
//        getAutoCompleteData(null);
//        //初始化搜索结果数据
//        getResultData(null);
    }

//    /**
//     * 获取db数据
//     */
//    private void getDbData() {
//        int size = 100;
//        dbData = new ArrayList<>(size);
//        for (int i = 0; i < size; i++) {
//            dbData.add(new RouteSearchBean(R.drawable.title_icon, "android开发必备技能" + (i + 1),
//                    "Android自定义view——自定义搜索view", i * 20 + 2 + ""));
//        }
//    }
//
//    /**
//     * 获取热搜版data和adapter
//     */
//    private void getHintData() {
//        hintData = new ArrayList<>(hintSize);
//        for (int i = 1; i <= hintSize; i++) {
//            hintData.add("热搜版" + i + "：Android自定义View");
//        }
//        hintAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, hintData);
//    }
//
//    /**
//     * 获取自动补全data和adapter
//     */
//    private void getAutoCompleteData(String text) {
//        if (autoCompleteData == null) {
//            //初始化
//            autoCompleteData = new ArrayList<>(hintSize);
//        } else {
//            // 根据text获取autodata
//            autoCompleteData.clear();
//            for (int i = 0, count = 0; i < dbData.size()
//                    && count < hintSize; i++) {
//                if (dbData.get(i).getTitle().contains(text.trim())) {
//                    autoCompleteData.add(dbData.get(i).getTitle());
//                    count++;
//                }
//            }
//        }
//        if (autoCompleteAdapter == null) {
//            autoCompleteAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, autoCompleteData);
//        } else {
//            autoCompleteAdapter.notifyDataSetChanged();
//        }
//    }
//
//    /**
//     * 获取搜索结果data和adapter
//     */
//    private void getResultData(String text) {
////        if (resultData == null) {
////            // 初始化
////            resultData = new ArrayList<>();
////        } else {
////            resultData.clear();
////            for (int i = 0; i < dbData.size(); i++) {
////                if (dbData.get(i).getTitle().contains(text.trim())) {
////                    resultData.add(dbData.get(i));
////                }
////            }
////        }
////        if (resultAdapter == null) {
////            resultAdapter = new RouteSearchAdapter(getActivity(), resultData, R.layout.route_search_item_list);
////        } else {
////            resultAdapter.notifyDataSetChanged();
////        }
//    }
//
//    /**
//     * 当搜索框文本改变时触发的回调 ,更新自动补全数据
//     *
//     * @param text
//     */
//    @Override
//    public void onRefreshAutoComplete(String text) {
//        //更新数据
//        getAutoCompleteData(text);
//    }
//
//    /**
//     * 点击搜索键时edit text触发的回调
//     *
//     * @param text
//     */
//    @Override
//    public void onSearch(String text) {
////        //更新result数据
////        getResultData(text);
////        lvResults.setVisibility(View.VISIBLE);
////        //第一次获取结果 还未配置适配器
////        if (lvResults.getAdapter() == null) {
////            //获取搜索数据 设置适配器
////            lvResults.setAdapter(resultAdapter);
////        } else {
////            //更新搜索数据
////            resultAdapter.notifyDataSetChanged();
////        }
//        Toast.makeText(getActivity(), "完成搜素", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onBack() {
////        if (searchView.getText().equals("")) {
////            lvResults.setVisibility(View.GONE);
////            autoCompleteAdapter.notifyDataSetChanged();
////            resultAdapter.notifyDataSetChanged();
////        }
////        if (searchView2.getText().equals("")) {
////            lvResults2.setVisibility(View.GONE);
////            autoCompleteAdapter2.notifyDataSetChanged();
////            resultAdapter2.notifyDataSetChanged();
////        }
////        hintAdapter.notifyDataSetChanged();
//    }
//
//    /**
//     * 自动补全提示框出现触发回调
//     */
//    @Override
//    public void isFocus() {
////        if (searchView.hasFocus()) {
////            lvResults.setVisibility(View.GONE);
////            autoCompleteAdapter.notifyDataSetChanged();
////            resultAdapter.notifyDataSetChanged();
////        }
////        if (searchView2.hasFocus()) {
////            lvResults2.setVisibility(View.GONE);
////            autoCompleteAdapter2.notifyDataSetChanged();
////            resultAdapter2.notifyDataSetChanged();
////        }
////        hintAdapter.notifyDataSetChanged();
//    }

    /**
     * 获取当前热门关键字
     * @return
     */
    public ArrayList<String> getLabels()
    {
        labels = new ArrayList<String>();
        labels.add("烤鸭");
        labels.add("日料");
        labels.add("凯德广场");
        labels.add("万达");
        labels.add("汉堡王");
        labels.add("螺蛳粉");
        labels.add("火锅");
        return labels;
    }
}
