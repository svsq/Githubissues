package com.paulsoja.githubissues.presentation.ui.issue_flow

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.ui.issue_flow.card_issue.IssueCardComponent
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface IssueFlowComponent : BaseComponent {
    fun plusIssueCardComponent(): IssueCardComponent

    fun inject(issueFlowFragment: IssueFlowFragment)
}