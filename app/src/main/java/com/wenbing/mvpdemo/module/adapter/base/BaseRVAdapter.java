package com.wenbing.mvpdemo.module.adapter.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author: wenbing
 * @date: 2020/3/5 12:05
 */
public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    protected List<T> mBeans;
    protected Context mContext;

    public BaseRVAdapter(Context context, List<T> beans) {
        mContext = context;
        mBeans = beans;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(getItemLayoutID(viewType), parent, false);
        CommonViewHolder holder = new CommonViewHolder(view,this);
        return holder;
    }

    /**
     * 取得ItemView的布局文件
     *
     * @param viewType
     * @return
     */
    public abstract int getItemLayoutID(int viewType);


    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        runEnterAnimation(holder.itemView, position);
        onBindDataToView(holder, mBeans.get(position), position);
    }

    /**
     * 绑定数据到Item的控件中去
     *
     * @param holder
     * @param bean
     * @param position
     */
    protected abstract void onBindDataToView(CommonViewHolder holder, T bean, int position);


    @Override
    public int getItemCount() {
        return mBeans.size();
    }

    public T getItem(int position) {
        return mBeans.get(position);
    }

    public void add(T bean) {
        mBeans.add(bean);
        notifyDataSetChanged();
    }

    public void addAll(List<T> beans) {
        addAll(beans, false);
    }

    public void addAll(int position, List<T> beans) {
        mBeans.addAll(position, beans);
        notifyDataSetChanged();
    }

    public void addAll(List<T> beans, boolean clearPrevious) {
        if (clearPrevious) {
            mBeans = beans;
            notifyDataSetChanged();
        } else {
            mBeans.addAll(beans);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        mBeans.clear();
        notifyDataSetChanged();
    }

    public List<T> getBeans() {
        return mBeans;
    }

    public boolean isFinishing() {
        return mContext == null || mContext instanceof Activity && ((Activity) mContext).isFinishing();
    }

    /***
     * item的加载动画
     *
     * @param view
     * @param position
     */
    private void runEnterAnimation(final View view, int position) {
//
    }



}
