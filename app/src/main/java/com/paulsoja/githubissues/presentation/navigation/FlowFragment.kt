package com.paulsoja.githubissues.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.presentation.base.BaseFragment
import com.paulsoja.githubissues.presentation.navigation.router.FlowRouter
import com.paulsoja.githubissues.presentation.utils.setLaunchScreen
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

abstract class FlowFragment : BaseFragment(R.layout.layout_container) {

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    @Inject
    lateinit var cicerone: Cicerone<FlowRouter>

    protected val navigator: Navigator by lazy {
        object : SupportAppNavigator(this.activity!!, childFragmentManager, R.id.container) {
            override fun backToUnexisting(screen: SupportAppScreen?) {
                super.backToUnexisting(screen)
                screen?.let {
                    navigator.setLaunchScreen(it)
                }
            }

            override fun activityBack() {
                onExit()
            }

            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: onExit()
    }

    open fun onExit() {}

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

}