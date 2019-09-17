package com.paulsoja.githubissues.presentation.di

import com.paulsoja.githubissues.presentation.di.module.*
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        RepositoryModule::class,
        NavigationModule::class,
        FlowNavigationModule::class
    ]
)
interface AppComponent {
    fun plusActivityComponent(
        activityModule: ActivityModule
    ): ActivityComponent
}