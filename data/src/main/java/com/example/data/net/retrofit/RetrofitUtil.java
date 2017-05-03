package com.example.data.net.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/31.
 */

public class RetrofitUtil {

    public  static final String BASE_URL = "http://health-testapi.yxlady.com/";

    private static Retrofit retrofit;
    private static OkHttpClient client = new OkHttpClient.Builder()
            .build();

    public static <T> T createApi(Class<T> clazz) {
        if (null == retrofit) {
            synchronized (RetrofitUtil.class) {
                if (null == retrofit) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(client)
                            .build();
                }
            }
        }
        return  retrofit.create(clazz);
    }
}
