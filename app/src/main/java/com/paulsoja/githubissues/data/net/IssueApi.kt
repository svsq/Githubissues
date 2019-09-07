package com.paulsoja.githubissues.data.net

import com.paulsoja.githubissues.data.model.issue.SingleIssueApiModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IssueApi {

    @GET("repos/{owner}/{repo}/{issue_number}")
    fun getIssueById(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: String
    ): Single<SingleIssueApiModel>

}