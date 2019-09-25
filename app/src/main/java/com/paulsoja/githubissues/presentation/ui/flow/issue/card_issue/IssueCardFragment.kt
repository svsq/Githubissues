package com.paulsoja.githubissues.presentation.ui.flow.issue.card_issue

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.view.LoadingPopupDialog
import kotlinx.android.synthetic.main.fragment_issue_card.*
import javax.inject.Inject

class IssueCardFragment : BaseFragment(R.layout.fragment_issue_card), IssueCardView {

    companion object {
        fun newInstance() = IssueCardFragment()
    }

    override fun injectDaggerDependency(): BaseComponent? {
        return IssueInjector.plusIssueCardComponent()?.also {
            it.inject(this)
        }
    }

    override fun releaseDaggerDependency() {
        IssueInjector.clearIssueCardComponent(closedComponent)
    }

    override fun initViews() {
        //loadingDialog = LoadingPopupDialog(layoutInflater)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: IssueCardPresenter

    @ProvidePresenter
    fun providePresenter(): IssueCardPresenter {
        return presenter
    }

    override fun onIssueSuccess(issue: SingleIssue) {
        tvIssueNumber.text = "#${issue.issueNumber}: ${issue.issueTitle}"
        tvIssueTitle.text = issue.issueTitle
        tvIssueStatusBtn.text = issue.labels[0].name
    }

    override fun showLoadingDialog() {
        //loadingDialog.show()
    }

    override fun hideLoadingDialog() {
        //loadingDialog.hide()
    }

}