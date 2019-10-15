package com.paulsoja.githubissues.data.repository

import com.paulsoja.githubissues.data.mapper.IssueMapper
import com.paulsoja.githubissues.data.mapper.project.ProjectMapper
import com.paulsoja.githubissues.data.net.IssueApi
import com.paulsoja.githubissues.domain.model.issue.SingleIssue
import com.paulsoja.githubissues.domain.model.project.Project
import com.paulsoja.githubissues.domain.repository.IssueRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IssueDataRepository @Inject constructor(
    private val api: IssueApi,
    private val issueMapper: IssueMapper,
    private val projectMapper: ProjectMapper
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

    override fun getProjects(visibility: String): Single<List<Project>> {
        return api.getProjects(visibility).map {
            projectMapper.map(it)
        }
    }

}