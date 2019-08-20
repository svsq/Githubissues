package com.paulsoja.githubissues.presentation.navigation

import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Singleton
class IssueRouter : Router() {

    fun startMainFlow() {
        newRootScreen(Screens.MainScreenFlow)
    }
}