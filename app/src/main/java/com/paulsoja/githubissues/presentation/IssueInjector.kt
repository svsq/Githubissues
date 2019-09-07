package com.paulsoja.githubissues.presentation

import com.paulsoja.githubissues.presentation.di.AppComponent
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityModule
import com.paulsoja.githubissues.presentation.ui.issue_flow.IssueFlowComponent
import com.paulsoja.githubissues.presentation.ui.issue_flow.card_issue.IssueCardComponent
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.SampleFlowComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample_first.SampleComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample_second.SampleSecondComponent

object IssueInjector {

    private var appComponent: AppComponent? = null

    fun setAppComponent(appComponent: AppComponent) {
        this.appComponent = appComponent
    }

    // -----------------------------------------------------------
    //                      App Activity
    // -----------------------------------------------------------

    private var activityComponent: ActivityComponent? = null

    fun plusActivityComponent(activity: AppActivity): ActivityComponent? {
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

    fun plusIssueFlowComponent(): IssueFlowComponent? {
        return activityComponent?.plusIssueFlowComponent().also {
            issueFlowComponent = it
        }
    }

    fun clearIssueFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === issueFlowComponent) {
            issueFlowComponent = null
        }
    }

    fun plusIssueCardComponent(): IssueCardComponent? {
        return issueFlowComponent?.plusIssueCardComponent().also {
            issueCardComponent = it
        }
    }

    fun clearIssueCardComponent(closedComponent: BaseComponent?) {
        if (closedComponent === issueCardComponent) {
            issueCardComponent = null
        }
    }

    // -----------------------------------------------------------
    //                     Sample
    // -----------------------------------------------------------

    private var sampleFlowComponent: SampleFlowComponent? = null
    private var sampleComponent: SampleComponent? = null
    private var sampleSecondComponent: SampleSecondComponent? = null

    fun plusSampleFlowComponent(): SampleFlowComponent? {
        return activityComponent?.plusSampleFlowComponent().also {
            sampleFlowComponent = it
        }
    }

    fun clearSampleFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleFlowComponent) {
            sampleFlowComponent = null
        }
    }

    fun plusSampleComponent(): SampleComponent? {
        return sampleFlowComponent?.plusSampleFragmentComponent().also {
            sampleComponent = it
        }
    }

    fun clearSampleComponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleComponent) {
            sampleComponent = null
        }
    }

    fun plusSampleSecondComponent(): SampleSecondComponent? {
        return sampleFlowComponent?.plusSampleSecondComponent().also {
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

    fun plusLoginFlowComponent(): LoginFlowComponent? {
        return activityComponent?.plusLoginFlowComponent().also {
            loginFlowComponent = it
        }
    }

    fun clearLoginFlowComponent(closedComponent: BaseComponent?) {
        if (closedComponent === loginFlowComponent) {
            loginFlowComponent = null
        }
    }

}