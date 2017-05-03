package com.example.domain.interactor.repository;

import com.example.data.net.resp.QuestionsResp;

import rx.Observable;


/**
 * Created by Administrator on 2016/10/31.
 */

public interface QuestionRepository {

    Observable<QuestionsResp> lastestQuestions(int page);

}
