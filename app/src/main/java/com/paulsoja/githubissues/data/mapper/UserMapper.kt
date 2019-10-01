package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.user.UserApiModel
import com.paulsoja.githubissues.domain.model.user.User
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val identitiesMapper: IdentitiesMapper
) : Mapper<UserApiModel, User>() {

    override fun reverse(to: User): UserApiModel {
        throw NotImplementedError()
    }

    override fun map(from: UserApiModel): User {
        return with(from) {
            val identities = identities.map { identitiesMapper.map(it) }
            User(
                id,
                name,
                username,
                state,
                avatarUrl,
                webUrl,
                createdAt,
                bio,
                location,
                publicEmail,
                skype,
                linkedin,
                twitter,
                websiteUrl,
                organization,
                lastSignInAt,
                confirmedAt,
                lastActivityOn,
                email,
                themeId,
                colorSchemeId,
                projectsLimit,
                currentSignInAt,
                identities,
                canCreateGroup,
                canCreateProject,
                twoFactorEnabled,
                external,
                privateProfile,
                sharedRunnersMinutesLimit,
                extraSharedRunnersMinutesLimit
            )
        }
    }
}