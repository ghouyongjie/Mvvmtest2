package com.example.data.datasource;

import android.content.Context;

import com.example.data.net.api.Api;
import com.example.data.net.retrofit.RetrofitUtil;

/**
 * Created by Administrator on 2016/10/31.
 */

public class QuestionDataStoreFactory {

    private Context context;

    public QuestionDataStoreFactory(Context context) {
//        Context c = context.getApplicationContext();
        this.context = context;
    }

    public QuestionDataStore createCloudDataStore() {
        Api api = RetrofitUtil.createApi(Api.class);
        return new CloudQuestionDataStore(api);
    }

}
