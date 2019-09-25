package com.paulsoja.githubissues.presentation.ui.flow.issue.card_issue

import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.presentation.base.BaseView

interface IssueCardView : BaseView {

    fun initViews()
    fun showLoadingDialog()
    fun hideLoadingDialog()
    fun onIssueSuccess(issue: SingleIssue)

}