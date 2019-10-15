package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class LinksApiModel(
    @SerializedName("self") val self: String,
    @SerializedName("notes") val notes: String,
    @SerializedName("award_emoji") val awardEmoji: String,
    @SerializedName("project") val project: String
)