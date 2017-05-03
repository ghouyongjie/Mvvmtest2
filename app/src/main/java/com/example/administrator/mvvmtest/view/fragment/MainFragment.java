package com.example.administrator.mvvmtest.view.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.administrator.mvvmtest.R;
import com.example.administrator.mvvmtest.databinding.FragmentMainBinding;
import com.example.administrator.mvvmtest.viewmodel.QuestionViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<QuestionViewModel, FragmentMainBinding> {


    public MainFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setViewModel(new QuestionViewModel());
        setBinding(DataBindingUtil.<FragmentMainBinding>inflate(inflater, R.layout.fragment_main, container, false));
        getBinding().setViewModel(getViewModel());
        setupUI();
        return getBinding().getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getViewModel().loadQuestionsCommand(1);
    }

    private void setupUI() {
        getBinding().rvLastestQuestion.setLayoutManager(new LinearLayoutManager(getActivity()));
//        getBinding().rvLastestQuestion.setItemAnimator(new DefaultItemAnimator());
        getBinding().buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewModel().loadQuestionsCommand(2);
            }
        });
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }
}
