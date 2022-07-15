package com.ttopacademy.di;

import com.ttopacademy.remotedatasources.retrofit.ApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/** Injects interfaces needed for making api calls. */
@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    
    private static final String BASE_URL = "https://example.com/api/";

    /** Injects Retrofit interface. */
    @Provides
    @Singleton
    public static ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    /** Injects Retrofit interface. */
    @Provides
    @Singleton
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).build();
    }

    /** Injects OkHttpClient interface. */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    /** Injects HttpLoggingInterceptor interface. */
    @Provides
    @Singleton
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
