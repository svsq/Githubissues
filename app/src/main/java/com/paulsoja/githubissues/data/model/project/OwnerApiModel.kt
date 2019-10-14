package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class OwnerApiModel(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("created_at") val createdAt: String?
)