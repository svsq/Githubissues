package com.paulsoja.githubissues.domain.mapper

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.domain.model.project.Project
import com.paulsoja.githubissues.presentation.model.projects.ProjectViewModel
import javax.inject.Inject

class ProjectViewModelMapper @Inject constructor() : Mapper<Project, ProjectViewModel>() {

    override fun reverse(to: ProjectViewModel): Project {
        throw NotImplementedError()
    }

    override fun map(from: Project): ProjectViewModel {
        return with(from) {
            ProjectViewModel(id, title, description, avatar)
        }
    }

}