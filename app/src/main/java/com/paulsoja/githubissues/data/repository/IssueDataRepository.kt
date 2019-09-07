package com.paulsoja.githubissues.data.repository

import com.paulsoja.githubissues.data.net.IssueApi
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.domain.repository.IssueRepository
import io.reactivex.Single
import javax.inject.Inject

class IssueDataRepository @Inject constructor(
    private val api: IssueApi
) : IssueRepository {

    override fun getSingleIssue(repo: String, owner: String, issueNumber: String): Single<SingleIssue> {
        return api.getIssueById(repo, owner, issueNumber).map {
            // TODO
            SingleIssue(
            it.createdAt,
            it.closedAt!!
            )
        }
    }

}