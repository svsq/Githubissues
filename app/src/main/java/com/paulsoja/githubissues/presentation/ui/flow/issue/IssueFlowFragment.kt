package com.paulsoja.githubissues.presentation.ui.flow.issue

import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.navigation.FlowFragment

class IssueFlowFragment : FlowFragment(), IssueFlowView {
    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addIssueFlowComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearIssueFlowComponent(closedComponent)
    }

    override fun initIssuesListScreen() {
        //TODO
    }

    override fun initIssueDetailsScreen() {
        //TODO
    }
}