package com.paulsoja.githubissues.presentation.navigation

import androidx.fragment.app.Fragment
import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.ui.login_flow.LoginFlowFragment
import com.paulsoja.githubissues.presentation.ui.sample_flow.SampleFlowFragment
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample.SampleFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainScreenFlow : SupportAppScreen() {
        override fun getFragment() = Fragment()
    }

    // Sample flow
    data class SampleFlowScreen(
        val state: SampleScreenState
    ) : SupportAppScreen() {
        override fun getFragment() = SampleFlowFragment.newInstance(state)
    }

    data class SampleScreen(
        val state: SampleScreenState
    ) : SupportAppScreen() {
        override fun getFragment() = SampleFragment.newInstance(state)
    }

    // Login flow
    object LoginFlowScreen : SupportAppScreen() {
        override fun getFragment() = LoginFlowFragment.newInstance()
    }

}