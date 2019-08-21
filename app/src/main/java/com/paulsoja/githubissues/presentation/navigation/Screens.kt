package com.paulsoja.githubissues.presentation.navigation

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object MainScreenFlow : SupportAppScreen() {
        override fun getFragment() = Fragment()
    }

    // Login flow
    object LoginFlowScreen : SupportAppScreen() {
        override fun getFragment() = Fragment()
    }

}