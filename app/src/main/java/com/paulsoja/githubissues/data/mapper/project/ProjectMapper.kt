package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.ProjectApiModel
import com.paulsoja.githubissues.domain.model.project.Project
import javax.inject.Inject

class ProjectMapper @Inject constructor() : Mapper<ProjectApiModel, Project>() {

    override fun reverse(to: Project): ProjectApiModel {
        throw NotImplementedError()
    }

    override fun map(from: ProjectApiModel): Project {
        return with(from) {
            Project(id, name, description, avatarUrl, forksCount.toInt(), starCount.toInt())
        }
    }
}