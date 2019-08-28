package com.paulsoja.githubissues.presentation.di.module

import android.app.Application
import com.google.gson.GsonBuilder
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import com.paulsoja.githubissues.BuildConfig
import com.paulsoja.githubissues.BuildConfig.BASE_URL
import com.paulsoja.githubissues.data.HttpAuthInterceptor
import com.paulsoja.githubissues.data.RxErrorHandlingCallAdapterFactory
import com.paulsoja.githubissues.data.net.SampleApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesOkHttpCache(application: Application): Cache {
        val size: Long = 15 * 1024 * 1024 // 15 MB
        return Cache(application.cacheDir, size)
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): GsonBuilder {
        return GsonBuilder()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor, cache: Cache, authInterceptor: HttpAuthInterceptor
    ): OkHttpClient {

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(loggingInterceptor)
        builder.addInterceptor(OkHttpProfilerInterceptor())
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        builder.cache(cache)
        builder.addInterceptor(authInterceptor)
        return builder.build()

    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonBuilder: GsonBuilder, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideSampleApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }

    /*@Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }*/

}