package com.paulsoja.githubissues.presentation

import com.paulsoja.githubissues.presentation.di.AppComponent
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity
import com.paulsoja.githubissues.presentation.ui.activity.di.ActivityModule
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowComponent

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