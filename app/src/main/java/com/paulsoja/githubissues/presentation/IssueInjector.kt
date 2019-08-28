package com.paulsoja.githubissues.presentation

import com.paulsoja.githubissues.presentation.di.AppComponent
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityModule
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.SampleFlowComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample.SampleComponent

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
    //                     Sample
    // -----------------------------------------------------------

    private var sampleFlowComponent: SampleFlowComponent? = null
    private var sampleComponent: SampleComponent? = null

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

    fun clearSampleCOmponent(closedComponent: BaseComponent?) {
        if (closedComponent === sampleComponent) {
            sampleComponent = null
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