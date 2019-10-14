package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.PermissionsApiModel
import com.paulsoja.githubissues.domain.model.project.Permissions
import javax.inject.Inject

class PermissionsMapper @Inject constructor(
    private val projectAccessMapper: ProjectAccessMapper,
    private val groupAccessMapper: GroupAccessMapper
) : Mapper<PermissionsApiModel, Permissions>() {

    override fun reverse(to: Permissions): PermissionsApiModel {
        throw NotImplementedError()
    }

    override fun map(from: PermissionsApiModel): Permissions {
        return with(from) {
            val projectAccess = from.projectAccess?.let { projectAccessMapper.map(it) }
            val groupAccess = from.groupAccess?.let { groupAccessMapper.map(it) }
            Permissions(projectAccess, groupAccess)
        }
    }

}