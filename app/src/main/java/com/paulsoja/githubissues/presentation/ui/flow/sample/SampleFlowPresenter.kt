package com.paulsoja.githubissues.presentation.ui.flow.sample

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import javax.inject.Inject

@PerFlow
@InjectViewState
class SampleFlowPresenter @Inject constructor(
    private val flowRouter: FlowRouter
) : BasePresenter<SampleFlowView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLaunchScreen()
    }

    fun finishFlow() {
        flowRouter.finishFlow()
    }

}