package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class TimeStats(
    @SerializedName("time_estimate") val timeEstimate: Int,
    @SerializedName("total_time_spent") val totalTimeEstimate: Int,
    @SerializedName("human_time_estimate") val humanTimeEstimate: Int,
    @SerializedName("human_total_time_spent") val humanTotalTimeEstimate: Int
)