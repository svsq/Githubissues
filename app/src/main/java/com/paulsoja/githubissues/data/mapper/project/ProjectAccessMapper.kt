package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.ProjectAccessApiModel
import com.paulsoja.githubissues.domain.model.project.ProjectAccess
import javax.inject.Inject

class ProjectAccessMapper @Inject constructor() : Mapper<ProjectAccessApiModel, ProjectAccess>() {

    override fun reverse(to: ProjectAccess): ProjectAccessApiModel {
        throw NotImplementedError()
    }

    override fun map(from: ProjectAccessApiModel): ProjectAccess {
        return with(from) {
            ProjectAccess(accessLevel, notificationLevel)
        }
    }

}