package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class NameSpaceApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("path") val path: String,
    @SerializedName("kind") val kind: String,
    @SerializedName("full_path") val fullPath: String,
    @SerializedName("parent_id") val parentId: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("web_url") val webUrl: String
)