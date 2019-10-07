package com.paulsoja.githubissues.data.net

import com.paulsoja.githubissues.data.model.issue.SingleIssueApiModel
import com.paulsoja.githubissues.data.model.project.ProjectApiModel
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IssueApi {

    @GET("repos/{owner}/{repo}/issues/{issue_number}")
    fun getIssueById(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int
    ): Single<SingleIssueApiModel>

    @GET("projects")
    fun getProjects(
        @Query("visibility") visibility: String,
        @Query("owned") owned: Boolean = true
    ): Single<List<ProjectApiModel>>

}