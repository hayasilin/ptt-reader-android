package com.cracktheterm.pttreader.ui.presenters;

import com.cracktheterm.pttreader.ui.interfaces.RefreshInterface;

import javax.xml.transform.ErrorListener;

/**
 * 含有网络加载的Presenter
 *
 * @author mrsimple
 * @param <T> 视图接口的类型
 */
public abstract class NetBasePresenter<T extends RefreshInterface<?>> {
    protected T mView;

//    ErrorListener mErrorListener = new ErrorListener() {
////        public void onErrorResponse(Error error) {
////            mView.onError(error);
////        };
////    };
}
