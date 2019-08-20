package com.paulsoja.githubissues.presentation

import com.paulsoja.githubissues.presentation.di.AppComponent
import com.paulsoja.githubissues.presentation.ui.ActivityModule
import com.paulsoja.githubissues.presentation.ui.activity.ActivityComponent
import com.paulsoja.githubissues.presentation.ui.activity.AppActivity

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

}