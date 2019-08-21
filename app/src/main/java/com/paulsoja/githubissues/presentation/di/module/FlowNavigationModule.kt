package com.paulsoja.githubissues.presentation.di.module

import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import com.paulsoja.githubissues.presentation.navigation.router.IssueRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone

@Module
class FlowNavigationModule {

    @Provides
    @PerFlow
    fun provideCicerone(issueRouter: IssueRouter) = Cicerone.create(
        FlowRouter(
            issueRouter
        )
    )

    @Provides
    @PerFlow
    fun provideRouter(cicerone: Cicerone<FlowRouter>): FlowRouter = cicerone.router

}