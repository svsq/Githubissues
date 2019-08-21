package com.paulsoja.githubissues.presentation.ui.activity.di

import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowComponent
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(appActivity: AppActivity)
    fun plusLoginFlowComponent(): LoginFlowComponent
}