package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class MilestoneApiModel(
    @SerializedName("project_id") val projectId: Int,
    @SerializedName("description") val description: String,
    @SerializedName("state") val state: String,
    @SerializedName("due_date") val dueDate: String?,
    @SerializedName("iid") val iid: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("title") val title: String,
    @SerializedName("id") val id: Int,
    @SerializedName("updated_at") val updatedAt: String
)