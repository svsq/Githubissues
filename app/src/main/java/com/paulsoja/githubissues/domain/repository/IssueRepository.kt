package com.paulsoja.githubissues.domain.repository

import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import io.reactivex.Single

interface IssueRepository {

    fun getSingleIssue(owner: String, repo: String, issueNumber: Int): Single<SingleIssue>

}