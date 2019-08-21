package com.paulsoja.githubissues.presentation.ui.login_flow

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface LoginFlowComponent : BaseComponent {
    //fun plusPhoneFragmentComponent(): PhoneFragmentComponent

    fun inject(loginFlowFragment: LoginFlowFragment)
}