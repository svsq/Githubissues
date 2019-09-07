package com.paulsoja.githubissues.domain.repository

import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import io.reactivex.Single

interface IssueRepository {

    fun getSingleIssue(repo: String, owner: String, issueNumber: String): Single<SingleIssue>

}