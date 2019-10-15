package com.paulsoja.githubissues.data.mapper.project

import com.paulsoja.githubissues.data.mapper.Mapper
import com.paulsoja.githubissues.data.model.project.OwnerApiModel
import com.paulsoja.githubissues.domain.model.project.Owner
import javax.inject.Inject

class OwnerMapper @Inject constructor() : Mapper<OwnerApiModel, Owner>() {

    override fun reverse(to: Owner): OwnerApiModel {
        throw NotImplementedError()
    }

    override fun map(from: OwnerApiModel): Owner {
        return with(from) {
            Owner(id, name, username, createdAt)
        }
    }

}