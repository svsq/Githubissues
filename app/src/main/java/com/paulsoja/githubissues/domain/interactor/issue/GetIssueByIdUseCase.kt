package com.paulsoja.githubissues.domain.interactor.issue

import com.paulsoja.githubissues.domain.interactor.base.SingleUseCase
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.domain.repository.IssueRepository
import io.reactivex.Single
import javax.inject.Inject

class GetIssueByIdUseCase @Inject constructor(
    private val issueRepository: IssueRepository
) : SingleUseCase<SingleIssue, GetIssueByIdUseCase.Params>() {

    override fun buildSingleUseCase(params: Params): Single<SingleIssue> {
        return issueRepository.getSingleIssue(params.owner, params.repo, params.issueNumber)
            .map { issue ->
                // save to local db
                issue
            }
    }

    data class Params(
        val owner: String,
        val repo: String,
        val issueNumber: Int
    )
}