package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class GroupAccessApiModel(
    @SerializedName("access_level") val accessLevel: Int,
    @SerializedName("notification_level") val notificationLevel: Int
)