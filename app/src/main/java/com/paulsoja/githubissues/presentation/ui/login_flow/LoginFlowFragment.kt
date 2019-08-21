package com.paulsoja.githubissues.presentation.ui.login_flow

import android.os.Bundle
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment
import com.paulsoja.githubissues.presentation.navigation.Screens
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import com.paulsoja.githubissues.presentation.utils.setLaunchScreen
import javax.inject.Inject

class LoginFlowFragment : FlowFragment() {

    companion object {
        fun newInstance(): LoginFlowFragment = LoginFlowFragment()
    }

    @Inject
    lateinit var flowRouter: FlowRouter

    override val layoutRes: Int = R.layout.layout_container

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusLoginFlowComponent()?.also {
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