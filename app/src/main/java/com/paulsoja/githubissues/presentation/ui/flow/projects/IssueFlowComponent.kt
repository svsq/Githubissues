package com.paulsoja.githubissues.presentation.ui.flow.projects

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.ui.flow.projects.card_issue.IssueCardComponent
import com.paulsoja.githubissues.presentation.ui.flow.projects.project_info.ProjectInfoComponent
import com.paulsoja.githubissues.presentation.ui.flow.projects.projects.ProjectsComponent
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface IssueFlowComponent : BaseComponent {
    fun addIssueCardComponent(): IssueCardComponent
    fun addProjectsComponent(): ProjectsComponent
    fun addProjectInfoComponent(): ProjectInfoComponent

    fun inject(issueFlowFragment: IssueFlowFragment)
}