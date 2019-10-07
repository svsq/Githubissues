package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class GroupAccess(
    @SerializedName("access_level") val accessLevel: Long,
    @SerializedName("notification_level") val notificationLevel: Long
)