package com.paulsoja.githubissues.presentation.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences(app.packageName + "_prefs", Context.MODE_PRIVATE)
    }

}