package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("state") val state: String,
    @SerializedName("id") val id: Int,
    @SerializedName("web_url") val webUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("username") val username: String
)