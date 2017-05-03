package com.example.data.datasource;

import com.example.data.net.resp.QuestionsResp;

import rx.Observable;


/**
 * Created by Administrator on 2016/10/31.
 */

public interface QuestionDataStore {

    Observable<QuestionsResp> lastestQuestions(int page);

}
