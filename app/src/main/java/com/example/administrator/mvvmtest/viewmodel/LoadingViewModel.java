package com.example.administrator.mvvmtest.viewmodel;

import android.databinding.ObservableBoolean;
import android.view.View;

/**
 * Created by Administrator on 2016/10/31.
 */

public abstract class LoadingViewModel extends ViewModel {

    public final ObservableBoolean showRetry = new ObservableBoolean(false);
    public final ObservableBoolean showLoading = new ObservableBoolean(false);
    public ObservableBoolean showProgress = new ObservableBoolean(false);

    @BindView
    public void showLoading() {
        showRetry.set(false);
        showLoading.set(true);
    }

    @BindView
    public void showRetry() {
        showLoading.set(false);
        showRetry.set(true);
    }

    public void showProgress() {
        showProgress.set(true);
    }

    public void hideProgress() {
        showProgress.set(false);
    }

    public abstract View.OnClickListener onRetryClick();

}
