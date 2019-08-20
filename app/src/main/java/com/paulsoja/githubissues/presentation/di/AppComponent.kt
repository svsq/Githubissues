package com.paulsoja.githubissues.presentation.di

import com.paulsoja.githubissues.presentation.di.module.ApiModule
import com.paulsoja.githubissues.presentation.di.module.AppModule
import com.paulsoja.githubissues.presentation.di.module.NavigationModule
import com.paulsoja.githubissues.presentation.ui.ActivityModule
import com.paulsoja.githubissues.presentation.ui.activity.ActivityComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AppModule::class,
    ApiModule::class,
    NavigationModule::class
    ]
)
interface AppComponent {
    fun plusActivityComponent(
        activityModule: ActivityModule
    ): ActivityComponent
}