package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class TaskCompletionStatusApiModel(
    @SerializedName("count") val count: Int,
    @SerializedName("completed_count") val completedCount: Int
)