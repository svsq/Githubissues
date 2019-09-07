package com.paulsoja.githubissues.presentation.ui.activity.di

import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.issue_flow.IssueFlowComponent
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.SampleFlowComponent
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(appActivity: AppActivity)
    fun plusSampleFlowComponent(): SampleFlowComponent
    fun plusLoginFlowComponent(): LoginFlowComponent
    fun plusIssueFlowComponent(): IssueFlowComponent
}