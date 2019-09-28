package com.paulsoja.githubissues.presentation.ui.flow.issue

import android.os.Bundle
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import javax.inject.Inject

class IssueFlowFragment : FlowFragment() {

    companion object {
        fun newInstance() = IssueFlowFragment()
    }

    @Inject
    lateinit var flowRouter: FlowRouter

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addIssueFlowComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        return IssueInjector.clearIssueFlowComponent(closedComponent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onExit() {
        super.onExit()


    }

}
