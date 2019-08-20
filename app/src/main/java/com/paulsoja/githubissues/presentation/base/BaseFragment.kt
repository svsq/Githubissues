package com.paulsoja.githubissues.presentation.base

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.ui.view.CorrectMessageDialog
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    protected abstract val layoutRes: Int

    @Inject
    protected lateinit var errorDialog: CorrectMessageDialog

    protected var closedComponent: BaseComponent? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        closedComponent = injectDaggerDependency()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layoutRes, container, false)
    }

    abstract fun injectDaggerDependency(): BaseComponent?
    abstract fun releaseDaggerDependency()

    open fun onBackPressed() {}

    override fun onDestroy() {
        releaseDaggerDependency()
        closedComponent = null
        super.onDestroy()
    }

    override fun showNetworkError(shouldReloadOnError: Boolean) {
        context?.let {
            val okListener: (() -> Unit)? =
                if (shouldReloadOnError) {
                    { reloadOnError() }
                } else null
            if (!errorDialog.isVisible()) {
                errorDialog.show(it, getString(R.string.error_network), getString(R.string.error_network_title), okListener)
            }
        }
    }

    override fun showHttpError(error: String?, shouldReloadOnError: Boolean) {
        error?.let {
            context?.let { context ->
                val okListener: (() -> Unit)? =
                    if (shouldReloadOnError) {
                        { reloadOnError() }
                    } else null
                if (TextUtils.isEmpty(error)) {
                    if (!errorDialog.isVisible()) {
                        errorDialog.show(context, R.string.error_unexpected, okListener = okListener)
                    }
                } else {
                    if (!errorDialog.isVisible()) {
                        errorDialog.show(context, error, okListener = okListener)
                    }
                }
            }
        }
    }

    open fun reloadOnError() {

    }

    override fun showUnexpectedError() {
        context?.let {
            if (!errorDialog.isVisible()) {
                errorDialog.show(it, R.string.error_unexpected)
            }
        }
    }

}