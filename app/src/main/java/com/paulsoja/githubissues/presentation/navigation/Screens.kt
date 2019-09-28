package com.paulsoja.githubissues.presentation.navigation

import androidx.fragment.app.Fragment
import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.ui.flow.issue.IssueFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.login.LoginFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.SampleFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first.SampleFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_second.SampleSecondFragment
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

    object SampleSecondScreen : SupportAppScreen() {
        override fun getFragment() = SampleSecondFragment.newInstance()
    }

    // Login flow
    object LoginFlowScreen : SupportAppScreen() {
        override fun getFragment() = LoginFlowFragment.newInstance()
    }

    // Issue flow
    object IssueFlowScreen : SupportAppScreen() {
        override fun getFragment() = IssueFlowFragment.newInstance()
    }
}