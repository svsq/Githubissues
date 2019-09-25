package com.paulsoja.githubissues.data.net

import com.paulsoja.githubissues.data.model.issue.SingleIssueApiModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IssueApi {

    @GET("repos/{owner}/{repo}/issues/{issue_number}")
    fun getIssueById(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("issue_number") issueNumber: Int
    ): Single<SingleIssueApiModel>

}