package com.paulsoja.githubissues.presentation.ui.activity.di

import androidx.appcompat.app.AppCompatActivity
import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    fun provideFragmentManager() = activity.supportFragmentManager

}