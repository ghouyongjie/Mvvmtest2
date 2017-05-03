package com.example.domain.interactor.repository;

import android.content.Context;

import com.example.data.datasource.QuestionDataStore;
import com.example.data.datasource.QuestionDataStoreFactory;
import com.example.data.net.resp.QuestionsResp;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/31.
 */

public class QuestionDataRepository implements QuestionRepository{

    private QuestionDataStoreFactory questionDataStoreFactory;

    public QuestionDataRepository(Context context) {
        this.questionDataStoreFactory = new QuestionDataStoreFactory(context);
    }

    public void setQuestionDataStoreFactory(QuestionDataStoreFactory questionDataStoreFactory) {
        this.questionDataStoreFactory = questionDataStoreFactory;
    }

    @Override
    public Observable<QuestionsResp> lastestQuestions(int page) {
        QuestionDataStore questionDataStore = this.questionDataStoreFactory.createCloudDataStore();
        return questionDataStore.lastestQuestions(page);
    }
}
