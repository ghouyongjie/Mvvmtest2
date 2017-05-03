package com.example.domain.interactor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Administrator on 2016/10/31.
 */

public abstract class QuestionCase {

    private Subscription subscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable();

    public void execute(Subscriber questionCase) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(questionCase);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
