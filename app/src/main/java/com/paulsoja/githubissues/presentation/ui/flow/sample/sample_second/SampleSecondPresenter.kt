package com.paulsoja.githubissues.presentation.ui.flow.sample.sample_second

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.navigation.Screens
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import javax.inject.Inject

@InjectViewState
class SampleSecondPresenter @Inject constructor(
    private val flowRouter: FlowRouter
) : BasePresenter<SampleSecondView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initViews()
    }

    fun goToLoginScreen() {
        flowRouter.newRootFlow(Screens.LoginFlowScreen)
    }

    fun onBackPressed() {
        flowRouter.exit()
    }

}