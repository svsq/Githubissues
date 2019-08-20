package com.paulsoja.githubissues

import android.app.Application
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.DaggerAppComponent
import com.paulsoja.githubissues.presentation.di.module.AppModule

class IssueApplication : Application() {

    companion object {
        lateinit var issueApplication: IssueApplication
    }

    override fun onCreate() {
        super.onCreate()
        issueApplication = this
        initAppComponent()
    }

    private fun initAppComponent() {
        IssueInjector.setAppComponent(
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        )
    }

}