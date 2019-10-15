package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class LinksApiModel(
    @SerializedName("self") val self: String,
    @SerializedName("issues") val issues: String,
    @SerializedName("merge_requests") val mergeRequests: String,
    @SerializedName("repo_branches") val repoBranches: String,
    @SerializedName("labels") val labels: String,
    @SerializedName("events") val events: String,
    @SerializedName("members") val members: String
)