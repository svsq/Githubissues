package com.paulsoja.githubissues.presentation.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.IssueInjector
import com.paulsoja.githubissues.presentation.base.BaseActivity
import com.paulsoja.githubissues.presentation.base.BaseFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

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
        IssueInjector.plusActivityComponent(this)?.inject(this)
    }

}