package com.example.domain.interactor;

import android.content.Context;

import com.example.domain.interactor.repository.QuestionDataRepository;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/31.
 */

public class GetLastestQuestions extends QuestionCase{

    private QuestionDataRepository questionDataRepository;
    private int page;

    public GetLastestQuestions(Context context) {
        this.questionDataRepository = new QuestionDataRepository(context);
    }

    public void setQuestionDataRepository(QuestionDataRepository questionDataRepository) {
        this.questionDataRepository = questionDataRepository;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return questionDataRepository.lastestQuestions(page);
    }

}
