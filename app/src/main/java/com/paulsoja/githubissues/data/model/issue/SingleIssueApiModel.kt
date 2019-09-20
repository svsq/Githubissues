package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName
import com.paulsoja.githubissues.data.model.user.UserApiModel

data class SingleIssueApiModel(
    @SerializedName("url") val url: String,
    @SerializedName("repository_url") val repoUrl: String,
    @SerializedName("labels_url") val labelsUrl: String,
    @SerializedName("comments_url") val commentsUrl: String,
    @SerializedName("events_url") val eventsUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val node_id: String,
    @SerializedName("number") val issueNumber: Int,
    @SerializedName("title") val issueTitle: String,
    @SerializedName("user") val user: UserApiModel,
    @SerializedName("labels") val list: List<String> = listOf(),
    @SerializedName("state") val state: String,
    @SerializedName("locked") val isLocked: Boolean,
    @SerializedName("assignee") val assignee: UserApiModel?,
    @SerializedName("assignees") val assignees: List<UserApiModel> = listOf(),
    @SerializedName("milestone") val milestone: String?,
    @SerializedName("comments") val comments: String?,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String?,
    @SerializedName("closed_at") val closedAt: String?,
    @SerializedName("author_association") val authorAssociation: String,
    @SerializedName("body") val issueBody: String?,
    @SerializedName("closed_by") val closedBy: String?
)