package com.example.data.datasource;

import com.example.data.net.api.Api;
import com.example.data.net.resp.QuestionsResp;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/31.
 */

public class CloudQuestionDataStore implements QuestionDataStore{

    private Api api;

    public CloudQuestionDataStore(Api api) {
        this.api = api;
    }

    @Override
    public Observable<QuestionsResp> lastestQuestions(int page) {
        return api.getLastestQuestions(page);
    }
}
