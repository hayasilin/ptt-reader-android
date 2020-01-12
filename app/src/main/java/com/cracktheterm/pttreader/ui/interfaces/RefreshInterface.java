package com.cracktheterm.pttreader.ui.interfaces;

/**
 * 可进行网络刷新的接口
 *
 * @author mrsimple
 * @param <T>
 */
public interface RefreshInterface<T> extends BaseViewInterface<T> {

    public void showLoading();

    public void hideLoading();

    public void onError(Error error);
}
