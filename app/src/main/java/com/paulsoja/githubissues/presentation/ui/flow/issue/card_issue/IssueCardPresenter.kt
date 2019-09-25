package com.paulsoja.githubissues.presentation.ui.flow.issue.card_issue

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.domain.interactor.issue.GetIssueByIdUseCase
import com.paulsoja.githubissues.presentation.base.BasePresenter
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

@InjectViewState
class IssueCardPresenter @Inject constructor(
    private val getIssueByIdUseCase: GetIssueByIdUseCase
) : BasePresenter<IssueCardView>() {

    override fun onFirstViewAttach() {
        viewState.initViews()
        getIssue()
    }

    private fun getIssue() {
        val params = GetIssueByIdUseCase.Params("paulsoja", "Githubissues", 1)
        disposables += getIssueByIdUseCase.execute(params)
            .doOnSubscribe { viewState.showLoadingDialog() }
            .doFinally { viewState.hideLoadingDialog() }
            .subscribe({
                viewState.onIssueSuccess(it)
            }, {
                handleRetrofitError(it)
            })
    }

}