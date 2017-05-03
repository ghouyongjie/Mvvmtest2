package com.example.administrator.mvvmtest.viewmodel;

import android.databinding.BaseObservable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/10/31.
 */

public abstract class ViewModel extends BaseObservable{

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    protected @interface Command{

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    protected @interface BindView{

    }

}
