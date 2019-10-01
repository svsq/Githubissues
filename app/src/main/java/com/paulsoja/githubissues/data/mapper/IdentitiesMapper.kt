package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.user.IdentitiesApiModel
import com.paulsoja.githubissues.domain.model.user.Identities
import javax.inject.Inject

class IdentitiesMapper @Inject constructor(): Mapper<IdentitiesApiModel, Identities>() {

    override fun reverse(to: Identities): IdentitiesApiModel {
        throw NotImplementedError()
    }

    override fun map(from: IdentitiesApiModel): Identities {
        return with(from) {
            Identities(provider, externUid, samlProviderId)
        }
    }

}