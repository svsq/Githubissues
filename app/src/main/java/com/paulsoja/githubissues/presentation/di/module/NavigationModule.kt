package com.paulsoja.githubissues.presentation.di.module

import com.paulsoja.githubissues.presentation.navigation.IssueRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideCicerone() = Cicerone.create(IssueRouter())

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<IssueRouter>): IssueRouter = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(cicerone: Cicerone<IssueRouter>) = cicerone.navigatorHolder

}