package com.example.administrator.mvvmtest.view.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.administrator.mvvmtest.viewmodel.ViewModel;

/**
 * Created by Administrator on 2016/11/1.
 */

public abstract class BaseFragment<VM extends ViewModel, B extends ViewDataBinding> extends Fragment{

    private VM viewModel;
    private B binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void setViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }

    public VM getViewModel() {
        if (viewModel == null) {
            throw new NullPointerException("You should setViewModel first!");
        }
        return viewModel;
    }

    public void setBinding(@NonNull B binding) {
        this.binding = binding;
    }

    public B getBinding() {
        if (binding == null) {
            throw new NullPointerException("You should setBinding first!");
        }
        return binding;
    }

}
