package com.paulsoja.githubissues.data.mapper

import com.paulsoja.githubissues.data.model.issue.SingleIssueApiModel
import com.paulsoja.githubissues.data.model.user.UserApiModel
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.domain.model.user.User
import javax.inject.Inject

class IssueMapper @Inject constructor(
    private val userMapper: UserMapper,
    private val labelsMapper: LabelsMapper
) : Mapper<SingleIssueApiModel, SingleIssue>() {

    override fun reverse(to: SingleIssue): SingleIssueApiModel {
        throw NotImplementedError()
    }

    override fun map(from: SingleIssueApiModel): SingleIssue {
        return with(from) {
            val user = user.let { userMapper.map(it) }
            val labels = labels.let { labelsMapper.map(it) }
            SingleIssue(
                url,
                repoUrl,
                labelsUrl,
                commentsUrl,
                eventsUrl,
                htmlUrl,
                id,
                node_id,
                issueNumber,
                issueTitle,
                user,
                labels,
                state,
                isLocked,
                user,
                mapAssignees(assignees),
                milestone,
                comments,
                createdAt,
                updatedAt,
                closedAt,
                authorAssociation,
                issueBody,
                closedBy
            )
        }
    }

    private fun mapAssignees(items: List<UserApiModel>): MutableList<User> {
        return mutableListOf<User>().apply {
            items.forEach {
                add(userMapper.map(it))
            }
        }
    }

}