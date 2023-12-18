package com.myfablo.cms.utils;

import android.content.Context;
import android.net.Uri;

import com.myfablo.cms.module_menu_sync.models.upload_swiggy.MenuUploadResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public class FileUploadHelper {

    private static final String BASE_URL = "https://menutool.fablocdn.com/api/";
    private ApiService apiService;
    private Context context;

    public FileUploadHelper(Context context) {
        this.context = context;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public void uploadFile(Uri fileUri, Callback<MenuUploadResponse> callback) {
        try {
            RequestBody requestFile = createRequestBody(fileUri);
            MultipartBody.Part body = MultipartBody.Part.createFormData("menuFile", "filename.json", requestFile);
            Call<MenuUploadResponse> call = apiService.uploadFile(body);
            call.enqueue(callback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RequestBody createRequestBody(Uri fileUri) throws IOException {
        InputStream inputStream = context.getContentResolver().openInputStream(fileUri);
        return RequestBody.create(MediaType.parse("application/json"), inputStreamToBytes(inputStream));
    }

    private byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }

    public interface ApiService {
        @Multipart
        @POST("menu/upload")
        Call<MenuUploadResponse> uploadFile(@Part MultipartBody.Part file);
    }
}
