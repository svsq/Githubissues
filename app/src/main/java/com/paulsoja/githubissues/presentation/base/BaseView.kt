package com.paulsoja.githubissues.presentation.base

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

    fun showNetworkError(shouldReloadOnError: Boolean)

    fun showHttpError(error: String?, shouldReloadOnError: Boolean)

    fun showUnexpectedError()

    enum class ErrorState {
        NETWORK_ERROR, HTTP_ERROR, UNEXPECTED_ERROR, NOTHING
    }

}