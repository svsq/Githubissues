package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.GroupAccessApiModel
import com.paulsoja.githubissues.domain.model.project.GroupAccess
import javax.inject.Inject

class GroupAccessMapper @Inject constructor() : Mapper<GroupAccessApiModel, GroupAccess>() {

    override fun reverse(to: GroupAccess): GroupAccessApiModel {
        throw NotImplementedError()
    }

    override fun map(from: GroupAccessApiModel): GroupAccess {
        return with(from) {
            GroupAccess(accessLevel, notificationLevel)
        }
    }

}