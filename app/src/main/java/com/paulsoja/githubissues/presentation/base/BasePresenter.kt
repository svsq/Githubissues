package com.paulsoja.githubissues.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.google.gson.stream.MalformedJsonException
import com.paulsoja.githubissues.data.RetrofitException
import com.paulsoja.githubissues.data.model.server_error.ServerErrorResponse
import com.paulsoja.githubissues.domain.repository.PreferencesRepository
import com.paulsoja.githubissues.presentation.navigation.router.IssueRouter
import io.reactivex.disposables.CompositeDisposable
import java.net.SocketTimeoutException
import javax.inject.Inject

open class BasePresenter<V : MvpView> : MvpPresenter<V>() {

    var errorState: BaseView.ErrorState = BaseView.ErrorState.NOTHING
    val disposables = CompositeDisposable()
    @Inject
    lateinit var issueRouter: IssueRouter
    @Inject
    lateinit var preferencesRepository: PreferencesRepository
    /**
     * setTrue if you want to call reloadOnError() on "Ok" button click in error dialog in baseFragment
     */
    protected open val shouldReloadOnError = false

    var initialLoadFinished = false

    override fun onDestroy() {
        disposables.clear()
    }

    // Override in your presenters when you have to
    open fun handleServerError(code: Int, error: ServerErrorResponse?) {
        if (code == 401) {
            preferencesRepository.clear()
            issueRouter.startIssueScreen()
        } else {
            // parse error - example
            //(viewState as? BaseView)?.showHttpError(error!!.errors[0].description, shouldReloadOnError)
        }
    }

    open fun reloadOnError() {

    }

    protected fun handleRetrofitError(e: Throwable) {
        if (e is RetrofitException) {
            try {
                val err = e.getErrorBodyAs(ServerErrorResponse::class.java)
                when (e.serverErrorType) {
                    RetrofitException.ServerErrorType.HTTP -> {
                        handleServerError(e.response?.code() ?: 500, err)
                    }
                    RetrofitException.ServerErrorType.NETWORK -> {
                        if (e.exception is SocketTimeoutException) {
                            (viewState as? BaseView)?.showHttpError("", shouldReloadOnError)
                        } else {
                            (viewState as? BaseView)?.showNetworkError(shouldReloadOnError)
                        }
                    }
                    RetrofitException.ServerErrorType.UNEXPECTED -> (viewState as? BaseView)?.showUnexpectedError()
                }
            } catch (e: MalformedJsonException) {
                (viewState as? BaseView)?.showUnexpectedError()
            }
        }
    }

}