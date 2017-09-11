package com.xxoo.av666.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.xxoo.av666.R;
import com.xxoo.av666.adapter.SimpleRecyclerCardAdapter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * com.xxoo.av666.activity
 * Description：瀑布流
 * Created by zhangle on 2017/5/13.
 * qq:475166369
 */
public class WaterfallActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas = null;

    private SimpleRecyclerCardAdapter mSimpleRecyclerAdapter;

    private Context activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        activity = this;

        mRecyclerView = (RecyclerView) findViewById(R.id.app_recyclerview);
        initDataAndView();
    }

    private void initDataAndView()
    {
        mDatas = new ArrayList<String>();
        for(int i=0;i<=9;i++)
        {
            mDatas.add("AV666"+String.valueOf((char)i));
        }
        mSimpleRecyclerAdapter = new SimpleRecyclerCardAdapter(this, mDatas);
        mRecyclerView.setAdapter(mSimpleRecyclerAdapter);
        //设置网格布局管理器
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mSimpleRecyclerAdapter.setOnItemActionListener(new SimpleRecyclerCardAdapter.OnItemActionListener() {

            @Override
            public boolean onItemLongClickListener(View v, int pos)
            {
                Toast.makeText(activity, "-长按-"+pos, Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public void onItemClickListener(View v, int pos) {
                Toast.makeText(activity, "-单击-"+pos, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setShortcutsVisible(Menu menu)
    {
        if(MenuBuilder.class.isInstance(menu))
        {
            MenuBuilder builder = (MenuBuilder) menu;
            builder.setShortcutsVisible(true);
            try {
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(builder, true);
            } catch (Exception ie) {
            }
        }
    }
}
