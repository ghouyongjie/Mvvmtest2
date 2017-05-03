package com.example.administrator.mvvmtest.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.view.View;

import com.example.administrator.mvvmtest.MyApplication;
import com.example.administrator.mvvmtest.view.adapter.QuestionListAdapter;
import com.example.data.entity.Question;
import com.example.data.net.resp.QuestionsResp;
import com.example.domain.interactor.GetLastestQuestions;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/31.
 */

public class QuestionViewModel extends LoadingViewModel {

    public final ObservableField<QuestionsResp> questionObs = new ObservableField<>();
    public final ObservableBoolean showProgress = new ObservableBoolean(false);
    GetLastestQuestions getLastestQuestions = new GetLastestQuestions(MyApplication.getContext());

    public final ObservableField<QuestionListAdapter> questionListAdapter = new ObservableField<>();
    private QuestionListAdapter adapter;

    @Override
    public View.OnClickListener onRetryClick() {
        return null;
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Command
    public void change() {
        showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                QuestionsResp questionsResp = new QuestionsResp();
                List<Question> list = new ArrayList<>();
                Question question = new Question();
                question.setAskName("askname");
                question.setContent("content");
                question.setId("id");
                question.setTitle("title");
                list.add(question);
                questionsResp.setData(list);
                questionObs.set(questionsResp);
                hideProgress();
            }
        }, 3000);

    }

    @Command
    public void loadQuestionsCommand(int page) {
        getLastestQuestions.setPage(page);
        getLastestQuestions.execute(new Subscriber<QuestionsResp>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(QuestionsResp questionsResp) {
                if (null == adapter) {
                    adapter = new QuestionListAdapter(MyApplication.getContext(), questionsResp.getData());
                } else {
                    adapter.addDatas(questionsResp.getData());
                    return;
                }
                questionListAdapter.set(adapter);
            }
        });
    }

    public void showProgress() {
        showProgress.set(true);
    }

    public void hideProgress() {
        showProgress.set(false);
    }

}
