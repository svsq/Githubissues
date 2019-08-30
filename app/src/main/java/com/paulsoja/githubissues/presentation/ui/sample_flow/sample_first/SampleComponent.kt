package com.paulsoja.githubissues.presentation.ui.sample_flow.sample_first

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.scope.PerFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent
interface SampleComponent : BaseComponent {
    fun inject(sampleFragment: SampleFragment)
}