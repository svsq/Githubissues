package com.paulsoja.githubissues.presentation.ui.activity

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.di.scope.PerActivity
import com.paulsoja.githubissues.presentation.navigation.router.IssueRouter
import javax.inject.Inject

@InjectViewState
@PerActivity
class AppPresenter @Inject constructor(
    private val router: IssueRouter
) : BasePresenter<MainView>() {

    fun coldStart() {
        router.startIssueScreen()
        /*when {
            preferencesRepository.getToken() == null -> router.startLoginFlow()
            else -> router.startMainFlow()
        }*/
    }

}