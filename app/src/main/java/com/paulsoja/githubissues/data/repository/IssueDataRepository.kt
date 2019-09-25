package com.paulsoja.githubissues.data.repository

import com.paulsoja.githubissues.data.mapper.IssueMapper
import com.paulsoja.githubissues.data.net.IssueApi
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.domain.repository.IssueRepository
import io.reactivex.Single
import javax.inject.Inject

class IssueDataRepository @Inject constructor(
    private val api: IssueApi,
    private val issueMapper: IssueMapper
) : IssueRepository {

    override fun getSingleIssue(
        owner: String,
        repo: String,
        issueNumber: Int
    ): Single<SingleIssue> {
        return api.getIssueById(owner, repo, issueNumber).map {
            issueMapper.map(it)
        }
    }

}