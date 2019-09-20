package com.paulsoja.githubissues.presentation.ui.flow.issue

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import javax.inject.Inject

@PerFlow
@InjectViewState
class IsuueFlowPresenter @Inject constructor() : BasePresenter<IssueFlowView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLaunchScreen()
    }

}