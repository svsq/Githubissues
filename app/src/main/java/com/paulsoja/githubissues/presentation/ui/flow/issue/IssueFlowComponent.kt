package com.paulsoja.githubissues.presentation.ui.flow.issue

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface IssueFlowComponent : BaseComponent {

    fun inject(issueFlowFragment: IssueFlowFragment)
}