package com.paulsoja.githubissues.presentation.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseActivity
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.utils.color
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class AppActivity : BaseActivity(), MainView {

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.root) as? BaseFragment

    override val layoutRes = R.layout.activity_app

    override val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.root) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                //fix incorrect order lifecycle categoryCategoryCallback of MainTabsFlowFragment
                fragmentTransaction.setReorderingAllowed(true)
            }
        }

    override fun injectDependency() {
        IssueInjector.addActivityComponent(this)?.inject(this)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: AppPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        window.decorView.setBackgroundColor(color(R.color.white))
        presenter.coldStart()
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onDestroy() {
        IssueInjector.clearActivityComponent()
        super.onDestroy()
    }


}