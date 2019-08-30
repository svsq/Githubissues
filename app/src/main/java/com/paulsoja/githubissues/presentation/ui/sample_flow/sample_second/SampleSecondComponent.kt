package com.paulsoja.githubissues.presentation.ui.sample_flow.sample_second

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.scope.PerFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent
interface SampleSecondComponent : BaseComponent {
    fun inject(sampleSecondFragment: SampleSecondFragment)
}