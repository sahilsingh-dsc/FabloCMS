package com.myfablo.cms.utils.retrofit;

import android.content.Context;

import com.myfablo.cms.utils.AppConfig;
import com.myfablo.cms.utils.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestClient {

    private static Retrofit retrofitFabloUserService;
    private static Retrofit retrofitFabloInventoryService;
    private static Retrofit retrofitFabloOrderService;
    private static Retrofit retrofitFabloAdminService;
    private static Retrofit retrofitFabloMenuTool;
    private static Retrofit retrofitDigiKycService;
    private static final String FABLO_DIGIKYC_SERVICE_BASE_URL = "https://digikyc.fablocdn.com/v1/";

    public static Retrofit getRetrofitFabloUserService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient;

        if (Constant.APP_ENV != Constant.APP_ENV_PRODUCTION) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        }



        if (retrofitFabloUserService == null) {
            retrofitFabloUserService = new Retrofit.Builder()
                    .baseUrl(new AppConfig().getBaseUrl(Constant.APP_ENV_PRODUCTION).getUserBaseUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitFabloUserService;
    }

    public static Retrofit getRetrofitFabloInventoryService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient;

        if (Constant.APP_ENV != Constant.APP_ENV_PRODUCTION) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        }

        if (retrofitFabloInventoryService == null) {
            retrofitFabloInventoryService = new Retrofit.Builder()
                    .baseUrl(new AppConfig().getBaseUrl(Constant.APP_ENV_PRODUCTION).getInventoryBaseUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitFabloInventoryService;
    }

    public static Retrofit getRetrofitFabloOrderService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient;

        if (Constant.APP_ENV != Constant.APP_ENV_PRODUCTION) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        }

        if (retrofitFabloOrderService == null) {
            retrofitFabloOrderService = new Retrofit.Builder()
                    .baseUrl(new AppConfig().getBaseUrl(Constant.APP_ENV_PRODUCTION).getOrderBaseUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitFabloOrderService;
    }

    public static Retrofit getRetrofitFabloAdminService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient;

        if (Constant.APP_ENV != Constant.APP_ENV_PRODUCTION) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        } else {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS).build();
        }

        if (retrofitFabloAdminService == null) {
            retrofitFabloAdminService = new Retrofit.Builder()
                    .baseUrl(new AppConfig().getBaseUrl(Constant.APP_ENV_PRODUCTION).getAdminBaseUrl())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitFabloAdminService;
    }

    public static Retrofit getRetrofitFabloMenuTool(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).build();

        if (retrofitFabloMenuTool == null) {
            retrofitFabloMenuTool = new Retrofit.Builder()
                    .baseUrl("https://menutool.fablocdn.com/api/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitFabloMenuTool;
    }

    public static Retrofit getRetrofitDigiKycService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).build();

        if (retrofitDigiKycService == null) {
            retrofitDigiKycService = new Retrofit.Builder()
                    .baseUrl(FABLO_DIGIKYC_SERVICE_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofitDigiKycService;
    }

}
