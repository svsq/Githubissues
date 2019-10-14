package com.paulsoja.githubissues.data.model.project

import com.google.gson.annotations.SerializedName

data class PermissionsApiModel(
    @SerializedName("project_access") val projectAccess: ProjectAccessApiModel?,
    @SerializedName("group_access") val groupAccess: GroupAccessApiModel?
)