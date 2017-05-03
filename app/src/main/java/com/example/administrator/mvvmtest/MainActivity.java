package com.example.administrator.mvvmtest;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.mvvmtest.customview.ProgressUtil;
import com.example.administrator.mvvmtest.databinding.ActivityMainBinding;
import com.example.administrator.mvvmtest.view.fragment.MainFragment;
import com.example.administrator.mvvmtest.viewmodel.QuestionViewModel;
import com.example.data.net.resp.QuestionsResp;
import com.example.domain.interactor.GetLastestQuestions;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    QuestionViewModel viewmodel = new QuestionViewModel();
    ActivityMainBinding binding;
    private ProgressUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment("1");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        viewmodel.loadQuestionsCommand(1);
//        bindning.setUser(new User("ouyongjie", "guangzhou"));
//        getLastestQuestions.execute(new Subscriber<QuestionsResp>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(MainActivity.this, "e:"+e.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNext(QuestionsResp questionsResp) {
////                binding.setUser(questionsResp);
//                questionObs.set(questionsResp);
//                Toast.makeText(MainActivity.this, "onnext:"+questionsResp.getData().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void showFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (null == fragment) {
            fragment = createFragment(tag);
            if (null != fragment) {
                transaction.add(R.id.framelayout_fragment, fragment, tag);
            }
        }
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
    }

    public Fragment createFragment(String tag) {
        Fragment fragment = null;
        switch (tag) {
            case "1":
                fragment =  new MainFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    public void showProgress() {
        if (null == util) {
            util = new ProgressUtil(MainActivity.this);
        }
        util.showProgressDialog();
    }

    public void hideProgress() {
        if (null != util) {
            util.closeProgerssDialog();
        }
    }

}
