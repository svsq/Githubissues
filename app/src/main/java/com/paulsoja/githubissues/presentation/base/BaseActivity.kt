package com.paulsoja.githubissues.presentation.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.ui.view.MessageDialog
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    protected abstract val layoutRes: Int
    protected abstract val navigator: Navigator

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependency()
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showNetworkError(shouldReloadOnError: Boolean) {
        val okListener: (() -> Unit)? =
            if (shouldReloadOnError) {
                { reloadOnError() }
            } else null

        MessageDialog.show(this, getString(R.string.error_network), getString(R.string.error_network_title), okListener)
    }

    override fun showHttpError(error: String?, shouldReloadOnError: Boolean) {
        error?.let {
            val okListener: (() -> Unit)? =
                if (shouldReloadOnError) {
                    { reloadOnError() }
                } else null
            MessageDialog.show(this, error, okListener = okListener)
        }
    }

    open fun reloadOnError() {

    }

    override fun showUnexpectedError() {
        MessageDialog.show(this, R.string.error_unexpected)
    }

    abstract fun injectDependency()

}