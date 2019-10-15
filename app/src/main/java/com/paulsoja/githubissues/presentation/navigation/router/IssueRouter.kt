package com.paulsoja.githubissues.presentation.navigation.router

import com.paulsoja.githubissues.domain.model.sample.SampleScreenState
import com.paulsoja.githubissues.presentation.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
class IssueRouter : Router() {

    fun startIssueScreen() {
        newRootScreen(Screens.IssueScreenFlow)
    }

    fun startSampleScreen() {
        newRootScreen(Screens.SampleFlowScreen(SampleScreenState.SAMPLE_1))
    }

    fun startMainFlow() {
        newRootScreen(Screens.MainScreenFlow)
    }

    fun startLoginFlow() {
        newRootScreen(Screens.LoginFlowScreen)
    }

}