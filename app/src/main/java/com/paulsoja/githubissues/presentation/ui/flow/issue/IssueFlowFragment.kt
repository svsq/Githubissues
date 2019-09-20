package com.paulsoja.githubissues.presentation.ui.flow.issue

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment
import com.paulsoja.githubissues.presentation.navigation.Screens
import com.paulsoja.githubissues.presentation.utils.setLaunchScreen
import javax.inject.Inject

class IssueFlowFragment : FlowFragment(), IssueFlowView {

    companion object {
        fun newInstance() = IssueFlowFragment()
    }

    override fun initLaunchScreen() {
        navigator.setLaunchScreen(Screens.IssueCardScreen)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: IsuueFlowPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusIssueFlowComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearIssueFlowComponent(closedComponent)
    }

}