package com.paulsoja.githubissues.presentation.ui.flow.issue.card_issue

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import javax.inject.Inject

class IssueCardFragment : BaseFragment(R.layout.fragment_issue_card),
    IssueCardView {

    companion object {
        fun newInstance() =
            IssueCardFragment()
    }

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.addIssueCardComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearIssueCardComponent(closedComponent)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: IssueCardPresenter

    @ProvidePresenter
    fun providePresenter(): IssueCardPresenter {
        return presenter
    }

}