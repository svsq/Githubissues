package com.paulsoja.githubissues.presentation.ui.flow.projects.project_info

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.scope.PerFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent
interface ProjectInfoComponent : BaseComponent {
    fun inject(projectInfoFragment: ProjectInfoFragment)
}