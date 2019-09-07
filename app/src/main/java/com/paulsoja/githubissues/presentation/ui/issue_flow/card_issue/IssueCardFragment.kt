package com.paulsoja.githubissues.presentation.ui.issue_flow.card_issue

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import javax.inject.Inject

class IssueCardFragment : BaseFragment(), IssueCardView {

    companion object {
        fun newInstance() = IssueCardFragment()
    }

    override val layoutRes: Int = R.layout.fragment_issue_card

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusIssueCardComponent()?.also {
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