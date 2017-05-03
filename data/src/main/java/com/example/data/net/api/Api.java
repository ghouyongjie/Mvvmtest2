package com.example.data.net.api;

import com.example.data.net.resp.QuestionsResp;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/31.
 */

public interface Api {

    @GET("question/index")
    Observable<QuestionsResp> getLastestQuestions(@Query("page") int page);

}
