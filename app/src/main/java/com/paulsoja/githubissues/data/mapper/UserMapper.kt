package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.user.UserApiModel
import com.paulsoja.githubissues.domain.model.user.User
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserApiModel, User>() {
    override fun reverse(to: User): UserApiModel {
        throw NotImplementedError()
    }

    override fun map(from: UserApiModel): User {
        return with(from) {
            User(
                login,
                id,
                nodeId,
                avatarUrl,
                gravatarId,
                userUrl,
                htmlUrl,
                followersUrl,
                followingUrl,
                gistsUrl,
                starredUrl,
                subscriptionsUrl,
                organizationsUrl,
                reposUrl,
                eventsUrl,
                receivedEventsUrl,
                type,
                siteAdmin
            )
        }
    }
}