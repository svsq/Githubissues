package com.paulsoja.githubissues.presentation.ui.flow.sample

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.module.FlowNavigationModule
import com.paulsoja.githubissues.presentation.di.scope.PerFlow
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_first.SampleComponent
import com.paulsoja.githubissues.presentation.ui.flow.sample.sample_second.SampleSecondComponent
import dagger.Subcomponent

@PerFlow
@Subcomponent(modules = [FlowNavigationModule::class])
interface SampleFlowComponent : BaseComponent {
    fun addSampleFragmentComponent(): SampleComponent
    fun addSampleSecondComponent(): SampleSecondComponent

    fun inject(sampleFlowFragment: SampleFlowFragment)
}