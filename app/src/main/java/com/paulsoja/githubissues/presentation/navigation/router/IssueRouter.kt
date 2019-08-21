package com.paulsoja.githubissues.presentation.navigation.router

import com.paulsoja.githubissues.presentation.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
class IssueRouter : Router() {

    fun startMainFlow() {
        newRootScreen(Screens.MainScreenFlow)
    }

    fun startLoginFlow() {
        newRootScreen(Screens.LoginFlowScreen)
    }

}