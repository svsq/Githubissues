package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class LabelsApiModel(
    @SerializedName("id") val id: Long,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("url") val url: String,
    @SerializedName("name") val name: String,
    @SerializedName("color") val color: String,
    @SerializedName("default") val default: Boolean
)