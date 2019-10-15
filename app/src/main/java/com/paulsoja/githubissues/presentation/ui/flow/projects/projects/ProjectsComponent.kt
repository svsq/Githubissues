package com.paulsoja.githubissues.presentation.ui.flow.projects.projects

import com.paulsoja.githubissues.presentation.di.BaseComponent
import com.paulsoja.githubissues.presentation.di.scope.PerFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent
interface ProjectsComponent : BaseComponent {
    fun inject(projectsFragment: ProjectsFragment)
}