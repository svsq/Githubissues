package com.paulsoja.githubissues.presentation.navigation

import androidx.fragment.app.Fragment
import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.ui.flow.projects.IssueFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.projects.card_issue.IssueCardFragment
import com.paulsoja.githubissues.presentation.ui.flow.projects.projects.ProjectsFragment
import com.paulsoja.githubissues.presentation.ui.flow.login.LoginFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.projects.project_info.ProjectInfoFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.SampleFlowFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first.SampleFragment
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_second.SampleSecondFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainScreenFlow : SupportAppScreen() {
        override fun getFragment() = Fragment()
    }

    // Issue flow
    object IssueScreenFlow : SupportAppScreen() {
        override fun getFragment() = IssueFlowFragment.newInstance()
    }

    object ProjectsScreen : SupportAppScreen() {
        override fun getFragment() = ProjectsFragment.newInstance()
    }

    data class ProjectInfoScreen(val projectId: Long) : SupportAppScreen() {
        override fun getFragment() = ProjectInfoFragment.newInstance(projectId)
    }

    object IssueCardScreen : SupportAppScreen() {
        override fun getFragment() = IssueCardFragment.newInstance()
    }

    // Sample flow
    data class SampleFlowScreen(val state: SampleScreenState) : SupportAppScreen() {
        override fun getFragment() = SampleFlowFragment.newInstance(state)
    }

    data class SampleScreen(val state: SampleScreenState) : SupportAppScreen() {
        override fun getFragment() = SampleFragment.newInstance(state)
    }

    object SampleSecondScreen : SupportAppScreen() {
        override fun getFragment() = SampleSecondFragment.newInstance()
    }

    // Login flow
    object LoginFlowScreen : SupportAppScreen() {
        override fun getFragment() = LoginFlowFragment.newInstance()
    }
}