package com.laioffer.tinnews.network;

import android.content.Context;

import com.ashokvarma.gander.GanderInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //make a_p_i key
    private static final String MY_A_P_I__K_E_Y = "09792575b7674ec39f99cd6cac0e3dd0";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit newInstance(Context context){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new GanderInterceptor(context).showNotification(true))
                .build(); // interceptor defined in another class
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private static class HeaderInterceptor implements Interceptor{
        //拆了再装  // 放入api_Key
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original.newBuilder()
                               .header("X-Api-Key", MY_A_P_I__K_E_Y)
                               .build();
            return chain.proceed(request);

        }
    }
}
