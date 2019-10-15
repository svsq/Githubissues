package com.paulsoja.githubissues.presentation.ui.activity.di

import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.flow.projects.IssueFlowComponent
import com.paulsoja.githubissues.presentation.ui.flow.login.LoginFlowComponent
import com.paulsoja.githubissues.presentation.ui.flow.sample.SampleFlowComponent
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(appActivity: AppActivity)
    fun addSampleFlowComponent(): SampleFlowComponent
    fun addLoginFlowComponent(): LoginFlowComponent
    fun addIssueFlowComponent(): IssueFlowComponent
}