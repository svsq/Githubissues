package com.paulsoja.githubissues.presentation

import com.paulsoja.githubissues.presentation.di.AppComponent
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityModule
import com.paulsoja.githubissues.presentation.ui.flow.projects.IssueFlowComponent
import com.paulsoja.githubissues.presentation.ui.flow.projects.card_issue.IssueCardComponent
import com.paulsoja.githubissues.presentation.ui.flow.projects.projects.ProjectsComponent
import com.paulsoja.githubissues.presentation.ui.flow.login.LoginFlowComponent
import com.paulsoja.githubissues.presentation.ui.flow.projects.project_info.ProjectInfoComponent
import com.paulsoja.githubissues.presentation.ui.flow.sample.SampleFlowComponent
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first.SampleComponent
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_second.SampleSecondComponent

object IssueInjector {

    private var appComponent: AppComponent? = null

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

    // -----------------------------------------------------------
    //                      App Activity
    // -----------------------------------------------------------

    private var activityComponent: ActivityComponent? = null

    fun addActivityComponent(activity: AppActivity): ActivityComponent? {
        return appComponent?.plusActivityComponent(
            ActivityModule(activity)
        ).also {
            activityComponent = it
        }
    }

    fun clearActivityComponent() {
        activityComponent = null
    }

    // -----------------------------------------------------------
    //                     Issue
    // -----------------------------------------------------------

    private var issueFlowComponent: IssueFlowComponent? = null
    private var issueCardComponent: IssueCardComponent? = null
    private var projectsComponent: ProjectsComponent? = null
    private var projectInfoComponent: ProjectInfoComponent? = null

    fun plusIssueFlowComponent(): IssueFlowComponent? {
        return activityComponent?.addIssueFlowComponent().also {
            issueFlowComponent = it
        }
    }

    fun clearIssueFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === issueFlowComponent) {
            issueFlowComponent = null
        }
    }

    fun plusIssueCardComponent(): IssueCardComponent? {
        return issueFlowComponent?.addIssueCardComponent().also {
            issueCardComponent = it
        }
    }

    fun clearIssueCardComponent(closedComponent: BaseComponent?) {
        if (closedComponent === issueCardComponent) {
            issueCardComponent = null
        }
    }

    fun addProjectsComponent(): ProjectsComponent? {
        return issueFlowComponent?.addProjectsComponent().also {
            projectsComponent = it
        }
    }

    fun clearProjectsComponent(closedComponent: BaseComponent?) {
        if (closedComponent === projectsComponent) {
            projectsComponent = null
        }
    }

    fun addProjectInfoComponent(): ProjectInfoComponent? {
        return issueFlowComponent?.addProjectInfoComponent().also {
            projectInfoComponent = it
        }
    }

    fun clearProjectInfoComponent(closedComponent: BaseComponent?) {
        if (closedComponent === projectInfoComponent) {
            projectInfoComponent = null
        }
    }

    // -----------------------------------------------------------
    //                     Sample
    // -----------------------------------------------------------

    private var sampleFlowComponent: SampleFlowComponent? = null
    private var sampleComponent: SampleComponent? = null
    private var sampleSecondComponent: SampleSecondComponent? = null

    fun addSampleFlowComponent(): SampleFlowComponent? {
        return activityComponent?.addSampleFlowComponent().also {
            sampleFlowComponent = it
        }
    }

    fun clearSampleFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleFlowComponent) {
            sampleFlowComponent = null
        }
    }

    fun addSampleComponent(): SampleComponent? {
        return sampleFlowComponent?.addSampleFragmentComponent().also {
            sampleComponent = it
        }
    }

    fun clearSampleComponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleComponent) {
            sampleComponent = null
        }
    }

    fun addSampleSecondComponent(): SampleSecondComponent? {
        return sampleFlowComponent?.addSampleSecondComponent().also {
            sampleSecondComponent = it
        }
    }

    fun clearSampleSecondComponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleSecondComponent) {
            sampleSecondComponent = null
        }
    }

    // -----------------------------------------------------------
    //                     Login and Auth
    // -----------------------------------------------------------

    private var loginFlowComponent: LoginFlowComponent? = null

    fun addLoginFlowComponent(): LoginFlowComponent? {
        return activityComponent?.addLoginFlowComponent().also {
            loginFlowComponent = it
        }
    }

    fun clearLoginFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === loginFlowComponent) {
            loginFlowComponent = null
        }
    }

}