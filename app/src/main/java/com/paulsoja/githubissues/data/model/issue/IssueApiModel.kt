package com.paulsoja.githubissues.data.model.issue

import com.google.gson.annotations.SerializedName

data class IssueApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("iid") val iid: Int,
    @SerializedName("project_id") val projectId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("state") val state: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("closed_at") val closedAt: String,
    @SerializedName("closed_by") val closedBy: String,
    @SerializedName("labels") val labels: List<String> = listOf(),
    @SerializedName("milestone") val milestone: String?,
    @SerializedName("assignees") val assignees: List<Author> = listOf(),
    @SerializedName("author") val author: Author,
    @SerializedName("assignee") val assignee: Author?,
    @SerializedName("user_notes_count") val userNotesCount: Int,
    @SerializedName("merge_requests_count") val mergeRequestsCount: Int,
    @SerializedName("upvotes") val upvotes: Int,
    @SerializedName("downvotes") val downvotes: Int,
    @SerializedName("due_date") val dueDate: String,
    @SerializedName("confidential") val confidential: Boolean,
    @SerializedName("discussion_locked") val discussionLocked: String?,
    @SerializedName("web_url") val webUrl: String,
    @SerializedName("time_stats") val timeStats: TimeStats,
    @SerializedName("task_completion_status") val taskCompletionStatus: TaskCompletionStatusApiModel,
    @SerializedName("has_tasks") val hasTasks: Boolean,
    @SerializedName("_links") val links: LinksApiModel,
    @SerializedName("weight") val weight: Int?
)