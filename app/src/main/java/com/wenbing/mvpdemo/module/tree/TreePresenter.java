package com.wenbing.mvpdemo.module.tree;

import com.wenbing.mvpdemo.base.BasePresenter;
import com.wenbing.mvpdemo.beans.TreeBean;
import com.wenbing.mvpdemo.module.RecyclerFragment;
import com.wenbing.mvpdemo.retrofit.BaseObserver;
import com.wenbing.mvpdemo.retrofit.error.ApiException;

import java.util.List;

/**
 * @author: wenbing
 * @date: 2020/3/5 10:51
 */
public class TreePresenter extends BasePresenter<ITreeView> {

    public void requestData(final int action, int pageSize, int page) {
        if (getView() == null) {
            return;
        }
        addDisposable(mApiServer.toSubscribe(mApiServer.getApi().getTreeList(),
                new BaseObserver<List<TreeBean>>(getView(), false) {
                    @Override
                    protected void onSuccess(List<TreeBean> treeList) {
                        if (getView() != null) {
                            getView().showData(treeList, action);
                        }
                    }

                    @Override
                    protected void onError(ApiException ex) {
                        if (getView() != null) {
                            getView().showData(null, RecyclerFragment.ACTION_LOAD_FAILED);
                        }
                    }
                }));
    }
}
