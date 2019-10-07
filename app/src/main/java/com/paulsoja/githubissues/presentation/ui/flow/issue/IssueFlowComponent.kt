package com.paulsoja.githubissues.presentation.ui.flow.issue

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.ui.flow.issue.card_issue.IssueCardComponent
import com.paulsoja.githubissues.presentation.ui.flow.issue.projects.ProjectsComponent
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface IssueFlowComponent : BaseComponent {
    fun addIssueCardComponent(): IssueCardComponent
    fun addProjectsComponent(): ProjectsComponent

    fun inject(issueFlowFragment: IssueFlowFragment)
}