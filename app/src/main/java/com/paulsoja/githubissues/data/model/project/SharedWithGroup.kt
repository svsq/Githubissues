package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class SharedWithGroup(
    @SerializedName("group_id") val groupId: Long,
    @SerializedName("group_name") val groupName: String?,
    @SerializedName("group_access_level") val groupAccessLevel: Long
)