package com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first

import com.arellomobile.mvp.InjectViewState
import com.paulsoja.githubissues.domain.interactor.sample.GetSampleUseCase
import com.paulsoja.githubissues.presentation.base.BasePresenter
import com.paulsoja.githubissues.presentation.navigation.Screens
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

@InjectViewState
class SamplePresenter @Inject constructor(
    private val flowRouter: FlowRouter,
    private val getSampleUseCase: GetSampleUseCase
) : BasePresenter<SampleView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initViews()
    }

    fun loadData(value: String, value2: String) {
        val params = GetSampleUseCase.Params(value, value2)
        disposables += getSampleUseCase.execute(params)
            .doOnSubscribe {
                viewState.showLoadingDialog()
            }.doFinally {
                viewState.hideLoadingDialog()
            }.subscribe({
                viewState.onSuccessLoadList(it)
            }, { throwable ->
                handleRetrofitError(throwable)
            })
    }

    fun goToSecondSample() {
        flowRouter.navigateTo(Screens.SampleSecondScreen)
    }

    fun finish() {
        flowRouter.finishFlow()
    }

}