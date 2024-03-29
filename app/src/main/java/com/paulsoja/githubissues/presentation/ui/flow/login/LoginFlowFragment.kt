package com.paulsoja.githubissues.presentation.ui.flow.login

import android.os.Bundle
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import javax.inject.Inject

class LoginFlowFragment : FlowFragment() {

    companion object {
        fun newInstance(): LoginFlowFragment = LoginFlowFragment()
    }

    @Inject
    lateinit var flowRouter: FlowRouter

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addLoginFlowComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearLoginFlowComponent(closedComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //navigator.setLaunchScreen(Screens.LoginPhoneScreen)
    }

    override fun onExit() {
        flowRouter.finishFlow()
    }

}