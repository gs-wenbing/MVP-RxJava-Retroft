package com.wenbing.mvpdemo.widget.bottomtab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wenbing.mvpdemo.R;

public class TabView extends LinearLayout implements View.OnClickListener {

    private ImageView mTabImage;
    private TextView mTabLable;

    public TabView(Context context) {
        super(context);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.main_tab_view, this, true);
        mTabImage = findViewById(R.id.tab_image);
        mTabLable = findViewById(R.id.tab_lable);

    }

    public void initData(TabItem tabItem) {

        mTabImage.setImageResource(tabItem.imageResId);
        mTabLable.setText(tabItem.lableResId);
    }

    @Override
    public void onClick(View v) {

    }
}