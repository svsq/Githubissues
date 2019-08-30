package com.paulsoja.githubissues.presentation.ui.sample_flow

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample_first.SampleComponent
import com.paulsoja.githubissues.presentation.ui.sample_flow.sample_second.SampleSecondComponent
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface SampleFlowComponent : BaseComponent {
    fun plusSampleFragmentComponent(): SampleComponent
    fun plusSampleSecondComponent(): SampleSecondComponent

    fun inject(sampleFlowFragment: SampleFlowFragment)
}