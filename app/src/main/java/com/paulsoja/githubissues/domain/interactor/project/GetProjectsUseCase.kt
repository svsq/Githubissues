package com.paulsoja.githubissues.domain.interactor.project

import com.paulsoja.githubissues.domain.interactor.base.SingleUseCase
import com.paulsoja.githubissues.domain.model.project.Project
import com.paulsoja.githubissues.domain.repository.IssueRepository
import io.reactivex.Single
import javax.inject.Inject

class GetProjectsUseCase @Inject constructor(
    private val issueRepository: IssueRepository
) : SingleUseCase<List<Project>, GetProjectsUseCase.Params>() {

    override fun buildSingleUseCase(params: Params): Single<List<Project>> {
        return issueRepository.getProjects(params.visibility)
    }

    data class Params(
        val visibility: String
    )
}