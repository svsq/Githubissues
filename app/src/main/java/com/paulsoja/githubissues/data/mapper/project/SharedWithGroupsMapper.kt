package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.SharedWithGroupApiModel
import com.paulsoja.githubissues.domain.model.project.SharedWithGroup
import javax.inject.Inject

class SharedWithGroupsMapper @Inject constructor() : Mapper<SharedWithGroupApiModel, SharedWithGroup>() {

    override fun reverse(to: SharedWithGroup): SharedWithGroupApiModel {
        throw NotImplementedError()
    }

    override fun map(from: SharedWithGroupApiModel): SharedWithGroup {
        return with(from) {
            SharedWithGroup(groupId, groupName, groupAccessLevel)
        }
    }

}