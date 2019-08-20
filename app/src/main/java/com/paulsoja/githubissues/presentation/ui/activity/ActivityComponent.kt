package com.paulsoja.githubissues.presentation.ui.activity

import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import com.paulsoja.githubissues.presentation.ui.ActivityModule
import dagger.Subcomponent

@PerActivity
@Subcomponent (modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(appActivity: AppActivity)
}